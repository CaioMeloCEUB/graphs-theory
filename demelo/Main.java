package demelo;
import demelo.graph.Graph;
import exceptions.DuplicatedEdgeException;
import exceptions.NodeNotFoundException;

public class Main {
    
    public static void main(String[] args) {
        try {
            // Example 1: Directed Graph
            Graph graph1 = new Graph();
            graph1.addNode("A");
            graph1.addNode("B");
            graph1.addNode("C");
            graph1.addNode("D");
            graph1.addNode("E");
            graph1.addEdge("A", "B", false);
            graph1.addEdge("B", "C", false);
            graph1.addEdge("C", "D", false);
            graph1.addEdge("D", "E", false);
            graph1.addEdge("E", "A", false);
            graph1.addEdge("A", "C", false);
            graph1.addEdge("B", "D", false);

            graph1.printGraph();
            graph1.printAdjacencyMatrix();

            // Example 2: Undirected Graph
            Graph graph2 = new Graph();
            graph2.addNode("W");
            graph2.addNode("X");
            graph2.addNode("Y");
            graph2.addNode("Z");
            graph2.addUndirectedEdge("W", "X", 1, false);
            graph2.addUndirectedEdge("X", "Y", 9, false);
            graph2.addUndirectedEdge("Y", "Z", 5, false);
            graph2.addUndirectedEdge("Z", "W", 4, false);
            graph2.addUndirectedEdge("W", "Y", 6, false);
            graph2.addUndirectedEdge("X", "Z", 2, false);
            
            graph2.printGraph();
            graph2.printAdjacencyMatrix();

        } catch (NodeNotFoundException | DuplicatedEdgeException e) {
            e.printStackTrace();
        }
    }
}