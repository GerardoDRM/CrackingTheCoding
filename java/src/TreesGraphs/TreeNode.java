package TreesGraphs;

import java.util.ArrayList;

/**
 * Created by gerardo on 21/07/17.
 */
public class TreeNode {


    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;

    TreeNode(int value) {
        this.val = value;
        left = null;
        right = null;
        parent = null;
    }
}
