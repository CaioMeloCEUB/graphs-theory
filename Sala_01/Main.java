// Guilherme Lopes Costa Pereira - 22101616
// Ivan de Medeiros Yared - 22103194

import classesJava.Node;
import classesJava.Graph;
import java.util.List;
import java.util.ArrayList;

public class Main {

    public static void main (String[] args) {
        Node dc0 = new Node("Data Center 0");
        Node dc1 = new Node("Data Center 1");
        Node dc2 = new Node("Data Center 2");
        Node dc3 = new Node("Data Center 3");
        Node dc4 = new Node("Data Center 4");
        Node dc5 = new Node("Data Center 5");
        Node dc6 = new Node("Data Center 6");
        Node dc7 = new Node("Data Center 7");
        Node dc8 = new Node("Data Center 8");
        Node dc9 = new Node("Data Center 9");
        Node dc10 = new Node("Data Center 10");
        Node dc11 = new Node("Data Center 11");
        Node dc12 = new Node("Data Center 12");

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

        Graph grafo = new Graph("Grafo dos Data Centers", nos);
        grafo.printGraph();
        
        for(int i = 0; i < 13; i++) {
            
        }

        grafo.addEdge(0, 1);
        grafo.addEdge(1, 0);

        grafo.printMatrix();
    }
}