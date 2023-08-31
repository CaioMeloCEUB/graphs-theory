package classesJava;
import classesJava.Node;
import java.util.List;

public class Graph {
    private String name;
    private List<Node> vertexes;
    private int numVertexes;
    private int[][] adjMatrix;
    
    public Graph(String n, List<Node> list) {
        this.name = n;
        this.vertexes = list;
        this.numVertexes = list.size();
        this.adjMatrix = new int[numVertexes][numVertexes];

        int i = 0;
        for (Node o: list){
            o.setAdjMatrixNum(i);
            i++;
        }
    }

    public void addEdge (int origin, int end) {
        this.adjMatrix[origin][end] = 1;
        this.adjMatrix[end][origin] = 1;
    }

    public void printGraph() {
        System.out.println("Grafo: " + this.name + "\n");
        System.out.println("Vértices: \n");
        for (Node n: this.vertexes) {
            List<Node> adjacents = n.getAdjacents();
            System.out.print("Nome: " + n.getName() + " | Número na matriz: " + n.getAdjMatrixNum() + " | Grau: " + n.nodeDegree());
            System.out.print(" | Adjacentes: ");
            for (Node o: adjacents) {
                System.out.print(o.getName() + ", ");
            }
            System.out.print("\n\n");
        }
        System.out.println("Total de vértices: " + this.numVertexes + "\n");
    }

    public void printMatrix() {
        System.out.println("Matriz de adjacência: \n");
        for (int i = 0; i < this.numVertexes; i++)  {
            for (int j = 0; j < this.numVertexes; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    
}
