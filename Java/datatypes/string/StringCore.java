package Java.datatypes.string;

import java.util.Locale;

public class StringCore {
    public static void main(String[] args) {
        String name = "Bayonle";
        System.out.println(name);
        name = "Onadiran";

        System.out.println(name);
    }


    // palindrome check
    static boolean isPalindrome(String str){
        if (str == null || str.length() == 0){
            return true;
        }

        str = str.toLowerCase();
        for (int i = 0; i< str.length()/2; i++){
            char start = str.charAt(i);
            char end = str.charAt(str.length() -1 - i);

            if (start != end) {
                return false;
            }
        }
        return true;
    }
}
