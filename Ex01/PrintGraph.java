package Ex01;

public class PrintGraph {
    public static void print(Graph graph) {
        for (Node node : graph.nodes) {
            System.out.println("Node " + node.name + "\nDegree " + GraphDegree.calculateDegree(node));
            for (Edge edge : node.edges) {
                System.out.println("(" + edge.arrival.name + ", Weight " + edge.weight + ")");
            }
            System.out.println();
        }
    }
}