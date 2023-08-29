class Edge:
    def __init__(self, node1, node2, valor):
        self.node1 = node1
        self.node2 = node2
        self.valor = valor

        
class Node:
    def __init__(self, nome):
        self.nome = nome

class Graph:
    def __init__(self, arestas=None, nos=None):
        self.arestas = arestas if arestas is not None else []
        self.nos = nos if nos is not None else []
        
    def adicionar_aresta(self, aresta):
        self.arestas.append(aresta)

    def adicionar_no(self, no):
        self.nos.append(no)
        
    def grau_do_vertice(self, vertice):
        grau = 0
        for aresta in self.arestas:
            if aresta.node1 == vertice or aresta.node2 == vertice:
                grau += 1
        return grau
    
    def vizinhanca_do_vertice(self, vertice):
        vizinhanca = []
        for aresta in self.arestas:
            if aresta.node1 == vertice:
                vizinhanca.append(aresta.node2)
            elif aresta.node2 == vertice:
                vizinhanca.append(aresta.node1)
        return vizinhanca
        
if __name__ == "__main__":
    no1 = Node("gama")
    no2 = Node("ceilandia")
    no3 = Node("taguatinga")
    aresta1 = Edge(no1, no2, 20)
    aresta2 = Edge(no2, no3, 15)
    
    nos_do_grafo = [no1, no2, no3]
    grafo = Graph([], nos_do_grafo)
    
    # Adicione as arestas ao grafo
    grafo.adicionar_aresta(aresta1)
    grafo.adicionar_aresta(aresta2)
    
    print("Nós do grafo:")
    for no in grafo.nos:
        print(no.nome)
    
    print("Arestas do grafo:")
    for aresta in grafo.arestas:
        print(f"{aresta.node1.nome} e {aresta.node2.nome}, valor: {aresta.valor}")
    
    vertice_alvo = no2
    grau_vertice = grafo.grau_do_vertice(vertice_alvo)
    print(f"O grau do vértice {vertice_alvo.nome} é: {grau_vertice}")
    
    vizinhanca_vertice = grafo.vizinhanca_do_vertice(vertice_alvo)
    print(f"Vizinhança do vértice {vertice_alvo.nome}: {[v.nome for v in vizinhanca_vertice]}")