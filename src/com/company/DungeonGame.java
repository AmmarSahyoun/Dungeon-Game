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
        static int monsterY = 7;
        static int monsterX = 3;
        static final int mazeY = 15;
        static final int mazeX = 15;
        static char[][] mazeBoard = new char[mazeY][mazeX];
        static int scoreCounter;

        public static void mainMenu() {
            while (true) {
                boardSetup();
                boardFunction();
            }
        }

        public static void boardSetup() {
            for (int r = 0; r < mazeBoard.length; r++) {
                //iterate through c
                for (int c = 0; c < mazeBoard[r].length; c++) {
                    mazeBoard[c][r] = ' ';
                    mazeBoard[c][0] = 'W';
                    mazeBoard[c][14] = 'W';
                    mazeBoard[0][r] = 'W';
                    mazeBoard[14][r] = 'W';
                    mazeBoard[5][1] = 'W';
                    mazeBoard[5][2] = 'W';
                    mazeBoard[5][3] = 'W';
                    mazeBoard[5][4] = 'W';
                    mazeBoard[5][5] = 'W';
                    mazeBoard[6][5] = 'W';
                    mazeBoard[7][5] = 'W';
                    mazeBoard[8][5] = 'W';
                    mazeBoard[9][5] = 'W';
                    mazeBoard[10][5] = 'W';
                    mazeBoard[10][4] = 'W';
                    mazeBoard[10][3] = 'W';
                    mazeBoard[10][2] = 'W';
                    mazeBoard[8][2] = 'W';
                    mazeBoard[9][2] = 'W';
                    mazeBoard[3][10] = 'W';
                    mazeBoard[4][10] = 'W';
                    mazeBoard[5][10] = 'W';
                    mazeBoard[6][10] = 'W';
                    mazeBoard[7][10] = 'W';
                    mazeBoard[8][10] = 'W';
                    mazeBoard[9][10] = 'W';
                    mazeBoard[10][10] = 'W';
                    mazeBoard[6][11] = 'W';
                    mazeBoard[6][12] = 'W';
                    mazeBoard[6][13] = 'W';
                    mazeBoard[gold1Y][gold1X] = gold1;
                    mazeBoard[gold2Y][gold2X] = gold2;
                    mazeBoard[gold3Y][gold3X] = gold3;
                    mazeBoard[gold4Y][gold4X] = gold4;
                    mazeBoard[heroX][heroY] = hero;
                    mazeBoard[caffeY][cafeeX] = caffe;
                    mazeBoard[monsterY][monsterX] = monster;

                    System.out.print(mazeBoard[c][r] + " ");
                }
                System.out.println();
            }
            System.out.println("");
        }

        public static void boardFunction() {
            Scanner scan = new Scanner(System.in);
            char direction = scan.nextLine().charAt(0);

            switch (direction) {
                case 'w': // up
                    if (heroY == 0) {
                    } else {
                        heroY = --heroY;
                    }
                    break;

                case 's': //down
                    if (heroY == 14) {
                    }  else {
                        heroY = ++heroY;
                    }
                    break;

                case 'a': //left
                    if (heroX == 0) {
                    }  else {
                        heroX = --heroX;
                    }
                    break;

                case 'd': //down
                    if (heroY == 14) {
                    }  else {
                        heroX = ++heroX;
                    }
                    break;
                default :
                    System.out.println("Use letters /up=w/, /left=a/, /down = s/, /right = d/ then ENTER");
            }





        }
    }