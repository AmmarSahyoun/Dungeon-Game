package com.company;

public abstract class Item {
    private String name;
    private int energy;

    public Item(String name, int energy) {
        this.name = name;
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int newValue) {
        energy = newValue;
    }

}


