import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {

    private List<Node> nodes;
    private Set<Edge> edges;


    public Graph() {
        this.nodes = new ArrayList<Node>();
        this.edges = new HashSet<Edge>();
    }

    public void addNode(Node n) {
        this.nodes.add(n);
    }

    public void addEdge(Edge e) {
        this.edges.add(e);
    }

    public void printGraph() {
        for(Edge e: this.edges) {
            e.print();
        }
    }
}
