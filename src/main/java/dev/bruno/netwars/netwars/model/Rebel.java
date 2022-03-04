package dev.bruno.netwars.netwars.model;


import dev.bruno.netwars.netwars.model.inventory.Inventory;
import dev.bruno.netwars.netwars.utils.GetItemPoint;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@RequiredArgsConstructor
public class Rebel {

    @NonNull private String name;
    @NonNull private Integer age;
    @NonNull private String gender;
    @NonNull private Localization localization;
    private final Inventory inventory = new Inventory();
    private Map<String,Boolean> complaints = new HashMap();

    public Localization reportLastLocal(Localization newLocal){
        localization = newLocal;
        return localization;
    }

    public void reportTraitor(Rebel traitor){
        traitor.complaints.put(this.name, true);
    }

    public String negotiateItem(Inventory itemsReceived) throws Exception {
        boolean isTraitor = getComplaints().size() >= 3;
        if(isTraitor){
            throw new Exception("O Rebelde é um traidor");
        }

        GetItemPoint itemsPointNegotiator = new GetItemPoint();
        itemsReceived.items.forEach(item ->{
            item.forEach((key, value)->{
                itemsPointNegotiator.updatePoints(key);
            });
        });

        GetItemPoint itemsPointMy = new GetItemPoint();
        inventory.items.forEach(item ->{
            item.forEach((key, value)->{
                itemsPointMy.updatePoints(key);
            });
        });

        return "";
    }

}
