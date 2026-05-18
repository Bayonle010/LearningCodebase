package Algorithm;

public class BitwiseOperator {
    public static void main(String[] args) {
        int[] arr = {2,3,2,3,4,6,4};
        System.out.println(ans(arr));

    }

    static int ans(int[] array){
        int unique = 0;

        for (int n : array){
            unique ^= n;
        }

        return unique;

    }
}
