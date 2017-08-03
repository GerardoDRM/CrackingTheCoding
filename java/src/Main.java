import LinkedList.Node;
import LinkedList.NodeTesting;
import Sorting.Sort;
import StacksQueues.StacksQueuesSolutions;
import TreesGraphs.TestGraphs;

import java.util.*;

/**
 * Created by gerardo on 26/06/17.
 */
public class Main {

    public static void main(String args[]) {

        /**
         * Problem 1 Arrays.ArraysClass
         */
        ArraysSolutions.ArraysClass ac = new ArraysSolutions.ArraysClass();
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
        int [][] matrix1 = ac.rotateMatrix(matrix);
        for(int i=0; i< matrix1.length; i++) {
            for(int j=0; j< matrix1[0].length; j++) {
                System.out.print(matrix1[i][j]);
            }
            System.out.println("");
        }

        int [][] matrix2 = ac.rotateMatrixV2(matrix);
        for(int i=0; i< matrix2.length; i++) {
            for(int j=0; j< matrix2[0].length; j++) {
                System.out.print(matrix2[i][j]);
            }
            System.out.println("");
        }


        // Problem 9
        System.out.println(ac.checkRotation("waterbottle", "erbottlewat"));


        // Problem 2.0
        NodeTesting linked = new NodeTesting();
        linked.basicOps();
        // Problem 2.1
        Node dup = linked.removeDup(linked.createNodes());
        dup.printList();
        linked.removeDupV2(linked.createNodes());

        // Problem 2.2
        System.out.println("");
        linked.getKthPos(linked.createNodes(), 0, 0);
        System.out.println(linked.getKthPosV2(linked.createNodes(), 5));

        // Problem 2.3
        System.out.println("");
        Node headMiddle = linked.createNodes();
        for(int i=0; i<2; i++)
            headMiddle = headMiddle.next;
         Node nodeMiddle = linked.deleteMiddle(headMiddle);
         nodeMiddle.printList();

         // Problem 2.4
        System.out.println("");
        Node nodePartition = linked.linkedPartition(linked.createNodes(), 3);
        nodePartition.printList();

        // Problem 2.5
        System.out.println("");
        Node nodeSum = linked.linkedSum(linked.createNodes(), linked.createNodes());
        nodeSum.printList();

        // Problem 2.6
        System.out.println("");
        System.out.println(linked.linkedPalindrome(linked.createNodes()));

        // Problem 2.7
        System.out.println("");
        ArrayList<Integer> n1s = new ArrayList<>();
        n1s.add(1);
        n1s.add(3);
        ArrayList<Integer> n2s = new ArrayList<>();
        n2s.add(3);
        n2s.add(5);
        n2s.add(8);
        ArrayList<Integer> n3s = new ArrayList<>();
        n3s.add(2);
        n3s.add(9);
        n3s.add(19);
        Node l1 = linked.createNodes(n1s);
        Node l2 = linked.createNodes(n2s);
        Node l3 = linked.createNodes(n3s);

        // Get Last
        Node last_l1 = l1;
        Node last_l2 = l2;
        while(last_l1.next != null) {
            last_l1 = last_l1.next;
        }

        while(last_l2.next != null) {
            last_l2 = last_l2.next;
        }

        last_l1.next = l3;
        last_l2.next = l3;

        Node in = linked.linkedIntersection(l1,l2);
        in.printList();


        // Problem 2.8
        System.out.println("");
        ArrayList<Integer> n1c = new ArrayList<>();
        n1c.add(1);
        n1c.add(3);
        n1c.add(1);
        n1c.add(10);
        n1c.add(2);
        n1c.add(8);
        n1c.add(14);
        Node nc1 = linked.createNodes(n1c);
        Node lastNc1 = nc1;
        Node mid = nc1;

        while(lastNc1.next !=null){
            lastNc1 = lastNc1.next;
        }

        for(int i=0; i<2; i++)
            mid = mid.next;

        // Add  circular reference
        lastNc1.next = mid;
        Node resCircular = linked.linkedCircularV2(nc1);
        System.out.println(resCircular.value);

        // Problem 3.1
        System.out.println("PROBLEMS STACK AND QUEUES");
        StacksQueuesSolutions sq = new StacksQueuesSolutions();
        sq.createMultiStack();
        // Problem 3.2
        sq.searchMin();
        // Problem 3.3
        sq.checkSetOfStacks();
        // Problem 3.4
        sq.checkQueue();
        // Problem 3.6
        sq.checkAnimalQueue();


        /////////////////////////////////
        //// Problems 4 ////////////////
        ////////////////////////////////
        System.out.println("");
        System.out.println("PROBLEMS 4");
        TestGraphs.testBFS();


        //////////////////////////////
        /////// Problems 5 //////////
        /////////////////////////////
        System.out.println("");
        System.out.println("PROBLEMS 5");
        ArrayList<int[]> v = Sort.anagrams2("anagram", "granma");
        for(int[] a : v) {
            System.out.println(a[0]+ "-" + a[1]);
        }

    }
}
