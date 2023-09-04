package classesJava;
import java.util.List;

public class Graph {
    private String name;
    private List<Node> vertexes;
    private int numVertexes;
    private int numEdges;
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

    public void setNumEdges() {
        int n = 0;
        for (int i = 0; i < this.numVertexes; i++) {
            for (int j = 0; j < this.numVertexes; j++) {
                if(this.adjMatrix[i][j] == 1) {
                    n++;
                }
            }
        }
        this.numEdges = n/2;
    }

    // 3 - A verificação booleana se o grafo é conexo
    // Método utilizado: Busca em Profundidade (DFS - Depth-First Search)

    public void DFS(Node n) {
        n.setVisited();
        List<Node> neighbours = n.getAdjacents();
        for (Node o: neighbours){
            if (o.getVisited() == false) {
                DFS(o);
            }
        }
    }

    public boolean isConnected() {
        DFS(this.vertexes.get(0));
        for(Node n: this.vertexes) {
            if(!n.getVisited()) {
                return false;
            }
        }
        return true;
    }
    
    // 4 - A verificação booleana se o grafo é completo

    public boolean isComplete() {
        for (Node n: this.vertexes) {
            if (n.nodeDegree() != this.vertexes.size() - 1) {
                return false;
            }
        }
        return true;
    }

    // 5 - Fornecido um conjunto de vértices indicar se os mesmos representam um caminho, um circuito ou as duas possibilidades.

    // 5.1 - Checar se é caminho

    public boolean isPath(List<Node> list) {
        for (Node n: list) {
            if (!this.vertexes.contains(n)) {
                return false;
            }
        }
        DFS (list.get(0));
        for (Node n: list) {
            if (!n.getVisited()) {
                return false;
            }
        }
        return true;
        
    }

    // 5.2 - Checar se é circuito

    public boolean isCircuit(List<Node> list) {
        if (list.get(0) != list.get(list.size() - 1)) {
            return false;
        }
        boolean f = isPath(list);
        if (!f) {
            return false;
        } else {
            return true;
        }
    }

    public void printGraph() {
        System.out.println("Grafo: " + this.name + "\n");
        System.out.println("Vértices: \n");
        this.setNumEdges();
        for (Node n: this.vertexes) {
            List<Node> adjacents = n.getAdjacents();
            System.out.print("Nome: " + n.getName() + " | Número na matriz: " + n.getAdjMatrixNum() + " | Grau: " + n.nodeDegree());
            System.out.print(" | Adjacentes: ");
            for (Node o: adjacents) {
                System.out.print(o.getName() + ", ");
            }
            System.out.print("\n\n");
        }
        System.out.println("Total de vértices: " + this.numVertexes);
        System.out.println("Total de arestas: " + this.numEdges + "\n");
        if (this.isConnected() == true) {
            System.out.println("O grafo é conexo\n");
        } else {
            System.out.println("O grafo é desconexo\n");
        }
        if (this.isComplete() == true) {
            System.out.println("O grafo é completo\n");
        } else {
            System.out.println("O grafo é incompleto\n");
        }
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
