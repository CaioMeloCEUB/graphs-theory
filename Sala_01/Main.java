// Guilherme Lopes Costa Pereira - 22101616
// Ivan de Medeiros Yared - 22103194

import classesJava.Node;
import classesJava.Graph;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main (String[] args) {
        Node dc0 = new Node("Data Center 0", 0);
        Node dc1 = new Node("Data Center 1", 1);
        Node dc2 = new Node("Data Center 2", 2);
        Node dc3 = new Node("Data Center 3", 3);
        Node dc4 = new Node("Data Center 4", 4);
        Node dc5 = new Node("Data Center 5", 5);
        Node dc6 = new Node("Data Center 6", 6);
        Node dc7 = new Node("Data Center 7", 7);
        Node dc8 = new Node("Data Center 8", 8);
        Node dc9 = new Node("Data Center 9", 9);
        Node dc10 = new Node("Data Center 10", 10);
        Node dc11 = new Node("Data Center 11", 11);
        Node dc12 = new Node("Data Center 12", 12);

        // Bonus Round: três novos data centers

        Node dc13 = new Node("Data Center 13", 13);
        Node dc14 = new Node("Data Center 14", 14);
        Node dc15 = new Node("Data Center 15", 15);

        //

        // Teste caminho e circuito

        /* Node dc16 = new Node("Data Center 16"); */

        //

        List<Node> adjn0 = new ArrayList<Node>();
        List<Node> adjn1 = new ArrayList<Node>();
        List<Node> adjn2 = new ArrayList<Node>();
        List<Node> adjn3 = new ArrayList<Node>();
        List<Node> adjn4 = new ArrayList<Node>();
        List<Node> adjn5 = new ArrayList<Node>();
        List<Node> adjn6 = new ArrayList<Node>();
        List<Node> adjn7 = new ArrayList<Node>();
        List<Node> adjn8 = new ArrayList<Node>();
        List<Node> adjn9 = new ArrayList<Node>();
        List<Node> adjn10 = new ArrayList<Node>();
        List<Node> adjn11 = new ArrayList<Node>();
        List<Node> adjn12 = new ArrayList<Node>();

        // Bonus Round: três novos data centers

        List<Node> adjn13 = new ArrayList<Node>();
        List<Node> adjn14 = new ArrayList<Node>();
        List<Node> adjn15 = new ArrayList<Node>();

        //

        List<Node> nos = new ArrayList<Node>();
        nos.add(dc0);
        nos.add(dc1);
        nos.add(dc2);
        nos.add(dc3);
        nos.add(dc4);
        nos.add(dc5);
        nos.add(dc6);
        nos.add(dc7);
        nos.add(dc8);
        nos.add(dc9);
        nos.add(dc10);
        nos.add(dc11);
        nos.add(dc12);

        // Bonus Round: três novos data centers

        nos.add(dc13);
        nos.add(dc14);
        nos.add(dc15);

        //

        // Teste caminho e circuito

        /* nos.add(dc16); */

        //

        for(Node n: nos){
            if(n.getName() != dc0.getName()) {
                adjn0.add(n);
            }
        }
        dc0.setAdjacents(adjn0);
        for(Node n: nos){
            if(n.getName() != dc1.getName()) {
                adjn1.add(n);
            }
        }
        dc1.setAdjacents(adjn1);
        for(Node n: nos){
            if(n.getName() != dc2.getName()) {
                adjn2.add(n);
            }
        }
        dc2.setAdjacents(adjn2);
        for(Node n: nos){
            if(n.getName() != dc3.getName()) {
                adjn3.add(n);
            }
        }
        dc3.setAdjacents(adjn3);
        for(Node n: nos){
            if(n.getName() != dc4.getName()) {
                adjn4.add(n);
            }
        }
        dc4.setAdjacents(adjn4);
        for(Node n: nos){
            if(n.getName() != dc5.getName()) {
                adjn5.add(n);
            }
        }
        dc5.setAdjacents(adjn5);
        for(Node n: nos){
            if(n.getName() != dc6.getName()) {
                adjn6.add(n);
            }
        }
        dc6.setAdjacents(adjn6);
        for(Node n: nos){
            if(n.getName() != dc7.getName()) {
                adjn7.add(n);
            }
        }
        dc7.setAdjacents(adjn7);
        for(Node n: nos){
            if(n.getName() != dc8.getName()) {
                adjn8.add(n);
            }
        }
        dc8.setAdjacents(adjn8);
        for(Node n: nos){
            if(n.getName() != dc9.getName()) {
                adjn9.add(n);
            }
        }
        dc9.setAdjacents(adjn9);
        for(Node n: nos){
            if(n.getName() != dc10.getName()) {
                adjn10.add(n);
            }
        }
        dc10.setAdjacents(adjn10);
        for(Node n: nos){
            if(n.getName() != dc11.getName()) {
                adjn11.add(n);
            }
        }
        dc11.setAdjacents(adjn11);
        for(Node n: nos){
            if(n.getName() != dc12.getName()) {
                adjn12.add(n);
            } 
        }
        dc12.setAdjacents(adjn12);

        // Bonus Round: três novos data centers

        for(Node n: nos){
            if(n.getName() != dc13.getName()) {
                adjn13.add(n);
            }
        }
        dc13.setAdjacents(adjn13);
        for(Node n: nos){
            if(n.getName() != dc14.getName()) {
                adjn14.add(n);
            }
        }
        dc14.setAdjacents(adjn14);
        for(Node n: nos){
            if(n.getName() != dc15.getName()) {
                adjn15.add(n);
            } 
        }
        dc15.setAdjacents(adjn15);

        //

        Graph grafo = new Graph("Grafo dos Data Centers", nos);
        
        for(int i = 0; i < 16; i++) {
            for(int j = 0; j < 16; j++){
                if(i != j){
                    grafo.addEdge(i, j);
                }
            }
        }

        // Teste caminho e circuito

        /* List<Node> caminhoTrue = new ArrayList<Node>();
        caminhoTrue.add(dc0);
        caminhoTrue.add(dc1);

        List<Node> caminhoFalse = new ArrayList<Node>();
        caminhoTrue.add(dc0);
        caminhoTrue.add(dc16);

        List<Node> circuitoTrue = new ArrayList<Node>();
        circuitoTrue.add(dc0);
        circuitoTrue.add(dc1);
        circuitoTrue.add(dc2);
        circuitoTrue.add(dc0);

        List<Node> circuitoFalse = new ArrayList<Node>();
        circuitoTrue.add(dc0);
        circuitoTrue.add(dc1);
        circuitoTrue.add(dc2);

        List<Node> circuitoFalseDois = new ArrayList<Node>();
        circuitoTrue.add(dc0);
        circuitoTrue.add(dc1);
        circuitoTrue.add(dc16);
        circuitoTrue.add(dc0);

        System.out.println("Teste das funções de caminho e circuito\n");
        System.out.println("Caminho True: " + grafo.isPath(caminhoTrue));
        System.out.println("Caminho False: " + grafo.isPath(caminhoFalse));
        System.out.println("Circuito True: " + grafo.isPath(circuitoTrue));
        System.out.println("Circuito False: " + grafo.isPath(circuitoFalse));
        System.out.println("Circuito False 2: " + grafo.isPath(circuitoFalseDois)); */

        //

        grafo.printGraph();
        grafo.printMatrix();

    }
}