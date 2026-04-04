package Algorithm;

import java.util.Arrays;

public class RolColMatrix {
    public static void main(String[] args) {
        int [][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9 }
        };

        int [][] array2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15,16}
        };



        System.out.println(array.length);

        System.out.println(Arrays.toString(findTargetIn2DArray(array2, 12)));
    }

    /**
     This is used when:
     1. Every row is sorted left to right
     2. Every column is sorted top to bottom.

     Time complexity = O(row + cols)
     **/


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
