package com.company;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Supporter gold = new Supporter(150, "Gold");
   //     gold.showDescription();

        Supporter caffe = new Supporter(500, "Coffee");
  //      caffe.showDescription();

        Supporter monster = new Supporter(750,"the monster");
  //      monster.showDescription();

   //     DungeonGame dungeonGame = new DungeonGame();
     //   dungeonGame.mainMenu();


        System.out.println("  .: Welcome to Doungeon maze :.");
        System.out.println();
        boolean continueToRun = true;
        while (continueToRun) {

            System.out.println("1. Play a game");
            System.out.println("2. Read the instructions");
            System.out.println("3. Exit");

            Scanner scn = new Scanner(System.in);
            int choice = Integer.parseInt(scn.nextLine());
              switch (choice) {
                case 1:
                    DungeonGame dungeonGame = new DungeonGame();
                    dungeonGame.mainMenu();
                    break;
                case 2:
                    readInstructions();
                    break;
                case 3:
                    continueToRun = false;

            }
        }
    }
    public static void readInstructions() {
        System.out.println("use the keys ('W' To move up)('A' To move to left)('S' To move down)('D' to move to right)");
        System.out.println("Move the hero around the maze to earn the gold and finish the monster");
        System.out.println("Good luck!");
        System.out.println("  \n");

    }


}


