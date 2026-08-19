package Algorithm.leetcode;

import java.math.BigDecimal;
import java.util.*;

public class InvalidTransaction1169 {

    public List<String> invalidTransactions(String[] transactions) {

        List<Transaction> parsedTransactions = new ArrayList<>();

        for (int i = 0; i < transactions.length; i++) {
            parsedTransactions.add(parse(transactions[i], i));
        }

        return invalidTransactions(parsedTransactions);
    }


    private List<String> invalidTransactions(List<Transaction> transactions) {

        Map<String, List<Transaction>> transactionGroup = new HashMap<>();

        // Group transactions by name
        for (Transaction transaction : transactions) {
            transactionGroup.computeIfAbsent(transaction.getName(), k -> new ArrayList<>()).add(transaction);
        }

        boolean[] invalidTransaction = new boolean[transactions.size()];


        // Rule 1: amount > 1000
        for (Transaction transaction : transactions) {

            if (transaction.getAmount().compareTo(BigDecimal.valueOf(1000)) > 0) {
                invalidTransaction[transaction.getOriginalIndex()] = true;
            }
        }


        // Rule 2: same name, <= 60 minutes, different city
        for (Map.Entry<String, List<Transaction>> entry : transactionGroup.entrySet()) {

            List<Transaction> group = entry.getValue();

            // Sort by time
            group.sort(Comparator.comparingInt(Transaction::getTime));


            // =====================================
            // PASS 1: Check earlier transactions
            // =====================================

            Map<String, Integer> cityFrequency = new HashMap<>();

            int left = 0;
            for (int right = 0; right < group.size(); right++) {

                Transaction current = group.get(right);

                // Add current transaction's city to window
                cityFrequency.put(current.getCity(), cityFrequency.getOrDefault(
                                current.getCity(), 0
                        ) + 1
                );


                // Remove transactions more than 60 minutes old
                while (current.getTime() - group.get(left).getTime() > 60) {

                    Transaction removed = group.get(left);

                    cityFrequency.put(removed.getCity(), cityFrequency.get(removed.getCity()) - 1);

                    if (cityFrequency.get(removed.getCity()) == 0) {
                        cityFrequency.remove(removed.getCity());
                    }

                    left++;
                }


                int windowSize = right - left + 1;

                int sameCityCount = cityFrequency.getOrDefault(current.getCity(), 0);


                // If not every transaction in the window
                // has the same city as current,
                // then another city exists.
                if (windowSize > sameCityCount) {

                    invalidTransaction[
                            current.getOriginalIndex()
                            ] = true;
                }
            }


            // =====================================
            // PASS 2: Check later transactions
            // =====================================

            cityFrequency.clear();

            int right = group.size() - 1;

            for (int leftIndex = group.size() - 1;
                 leftIndex >= 0;
                 leftIndex--) {

                Transaction current = group.get(leftIndex);


                // Add current city
                cityFrequency.put(
                        current.getCity(),
                        cityFrequency.getOrDefault(
                                current.getCity(), 0
                        ) + 1
                );


                // Remove transactions more than
                // 60 minutes ahead
                while (group.get(right).getTime() - current.getTime() > 60) {

                    Transaction removed = group.get(right);

                    cityFrequency.put(
                            removed.getCity(),
                            cityFrequency.get(removed.getCity()) - 1
                    );

                    if (cityFrequency.get(removed.getCity()) == 0) {
                        cityFrequency.remove(removed.getCity());
                    }

                    right--;
                }


                int windowSize = right - leftIndex + 1;

                int sameCityCount =
                        cityFrequency.getOrDefault(
                                current.getCity(), 0
                        );


                if (windowSize > sameCityCount) {

                    invalidTransaction[
                            current.getOriginalIndex()
                            ] = true;
                }
            }
        }


        // Build final result
        List<String> result = new ArrayList<>();

        for (Transaction transaction : transactions) {

            if (invalidTransaction[
                    transaction.getOriginalIndex()
                    ]) {

                result.add(transaction.toString());
            }
        }

        return result;
    }


    private Transaction parse(String transaction, int index) {

        String[] parts = transaction.split(",");

        String name = parts[0];
        int time = Integer.parseInt(parts[1]);
        BigDecimal amount = new BigDecimal(parts[2]);
        String city = parts[3];

        return new Transaction(
                name,
                time,
                amount,
                city,
                index
        );
    }


    public class Transaction {

        private String name;
        private int time;
        private BigDecimal amount;
        private String city;

        // Remember where this transaction was
        // in the original input
        private int originalIndex;


        public Transaction(
                String name,
                int time,
                BigDecimal amount,
                String city,
                int originalIndex
        ) {
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
            this.originalIndex = originalIndex;
        }


        public String getName() {
            return name;
        }

        public int getTime() {
            return time;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public String getCity() {
            return city;
        }

        public int getOriginalIndex() {
            return originalIndex;
        }


        @Override
        public String toString() {
            return name + ","
                    + time + ","
                    + amount + ","
                    + city;
        }
    }
}