package Algorithm.backtracking;

public class Maze {
    public static void main(String[] args) {
        int numberOfPaths = count(3,3);
        System.out.println(numberOfPaths    );
    }


    static int count(int row, int column){
        if (row == 1 || column == 1){
            return 1;
        }

        int downPaths    = count(row -1 , column);
        int rightPaths = count(row, column -1);

        return  downPaths + rightPaths;
    }
}
