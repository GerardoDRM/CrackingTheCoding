package LinkedList;

/**
 * Created by gerardo on 4/07/17.
 */
public class Node {

    public Node next;
    int value;

    Node(int val, Node next){
        this.value = val;
        this.next = next;
    }

    void appendToEnd(Node node) {
        Node current = this;
        while(current.next != null) {
            current = current.next;
        }
        current.next=node;
    }


    void removeNode(int val) {
        Node current = this;
        // It's the head just change for the next node
        if(current.value == val) {
            if(current.next != null) {
                current.value = current.next.value;
                current.next = current.next.next;
            } else {
                current = null;
            }

        } else {
            // It's another node
            Node prev = null;
            while(current != null) {

                if(current.value == val) {
                    prev.next = current.next;
                    break;
                }
                prev = current;
                current = current.next;
            }

        }
    }

    public void printList() {
        Node current = this;
        while(current != null) {
            System.out.print(current.value + "->");
            current = current.next;
        }
        System.out.print("NULL");
    }

}
