# Reto 2 veterinaria
# Realizado por Jose Villero ♠

nombres = ['Martín', 'Milú', 'Anastasia', 'Lupita', 'Tomasa', 'Pelusa', 'Genoveva', 'Motita']
tipos = ['canino', 'canino', 'felino', 'felino', 'felino', 'canino', 'bovino', 'roedor']
edades = [12, 9, 10, 8, 9, 2, 14, 1]
pesos = [33, 26, 4, 5, 5, 6, 106.4, 0.34]

clave = []
lista_valor = []
caninos_felinos = {}
equinos_bobinos = {}
suma_edades_c_f = 0
suma_edades_e_b = 0

for i in range(len(nombres)):
    indice = str((i+1))
    clave.extend(indice)
i = None
for i in range(len(nombres)):
    lista_valor.insert(i, [])
    lista_valor[i].append(nombres[i])
    lista_valor[i].append(tipos[i])
    lista_valor[i].append(edades[i])
    lista_valor[i].append(pesos[i])

diccionario1 = dict(zip(clave, lista_valor))
i = None

for i in diccionario1:
    if diccionario1[i][2] >= 9:
        if diccionario1[i][1] == 'canino':
            valor = diccionario1.get(i)
            caninos_felinos.setdefault(i, valor)
        elif diccionario1[i][1] == 'felino':
            valor = diccionario1.get(i)
            caninos_felinos.setdefault(i, valor)
    elif diccionario1[i][2] >= 16:
        if diccionario1[i][1] == 'bovino':
            valor = diccionario1.get(i)
            equinos_bobinos.setdefault(i, valor)
        elif diccionario1[i][1] == 'equino':
            valor = diccionario1.get(i)
            equinos_bobinos.setdefault(i, valor)
i = None

for i in caninos_felinos:
    suma_edades_c_f += caninos_felinos[i].pop(2)
i = None
for i in equinos_bobinos:
    suma_edades_e_b += equinos_bobinos[i].pop(2)

# Pendientes los promedios, utilizar suma_edades_c_f y suma_edades_e_b
