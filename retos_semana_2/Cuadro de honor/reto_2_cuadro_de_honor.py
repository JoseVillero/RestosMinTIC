# Reto 2 cuadro de honor
# Realizado por Jose Villero ♠

# Estudiantes del grupo
estudiante1 = {'cedula': '00014301503', 'nombre': 'Pepito', 'nota_fundamentos': 4.3}
estudiante2 = {'cedula': '1037678471', 'nombre': 'Fulanito', 'nota_fundamentos': 3.2}
estudiante3 = {'cedula': '71023576', 'nombre': 'Pancho', 'nota_fundamentos': 5}
estudiante4 = {'cedula': '32276123', 'nombre': 'Rita', 'nota_fundamentos': 4.7}
estudiante5 = {'cedula': '1036765245', 'nombre': 'Anita', 'nota_fundamentos': 4.7}
estudiante6 = {'cedula': '89122456', 'nombre': 'Pedrito', 'nota_fundamentos': 4.7}
estudiante7 = {'cedula': '289765345', 'nombre': 'Mat', 'nota_fundamentos': 4.8}
estudiante8 = {'cedula': '4576890', 'nombre': 'Dan', 'nota_fundamentos': 4.8}

estudiante9 = {'cedula': '0032145678', 'nombre': 'Valen', 'nota_fundamentos': 3}
estudiante10 = {'cedula': '1067678654', 'nombre': 'Cris', 'nota_fundamentos': 4.5}
estudiante11 = {'cedula': '45677890', 'nombre': 'John', 'nota_fundamentos': 4.5}
estudiante12 = {'cedula': '72033405', 'nombre': 'Carmen', 'nota_fundamentos': 4.5}
estudiante13 = {'cedula': '89245678', 'nombre': 'Jordan', 'nota_fundamentos': 4.5}
estudiante14 = {'cedula': '89766345', 'nombre': 'Pedro', 'nota_fundamentos': 2.3}
estudiante15 = {'cedula': '1045789098', 'nombre': 'Camilo', 'nota_fundamentos': 3.7}
#

grupo = [estudiante9, estudiante10, estudiante11, estudiante12, estudiante13, estudiante14, estudiante15]
# grupo = [estudiante1, estudiante2, estudiante3, estudiante4, estudiante5, estudiante6, estudiante7, estudiante8]

suma_notas = 0
notas = []
podio = {1: [], 2: [], 3: []}

for i in grupo:
    notas.append(i['nota_fundamentos'])
    suma_notas += i.get('nota_fundamentos')

promedio = suma_notas / len(grupo)
i = None
notas_set = set(notas)
notas = list(notas_set)
notas.sort(reverse=True)

puesto1 = notas[0]
puesto2 = notas[1]
puesto3 = notas[2]

for i in range(len(grupo)):
    if grupo[i]['nota_fundamentos'] == puesto1:
        podio[1].extend([grupo[i]['cedula']])
    elif grupo[i]['nota_fundamentos'] == puesto2:
        podio[2].extend([grupo[i]['cedula']])
    elif grupo[i]['nota_fundamentos'] == puesto3:
        podio[3].extend([grupo[i]['cedula']])

cuadro_honor = [promedio, podio]











