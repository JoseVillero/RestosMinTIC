# Reto 1 materias
# Realizado por Jose Villero ♠

iva = 0.19
subtotal = 0

flag = 1

while flag == 1:
    valor_unitario = int(input('Ingrese el valor unitario: '))
    pregunta_iva = input('El producto cuenta con IVA? ')
    if pregunta_iva =='S':
        cantidad = int(input('Ingrese la cantidad que lleva el cliente del producto a registar: '))
        subtotal += (valor_unitario+(iva * valor_unitario)) * cantidad
        print('IVA incluído')
        print(f"SUBTOTAL: {subtotal}")
        pregunta_cobro = input('Faltan productos por cobrar? ')
        if pregunta_cobro == 'S':
            continue
        else:
            flag = 0
    else:
        cantidad = int(input('Ingrese la cantidad que lleva el cliente del producto a registar: '))
        subtotal += valor_unitario * cantidad
        print('PRODUCTO SIN IVA')
        print(f"SUBTOTAL: {subtotal}")
        pregunta_cobro = input('Faltan productos por cobrar? ')

print(f"TOTAL A COBRAR: {subtotal}")
