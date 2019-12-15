package com.company;

import java.util.ArrayList;

public class BackPack extends Item {

    private ArrayList<Item> items = new ArrayList<>();

    public BackPack() {
        super("BackPack", 0);
    }

    public void addItem(Item item) {

        items.add(item);
        setEnergy(getEnergy() + item.getEnergy());
    }

}




