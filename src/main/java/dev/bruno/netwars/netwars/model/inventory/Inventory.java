package dev.bruno.netwars.netwars.model.inventory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Inventory {
    public List<Item> items = new ArrayList<>();

    public Inventory(){
        items.add(new Item(ItemType.WEAPON, 0));
        items.add(new Item(ItemType.MUNITION, 0));
        items.add(new Item(ItemType.WATER, 0));
        items.add(new Item(ItemType.FOOD, 0));
    }
}
