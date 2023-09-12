import heapq
import time

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
            print(f"Visitando {current_node} com distancia {current_distance}")

            if current_distance > distances[current_node]:
                continue

            for (neighbor, weight) in self.graph[current_node]:
                distance = current_distance + weight

                if distance < distances[neighbor]:
                    distances[neighbor] = distance
                    previous[neighbor] = current_node
                    heapq.heappush(heap, (distance, neighbor))

                    print("_"*50)
                    print(f"Atualizando distacia de {neighbor} para {distance}")
                    print(f"Anterior de {neighbor} e {current_node}")
                    print("_"*50)
                    time.sleep(1)

        if end not in previous:
            return None

        path = []
        while end:
            path.insert(0, end)
            end = previous.get(end)

        return path

# Exemplo de uso:
graph = Graph()

# Exemplo de uso:
graph = Graph()

graph.add_edge("Mario", "Acorn Plains", 10)
graph.add_edge("Acorn Plains", "Layer-Cake Desert", 15)
graph.add_edge("Layer-Cake Desert", "Sparkling Waters", 20)
graph.add_edge("Sparkling Waters", "Soda Jungle", 10)
graph.add_edge("Soda Jungle", "Forest Glacier", 15)
graph.add_edge("Forest Glacier", "Rock-Candy Mines", 18)
graph.add_edge("Rock-Candy Mines", "Secret Island", 12)
graph.add_edge("Secret Island", "Superstar Road", 10)
graph.add_edge("Superstar Road", "Peach's Castle", 25)
graph.add_edge("Peach's Castle", "Princess's Castle", 50)
graph.add_edge("Acorn Plains", "Sparkling Waters", 22)
graph.add_edge("Layer-Cake Desert", "Forest Glacier", 28)
graph.add_edge("Soda Jungle", "Rock-Candy Mines", 14)
graph.add_edge("Secret Island", "    ", 25)
graph.add_edge("Princess's Castle", "Special World", 70)
graph.add_edge("Acorn Plains", "Superstar Road", 60)
graph.add_edge("Sparkling Waters", "Secret Island", 30)
graph.add_edge("Soda Jungle", "Peach's Castle", 45)
graph.add_edge("Special World", "Star Road", 40)
graph.add_edge("Star Road", "Yoshi's Island", 25)
graph.add_edge("Yoshi's Island", "Donut Plains", 30)
graph.add_edge("Donut Plains", "Vanilla Dome", 20)
graph.add_edge("Vanilla Dome", "Chocolate Island", 35)
graph.add_edge("Chocolate Island", "Valley of Bowser", 45)
graph.add_edge("Valley of Bowser", "Front Door", 10)
graph.add_edge("Front Door", "Back Door", 10)
graph.add_edge("Back Door", "Bowser's Keep", 5)
graph.add_edge("Bowser's Keep", "End of the Game", 100)
graph.add_edge("End of the Game", "Credits", 5)
graph.add_edge("Credits", "New Game", 5)
graph.add_edge("New Game", "Acorn Plains", 1)
graph.add_edge("Acorn Plains", "Donut Plains", 30)
graph.add_edge("Donut Plains", "Yoshi's Island", 22)
graph.add_edge("Yoshi's Island", "Peach's Castle", 60)
graph.add_edge("Peach's Castle", "Luigi's Mansion", 40)
graph.add_edge("Luigi's Mansion", "Haunted Woods", 20)
graph.add_edge("Haunted Woods", "Boo's House", 15)
graph.add_edge("Boo's House", "Spooky Swamp", 25)
graph.add_edge("Spooky Swamp", "Ghost Ship", 35)
graph.add_edge("Ghost Ship", "Sunken Ship", 30)
graph.add_edge("Sunken Ship", "Treasure Island", 15)
graph.add_edge("Treasure Island", "Endless Ocean", 50)
graph.add_edge("Layer-Cake Desert", "Peach's Castle", 40)
graph.add_edge("Forest Glacier", "Peach's Castle", 35)
graph.add_edge("Rock-Candy Mines", "Peach's Castle", 30)
graph.add_edge("Superstar Road", "Peach's Castle", 20)
graph.add_edge("Secret Island", "Peach's Castle", 25)
graph.add_edge("Special World", "Peach's Castle", 60)
graph.add_edge("Star Road", "Peach's Castle", 55)
graph.add_edge("Yoshi's Island", "Peach's Castle", 45)
graph.add_edge("Donut Plains", "Peach's Castle", 50)
graph.add_edge("Vanilla Dome", "Peach's Castle", 38)
graph.add_edge("Chocolate Island", "Peach's Castle", 42)
graph.add_edge("Valley of Bowser", "Peach's Castle", 48)
graph.add_edge("Peach's Castle", "Princesa",100)

start_node = "Mario"    
end_node = "Princesa"

shortest_path = graph.dijkstra(start_node, end_node)

if shortest_path:
    print("\nMenor caminho de", start_node, "para", end_node, ":", shortest_path)
else:
    print("\nNão há caminho de", start_node, "para", end_node)
