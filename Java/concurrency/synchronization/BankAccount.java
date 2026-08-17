package Java.concurrency.synchronization;

public class BankAccount {
    private  double balance;

    public BankAccount(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return this.balance;
    }

    public synchronized void deposit(double amount){
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        double originalBalance = balance;
        balance+= amount;

        System.out.printf("STARTING BALANCE: %.0f, DEPOSIT (%.0f)"
            +
            " : NEW BALANCE = %.0f%n", originalBalance, amount, balance);
    }

    public synchronized void withdraw(double amount){
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        double originalBalance = balance;
        if (amount <= balance){
            balance-= amount;

            System.out.printf("STARTING BALANCE: %.0f, WITHDRAWAL (%.0f)"
                    +
                    " : NEW BALANCE = %.0f%n", originalBalance, amount, balance);
        }else {
            System.out.printf("STARTING BALANCE");

        }

    }
}
