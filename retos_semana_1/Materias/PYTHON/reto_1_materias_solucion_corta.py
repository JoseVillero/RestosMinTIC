# Reto 1 materias
# Realizado por Jose Villero ♠

mensaje_bienvenida = '¡Bienvenido! En esta aplicación los estudiantes podrán gestionar las notas de su materia.'
mensaje_error = 'El porcentaje evaluado de una materia no puede ser mayor a 100'
porcentaje_evaluado = 100
porcentajes_sumados = 0
nota_final = 0
aviso = '¿Falta añadir notas? S/N '
flag = 1

print(mensaje_bienvenida)
nombre = input('Por favor ingrese su nombre: ').capitalize()
nombre_materia = input('Ingrese el nombre de la materia: ').capitalize()
nota = float(input('Ingrese la nota obtenida: '))
porcentaje_nota = int(input('Ingrese el porcentaje de la nota: '))

while flag == 1:
    if porcentaje_nota <= porcentaje_evaluado:
        nota_final += (nota * (porcentaje_nota / 100))
        porcentajes_sumados += porcentaje_nota
        if porcentajes_sumados == porcentaje_evaluado:
            flag = 0
        else:
            respuesta = input(aviso).upper()
            if respuesta == 'S':
                nota = float(input('Ingrese la nota obtenida: '))
                porcentaje_nota = int(input('Ingrese el porcentaje de la nota: '))
                suma = porcentaje_nota + porcentajes_sumados
                if suma > porcentaje_evaluado:
                    print(mensaje_error)
                    suma = 0
                    porcentaje_nota = 0
                    continue
                elif suma == porcentaje_evaluado:
                    nota_final += (nota * (porcentaje_nota / 100))
                    flag = 0
                else:
                    nota_final += (nota * (porcentaje_nota / 100))
                    porcentajes_sumados += porcentaje_nota
                    suma = 0
                    porcentaje_nota = 0
                    continue
            else:
                flag = 0
    else:
        print(mensaje_error)
        nota = float(input('Ingrese la nota obtenida: '))
        porcentaje_nota = int(input('Ingrese el porcentaje de la nota: '))
        continue

if nota_final >= 3:
    aprobacion = 'aprobado'
else:
    aprobacion = 'reprobado'
print(f'El estudiante {nombre} cursó la materia {nombre_materia} y obtuvo {round(nota_final,2)} resultando en {aprobacion}')



















