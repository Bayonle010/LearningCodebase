package interview.cashii;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class LedgerBalanceChecker {

    public static void main(String[] args) {
        List<LedgerEntry> ledgerEntries = List.of(
                new LedgerEntry(UUID.fromString("8f6d2c3e-1c9a-4b7f-a2d1-5f9b8c7e3a11"), Direction.CREDIT, 20l),
                new LedgerEntry(UUID.fromString("8f6d2c3e-1c9a-4b7f-a2d1-5f9b8c7e3a11"), Direction.CREDIT, 50l)
        );

        System.out.println(isBalanced(ledgerEntries));
    }
    /*
    "Given a list of ledger entries, verify that the books balance — total debits equal total credits. What if the list has millions of entries?"
     */

    enum Direction { DEBIT, CREDIT }

    record LedgerEntry(UUID accountId, Direction direction, long amount) {}

    static boolean isBalanced(List<LedgerEntry> entries){
        Map<UUID, Long> directionLongMap = new HashMap<>();

        for (LedgerEntry entry : entries){

            if (entry.direction() == Direction.CREDIT) {
                directionLongMap.put(entry.accountId, directionLongMap.getOrDefault(entry.accountId(), 0l) + entry.amount());
            }else {
                directionLongMap.put(entry.accountId, directionLongMap.getOrDefault(entry.accountId(), 0l)  - entry.amount());
            }

        }

        for (Map.Entry<UUID, Long> remainder : directionLongMap.entrySet()){

            if (remainder.getValue() != 0l){
                return false;
            }
        }

        return true;
    }


    // for million of entries.
    public boolean isBalancedParallel(List<LedgerEntry> entries){
        Map<Direction, Long> totals = entries.parallelStream()
                .collect(Collectors.groupingBy(
                        LedgerEntry::direction,
                        Collectors.summingLong(LedgerEntry::amount)
                ));

        long debits = totals.getOrDefault(Direction.DEBIT, 0L);
        long credits = totals.getOrDefault(Direction.CREDIT, 0L);

        return debits == credits;
    }

    // another

    public boolean isBalancedII(List<LedgerEntry> entries){
        long balance = 0L;

        for (LedgerEntry entry :  entries){
             balance += entry.direction() == Direction.CREDIT ?  entry.amount() : - entry.amount();
        }

        return balance == 0L;
    }
}
