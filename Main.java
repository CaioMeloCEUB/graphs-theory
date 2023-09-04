import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        List<Node> nodes = new ArrayList<>();

        Node n1 = new Node("1");
        Node n2 = new Node("2");
        Node n3 = new Node("3");
        Node n4 = new Node("4");
        Node n5 = new Node("5");
        Node n6 = new Node("6");

        // Node 1
        HashMap<Node, Double> n1EdgeValues = new HashMap<>();
        n1EdgeValues.put(n5, 2.0);
        n1EdgeValues.put(n2, 3.0);
        n1.setNeighbours(n1EdgeValues);

        // Node 2
        HashMap<Node, Double> n2EdgeValues = new HashMap<>();
        n2EdgeValues.put(n1, 3.0);
        n2EdgeValues.put(n5, 0.0);
        n2EdgeValues.put(n3, 10.0);
        n2.setNeighbours(n2EdgeValues);

        // Node 3
        HashMap<Node, Double> n3EdgeValues = new HashMap<>();
        n3EdgeValues.put(n2, 10.0);
        n3EdgeValues.put(n4, 1.0);
        n3.setNeighbours(n3EdgeValues);

        // Node 4
        HashMap<Node, Double> n4EdgeValues = new HashMap<>();
        n4EdgeValues.put(n5, 4.0);
        n4EdgeValues.put(n3, 1.0);
        n4EdgeValues.put(n6, 0.0);
        n4.setNeighbours(n4EdgeValues);

        // Node 5
        HashMap<Node, Double> n5EdgeValues = new HashMap<>();
        n5EdgeValues.put(n4, 4.0);
        n5EdgeValues.put(n2, 0.0);
        n5EdgeValues.put(n1, 2.0);
        n5.setNeighbours(n5EdgeValues);

        // Node 6
        HashMap<Node, Double> n6EdgeValues = new HashMap<>();
        n6EdgeValues.put(n4, 0.0);
        n6.setNeighbours(n6EdgeValues);

        nodes.add(n1);
        nodes.add(n2);
        nodes.add(n3);
        nodes.add(n4);
        nodes.add(n5);
        nodes.add(n6);

        graph.setNodes(nodes);

        // Questoes do Exercicio

        // O grau de um determinado vértice;
        for (Node e : graph.getNodes()) {
            System.out.println("Vertice " + e.getName() + " " + "Grau: " + e.findDegree());
        }

        // A vizinhança de um determinado vértice;
        graph.printNodes();

        // A verificação booleana se o Grafo é conexo;


        // A verificação booleana se o Grafo é completo.
        graph.isComplete();

        // Fornecido um conjunto de vértices indicar se os mesmos representam um caminho, um circuito ou as duas possibilidades.
        graph.checkPath(n1, n6);


        //Questao Bonus:

        /*1 - O grafo que representa essa rede é completo e todos seus vertices possuem grau 12. */

        /*2 -  Quantas universidades fazem parte da rede?*/

        /*3 - Sabendo que as universidades investiram para construir três novos data centers.
        E que mantiveram as regras anteriores. Podemos afirmar que:

        - Com os novos data centers será possível atender 125 universidades.
        -O grafo complementar dessa rede é um grafo com apenas 1 aresta.
        -O grafo que representa a rede de data centers pode ser classificado como Euleriano.
        -Podemos afirmar que o delay mínimo entre dois data centers (w,v) é igual a D * N,
        onde D é o valor global do delay e Nc é o número mínimo de cidades entre os data centers.

         */

    }
}

/* O usuario determina os valores do proprio grafo
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("""
                              \\t  0 == Terminar Grafo \\t\\n
                              \\t  1 == Construir Grafo \\t\\n
                    Esse é o menu, o que você quer fazer? \n""");
            int option = sc.nextInt();

            if(option == 0){
                break;
            }else if (option == 1){
                System.out.println("Quantos vertices o grafo tem? ");
                int nv = sc.nextInt();
                for (int i=0; i<nv; i++){
                    System.out.println("Insira o nome dos vertices. Vertice atual: " + i + "\nNome: ");
                    String n_name = sc.next();
                    Node n = new Node(n_name);
                    nodes.add(n);
                }
                for(Node item : nodes){
                    System.out.println( nodes.indexOf(item) + ": " + item);
                }
                for(int j = 0; j<nodes.size(); j++){
                    System.out.println("Agora vamos inserir os vizinhos.\nQuantos vizinhos o vertice ["+j+"] tem?");
                    int num = sc.nextInt();
                    int z = 0;
                    List<Integer> viz = new ArrayList<Integer>();
                    System.out.println("Qual o indice de seus vizinhos? ");
                    while(sc.hasNext()){
                        z++;

                    }
                    for(int x=0; x<num; x++){

                        System.out.println("Qual o peso da aresta formada pelo vertice: "+j+" com o vertice: ");

                        HashMap<Node, Double> EdgeValues = new HashMap<>();

                    int z = 0;
                    List<Node> n_viz = new ArrayList<>();

                    //float w = sc.nextFloat();

                        //EdgeValues.put(nodes.get(x),);
                    }

                }
            }
        }
*/