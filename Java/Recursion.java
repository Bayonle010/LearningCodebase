package Java;

public class Recursion {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int ans = binarySearch(array, 4);
        int answer = binarySearchRecursion(array, 4, 0, array.length -1);
        System.out.println(ans);
        System.out.println(answer);
    }


    static void print(int n){
        if (n == 5){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        print(n + 1);
    }

    // 0, 1, 1, 2, 3, 5, 8, 13, 21
    static int fibonnaci(int n){
        if (n == 0 || n == 1){
            return n;
        }

        return fibonnaci(n -1) + fibonnaci(n - 2);
    }


    static int binarySearch(int[] array, int target){
        int start = 0;
        int end = array.length -1;


        while (start <= end){

            int mid = start + (end - start)/2;

            if (array[mid] == target){
                return mid;
            } else if (array[mid] < target) {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }

        return -1;
    }


    static int binarySearchRecursion(int[] array, int target, int start, int end){

        if (start > end) return  -1;

        int mid = start + (end - start)/2;

        if (array[mid] == target){
            return mid;
        }

        if (array[mid] < target){
            return binarySearchRecursion(array, target, mid + 1, end);
        }

        return binarySearchRecursion(array, target, start, mid - 1);

    }
}
