package classesJava;

import java.util.List;

public class Node {
    private String name;
    private int id;
    private List<Node> adjacents;
    private boolean visited;
    private boolean noAdjacents;

    public Node(String n, List<Node> list, int id) {
        this.name = n;
        this.id = id;
        this.adjacents = list;
        this.visited = false;
        this.noAdjacents = false;
    }

    public Node(String n, List<Node> list) {
        this.name = n;
        this.adjacents = list;
        this.visited = false;
        this.noAdjacents = false;
    }

    public Node(String n, int id) {
        this.name = n;
        this.id = id;
        this.visited = false;
        this.noAdjacents = true;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public List<Node> getAdjacents() {
        return this.adjacents;
    }

    public boolean getVisited() {
        return this.visited;
    }

    public boolean getNoAdjacents() {
        return this.noAdjacents;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setAdjacent(Node node) {
        this.adjacents.add(node);
        this.noAdjacents = false;
    }

    public void setAdjacents(List<Node> list) {
        this.adjacents = list;
        this.noAdjacents = false;
    }

    public void setIndividualAdjacent(Node n){
        this.adjacents.add(n);
        this.noAdjacents = false;
    }

    public void setVisited() {
        this.visited = true;
    }

    public void setVisitedFalse() {
        this.visited = false;
    }

    // 1 - O grau de um determinado vértice

    public int nodeDegree() {
        if (this.adjacents != null) {
            return this.adjacents.size();
        } else {
            return 0;
        }    
    }

    // 2 - A vizinhança de um determinado vértice

    public void neighbours() {
        for (Node n: this.adjacents) {
            System.out.println("Adjacentes: \n");
            System.out.println(n.name);
        }
    }


}   
