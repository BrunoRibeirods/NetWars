package dev.bruno.netwars.netwars.model;

import dev.bruno.netwars.netwars.model.inventory.Inventory;
import dev.bruno.netwars.netwars.utils.GetItemPoint;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Setter
@Getter
public class Rebellion {

    public static List<Rebel> rebels = new ArrayList<>();

    public static double getTraitorsPercent(){
        double totalOfTraitors = rebels.stream().filter(rebel -> rebel.getComplaints().size() >= 3).count();
        return (totalOfTraitors / rebels.size()) * 100;
    }

    public static String getTraitorsPoints(){
        GetItemPoint traitorsPoints = new GetItemPoint();
        rebels.stream().forEach(rebel -> {
            if(rebel.getComplaints().size() >= 3){
                rebel.getInventory().items.forEach(traitorsPoints::updatePoints);
            }
        });
        return "Pontos perdidos devido traidores: " + traitorsPoints.getAllPoints().get();
    }

    public static double getRebelsPercent(){
        return 100 - getTraitorsPercent();
    }

    public static String getItemTypesQuantity(){
        GetItemPoint itemsPoint = new GetItemPoint();

        rebels.forEach(rebel -> rebel.getInventory().items.forEach(itemsPoint::updatePoints));

        int weaponsAverage = (itemsPoint.getWeapons() / rebels.size());
        int munitionAverage = (itemsPoint.getMunition() / rebels.size());
        int waterAverage = (itemsPoint.getWater() / rebels.size());
        int foodAverage = (itemsPoint.getFood() / rebels.size());

        return "MÉDIA: " + '\n' +
                weaponsAverage +" Armas para cada rebelde"  + '\n' +
                munitionAverage + " Muniçoes para cada rebelde" + '\n' +
                waterAverage + " Bebidas para cada rebelde" + '\n' +
                foodAverage + " Alimentos para cada rebelde " + '\n';
    }
    
    public static String negotiateItems(String rebelNameA, String rebelNameB) throws Exception {
        Rebel rebelA = verifyIfContainsRebel(rebelNameA);
        Rebel rebelB = verifyIfContainsRebel(rebelNameB);

        if(rebelA == null || rebelB == null){
            throw new Exception("Nome nao encontrado");
        }

        boolean isATraitor = rebelA.getComplaints().size() >= 3;
        boolean isBTraitor = rebelB.getComplaints().size() >= 3;

        if(isATraitor || isBTraitor){
            throw new Exception("Um dos Rebeldes é traidor");
        }

        GetItemPoint rebelAPoint = new GetItemPoint();
        rebelA.getInventory().getItems().forEach(rebelAPoint::updatePoints);

        GetItemPoint rebelBPoint = new GetItemPoint();
        rebelB.getInventory().getItems().forEach(rebelBPoint::updatePoints);


        if(!rebelAPoint.getAllPoints().equals(rebelBPoint.getAllPoints())){
            throw new Exception("Pontos não coincidem");
        }

        Inventory rebelAInventory = rebelA.getInventory();
        Inventory rebelBInventory = rebelB.getInventory();

        rebelA.setInventory(rebelBInventory);
        rebelB.setInventory(rebelAInventory);
        return "Negociação concluída com sucesso!";
    }

    public static Rebel verifyIfContainsRebel(String name){
        AtomicReference<Rebel> rebel = new AtomicReference<>(null);
        rebels.forEach(rebelLoop -> {
            if(rebelLoop.getName().equals(name)){
                rebel.set(rebelLoop);
            }
        });
        return rebel.get();
    }

}
