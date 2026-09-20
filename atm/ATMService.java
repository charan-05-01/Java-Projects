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

        showMenu();
        System.out.print("Enter Choice : ");
        byte choice= scanner.nextByte();

        if(choice==1)
            checkBalance(account);
        if (choice==2){
            System.out.print("Enter deposit Amount : ");
            long amount= scanner.nextLong();
            deposit(account,amount);
        } else if (choice==3) {
            System.out.print("Enter deposit Amount : ");
            long amount= scanner.nextLong();
            withdraw(account,amount);
        } else
            System.out.println("Invalid Choice !!!");
    }

    public void checkBalance(Account account){
        System.out.println("Balance : ₹ "+account.getBalance());
    }


    public void updatedBalance(Account account){
        System.out.println("Updated Balance : ₹ "+account.getBalance());
    }
    public void deposit(Account account,long amount){
        if (amount > 0){
            long am= account.getBalance();
            account.setBalance(am+amount);
            System.out.println("Deposit successful!");
            updatedBalance(account);
        }
        else
            System.out.println("Invalid deposit amount.");
    }


    public  void withdraw(Account account,long amount){
        if (amount>0){
            long am=account.getBalance();
            if (am>=amount){
                account.setBalance(am-amount);
            }
            else
                System.out.println("Insufficient Balance !! ");
        }
        else
            System.out.println("Invalid withdraw amount");
    }
    public void showMenu(){
        System.out.println("1.Check BankBalance ");
        System.out.println("2.Deposit Amount");
        System.out.println("3.Withdraw Amount ");
    }
}