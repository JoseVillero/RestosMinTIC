# Reto 1 materias
# Realizado por Jose Villero ♠

import random

flag = 1
b = random.randrange(30, 101)        # Simula el numero b aleatorio de la funcion, establece el numero limite de la rifa
n = random.randrange(30, b+1)        # es el numero a adivinar dentro del numero limite de la rifa

print(f'numero limite de la rifa {b}')
print(f'numero a adivinar {n}')

intentos = 0

while flag == 1:
    numero = int(input('Ingresa un numero: '))
    if numero < 0 or numero > b:
        print('¡Te saliste del intervalo!')
    else:
        if numero > n:
            print('¡Ups! Te pasaste')
            intentos += 1
        elif numero < n:
            print('¡Ups! Estás por debajo')
            intentos += 1
        else:
            intentos += 1
            print(f'¡LO LOGRASTE! Usaste {intentos} intentos')
            flag = 0



