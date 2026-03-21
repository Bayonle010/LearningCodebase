package Algorithm.binarySearch;

public class FindSmallestCharInAnArray {
    // 3.  Given a characters array letters that is sorted in non-decreasing order and a character target,
    //    return the smallest character in the array larger than target.
    private static char findTheSmallestCharInAnArray(char [] letters, char target){
        int start = 0;
        int end = letters.length -1;
        while (start<= end){
            int mid = start + (end -start)/2;
            if (target < letters[mid]){
                end = mid -1;
            }else{
                start = mid +1;
            }
        }
        return letters[start % letters.length];
    }
}
