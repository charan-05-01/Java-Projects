package projects.atm;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ATMService {

    static Scanner scanner = new Scanner(System.in);


    public  void createAccount(){
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

        System.out.println("Account created successfully!! ");
        System.out.println("Bank ID : "+account.getBankId());
        showMainMenu();
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
//            System.out.println(account);
            showMenu();
        }else {
            System.out.println("Invalid Credentials ");
            return;
        }


        System.out.print("Enter Choice : ");
        byte choice= scanner.nextByte();

        if(choice==1)
            checkBalance(account);
        else if (choice==2){
            System.out.print("Enter deposit Amount : ");
            long amount= scanner.nextLong();
            deposit(account,amount);
        } else if (choice==3) {
            System.out.print("Enter Withdraw Amount : ");
            long amount= scanner.nextLong();
            withdraw(account,amount);
        } else
            System.out.println("Invalid Choice !!!");
    }

    public void checkBalance(Account account){
        System.out.println("Balance : ₹ "+account.getBalance());
        showMainMenu();
    }


    public void updatedBalance(Account account){
        System.out.println("Updated Balance : ₹ "+account.getBalance());
        showMainMenu();
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
        showMainMenu();
    }


    public  void withdraw(Account account,long amount){
        if (amount>0){
            long am=account.getBalance();
            if (am>=amount){
                account.setBalance(am-amount);
                updatedBalance(account);
            }
            else
                System.out.println("Insufficient Balance !! ");
        }
        else
            System.out.println("Invalid withdraw amount");
        showMainMenu();
    }
    public void showMenu(){
        System.out.println("==========ATM MENU==========");
        System.out.println("1.Check BankBalance\n2.Deposit Amount\n3.Withdraw Amount4.Logout");
    }
    public void showMainMenu(){
        System.out.println("==========MENU==========");
        System.out.println("1.Create Account\n2.Login Account\n3.Exit");
    }
}