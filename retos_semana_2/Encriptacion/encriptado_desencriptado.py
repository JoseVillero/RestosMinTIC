# Reto 1 materias
# Realizado por Jose Villero ♠

mensaje = 'The Garden of Earthly Delights'    # Mensaje cualquiera a encriptar
alfabeto = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'       # Alfabeto base para encriptar

clave = set(mensaje)                           # convertimos el mensaje a conjunto
clave = dict(zip(clave, alfabeto))             # unimos el conjunto con el alfabeto generando un diccionario
encriptado = ''
for i in mensaje:
 encriptado += clave.get(i)                    # se obtienen los valores de las claves generando encriptacion
clave = {v: k for k, v in clave.items()}       # Se invierten las claves por valores y viceversa
desencriptado = ''
for i in encriptado:
 desencriptado += clave.get(i)                 # se obtienen los valores de las claves desencriptando el mensaje




