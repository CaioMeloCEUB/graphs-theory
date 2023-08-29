class Edge:
    def __init__(self, n1, n2, w=None):
        self.node1 = n1
        self.node2 = n2
        self.weight = w

    def print_info(self):
        print(f"{self.node1.get_name()} | {self.node2.get_name()} | {self.weight}")


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

    def add_edge(self, e):
        self.edges.add(e)

    def print_graph(self):
        for e in self.edges:
            e.print_info()

