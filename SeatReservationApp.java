package gr.aueb.cf.projects;

import java.util.Scanner;

public class SeatReservationApp {
    final static String[][] seats = new String[30][12];
    static int seat = 1;
    static int choice = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 12; j++) {
                seats[i][j] = Integer.toString(seat);
                seat++;
            }
        }
        printSeats();
        do {
            System.out.println("");
            System.out.println("Welcome to theater.");
            System.out.println("Press 1 if you want to make a reservation");
            System.out.println("Press 2 if you want to cancelled your seat");
            System.out.println("Press 3 if you want to exit");

            choice = Integer.parseInt(input.nextLine().trim());
            if (choice >= 4 || choice <= 0) {
                System.out.println("Please enter a right choice ");
            }
            if (choice == 1) {
                System.out.println("You have selected the reservation");
                System.out.println("Now select the seat");

                int choiceSeat = Integer.parseInt(input.nextLine().trim());

                if (choiceSeat > 360 || choiceSeat < 0) {
                    System.out.println("Wrong seat");
                    System.out.println("please enter a seat again");
                    continue;
                }
                int row = (choiceSeat - 1) / 12;
                int col = (choiceSeat - 1) % 12;
                if (seats[row][col].equals("X")) {
                    System.out.println("The selected seat is already reserved");
                } else {
                    replaceWithX(choiceSeat);
                    //System.out.println("Your seat " + choiceSeat + " is reserved");
                }
                printSeats();
                System.out.println("Your seat " + choiceSeat + " is reserved");
            } else if (choice == 2) {
                System.out.println("You have selected the cancelled");
                System.out.println("Now select the seat you want to cancelled");

                int choiceSeat = Integer.parseInt(input.nextLine().trim());
                int row = (choiceSeat - 1) / 12;
                int col = (choiceSeat - 1) % 12;

                if (seats[row][col].equals("X")) {
                    replaceWithSeat(choiceSeat);
                    //System.out.println("Seat is canceled");
                    printSeats();
                    System.out.println("Seat " + choiceSeat + " is canceled");
                }
            }
        } while (choice != 3);
        System.out.println("you have chosen the exit. Thank You. I hope you enjoy the play");
    }

    public static void replaceWithX(int choiceSeat) {

        int row = (choiceSeat - 1) / 12;
        int numCol = (choiceSeat - 1) % 12;
        seats[row][numCol] = "X";
    }

    public static void replaceWithSeat(int choiceSeat) {

        int row = (choiceSeat - 1) / 12;
        int numCol = (choiceSeat - 1) % 12;
        if (seats[row][numCol].equals("X")) {
            seats[row][numCol] = String.valueOf(choiceSeat);
        }
    }

    public static void printSeats () {

        System.out.println("------------------- stage --------------------------");
        for (int i = 0; i < 30; i++) {
            System.out.println("----------------gangway-------------------------");
            for (int j = 0; j < 12; j++) {
                System.out.print(seats[i][j] + "\t");
            }
            System.out.println();
        }
    }
}