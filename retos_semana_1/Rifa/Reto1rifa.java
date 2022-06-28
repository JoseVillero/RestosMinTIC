// Reto 1 rifa
// Realizado por jose villero

import java.util.Random;
import java.util.Scanner;

public class Reto1rifa{
    public static void main (String[] arg){

        Scanner sc = new Scanner(System.in);
        // Clase Random para generar numeros aleatorios
        Random rd = new Random();
        int b = rd.nextInt(30,101);  // Establece el numero limite de la rifa ( del 30 al 100)
        int n = rd.nextInt(30, b + 1);  // es el numero a adivinar dentro del numero limite de la rifa
        int flag = 1;
        int intentos = 0;
        int numero;


        System.out.printf("Numero limite de la rifa: %10d%n", b);
        System.out.printf("Numero a adivinar %10d%n", n);

        while (flag == 1){
            System.out.println("\nIngrese un numero: ");
            numero = sc.nextInt();
            if (numero < 0 || numero > b){
                System.out.println("¡Te saliste del intervalo!");
            } else {
                if (numero > n){
                    System.out.println("¡Ups! Te pasaste");
                    intentos += 1;
                } else if (numero < n) {
                    System.out.println("¡Ups! Estás por debajo");
                    intentos += 1;
                }else {
                    intentos += 1;
                    System.out.println("¡LO LOGRASTE! Usaste " + intentos + " intentos");
                    flag = 0;
                }
            }
        }
    }
}