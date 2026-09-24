package projects.atm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ATMService atmService = new ATMService();
        Scanner scanner = new Scanner(System.in);

        char ch = 'y';

        while (ch == 'y' || ch == 'Y') {

            atmService.showMainMenu();

            System.out.print("Enter your choice : ");
            byte choice = scanner.nextByte();
            scanner.nextLine();

            if (choice == 1) {

                atmService.createAccount();

            } else if (choice == 2) {

                atmService.loginToAccount();

            } else if (choice == 3) {

                System.out.println("Thank you for using ATM!");
                return;

            } else {

                System.out.println("Invalid Choice!");
            }

            System.out.print("\nEnter (y/Y) to continue : ");
            ch = scanner.nextLine().charAt(0);
        }
    }
}