import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Matrix {

    private Set<Node> nodes = new HashSet<>();

    public Matrix(Set<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node node){
        this.nodes.add(node);
    }

    public Matrix(){

    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }
}
