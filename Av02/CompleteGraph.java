package Av02;

public class CompleteGraph {
    public static boolean checkComplete(Graph graph) {
        int numNodes = graph.nodes.size();
        int numEdges = 0;

        for (Node node : graph.nodes) {
            numEdges += node.edges.size();
        }

        int maxEdges = (numNodes * (numNodes - 1)) / 2;

        return numEdges == maxEdges;
    }
}
