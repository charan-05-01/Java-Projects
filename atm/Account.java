package projects.atm;

public class Account {
    private String accountHolderName;
    private long bankId;
    private String branch;
    private String mobile_number;
    private int pin;
    private Long balance;

    public Account() {
    }

    public Account(String accountHolderName, Long bankId, String branch, String mobile_number, int pin, Long balance) {
        this.accountHolderName = accountHolderName;
        this.bankId = bankId;
        this.branch = branch;
        this.mobile_number = mobile_number;
        this.pin = pin;
        this.balance = balance;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setMobile_number(String mobile_number) {
        this.mobile_number = mobile_number;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }


    public int getPin() {
        return pin;
    }

    public Long getBalance() {
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

    public String getMobile_number() {
        return mobile_number;
    }


    public void displayDetails() {
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Bank ID        : " + bankId);
        System.out.println("Branch         : " + branch);
        System.out.println("Mobile Number  : " + mobile_number);
        System.out.println("Balance        : ₹" + balance);
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountHolderName='" + accountHolderName + '\'' +
                ", bankId=" + bankId +
                ", branch='" + branch + '\'' +
                ", mobile_number='" + mobile_number + '\'' +
                ", pin=" + pin +
                ", balance=" + balance +
                '}';
    }
}
