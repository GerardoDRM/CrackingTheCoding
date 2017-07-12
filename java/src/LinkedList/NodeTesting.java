package LinkedList;

import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;

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

    // Problem 3
    public Node deleteMiddle(Node node) {
        Node prev = null;
        Node current = node;
        while(current.next != null) {
            current.value = current.next.value;
            prev = current;
            current = current.next;
        }
        prev.next = null;
        return node;
    }

    // Problem 4
    public Node linkedPartition(Node head, int partition){
        Node left = null;
        Node right = null;
        Node first_left = null;
        Node first_right = null;

        while(head != null) {
            // Compare with partition
            // If is greater than partition goes to right
            if(head.value > partition) {
                if(right == null) {
                    right = new Node(head.value, null);
                    first_right = right;
                } else {
                    System.out.println(head.value);
                    right.next = new Node(head.value, null);
                    right = right.next;
                }
            }
            // If is less than partition goes to left
            else {
                if(left == null) {
                    left = new Node(head.value, null);
                    first_left = left;
                } else {
                    left.next = new Node(head.value, null);
                    left = left.next;
                }
            }
            head = head.next;
        }
        left.next = first_right;

        return first_left;
    }

    public Node linkedSum(Node a, Node b) {
        Node new_node = null;
        Node first = null;
        int sum = 0, quotient = 0, remainder = 0;
        // Iterate over
        while(a != null || b != null) {
            int val_1 = a!= null ? a.value : 0;
            int val_2 = b!= null ? b.value : 0;

            sum = val_1 + val_2 + quotient;
            quotient = sum / 10;
            remainder = sum % 10;

            // Add the result to new node
            if(new_node == null) {
                new_node = new Node(remainder, null);
                first = new_node;
            } else {
                new_node.next = new Node(remainder, null);
                new_node = new_node.next;
            }


            a = a!=null ? a.next : null;
            b = b!= null ? b.next : null;
        }
        return first;
    }

    public boolean linkedPalindrome(Node node) {
        Stack<Node> stack = new Stack();
        Node pointer1 = node;
        Node pointer2 = node;
        while(pointer1 != null){
            stack.push(pointer1);
            pointer1 = pointer1.next;
        }

        while(pointer2 != null) {
            Node n = stack.pop();
            if (n.value != pointer2.value) {
                return false;
            }
            pointer2 = pointer2.next;
        }
        return true;
    }
}
