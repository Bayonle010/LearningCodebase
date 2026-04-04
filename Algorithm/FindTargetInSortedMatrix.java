package Algorithm;

import java.util.Arrays;

public class FindTargetInSortedMatrix {
    public static void main(String[] args) {
        int [][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}

        };

        System.out.println(Arrays.toString(search(array, 8)));

    }


    /**
     This is used when:
     1. Rows are sorted
     2. values increase as you go downward
     3. the matrix is ordered enough that binary search ideas can work

     Time complexity = O(log(rows) + log(cols))
     **/

    static int [] search (int[][] matrix, int target){
        int rows = matrix.length;
        int cols = matrix[0].length;

        if (rows == 0 || cols == 0){
            return new int[]{-1, -1};
        }

        if (rows == 1){
            return binarySearch(matrix, 0, 0, cols -1, target);
        }

        int rowStart = 0;
        int rowEnd = rows -1;
        int columnMid = cols/2;

        // run the loop till 2 rows are remaining
         while (rowStart < rowEnd -1){
             int mid = rowStart + (rowEnd - rowStart)/2;

             if (matrix[mid][columnMid] == target){
                 return new int[]{rowStart, columnMid};
             }
             if (matrix[mid][columnMid] < target) {
                 rowStart = mid;
             } else {
                 rowEnd = mid;
             }
         }

         // now we have two rows
        // check whether target is in the col of 2 rows

        if (matrix[rowStart][columnMid] == target){
            return new int[]{rowStart, columnMid};
        }
        if (matrix[rowStart + 1][columnMid] == target){
            return new int[]{rowStart + 1, columnMid};
        }

        // search in 1st half
        if (target <= matrix[rowStart][columnMid -1]){
            return binarySearch(matrix, rowStart, 0, columnMid - 1, target );
        }

        // search in 2nd half

        if (target >= matrix[rowStart][columnMid + 1] && target <= matrix[rowStart][cols - 1] ){
            return binarySearch(matrix, rowStart, columnMid + 1, cols -1, target);
        }

        // search in 3rd half

        if (target <= matrix[rowStart + 1][columnMid - 1]){
            return binarySearch(matrix, rowStart+1, 0, columnMid -1, target);
        }

        // search in 4th half
        return binarySearch(matrix, rowStart + 1, columnMid + 1, cols -1, target);

    }

    static int[] binarySearch(int[][] matrix, int row, int columnStart, int columnEnd, int target){
        while (columnStart <= columnEnd){
            int mid = columnStart + (columnEnd - columnStart)/2;

            if (matrix[row][mid] == target){
                return  new int[]{row, mid};
            }

            if (matrix[row][mid] < target){
                 columnStart = mid + 1;
            }else {
                columnEnd = mid - 1;
            }
        }

        return  new  int[]{-1, -1};
    }


}
