package dev.bruno.netwars.netwars.controller;


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
    public ResponseEntity<String> reportLocation(@RequestParam("rebelName") String rebelName, @RequestBody Localization localization) throws Exception{

        return ResponseEntity.ok("");
    }

    @PatchMapping("/report/traitor")
    public ResponseEntity<String> reportTraitor(@RequestParam("rebelNameA") String rebelNameA, @RequestParam("rebelNameB") String rebelNameB) throws Exception{

        return ResponseEntity.ok("");
    }

}
