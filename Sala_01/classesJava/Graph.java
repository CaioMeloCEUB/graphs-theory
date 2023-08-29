package classesJava;
import classesJava.Node;
import java.util.List;

public class Graph {
    private String name;
    private List<Node> vertexes;
    
    public Graph(String n, List<Node> list) {
        this.name = n;
        this.vertexes = list;
    }
}
