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

# Exemplo de uso:
graph = Graph()

graph.add_edge("Mario", "Acorn Plains", 20)
graph.add_edge("Mario", "Sparkling Waters", 30)
graph.add_edge("Acorn Plains", "Sparkling Waters", 10)
graph.add_edge("Mario", "Layer Cake Desert", 300)
graph.add_edge("Acorn Plains", "Layer Cake Desert", 5)
graph.add_edge("Layer Cake Desert", "Princesa", 5)

start_node = "Mario"
end_node = "Princesa"

shortest_path = graph.dijkstra(start_node, end_node)

if shortest_path:
    print("Menor caminho de", start_node, "para", end_node, ":", shortest_path)
else:
    print("Não há caminho de", start_node, "para", end_node)
