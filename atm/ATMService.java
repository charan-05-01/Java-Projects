package projects.atm;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ATMService {

    static Scanner scanner = new Scanner(System.in);

    public void getAccountDetails() {
        System.out.print("Enter Name : ");
        String name = scanner.nextLine();
        System.out.print("Enter Mobile Number : ");
        String mobile = scanner.nextLine();
        System.out.print("Enter Branch : ");
        String branch_name = scanner.nextLine();
        System.out.print("Enter Pin : ");
        int pin = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline after nextInt()

        long bankId = ThreadLocalRandom.current().nextLong(100000L, 1000000L);

        Account account = new Account(name, bankId, branch_name, mobile, pin, 0L);
        new AccountsInformation().addAccount(bankId,account);

        System.out.println("Account created successfully: " + account);
    }

    public void loginToAccount() {
        System.out.print("Enter Bank ID : ");
        long bankId = Long.parseLong(scanner.nextLine());

        System.out.print("Enter Pin : ");
        int pin = scanner.nextInt();
        scanner.nextLine();

        Account account = new AccountsInformation().findAccount(bankId, pin);

        if (account != null) {
            System.out.println("Login successful!");
            System.out.println(account);
        }
    }
}