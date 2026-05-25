package Algorithm;

public class Recursion {

    public static void main(String[] args) {
//        System.out.println(factorial(5));

        System.out.println(sumOfDigits(123));
        System.out.println(productOfDigits(123));
        System.out.println(reverse(4321));
        System.out.println(countZeros(510402002));
    }

    static int factorial(int num){
        if (num <= 1){
            return 1    ;
        }

        return num * factorial(num -1);
    }


    static int sumOfDigits(int num){
        if (num == 0){
            return  0;
        }

        return sumOfDigits(num / 10) + (num % 10);
    }

    static int productOfDigits(int num){
        if (num == 0){
            return 0;
        }

        if (num == 1){
            return  1;
        }

        return productOfDigits(num/10) * (num % 10);
    }


    static int reverse(int number){
        int digits = (int) (Math.log10(number) + 1);
        return helper(number, digits);
    }

    private static int helper(int n, int digits){
        if (n%10 == n){
            return n;
        }

        int rem = n % 10;

        return rem * (int) Math.pow(10, digits -1) + helper(n/10, digits -1);
    }


    static int countZeros(int num){
        return countHelper(num, 0);
    }

    /*
        Given an integer num, return the number of steps to reduce it to zero.
        In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
     */

    static int numberOfSteps(int num){
        return numberOfStepsToZeroHelper(num, 0);
    }

    private static int numberOfStepsToZeroHelper(int num, int steps){
        if (num == 0){
            return steps;
        }
        if (num % 2 == 0){
            return numberOfStepsToZeroHelper(num/2, steps+1);
        }
        return numberOfStepsToZeroHelper(num -1, steps + 1);
    }


    private static int countHelper(int num, int count) {
        if (num == 0){
            return count;
        }

        int remainder = num % 10;
        if (remainder == 0){
            return countHelper(num/10, count+1);
        }
        return countHelper(num/10 , count);
    }
}
