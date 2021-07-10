import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;

import java.util.Vector;

public class GraphManager {

    public static void createGraph(Vector<Vector<Integer>> matrix, Vector<String> nodes, Vector<String> arcs,
            Graph<String, String> graph) {
        int i = 0;
        while (i < matrix.size()) {
            int j = 0;
            while (j < matrix.get(i).size()) {
                if (matrix.get(i).get(j) == 0) {
                    graph.addEdge("Exception_" + i + j, nodes.get(i), nodes.get(j), EdgeType.DIRECTED);
                } else if (matrix.get(i).get(j) > 0) {
                    graph.addEdge(arcs.get(matrix.get(i).get(j) - 1) + "_" + i + j, nodes.get(i), nodes.get(j),
                            EdgeType.DIRECTED);
                }
                j++;
            }
            i++;
        }
    }
}
