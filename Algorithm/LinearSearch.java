package Algorithm;

public class LinearSearch {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int ans = linearSearch(nums, 5);
        System.out.println(ans);
    }

    static int linearSearch(int[] array, int target){
        if (array.length == 0){
            return -1;
        }

        //run a for loop
        for (int i =0; i<= array.length; i++){
            int element = array[i];
            if (element == target){
                return i;
            }
        }
        return -1;

    }

    static boolean searchInString(String str, char target){
        if (str.isEmpty()){
            return false;
        }
        for (char ch: str.toCharArray()){
            if (ch == target){
                return true;
            }
        }
        return false;

    }


    // given an array below, search for 3 in the range of index[1,4]
   // int[] array = {18, 12, -7, 3, 14, 28};

    static boolean searchInRange(int[] arrays, int target, int start, int end){
        for (int i= start;  i<=end; i++){
            if (arrays[i] == target){
                return true;
            }
        }
        return false;
    }


    // finding the minimum numbers in an array
    static int min(int[] array){
        int ans = array[0];
        for (int i = 0; i< array.length; i++){
            if (array[i] < ans){
                ans = array[i];
            }
        }
        return ans;
    }

    // search for a target in 2D array
    static int[] searchForTargetIn2DArray(int[][] array, int target){
        for (int row = 0; row <= array.length; row++){
            for (int col = 0; col < array[row].length; col++){
                if (array[row][col] == target){
                    return new int[]{row, col};
                }
            }
        }
        return new int[]{-1, -1};
    }

    //Given an array of nums of integers, return how many of them contain an even number of digits
    //e.g nums = [12, 345, 2, 6, 7896
//    ans:is 2 because  12 and 7896  contain even number of digits;

    static int findEvenNumbers(int[] nums){
        int count = 0;
        for (int num : nums){
            if (even(num)){
                count++;
            }
        }
        return count;
    }

    private static boolean even(int num) {
        int numberDigit = digits(num);

        return numberDigit % 2 == 0;
    }

    //count the number of digit in a number: time complexity O(log(n)
    private static int digits(int num) {
        if (num ==0) return 1;
        if (num<0) num = -num;
        int count = 0;
        while(num > 0){
            count++;
            num = num/10;
        }
        return count;
    }

    //optimized method to count the number of digits in a number : time complexity O(1)
    // Using log10 to compute the number of digits
    // log10(num) gives the power of 10 needed to reach num
    // Adding 1 to account for the number of digits
    // Casting to int truncates the decimal and gives us the integer digit count
    private static int digits2(int num){
        if (num == 0) return 1;
        num = Math.abs(num);
        return (int)(Math.log10(num) + 1);
    }


}
