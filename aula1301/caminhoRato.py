import random

# Tamanho do labirinto
labirinto_size = 16

# Criar uma matriz para representar o labirinto
labirinto = [[' ' for _ in range(labirinto_size)] for _ in range(labirinto_size)]

# Adicionar paredes aleatoriamente
for i in range(labirinto_size):
    for j in range(labirinto_size):
        # Definir uma parede com probabilidade de 30%
        if random.randint(1, 10) <= 3:
            labirinto[i][j] = '#'

# Definir o ponto de chegada no centro
chegada_x = chegada_y = labirinto_size // 2
labirinto[chegada_x][chegada_y] = 'C'

# Definir o ponto de partida em um canto
partida_x = partida_y = 0
labirinto[partida_x][partida_y] = 'S'

# Imprimir o labirinto
for linha in labirinto:
    print(' '.join(linha))

