package projects.atm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountsInformation {
    static Map<Long, Account> accounts = new HashMap<>();

    public void addAccount(long accountNumber, Account ac) {
        accounts.put(accountNumber, ac);
    }

    public void displayAccounts(List<Account> accounts) {
        System.out.println(accounts);
    }

    public Account findAccount(long bankId, int pin) {
        Account account = accounts.get(bankId);

        if (account == null) {
            System.out.println("No account found with Bank ID: " + bankId);
            return null;
        }

        if (account.getPin() != pin) {
            System.out.println("Incorrect PIN for Bank ID: " + bankId);
            return null;
        }

        return account;
    }
}