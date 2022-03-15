package dev.bruno.netwars.netwars.controller;


import dev.bruno.netwars.netwars.dto.RequestLocalization;
import dev.bruno.netwars.netwars.model.Localization;
import dev.bruno.netwars.netwars.service.RebelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rebel")
public class RebelController {

    @Autowired
    private RebelService rebelService;

    @PatchMapping("/report/location")
    public ResponseEntity<String> reportLocation(@RequestParam("rebelName") String rebelName, @RequestBody RequestLocalization reqLocalization) throws Exception{
        
        Localization localization = rebelService.mapToLocalization(reqLocalization);

        String rebelReportLocationResult = rebelService.reportLastLocal(rebelName, localization);

        return ResponseEntity.ok(rebelReportLocationResult);
    }

    @PatchMapping("/report/traitor")
    public ResponseEntity<String> reportTraitor(@RequestParam("rebelName") String rebel, @RequestParam("traitorName") String traitor) throws Exception{

        String rebelReportTraitorResult = rebelService.reportTraitor(rebel, traitor);

        return ResponseEntity.ok(rebelReportTraitorResult);
    }

}
