package Ex01;

public class Main {
    public static void main(String[] args) {
        int numNodes = 13;
        Graph graph = new Graph(numNodes);

        graph.nodes.get(0).name = "Data Center 1";
        graph.nodes.get(1).name = "Data Center 2";
        graph.nodes.get(2).name = "Data Center 3";
        graph.nodes.get(3).name = "Data Center 4";
        graph.nodes.get(4).name = "Data Center 5";
        graph.nodes.get(5).name = "Data Center 6";
        graph.nodes.get(6).name = "Data Center 7";
        graph.nodes.get(7).name = "Data Center 8";
        graph.nodes.get(8).name = "Data Center 9";
        graph.nodes.get(9).name = "Data Center 10";
        graph.nodes.get(10).name = "Data Center 11";
        graph.nodes.get(11).name = "Data Center 12";
        graph.nodes.get(12).name = "Data Center 13";

        /*graph.nodes.get(13).name = "Data Center 14";
        graph.nodes.get(14).name = "Data Center 15";
        graph.nodes.get(15).name = "Data Center 16";*/

        for (int i = 0; i < 13; i++) {
            for (int j = i + 1; j < 13; j++) {
                graph.addEdge(i, j, 0);
            }
        }

        /*for (int i = 0; i < 16; i++) {
            for (int j = i + 1; j < 16; j++) {
                graph.addEdge(i, j, 0);
            }
        } */

        PrintGraph.print(graph);

        boolean connected = ConnectedGraph.checkConnected(graph);
        if (connected) {
            System.out.println("The graph is connected\n");
        } else {
            System.out.println("The graph is not connected\n");
        }

        boolean complete = CompleteGraph.checkComplete(graph);
        if (complete) {
            System.out.println("The graph is completed\n");
        } else {
            System.out.println("The graph is not completed\n");
        }

        String resultCheckCircuitPath = CheckCircuitPath.checkCircuitOrPath(graph.nodes);
        System.out.println(resultCheckCircuitPath);
    }
}