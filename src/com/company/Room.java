package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Room {

    private final char goldChar = '$';
    private final char coffeeChar = 'K';
    private final char monsterChar = '¤';
    private Hero gameHero = new Hero(13, 4);
    private ArrayList<MapItem> roomItems = new ArrayList();
    private ArrayList<Monster> roomMonster = new ArrayList();

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
        prepareItems();
        while (true) {
            boardSetup();
            boardFunction();
        }
    }

    private void prepareItems() {
        roomItems.add(new Gold(10, 3, 200));
        roomItems.add(new Gold(5, 12, 200));
        roomItems.add(new Gold(1, 1, 200));
        roomItems.add(new Gold(7, 7, 200));
        roomItems.add(new Coffee(12, 13, 700));
        roomMonster.add(new Monster(3, 7));
    }

    private void boardSetup() {
        for (int r = 0; r < mazeBoard.length; r++) {
            for (int c = 0; c < mazeBoard[r].length; c++) {
                for (MapItem mapItem : roomItems) {
                    mazeBoard[mapItem.getPositionY()][mapItem.getPositionX()] = mapItem.GetSymbol();
                }
                for (Monster monster : roomMonster) {
                    mazeBoard[monster.getPositionY()][monster.getPositionX()] = monster.GetSymbol();
                }
                mazeBoard[gameHero.getPositionY()][gameHero.getPositionX()] = gameHero.GetSymbol();

                System.out.print(GameConstant.ANSI_YELLOW + mazeBoard[r][c] + " " + GameConstant.ANSI_RESET);
            }
            System.out.println();
        }
        System.out.println(GameConstant.ANSI_BLUE + "w: up  s: down  a: left  d: right" + GameConstant.ANSI_RESET);
        System.out.println(GameConstant.ANSI_GREEN + "Energy : " + gameHero.getBackPackTotalValue() + GameConstant.ANSI_RESET);

    }

    private void boardFunction() {

        Scanner scan = new Scanner(System.in);
        char direction = scan.nextLine().charAt(0);
        int currentYPosition = gameHero.getPositionY();
        int currentXPosition = gameHero.getPositionX();
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

        switch (mazeBoard[currentYPosition][currentXPosition]) {
            case 'W':
                return;
            case ' ':
                break;
            case goldChar:
            case coffeeChar:
                catchItem(currentYPosition, currentXPosition);
                break;
            case monsterChar:
                beatTheMonster();
        }

        mazeBoard[gameHero.getPositionY()][gameHero.getPositionX()] = ' ';
        gameHero.moveHero(currentYPosition, currentXPosition);

    }

    private void catchItem(int currentPosY, int currentPosX) {
        for (MapItem mapItem : roomItems) {
            if (currentPosY == mapItem.getPositionY() && currentPosX == mapItem.getPositionX()) {
                gameHero.addItem(mapItem);
                roomItems.remove(mapItem);
                break;
            }
        }
    }

    private void beatTheMonster() {
        if (gameHero.IsHeroDrunkCoffee()) {
            System.out.println(GameConstant.ANSI_BLUE + "     congratulation!  " + GameConstant.ANSI_RESET);
            System.out.println(GameConstant.ANSI_BLUE + "        YOU WIN.." + GameConstant.ANSI_RESET);
            System.out.println(GameConstant.ANSI_BLUE + "   YOU WIN!  YOU WIN!" + GameConstant.ANSI_RESET);

            gameHero.addItem(new Gold(1, 1, 2000));
            roomMonster.clear();
        } else {
            System.out.println(GameConstant.ANSI_RED + "        You CAN'T !!!");
            System.out.println("You need more energy to beat the monster!" + GameConstant.ANSI_RESET);
        }
    }
}



