package dev.bruno.netwars.netwars.dto;

import dev.bruno.netwars.netwars.model.Localization;
import dev.bruno.netwars.netwars.model.Rebel;
import dev.bruno.netwars.netwars.model.inventory.Inventory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class ResponseRebel {
    private String name;
    private Integer age;
    private String gender;
    private Localization localization;
    private Inventory inventory;
    private Map<String,Boolean> complaints;

    public ResponseRebel(Rebel rebel){
        this.name = rebel.getName();
        this.age = rebel.getAge();
        this.gender = rebel.getGender();
        this.localization = rebel.getLocalization();
        this.inventory = rebel.getInventory();
        this.complaints = rebel.getComplaints();
    }

    public static List<ResponseRebel> toResponse(List<Rebel> rebels){
        return  rebels.stream().map(ResponseRebel::new).collect(Collectors.toList());
    }

}
