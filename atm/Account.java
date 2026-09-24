package projects.atm;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private String accountHolderName;
    private long bankId;
    private String branch;
    private String mobileNumber;
    private int pin;
    private long balance;
    private List transactionHistory;

    public Account() {
        this.transactionHistory = new ArrayList<>();
    }

    public Account(String accountHolderName, long bankId, String branch,
                   String mobileNumber, int pin, long balance) {

        this.accountHolderName = accountHolderName;
        this.bankId = bankId;
        this.branch = branch;
        this.mobileNumber = mobileNumber;
        this.pin = pin;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public void setBankId(long bankId) {
        this.bankId = bankId;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getPin() {
        return pin;
    }

    public long getBalance() {
        return balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public long getBankId() {
        return bankId;
    }

    public String getBranch() {
        return branch;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public List getTransactionHistory() {
        return transactionHistory;
    }

    public void addTransaction(String type, long amount) {
        transactionHistory.add(new Transaction(type, amount, this.balance));
    }

    public void displayDetails() {

        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Bank ID        : " + bankId);
        System.out.println("Branch         : " + branch);
        System.out.println("Mobile Number  : " + mobileNumber);
        System.out.println("Balance        : ₹" + balance);
    }

    @Override
    public String toString() {

        return "Account{" +
                "accountHolderName='" + accountHolderName + '\'' +
                ", bankId=" + bankId +
                ", branch='" + branch + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}