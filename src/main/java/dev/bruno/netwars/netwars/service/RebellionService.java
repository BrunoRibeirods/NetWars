package dev.bruno.netwars.netwars.service;

import dev.bruno.netwars.netwars.dto.RequestRebel;
import dev.bruno.netwars.netwars.model.Localization;
import dev.bruno.netwars.netwars.model.Rebel;
import dev.bruno.netwars.netwars.model.Rebellion;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Rebel> searchForAllRebels(){
        return Rebellion.rebels;
    }

}
