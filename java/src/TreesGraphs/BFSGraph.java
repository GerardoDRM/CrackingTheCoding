package TreesGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by gerardo on 13/08/17.
 */
public class BFSGraph {

    private int size;
    private ArrayList<List<Integer>> nodes;

    BFSGraph(int size) {
        this.size = size;
        nodes = new ArrayList<List<Integer>>();

        for(int i=0; i<size; i++) {
            nodes.add(new ArrayList<Integer>());
        }

    }

    public void addEdge(int first, int second) {
        nodes.get(first).add(second);
        nodes.get(second).add(first);
    }

    public int[] shortestReach(int startId) { // 0 indexed
        int [] distances = new int[size];
        Arrays.fill(distances, -1);
        LinkedList<Integer> q = new LinkedList<>();

        q.add(startId);
        distances[startId] = 0;

        while(!q.isEmpty()) {
            int n = q.poll();
            for(int i : nodes.get(n)) {
                if(distances[i] == -1) {
                    distances[i] = distances[n] + 6;
                    q.add(i);
                }
            }
        }

        return distances;

    }



}
