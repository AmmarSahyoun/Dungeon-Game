package com.company;

public class Hero extends Creature {
    private BackPack heroBackPack = new BackPack();

    public Hero(int Y, int X) {
        super("Hero", 100, Y, X);
    }

    public void addItem(MapItem gameItem) {
        heroBackPack.addItem(gameItem);
    }

    public int getBackPackTotalValue() {
        return heroBackPack.getTotalValue();
    }

    public void moveHero(int Y, int X) {
        setPositionY(Y);
        setPositionX(X);
    }

    public boolean IsHeroDrunkCoffee() {
        return heroBackPack.IsCoffeeExists();
    }

    @Override
    public char GetSymbol() {
        return 'Å';
    }
}

