package interview.cashii;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.*;

public class DuplicateTransactionDetector {
    private final static long WINDOW = 60L;


    /*
     "Given a list of transactions, detect if any account has a duplicate transaction — same amount, same account, within 60 seconds. Write the code."
     */

    public static void main(String[] args) {
            List<Transaction> transactions = List.of(
                    new Transaction("USER1", BigDecimal.valueOf(20), 10),
                    new Transaction("USER1", BigDecimal.valueOf(20), 50),
                    new Transaction("USER1", BigDecimal.valueOf(20), 70),
                    new Transaction("USER2", BigDecimal.valueOf(20), 10),
                    new Transaction("USER3", BigDecimal.valueOf(20), 10)


            );

        System.out.println(duplicateTransactions(transactions));

    }


    public static List<String> duplicateTransactions(List<Transaction> transactions){

        Map<String, List<Long>> transactionMap = new HashMap<>();


        for (Transaction transaction : transactions){
            String idempotencyKey = transaction.getAccountId() + transaction.getAmount();
            transactionMap.computeIfAbsent(idempotencyKey, k-> new ArrayList<>())
                            .add(transaction.getTime());
        }

        List<String> duplicateTransactions = new ArrayList<>();

        for (Map.Entry<String, List<Long>> entry : transactionMap.entrySet()){

            String key = entry.getKey();
            List<Long> timeList = entry.getValue();

            Collections.sort(timeList);

            int left = 0;
            for (int right = 0; right < timeList.size(); right++){

                while (timeList.get(right) - timeList.get(left) > WINDOW){
                    left++;
                }

                int windowSize = right - left + 1;

                if (windowSize >=  2){
                    duplicateTransactions.add(key);
                    break;
                }
            }
        }

        return new ArrayList<>(duplicateTransactions);

    }
}
