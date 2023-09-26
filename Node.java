/**
 * Classe que representa um Nó (Vértice) em um grafo.
 * <p>
 * Na teoria dos grafos, um nó ou vértice é uma das duas entidades fundamentais de um grafo,
 * sendo a outra as arestas que conectam os nós. Cada nó pode ter um identificador único e um valor associado.
 * </p>
 */
public class Node {

    /**
     * O identificador único para o nó.
     * Este ID é usado para diferenciar cada nó dentro do grafo.
     * Em aplicações práticas, pode ser um identificador de um objeto no domínio do problema.
     */
    private String id;

    /**
     * O valor associado ao nó.
     * Em grafos ponderados, este valor pode representar uma métrica como custo, distância, etc.
     * Em grafos não ponderados, este valor pode não ter significado.
     */
    private int value;

    /**
     * Construtor para inicializar o nó com apenas um ID.
     * Útil para grafos onde somente a identidade do nó é relevante.
     *
     * @param id O identificador único para o nó.
     */
    public Node(String id) {
        this.id = id;
    }

    /**
     * Construtor para inicializar o nó com um ID e um valor associado.
     * Útil para grafos ponderados onde os nós têm valores ou pesos.
     *
     * @param id    O identificador único para o nó.
     * @param value O valor associado ao nó.
     */
    public Node(String id, int value) {
        this.id = id;
        this.value = value;
    }

    /**
     * Verifica a igualdade de dois nós com base no seu ID.
     * Essa implementação é crucial para garantir que cada nó seja único dentro do grafo.
     *
     * @param o O objeto a ser comparado com este nó.
     * @return  Verdadeiro se os dois nós forem iguais, falso caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return id.equals(node.id);
    }

    /**
     * Gera um código hash com base no ID do nó.
     * Útil para operações de recuperação eficiente em coleções baseadas em hash, como HashMap.
     *
     * @return O código hash do nó.
     */
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    /**
     * Retorna uma representação em String do nó, que é basicamente seu ID.
     * Útil para fins de depuração e visualização da estrutura do grafo.
     *
     * @return A representação em String do nó.
     */
    @Override
    public String toString() {
        return id + " (Value: " + value + ")";
    }

    public int getValue() {
        return this.value;
    }

    public String getID() {
        return this.id;
    }
}
