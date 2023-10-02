// Classe que representa um Nó.
// Em teoria dos grafos, um nó (também conhecido como vértice) é uma das duas partes fundamentais de um grafo.
// A outra parte são as arestas que conectam os nós.
public class Node {
    
     // O identificador único para o nó.
    // Em grafos, cada nó geralmente tem um rótulo ou ID único que o identifica.
    String id;

    // O valor associado ao nó.
    // Em alguns grafos, um valor (também conhecido como peso) pode ser associado a um nó.
    int value;

    // Construtor que inicializa o nó com um ID.
    // Útil para grafos onde apenas a identidade do nó é relevante.
    public Node(String id) {
        this.id = id;
    }

    // Construtor que inicializa o nó com um ID e um valor.
    // Útil para grafos ponderados, onde os nós têm pesos ou valores associados.
    public Node(String id, int value) {
        this.id = id;
        this.value = value;
    }

    // Verifica a igualdade com base no ID do nó.
    // Isso é crucial para a identificação única de nós no grafo.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return id.equals(node.id);
    }

    // Gera um código hash com base no ID do nó.
    // Isso é útil para a recuperação eficiente de nós em coleções baseadas em hash, como o HashMap.
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    // Retorna uma representação em string do nó, que é seu ID.
    // Útil para depuração e exibição do nó.
    @Override
    public String toString() {
        return id;
    }
}
