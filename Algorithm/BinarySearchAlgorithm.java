package Algorithm;

public class BinarySearchAlgorithm  {
    public static void main(String[] args) {
        //int [] input = {2,4,6,8,9,10,12,14};
        char[] letters = {'c', 'f', 'g'};
        System.out.println(
                findTheSmallestCharInAnArray(letters, 'c' )
        );

    }

    private static int binarySearchForAscSortedArray(int[] array, int target){
        int start = 0;
        int end = array.length -1;
        while (start<= end){
            int mid = start + (end -start)/2;
            if (target < array[mid]){
                end = mid -1;
            }else if (target > array[mid]){
                start = mid +1;
            }else {
                // target found
                return mid;
            }
        }
        return -1;
    }

    private static int binarySearchForDscSortedArray(int[] array, int target){
        int start = 0;
        int end = array.length -1;
        while (start<= end){
            int mid = start + (end -start)/2;
            if (target > array[mid]){
                end = mid -1;
            }else if (target < array[mid]){
                start = mid +1;
            }else {
                // target found
                return mid;
            }
        }
        return -1;
    }


    private static int unknownSortedOrderBinarySearch(int[] array, int target){
        int start = 0;
        int end = array.length -1;
        boolean isAscOrder = (array[start] < array[end]);

        while (start<= end){
            int mid = start + (end - start)/2;
            if (array[mid] == target) {return  mid;}
            if (isAscOrder){
                if (target < mid){
                    end = mid -1;
                }else{
                    start = mid + 1;
                }
            }else{
                if (target > array[mid]){
                    end = mid - 1;
                }else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }


    private static int binarySearchAlgorithmWithRecursion(int[] array, int target, int start, int end){
        if (start > end){
            return -1;
        }

        int m = start + (end - start)/2;
        if (array[m] == target){
            return m;
        }

        if (target < array[m]){
            return binarySearchAlgorithmWithRecursion(array, target, start, m-1);
        }
        return binarySearchAlgorithmWithRecursion(array, target, m+1, end);

    }


    //<<------------ INTERVIEW QUESTION --------->>
    // 1.  Ceiling : is the least number in an array greater than or equal to target number
    private static int findCeilingInAscSortedArray(int[] array, int target){
        int start = 0;
        int end = array.length -1;
        while (start<= end){
            int mid = start + (end -start)/2;
            if (target < array[mid]){
                end = mid -1;
            }else if (target > array[mid]){
                start = mid +1;
            }else {
                // target found
                return mid;
            }
        }
        return start;
    }

    //<<------------ INTERVIEW QUESTION --------->>
    // 2.  Floor of a number :  is the greatest number in an array less than or equal to target number
    private static int findFloorInAscSortedArray(int[] array, int target){
        int start = 0;
        int end = array.length -1;
        while (start<= end){
            int mid = start + (end -start)/2;
            if (target < array[mid]){
                end = mid -1;
            }else if (target > array[mid]){
                start = mid +1;
            }else {
                // target found
                return mid;
            }
        }
        return end;
    }

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


    //4. Leetcode 34. (facebook question)
    // Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
    //If target is not found in the array, return [-1, -1].
    //You must write an algorithm with O(log n) runtime complexity.


    public int[] searchRange(int[] nums, int target){
        int[] ans = {-1, -1};

        ans[0] = search(nums, target, true);
        if (ans[0] != -1){
            ans[1] = search(nums, target, false);
        }

        return ans;
    }

    //returns the index value of target
    int search(int[] nums, int target, boolean firstStartIndex){
        int ans = -1;
        int start = 0;
        int end = nums.length -1;

        while (start <= end){
            int mid = start + (end - start)/2;

            if (target < nums[mid]){
                end = mid -1;
            }else if (target > nums[mid]){
                start = mid + 1;
            }else {
                // potential ans found
                ans = mid;
                if (firstStartIndex){
                    end = mid -1;
                }else {
                    start = mid + 1;
                }
            }

        }

        return ans;
    }


    // Search in an infinite array

    static int ans(int[] array, int target){
        int start = 0;
        int end = 1;

        while (target > array[end]){
            int newStart = end + 1;

            end = end + (end - start + 1) * 2;
            start = newStart;
        }

        return binarySearch(array, target, start, end);
    }

    static int binarySearch(int[] array, int target, int start, int end){
        while (start <= end){
            int mid = start + (end - start)/2;

            if (target < array[mid]){
                end = mid - 1;
            } else if (target > array[mid]) {
                start = mid + 1;

            }else{
                return mid;
            }
        }

        return -1;
    }

    public int peakIndexMountainArray(int[]  arr){
        int start = 0;
        int end = arr.length -1;

        while (start < end){

            int mid = start + (end - start)/2;

            if (arr[mid] < arr[mid + 1]){

                start = mid + 1;

            } else {
                end = mid;
            }
        }

        return start; // or end

    }



}
