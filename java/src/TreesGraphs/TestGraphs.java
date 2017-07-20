package TreesGraphs;

/**
 * Created by gerardo on 20/07/17.
 */
public class TestGraphs {

    public static void testBFS() {
        GraphNode n = new GraphNode(0);
        GraphNode subn1 = new GraphNode(1);
        GraphNode subn2 = new GraphNode(3);
        GraphNode subn3 = new GraphNode(2);
        GraphNode subn4 = new GraphNode(4);
        GraphNode subn5 = new GraphNode(5);

        subn3.nodes.add(subn1);
        subn2.nodes.add(subn3);
        subn1.nodes.add(subn2);

        n.nodes.add(subn1);
        n.nodes.add(subn4);
        n.nodes.add(subn5);

        SearchGraphs.bfs(n);
    }


}
