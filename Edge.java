// Classe que representa uma Aresta
// Na teoria dos grafos, uma aresta é um link entre dois nós (também chamados de vértices).
// As arestas podem ser direcionadas ou não direcionadas, e podem ter um valor (ou peso) associado.
class Edge {
    // O nó de origem da aresta.
    // Em uma aresta direcionada, este é o ponto de partida.
    Node source;

    // O nó de destino da aresta.
    // Em uma aresta direcionada, este é o ponto de chegada.
    Node destination;

    // O valor (ou peso) associado à aresta.
    // Em grafos ponderados, as arestas têm um valor que pode representar distâncias, custos, etc.
    int value;

    // Construtor que cria uma aresta sem valor.
    // Útil para grafos não ponderados.
    public Edge(Node source, Node destination) {
        this.source = source;
        this.destination = destination;
    }

    // Construtor que cria uma aresta com um valor.
    // Útil para grafos ponderados.
    public Edge(Node source, Node destination, int value) {
        this.source = source;
        this.destination = destination;
        this.value = value;
    }

    // Retorna uma representação em string da aresta.
    // Esta é uma forma conveniente de visualizar a aresta, especialmente útil para depuração.
    @Override
    public String toString() {
        return source + " -> " + destination;
    }
}
