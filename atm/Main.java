package projects.atm;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ATMService atmService = new ATMService();
        Scanner scanner = new Scanner(System.in);

        atmService.displayRules();
        char ch = 'y';

        while (ch == 'y' || ch == 'Y') {

            atmService.showMainMenu();

            byte choice = -1;
            try {
                System.out.print("Enter your choice : ");
                choice = Byte.parseByte(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("-> Error: Choice must be a valid number (1, 2, or 3).");
                ch = askToContinue(scanner);
                continue;
            }

            if (choice == 1) {

                atmService.createAccount();

            } else if (choice == 2) {

                atmService.loginToAccount();

            } else if (choice == 3) {

                System.out.println("Thank you for using ATM!");
                return;

            } else {

                System.out.println("Invalid Choice! Please select 1, 2, or 3.");
            }

            ch = askToContinue(scanner);
        }

        System.out.println("Thank you for using ATM!");
    }

    private static char askToContinue(Scanner scanner) {
        System.out.print("\nEnter (y/Y) to continue : ");
        String input = scanner.nextLine();

        if (!input.isEmpty()) {
            return input.charAt(0);
        }
        return 'n';
    }
}