package com.company;

public class Gold extends MapItem {

    public Gold(int itemY, int itemX, int value) {
        super("Gold", itemY, itemX, value);
    }

    @Override
    public char GetSymbol() {
        return '$';
    }

}
