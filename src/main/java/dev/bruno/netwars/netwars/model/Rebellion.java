package dev.bruno.netwars.netwars.model;

import dev.bruno.netwars.netwars.model.Rebel;
import dev.bruno.netwars.netwars.utils.GetItemPoint;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Setter
@Getter
public class Rebellion {

    public static List<Rebel> rebels = new ArrayList<>();

    public static int getTraitorsPercent(){
        int totalOfTraitors = (int) rebels.stream().filter(rebel -> rebel.getComplaints().size() >= 3).count();
        return (totalOfTraitors / rebels.size()) * 100;
    }

    public static int getRebelsPercent(){
        return 100 - getTraitorsPercent();
    }

    public static String getItemTypesQuantity(){
        GetItemPoint itemsPoint = new GetItemPoint();

        rebels.forEach(rebel -> rebel.getInventory().items.forEach(itemsPoint::updatePoints));

        int weaponsAverage = (itemsPoint.getWeapons() / rebels.size()) * 100;
        int munitionAverage = (itemsPoint.getMunition() / rebels.size()) * 100;
        int waterAverage = (itemsPoint.getWater() / rebels.size()) * 100;
        int foodAverage = (itemsPoint.getFood() / rebels.size()) * 100;

        return "MÉDIA: " + '\n' +
                weaponsAverage +" Armas para cada rebelde"  + '\n' +
                munitionAverage + " Muniçoes para cada rebelde" + '\n' +
                waterAverage + " Bebidas para cada rebelde" + '\n' +
                foodAverage + " Alimentos para cada rebelde: " + '\n';
    }
    
    public static String negotiateItems(Rebel rebelA, Rebel rebelB) throws Exception {
        boolean isATraitor = rebelA.getComplaints().size() >= 3;
        boolean isBTraitor = rebelB.getComplaints().size() >= 3;

        if(isATraitor || isBTraitor){
            throw new Exception("Um dos Rebeldes é traidor");
        }

        return "Negociação concluída com sucesso!";
    }

}
