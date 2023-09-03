package Av02;

import java.util.*;

public class Graph {
    List<Node> nodes;

    public Graph(int numNodes) {
        nodes = new ArrayList<>();

        for (int i = 0; i < numNodes; i++) {
            nodes.add(new Node(i, "Node " + i));
        }
    }

    public void addEdge(int origin, int arrival, int weight) {
        Node nodeOrigin = nodes.get(origin);
        Node nodeArrival = nodes.get(arrival);
        nodeOrigin.addEdge(nodeArrival, weight);
        nodeArrival.addEdge(nodeOrigin, weight);
    }
}