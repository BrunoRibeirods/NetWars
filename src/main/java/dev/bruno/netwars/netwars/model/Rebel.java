package dev.bruno.netwars.netwars.model;


import dev.bruno.netwars.netwars.model.inventory.Inventory;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@RequiredArgsConstructor
public class Rebel {

    @NonNull private String name;
    @NonNull private Integer age;
    @NonNull private String gender;
    @NonNull private Localization localization;
    @NonNull private Inventory inventory;
    private Map<String,Boolean> complaints = new HashMap();

    public String reportLastLocal(Localization newLocal){
        localization = newLocal;
        return localization.toString();
    }

    public String reportTraitor(Rebel traitor){
        traitor.complaints.put(this.name, true);
        return "Traidor reportado";
    }
}
