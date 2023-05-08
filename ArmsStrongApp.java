package gr.aueb.cf.projects;

import java.util.ArrayList;
import java.util.Scanner;

public class ArmsStrongApp {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        final ArrayList<Integer> digits = new ArrayList<>();
        int inputNumber;
        int digitsCount = 0;
        int sum = 0;
        int num = 0;
        int digit = 0;
        boolean isArmstrong = false;

        System.out.println("Please insert a number");
        inputNumber = in.nextInt();

        num = inputNumber;
        do {
            digitsCount++;
            digit = num % 10;
            digits.add(digit);
            num = num / 10;
        } while (num !=0);

        for (int item : digits) {
            sum += Math.pow(item, digitsCount);
        }

        isArmstrong = (sum == inputNumber);

        System.out.println("Number is: " +inputNumber);
        System.out.println("Sum is: " + sum);
        System.out.printf("%d is Armstrong: %s", inputNumber, (isArmstrong) ? "YES" : "FALSE");
    }
}
