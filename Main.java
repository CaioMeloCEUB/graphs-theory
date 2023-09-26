public class Main {
    
    public static void main(String[] args) {
    
      Graph graph = new Graph();

      // Adicionar Nós
      graph.addNode("A");
      graph.addNode("B");
      graph.addNode("C");

      // Adicionar Arestas
       try {
            graph.addEdge("A", "B", 4, false);
            graph.addEdge("A", "C", 5, false);
            graph.addEdge("B", "C", 1, false);
        } catch (NodeNotFoundException | DuplicatedEdgeException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

      // Imprimir matriz de adjacencia
      graph.printAdjacencyMatrix();
    }
}