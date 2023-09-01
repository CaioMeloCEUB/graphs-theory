import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Queue;
import java.util.LinkedList;



public class Matrix {

    private Set<Node> nodes = new HashSet<>();

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
    public Set<Node> getNeighbors(Node node) {
        Set<Node> neighbors = new HashSet<>();
        for (Node n : nodes) {
            if (n.getConnectedTo().containsKey(node)) {
                neighbors.add(n);
            }
        }
        return neighbors;
    }

    // teste para conexo

    public boolean isGraphConnected() {
        if (nodes.isEmpty()) {
            return true; // Grafo vazio é considerado conexo
        }
        Node startNode = nodes.iterator().next(); // Comece a partir de um vértice arbitrário
        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(startNode);
        visited.add(startNode);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            for (Node neighbor : getNeighbors(currentNode)) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return visited.size() == nodes.size(); // Se todos os vértices foram visitados, o grafo é conexo
    }

    // teste para completo

    public boolean isGraphComplete() {
        for (Node node1 : nodes) {
            for (Node node2 : nodes) {
                if (node1 != node2 && !node1.getConnectedTo().containsKey(node2)) {
                    return false; // Encontrou um par não conectado
                }
            }
        }
        return true; // Todos os pares de vértices estão conectados
    }


    //teste para caminho, circuito ou ambos

    public boolean isPath(List<Node> nodes) {
        if (nodes.isEmpty()) {
            return false;
        }
        for (int i = 0; i < nodes.size() - 1; i++) {
            Node node1 = nodes.get(i);
            Node node2 = nodes.get(i + 1);
            if (!node1.getConnectedTo().containsKey(node2)) {
                return false; // Vértices consecutivos não estão conectados
            }
        }
        return true;
    }

    public boolean isCircuit(List<Node> nodes) {
        if (nodes.size() < 2) {
            return false;
        }
        Node firstNode = nodes.get(0);
        Node lastNode = nodes.get(nodes.size() - 1);
        if (!firstNode.getConnectedTo().containsKey(lastNode)) {
            return false; // O primeiro e o último vértice não estão conectados
        }
        return isPath(nodes);
    }


}
