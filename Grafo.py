


def grafo(x, y):
    lista_conexoes = {}
    lista_teste = []
    x = int(input("Vertices: ")) 
    y = int(input("Conexoes: ")) 
    grau = 0
    contador = 0
    for tamanho in range(y):
        conexoes = input("Input conexoes as verticie inicial verticie de chegada: ")
        valor_da_aresta = input("valor da conexao: ")
        conexoes = conexoes.split(" ")
        lista_conexoes[valor_da_aresta] = conexoes

    soma = 0
    graus = {}
    key = 0
    for chave, lista_de_valores in lista_conexoes.items():
        for valor in lista_de_valores:
            if valor in graus:
                graus[valor]['Grau'] += 1
               
            else:
                graus[valor] = {'Grau': 1}

    print(graus)
    print(str(lista_conexoes))
grafo(2,1)