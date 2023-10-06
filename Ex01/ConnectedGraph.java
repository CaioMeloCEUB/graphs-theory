package Ex01;

import java.util.*;

public class ConnectedGraph {
    public static boolean checkConnected(Graph graph) {
        if (graph.nodes.isEmpty()) {
            return true;
        }
        Node initNode = graph.nodes.get(0);

        Set<Node> passedNode = new HashSet<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(initNode);
        passedNode.add(initNode);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            for (Edge edge : currentNode.edges) {
                Node arrivalNode = edge.arrival;

                if (!passedNode.contains(arrivalNode)) {
                    passedNode.add(arrivalNode);
                    queue.add(arrivalNode);
                }
            }
        }
        return passedNode.size() == graph.nodes.size();
    }
}