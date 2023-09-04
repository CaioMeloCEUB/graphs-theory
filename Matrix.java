import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Matrix {

    private Set<Node> nodes = new LinkedHashSet<>();

    public Matrix(Set<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node node){
        this.nodes.add(node);
    }

    public Matrix(){

    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    // teste para grau
    public int getDegree(Node node) {
        int degree = 0;
        for (Node n : nodes) {
            if (n.getConnectedTo().containsKey(node)) {
                degree++;
            }
        }
        return degree;
    }

    // teste para vizinhança
//    public Set<Node> getNeighbors(Node node) {
//        Set<Node> neighbors = new HashSet<>();
//        for (Node n : nodes) {
//            if (n.getConnectedTo().containsKey(node)) {
//                neighbors.add(n);
//            }
//        }
//        return neighbors;
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node node : nodes) {
            sb.append(node.getName()).append(" -> ");
            for (Node neighbor : node.getNeighbors()) {
                sb.append(neighbor.getName()).append(" (").append(node.getConnectedTo().get(neighbor)).append("), ");
            }
            if (!node.getNeighbors().isEmpty()) {
                sb.setLength(sb.length() - 2);  // remove the last comma and space
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // teste para conexo

//    public boolean isGraphConnected() {
//        if (nodes.isEmpty()) {
//            return true; // Grafo vazio é considerado conexo
//        }
//        Node startNode = nodes.iterator().next(); // Comece a partir de um vértice arbitrário
//        Set<Node> visited = new HashSet<>();
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(startNode);
//        visited.add(startNode);
//        while (!queue.isEmpty()) {
//            Node currentNode = queue.poll();
//            for (Node neighbor : getNeighbors(currentNode)) {
//                if (!visited.contains(neighbor)) {
//                    queue.add(neighbor);
//                    visited.add(neighbor);
//                }
//            }
//        }
//        return visited.size() == nodes.size(); // Se todos os vértices foram visitados, o grafo é conexo
//    }

    public boolean isConnectedGraph() {
        // Using Depth First Search (DFS) to check connectivity
        Set<Node> visited = new HashSet<>();
        dfs(nodes.iterator().next(), visited); // starting from any node

        return visited.size() == nodes.size();
    }

    private void dfs(Node current, Set<Node> visited) {
        visited.add(current);
        for (Node neighbor : current.getNeighbors()) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }
    }

    // teste para completo
//    public boolean isGraphComplete() {
//        for (Node node1 : nodes) {
//            for (Node node2 : nodes) {
//                if (node1 != node2 && !node1.getConnectedTo().containsKey(node2)) {
//                    return false; // Encontrou um par não conectado
//                }
//            }
//        }
//        return true; // Todos os pares de vértices estão conectados
//    }

    public boolean isCompleteGraph() {
        for (Node node : nodes) {
            if (node.getDegree() != nodes.size() - 1) {
                return false;
            }
        }
        return true;
    }


    //teste para caminho, circuito ou ambos

//    public boolean isPath(List<Node> nodes) {
//        if (nodes.isEmpty()) {
//            return false;
//        }
//        for (int i = 0; i < nodes.size() - 1; i++) {
//            Node node1 = nodes.get(i);
//            Node node2 = nodes.get(i + 1);
//            if (!node1.getConnectedTo().containsKey(node2)) {
//                return false; // Vértices consecutivos não estão conectados
//            }
//        }
//        return true;
//    }

    // To detect cycle, we can modify DFS. If a node is revisited before it's popped off the recursion stack, there's a cycle.
    public boolean hasCycle() {
        Set<Node> visited = new HashSet<>();
        Set<Node> stack = new HashSet<>();

        for (Node node : nodes) {
            if (!visited.contains(node) && hasCycleUtil(node, visited, stack, null)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasCycleUtil(Node current, Set<Node> visited, Set<Node> stack, Node parent) {
        visited.add(current);
        stack.add(current);

        for (Node neighbor : current.getNeighbors()) {
            if (!visited.contains(neighbor)) {
                if (hasCycleUtil(neighbor, visited, stack, current)) {
                    return true;
                }
            } else if (stack.contains(neighbor) && !neighbor.equals(parent)) {
                return true;
            }
        }

        stack.remove(current);
        return false;
    }

//    public boolean isCircuit(List<Node> nodes) {
//        if (nodes.size() < 2) {
//            return false;
//        }
//        Node firstNode = nodes.get(0);
//        Node lastNode = nodes.get(nodes.size() - 1);
//        if (!firstNode.getConnectedTo().containsKey(lastNode)) {
//            return false; // O primeiro e o último vértice não estão conectados
//        }
//        return isPath(nodes);
//    }

    public String toAdjacencyMatrix() {
        int n = this.nodes.size();
        Node[] nodeArray = this.nodes.toArray(new Node[0]);
        double[][] matrix = new double[n][n];

        // Inicializa a matriz com um valor padrão. Vamos usar Double.POSITIVE_INFINITY para "sem conexão".
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Double.POSITIVE_INFINITY;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nodeArray[i].getConnectedTo().containsKey(nodeArray[j])) {
                    matrix[i][j] = nodeArray[i].getConnectedTo().get(nodeArray[j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        // Printando a matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == Double.POSITIVE_INFINITY) {
                    sb.append("INF").append("\t\t\t");
                } else {
                    sb.append(matrix[i][j]).append("\t\t\t");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }



}