package interview;

import java.util.*;

public class DuplicateTransaction {
    /*
    A payment system receives a list of transactions. Each transaction has a unique transactionReference under normal circumstances.
Due to retries or processing errors, the same transaction reference may appear more than once.
Write a Java method that returns all transaction references that occur more than once.
Example
Input:
[
  TX001,
  TX002,
  TX003,
  TX002,
  TX004,
  TX001,
  TX005
]
Expected output:
[TX001, TX002]
    * */


    public Set<String> findDuplicateTransaction(List<String> transactionReferences){

        Map<String, Integer> map = new HashMap<>();

        for (String transactionReference : transactionReferences){
            map.put(transactionReference, map.getOrDefault(transactionReference, 0) + 1);
        }

        Set<String> ans = new HashSet<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()){
            if (entry.getValue() > 0){
                ans.add(entry.getKey());
            }
        }
        return ans;
    }
}
