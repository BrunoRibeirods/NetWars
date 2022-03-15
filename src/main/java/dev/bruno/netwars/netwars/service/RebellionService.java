package dev.bruno.netwars.netwars.service;

import dev.bruno.netwars.netwars.dto.RequestRebel;
import dev.bruno.netwars.netwars.model.Localization;
import dev.bruno.netwars.netwars.model.Rebel;
import dev.bruno.netwars.netwars.model.Rebellion;
import dev.bruno.netwars.netwars.model.inventory.Inventory;
import dev.bruno.netwars.netwars.model.inventory.Item;
import dev.bruno.netwars.netwars.model.inventory.ItemType;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RebellionService {

    public Rebel registerRebel(RequestRebel requestRebel){
        Localization localization = new Localization("Buenos aires", "-34.6157437", "-58.5733832");

        Random rn = new Random();
        int range = 5 - 0 + 1;

        Inventory inventory = new Inventory();
        List<Item> items = new ArrayList<>();
        items.add(new Item(ItemType.WEAPON, rn.nextInt(range) + 0));
        items.add(new Item(ItemType.MUNITION, rn.nextInt(range) + 0));
        items.add(new Item(ItemType.WATER, rn.nextInt(range) + 0));
        items.add(new Item(ItemType.FOOD, rn.nextInt(range) + 0));
        inventory.setItems(items);

        Rebel rebel = new Rebel(
                requestRebel.getName(),
                requestRebel.getAge(),
                requestRebel.getGender(),
                localization,
                inventory
        );

        Rebellion.rebels.add(rebel);
        return rebel;
    }

    public String getPercentRebels(){
        return Rebellion.getRebelsPercent() + "%";
    }

    public String getPercentTraitors(){
        return Rebellion.getTraitorsPercent() + "%";
    }

    public String getTraitorsPoint(){
        return Rebellion.getTraitorsPoints();
    }

    public String getItemTypeQuantity(){
        return Rebellion.getItemTypesQuantity();
    }

    public List<Rebel> searchForAllRebels(){
        return Rebellion.rebels;
    }

    public String patchNegotiationRebels(String rebelA, String rebelB) throws Exception{

        return Rebellion.negotiateItems(rebelA, rebelB);
    }

}
