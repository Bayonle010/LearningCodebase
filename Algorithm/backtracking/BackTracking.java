package Algorithm.backtracking;

public class BackTracking {


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
}
