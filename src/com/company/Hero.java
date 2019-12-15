package com.company;

public class Hero extends Creature {

    private BackPack heroBackPack = new BackPack();

    public Hero() {
        super("Hero", 100);
    }

   public void addItem(Item gameItem){
       heroBackPack.addItem(gameItem);
   }

    public int getScore(){
        return heroBackPack.getEnergy();
    }

}

