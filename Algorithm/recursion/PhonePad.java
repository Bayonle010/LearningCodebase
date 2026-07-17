package Algorithm.recursion;

import java.util.ArrayList;
import java.util.List;

public class PhonePad {
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits == null || digits.isEmpty()) {
            return result;
        }

        String[] mapping = {
                "",     // 0
                "",     // 1
                "abc",  // 2
                "def",  // 3
                "ghi",  // 4
                "jkl",  // 5
                "mno",  // 6
                "pqrs", // 7
                "tuv",  // 8
                "wxyz"  // 9
        };

        pad("", digits, mapping, result);

        return result;
    }

    private void pad(
            String processed,
            String unProcessed,
            String[] mapping,
            List<String> result
    ) {

        if (unProcessed.isEmpty()) {
            result.add(processed);
            return;
        }

        int digit = unProcessed.charAt(0) - '0';
        String letters = mapping[digit];

        for (char ch : letters.toCharArray()) {
            pad(
                    processed + ch,
                    unProcessed.substring(1),
                    mapping,
                    result
            );
        }
    }
}
