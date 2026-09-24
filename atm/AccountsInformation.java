package projects.atm;

import java.util.HashMap;
import java.util.Map;

public class AccountsInformation {

    static Map<Long, Account> accounts = new HashMap<>();

    public void addAccount(long bankId, Account account) {
        accounts.put(bankId, account);
    }

    public Account findAccount(long bankId, int pin) {

        Account account = accounts.get(bankId);

        if (account == null) {
            System.out.println("No account found with Bank ID: " + bankId);
            return null;
        }

        if (account.getPin() != pin) {
            System.out.println("Incorrect PIN.");
            return null;
        }

        return account;
    }
}