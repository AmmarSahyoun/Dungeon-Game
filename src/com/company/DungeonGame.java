package com.company;

import java.util.Scanner;

public class DungeonGame {

    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_YELLOW = "\u001B[33m";
    private final String ANSI_BLUE = "\u001B[34m";
    private final String ANSI_RED = "\u001B[31m";

    public void runTheGame() {
        System.out.println();
        System.out.println(ANSI_RED + "     ..: Welcome to Doungeon Maze :.." + ANSI_RESET);
        System.out.println();
        boolean continueToRun = true;
        while (continueToRun) {

            System.out.println(ANSI_BLUE + "1. Play a game" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "2. Read the instructions" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "3. Exit" + ANSI_RESET);

            Scanner scn = new Scanner(System.in);
            int choice = Integer.parseInt(scn.nextLine());
            switch (choice) {
                case 1:
                    Room room = new Room();
                    room.play();
                    break;
                case 2:
                    readInstructions();
                    break;
                case 3:
                    System.out.println(ANSI_YELLOW + "Good Bye!  " + ANSI_RESET);
                    continueToRun = false;

            }

        }
    }

    public static void readInstructions() {
        System.out.println("use the keys ('W' To move up)('A' To move to left)('S' To move down)('D' to move to right)");
        System.out.println("Move the hero around the maze to earn the gold and finish the monster");
        System.out.println("REMEMBER to drink coffee before you beat the monster!");
        System.out.println("Good luck!");
        System.out.println("  \n");

    }


}

