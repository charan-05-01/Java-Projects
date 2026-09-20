package projects.atm;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ATMService atmService = new ATMService();

        atmService.getAccountDetails();
//        atmService.getAccountDetails();
//        atmService.getAccountDetails();

        atmService.loginToAccount();

        AccountsInformation info = new AccountsInformation();

        info.displayAccounts(new ArrayList<>(AccountsInformation.accounts.values()));

    }
}