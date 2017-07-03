import java.util.*;

/**
 * Created by gerardo on 26/06/17.
 */
public class Main {

    public static void main(String args[]) {

        /**
         * Problem 1 ArraysClass
         */
        ArraysClass ac = new ArraysClass();
        System.out.println(ac.isUniqueV1("hello"));
        System.out.println(ac.isUniqueV2("smile"));

        // Problem 2
        System.out.println(ac.checkPermutationV1("hello", "elloh"));
        System.out.println(ac.checkPermutationV2("hello", "lleho"));

        // Problem 3
        System.out.println(ac.getURLify("Mr John Smith    ", 13));
        System.out.println(ac.getURLifyv2("Mr John Smith    ", 13));

        // Problem 4
        System.out.println(ac.checkPalindromePermutation("Tact Coa"));


    }
}
