package classesJava;

import java.util.List;

public class Node {
    private String name;
    private int adjMatrixNum;
    private List<Node> adjacents;

    public Node(String n, List<Node> list) {
        this.name = n;
        this.adjacents = list;
    }

    public Node(String n) {
        this.name = n;
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