/**
 * Classe para representar uma exceção de nó não encontrado em algoritmos de grafos.
 * <p>
 * Esta exceção é lançada quando uma operação tenta acessar um nó que não existe no grafo.
 * O manejo correto desta exceção é fundamental para assegurar a confiabilidade e a acurácia
 * de algoritmos de grafos.
 * </p>
 *
 * @see Exception
 */
class NodeNotFoundException extends Exception {
    /**
     * Construtor que inicializa a exceção com uma mensagem específica.
     *
     * @param message A mensagem de erro detalhada.
     */
    public NodeNotFoundException(String message) {
        super(message);
    }
}