class Node:
    def __init__(self, name):
        self.name = name
        self.rate = 0
        self.relations = {}

    def add_relation(self, node, relation):
        self.relations[node] = relation

    def get_rate(self):
        self.rate = 0
        for related_node, relation in self.get_relations().items():
            self.rate += 1
        return self.rate
        

    def get_neighborhood(self):
        print(f"Os vizinhos de {self.name} são:")
        for k, v in self.relations.items():
            print(f'- {k.name}')

    def get_relations(self):
        return self.relations


class Graph:
    def __init__(self):
        self.nodes = set()

    def add_node(self, node):
        self.nodes.add(node)

    def create_relation(self, node1, node2, relation):
        node1.add_relation(node2, relation)

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
    def depth_search(self, node, visited:set):
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
    graph_complete = Graph()

    nodes = [taube, valeria, desine, andrea, daise, jair, rodrigo, ricardo, marta, alexandre, guerda, leonardo, camila]
    for node in nodes:
        graph.add_node(node)
        pass
    
    graph_complete.add_node(leonardo)
    graph_complete.add_node(camila)
    graph_complete.add_node(rodrigo)

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

    graph_complete.create_relation(leonardo, camila, "irmão de")
    graph_complete.create_relation(leonardo, rodrigo, "filho de")

    graph_complete.create_relation(camila, leonardo, "irmã de")
    graph_complete.create_relation(camila, rodrigo, "filha de")

    graph_complete.create_relation(rodrigo, leonardo, "pai de")
    graph_complete.create_relation(rodrigo, camila, "pai de")

    # Exercício 1: O grau de um determinado vértice;
    print(rodrigo.get_rate())
    print(f'O grau do vértice {leonardo.name} é de {leonardo.get_rate()}')
    print()

    # Exercício 2: A vizinhança de um determinado vértice;
    jair.get_neighborhood()
    print()

    # Exercício 3: A verificação booleana se o Grafo é completo;
    print(graph.is_complete())
    print(graph_complete.is_complete())
    print()

    # Exercício 4: A verificação booleana se o Grafo é conexo.
    print(graph.is_connected())
    print(graph_complete.is_connected())
    print()


