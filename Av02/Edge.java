package Av02;
import Av02.Node;

public class Edge {
    Node arrival;
    int weight;

    public Edge(Node arrival, int weight) {
        this.arrival  = arrival;
        this.weight = weight;
    }
}
