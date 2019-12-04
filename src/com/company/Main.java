package com.company;

public class Main {

    public static void main(String[] args) {
        Supporter gold = new Supporter(150, "Gold");
        gold.showDescription();

        Supporter caffe = new Supporter(500, "the power of the Caffe");
        caffe.showDescription();

        Supporter monster = new Supporter(750,"the monster");
        monster.showDescription();

        DungeonGame dungeonGame = new DungeonGame();
        dungeonGame.mainMenu();

    }
}
