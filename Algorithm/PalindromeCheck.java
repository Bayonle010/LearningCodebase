package Algorithm;

public class PalindromeCheck {

    public static void main(String[] args) {
        System.out.println(isPalindrome("Ma dam"));
    }

    public static boolean isPalindrome(String letter){

        String word = letter.toLowerCase().replace(" ", "");

        int left = 0;
        int right = word.length() -1;


        while (left < right){
            if (word.charAt(left) != word.charAt(right)){
                return false;
            }

            left++;
            right--;
        }

        return true;

    }

}
