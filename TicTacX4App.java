package gr.aueb.cf.projects;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacX4App {

        static String[] board;
        static String turn;

        public static void main(String[] args)
        {
            Scanner in = new Scanner(System.in);
            board = new String[16];
            turn = "0";
            String winner = null;

            for (int i = 0; i < 16; i++) {
                board[i] = String.valueOf(i + 1);
            }

            System.out.println("Welcome to 4x4 Tic Tac Toe for hard bastards.");
            printBoard();

            System.out.println(
                    "0 will play first. Enter a number to place 0 in:");

            while (winner == null) {
                int num = 0;

                try {
                    num = in.nextInt();
                    if (!(num > 0 && num <= 16)) {
                        System.out.println(
                                "Invalid input. re-enter number:");
                        continue;
                    }
                }
                catch (InputMismatchException e) {
                    System.out.println(
                            "Invalid input. re-enter number:");
                    continue;
                }

                if (board[num - 1].equals(
                        String.valueOf(num))) {
                    board[num - 1] = turn;

                    if (turn.equals("X")) {
                        turn = "0";
                    }
                    else {
                        turn = "X";
                    }

                    printBoard();
                    winner = winner();
                }
                else {
                    System.out.println(
                            "Slot already taken. enter a new slot number:");
                }
            }

            if (winner.equalsIgnoreCase("draw")) {
                System.out.println(
                        "It's a draw! Game over");
            }

            else {
                System.out.println(
                        "Congratulations!  The  "  + winner
                                + " have won!");
                System.out.println("Game over");
            }
        }
        public static String winner()
        {
            for (int i = 0; i < 17; i++) {
                String line = "0";

                switch (i) {
                    case 0:
                        line = board[0] + board[1] + board[2] + board[3];
                        break;
                    case 1:
                        line = board[4] + board[5] + board[6]+ board[7];
                        break;
                    case 2:
                        line = board[12] + board[13] + board[14]+ board[15];
                        break;
                    case 3:
                        line = board[8] + board[9] + board[10] + board[11];
                        break;
                    case 4:
                        line = board[1] + board[5] + board[9] + board[13];
                        break;
                    case 5:
                        line = board[0] + board[4] + board[8] + board[12];
                        break;
                    case 6:
                        line = board[2] + board[6] + board[10] + board[14];
                        break;
                    case 7:
                        line = board[3] + board[7] + board[11] + board[15];
                        break;
                    case 8:
                        line = board[0] + board[5] + board[10] + board[15];
                        break;
                    case 9:
                        line = board[3] + board[6] + board[9] + board[12];
                        break;
                }

                if (line.equals("XXXX")) {
                    return "X";
                }

                else if (line.equals("0000")) {
                    return "0";
                }
            }

            for (int a = 0; a < 16; a++) {
                if (Arrays.asList(board).contains(
                        String.valueOf(a + 1))) {
                    break;
                }
                else if (a == 15) {
                    return "draw";
                }
            }

            System.out.println(
                    turn + "'s turn; enter a slot number to place "
                            + turn + " in:");
            return null;
        }

       public static void printBoard()
        {

            System.out.println("----------------------------");
            System.out.println("| "+board[0]+"   /  "
                    +board[1]+"   /   "+board[2] +"   /  " + board[3]
                    +"  |  ");
            System.out.println("----------------------------");
            System.out.println("| "+board[4]+"   /  "
                    + board[5] +"   /   "+ board[6]
                    + "   /  "+ board[7]
                    + "  |  ");
            System.out.println("----------------------------");
            System.out.println("|  "+board[8]+"  /  "
                    + board[9] +"  /  "+ board[10]
                    + "  /  "+ board[11]
                    +"  | ");
            System.out.println("----------------------------");
            System.out.println("| "+board[12]+"  /  "
                    + board[13] +"  /  "+ board[14]
                    +"  /  "+ board[15]
                    +"  | ");
            System.out.println("----------------------------");
        }
    }
