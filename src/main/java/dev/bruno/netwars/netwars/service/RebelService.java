package dev.bruno.netwars.netwars.service;

import dev.bruno.netwars.netwars.model.Localization;
import dev.bruno.netwars.netwars.model.Rebel;
import org.springframework.stereotype.Service;


@Service
public class RebelService {

    public Localization reportLastLocal(Rebel rebel, Localization localization){
        return rebel.reportLastLocal(localization);
    }

    public void reportTraitor(Rebel rebel, Rebel traitor){
        rebel.reportTraitor(traitor);
    }

}
