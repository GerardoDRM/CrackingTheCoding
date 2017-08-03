package LinkedList;

import java.util.*;

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
        n.appendToEnd(new Node(3, null));
        n.appendToEnd(new Node(2, null));

        return n;
    }

    public Node createNodes(ArrayList<Integer> nodes) {
        Node newNode = null;
        for(Integer n : nodes) {
            if(newNode == null) {
                newNode = new Node(n, null);
            } else {
                newNode.appendToEnd(new Node(n, null));
            }
        }
        return newNode;
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

    public Node linkedIntersection(Node a, Node b) {
        Node a_l = a;
        Node b_l = b;
        int len_a = 0, len_b =0;
        while (a_l != null) {
            a_l = a_l.next;
            len_a+=1;
        }

        while (b_l != null) {
            b_l = b_l.next;
            len_b+=1;
        }

        // Check if tail of both list are the same
        if(a_l != b_l)
            return null;

        // Check longest list
        int sub = len_a >= len_b ? len_a-len_b : len_b - len_a;
        Node longest = null, shortest = null;
        if (len_a >= len_b) {
            longest = a;
            shortest = b;
        } else {
            longest = b;
            shortest = a;
        }

        // Cut off unwanted nodes
        for(int i=0; i<sub; i++)
            longest = longest.next;

        while(shortest != null) {
            if(longest == shortest)
                return longest;
            longest = longest.next;
            shortest = shortest.next;
        }

        return longest;
    }


    public Node linkedCircularV1(Node n) {
        HashMap<Node, Integer> map = new HashMap<>();

        while(n != null) {
            if(map.containsKey(n)) {
                return n;
            } else {
                map.put(n, n.value);
            }
            n = n.next;
        }
        return null;
    }

    public Node linkedCircularV2(Node n) {
        Node f1 = n;
        Node f2 = n;

        // Check for a collision
        while(f1 != null && f2 !=null) {
            f1  = f1.next;
            f2 = f2.next.next;

            if (f1 == f2) {
                break;
            }
        }

        // Check if is a circular list
        if (f1 == null || f2 == null)
            return null;

        // Get first Circular node head
        f2 = n;
        while(f1 != f2) {
            f1 = f1.next;
            f2 = f2.next;
        }

        return f1;
    }

    boolean hasCycle(Node head) {
        Node n1 = head;
        Node n2 = head;

        while(n1 != null && n2 != null) {
            n1 = n1.next;
            n2 = n2.next.next;

            if(n1 == n2)
                return true;
        }

        return false;
    }






}
