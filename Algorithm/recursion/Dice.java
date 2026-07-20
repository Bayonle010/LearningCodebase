package Algorithm.recursion;

import java.util.ArrayList;

public class Dice {

    public static void main(String[] args) {
        System.out.println(diceFaceReturn("", 4, 6));
    }



    static ArrayList<String> diceFaceReturn(String p, int target, int face){
        if (target == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;

        }

        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i<= face && i<= target; i++){
            list.addAll(diceFaceReturn(p+i, target -i, face));
        }
        return list;
    }
}
