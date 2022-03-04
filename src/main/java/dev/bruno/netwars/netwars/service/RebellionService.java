package dev.bruno.netwars.netwars.service;

import dev.bruno.netwars.netwars.dto.RequestRebel;
import dev.bruno.netwars.netwars.model.Localization;
import dev.bruno.netwars.netwars.model.Rebel;
import dev.bruno.netwars.netwars.model.Rebellion;
import dev.bruno.netwars.netwars.model.inventory.ItemType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RebellionService {

    public Rebel registerRebel(RequestRebel requestRebel){
        Localization localization = new Localization("Buenos aires", "-34.6157437", "-58.5733832");

        Rebel rebel = new Rebel(
                requestRebel.getName(),
                requestRebel.getAge(),
                requestRebel.getGender(),
                localization
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

    public String getItemTypeQuantity(){
        return Rebellion.getItemTypesQuantity();
    }

    public List<Rebel> searchForAllRebels(){
        return Rebellion.rebels;
    }

}
