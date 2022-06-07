# Reto 3 Barajas
# Realizado por Jose Villero ♠
import numpy as np

tipos_cartas = ['A', '2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K']
n_palos = 4

mazo = []

mazo.append(tipos_cartas * n_palos)

baraja = mazo[0]

np.random.shuffle(baraja)

baraja = tuple(baraja)
