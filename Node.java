import java.util.HashMap;

public class Node {

    private HashMap<Node, Double> connectedTo;

    private String name;


    public Node(HashMap<Node, Double> connectedTo, String name) {
        this.connectedTo = connectedTo;
        this.name = name;
    }

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public HashMap<Node, Double> getConnectedTo() {
        return connectedTo;
    }

    public void setConnectedTo(HashMap<Node, Double> connectedTo) {
        this.connectedTo = connectedTo;
    }
}