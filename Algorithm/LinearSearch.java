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
}
