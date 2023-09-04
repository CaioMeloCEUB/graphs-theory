package classesJava;

import java.util.List;

public class Node {
    private String name;
    private int adjMatrixNum;
    private List<Node> adjacents;
    private boolean visited;

    public Node(String n, List<Node> list) {
        this.name = n;
        this.adjacents = list;
        this.visited = false;
    }

    public Node(String n) {
        this.name = n;
        this.visited = false;
    }

    public String getName() {
        return this.name;
    }

    public List<Node> getAdjacents() {
        return this.adjacents;
    }

    public int getAdjMatrixNum() {
        return this.adjMatrixNum;
    }

    public boolean getVisited() {
        return this.visited;
    }

    public void setName(String n) {
        this.name = n;
    }

    public void setAdjacents(List<Node> list) {
        this.adjacents = list;
    }

    public void setAdjMatrixNum (int i) {
        this.adjMatrixNum = i;
    }


    public void setIndividualAdjacent(Node n){
        this.adjacents.add(n);
    }

    public void setVisited() {
        this.visited = true;
    }

    public void setVisitedFalse() {
        this.visited = false;
    }

    // 1 - O grau de um determinado vértice

    public int nodeDegree() {
        return this.adjacents.size();
    }

    // 2 - A vizinhança de um determinado vértice

    public void neighbours() {
        for (Node n: this.adjacents) {
            System.out.println("Adjacentes: \n");
            System.out.println(n.name);
        }
    }


}   
