package dev.bruno.netwars.netwars.model.inventory;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Inventory {
    public List<Map<ItemType, List<String>>> items = new ArrayList<>();
}
