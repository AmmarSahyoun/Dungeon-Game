package com.company;
import java.util.Scanner;

public class DungeonGame {

    static char hero = 'Å';
    static int heroY = 13;
    static int heroX = 3;
    static char gold1 = '$';
    static char gold2 = '$';
    static char gold3 = '$';
    static char gold4 = '$';
    static int gold1Y = 11;
    static int gold1X = 3;
    static int gold2Y = 2;
    static int gold2X = 11;
    static int gold3Y = 3;
    static int gold3X = 3;
    static int gold4Y = 8;
    static int gold4X = 4;
    static char caffe = 'K';
    static int caffeY = 8;
    static int cafeeX = 12;
    static char monster = '¤';
    static int monsterY = 3;
    static int monsterX = 7;
    static final int mazeY = 15;
    static final int mazeX = 15;
    char[][] mazeBoard = {
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
    public int score = 0;

    public void mainMenu() {
        while (true) {
            boardSetup();
            boardFunction();
        }
    }

    public void boardSetup() {
        for (int r = 0; r < mazeBoard.length; r++) {

            for (int c = 0; c < mazeBoard[r].length; c++) {

                mazeBoard[gold1Y][gold1X] = gold1;
                mazeBoard[gold2Y][gold2X] = gold2;
                mazeBoard[gold3Y][gold3X] = gold3;
                mazeBoard[gold4Y][gold4X] = gold4;
                mazeBoard[heroY][heroX] = hero;
                mazeBoard[caffeY][cafeeX] = caffe;
                mazeBoard[monsterY][monsterX] = monster;
                System.out.print(mazeBoard[r][c] + " ");
            }


            System.out.println();
        }

        System.out.println("Score is:" + score);
    }

    public void boardFunction() {
        Scanner scan = new Scanner(System.in);
        char direction = scan.nextLine().charAt(0);

        switch (direction) {
            case 'w':
                try {
                    if (mazeBoard[heroY - 1][heroX] == 'W') {
                    } else if (mazeBoard[heroY - 1][heroX] == ' ') {
                        mazeBoard[heroY][heroX] = ' ';
                        heroY = --heroY;
                    } else if (mazeBoard[heroY - 1][heroX] == gold1) {
                        catchGold1();
                    } else if (mazeBoard[heroY - 1][heroX] == gold4) {
                        catchGold4();
                    } else if (mazeBoard[heroY - 1][heroX] == gold3) {
                        catchGold3();
                    } else if (mazeBoard[heroY - 1][heroX] == gold2) {
                        catchGold2();
                    } else if (mazeBoard[heroY - 1][heroX] == caffe) {
                        drinkCoffee();
                    }
                } catch (Exception e) {
                }

                break;

            case 's':
                try {
                    if (heroY == 14) {
                    } else if (mazeBoard[heroY + 1][heroX] == ' ') {
                        mazeBoard[heroY][heroX] = ' ';
                        heroY = ++heroY;
                    } else if (mazeBoard[heroY + 1][heroX] == gold1) {
                        catchGold1();
                    } else if (mazeBoard[heroY + 1][heroX] == gold4) {
                        catchGold4();
                    } else if (mazeBoard[heroY + 1][heroX] == gold3) {
                        catchGold3();
                    } else if (mazeBoard[heroY + 1][heroX] == gold2) {
                        catchGold2();
                    } else if (mazeBoard[heroY + 1][heroX] == caffe) {
                        drinkCoffee();
                    }
                } catch (Exception e) {
                }
                break;

            case 'a':
                try {
                    if (mazeBoard[heroY][heroX - 1] == 'W') {
                    } else if (mazeBoard[heroY][heroX - 1] == ' ') {
                        mazeBoard[heroY][heroX] = ' ';
                        heroX = --heroX;
                    } else if (mazeBoard[heroY][heroX - 1] == gold1) {
                        catchGold1();
                    } else if (mazeBoard[heroY][heroX - 1] == gold4) {
                        catchGold4();
                    } else if (mazeBoard[heroY][heroX - 1] == gold3) {
                        catchGold3();
                    } else if (mazeBoard[heroY][heroX - 1] == gold2) {
                        catchGold2();
                    } else if (mazeBoard[heroY][heroX - 1] == caffe) {
                        drinkCoffee();
                    }
                } catch (Exception e) {
                }
                break;

            case 'd':
                try {
                    if (heroX == 14) {
                    } else if (mazeBoard[heroY][heroX + 1] == ' ') {
                        mazeBoard[heroY][heroX] = ' ';
                        heroX = ++heroX;
                    } else if (mazeBoard[heroY][heroX + 1] == gold1) {
                        gold1 = ' ';
                        score += 10;
                        mazeBoard[heroY][heroX] = ' ';
                        heroX = ++heroX;
                    } else if (mazeBoard[heroY][heroX + 1] == gold4) {
                        gold4 = ' ';
                        score += 10;
                        mazeBoard[heroY][heroX] = ' ';
                        heroX = ++heroX;
                    } else if (mazeBoard[heroY][heroX + 1] == gold3) {
                        gold3 = ' ';
                        score += 10;
                        mazeBoard[heroY][heroX] = ' ';
                        heroX = ++heroX;
                    } else if (mazeBoard[heroY][heroX + 1] == gold2) {
                        gold2 = ' ';
                        score += 10;
                        mazeBoard[heroY][heroX] = ' ';
                        heroX = ++heroX;
                    } else if (mazeBoard[heroY][heroX + 1] == caffe) {
                        drinkCoffee();
                    }
                } catch (Exception e) {
                }

                break;
            default:
                System.out.println("Use letters /up=w/, /left=a/, /down = s/, /right = d/ then ENTER");
        }

    }

    public void drinkCoffee() {
        if (mazeBoard[heroY][heroX + 1] == caffe || mazeBoard[heroY][heroX - 1] == caffe ||
                mazeBoard[heroY + 1][heroX] == caffe || mazeBoard[heroY - 1][heroX] == caffe) {
            caffe = ' ';
            score += 10;
            mazeBoard[heroY][heroX] = ' ';
            heroX = ++heroX;
            System.out.println("drinking coffee ¨¨");
            System.out.println("i am full of energy  ");
            System.out.println("let's go to beat the monster! :-)");
        }
    }

    public void catchGold1() {
        if (mazeBoard[heroY][heroX + 1] == gold1 || mazeBoard[heroY][heroX - 1] == gold1 ||
                mazeBoard[heroY + 1][heroX] == gold1 || mazeBoard[heroY - 1][heroX] == gold1) {
            gold1 = ' ';
            score += 10;
            mazeBoard[heroY][heroX] = ' ';
            heroY = --heroY;
        }
    }
        public void catchGold2 () {
            if (mazeBoard[heroY][heroX + 1] == gold2 || mazeBoard[heroY][heroX - 1] == gold2 ||
                    mazeBoard[heroY + 1][heroX] == gold2 || mazeBoard[heroY - 1][heroX] == gold2) {
                gold2 = ' ';
                score += 10;
                mazeBoard[heroY][heroX] = ' ';
                heroY = --heroY;
            }
        }
            public void catchGold3 () {
            if (mazeBoard[heroY][heroX + 1] == gold3 || mazeBoard[heroY][heroX - 1] == gold3 ||
                    mazeBoard[heroY + 1][heroX] == gold3 || mazeBoard[heroY - 1][heroX] == gold3) {
                gold3 = ' ';
                score += 10;
                mazeBoard[heroY][heroX] = ' ';
                heroY = --heroY;
            }
        }
                public void catchGold4 () {
                    if (mazeBoard[heroY][heroX + 1] == gold4 || mazeBoard[heroY][heroX - 1] == gold4 ||
                            mazeBoard[heroY + 1][heroX] == gold4 || mazeBoard[heroY - 1][heroX] == gold4) {
                        gold4 = ' ';
                        score += 10;
                        mazeBoard[heroY][heroX] = ' ';
                        heroY = --heroY;
                    }
                }
            }
