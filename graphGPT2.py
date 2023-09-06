import heapq

class Graph:
    def __init__(self):
        self.graph = {}

    def add_edge(self, node1, node2, weight):
        if node1 not in self.graph:
            self.graph[node1] = []
        if node2 not in self.graph:
            self.graph[node2] = []
        self.graph[node1].append((node2, weight))
        self.graph[node2].append((node1, weight))

    def dijkstra(self, start, end):
        distances = {node: float('inf') for node in self.graph}
        distances[start] = 0
        previous = {}
        heap = [(0, start)]

        while heap:
            (current_distance, current_node) = heapq.heappop(heap)

            if current_distance > distances[current_node]:
                continue

            for (neighbor, weight) in self.graph[current_node]:
                distance = current_distance + weight

                if distance < distances[neighbor]:
                    distances[neighbor] = distance
                    previous[neighbor] = current_node
                    heapq.heappush(heap, (distance, neighbor))

        if end not in previous:
            return None

        path = []
        while end:
            path.insert(0, end)
            end = previous.get(end)

        return path

    def optimized_path(self, start, end):
        acorn_plains_to_layer_cake_desert_weight = float('inf')
        acorn_plains_to_layer_cake_desert_node = None

        for (neighbor, weight) in self.graph["Acorn Plains"]:
            if neighbor == "Layer Cake Desert" and weight < acorn_plains_to_layer_cake_desert_weight:
                acorn_plains_to_layer_cake_desert_weight = weight
                acorn_plains_to_layer_cake_desert_node = neighbor

        if not acorn_plains_to_layer_cake_desert_node:
            return None

        path_part1 = self.dijkstra(start, acorn_plains_to_layer_cake_desert_node)
        path_part2 = self.dijkstra(acorn_plains_to_layer_cake_desert_node, end)[1:]

        optimized_path = path_part1 + path_part2

        return optimized_path

    def get_path_details(self, path):
        if not path:
            return "Caminho não encontrado."

        total_distance = 0
        path_details = []

        for i in range(len(path) - 1):
            node1 = path[i]
            node2 = path[i + 1]
            for (neighbor, weight) in self.graph[node1]:
                if neighbor == node2:
                    total_distance += weight
                    path_details.append(f"Ir de {node1} para {node2} (Distancia: {weight})")

        return path_details, total_distance
    
# Exemplo de uso:
graph = Graph()

graph.add_edge("Mario", "Acorn Plains", 20)
graph.add_edge("Mario", "Sparkling Waters", 30)
graph.add_edge("Mario", "Layer Cake Desert", 20)
graph.add_edge("Acorn Plains", "Sparkling Waters", 10)
graph.add_edge("Acorn Plains", "Layer Cake Desert", 15)
graph.add_edge("Layer Cake Desert", "Princesa", 50)
graph.add_edge("Sparkling Waters","Princesa", 180)

start_node = "Mario"
end_node = "Princesa"

optimized_shortest_path = graph.optimized_path(start_node, end_node)

if optimized_shortest_path:
    print("Caminho otimizado de", start_node, "para", end_node, ":")
    path_details, total_distance = graph.get_path_details(optimized_shortest_path)
    for detail in path_details:
        print(detail)
    print("Distancia total:", total_distance)
else:
    print("Não há caminho de", start_node, "para", end_node)