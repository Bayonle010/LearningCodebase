package interview.suspicioustxn;

public class Transaction {

    private String accountId;
    private int timeStamp;

    Transaction(String accountId, int timeStamp){
        this.accountId = accountId;
        this.timeStamp = timeStamp;
    }

    public String getAccountId(){
        return this.accountId;
    }

    public int getTimeStamp(){
        return this.timeStamp;
    }


}
