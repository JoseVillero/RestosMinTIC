// Realizado por Jose Villero
// Reto 1 - Nutricion

import java.util.Scanner;
import java.lang.Math;

public class Reto1nutricion {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int edad;
        double peso, pesoSaludable, sobrepeso, desnutricion, dias;
        char estado;
        double aporteCH = 60.1; // aporte calorico de carbohidratos
        double aporteP = 30.5;  // aporte calorico de proteinas
        double aporteFV = -24.4;    // aporte calorico de frutas y verduras

        // Solicitar datos de edad y peso
        System.out.println("Ingrese su edad: ");
        edad = sc.nextInt();
        System.out.println("Ingrese su peso: ");
        peso = sc.nextDouble();

        // Verificacion de edades entre 5 a 10 años
        if (edad >= 5 && edad <= 10){
            if (peso < 16){
                desnutricion = (aporteCH * 2) + (aporteP * 1) + (aporteFV * 2);
                estado = 'A';
                dias = Math.round(((22 - peso) / (desnutricion / 1000)) + 0.5);
                System.out.println("El estado nutricional del paciente es " + estado + " y se requieren " + dias + " dias de dieta para que alcance un peso saludable.");
            } else if (peso > 28) {
                sobrepeso = (aporteCH * 0.6) + (aporteP * 1) + (aporteFV * 4);
                estado = 'B';
                dias = Math.round(((peso - 24) / (sobrepeso / (-1000))) + 0.5);
                System.out.println("El estado nutricional del paciente es " + estado + " y se requieren " + dias + " dias de dieta para que alcance un peso saludable.");
            }else{
                pesoSaludable = (aporteCH * 0.5) + (aporteP * 0.7) + (aporteFV * 2);
                estado = 'C';
                dias = Math.round(((28 - peso) / (pesoSaludable / 1000)) + 0.5);
                System.out.println("El estado nutricional del paciente es " + estado + " y se requieren " + dias + " dias de dieta para que alcance el peso maximo.");
            }
            // Verificacion de edades entre 10 y 13 años
        } else if (edad > 10 && edad <= 13) {
            if (peso < 30){
                desnutricion = (aporteCH * 2) + (aporteP * 1) + (aporteFV * 2);
                estado = 'A';
                dias = Math.round(((32 - peso) / (desnutricion / 1000)) + 0.5);
                System.out.println("El estado nutricional del paciente es " + estado + " y se requieren " + dias + " dias de dieta para que alcance un peso saludable.");
            } else if (peso > 50) {
                sobrepeso = (aporteCH * 0.6) + (aporteP * 1) + (aporteFV * 4);
                estado = 'B';
                dias = Math.round(((peso - 24) / (sobrepeso / (-1000))) + 0.5);
                System.out.println("El estado nutricional del paciente es " + estado + " y se requieren " + dias + " dias de dieta para que alcance un peso saludable.");
            } else {
                pesoSaludable = (aporteCH * 0.5) + (aporteP * 0.7) + (aporteFV * 2);
                estado = 'C';
                dias = Math.round(((50 - peso) / (pesoSaludable / 1000)) + 0.5);
                System.out.println("El estado nutricional del paciente es " + estado + " y se requieren " + dias + " dias de dieta para que alcance el peso maximo.");
            }
            // Verificacion de edades entre 13 a 17 años
        } else if (edad > 13 && edad <= 17) {
            if (peso < 51){
                desnutricion = (aporteCH * 2) + (aporteP * 1) + (aporteFV * 2);
                estado = 'A';
                dias = Math.round(((56 - peso) / (desnutricion / 1000)) + 0.5);
                System.out.println("El estado nutricional del paciente es " + estado + " y se requieren " + dias + " dias de dieta para que alcance un peso saludable.");
            } else if (peso > 63) {
                sobrepeso = (aporteCH * 0.6) + (aporteP * 1) + (aporteFV * 4);
                estado = 'B';
                dias = Math.round(((peso - 24) / (sobrepeso / (-1000))) + 0.5);
                System.out.println("El estado nutricional del paciente es " + estado + " y se requieren " + dias + " dias de dieta para que alcance un peso saludable.");
            }else {
                pesoSaludable = (aporteCH * 0.5) + (aporteP * 0.7) + (aporteFV * 2);
                estado = 'C';
                dias = Math.round(((63 - peso) / (pesoSaludable / 1000)) + 0.5);
                System.out.println("El estado nutricional del paciente es " + estado + " y se requieren " + dias + " dias de dieta para que alcance el peso maximo.");
            }
        } else {
            if (edad > 17){
                System.out.println("Error: La edad del paciente es mayor a 17 años");
            } else if (edad < 5) {
                System.out.println("'Error: La edad del paciente es menor de 5 años'");
            }
        }
    }
}
