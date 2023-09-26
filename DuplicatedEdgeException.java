/**
 * Classe para representar uma exceção de aresta duplicada em algoritmos de grafos.
 * <p>
 * Esta exceção é lançada quando uma operação tenta inserir uma aresta já existente no grafo.
 * Em algoritmos de grafos, é crucial garantir que cada aresta seja única para evitar ambiguidades
 * ou resultados incorretos. Portanto, o tratamento dessa exceção é vital para a integridade do grafo.
 * </p>
 *
 * @see Exception
 */
class DuplicatedEdgeException extends Exception {
    /**
     * Construtor que inicializa a exceção com uma mensagem específica.
     *
     * @param message A mensagem de erro detalhada.
     */
    public DuplicatedEdgeException(String message) {
        super(message);
    }
}