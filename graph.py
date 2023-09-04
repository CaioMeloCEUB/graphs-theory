class Edge:
    def __init__(self, n1, n2, w=None):
        self.node1 = n1
        self.node2 = n2
        self.weight = w

    def print_info(self):
        if self.weight is not None:
            print(f"{self.node1.get_name()} --({self.weight})-- {self.node2.get_name()}")
        else:
            print(f"{self.node1.get_name()} -- {self.node2.get_name()}")


class Node:
    def __init__(self, n):
        self.name = n

    def get_name(self):
        return self.name


class Graph:
    def __init__(self):
        self.nodes = []
        self.edges = set()

    def add_node(self, n):
        self.nodes.append(n)

    def add_edge(self, n1, n2, w=None):
        node1 = None
        node2 = None

        # Procurar os nós correspondentes na lista de nós
        for node in self.nodes:
            if node.get_name() == n1:
                node1 = node
            if node.get_name() == n2:
                node2 = node

        # Verificar se os nós existem
        if node1 is None:
            node1 = Node(n1)
            self.add_node(node1)
        if node2 is None:
            node2 = Node(n2)
            self.add_node(node2)

        # Adicionar a aresta ao conjunto de arestas
        edge = Edge(node1, node2, w)
        self.edges.add(edge)

    def print_graph(self):
        for edge in self.edges:
            edge.print_info()


# Exemplo de uso:
graph = Graph()

# Adicionar nós
graph.add_node(Node("A"))
graph.add_node(Node("B"))
graph.add_node(Node("C"))

# Adicionar arestas
graph.add_edge("A", "B", 5)
graph.add_edge("B", "C", 3)
graph.add_edge("A", "C", 2)

# Imprimir informações do grafo
graph.print_graph()
