# Reto 1 Nutricion

def solucion(edad, peso):
    edad = int(input('Indicar la edad del paciente: '))
    peso = float(input('Indicar el peso del paciente en kilogramos: '))

    APORTE_CH = 60.1         # Aporte Carbohidrato
    APORTE_P = 30.5          # Aporte proteinas
    APORTE_F_V = -24.4       # Aporte frutas y verduras

    if 5 <= edad <= 10:
        if peso < 16:
            desnutricion = (APORTE_CH * 2) + (APORTE_P * 1) + (APORTE_F_V * 2)
            estado = 'A'
            dias = round(((22 - peso) / (desnutricion / 1000)) + 0.5)
            print(
                f'El estado nutricional del paciente es {estado} y se requieren {dias} dias de dieta para que alcance un peso saludable')
        elif peso > 28:
            sobrepeso = (APORTE_CH * 0.6) + (APORTE_P * 1) + (APORTE_F_V * 4)
            estado = 'B'
            dias = round(((peso - 24) / (sobrepeso / (-1000))) + 0.5)
            print(
                f'El estado nutricional del paciente es {estado} y se requieren {dias} dias de dieta para que alcance un peso saludable')
        else:
            pesoSaludable = (APORTE_CH * 0.5) + (APORTE_P * 0.7) + (APORTE_F_V * 2)
            estado = 'C'
            dias = round(((28 - peso) / (pesoSaludable / 1000)) + 0.5)
            print(
                f'El estado nutricional del paciente es {estado} y se requieren {dias} dias de dieta para que alcance el peso maximo')
    elif 10 < edad <= 13:
        if peso < 30:
            desnutricion = (APORTE_CH * 2) + (APORTE_P * 1) + (APORTE_F_V * 2)
            estado = 'A'
            dias = round(((32 - peso) / (desnutricion / 1000)) + 0.5)
            print(
                f'El estado nutricional del paciente es {estado} y se requieren {dias} dias de dieta para que alcance un peso saludable')
        elif peso > 50:
            sobrepeso = (APORTE_CH * 0.6) + (APORTE_P * 1) + (APORTE_F_V * 4)
            estado = 'B'
            dias = round(((peso - 24) / (sobrepeso / (-1000))) + 0.5)
            print(
                f'El estado nutricional del paciente es {estado} y se requieren {dias} dias de dieta para que alcance un peso saludable')
        else:
            pesoSaludable = (APORTE_CH * 0.5) + (APORTE_P * 0.7) + (APORTE_F_V * 2)
            estado = 'C'
            dias = round(((50 - peso) / (pesoSaludable / 1000)) + 0.5)
            print(
                f'El estado nutricional del paciente es {estado} y se requieren {dias} dias de dieta para que alcance el peso maximo')
    elif 13 < edad <= 17:
        if peso < 51:
            desnutricion = (APORTE_CH * 2) + (APORTE_P * 1) + (APORTE_F_V * 2)
            estado = 'A'
            dias = round(((56 - peso) / (desnutricion / 1000)) + 0.5)
            print(
                f'El estado nutricional del paciente es {estado} y se requieren {dias} dias de dieta para que alcance un peso saludable')
        elif peso > 63:
            sobrepeso = (APORTE_CH * 0.6) + (APORTE_P * 1) + (APORTE_F_V * 4)
            estado = 'B'
            dias = round(((peso - 24) / (sobrepeso / (-1000))) + 0.5)
            print(
                f'El estado nutricional del paciente es {estado} y se requieren {dias} dias de dieta para que alcance un peso saludable')
        else:
            pesoSaludable = (APORTE_CH * 0.5) + (APORTE_P * 0.7) + (APORTE_F_V * 2)
            estado = 'C'
            dias = round(((63 - peso) / (pesoSaludable / 1000)) + 0.5)
            print(
                f'El estado nutricional del paciente es {estado} y se requieren {dias} dias de dieta para que alcance el peso maximo')
    else:
        if edad > 17:
            print('Error: La edad del paciente es mayor a 17 años')
        elif edad < 5:
            print('Error: La edad del paciente es menor de 5 años')