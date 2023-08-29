class Grafo:
    def __init__(self):
        self.grafo = {}

    def adicionar_vertice(self, vertice):
        if vertice not in self.grafo:
            self.grafo[vertice] = []

    def adicionar_aresta(self, vertice1, vertice2):
        if vertice1 in self.grafo and vertice2 in self.grafo:
            self.grafo[vertice1].append(vertice2)
            self.grafo[vertice2].append(vertice1)

    def grau_vertice(self, vertice):
        if vertice in self.grafo:
            return len(self.grafo[vertice])
        return -1

    def peso_aresta(self, vertice):
            if vertice in self.grafo:
                return len(self.grafo[vertice])
            return -1

    def vizinhanca_vertice(self, vertice):
        if vertice in self.grafo:
            return self.grafo[vertice]
        return []

    def __str__(self):
        return str(self.grafo)

# Criando um grafo vazio
meu_grafo = Grafo()

#  dados do usuário para adicionar vértices e arestas
num_vertices = int(input("Digite o número de vértices: "))
for i in range(num_vertices):
    vertice = input(f"Digite o nome do vértice {i + 1}: ")
    meu_grafo.adicionar_vertice(vertice)

num_peso = int(input("digite o peso do vertice: "))
for i in range (num_peso):
    vertice1 = input (f"Digite o valor da aresta :")

num_arestas = int(input("Digite o número de arestas: "))
for i in range(num_arestas):
    vertice1 = input(f"Digite o nome do vértice de origem da aresta {i + 1}: ")
    vertice2 = input(f"Digite o nome do vértice de destino da aresta {i + 1}: ")
    meu_grafo.adicionar_aresta(vertice1, vertice2)

#  calcular o grau
vertice_alvo = input("Digite o vértice para calcular o grau: ")
grau = meu_grafo.grau_vertice(vertice_alvo)

if grau != -1:
    print(f"O grau do vértice {vertice_alvo} é {grau}.")
else:
    print(f"O vértice {vertice_alvo} não foi encontrado no grafo.")

# para mostrar a vizinhança
vertice_alvo_vizinhanca = input("Digite o vértice para mostrar a vizinhança: ")
vizinhanca = meu_grafo.vizinhanca_vertice(vertice_alvo_vizinhanca)

if vizinhanca:
    print(f"A vizinhança do vértice {vertice_alvo_vizinhanca} é: {vizinhanca}.")
else:
    print(f"O vértice {vertice_alvo_vizinhanca} não foi encontrado no grafo.")

# Exibindo o grafo construído
print("\nGrafo construído:")
print(meu_grafo)