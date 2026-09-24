package projects.atm;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ATMService {

    static Scanner scanner = new Scanner(System.in);

    public void createAccount() {

        System.out.print("Enter Name : ");
        String name = scanner.nextLine();

        System.out.print("Enter Mobile Number : ");
        String mobile = scanner.nextLine();

        System.out.print("Enter Branch : ");
        String branchName = scanner.nextLine();

        System.out.print("Enter Pin : ");
        int pin = scanner.nextInt();
        scanner.nextLine();

        long bankId = ThreadLocalRandom.current()
                .nextLong(100000L, 1000000L);

        Account account = new Account(
                name,
                bankId,
                branchName,
                mobile,
                pin,
                0L
        );

        new AccountsInformation().addAccount(bankId, account);

        System.out.println("\nAccount created successfully!");
        System.out.println("Bank ID : " + account.getBankId());
    }

    public void loginToAccount() {

        System.out.print("Enter Bank ID : ");
        long bankId = Long.parseLong(scanner.nextLine());

        System.out.print("Enter Pin : ");
        int pin = scanner.nextInt();
        scanner.nextLine();

        Account account =
                new AccountsInformation().findAccount(bankId, pin);

        if (account != null) {

            System.out.println("\nLogin successful!");

            showAtmMenu(account);

        } else {

            System.out.println("Invalid Credentials.");
        }
    }

    public void showAtmMenu(Account account) {

        while (true) {

            System.out.println("\n========== ATM MENU ==========");
            showMenu();

            System.out.print("Enter Choice : ");
            byte choice = scanner.nextByte();

            switch (choice) {

                case 1:
                    checkBalance(account);
                    break;

                case 2:
                    System.out.print("Enter Deposit Amount : ");
                    long depositAmount = scanner.nextLong();

                    deposit(account, depositAmount);
                    break;

                case 3:
                    System.out.print("Enter Withdraw Amount : ");
                    long withdrawAmount = scanner.nextLong();

                    withdraw(account, withdrawAmount);
                    break;

                case 4:
                    account.displayDetails();
                    break;

                case 5:
                    System.out.println("Logged out successfully!");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    public void checkBalance(Account account) {

        System.out.println("Balance : ₹" + account.getBalance());
    }

    public void updatedBalance(Account account) {

        System.out.println("Updated Balance : ₹" + account.getBalance());
    }

    public void deposit(Account account, long amount) {

        if (amount > 0) {

            long balance = account.getBalance();

            account.setBalance(balance + amount);

            System.out.println("Deposit successful!");

            updatedBalance(account);

        } else {

            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(Account account, long amount) {

        if (amount > 0) {

            long balance = account.getBalance();

            if (balance >= amount) {

                account.setBalance(balance - amount);

                System.out.println("Withdrawal successful!");

                updatedBalance(account);

            } else {

                System.out.println("Insufficient Balance!");
            }

        } else {

            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void showMenu() {

        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Amount");
        System.out.println("3. Withdraw Amount");
        System.out.println("4. Account Details");
        System.out.println("5. Logout");
    }

    public void showMainMenu() {

        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("1. Create Account");
        System.out.println("2. Login Account");
        System.out.println("3. Exit");
    }
}