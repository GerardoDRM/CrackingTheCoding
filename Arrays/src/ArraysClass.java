import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gerardo on 26/06/17.
 */
public class ArraysClass {

    // Using another data structure
    public boolean isUniqueV1(String word) {
        Map<Character, Integer> words_hash = new HashMap<>();
        for(int w=0; w<word.length(); w++) {
            if (!words_hash.containsKey(word.charAt(w))) {
                words_hash.put(word.charAt(w), 1);
            } else {
                return false;
            }
        }
        return true;
    }


    public boolean isUniqueV2(String word) {
        char[] word_values = word.toCharArray();
        // This should change with own implementation
        Arrays.sort(word_values);
        for(int i=0; i<word_values.length; i++) {
            if (i+1 < word_values.length && word_values[i] == word_values[i+1]) {
                return false;
            }
        }
        return true;
    }

    // Check permutation with simple solution
    public boolean checkPermutationV1(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        char [] a_values = a.toCharArray();
        char [] b_values = b.toCharArray();

        Arrays.sort(a_values);
        Arrays.sort(b_values);

        return Arrays.equals(a_values, b_values);
    }

    // Check with Hash table
    public boolean checkPermutationV2(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        Map<Character, Integer> values = new HashMap<>();
        for(int i=0; i< a.length(); i++) {
            if(values.containsKey(a.charAt(i))) {
                values.put(a.charAt(i), values.get(a.charAt(i)) + 1);

            }
            if(!values.containsKey(a.charAt(i))) {
                values.put(a.charAt(i), 1);
            }


            if(values.containsKey(b.charAt(i))) {
                values.put(b.charAt(i), values.get(b.charAt(i)) + 1);

            }


            if (!values.containsKey(b.charAt(i))) {
                values.put(b.charAt(i), 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : values.entrySet()) {
            if(entry.getValue() % 2 != 0) {
                return false;
            }
       }

        return true;
    }





}
