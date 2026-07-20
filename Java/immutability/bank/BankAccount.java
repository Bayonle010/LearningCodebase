package Java.immutability.bank;

public class BankAccount {

    public BankAccount(AccountType accountType, double balance) {
        this.accountType = accountType;
        this.balance = balance;
    }

    public enum AccountType{CHECKING, SAVINGS}

    private final AccountType accountType;
    private final double balance;

    public AccountType getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "%s $%.2f".formatted(accountType, balance);
    }
}
