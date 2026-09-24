package projects.atm;

import projects.atm.exceptions.InvalidMobileException;
import projects.atm.exceptions.InvalidNameException;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class ATMService {

    static Scanner scanner = new Scanner(System.in);

    // --- Validation Methods ---

    public void checkName(String name) throws InvalidNameException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidNameException("Name cannot be empty.");
        }
        if (!name.matches("^[a-zA-Z\\s]+$")) {
            throw new InvalidNameException("Name should contain alphabets only.");
        }
    }

    public void checkMobile(String mobile) throws InvalidMobileException {
        if (mobile == null || mobile.trim().isEmpty()) {
            throw new InvalidMobileException("Mobile number cannot be empty.");
        }
        if (!mobile.matches("^[0-9]{10}$")) {
            throw new InvalidMobileException("Mobile Number should contain exactly 10 digits.");
        }
    }

    // --- Primary ATM Features ---

    public void createAccount() {
        byte attempts = 0;
        String name = "";

        while (attempts < 2) {
            try {
                System.out.print("Enter Name : ");
                name = scanner.nextLine();
                checkName(name);
                break;
            } catch (InvalidNameException e) {
                attempts++;
                System.out.println("-> Error: " + e.getMessage());

                if (attempts == 2) {
                    System.out.println("-> Invalid input entered twice. Account creation canceled.");
                    return;
                }

                System.out.println("-> Final chance! Please try again.");
            }
        }

        byte mobileAttempts = 0;
        String mobile = "";
        while (mobileAttempts < 2) {
            try {
                System.out.print("Enter Mobile Number : ");
                mobile = scanner.nextLine();
                checkMobile(mobile);
                break;
            } catch (InvalidMobileException e) {
                mobileAttempts++;
                System.out.println("-> Error: " + e.getMessage());

                if (mobileAttempts == 2) {
                    System.out.println("-> Invalid mobile number entered twice. Account creation canceled.");
                    return;
                }
                System.out.println("-> Final chance! Please try again.");
            }
        }

        System.out.print("Enter Branch : ");
        String branchName = scanner.nextLine();

        int pin = 0;
        while (true) {
            try {
                System.out.print("Enter Pin : ");
                pin = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("-> Error: PIN must be numeric.");
            }
        }

        long bankId = ThreadLocalRandom.current().nextLong(100000L, 1000000L);

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

        long bankId = 0;
        while (true) {
            try {
                System.out.print("Enter Bank ID : ");
                bankId = Long.parseLong(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("-> Error: Bank ID must be a valid number.");
            }
        }

        int pin = 0;
        while (true) {
            try {
                System.out.print("Enter Pin : ");
                pin = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("-> Error: PIN must be numeric.");
            }
        }

        Account account = new AccountsInformation().findAccount(bankId, pin);

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

            byte choice = -1;
            try {
                System.out.print("Enter Choice : ");
                choice = Byte.parseByte(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid menu option number.");
                continue;
            }

            switch (choice) {

                case 1:
                    checkBalance(account);
                    break;

                case 2:
                    try {
                        System.out.print("Enter Deposit Amount : ");
                        long depositAmount = Long.parseLong(scanner.nextLine());
                        deposit(account, depositAmount);
                    } catch (NumberFormatException e) {
                        System.out.println("-> Error: Invalid amount format.");
                    }
                    break;

                case 3:
                    try {
                        System.out.print("Enter Withdraw Amount : ");
                        long withdrawAmount = Long.parseLong(scanner.nextLine());
                        withdraw(account, withdrawAmount);
                    } catch (NumberFormatException e) {
                        System.out.println("-> Error: Invalid amount format.");
                    }
                    break;

                case 4:
                    transferAmount(account);
                    break;

                case 5:
                    viewTransactionHistory(account);
                    break;

                case 6:
                    account.displayDetails();
                    break;

                case 7:
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
            account.addTransaction("DEPOSIT", amount);
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
                account.addTransaction("WITHDRAW", amount);
                System.out.println("Withdrawal successful!");
                updatedBalance(account);
            } else {
                System.out.println("Insufficient Balance!");
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void transferAmount(Account sender) {

        System.out.println("\n========== TRANSFER MONEY ==========");

        try {
            System.out.print("Enter Receiver Bank ID : ");
            long receiverBankId = Long.parseLong(scanner.nextLine());

            if (receiverBankId == sender.getBankId()) {
                System.out.println("-> Error: You cannot transfer money to your own account.");
                return;
            }

            System.out.print("Enter Receiver PIN : ");
            int receiverPin = Integer.parseInt(scanner.nextLine());

            Account receiver = new AccountsInformation().findAccount(receiverBankId, receiverPin);

            if (receiver == null) {
                System.out.println("-> Error: Invalid Receiver Credentials.");
                return;
            }

            System.out.print("Enter Transfer Amount : ");
            long amount = Long.parseLong(scanner.nextLine());

            if (amount <= 0) {
                System.out.println("-> Error: Invalid transfer amount.");
                return;
            }

            if (sender.getBalance() < amount) {
                System.out.println("-> Error: Insufficient Balance!");
                return;
            }

            // Perform Transfer
            sender.setBalance(sender.getBalance() - amount);
            receiver.setBalance(receiver.getBalance() + amount);

            // Record Transactions
            sender.addTransaction("TRANSFER OUT", amount);
            receiver.addTransaction("TRANSFER IN", amount);

            System.out.println("\nTransfer Successful!");
            System.out.println("Updated Balance : ₹" + sender.getBalance());

        } catch (NumberFormatException e) {
            System.out.println("-> Error: Invalid numeric input.");
        }
    }

    public void viewTransactionHistory(Account account) {
        List history = account.getTransactionHistory();

        System.out.println("\n========== TRANSACTION HISTORY ==========");
        if (history.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            for (Object tx : history) {
                System.out.println(tx);
            }
        }
        System.out.println("=========================================");
    }

    public void showMenu() {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Amount");
        System.out.println("3. Withdraw Amount");
        System.out.println("4. Transfer Amount");
        System.out.println("5. Transaction History");
        System.out.println("6. Account Details");
        System.out.println("7. Logout");
    }

    public void showMainMenu() {
        System.out.println("\n========== MAIN MENU ==========");
        System.out.println("1. Create Account");
        System.out.println("2. Login Account");
        System.out.println("3. Exit");
    }

    public void displayRules() {
        System.out.println("\n========== ATM RULES ==========");
        System.out.println("-> You must create an account before logging in.");
        System.out.println("-> Name should contains alphabets only");
        System.out.println("-> Mobile Number should contains digits and 10 digits only");
        System.out.println("-> Keep your Bank ID and PIN secure.");
        System.out.println("-> Deposit amount must be greater than ₹0.");
        System.out.println("-> Withdrawal amount must be greater than ₹0.");
        System.out.println("-> You cannot withdraw more than your balance.");
        System.out.println("-> Logout after completing your transactions.");
        System.out.println("===============================");
    }
}