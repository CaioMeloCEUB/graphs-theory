import java.util.HashMap;
import java.util.List;

public class Node {
    private String name;
    private HashMap<Node, Double> neighbours;

    public Node(String name) {
        this.name = name;
    }

    public Node(String name, HashMap<Node, Double> neighbours) {
        this.name = name;
        this.neighbours = neighbours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Node, Double> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(HashMap<Node, Double> neighbours) {
        this.neighbours = neighbours;
    }

    public int findDegree(){
        return this.neighbours.size();
    }


    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", neighbours=" + neighbours +
                '}';
    }
}
