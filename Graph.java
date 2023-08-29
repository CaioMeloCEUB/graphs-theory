import java.util.HashMap;
import java.util.List;

public class Graph {
    private List<Node> nodes;

    public void printNodes() {

        for (Node e : nodes) {
            System.out.println(e.getName());
            for (Node j : e.getNeighbours().keySet()) {
                System.out.printf("n" + j.getName() + " ");
            }
            System.out.println("\n");
        }

    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "nodes=" + nodes +
                '}';
    }
}
