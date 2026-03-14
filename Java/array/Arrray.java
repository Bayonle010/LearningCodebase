package Java.array;

import java.util.Arrays;

public class Arrray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 23,9, 18};
//        swap(arr, 0,4);
//        System.out.println(Arrays.toString(arr));

        System.out.println(max(arr));
        reverse(arr);
        System.out.println(Arrays.toString(arr));

    }


    static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    static int max(int[] arr){
        int ans = arr[0];
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > ans){
                ans = arr[i];
            }
        }
        return ans;
    }

    static void reverse(int[] arr){
        int start = 0;
        int end = arr.length - 1;

        while (start < end){
            swap(arr, start, end);
            start++;
            end--;
        }

    }
}
