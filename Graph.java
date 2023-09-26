import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ---- Classe Graph ----
 * 
 * A classe Graph representa a estrutura de dados para um Grafo na Teoria dos Grafos.
 *
 * ---- Tipos de Grafos ----
 * Esta implementação é genérica o suficiente para representar diversos tipos de grafos:
 * - Grafos Direcionados (Digrafos)
 * - Grafos Não-Direcionados
 * - Grafos Ponderados (Arestas com pesos)
 * - Grafos Não-Ponderados
 *
 * ---- Conceitos Formais ----
 * - Vértices: Os nós do grafo, representados pela classe {@link Node}.
 * - Arestas: As conexões entre os nós, representadas pela classe {@link Edge}.
 * - Lista de Adjacência: Uma estrutura de dados eficiente para representar grafos esparsos, armazenada como {@code Map<Node, List<Edge>>}.
 * 
 * ---- Complexidade Computacional ----
 * - Adicionar um Vértice: O(1)
 * - Adicionar uma Aresta: O(1) em média, se ignorarmos o tempo necessário para verificar a duplicação.
 * - Busca: O(1) para vértices e O(V) para arestas, onde V é o número de vértices.
 *
 * ---- Uso Prático ----
 * - Redes Sociais: Utilizado para modelar relações entre indivíduos, podendo ajudar a identificar padrões e recomendar conexões.
 * - Sistemas de Recomendação: Eficiente para filtragem colaborativa, onde os nós podem ser usuários ou itens, e as arestas podem representar preferências ou comportamentos.
 * - Roteamento em Redes: Utilizado em algoritmos como OSPF (Open Shortest Path First) e BGP (Border Gateway Protocol) para encontrar o caminho mais eficiente entre dispositivos em uma rede.
 * - Modelagem de Transporte: Pode ser utilizado para otimizar rotas de veículos, calcular tempos de tráfego e avaliar a eficiência do sistema.
 * - Processamento de Texto: Utilizado em análise de sentimento, classificação de tópicos, e outras aplicações de NLP (Processamento de Linguagem Natural).
 * - Flexibilidade Algorítmica: A classe é projetada para permitir a fácil inclusão de métodos que implementam algoritmos gráficos específicos. Isso inclui, mas não está limitado a, busca em profundidade (DFS), busca em largura (BFS), algoritmos de caminho mais curto como Dijkstra e Floyd-Warshall, e algoritmos de fluxo máximo como Ford-Fulkerson.
 * 
 * ---- Exceções ----
 * - {@link NodeNotFoundException} é lançada se um nó não for encontrado durante a adição de uma aresta.
 * - {@link DuplicatedEdgeException} é lançada se uma aresta duplicada for tentada ser adicionada.
 * 
 * @author Graph Theory Class | UniCEUB | 2-2023
 * @version 0.1
 * @see Node
 * @see Edge
 */
public class Graph {

    /**
     * ---- Campo de Dados: adjacencyList ----
     *
     * O campo 'adjacencyList' é uma estrutura de dados do tipo Map que relaciona cada objeto Node a uma lista de arestas (Edge).
     *
     * ---- Conceitos Formais ----
     * - Representação de Grafos: Grafos podem ser representados de várias formas, e a Lista de Adjacência é uma das mais eficientes em termos de espaço e tempo para determinadas operações.
     * - Complexidade de Espaço: Em uma lista de adjacência, apenas as arestas realmente existentes são armazenadas, tornando-a eficiente em termos de espaço para grafos esparsos.
     * - Grafos Direcionados e Não Direcionados: Este campo é versátil o suficiente para representar tanto grafos direcionados quanto não direcionados. Em um grafo não direcionado, uma aresta entre 'A' e 'B' seria armazenada nas listas de ambos os nós.
     *
     * ---- Insights Práticos ----
     * - Acessibilidade: Usar um Map oferece um acesso de tempo constante O(1) aos vértices e suas respectivas listas de arestas, tornando a estrutura eficiente para consultas e atualizações.
     * - Flexibilidade: Listas de adjacência são dinâmicas; portanto, adicionar ou remover vértices e arestas é feito de forma eficiente.
     * - Compatibilidade com Algoritmos: A maioria dos algoritmos modernos em teoria dos grafos são otimizados para trabalhar com listas de adjacência, tornando este campo adequado para implementações futuras de algoritmos como DFS, BFS, etc.
     *
     * Em resumo, 'adjacencyList' é escolhido como o campo de armazenamento do grafo por suas vantagens tanto teóricas quanto práticas em complexidade computacional e flexibilidade de uso.
     */
    private Map<Node, List<Edge>> adjacencyList;

    // Construtor para inicializar a lista de adjacência
    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    // Método para adicionar um Nó com id e valor padrão de 0
    public void addNode(String id) {
        addNode(id, 0);
    }

    // Método para adicionar um Nó com id e valor específicos
    public void addNode(String id, int value) {
        Node node = new Node(id, value);
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    /**
     * Adiciona uma aresta direcionada ao grafo entre dois nós específicos.
     * 
     * Conceitos Formais:
     * - Aresta Direcionada: Uma ligação entre dois nós que vai de um nó de origem a um nó de destino. 
     *   Neste caso, a aresta é orientada do nó com ID 'sourceId' para o nó com ID 'destinationId'.
     * 
     * Insights Práticos:
     * - Útil em cenários onde a direção importa, como em sistemas de rotas, fluxos de trabalho ou grafos de dependência.
     * 
     * @param sourceId O ID do nó de origem.
     * @param destinationId O ID do nó de destino.
     * @param create Um booleano que indica se o nó deve ser criado caso ainda não exista.
     * @throws NodeNotFoundException Se o nó não existir e 'create' for falso.
     * @throws DuplicatedEdgeException Se a aresta já existir.
     */
    public void addEdge(String sourceId, String destinationId, boolean create) throws NodeNotFoundException, DuplicatedEdgeException {
        addEdge(sourceId, destinationId, 0, create);
    }

    /**
     * Adiciona uma aresta não direcionada ao grafo.
     * 
     * Conceitos Formais:
     * - Aresta Não Direcionada: Uma ligação entre dois nós que não tem uma direção específica.
     *   Neste caso, são criadas duas arestas direcionadas para emular uma aresta não direcionada.
     * 
     * Insights Práticos:
     * - Útil em cenários como redes sociais, onde uma amizade é mutual.
     * 
     * @param sourceId O ID do primeiro nó.
     * @param destinationId O ID do segundo nó.
     * @param edgeValue O valor (peso) da aresta.
     * @param create Um booleano que indica se o nó deve ser criado caso ainda não exista.
     * @throws NodeNotFoundException Se o nó não existir e 'create' for falso.
     * @throws DuplicatedEdgeException Se a aresta já existir.
     */
    public void addUndirectedEdge(String sourceId, String destinationId, int edgeValue, boolean create) throws NodeNotFoundException, DuplicatedEdgeException {
        addEdge(sourceId, destinationId, edgeValue, create);
        addEdge(destinationId, sourceId, edgeValue, create);
    }

    /**
     * Adiciona uma aresta direcionada com um valor específico ao grafo.
     * 
     * Conceitos Formais:
     * - Grafo Ponderado: Um grafo onde cada aresta tem um peso ou valor associado.
     * 
     * Insights Práticos:
     * - Útil em cenários como mapas de rotas, onde o peso pode representar distância, tempo ou custo.
     * 
     * @param sourceId O ID do nó de origem.
     * @param destinationId O ID do nó de destino.
     * @param edgeValue O valor (peso) da aresta.
     * @param create Um booleano que indica se os nós devem ser criados caso ainda não existam.
     * @throws NodeNotFoundException Se o nó não existir e 'create' for falso.
     * @throws DuplicatedEdgeException Se a aresta já existir.
     */
    public void addEdge(String sourceId, String destinationId, int edgeValue, boolean create) throws NodeNotFoundException, DuplicatedEdgeException {
        Node sourceNode = new Node(sourceId, 0);
        Node destinationNode = new Node(destinationId, 0);

        ensureNodeExistsOrCreated(sourceNode, create);
        ensureNodeExistsOrCreated(destinationNode, create);
        ensureEdgeIsUnique(sourceNode, destinationNode);

        adjacencyList.get(sourceNode).add(new Edge(sourceNode, destinationNode, edgeValue));
    }

    /**
     * Retorna a matriz de adjacência do grafo.
     * 
     * Conceitos Formais:
     * - Matriz de Adjacência: É uma matriz quadrada usada para representar um grafo finito.
     *   O elemento matrix[i][j] é 1 se existe uma aresta do vértice i ao vértice j, e 0 caso contrário.
     * 
     * Insights Práticos:
     * - Útil quando é necessário realizar operações matriciais no grafo, como encontrar o caminho mais curto.
     * 
     * @return Uma matriz 2D de inteiros representando a matriz de adjacência do grafo.
     */
    public int[][] getAdjacencyMatrix() {
        int size = adjacencyList.size();        // Número de nós no grafo
        int[][] matrix = new int[size][size];   // Inicializa a matriz de adjacência com zeros
        List<Node> nodes = getNodesList();      // Obtém a lista de nós no grafo

        fillAdjacencyMatrix(matrix, nodes);     // Preenche a matriz de adjacência com os valores apropriados

        return matrix;
    }

    /**
     * Obtém uma lista de nós do grafo.
     * 
     * Conceitos Formais:
     * - Vértice (Nó): Elemento básico do qual os grafos são formados.
     * 
     * Insights Práticos:
     * - Útil para iterações onde você precisa acessar todos os nós. Por exemplo, quando você está preenchendo
     *   a matriz de adjacência ou buscando um nó específico.
     * 
     * @return Uma lista contendo todos os nós no grafo.
     */
    public List<Node> getNodesList() {
        return new ArrayList<>(adjacencyList.keySet());
    }

    /**
     * Retorna o valor de uma aresta entre um nó de origem e um nó de destino.
     * 
     * Conceitos Formais:
     * - Peso de Aresta: Um número associado a uma aresta em um grafo ponderado.
     * - Grafo Ponderado: Um grafo em que cada aresta tem um peso ou valor associado.
     * - Aresta: Um par ordenado ou não ordenado de nós conectados em um grafo.
     * 
     * Insights Práticos:
     * - Essa função é particularmente útil em algoritmos que precisam considerar o peso das arestas,
     *   como algoritmos de caminho mínimo ou máxima vazão.
     * - Também é usado internamente para preencher a matriz de adjacência com os pesos das arestas.
     * 
     * @param source Nó de origem da aresta.
     * @param target Nó de destino da aresta.
     * 
     * @return Retorna o valor (peso) da aresta entre os nós de origem e destino.
     *         Retorna 0 se não existe uma aresta entre os dois nós.
     */
    public int getEdgeValue(Node source, Node target) {
        List<Edge> edges = adjacencyList.get(source);   // Obtém a lista de arestas associadas ao nó de origem
        if (edges != null) {                            // Verifica se a lista de arestas não é nula (o nó de origem existe no grafo)
            for (Edge edge : edges) {                   // Itera sobre todas as arestas associadas ao nó de origem
                if (edge.destination.equals(target)) {  // Verifica se a aresta aponta para o nó de destino
                    return edge.value;                  // Retorna o valor (peso) da aresta
                }
            }
        }

        // 'return 0;' atua como um valor padrão retornado pela função quando não é encontrada
        // uma aresta entre os nós 'source' e 'target'.
        //
        // ---- Conceitos Formais ----
        // - Grafo Não-Ponderado: Em um contexto de um grafo não-ponderado, a ausência de uma
        //   aresta entre dois nós pode ser representada por 0 em uma matriz de adjacência.
        // - Matriz de Adjacência: É uma matriz quadrada usada para representar um grafo finito.
        //   O elemento 'A[i][j]' representa o peso da aresta entre os nós 'i' e 'j'. A ausência
        //   de uma aresta é frequentemente representada por 0.
        //
        // ---- Insights Práticos ----
        // - Eficiência Computacional: Retornar 0 simplifica o tratamento de casos onde uma aresta
        //   não existe entre dois nós, evitando a necessidade de verificar por valores 'null' ou exceções.
        // - Utilidade em Algoritmos: Algoritmos que utilizam a matriz de adjacência frequentemente
        //   assumem que o valor 0 indica a ausência de uma aresta, o que torna a implementação mais direta.
        //
        // Nesse contexto, o 'return 0;' é tanto uma prática padrão em teoria dos grafos quanto uma
        // decisão prática para simplificar o manuseio de grafos em algoritmos e aplicações.

        return 0;  // Retorna 0 se não encontrar uma aresta entre os nós de origem e destino
    }

    private void ensureNodeExistsOrCreated(Node node, boolean create) throws NodeNotFoundException {
        if (!adjacencyList.containsKey(node)) {
            if (create) {
                addNode(node.id, node.value);
            } else {
                throw new NodeNotFoundException("Node with ID " + node.id + " does not exist.");
            }
        }
    }

    private void ensureEdgeIsUnique(Node source, Node destination) throws DuplicatedEdgeException {
        List<Edge> edges = adjacencyList.get(source);
        if (edges != null && edges.stream().anyMatch(edge -> edge.destination.equals(destination))) {
            throw new DuplicatedEdgeException("Edge from " + source + " to " + destination + " already exists.");
        }
    }

    private void fillAdjacencyMatrix(int[][] matrix, List<Node> nodes) {
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = 0; j < nodes.size(); j++) {
                matrix[i][j] = getEdgeValue(nodes.get(i), nodes.get(j));
            }
        }
    }



    public void printAdjacencyMatrix() {
        int[][] matrix = this.getAdjacencyMatrix();
        List<Node> nodes = this.getNodesList();
        System.out.print("    ");
        for (Node node : nodes) {
            System.out.print(node.id + " ");
        }
        System.out.println();

        // Imprimir a matriz junto com os rótulos dos nós para as linhas
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(nodes.get(i).id + "   ");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }    

    public void printGraph() {
        for (Node node : adjacencyList.keySet()) {
            List<Edge> edges = adjacencyList.get(node);
            System.out.println("Node " + node + " has edges: " + edges);
        }
    }
}
