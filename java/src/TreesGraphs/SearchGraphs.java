package TreesGraphs;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by gerardo on 19/07/17.
 */
public class SearchGraphs {

    // Depth first search
    public static void dfs(GraphNode node) {
        if(node == null) return;
        node.visited = true;
        System.out.println(node.val);
        for(GraphNode n : node.nodes) {
            if(!n.visited) {
                dfs(n);
            }
        }
    }


    // Brief first search
    public static void bfs(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
        node.visited = true;
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode n = (GraphNode) queue.poll();
            System.out.println(n.val);
            for (GraphNode nc : n.nodes) {
                if (!nc.visited) {
                    nc.visited = true;
                    queue.add(nc);
                }
            }
        }
    }


    // Problem 4.2
    public static TreeNode minH(int [] array, int start, int end) {
        int middle = (start + end) / 2;
        TreeNode n = new TreeNode(array[middle]);
        n.left = minH(array, start, middle-1);
        n.right = minH(array, middle+1, end);

        return n;
    }


    // Problem 4.4
    private static int getHeight(TreeNode node) {
        if(node == null) return 0;
        return Math.max(getHeight(node.left), getHeight(node.right)) +1;
    }
    public static boolean checkBalanced(TreeNode node) {
        // GET RIGHT AND LEFT LEAFS
        int h_left = getHeight(node.left);
        int h_right = getHeight(node.right);

        if(h_left - h_right >1) {
            return false;
        }
        return true;
    }


}
