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

    #graph.display_graph()

    # Exercício 1: O grau de um determinado vértice;
    #print(rodrigo.get_rate())
    #print(f'O grau do vértice {leonardo.name} é de {leonardo.get_rate()}\n')
    
    
    # Exercício 2: A vizinhança de um determinado vértice;
    #jair.get_neighborhood()

    # Exercício 3: A verificação booleana se o Grafo é completo;
    print(graph.is_complete())
    print(graph_complete.is_complete())



