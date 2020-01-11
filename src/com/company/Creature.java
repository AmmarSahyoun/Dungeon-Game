package com.company;

public abstract class Creature {

    private String name;
    private int power;
    private int positionY;
    private int positionX;

    public Creature(String name, int power, int Y, int X) {
        this.name = name;
        this.power = power;
        this.positionY = Y;
        this.positionX = X;
    }

    public int getPositionY() {
        return this.positionY;
    }

    public int getPositionX() {
        return this.positionX;
    }

    protected void setPositionY(int Y) {
        this.positionY = Y;
    }

    protected void setPositionX(int X) {
        this.positionX = X;
    }

    public char GetSymbol() {
        return ' ';
    }

}
