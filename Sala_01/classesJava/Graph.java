package classesJava;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

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
        this.numEdges = 0;
        this.adjMatrix = new int[numVertexes][numVertexes];
        this.residualGraph = new int[numVertexes][numVertexes];
    }

    public void setAllAdjacents (int origin, int end) {
        List<Node> list_adj_origin = new ArrayList<Node>();
        List<Node> list_adj_end = new ArrayList<Node>();
        for (Node n: this.vertexes) {
            if (n.getId() == origin) {
                list_adj_end.add(n);
            } else if (n.getId() == end) {
                list_adj_origin.add(n);
            }
        }
        for (Node n: this.vertexes) {
            if (n.getId() == origin) {
                n.setAdjacent(list_adj_origin.get(0));
            } else if (n.getId() == end) {
                n.setAdjacent(list_adj_end.get(0));
            }
        }
    }

    public void addEdge (int origin, int end) {
        this.adjMatrix[origin][end] = 1;
        this.adjMatrix[end][origin] = 1;
        this.setAllAdjacents(origin, end);
        this.setNumEdges();
    }

    public void addEdge (int origin, int end, int value) {
        this.adjMatrix[origin][end] = value;
        this.adjMatrix[end][origin] = value;
        this.setAllAdjacents(origin, end);
        this.setNumEdges();
    }

    public void addEdge (int origin, int end, int valueOne, int valueTwo) {
        this.adjMatrix[origin][end] = valueOne;
        this.adjMatrix[end][origin] = valueTwo;
        this.setAllAdjacents(origin, end);
        this.setNumEdges();
    }
    public void addDirectedEdge (int origin, int end, int value) {
        this.adjMatrix[origin][end] = value;
        this.residualGraph[origin][end] = value;
        this.setAllAdjacents(origin, end);
        this.setNumEdgesDirected();
    }

    public void setNumEdges() {
        int n = 0;
        for (int i = 0; i < this.numVertexes; i++) {
            for (int j = 0; j < this.numVertexes; j++) {
                if(this.adjMatrix[i][j] != 0) {
                    n++;
                }
            }
        }
        this.numEdges = n/2;
    }

    public void setNumEdgesDirected() {
        int n = 0;
        for (int i = 0; i < this.numVertexes; i++) {
            for (int j = 0; j < this.numVertexes; j++) {
                if(this.adjMatrix[i][j] != 0) {
                    n++;
                }
            }
        }
        this.numEdges = n;
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

    public boolean BFS(int s, int t, int parent[]) {
        boolean visited[] = new boolean[this.numVertexes];
        for (int i = 0; i < this.numVertexes - 1; i++) {
            visited[i] = false;
        }

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;

        while (queue.size() != 0) {
            int u = queue.poll();
            for (int i = 0; i < this.numVertexes; i++) {
                if (visited[i] == false && this.residualGraph[u][i] > 0) {
                    if (i == t) {
                        parent[i] = u;
                        return true;
                    }
                    queue.add(i);
                    parent[i] = u;
                    visited[i] = true;
                }
            }
        }

        return false;

        /* s.setVisited();
        if (t.getVisited() || s.getId() == t.getId()) {
            return true;
        }
        List<Node> neighbours = s.getAdjacents();
        for (Node o: neighbours){
            if (o.getVisited() == false && !o.getNoAdjacents() && residualGraph[s.getId()][o.getId()] > 0) {
                DFS(o, t);
            }
        }
        return false; */
    }

    public int fordFulkerson () {
        int max_flow = 0;
        int parent[] = new int[this.numVertexes];
        int s = this.vertexes.get(0).getId();
        int t = this.vertexes.get(this.vertexes.size() - 1).getId();
        while(BFS(s, t, parent)) {
            int path_flow = Integer.MAX_VALUE;
            for (int i = t; i != s; i = parent[i]) {
                int u = parent[i];
                path_flow = Math.min (path_flow, residualGraph[u][i]);
            }

            for (int i = t; i != s; i = parent[i]) {
                int u = parent[i];
                residualGraph[u][i] -= path_flow;
                residualGraph[i][u] += path_flow;
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
            System.out.print("Nome: " + n.getName() + " | Número na matriz: " + n.getId() + " | Grau: " + n.nodeDegree());
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
        System.out.println("Fluxo máximo no grafo: " + this.fordFulkerson());
    }    
}
