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

        // Problem 5
        System.out.println(ac.checkStringsOp("pale", "bale"));
        System.out.println(ac.checkStringOpV2("pales", "pale"));

        // Problem 6
        System.out.println(ac.compressString("aabcccaaaad"));

        // Problem 7
        int [][] matrix = {{0,0,1},
                           {1,0,1},
                           {1,1,1}};
//        int [][] matrix1 = ac.rotateMatrix(matrix);
//        for(int i=0; i< matrix1.length; i++) {
//            for(int j=0; j< matrix1[0].length; j++) {
//                System.out.print(matrix1[i][j]);
//            }
//            System.out.println("");
//        }

        System.out.println("");

        int [][] matrix2 = ac.rotateMatrixV2(matrix);
        for(int i=0; i< matrix2.length; i++) {
            for(int j=0; j< matrix2[0].length; j++) {
                System.out.print(matrix2[i][j]);
            }
            System.out.println("");
        }


        // Problem 9
        System.out.println(ac.checkRotation("waterbottle", "erbottlewat"));

    }
}
