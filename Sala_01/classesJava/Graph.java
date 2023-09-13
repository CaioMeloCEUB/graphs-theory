package classesJava;
import java.util.List;
import java.util.Collection;

public class Graph {
    private String name;
    private List<Node> vertexes;
    private int numVertexes;
    private int numEdges;
    private int[][] adjMatrix;
    private int[][] residualGraph;
    
    public Graph(String n, List<Node> list) {
        this.name = n;
        this.vertexes = list;
        this.numVertexes = list.size();
        this.adjMatrix = new int[numVertexes][numVertexes];
        this.residualGraph = new int[numVertexes][numVertexes];

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

    public void addEdge (int origin, int end, int value) {
        this.adjMatrix[origin][end] = value;
        this.adjMatrix[end][origin] = value;
    }

    public void addEdge (int origin, int end, int valueOne, int valueTwo) {
        this.adjMatrix[origin][end] = valueOne;
        this.adjMatrix[end][origin] = valueTwo;
    }
    public void addDirectedEdge (int origin, int end, int value) {
        this.adjMatrix[origin][end] = value;
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
            if (o.getVisited() == false && !o.getNoAdjacents()) {
                DFS(o);
            }
        }
    }

    public boolean DFS(Node s, Node t) {
        s.setVisited();
        if (t.getVisited()) {
            return true;
        }
        List<Node> neighbours = s.getAdjacents();
        for (Node o: neighbours){
            if (o.getVisited() == false && !o.getNoAdjacents() && residualGraph[s.getId()][o.getId()] > 0) {
                DFS(o, t);
            }
        }
        return false;
    }

    public int fordFulkerson () {
        int max_flow = 0;
        while(DFS(this.vertexes.get(0), this.vertexes.get(this.vertexes.size() - 1))) {
            int path_flow = Integer.MAX_VALUE;
            int[] path_list = new int[this.numVertexes];
            int i = 0;
            for (Node o: vertexes) {
                if (o.getVisited()) {
                    path_list[i] = o.getId();
                    i++;
                }
            }
            int j = 0;

            for (i = 0; i < this.numVertexes - 2; i++) {
                for (j = 1; j < this.numVertexes - 1; j++) {
                    path_flow = Math.min (adjMatrix[i][j], path_flow);
                }
            }

            for (i = 0; i < this.numVertexes - 2; i++) {
                for (j = 1; j < this.numVertexes - 1; j++) {
                    this.residualGraph[i][j] -= path_flow;
                    this.residualGraph[j][i] += path_flow;
                }
            }

            for (Node n: this.vertexes) {
                n.setVisitedFalse();
            }

            max_flow += path_flow;
        }
        return max_flow;
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

    public void DFSPath(List<Node> list) {
        list.get(0).setVisited();
        List<Node> neighbours = list.get(0).getAdjacents();
        for (Node o: neighbours){
            if (o.getVisited() == false && list.contains(o)) {
                System.out.println(list.contains(o));
                DFS(o);
            }
        }
    }

    // 5.1 - Checar se é caminho

    public boolean isPath(List<Node> list) {
        for (Node n: list) {
            if (!this.vertexes.contains(n)) {
                return false;
            }
            if (n.getNoAdjacents()) {
                return false;
            }
        }
        if (list.size() != 0) {
            DFSPath (list);
            for (Node n: list) {
                if (!n.getVisited()) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }     
    }

    // 5.2 - Checar se é circuito

    public boolean isCircuit(List<Node> list) {
        if (list.get(0) != list.get(list.size() - 1) || !list.get(list.size() - 2).getAdjacents().contains(list.get(list.size() - 1)) ) {
            return false;
        }
        for (Node n: list) {
            if (n.getNoAdjacents()) {
                return false;
            }
        }
        boolean f = isPath(list);
        if (!f) {
            return false;
        } else {
            return true;
        }
    }

    public void resetVisited() {
        for (Node o: this.vertexes) {
                o.setVisitedFalse();
        }
    }
    // Bonus round
    // O grafo complementar dessa rede é um grafo com apenas 1 aresta.
    // // Método que retorna o número de arestas do grafo complementar

    public int edgesComp() {
        int totalPossibleEdges = (this.numVertexes * (this.numVertexes - 1)) / 2;
        return totalPossibleEdges - this.numEdges;
    }

    // O grafo que representa a rede de data centers pode ser classificado como Euleriano.
    // // Um grafo G é Euleriano se e somente se G for conexo e cada vértice de M tem grau par

    public boolean isEulerian() {
        for (Node n: vertexes) {
            if (n.nodeDegree() % 2 != 0) {
                return false;
            }
        }
        if (!this.isConnected()) {
            return false;
        }
        return true;
    }

    public void printGraph() {
        System.out.println("Grafo: " + this.name + "\n");
        System.out.println("Vértices: \n");
        this.setNumEdges();
        for (Node n: this.vertexes) {
            List<Node> adjacents = n.getAdjacents();
            System.out.print("Nome: " + n.getName() + " | Número na matriz: " + n.getAdjMatrixNum() + " | Grau: " + n.nodeDegree());
            System.out.print(" | Adjacentes: ");
            if (adjacents != null) {
                for (Node o: adjacents) {
                    System.out.print(o.getName() + ", ");
                }
            } else {
                System.out.print("Não há adjacentes");
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
        System.out.println("Número de arestas do grafo complementar: " + this.edgesComp() + "\n");
        if (this.isEulerian() == true) {
            System.out.println("O grafo é euleriano\n");
        } else {
            System.out.println("O grafo não é euleriano\n");
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
