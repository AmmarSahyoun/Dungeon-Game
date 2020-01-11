package com.company;

import java.util.ArrayList;

public class BackPack extends Item {

    private ArrayList<MapItem> items;

    public BackPack() {
        super("BackPack");
        this.items = new ArrayList<>();
    }

    public void addItem(MapItem item) {
        items.add(item);
    }

    public int getTotalValue() {
        int totalValue = 0;
        for (MapItem mapItem : this.items) {
            totalValue += mapItem.getValue();
        }
        return totalValue;
    }

    public boolean IsCoffeeExists() {
        boolean coffeeStatus = false;

        for (MapItem mapItem : items) {
            if (mapItem.getName().toLowerCase().equals("coffee")) {
                coffeeStatus = true;
                break;
            }
        }

        return coffeeStatus;
    }

}




