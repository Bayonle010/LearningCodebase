package interview.finprep;

import java.util.*;

public class SuspiciousTransaction {

    public static List<String> findSuspiciousTransaction(List<Transaction> transactions){

        Map<String, List<Integer>> accountToTimeMap = new HashMap<>();

        for (Transaction transaction : transactions){
            accountToTimeMap.computeIfAbsent(transaction.accountId, k-> new ArrayList<>()).add(transaction.timeStamp);
        }

        List<String> result = new ArrayList<>();

        for (Map.Entry<String, List<Integer>> entry : accountToTimeMap.entrySet()){
            String accountId = entry.getKey();
            List<Integer> timeStamp = entry.getValue();

            Collections.sort(timeStamp);

            int left = 0;
            for (int right = 0; right <= timeStamp.size(); right ++){

                while (timeStamp.get(right) - timeStamp.get(left) > 10000){
                    left++;
                }

                int windowSize = timeStamp.get(right) - timeStamp.get(left) + 1;

                if (windowSize > 3){
                    result.add(accountId);
                }
            }
        }

        return new ArrayList<>(result);
    }


    class Transaction{
        String accountId;
        int timeStamp;
    }
}
