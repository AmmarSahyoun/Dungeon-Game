package com.company;
import java.util.Scanner;

public class DungeonGame {

    public void mainMenu() {

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
                    play();
                    break;
                case 2:
                    readInstructions();
                    break;
                case 3:
                    continueToRun = false;

            }
        }
    }
    private void readInstructions() {
        System.out.println("use the keys ('W' To move up)('A' To move to left)('S' To move down)('D' to move to right)");
        System.out.println("Move the hero around the maze to earn the gold and finish the monster");
        System.out.println("Good luck!");
    }
    public static void play(){
        int pastY=13;
        int pastX =3;
        int thisY;
        int thisX;

        char[][] maze = {

                {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
                {'W', ' ', ' ', ' ', ' ', 'W', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'W'},
                {'W', ' ', ' ', ' ', ' ', 'W', ' ', ' ', 'W', 'W', 'W', ' ', ' ', ' ', 'W'},
                {'W', ' ', ' ', ' ', ' ', 'W', ' ', ' ', ' ', ' ', 'W', ' ', ' ', ' ', 'W'},
                {'W', ' ', ' ', ' ', ' ', 'W', ' ', ' ', ' ', ' ', 'W', ' ', ' ', ' ', 'W'},
                {'W', ' ', ' ', ' ', ' ', 'W', 'W', 'W', 'W', 'W', 'W', ' ', ' ', ' ', 'W'},
                {'W', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'W'},
                {'W', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'W'},
                {'W', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'W'},
                {'W', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'W'},
                {'W', ' ', ' ', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', ' ', ' ', ' ', 'W'},
                {'W', ' ', ' ', ' ', ' ', ' ', 'W', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'W'},
                {'W', ' ', ' ', ' ', ' ', ' ', 'W', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'W'},
                {'W', ' ', ' ', ' ', ' ', ' ', 'W', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'W'},
                {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
        };
        maze[pastY][pastX] ='Ä';
        maze[11][3] ='$';
        maze[8][9] ='$';
        maze[3][3] ='$';
        maze[12][8] ='K';
        maze[5][9] ='¤';

        for (int col = 0; col < maze.length; col++) {
            for (int row = 0; row < maze[col].length; row++) {
                System.out.print(maze[col][row]);
            }
            System.out.println();
        }
        System.out.println("/up:W/ /down:S/ /left:A/ /right:D/");
        Scanner scn = new Scanner(System.in);
        String move = scn.next();

        boolean continueToTrue = true;
        while (continueToTrue){
            switch (move) {
                case "W":   //up
                    if (maze[pastY-1][pastX] != 'W') { // possible to move
                        thisY = pastY -1; thisX = pastX;  // update location
                        System.out.println(maze[pastY][pastX] =' ');   // clear last location
                        System.out.println(maze[thisY][thisX] ='Ä');    // the hero moved
                        break;
                    }

                    else{ break;}
                case "S":
                    pastX += 1;
                    break;

            }

        }}}

