package LinkedList;

import java.util.Hashtable;
import java.util.Map;

/**
 * Created by gerardo on 4/07/17.
 */
public class NodeTesting {

    public void basicOps() {
        // Create value
        Node n = new Node(2, null);
        n.appendToEnd(new Node(3, null));
        n.appendToEnd(new Node(4, null));

        // Print
        n.printList();

        System.out.println("");

        // Delete values
        n.removeNode(2);
        n.printList();
    }

    public Node createNodes() {
        Node n = new Node(2, null);
        n.appendToEnd(new Node(3, null));
        n.appendToEnd(new Node(4, null));
        n.appendToEnd(new Node(4, null));
        n.appendToEnd(new Node(1, null));

        return n;
    }

    // Problem 1 with hashmap
    public Node removeDup(Node head) {
        Map<Integer, Node> unique = new Hashtable<>();
        Node newList = head;
        int first_value = head.value;
        unique.put(head.value, newList);
        while(head != null) {
            if(!unique.containsKey(head.value)) {
                unique.put(head.value, newList);
                newList.next = head;
                newList = newList.next;
            }
            head = head.next;
        }
        return unique.get(first_value);
    }

    // Problem 1 without temp buffer
    public void removeDupV2(Node head) {
        Node firstPointer = head;
        // Create two pointers
        while(firstPointer != null) {
            Node secondPointer=firstPointer;
            while(secondPointer.next !=null) {
                if(firstPointer.value == secondPointer.next.value) {
                    secondPointer.next = secondPointer.next.next;
                } else {
                    secondPointer = secondPointer.next;
                }


            }
            firstPointer = firstPointer.next;
        }
    }


    // Problem 2 recursive
    public int getKthPos(Node head, int k, int depth) {
        if(head.next != null)
            depth += getKthPos(head.next, k, depth);

        if(depth == k)
            System.out.println(head.value);
        return depth + 1;
    }

    // Problem 2 iterative
    public int getKthPosV2(Node head, int k){
        Node prev = head;
        Node current = head;

        for(int i=0; i<k; i++) {
            current = current.next;
        }

        while(current != null) {
            prev = prev.next;
            current = current.next;
        }

        return prev.value;

    }
}
