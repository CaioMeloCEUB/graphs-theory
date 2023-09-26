
/**
 * Classe para representar uma exceção de aresta não encontrada em algoritmos de grafos.
 * <p>
 * Esta exceção é lançada quando uma operação tenta acessar uma aresta que não existe no grafo.
 * Tratar essa exceção é essencial para a robustez dos algoritmos de grafos, garantindo que eles
 * possam lidar com condições de erro e estados inconsistentes.
 * </p>
 *
 * @see Exception
 */
public class EdgeNotFoundException extends Exception {
    /**
     * Construtor que inicializa a exceção com uma mensagem específica.
     *
     * @param message A mensagem de erro detalhada.
     */
    public EdgeNotFoundException(String message) {
        super(message);
    }
}