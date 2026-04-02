package Algorithm.binarySearch;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RolColMatrix {
    public static void main(String[] args) {
        int [][] array = {
                {1, 2, 3,},
                {4, 5, 6},
                {7, 8, 9 }
        };

        System.out.println(Arrays.toString(findTargetIn2DArray(array, 6)));
    }

    static int length(int [][] matrix){
        return matrix.length;
    }

    static int[] findTargetIn2DArray(int [][] matrix, int target){
        int row = 0;
        int column = matrix.length -1;

        while (row < matrix.length && column >= 0){

            if (matrix[row][column] == target){
                return new int[]{row, column};
            }
            if (matrix[row][column] < target){
                row++;
            }else {
                column --;
            }
        }

        return  new int[]{-1, -1};
    }
}
