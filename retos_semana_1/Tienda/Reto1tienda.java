// Reto 1 tienda
// Realizado por jose villero

import java.util.Scanner;

public class Reto1tienda {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        double iva = 0.19;
        double subtotal = 0;
        int flag = 1;
        int valorUnitario, cantidad;
        char preguntaIva, preguntaCobro;

        while (flag == 1){
            System.out.println("Ingrese valor unitario: ");
            valorUnitario = sc.nextInt();
            System.out.println("El producto cuenta con IVA?");
            preguntaIva = sc.next().toUpperCase().charAt(0);
            if (preguntaIva == 'S'){
                System.out.println("Ingrese la cantidad que lleva el cliente del producto a registrar: ");
                cantidad = sc.nextInt();
                subtotal += (valorUnitario + (iva * valorUnitario)) * cantidad;
                System.out.println("IVA incluido");
                System.out.println("SUBTOTAL: " + subtotal);
                System.out.println("Faltan productos por cobrar? ");
                preguntaCobro = sc.next().toUpperCase().charAt(0);
                if (preguntaCobro == 'S'){
                    continue;
                } else {
                    flag = 0;
                }

            } else {
                System.out.println("Ingrese la cantidad que lleva el cliente del producto a registrar: ");
                cantidad = sc.nextInt();
                subtotal += valorUnitario * cantidad;
                System.out.println("PRODUCTO SIN IVA");
                System.out.println("SUBTOTAL: " + subtotal);
                System.out.println("Faltan productos por cobrar? ");
                preguntaCobro = sc.next().toUpperCase().charAt(0);
            }
        }
        System.out.println("TOTAL A COBRAR: " + subtotal);
    }
}