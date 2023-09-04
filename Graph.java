import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
    private List<Node> nodes;

    public void printNodes() {

        for (Node e : nodes) {
            System.out.println(e.getName());
            for (Node j : e.getNeighbours().keySet()) {
                System.out.printf("n" + j.getName() + " ");
            }
            System.out.println("\n");
        }
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public Boolean isComplete(){
        if(((nodes.size()*(nodes.size()-1))/2) != nodes.size()-1){
            System.out.println("Não é Completo");
            return Boolean.FALSE;
        } else {
            System.out.println("É Completo");
            return Boolean.TRUE;
        }
    }
    public void isAssociated(){
        /*
        Basicamente, para saber se é conexo, é preciso fazer uma comparação entre as listas de neighbours,
        se você conseguir chegar em qualquer vertice atraves de outro o grafo é conexo, então atraves dos vertices
        vizinhos, se voce conseguir chegar em qualquer vertice do grafo o mesmo é conexo, caso contrário, não é.
        */

    }

    public void checkPath(Node v1, Node v2){
        /*
            Circuito: Repete o primeiro e ultimo vertice, mas não repete nenhum outro.
            Caminho: Passeio sem vertices repetidos.
        */
        List <String> passeio = new ArrayList<String>();
        passeio.add(v1.getName());
        int contador = 0;
        while(passeio.get(contador) != v2.getName()){
            for(Node x : v1.getNeighbours().keySet()){
                if(x.getName() == v2.getName()){
                    passeio.add(x.getName());
                    System.out.println(passeio);
                }else{
                    for(Node y : x.getNeighbours().keySet()){

                    }
                }
            }
            contador++;
        }


    }

    @Override
    public String toString() {
        return "Graph{" +
                "nodes=" + nodes +
                '}';
    }
}
