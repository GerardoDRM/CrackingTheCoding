package Amazon;

import TreesGraphs.TreeNode;

import java.util.*;

/**
 * Created by gerardo on 29/07/17.
 */
public class AmazonTest {

    public int golfField(List<List<Integer>> values) {
        HashMap<int[], Integer> objetives = new HashMap<>();
        for(int i=0; i < values.size(); i++){
            for(int j=0; j< values.get(i).size(); j++) {
                if(values.get(i).get(j) >= 2) {
                    int[] coord = new int[2];
                    coord[0] = i;
                    coord[1] = j;
                    objetives.put(coord, values.get(i).get(j));
                }
            }
        }

        // Sort Map

        return -1;
    }

    private int walk(List<Integer> coords, List<Integer> obj) {
        return 0;
    }



    public void verticalSum(int pos, HashMap<Integer, Integer> cols, TreeNode node) {
        if(node == null) return;

        if(cols.containsKey(pos)) {
            cols.put(pos, cols.get(pos) + node.val);
        } else {
            cols.put(pos, 0);
        }

        verticalSum(pos - 1, cols, node.left);
        verticalSum(pos+1, cols, node.right);
    }


    public void treeMaxWidth(TreeNode n) {
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        int max = 1;
        n.visited = true;
        q.add(n);

        while(!q.isEmpty()) {
            TreeNode n1 = q.poll();

            if(n1.left != null && !n1.left.visited) {
                n1.left.visited = true;
                q.add(n1.left);
            }

            if(n1.right != null && !n1.right.visited) {
                n1.right.visited = true;
                q.add(n1.right);
            }

            if(q.size() > max) {
                max = q.size();
            }
        }

        System.out.println(max);
    }

}
