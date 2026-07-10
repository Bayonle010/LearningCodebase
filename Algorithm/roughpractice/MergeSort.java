package Algorithm.roughpractice;

import com.sun.source.tree.BreakTree;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {1,10,12, 5, 7};
         array = mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    static int[] mergeSort(int[] array){

        if(array.length == 1){
            return array;
        }

        int mid = array.length/2;

        int[] left = mergeSort(Arrays.copyOfRange(array, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(array, mid, array.length));

        return merge(left, right);


    }


    static int[] merge(int[] first, int[] second){

        int[] merge = new int[first.length + second.length];

        int i = 0; int j = 0; int k = 0;

        while (i < first.length && j < second.length){
            if (first[i] < second[j]){
                merge[k] = first[i];

                i++;
            }else {
                merge[k] = second[j];

                j++;
            }
            k++;
        }

        while (i < first.length){
            merge[k] = first[i];
            i++;
            k++;
        }

        while (j < second.length){
            merge[k] = second[j];

            j++;
            k++;
        }

        return  merge;
    }

}
