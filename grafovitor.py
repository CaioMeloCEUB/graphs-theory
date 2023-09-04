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
    #os parâmetros arestas e nos da classe Graph são definidos como None por padrão e, em seguida, verificados se são None antes de serem atribuídos como listas vazias. Isso garante que o código funcione mesmo se nenhum valor for passado ao criar uma instância da classe Graph
        
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
    
    def grafo_completo(self):
        quantos_nos = len(self.nos)
        for no in self.nos:
            grau = self.grau_do_vertice(no)
            if grau != quantos_nos - 1:
                return False
        return True
    
    def verificar_conexo(self):

        if not self.nos: 
            return print("Grafo vazio")

        vertice_inicial = self.nos[0]
        visitados = set()
        fila = [vertice_inicial]

        while fila:

            vertice = fila.pop(0)
            visitados.add(vertice)
            vizinhos = [v for v in self.vizinhanca_do_vertice(vertice) if v not in visitados]
            fila.extend(vizinhos)

        
        return len(visitados) == len(self.nos)
    

        
if __name__ == "__main__":
    Grafo2 = Graph()
    grafo_conexo2 = Grafo2.verificar_conexo()
    print(grafo_conexo2)
    no1 = Node("gama")
    no2 = Node("ceilandia")
    no3 = Node("taguatinga")
    aresta1 = Edge(no1, no2, 20)
    aresta2 = Edge(no2, no3, 15)
    aresta3 = Edge(no1, no3, 60)
    
    nos_do_grafo = [no1, no2, no3]
    grafo = Graph([], nos_do_grafo)
    
    # Adicione as arestas ao grafo
    grafo.adicionar_aresta(aresta1)
    grafo.adicionar_aresta(aresta2)
    grafo.adicionar_aresta(aresta3)
    
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

    verificar_grafo_completo = grafo.grafo_completo()
    print(verificar_grafo_completo)

    grafo_conexo = grafo.verificar_conexo()
    print(grafo_conexo)