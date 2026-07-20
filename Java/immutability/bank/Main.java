package Java.immutability.bank;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(BankAccount.AccountType.CHECKING, 500);
        System.out.println(account);

        BankCustomer joe = new BankCustomer("joe", 500.00, 1000.00);

    }
}
