package dev.bruno.netwars.netwars.utils;

import dev.bruno.netwars.netwars.model.inventory.Item;
import dev.bruno.netwars.netwars.model.inventory.ItemType;
import lombok.*;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class GetItemPoint {
    int weapons = 0;
    int munition = 0;
    int water = 0;
    int food = 0;
    AtomicInteger allPoints = new AtomicInteger(0);

    public void updatePoints(Item item){
        switch (item.itemType){
            case WEAPON:
                weapons = item.quantity;
                break;
            case MUNITION:
                munition = item.quantity;
                break;
            case WATER:
                water = item.quantity;
                break;
            case FOOD:
                food = item.quantity;
                break;
        }
        allPoints.getAndAdd((item.itemType.getValue() * item.quantity));
    }

}
