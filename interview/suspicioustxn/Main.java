package interview.suspicioustxn;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Transaction> transactions = List.of(
                new Transaction("ACC001", 1000),
                new Transaction("ACC001", 5000),
                new Transaction("ACC001", 8000),
                new Transaction("ACC001", 10000),
                new Transaction("ACC002", 1000),
                new Transaction("ACC002", 9000),
                new Transaction("ACC001", 50000)
        );

        List<String> result = TransactionService.findSuspiciousTransaction(transactions);
//        System.out.println(result); // [ACC001]

        List<String> response = TransactionService.findTransactionsMoreThan3InAList(transactions);
        System.out.println(response);

    }
}
