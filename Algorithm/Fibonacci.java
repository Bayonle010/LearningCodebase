package Algorithm;

public class Fibonacci {
    public static void main(String[] args) {
        for (int i = 0; i<11; i++){
            System.out.println(fibonacciFormula(i));
        }

    }

    static int fibbo(int n){
        if (n<2){
            return n;
        }
        return fibbo(n-1) + fibbo(n -2);
    }


    static int fibonacciFormula(int n){
        return (int) ((Math.pow(((1+Math.sqrt(5))/2), n) - Math.pow(((1 - Math.sqrt(5))/2), n)) /Math.sqrt(5));
    }
}
