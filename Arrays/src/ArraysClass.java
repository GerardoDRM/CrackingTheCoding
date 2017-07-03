import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by gerardo on 26/06/17.
 */
class ArraysClass {

    // Using another data structure
    boolean isUniqueV1(String word) {
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


    boolean isUniqueV2(String word) {
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
    boolean checkPermutationV1(String a, String b) {
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
    boolean checkPermutationV2(String a, String b) {
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

    // URLify with loop
    String getURLify(String url, int size) {
        char [] urlChars = url.toCharArray();
        char [] urlCorrect = new char [urlChars.length];
        int j=0;
        for(int i=0; i<size; i++) {
            if(urlChars[i] == ' ') {
                urlCorrect[j] = '%';
                urlCorrect[j+1] = '2';
                urlCorrect[j+2] = '0';
                j += 3;
            } else {
                urlCorrect[j] = urlChars[i];
                j += 1;
            }
        }
        return String.valueOf(urlCorrect);
    }


    // URLify second version
    String getURLifyv2(String url, int size) {
        int counter = 0;
        char [] urlChar = url.toCharArray();
        for (int j =0; j<size; j++) {
            if(urlChar[j] == ' ') {
                counter+=1;
            }
        }

        int idx = size + (counter * 2) - 1;

        for(int i=size-1; i > 0; i--) {
            if(urlChar[i] == ' ') {
                urlChar[idx] = '0';
                urlChar[idx-1] = '2';
                urlChar[idx-2] = '%';
                idx-=3;
            } else {
                urlChar[idx] = urlChar[i];
                idx--;
            }
        }

        return String.valueOf(urlChar);
    }

    // Check if a string can be a permutation from a palindrome
    boolean checkPalindromePermutation(String word) {
        Map<Character, Integer> palindrome = new Hashtable<Character, Integer>();
        word = word.toLowerCase();
        for(char w : word.toCharArray()) {
            if(palindrome.containsKey(w)) {
                palindrome.put(w, palindrome.get(w) + 1);
            } else if(!palindrome.containsKey(w) && w != ' ') {
                palindrome.put(w, 1);
            }
        }

        boolean palindrome_validation = false;
        int counter = 0;
        for (Map.Entry<Character, Integer> w : palindrome.entrySet()) {
            if(w.getValue() % 2 != 0) {
                counter+=1;
            }
        }

        if(counter <= 1) {
            palindrome_validation = true;
        }

        return palindrome_validation;
    }

    // String operations can be (insert, remove, replace)
    // This method checks from 2 strings if an op was applied
    // This method assume that second word comes from first one
    boolean checkStringsOp(String word1, String word2) {
        // Check if was just an insert or remove or if there were not changes
        if(word2.length() == word1.length()-1 || word2.length() == word1.length()+1 || word1.equalsIgnoreCase(word2)) {
            return true;
        } // If the action was a replacement then check how many
        else if(word1.length() == word2.length()) {
            int changes = 0;
            for(int i=0; i<word1.length(); i++) {
                if(word1.charAt(i) != word2.charAt(i))
                    changes+=1;
            }
            return changes <= 1;
        } else  { // Has more than one changes
            return false;
        }
    }

    // Second Solution for String Ops
    boolean checkStringOpV2(String word1, String word2) {
        if(word2.length() == word1.length()-1 || word2.length() == word1.length()+1 || word1.length() == word2.length()) {
            int changes = 0;
            int idx = 0;
            String s1 = word1.length() >= word2.length() ? word1:word2;
            String s2 = word1.length() < word2.length() ? word1:word2;
            // Iterate over largest word
            for(int i=0; i<s1.length(); i++) {
                if(i >= s2.length())
                    break;

                if(word1.charAt(i) != word2.charAt(i))
                    changes+=1;
            }
            return changes <= 1;
        } else {
            return false;
        }

    }
}
