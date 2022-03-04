package dev.bruno.netwars.netwars.model;

import dev.bruno.netwars.netwars.model.Rebel;
import dev.bruno.netwars.netwars.utils.GetItemPoint;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Rebellion {
    public static List<Rebel> rebels = new ArrayList<>();

    public int getTraitorPercent(){
        int totalOfTraitors = (int) rebels.stream().filter(rebel -> rebel.getComplaints().size() >= 3).count();
        return (totalOfTraitors / rebels.size()) * 100;
    }

    public int getRebelsPercent(){
        return 100 - getTraitorPercent();
    }

    public String getItemTypesQuantity(){
        GetItemPoint itemsPoint = new GetItemPoint();

        rebels.forEach(rebel -> rebel.getInventory().items.forEach(item -> item.forEach((key, value)-> itemsPoint.updatePoints(key))));

        int weaponsAverage = (itemsPoint.getWeapons().get() / rebels.size()) * 100;
        int munitionAverage = (itemsPoint.getMunition().get() / rebels.size()) * 100;
        int waterAverage = (itemsPoint.getWater().get() / rebels.size()) * 100;
        int foodAverage = (itemsPoint.getFood().get() / rebels.size()) * 100;

        return "MÉDIA: " + '\n' +
                weaponsAverage +" Armas para cada rebelde"  + '\n' +
                munitionAverage + " Muniçoes para cada rebelde" + '\n' +
                waterAverage + "aguas para cada rebelde" + '\n' +
                foodAverage + "comidas para cada rebelde: " + '\n';
    }

}
