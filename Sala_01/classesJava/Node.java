package classesJava;

import java.util.List;

public class Node {
    private String name;
    private List<Node> adjacents;

    public Node(String n, List<Node> list) {
        this.name = n;
        this.adjacents = list;
    }

    public Node(String n) {
        this.name = n;
    }

    public void addNode(Node n){
        this.adjacents.add(n);
    }

    // O grau de um determinado vértice

    public void nodeDegree() {
        System.out.println(this.adjacents.size());
    }

    // A vizinhança de um determinado vértice

    public void neighbours() {
        for (Node n: this.adjacents) {
            System.out.println("Adjacentes: \n");
            System.out.println(n.name);
        }
    }


}
