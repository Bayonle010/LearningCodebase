package interview.suspicioustxn;

public class Main {
 /**
 You are given a list of transactions. An account is considered suspicious
 if it makes more than 3 transactions in total.
 Return a list of all suspicious accountIds with no duplicates.
  **/


    /**

     You are given a list of transactions. A transaction is considered suspicious
     if the same accountId makes more than 3 transactions within any 10-second window.
     Return a list of all accountIds that have at least one suspicious window.
     The result should contain no duplicates.

     accountId: "ACC001", timestamp: 1000
     accountId: "ACC001", timestamp: 5000
     accountId: "ACC001", timestamp: 8000
     accountId: "ACC001", timestamp: 10000   ← 4 transactions within 10 seconds (1000–10000) → suspicious
     accountId: "ACC002", timestamp: 1000
     accountId: "ACC002", timestamp: 9000    ← only 2 transactions → clean
     accountId: "ACC001", timestamp: 50000   ← new window, not suspicious alone
     **/
}
