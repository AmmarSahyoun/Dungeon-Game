package com.company;

public abstract class MapItem extends Item {
    private int positionY;
    private int positionX;
    private int value;

    public MapItem (String Name, int Y, int X, int Value)
    {
        super(Name);
        this.positionY = Y;
        this.positionX = X;
        this.value = Value;
    }

    public int getValue(){
        return this.value;
    }

    public abstract char GetSymbol();

    public int getPositionY(){
        return this.positionY;
    }

    public int getPositionX(){
        return this.positionX;
    }
}
