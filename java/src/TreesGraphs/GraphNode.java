package TreesGraphs;

import java.util.ArrayList;

/**
 * Created by gerardo on 19/07/17.
 */
public class GraphNode {

    public int val;
    public boolean visited;
    public ArrayList<GraphNode> nodes;

    GraphNode(int value) {
        this.val = value;
        visited = false;
        nodes = new ArrayList<>();
    }
}
