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


    // Problem 4.5
    public boolean checkBST(int min, int max, TreeNode node) {
        if(node == null) return true;
        boolean bool_l = true, bool_r = true;

        if(node.val < max && node.val > min) {
            bool_l = checkBST(min, node.val, node.left);
            bool_r = checkBST(node.val, max, node.right);
        }
        return (bool_l && bool_r);
    }

    // Problem 4.6
    public TreeNode getMostLeft(TreeNode node) {
        if(node == null) return null;
        while(node.left != null) {
            node = node.left;
        }

        return  node;
    }
    public TreeNode successorInOrder(TreeNode node) {
        if(node == null) return null;

        if(node.right != null) {
            return getMostLeft(node.right);
        } else {
            TreeNode current = node;
            TreeNode parent = current.parent;
            while(parent != null && parent.left != current) {
                current = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }

    // Problem 4.8
    public TreeNode ancestorV1(TreeNode root, TreeNode n1, TreeNode n2) {
        if(root == null) return null;
        if (root == n1 || root == n2) return root;
        TreeNode nLeft = ancestorV1(root.left, n1, n2);
        TreeNode nRight = ancestorV1(root.right, n1, n2);

        if(nLeft != null && nRight != null) return root;

        return nLeft.left != null ? nLeft : nRight;

    }


    // Problem 4.8
    public TreeNode ancestorBST(TreeNode root, TreeNode n1 , TreeNode n2) {
        if(root == null)return null;
        if(root.val < n1.val && root.val < n2.val)
            return ancestorBST(root.right, n1, n2);
        if(root.val > n1.val && root.val > n2.val)
            return ancestorBST(root.left, n1, n2);

        return root;
    }




}
