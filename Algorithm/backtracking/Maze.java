package Algorithm.backtracking;

import java.util.ArrayList;

public class Maze {
    public static void main(String[] args) {
        int numberOfPaths = count(3,3);
        //System.out.println(numberOfPaths    );


        boolean[][] maze = {
                {true,  true,  true},
                {true,  false, true},
                {true,  true,  true}
        };

        pathRestrictions("", maze, 0, 0);
    }


    static int count(int row, int column){
        if (row == 1 || column == 1){
            return 1;
        }

        int downPaths    = count(row -1 , column);
        int rightPaths = count(row, column -1);

        return  downPaths + rightPaths;
    }

    static ArrayList<String> returnPaths(String path, int row, int column){
        if (row ==1  && column == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(path);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if (row > 1){
            list.addAll(returnPaths(path + 'D', row -1 , column));
        }

        if (column > 1){
            list.addAll(returnPaths(path + 'R', row, column -1));
        }

        return  list;
    }

    static ArrayList<String> returnPathsDiagonal(String path, int row, int column){
        if (row ==1  && column == 1){
            ArrayList<String> list = new ArrayList<>();
            list.add(path);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        if (row > 1 && column > 1 ){
            list.addAll(returnPathsDiagonal(path + 'V', row -1 , column-1));
        }

        if (row > 1){
            list.addAll(returnPathsDiagonal(path + 'D', row -1 , column));
        }

        if (column > 1){
            list.addAll(returnPathsDiagonal(path + 'R', row, column -1));
        }


        return  list;
    }

    static void     pathRestrictions(String p, boolean[][] maze, int row, int column){

        // Is this cell block ?
        if (!maze[row][column]){
            return;
        }

        // have we reached the destination
        if (row == maze.length - 1 && column == maze[0].length - 1){
            System.out.println(p);
            return;
        }

        // move down
        if (row < maze.length -1){
            pathRestrictions(p + 'D', maze, row + 1, column);
        }

        // move right
        if(column < maze[0].length -1){
            pathRestrictions(p + 'R', maze, row,column + 1 );
        }

    }

}
