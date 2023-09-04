class Graph:
    def __init__(self):
        #Our two dictionaries that we will be using
        self.connections = {}
        self.degrees = {}

    def add_edge(self, edge_value, start_vertex, end_vertex):
        if edge_value not in self.connections:
            self.connections[edge_value] = []
        #Here we append to our dictionary our KEY and VALUES that we have defined in the main function
        self.connections[edge_value].append((start_vertex, end_vertex))

        #Here we have the conditions to sum to the degree of the vertexes
        if start_vertex in self.degrees:
            self.degrees[start_vertex] += 1
        else:
            self.degrees[start_vertex] = 1

        if end_vertex in self.degrees:
            self.degrees[end_vertex] += 1
        else:
            self.degrees[end_vertex] = 1

    #Here we have the display functions, the display_degrees show us the degrees in a more readable way
    def display_degrees(self):
        for vertex, degree in self.degrees.items():
            print(f"Degree of {vertex}: {degree}")

    def display_connections(self):
        print(self.connections)

def main():
    graph = Graph()
    #Here we collect both the verticies and the connections
    vertices = int(input("Vertices: "))
    connections = int(input("Connections: "))
    #Here we iterate trough the info from the user about the value of the edges and the connections
    for _ in range(connections):
        connection_input = input("Input connections as start_vertex end_vertex: ")
        edge_value = input("Edge value: ")
        start_vertex, end_vertex = connection_input.split(" ")
        #Add the information we collected to the add_edge method
        graph.add_edge(edge_value, start_vertex, end_vertex)

    graph.display_degrees()
    graph.display_connections()

if __name__ == "__main__":
    main()
