import java.util.HashMap;

public class Main {
    
    public static void main(String[] args) {

//        Node n1 = new Node("CEUB");
//        Node n2 = new Node("Student");
//        Node n3 = new Node("Learning");
//        Node n4 = new Node("Reprovation");
//        Node n5 = new Node("Maybe");
//
//        Edge e1 = new Edge(n1,n2,10);
//        Edge e2 = new Edge(n1,n3,0.1);
//        Edge e3 = new Edge(n1,n4,450);
//        Edge e4 = new Edge(n3,n4,0.2);
//        Edge e5 = new Edge(n3,n5,-3);
//        Edge e6 = new Edge(n2,n4,0);
//
//        Graph g = new Graph();
//        g.addEdge(e1);
//        g.addEdge(e2);
//        g.addEdge(e3);
//        g.addEdge(e4);
//        g.addEdge(e5);
//        g.addEdge(e6);
//
//        g.printGraph();

        Double[][] matrix = new Double[5][5];

//        matrix[0][0] = Double.POSITIVE_INFINITY;
//        matrix[0][1] = 88.0;
//        matrix[0][2] = 88.0;
//        matrix[0][3] = 88.0;
//        matrix[0][4] = 88.0;
//        matrix[1][0] = 88.0;
//        matrix[1][1] = Double.POSITIVE_INFINITY;
//        matrix[1][2] = 4.0;
//        matrix[1][3] = 4.0;
//        matrix[1][4] = 4.0;
//        matrix[2][0] = 88.8;
//        matrix[2][1] = 4.0;
//        matrix[2][2] = Double.POSITIVE_INFINITY;
//        matrix[2][3] = 5.0;
//        matrix[2][4] = 5.0;
//        matrix[3][0] = 88.0;
//        matrix[3][1] = 4.0;
//        matrix[3][2] = 5.0;
//        matrix[3][3] = Double.POSITIVE_INFINITY;
//        matrix[3][4] = 6.0;
//        matrix[4][0] = 88.0;
//        matrix[4][1] = 4.0;
//        matrix[4][2] = 5.0;
//        matrix[4][3] = 6.0;
//        matrix[4][4] = Double.POSITIVE_INFINITY;
//
//
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println(" ");
//
//        }


        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");
        HashMap<Node, Double> hashMap1 = new HashMap<>();
        hashMap1.put(node2, 88.0);
        hashMap1.put(node3, 88.0);
        hashMap1.put(node4, 88.0);
        hashMap1.put(node5, 88.0);
        node1.setConnectedTo(hashMap1);


        HashMap<Node, Double> hashMap2 = new HashMap<>();
        hashMap2.put(node3, 4.0);
        hashMap2.put(node4, 4.0);
        hashMap2.put(node5, 4.0);
        node2.setConnectedTo(hashMap2);

        HashMap<Node, Double> hashMap3 = new HashMap<>();
        hashMap3.put(node4, 5.0);
        hashMap3.put(node5, 5.0);
        node3.setConnectedTo(hashMap3);

        HashMap<Node, Double> hashMap4 = new HashMap<>();
        hashMap4.put(node5, 6.0);
        node4.setConnectedTo(hashMap4);

        Matrix matrix1 = new Matrix();

        matrix1.addNode(node1);
        matrix1.addNode(node2);
        matrix1.addNode(node3);
        matrix1.addNode(node4);
        matrix1.addNode(node5);

        for (Node node : matrix1.getNodes()) {
            if (node.getConnectedTo() != null) {
                node.getConnectedTo().forEach((connected, teste) -> {
                    System.out.print(connected.getName());
                    System.out.print(teste);
                });
            }
        }




    }
}