package Ex01;

import java.util.*;

public class CheckCircuitPath {
    public static String checkCircuitOrPath (List<Node> nodes) {
        int numNodes = nodes.size();

        Set<Node> setNodes = new HashSet<>(nodes);
        if (setNodes.size() != numNodes) {
            return "It is not a circuit or a path, repeated nodes\n";
        }

        boolean path = true;
        boolean circuit = false;

        for (int i = 0; i < numNodes - 1; i++) {
            Node origin = nodes.get(i);
            Node arrival =  nodes.get( + 1);

            boolean edgeFound = false;
            for (Edge edge : origin.edges) {
                if (edge.arrival == arrival) {
                    edgeFound = true;
                    break;
                }
            }
            
            if (!edgeFound) {
                path = false;
                break;
            }
        }

        if (nodes.get(0).equals(nodes.get(numNodes - 1))) {
            circuit = true;
        }

        if (path && circuit) {
            return "It's a path and a circuit\n";
        } else if (path) {
            return "It's a path\n";
        } else if (circuit) {
            return "It's a circuit\n";
        } else {
            return "It's not a circuit or a path\n";
        }
    }
}