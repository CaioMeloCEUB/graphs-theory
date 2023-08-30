class Node:

    def __init__(self, name:str):
        self.name = name
        self.relations = {}

    def add_relation(self, node:'Node', relation):
        self.relations[node] = relation


    def get_rate(self):
        return len(self.relations)
        

    def get_neighborhood(self):
        print(f"Os vizinhos de {self.name} são:")
        for k, v in self.relations.items():
            print(f'- {k.name}')


    def get_relations(self):
        return self.relations



class Graph:

    def __init__(self):
        self.nodes = set()


    def add_node(self, node:Node):
        self.nodes.add(node)


    def create_relation(self, node1:Node, node2:Node, relation, direcionado=True):
        if direcionado:
            # direcionado
            node1.add_relation(node2, relation)
        else:
            # não direcionado
            node1.add_relation(node2, relation)
            node2.add_relation(node1, relation)


    def is_complete(self):
        n = len(self.nodes)

        for node in self.nodes:
            if node.get_rate() != n - 1:
                return False
        return True
    

    '''
    esse depth search é a busca em profundidade que pelo o que eu pesquisei é um algoritmo para caminhar no grafo; 
    Definição:
    - Seu núcleo se concentra em buscar, sempre que possível, o mais fundo no grafo. As arestas são exploradas a partir do vértice v mais recentemente descoberto que ainda possui arestas não exploradas saindo dele. 
    
    Eu vi que fazer uma função recursiva era uma boa opção
    Basicamente ele vai caminhando nos vizinhos e salvando eles, se no final os visitados forem iguais a todos os nodes do grafo significa que ele andou por todos os nós e, consequentemente, é conexo.
    '''
    def depth_search(self, node:Node, visited:set[Node]):
        visited.add(node)
        for neighbor in node.get_relations():
            if neighbor not in visited:
                self.depth_search(neighbor, visited)


    def is_connected(self):
        visited = set()
        # nó start
        start_node = next(iter(self.nodes))
        self.depth_search(start_node, visited)
        # Retorna True se todos os nós foram visitados, False caso contrário
        return len(visited) == len(self.nodes)


    def path_circuit(self, vertices_list:list[Node]):
        if len(vertices_list) < 2:
            print("Não é um caminho nem um circúito por ter nenhum ou apenas um vértice")
            return 
        
        for i in range(len(vertices_list) - 1): # eu diminui um porque quero comparar cada vértice da lista com o próximo, então se eu não colocar o -1 ele da um erro de out of index
            if vertices_list[i + 1] not in vertices_list[i].get_relations(): # aqui eu quero saber se o próximo vértice da lista não está na relação do vértice atual, se não estiver é pq não é um cacminho ou um circuito
                print("Não é um caminho ou um circúito")
                return

        if vertices_list[0] == vertices_list[-1]:
            print("É um circúito e um caminho")
        else:
            print("É um Caminho")
            

if __name__ == "__main__":
    taube = Node("Taube")
    valeria = Node("Valeria")
    desine = Node("Desine")
    andrea = Node("Andrea")
    daise = Node("Daise")
    jair = Node("Jair")
    rodrigo = Node("Rodrigo")
    ricardo = Node("Ricardo")
    marta = Node("Marta")
    alexandre = Node("Alexandre")
    guerda = Node("Guerda")
    leonardo = Node("Leonardo")
    camila = Node("Camila")

    graph = Graph()
    #graph_complete = Graph()

    nodes = [taube, valeria, desine, andrea, daise, jair, rodrigo, ricardo, marta, alexandre, guerda, leonardo, camila]
    for node in nodes:
        graph.add_node(node)
        pass
    
    '''graph_complete.add_node(leonardo)
    graph_complete.add_node(camila)
    graph_complete.add_node(rodrigo)'''

    graph.create_relation(taube, valeria, "pai de")
    graph.create_relation(taube, desine, "pai de")
    graph.create_relation(taube, andrea, "pai de")
    graph.create_relation(daise, valeria, "mãe de")
    graph.create_relation(daise, desine, "mãe de")
    graph.create_relation(daise, andrea, "mãe de")
    graph.create_relation(jair, rodrigo, "pai de")
    graph.create_relation(jair, ricardo, "pai de")
    graph.create_relation(jair, marta, "pai de")
    graph.create_relation(jair, alexandre, "pai de")
    graph.create_relation(guerda, rodrigo, "mãe de")
    graph.create_relation(guerda, ricardo, "mãe de")
    graph.create_relation(guerda, marta, "mãe de")
    graph.create_relation(guerda, alexandre, "mãe de")
    graph.create_relation(rodrigo, leonardo, "pai de")
    graph.create_relation(rodrigo, camila, "pai de")
    graph.create_relation(valeria, leonardo, "mãe de")
    graph.create_relation(valeria, camila, "mãe de")
    graph.create_relation(leonardo, camila, "irmão de")
    graph.create_relation(camila, leonardo, "irmã de")
    graph.create_relation(leonardo, rodrigo, "filho de")
    graph.create_relation(camila, rodrigo, "filha de")
    

    # Grafo completo para testar a função, comentei pois já fiz o teste. Também porque o create_relation interfere no Node que por sua vez interfere no outro graph
    '''graph_complete.create_relation(leonardo, camila, "irmão de")
    graph_complete.create_relation(leonardo, rodrigo, "filho de")
    graph_complete.create_relation(camila, leonardo, "irmã de")
    graph_complete.create_relation(camila, rodrigo, "filha de")
    graph_complete.create_relation(rodrigo, leonardo, "pai de")
    graph_complete.create_relation(rodrigo, camila, "pai de")'''

    # Exercício 1: O grau de um determinado vértice;
    print(f'O grau do vértice {leonardo.name} é de {leonardo.get_rate()}')
    print()

    # Exercício 2: A vizinhança de um determinado vértice;
    jair.get_neighborhood()
    print()

    # Exercício 3: A verificação booleana se o Grafo é completo;
    print('O grafo é completo? ', graph.is_complete())
    #print(graph_complete.is_complete())
    print()

    # Exercício 4: A verificação booleana se o Grafo é conexo.
    print('O grafo é conexo?', graph.is_connected())
    #print(graph_complete.is_connected())
    print()

    # Exercício 5: Fornecido um conjunto de vértices indicar se os mesmos representam um caminho, um circuito ou as duas possibilidades.
    graph.path_circuit([taube, valeria, camila])
    graph.path_circuit([rodrigo, camila, leonardo, rodrigo])
    graph.path_circuit([jair, andrea])
    print()

    #===========================================
    # Booooooonus Round: Responda a avaliação 1 utilizando o código feito: https://forms.gle/5G1F7v8Uak2p68916
    '''
    Uma universidade está conectada à exatamente dois data centers. 
    Dois data centers compartilham uma única universidade.
    O delay do link de conexão entre os data centers é igual para todas as universidade. 
    '''

    # Criando os 13 nós
    data_centers = [Node(f"DataCenter {i+1}") for i in range(13)]

    graph_bonus = Graph()

    for node in data_centers:
        graph_bonus.add_node(node)
    
    # Como tenho que conectar todos os data centers a todos os outros data centers então vou fazer um loop
    # Conectando cada par de data centers (nodes) com uma universidade (que seria a relação)
    for i in range(13):
        for j in range(i+1, 13):
            graph.create_relation(data_centers[i], data_centers[j], f"University {i+1}-{j+1}", direcionado=False)


    # Bonus 1: O grafo que representa essa rede é completo e todos seus vertices possuem grau 12. 
    print("O grafo é completo? ", graph_bonus.is_complete())
    
    teste_grau = True
    for node in data_centers:
        if node.get_rate() != 12:
            print("Nem todos os vértices tem grau 12")
            teste_grau = False
            break
    if teste_grau == True:
        print("Todos os vértices tem grau 12")
    print()

    # Bonus 2: Quantas universidades fazem parte da rede? -> n*(n-1)/2
    n = len(data_centers)
    rede = n*(n-1)/2
    print(f"{rede} universidades fazem parte da rede")
    print()

    # Bonus 3: 
    '''
    Sabendo que as universidades investiram para construir três novos data centers. E que mantiveram as regras anteriores. Podemos afirmar que:

    [] Com os novos data centers será possível atender 125 universidades.
    [] O grafo complementar dessa rede é um grafo com apenas 1 aresta.
    [] O grafo que representa a rede de data centers pode ser classificado como Euleriano.
    [] Podemos afirmar que o delay mínimo entre dois data centers (w,v) é igual a D * N, onde D é o valor global do delay e Nc é o número mínimo de cidades entre os data centers.
    '''

    # [Falsa] Com os novos data centers será possível atender 125 universidades.
    n = len(data_centers) + 3
    rede = n*(n-1)/2
    print(f"{rede} universidades fazem parte da rede")
    print()

    # [Falsa] O grafo complementar dessa rede é um grafo com apenas 1 aresta.
    # Não tem nenhuma aresta o complementar pq o grafo é completo

    # [Verdadeira] O grafo que representa a rede de data centers pode ser classificado como Euleriano.

    # [Verdadeira] Podemos afirmar que o delay mínimo entre dois data centers (w,v) é igual a D * N, onde D é o valor global do delay e Nc é o número mínimo de cidades entre os data centers.