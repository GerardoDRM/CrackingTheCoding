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

}
