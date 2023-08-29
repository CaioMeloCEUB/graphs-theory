    package Av02;

    public class PrintGraph {
        public static void print(Graph graph) {
            for (Node node : graph.nodes) {
                System.out.println("Node " + node.name + ": ");
                for ( Edge edge : node.edges) {
                    System.out.println("(" + edge.arrival.name + ", Weight " + edge.weight + ")");
                }
                System.out.println();
            }
            
        }
    }