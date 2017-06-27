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
    

}
