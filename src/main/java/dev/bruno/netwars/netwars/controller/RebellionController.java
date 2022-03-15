package dev.bruno.netwars.netwars.controller;

import dev.bruno.netwars.netwars.dto.RequestRebel;
import dev.bruno.netwars.netwars.dto.ResponseRebel;
import dev.bruno.netwars.netwars.model.Rebel;
import dev.bruno.netwars.netwars.service.RebellionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/rebellion")
public class RebellionController {

    @Autowired
    private RebellionService rebellionService;

    @RequestMapping("/traitors/percent")
    @GetMapping
    public String getTraitorsPercent(){
        return rebellionService.getPercentTraitors();
    }

    @RequestMapping("/rebels/percent")
    @GetMapping
    public String getRebelsPercent(){
        return rebellionService.getPercentRebels();
    }

    @RequestMapping("/rebels/items")
    @GetMapping
    public String getItemTypeQuantity(){
        return rebellionService.getItemTypeQuantity();
    }

    @RequestMapping("/traitors/points")
    @GetMapping
    public String getTraitorsPoints(){
        return rebellionService.getTraitorsPoint();
    }

    @PostMapping
    public ResponseEntity<ResponseRebel> registerRebel(@RequestBody RequestRebel requestRebel){
        Rebel rebel = rebellionService.registerRebel(requestRebel);
        return ResponseEntity.ok(new ResponseRebel(rebel));
    }

    @GetMapping
    public List<ResponseRebel> getRebels(){
        return ResponseRebel.toResponse(rebellionService.searchForAllRebels());
    }

    @PatchMapping("/negotiate")
    public ResponseEntity<String> negotiateItems(@RequestParam("rebelNameA") String rebelNameA, @RequestParam("rebelNameB") String rebelNameB) throws Exception{

        String negotiateItemRebels = rebellionService.patchNegotiationRebels(rebelNameA, rebelNameB);

        return ResponseEntity.ok(negotiateItemRebels);
    }
}
