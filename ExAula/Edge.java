public class Edge {

    private Node node1;
    private Node node2;
    private double weight;

    public Edge(Node n1, Node n2) {
        this.node1 = n1;
        this.node2 = n2;
    }

    public Edge(Node n1, Node n2, double w) {
        this.node1 = n1;
        this.node2 = n2;
        this.weight = w;
    }

    public void print() {
        System.out.println(this.node1.getName() + " | "
                + this.node2.getName() + " | " + this.weight);


    }






}
