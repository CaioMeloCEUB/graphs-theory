import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Graph graph = new Graph();

        List<Node> nodes = new ArrayList<>();

        Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        Node n5 = new Node("5");
        Node n6 = new Node("6");

        // Node 1
        HashMap<Node, Double> n1EdgeValues = new HashMap<>();
        n1EdgeValues.put(n5, 2.0);
        n1EdgeValues.put(n2, 3.0);
        n1.setNeighbours(n1EdgeValues);

//         Node 2
        HashMap<Node, Double> n2EdgeValues = new HashMap<>();
        n2EdgeValues.put(n1, 3.0);
        n2EdgeValues.put(n5, 0.0);
        n2EdgeValues.put(n3, 10.0);
        n2.setNeighbours(n2EdgeValues);
//
//        // Node 3
        HashMap<Node, Double> n3EdgeValues = new HashMap<>();
        n3EdgeValues.put(n2, 10.0);
        n3EdgeValues.put(n4, 1.0);
        n3.setNeighbours(n3EdgeValues);
//
//        // Node 4
        HashMap<Node, Double> n4EdgeValues = new HashMap<>();
        n4EdgeValues.put(n5, 4.0);
        n4EdgeValues.put(n3, 1.0);
        n4EdgeValues.put(n6, 0.0);
        n4.setNeighbours(n4EdgeValues);
//
//        // Node 5
        HashMap<Node, Double> n5EdgeValues = new HashMap<>();
        n5EdgeValues.put(n4, 4.0);
        n5EdgeValues.put(n2, 0.0);
        n5EdgeValues.put(n1, 2.0);
        n5.setNeighbours(n5EdgeValues);
//
//        // Node 6
        HashMap<Node, Double> n6EdgeValues = new HashMap<>();
        n6EdgeValues.put(n4, 0.0);
        n6.setNeighbours(n6EdgeValues);


        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n4);
        nodes.add(n5);
        nodes.add(n6);


        graph.setNodes(nodes);

//        n1.findDegree();
//
//        graph.printNodes();

        // Degrees
        for (Node e : graph.getNodes()) {
            System.out.println("Node " + e.getName() + " " + "Grau: " + e.findDegree());
        }


    }
}
