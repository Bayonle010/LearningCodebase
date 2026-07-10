package Algorithm.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {5, 3, 8, 1, 4, 7, 2};

        quickSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }

    static void quickSort(int[] array, int low, int high) {

        if (low >= high) {
            return;
        }

        int pivotIndex = partition(array, low, high);

        quickSort(array, low, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, high);
    }

    static int partition(int[] array, int low, int high) {

        int middle = low + (high - low) / 2;

        // Move the middle pivot to the end
        swap(array, middle, high);

        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        // Move the pivot to its correct sorted position
        swap(array, i + 1, high);

        return i + 1;
    }

    static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}