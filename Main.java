public class Main {
    
    public static void main(String[] args) {

        Node n1 = new Node("CEUB");
        Node n2 = new Node("Student");
        Node n3 = new Node("Learning");
        Node n4 = new Node("Reprovation");
        Node n5 = new Node("Maybe");

        Edge e1 = new Edge(n1,n2,10);
        Edge e2 = new Edge(n1,n3,0.1);
        Edge e3 = new Edge(n1,n4,450);
        Edge e4 = new Edge(n3,n4,0.2);
        Edge e5 = new Edge(n3,n5,-3);
        //Edge e6 = new Edge(n2,n4,0);

        Graph g = new Graph();
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);
        g.addEdge(e5);
        g.addEdge(e6);

        g.printGraph();
    }
}