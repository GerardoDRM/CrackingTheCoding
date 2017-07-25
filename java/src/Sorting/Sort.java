package Sorting;

/**
 * Created by gerardo on 25/07/17.
 */
public class Sort {

    public static void bubbleSort(int [] array) {
        int swapCounter = 0;
        for(int i=0; i<array.length; i++) {
            for(int j=0; j<array.length - 1; j++) {
                if(array[i] > array[j+1] ) {
                    swapCounter++;
                    int temp = array[i];
                    array[i] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        System.out.println(swapCounter);
    }
}
