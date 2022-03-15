package dev.bruno.netwars.netwars.service;

import dev.bruno.netwars.netwars.dto.RequestLocalization;
import dev.bruno.netwars.netwars.model.Localization;
import dev.bruno.netwars.netwars.model.Rebel;
import dev.bruno.netwars.netwars.model.Rebellion;
import org.springframework.stereotype.Service;


@Service
public class RebelService {

    public Localization mapToLocalization(RequestLocalization requestLocalization){
        return new Localization(
                requestLocalization.getName(),
                requestLocalization.getLatitude(),
                requestLocalization.getLongitude()
        );
    }

    public String reportLastLocal(String rebelName, Localization localization) throws Exception {
        Rebel rebel = Rebellion.verifyIfContainsRebel(rebelName);

        if(rebel == null){
            throw new Exception("Nome nao encontrado");
        }

        return rebel.reportLastLocal(localization);
    }

    public String reportTraitor(String rebelName, String traitorName) throws Exception {
        Rebel rebel = Rebellion.verifyIfContainsRebel(rebelName);
        Rebel traitor = Rebellion.verifyIfContainsRebel(traitorName);

        if(rebel == null || traitor == null){
            throw new Exception("Nome nao encontrado");
        }

        return rebel.reportTraitor(traitor);
    }

}
