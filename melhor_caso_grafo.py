import heapq
import time


class Grafo:
    def __init__(self):
        self.vertices = set()
        self.arestas = []

    def adicionar_cidade(self, cidade):
        self.vertices.add(cidade)

    def adicionar_estrada(self, cidade1, cidade2, distancia):
        self.arestas.append((cidade1, cidade2, distancia))
        self.arestas.append((cidade2, cidade1, distancia))


def criar_arvore_geradora_minima():
    grafo = Grafo()

    # Adiciona cidades fictícias ao grafo
    cidades = ['Cidade_1', 'Cidade_2', 'Cidade_3', 'Cidade_4', 'Cidade_5', 'Cidade_6', 'Cidade_7', 'Cidade_8',
               'Cidade_9', 'Cidade_10', 'Cidade_11', 'Cidade_12', 'Cidade_13', 'Cidade_14', 'Cidade_15', 'Cidade_16',
               'Cidade_17', 'Cidade_18', 'Cidade_19', 'Cidade_20', 'Cidade_21', 'Cidade_22', 'Cidade_23', 'Cidade_24',
               'Cidade_25', 'Cidade_26', 'Cidade_27', 'Cidade_28', 'Cidade_29', 'Cidade_30', 'Cidade_31', 'Cidade_32',
               'Cidade_33', 'Cidade_34', 'Cidade_35', 'Cidade_36', 'Cidade_37', 'Cidade_38', 'Cidade_39', 'Cidade_40',
               'Cidade_41', 'Cidade_42', 'Cidade_43', 'Cidade_44', 'Cidade_45', 'Cidade_46', 'Cidade_47', 'Cidade_48',
               'Cidade_49', 'Cidade_50', 'Cidade_51', 'Cidade_52', 'Cidade_53', 'Cidade_54', 'Cidade_55', 'Cidade_56',
               'Cidade_57', 'Cidade_58', 'Cidade_59', 'Cidade_60', 'Cidade_61', 'Cidade_62', 'Cidade_63', 'Cidade_64',
               'Cidade_65', 'Cidade_66', 'Cidade_67', 'Cidade_68', 'Cidade_69', 'Cidade_70', 'Cidade_71', 'Cidade_72',
               'Cidade_73', 'Cidade_74', 'Cidade_75', 'Cidade_76', 'Cidade_77', 'Cidade_78', 'Cidade_79', 'Cidade_80',
               'Cidade_81', 'Cidade_82', 'Cidade_83', 'Cidade_84', 'Cidade_85', 'Cidade_86', 'Cidade_87', 'Cidade_88',
               'Cidade_89', 'Cidade_90', 'Cidade_91', 'Cidade_92', 'Cidade_93', 'Cidade_94', 'Cidade_95', 'Cidade_96',
               'Cidade_97', 'Cidade_98', 'Cidade_99', 'Cidade_100']

    for cidade in cidades:
        grafo.adicionar_cidade(cidade)

    # Adiciona estradas entre todas as combinações de cidades com distâncias fictícias
    for i in range(len(cidades)):
        for j in range(i + 1, len(cidades)):
            distancia = (i + j) * 10  # Distância fictícia
            grafo.adicionar_estrada(cidades[i], cidades[j], distancia)

    return grafo


def prim(grafo):
    mst = []
    vertices_conectados = set()

    # Escolhe o primeiro vértice como ponto de partida
    primeiro_vertice = grafo.vertices.pop()
    vertices_conectados.add(primeiro_vertice)

    while len(vertices_conectados) < len(grafo.vertices):
        menor_distancia = float('inf')
        aresta_menor_distancia = None

        for origem in vertices_conectados:
            for destino, distancia in obter_estradas_vizinhas(grafo, origem):
                if destino not in vertices_conectados and distancia < menor_distancia:
                    menor_distancia = distancia
                    aresta_menor_distancia = (origem, destino, distancia)

        if aresta_menor_distancia:
            mst.append(aresta_menor_distancia)
            vertices_conectados.add(aresta_menor_distancia[1])

    return mst


def obter_estradas_vizinhas(grafo, cidade):
    estradas = []
    for cidade_origem, cidade_destino, distancia in grafo.arestas:
        if cidade_origem == cidade:
            estradas.append((cidade_destino, distancia))
    return estradas


if __name__ == "__main__":
    grafo_melhor_caso = criar_arvore_geradora_minima()

    # Medição de tempo de início
    inicio = time.time()

    # Executa o algoritmo de Prim
    estradas_construidas = prim(grafo_melhor_caso)

    # Medição de tempo de término
    fim = time.time()

    print("Árvore Geradora Mínima com Cidades Fictícias:")
    for aresta in estradas_construidas:
        cidade_origem, cidade_destino, distancia = aresta
        print(f"{cidade_origem} - {cidade_destino}, Distância: {distancia} km")

    tempo_execucao = fim - inicio
    print(f"Tempo de Execução: {tempo_execucao:.6f} segundos")
