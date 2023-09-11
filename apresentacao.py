import heapq  # Importa a biblioteca heapq para usar em nossa implementação do algoritmo.

class Graph:
    def __init__(self):
        # Inicializa a classe do grafo com um dicionário vazio para representar o grafo.
        self.graph = {}

    def add_edge(self, node1, node2, weight):
        # Adiciona uma aresta entre node1 e node2 com o peso especificado ao grafo.
        # Verifica se os nós já existem no grafo; se não, cria uma lista vazia para eles.
        if node1 not in self.graph:
            self.graph[node1] = []
        if node2 not in self.graph:
            self.graph[node2] = []
        # Adiciona a aresta em ambas as direções, já que o grafo é não direcionado.
        self.graph[node1].append((node2, weight))
        self.graph[node2].append((node1, weight))

    def dijkstra(self, start, end):
        # Implementa o algoritmo de Dijkstra para encontrar o menor caminho entre start e end.
        distances = {node: float('inf') for node in self.graph}
        distances[start] = 0
        previous = {}
        heap = [(0, start)]  # Cria uma fila de prioridade com a distância de start para start (0).

        while heap:
            # Remove o nó com a menor distância da fila de prioridade.
            (current_distance, current_node) = heapq.heappop(heap)

            # Verifica se encontramos um caminho mais curto para o nó atual; se não, ignoramos.
            if current_distance > distances[current_node]:
                continue

            # Itera sobre os vizinhos do nó atual.
            for (neighbor, weight) in self.graph[current_node]:
                distance = current_distance + weight

                # Se a nova distância for menor, atualiza as distâncias e predecessores.
                if distance < distances[neighbor]:
                    distances[neighbor] = distance
                    previous[neighbor] = current_node
                    heapq.heappush(heap, (distance, neighbor))

        # Verifica se não há caminho válido para o nó de destino; se não, retorna None.
        if end not in previous:
            return None

        # Constrói o caminho mínimo retrocedendo dos nós de destino para o nó de partida.
        path = []
        while end:
            path.insert(0, end)
            end = previous.get(end)

        return path

# Exemplo de uso:
graph = Graph()

graph.add_edge("Mario", "Acorn Plains", 30)
graph.add_edge("Mario", "Layer-Cake_desert", 5)
graph.add_edge("Mario", "Superstar road", 60)
graph.add_edge("Acorn Plains", "Sparkling waters", 25)
graph.add_edge("sparkling waters", "Soda Jungle", 10) 
graph.add_edge("Layer-Cake_desert", "Soda Jungle", 40)
graph.add_edge("Layer-Cake_desert", "Forest Glacier", 10)
graph.add_edge("Forest Glacier", "Rock-Candy-Mines", 45)
graph.add_edge("Superstar road", "Secret Island", 55)
graph.add_edge("Forest Glacier", "Secret Island", 25)
graph.add_edge("Rock-Candy-Mines",  "Peach's Castle", 30)
graph.add_edge("Soda Jungle", "Peach's Castle", 40)
graph.add_edge("Secret Island", "Peach's Castle", 25)
graph.add_edge("Peach's Castle", "Princesa", 100)
start_node = "Mario"
end_node = "Princesa"

shortest_path = graph.dijkstra(start_node, end_node)

if shortest_path:
    print("Menor caminho de", start_node, "para", end_node, ":", shortest_path)
else:
    print("Não há caminho de", start_node, "para", end_node)
