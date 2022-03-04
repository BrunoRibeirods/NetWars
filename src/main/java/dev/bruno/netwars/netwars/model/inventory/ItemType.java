package dev.bruno.netwars.netwars.model.inventory;


public enum ItemType {
    WEAPON(4),
    MUNITION(3),
    WATER(2),
    FOOD(1),
    ;

    private final int value;

    ItemType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
