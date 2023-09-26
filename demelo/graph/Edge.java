 package demelo.graph;
 
 /**
 * Classe que representa uma Aresta em um grafo.
 * <p>
 * Na teoria dos grafos, uma aresta é uma ligação entre dois vértices (nós).
 * As arestas podem ser direcionadas ou não direcionadas. Em um grafo direcionado, a ordem dos
 * vértices importa, enquanto em um grafo não direcionado, a ordem é irrelevante.
 * As arestas também podem ter um valor (ou peso) associado, o que é comum em grafos ponderados.
 * </p>
 */
public class Edge {

    /**
     * O vértice de origem da aresta.
     * Em grafos direcionados, este é o ponto inicial da aresta.
     * Nos casos de grafos não direcionados, este é apenas um dos vértices conectados pela aresta.
     */
    private Node source;

    /**
     * O vértice de destino da aresta.
     * Em grafos direcionados, este é o ponto final da aresta.
     * Nos casos de grafos não direcionados, este é apenas um dos vértices conectados pela aresta.
     */
    private Node destination;

    /**
     * O valor (ou peso) da aresta.
     * Em grafos ponderados, este valor pode representar distâncias, custos, etc.
     * Em grafos não ponderados, este valor geralmente é ignorado.
     */
    private int value;

    /**
     * Construtor para criar uma aresta sem um valor associado.
     * Esta construção é frequentemente usada em grafos não ponderados.
     * 
     * @param source      O nó de origem da aresta.
     * @param destination O nó de destino da aresta.
     */
    public Edge(Node source, Node destination) {
        this.source = source;
        this.destination = destination;
    }

    /**
     * Construtor para criar uma aresta com um valor associado.
     * Esta construção é frequentemente usada em grafos ponderados.
     * 
     * @param source      O nó de origem da aresta.
     * @param destination O nó de destino da aresta.
     * @param value       O valor (ou peso) associado à aresta.
     */
    public Edge(Node source, Node destination, int value) {
        this.source = source;
        this.destination = destination;
        this.value = value;
    }

    /**
     * Retorna uma representação em String da aresta.
     * Esta função é útil para depuração e para visualizar a estrutura do grafo.
     * 
     * @return Uma string que representa a aresta.
     */
    @Override
    public String toString() {
        return source + " -> " + destination + " (Weight: " + value + ")";
    }

    public Node getDestination() {
        return this.destination;
    }

    public int getValue() {
        return this.value;
    }
}
