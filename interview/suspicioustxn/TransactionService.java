package interview.suspicioustxn;

import java.util.*;

public class TransactionService {

    public static List<String> findSuspiciousTransaction(List<Transaction> transactions){

        /**
         *
         *     /**
         *         QUESTION1:
         *      You are given a list of transactions. A transaction is considered suspicious
         *      if the same accountId makes more than 3 transactions within any 10-second window.
         *      Return a list of all accountIds that have at least one suspicious window.
         *      The result should contain no duplicates.
         *
         *      accountId: "ACC001", timestamp: 1000
         *      accountId: "ACC001", timestamp: 5000
         *      accountId: "ACC001", timestamp: 8000
         *      accountId: "ACC001", timestamp: 10000   ← 4 transactions within 10 seconds (1000–10000) → suspicious
         *      accountId: "ACC002", timestamp: 1000
         *      accountId: "ACC002", timestamp: 9000    ← only 2 transactions → clean
         *      accountId: "ACC001", timestamp: 50000   ← new window, not suspicious alone
         *      **

         * Group timestamps by accountId, sort them, then use a sliding window:

            keep two pointers: left and right
            expand right
            while the window is more than 10 seconds, move left
            if window size becomes >= 4, mark the account suspicious
         **/

        Map<String, List<Integer>> accountToTimeStamp = new HashMap<>();

        for (Transaction transaction : transactions){
            accountToTimeStamp.computeIfAbsent(
                        transaction.getAccountId(), k-> new ArrayList<>()
                    )
                    .add(transaction.getTimeStamp());
        }


        // check each acccount using sliding window
        Set<String> suspiciousAccounts = new HashSet<>();

        for (Map.Entry<String, List<Integer>> entry: accountToTimeStamp.entrySet()){
            String accountId = entry.getKey();
            List<Integer> timeStamps = entry.getValue();

            Collections.sort(timeStamps);

            int left = 0;
            for (int right = 0; right < timeStamps.size(); right++){
                while (timeStamps.get(right) - timeStamps.get(left) > 10000){
                    left++;
                }

                int windowSize = right - left + 1;

                if (windowSize > 3){
                    suspiciousAccounts.add(accountId);
                    break; // no need to keep checking for this accountId
                }

            }
        }

        return new ArrayList<>(suspiciousAccounts);
    }



    /**
     You are given a list of transactions. An account is considered suspicious
     if it makes more than 3 transactions in total.
     Return a list of all suspicious accountIds with no duplicates.
     **/

    public static List<String> findTransactionsMoreThan3InAList(List<Transaction> transactions){
        Map<String, Integer> countMap = new HashMap<>();

        for (Transaction transaction: transactions){
            countMap.put(transaction.getAccountId(), countMap.getOrDefault(transaction.getAccountId(), 0) + 1);
        }

        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry: countMap.entrySet()){
            if (entry.getValue() > 3){
                result.add(entry.getKey());
            }
        }

        return result;
    }




}
