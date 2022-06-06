# Reto 2 pensum
# Realizado por Jose Villero ♠

pensum = [{'0123': {'nombre': 'intro a la ing', 'créditos': 2},
           '4567': {'nombre': 'ingles', 'créditos': 1}}, {}, {}]


def modificar_materia(pensum, semestre, materia, nombre, creditos):
    if semestre != 0 and semestre <= len(pensum):
        semestre -= 1
        for semestre in range(semestre, len(pensum)):
            if pensum[semestre] != pensum[1]:
                if materia in pensum[semestre]:
                    pensum[semestre][materia]['nombre'] = nombre
                    pensum[semestre][materia]['créditos'] = creditos
                    mensaje = 'Modificada con éxito'
                    break
                else:
                    mensaje = 'La materia no existe'
                    break
            mensaje = 'El semestre no tiene materias'
            break
    else:
        mensaje = 'Ingrese un semestre válido'

    return mensaje
