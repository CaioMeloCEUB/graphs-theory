class Grafo:
    def __init__(self):
        self.vertices = []
        self.matriz_adjacencia = {}

    def adicionar_vertice(self, vertice):
        if vertice not in self.vertices:
            self.vertices.append(vertice)
            self.matriz_adjacencia[vertice] = {}

    def adicionar_aresta(self, vertice1, vertice2, peso):
        if vertice1 in self.vertices and vertice2 in self.vertices:
            self.matriz_adjacencia[vertice1][vertice2] = peso
            self.matriz_adjacencia[vertice2][vertice1] = peso

    def grau_vertice(self, vertice):
        if vertice in self.vertices:
            return len(self.matriz_adjacencia[vertice])
        return -1

    def matriz_para_string(self):
        matriz_str = "   " + "  ".join(self.vertices) + "\n"
        for v1 in self.vertices:
            linha = v1 + " "
            for v2 in self.vertices:
                if v2 in self.matriz_adjacencia[v1]:
                    linha += f"{self.matriz_adjacencia[v1][v2]:<3} "
                else:
                    linha += "0   "
            matriz_str += linha + "\n"
        return matriz_str

# Criando um grafo vazio
meu_grafo = Grafo()

# Dados do usuário para adicionar vértices e arestas
num_vertices = int(input("Digite o número de vértices: "))
for i in range(num_vertices):
    vertice = input(f"Digite o nome do vértice {i + 1}: ")
    meu_grafo.adicionar_vertice(vertice)

num_arestas = int(input("Digite o número de arestas: "))
for i in range(num_arestas):
    vertice1 = input(f"Digite o nome do vértice de origem da aresta {i + 1}: ")
    vertice2 = input(f"Digite o nome do vértice de destino da aresta {i + 1}: ")
    peso = float(input(f"Digite o peso da aresta entre {vertice1} e {vertice2}: "))
    meu_grafo.adicionar_aresta(vertice1, vertice2, peso)

# Exibir a matriz de adjacência
print("\nMatriz de Adjacência:")
print(meu_grafo.matriz_para_string())

# Exibir o número de vértices
num_vertices_total = len(meu_grafo.vertices)
print(f"Número de vértices no grafo: {num_vertices_total}")

# Exibir a quantidade de graus de cada vértice
for vertice in meu_grafo.vertices:
    grau = meu_grafo.grau_vertice(vertice)
    print(f"Grau do vértice {vertice}: {grau}")

# Calcular e exibir o grau total do grafo
grau_total = sum(meu_grafo.grau_vertice(vertice) for vertice in meu_grafo.vertices)
print(f"Grau total do grafo: {grau_total}")