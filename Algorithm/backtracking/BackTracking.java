package Algorithm.backtracking;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BackTracking {

    public static void main(String[] args) {
        boolean[][] board = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        int[][] pathInMatrix = new int[board.length][board[0].length];

        allPathWithStepsCount("", board, 0, 0, pathInMatrix, 1);
    }


    static  void allPath(String path, boolean[][] maze, int row, int column){

        // check if the cell is blocked or already visited
        if (!maze[row][column]){
            return;
        }

        // check if destination has been reached
        if (row == maze.length - 1 && column == maze[0].length -1){
            System.out.println(path);
            return;
        }

        // mark current cell as visited
        maze[row][column] = false;

        // move down
        if (row < maze.length -1 ){
            allPath(path + 'D', maze, row + 1, column);
        }

        // move right
        if (column < maze[0].length -1){
            allPath(path + 'R', maze, row, column + 1);
        }

        // move up
        if (row > 0){
            allPath(path + 'U', maze, row -1, column);
        }


        // move left
        if (column > 0){
            allPath(path + 'L', maze, row, column -1);
        }

        // Backtrack: restore the cell for other possible paths
        maze[row][column] = true;
    }

    static  void allPathWithStepsCount(String path, boolean[][] maze, int row, int column, int[][] pathInMatrix, int step){

        // check if the cell is blocked or already visited
        if (!maze[row][column]){
            return;
        }

        // check if destination has been reached
        if (row == maze.length - 1 && column == maze[0].length -1){
            pathInMatrix[row][column] = step;

            for (int[] arr : pathInMatrix){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(path);
            System.out.println();
            return;
        }

        // mark current cell as visited
        maze[row][column] = false;
        pathInMatrix[row][column] = step;

        // move down
        if (row < maze.length -1 ){
            allPathWithStepsCount(path + 'D', maze, row + 1, column, pathInMatrix, step + 1);
        }

        // move right
        if (column < maze[0].length -1){
            allPathWithStepsCount(path + 'R', maze, row, column + 1, pathInMatrix, step + 1);
        }

        // move up
        if (row > 0){
            allPathWithStepsCount(path + 'U', maze, row -1, column, pathInMatrix, step + 1);
        }


        // move left
        if (column > 0){
            allPathWithStepsCount(path + 'L', maze, row, column -1, pathInMatrix, step + 1);
        }

        // Backtrack: restore the cell for other possible paths
        maze[row][column] = true;
        pathInMatrix[row][column] = 0;
    }
}
