package com.company;

public class Monster extends Creature {

    public Monster(int Y, int X) {
        super("Monster", 500, Y, X);
    }

    @Override
    public char GetSymbol() {
        return '¤';
    }
}
