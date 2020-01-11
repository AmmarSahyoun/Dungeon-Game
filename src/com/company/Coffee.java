package com.company;

public class Coffee extends MapItem {

    public Coffee(int itemY, int itemX, int value) {
        super("Coffee", itemY, itemX, value);
    }

    @Override
    public char GetSymbol() {
        return 'K';
    }
}
