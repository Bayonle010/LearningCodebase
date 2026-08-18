package Algorithm.leetcode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InvalidTransaction1169BruteForce {

    public List<String> invalidTransactions(String[] transactions) {

        List<Transaction> parsedTransactions = new ArrayList<>();

        for (String transaction : transactions) {
            parsedTransactions.add(parse(transaction));
        }

        return invalidTransactions(parsedTransactions);
    }

    private List<String> invalidTransactions(List<Transaction> transactions) {

        boolean[] invalid = new boolean[transactions.size()];

        for (int i = 0; i < transactions.size(); i++) {

            Transaction firstTransaction = transactions.get(i);

            // Rule 1: amount exceeds 1000
            if (firstTransaction.getAmount()
                    .compareTo(BigDecimal.valueOf(1000)) > 0) {

                invalid[i] = true;
            }

            // Compare only with transactions after i
            for (int j = i + 1; j < transactions.size(); j++) {

                Transaction secondTransaction = transactions.get(j);

                boolean sameName = firstTransaction.getName().equals(secondTransaction.getName());

                boolean within60Minutes =
                        Math.abs(firstTransaction.getTime() - secondTransaction.getTime()) <= 60;

                boolean differentCity = !firstTransaction.getCity().equals(secondTransaction.getCity());

                // Rule 2
                if (sameName && within60Minutes && differentCity) {
                    invalid[i] = true;
                    invalid[j] = true;
                }
            }
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < transactions.size(); i++) {
            if (invalid[i]) {
                result.add(transactions.get(i).toString());
            }
        }

        return result;
    }

    private Transaction parse(String transaction) {

        String[] parts = transaction.split(",");

        String name = parts[0];
        int time = Integer.parseInt(parts[1]);
        BigDecimal amount = new BigDecimal(parts[2]);
        String city = parts[3];

        return new Transaction(name, time, amount, city);
    }

    public class Transaction {

        private String name;
        private int time;
        private BigDecimal amount;
        private String city;

        public Transaction(
                String name,
                int time,
                BigDecimal amount,
                String city
        ) {
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
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

        @Override
        public String toString() {
            return name + "," + time + "," + amount + "," + city;
        }
    }
}