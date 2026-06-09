package Algorithm.sorting;

import java.util.Arrays;

public class MergerSort {
    public static void main(String[] args) {
        int[] array = {5,4,3,2,1};
        array = mergeSort(array);
        System.out.println(Arrays.toString(array));
    }


    static int[] mergeSort(int[] array){
        if(array.length == 1){
            return array;
        }

        int mid = array.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(array, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(array, mid, array.length));

        return merge(left, right);

    }


    static int[] merge(int[] first, int[] second){
        int[] merged = new int[first.length + second.length];

        int i = 0, j = 0, k = 0;

        while (i < first.length && j < second.length){
            if(first[i] < second[j]){
                merged[k] = first[i];
                i++;
            } else {
                merged[k] = second[j];
                j++;
            }
            k++;
        }

        while (i < first.length){
            merged[k] = first[i];
            i++;
            k++;

        }

        while (j < second.length){
            merged[k] = second[j];
            j++;
            k++;
        }

        return merged;
    }
    

}
