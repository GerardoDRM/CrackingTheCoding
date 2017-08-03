package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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

    // Ranson Note
    public static boolean subMessage(String[] n, String []n2) {
        HashMap<String, Integer> values = new HashMap<>();
        for(String s1:n) {
            if(values.containsKey(s1))
                values.put(s1, values.get(s1) + 1);
            else
                values.put(s1, 1);

        }


        for (String s2:n2) {
            if(!values.containsKey(s2) || values.get(s2)-1 <= 0) {
                return false;
            } else {
                values.put(s2, values.get(s2) -1);
            }
        }
        return true;
    }


    // Quick Sort
    public static void  quicksort(int[] array) {
        quicksort(array, 0, array.length);
    }

    private static void quicksort(int[] array, int left, int right) {
        if(left<=right) return;
        // Get pivot
        int pivot = (left+right) / 2;
        int index = partition(array, left, right, pivot);
        quicksort(array, left, index-1);
        quicksort(array, index, right);
    }

    private static int partition(int[] array, int left, int right, int p) {
        while(left<=right) {
            while(array[left] < p) {
                left++;
            }
            while(array[right] < p) {
                left--;
            }

            if(left <= right) {
                int temp = array[left];
                array[temp] = array[right];
                array[right] = temp;
                right--;
                left++;
            }
        }
        return left;
    }


    // Amazon Interview
    public static ArrayList<int[]> anagrams2(String s1, String s2) {
        char [] s2_c = s2.toCharArray();
        Arrays.sort(s2_c);
        ArrayList<int[]> values = new ArrayList<>();

        for(int i=0; i<s1.length() - s2.length() + 1; i++) {
            String val = s1.substring(i,i+s2.length());
            char[] val_c = val.toCharArray();
            Arrays.sort(val_c);
            if(Arrays.equals(val_c,s2_c)) {
                int [] d = new int[2];
                d[0] = i;
                d[1] = i + s2.length() - 1;
                values.add(d);
            }
        }
        return values;
    }


}
