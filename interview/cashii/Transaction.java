package interview.cashii;

import java.math.BigDecimal;

public class Transaction {
    private String accountId;
    private BigDecimal amount;
    private long time;


    public Transaction(String accountId, BigDecimal amount, long time){
        this.accountId = accountId;
        this.amount = amount;
        this.time = time;
    }

    public String getAccountId(){
        return this.accountId;
    }

    public BigDecimal getAmount(){
        return this.amount;
    }


    public long getTime(){
        return this.time;
    }
}
