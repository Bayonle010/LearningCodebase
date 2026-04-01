package Algorithm.binarySearch;

public class RolColMatrix {
    public static void main(String[] args) {
        int [][] array = {
                {1, 2, 3,4, 5},
                {4, 5, 6},
                {7, 8, 9 }
        };

        System.out.println(length(array));
    }

    static int length(int [][] matrix){
        return matrix.length;
    }
}
