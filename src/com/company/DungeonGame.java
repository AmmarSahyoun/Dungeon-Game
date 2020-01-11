package com.company;

import java.util.Scanner;

public class DungeonGame {

    public void runTheGame() {
        int choice = 0;
        System.out.println();
        System.out.println(GameConstant.ANSI_RED + "     ..: Welcome to Doungeon Maze :.." + GameConstant.ANSI_RESET);
        System.out.println();
        boolean continueToRun = true;
        while (continueToRun) {

            try {
                System.out.println(GameConstant.ANSI_BLUE + "1. Play a game" + GameConstant.ANSI_RESET);
                System.out.println(GameConstant.ANSI_BLUE + "2. Read the instructions" + GameConstant.ANSI_RESET);
                System.out.println(GameConstant.ANSI_BLUE + "3. Exit" + GameConstant.ANSI_RESET);

                Scanner scn = new Scanner(System.in);
                choice = Integer.parseInt(scn.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println("Wrong choice! ");
            } catch (Exception e) {
                System.out.println("Failed to get input");
            }
            if (choice == 1) {
                Room room = new Room();
                room.play();
            }
            if (choice == 2) {
                readInstructions();
            }
            if (choice > 3) {
                System.out.println("Choose a valid number [1-3] ");
            }
            if (choice == 3) {
                System.out.println(GameConstant.ANSI_YELLOW + "Good Bye!  " + GameConstant.ANSI_RESET);
                continueToRun = false;

            }
        }
    }

    public void readInstructions() {
        System.out.println("use the keys ('W' To move up) - ('A' To move to left)");
        System.out.println("('S' To move down) - ('D' to move to right)");
        System.out.println("Navigate around the maze to earn the gold and beat the monster");
        System.out.println("REMEMBER! to beat the monster, you should have enough energy!");
        System.out.println("Good luck! ...");
        System.out.println("  \n");

    }
}

