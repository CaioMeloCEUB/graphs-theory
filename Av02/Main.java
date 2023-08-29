package Av02;

public class Main {
    public static void main(String[] args) {
        int numNodes = 4;
        Graph graph = new Graph(numNodes);

        graph.nodes.get(0).name = "CEUB";
        graph.nodes.get(1).name = "UNB";
        graph.nodes.get(2).name = "IESB";
        graph.nodes.get(3).name = "UDF";

        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 3, 7);

        PrintGraph.print(graph);
    }
}