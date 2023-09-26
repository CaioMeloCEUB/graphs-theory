package demelo.graph;

/**
 * Classe Node representa um Nó ou Vértice em um grafo, um dos pilares fundamentais na teoria dos grafos.
 * O outro pilar são as arestas que ligam esses nós. Cada nó possui um identificador único 'id' e um valor 'value',
 * que podem ser usados para modelar diversas situações práticas, como representação de cidades em um mapa,
 * estados em um autômato ou até usuários em uma rede social.
 *
 * O campo 'id' serve como rótulo único, permitindo identificação e diferenciação rápidas dos nós em um grafo.
 * Ele pode ser utilizado como chave primária em um banco de dados ou como identificador de objeto em aplicações.
 *
 * Importante: Esta classe define o nó em termos de sua identidade e informações associadas, mas não em termos
 * de suas conexões com outros nós, que são gerenciadas externamente, comumente por uma classe Graph.
 */
public class Node {

    private String id;
   
    /**
     * O valor associado ao nó.
     * Em grafos ponderados, este valor pode representar uma métrica como custo, distância, relevância ou capacidade.
     * Em grafos não ponderados, este valor pode não ter significado.
     * 
     * Aplicações práticas:
     * - Em algoritmos de roteamento, o valor representa o custo para viajar até este nó a partir de um nó adjacente.
     * - Em redes sociais, o valor poderia representar o nível de influência ou popularidade de um usuário.
     * - Em sistemas de recomendação, o valor representa a avaliação ou a relevância de um item.
     */
    private int value;


    /**
     * Construtor que inicializa o nó com um identificador único.
     *
     * @param id O identificador único do nó.
     */
    public Node(String id) {
        this.id = id;
    }

    /**
     * Construtor que inicializa o nó com um identificador único e um valor associado.
     *
     * @param id    Identificador único do nó.
     * @param value Valor associado ao nó.
     */
    public Node(String id, int value) {
        this.id = id;
        this.value = value;
    }

    /**
     * Sobrescreve o método equals para comparar a igualdade entre dois nós baseando-se no identificador.
     *
     * @param o Objeto a ser comparado.
     * @return Verdadeiro se os identificadores forem iguais, falso caso contrário.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return id.equals(node.id);
    }

    /**
     * Sobrescreve o método hashCode para fornecer um hash consistente baseado no identificador do nó.
     *
     * @return O código hash gerado com base no identificador.
     */
    @Override
    public int hashCode() {
        return id.hashCode();
    }

    /**
     * Representação textual do nó, útil para depuração e representação do estado do objeto.
     *
     * @return String que representa o estado atual do nó.
     */
    @Override
    public String toString() {
        return id + " (Value: " + value + ")";
    }

     /**
     * Retorna o valor associado a este nó.
     * Este valor pode representar diversas métricas em um grafo ponderado, como custo ou distância.
     * Em um grafo não ponderado, o valor pode não ter um significado específico.
     *
     * @return O valor inteiro associado a este nó.
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Retorna o identificador único deste nó.
     * O identificador é crucial para distinguir os nós dentro de um grafo e é frequentemente usado
     * como chave em estruturas de dados que armazenam os nós.
     *
     * @return A String que representa o identificador único deste nó.
     */
    public String getID() {
        return this.id;
    }
}
