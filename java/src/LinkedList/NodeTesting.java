package LinkedList;

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
}
