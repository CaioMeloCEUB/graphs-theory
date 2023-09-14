package FordFulkerson;

// Ivan de Medeiros Yared
// Matheus Belo Palazzo
// Victor Daniel dos Santos Gonçalves

import classesJava.Graph;
import classesJava.Node;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        Node dc0 = new Node("BRT Sul", 0);
        Node dc1 = new Node("Periquito", 1);
        Node dc2 = new Node("Papuda", 2);
        Node dc3 = new Node("Catetinho", 3);
        Node dc4 = new Node("Park Way", 4);
        Node dc5 = new Node("Balao do Aeroporto", 5);
        Node dc6 = new Node("Zoologico", 6);
        Node dc7 = new Node("Telebrasilia", 7);
        Node dc8 = new Node("Octogonal", 8);
        Node dc9 = new Node("Memorial JK", 9);
        Node dc10 = new Node("Jardim Botanico", 10);
        Node dc11 = new Node("Bosque dos Constituintes", 11);
        Node dc12 = new Node("Rodoviaria", 12);

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

        Graph grafo = new Graph("Grafo das rodovias do DF", nos);

        grafo.addDirectedEdge(0, 1, 7115);
        grafo.addDirectedEdge(0, 2, 3560);
        grafo.addDirectedEdge(0, 3, 7115);
        grafo.addDirectedEdge(1, 3, 7115);
        grafo.addDirectedEdge(2, 10, 7120);
        grafo.addDirectedEdge(3, 4, 10674);
        grafo.addDirectedEdge(4, 5, 10674);
        grafo.addDirectedEdge(5, 7, 10674);
        grafo.addDirectedEdge(6, 8, 10674);
        grafo.addDirectedEdge(7, 12, 10674);
        grafo.addDirectedEdge(7, 6, 10679);
        grafo.addDirectedEdge(8, 9, 7120);
        grafo.addDirectedEdge(9, 12, 17800);
        grafo.addDirectedEdge(10, 11, 10674);
        grafo.addDirectedEdge(11, 12, 17800);

        grafo.printGraph();
        grafo.printMatrix();
    }
}
