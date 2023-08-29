package Av02;
import java.util.*;
import Av02.Edge;
 
public class Node {
    int id;
    String name;
    List<Edge> edges;

    public Node(int idNode, String nameNode) {
        this.id = idNode;
        this.name = nameNode;
        edges = new ArrayList<>();
    }

    /*public void addEdge(Node arrival, int weight) {
        edges.add(new Edge(arrival, weight));
    }*/
}