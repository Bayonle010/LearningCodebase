package Algorithm;

import java.util.ArrayList;
import java.util.List;

public class MathsForDSA {
    public static void main(String[] args) {
//        for (int i = 0; i <= 30; i++){
//            System.out.println(i + " is prime ? : " + isPrime(i));
//        }
//        System.out.println(primeNumberBefore(40));
//        System.out.println(squareroot(36));
//        System.out.println(binarySearchSqrt(40, 3));
        System.out.println(factorsOf(20));
    }


    static List<Integer> primeNumberBefore(int number){

        int start = 0;
        List result = new ArrayList<Integer>();

        for (int i = 0; i<= number; i++){
            if (isPrime(i)){
                result.add(i);
            }
        }

        return result;


    }


    static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        int c = 2;
        while (c < num){
            if(num % c == 0){
                return false;
            }

            c++;
        }

        return true;

    }


    static boolean isPalindrome(String word){

        int left = 0;
        int right = word.length();

        while (left<= right){
            if (word.charAt(left) != word.charAt(right)){
                return false;
            }

            left++;
            right--;
        }

        return true;

    }

    static double squareroot(int num){
        return Math.pow(num, 0.5);
    }


    static double binarySearchSqrt(int number, int precision){
        int start = 0;
        int end = number;
        double root = 0.0;
        
        while (start <= end){
            int mid = start + (end  - start)/2;
            
            if (mid * mid == number){
                root = mid;
                return root;
            }
            if (mid * mid >  number){
                end = mid -1;
            }else {
                start = mid +1;
            }
        }

        double increment = 0.1;
        for (int i = 0; i < precision; i++){
            while (root * root < number){
                root += increment;
            }

            root -= increment;
            increment/= 10;
        }
        return root;
    }


    static List<Integer> factorsOf(int number){


        List<Integer> results = new ArrayList<>();

        for (int i = 1; i <= number; i++){
            if (number % i  == 0){
                results.add(i);
            }
        }

        return results;
    }




}
