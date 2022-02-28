package dev.bruno.netwars.netwars.utils;

import dev.bruno.netwars.netwars.model.inventory.ItemType;
import lombok.*;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
public class GetItemPoint {
    AtomicInteger weapons = new AtomicInteger(0);
    AtomicInteger munition = new AtomicInteger(0);
    AtomicInteger water = new AtomicInteger(0);
    AtomicInteger food = new AtomicInteger(0);
    AtomicInteger allPoints = new AtomicInteger(0);

    public void updatePoints(ItemType key){
        switch (key){
            case WEAPON:
                weapons.getAndAdd(key.getValue());
                allPoints.getAndAdd(key.getValue());
                break;
            case MUNITION:
                munition.getAndAdd(key.getValue());
                allPoints.getAndAdd(key.getValue());
                break;
            case WATER:
                water.getAndAdd(key.getValue());
                allPoints.getAndAdd(key.getValue());
                break;
            case FOOD:
                food.getAndAdd(key.getValue());
                allPoints.getAndAdd(key.getValue());
                break;
        }
    }

}
