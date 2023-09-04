from collections import defaultdict

class Grafo(object):
    def __init__(self, aresta, direcao=False):
        self.adj = defaultdict(set)
        self.direcao = direcao
        self.adiciona_aresta(aresta)

    def get_vertice(self):
        return list(self.adj.keys())

    def get_aresta(self):
        return[(x, y) for x in self.adj.keys() for y in self.adj[x]]

    def adiciona_aresta(self, aresta):
        for w, y in aresta:
            self.adiciona_arco(w, y)

    def adiciona_arco(self, w, y):
        self.adj[w].add(y)
        if not self.direcao:
            self.adj[y].add(w)

    def aresta_exist(self, w, y):
        return w in self.adj and y in self.adj[w]

    def __len__(self):
        return len(self.adj)

    def __str__(self):
        return '{}({})'.format(self.__class__.__name__, dict(self.adj))

    def __getitem__(self, y):
        return self.adj[y]


