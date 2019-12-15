package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Room {

    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";
    private  final String ANSI_YELLOW = "\u001B[33m";
    private  final String ANSI_RESET = "\u001B[0m";
    private  final String ANSI_BLUE = "\u001B[34m";
    private final char heroChar = 'Å';
    private int heroY = 13;
    private int heroX = 4;
    private final char goldChar = '$';
    private final int gold1Y = 10;
    private final int gold1X = 3;
    private final int gold2Y = 5;
    private final int gold2X = 12;
    private final int gold3Y = 1;
    private final int gold3X = 1;
    private final int gold4Y = 7;
    private final int gold4X = 7;
    private final char coffeeChar = 'K';
    private final int coffeeY = 12;
    private final int coffeeX = 13;
    private final char monsterChar = '¤';
    private final int monsterY = 3;
    private final int monsterX = 7;
    private Hero gameHero = new Hero();
    private ArrayList<Gold> roomGold = new ArrayList();

    char[][] mazeBoard = {
            {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
            {'W', ' ', 'W', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'W', ' ', 'W'},
            {'W', ' ', 'W', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'W', ' ', 'W'},
            {'W', ' ', 'W', 'W', 'W', ' ', ' ', ' ', ' ', ' ', 'W', 'W', 'W', ' ', 'W'},
            {'W', ' ', ' ', ' ', 'W', ' ', ' ', ' ', ' ', ' ', 'W', ' ', ' ', ' ', 'W'},
            {'W', ' ', ' ', ' ', 'W', ' ', ' ', ' ', ' ', ' ', 'W', ' ', ' ', ' ', 'W'},
            {'W', ' ', ' ', ' ', 'W', 'W', 'W', ' ', 'W', 'W', 'W', ' ', ' ', ' ', 'W'},
            {'W', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'W'},
            {'W', ' ', ' ', ' ', 'W', 'W', 'W', ' ', 'W', 'W', 'W', ' ', ' ', ' ', 'W'},
            {'W', ' ', ' ', ' ', 'W', ' ', ' ', ' ', ' ', ' ', 'W', ' ', ' ', ' ', 'W'},
            {'W', ' ', ' ', ' ', 'W', ' ', ' ', ' ', ' ', ' ', 'W', ' ', ' ', ' ', 'W'},
            {'W', ' ', 'W', 'W', 'W', ' ', ' ', ' ', ' ', ' ', 'W', 'W', 'W', ' ', 'W'},
            {'W', ' ', 'W', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'W', ' ', 'W'},
            {'W', ' ', 'W', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'W', ' ', 'W'},
            {'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W', 'W'},
    };

    public void play() {
        prepareGold();
        while (true) {
            boardSetup();
            boardFunction();
        }
    }

    private void prepareGold() {
        roomGold.add(new Gold(gold1Y, gold1X));
        roomGold.add(new Gold(gold2Y, gold2X));
        roomGold.add(new Gold(gold3Y, gold3X));
        roomGold.add(new Gold(gold4Y, gold4X));
    }

    private void boardSetup() {
        for (int r = 0; r < mazeBoard.length; r++) {
            for (int c = 0; c < mazeBoard[r].length; c++) {
                for (Gold remainGold : roomGold) {
                    mazeBoard[remainGold.goldY][remainGold.goldX] = goldChar;
                }
                mazeBoard[heroY][heroX] = heroChar;
                mazeBoard[coffeeY][coffeeX] = coffeeChar;
                mazeBoard[monsterY][monsterX] = monsterChar;
                System.out.print(ANSI_YELLOW + mazeBoard[r][c] + " " + ANSI_RESET);
            }
            System.out.println();
        }

        System.out.println(ANSI_GREEN + "Energy : " + gameHero.getScore() + ANSI_RESET);

    }

    private void boardFunction() {

        Scanner scan = new Scanner(System.in);
        char direction = scan.nextLine().charAt(0);
        try {
            int currentYPosition = heroY;
            int currentXPosition = heroX;

            switch (direction) {
                case 'w':
                    currentYPosition--;
                    break;
                case 's':
                    currentYPosition++;
                    break;
                case 'a':
                    currentXPosition--;
                    break;
                case 'd':
                    currentXPosition++;
                    break;
            }

            // Check new location
            switch (mazeBoard[currentYPosition][currentXPosition]) {
                case 'W':
                    return;
                case ' ':
                    break;
                case goldChar:
                    catchGold(currentYPosition, currentXPosition);
                    break;
                case coffeeChar:
                    drinkCoffee();
                    break;
                case monsterChar:
                    beatTheMonster();

            }

            moveHero(currentYPosition, currentXPosition);


        } catch (Exception e) {
        }

    }

    private void drinkCoffee() {

        gameHero.addItem(new Coffee());
        System.out.println(ANSI_RED + " Drinking coffee increases my energy! "+ ANSI_RESET);


    }

    private void catchGold(int currentPosY, int currentPosX) {

        for (Gold listGold : roomGold) {
            if (currentPosY == listGold.goldY && currentPosX == listGold.goldX) {
                gameHero.addItem(listGold);
                roomGold.remove(listGold);
                break;
            }
        }
    }

    private void beatTheMonster() {
        if (gameHero.getScore() < 800) {
            System.out.println(ANSI_RED +"        You CAN'T !!!");
            System.out.println("You need more energy to beat the monster!"+ ANSI_RESET);
              }
        else if(gameHero.getScore() > 800) {
            System.out.println(ANSI_BLUE +"     congratulation!  "+ ANSI_RESET);
            System.out.println(ANSI_BLUE +"        YOU WIN.."+ ANSI_RESET);
            System.out.println(ANSI_BLUE +"   YOU WIN!  YOU WIN!"+ ANSI_RESET);

        }

    }

    private void moveHero(int newY, int newX) {

        mazeBoard[heroY][heroX] = ' ';
        mazeBoard[newY][newX] = heroChar;
        heroY = newY;
        heroX = newX;
    }

}


