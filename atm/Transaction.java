package projects.atm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String type;
    private long amount;
    private long remainingBalance;
    private String timestamp;

    public Transaction(String type, long amount, long remainingBalance) {
        this.type = type;
        this.amount = amount;
        this.remainingBalance = remainingBalance;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.timestamp = LocalDateTime.now().format(formatter);
    }

    @Override
    public String toString() {
        return String.format("[%s] %-10s | Amount: ₹%-8d | Balance: ₹%d",
                timestamp, type, amount, remainingBalance);
    }
}