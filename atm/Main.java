package projects.atm;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ATMService atmService = new ATMService();
        Scanner scanner=new Scanner(System.in);
        char ch='y';
        while (ch=='y' || ch=='Y') {
           atmService.showMainMenu();
            System.out.print("Enter your choice : ");
            byte choice = scanner.nextByte();
            if (choice == 1)
                atmService.createAccount();
            else if (choice == 2)
                atmService.loginToAccount();
            else if (choice==3)
                return;
            else
                System.out.println("Invalid Choice ...");

            AccountsInformation info = new AccountsInformation();

//            info.displayAccounts(new ArrayList<>(AccountsInformation.accounts.values()));
            scanner.nextLine();
            System.out.print("Enter (y/Y) to continue : ");
            ch=scanner.nextLine().charAt(0);
        }
    }
}