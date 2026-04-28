package Algorithm;

public class FindDuplicate {
    public static void main(String[] args) {
        int[] array = {3,3,3,3,3,3};
        System.out.println(findDuplicate(array));
    }

    static int findDuplicate(int[] array){

        int i = 0;
        while(i < array.length){

            if (array[i] != i + 1){
                int current = array[i];
                int correctIndex = array[i] - 1;

                if (current != array[correctIndex]){
                    swap(array, i, correctIndex);
                }else {
                    return array[i];
                }
            }else {
                i++;
            }
        }

        return  -1;

    }

        static void swap(int[] array, int num1, int num2){
            int temp = array[num1];
            array[num1] = array[num2];
            array[num2] = temp;
        }
}
