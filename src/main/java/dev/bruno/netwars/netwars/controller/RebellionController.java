package dev.bruno.netwars.netwars.controller;

import dev.bruno.netwars.netwars.dto.RequestRebel;
import dev.bruno.netwars.netwars.dto.ResponseRebel;
import dev.bruno.netwars.netwars.model.Rebel;
import dev.bruno.netwars.netwars.service.RebellionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rebellion")
public class RebellionController {

    @Autowired
    private RebellionService rebellionService;

    @GetMapping
    public List<ResponseRebel> getRebels(){
        return ResponseRebel.toResponse(rebellionService.searchForAllRebels());
    }

    @PostMapping
    public ResponseEntity<ResponseRebel> registerRebel(@RequestBody RequestRebel requestRebel){
        Rebel rebel = rebellionService.registerRebel(requestRebel);
        return ResponseEntity.ok(new ResponseRebel(rebel));
    }

}