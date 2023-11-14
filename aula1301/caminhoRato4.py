import random
from collections import deque
import time

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
print("\n")

def bfs(labirinto, partida, chegada):
    queue = deque([(partida[0], partida[1], [(partida[0], partida[1])])])
    visitado = set([partida])

    while queue:
        x, y, caminho = queue.popleft()

        if (x, y) == chegada:
            return caminho

        for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
            novo_x, novo_y = x + dx, y + dy

            if 0 <= novo_x < len(labirinto) and 0 <= novo_y < len(labirinto[0]) and labirinto[novo_x][novo_y] != '#' and (novo_x, novo_y) not in visitado:
                queue.append((novo_x, novo_y, caminho + [(novo_x, novo_y)]))
                visitado.add((novo_x, novo_y))

                # Marcar o caminho percorrido com 'x'
                labirinto[novo_x][novo_y] = 'x'

                # Imprimir o labirinto com o caminho sendo percorrido passo a passo
                for linha in labirinto:
                    print(' '.join(linha))
                print("\n")
                  # Atraso de 2 segundos

    return None  # Caminho não encontrado

# Encontrar o caminho mais curto
caminho_mais_curto = bfs(labirinto, (partida_x, partida_y), (chegada_x, chegada_y))

# Imprimir o caminho mais curto
if caminho_mais_curto:
    print("\nCaminho mais curto encontrado:")
    for x, y in caminho_mais_curto:
        labirinto[x][y] = '\033[41m*\033[m'

    for linha in labirinto:
        print(' '.join(linha))
else:
    print("\nNão foi possível encontrar um caminho.")
