// Realizado por Jose Villero
// Reto 1 - Materias

import java.util.Scanner;

public class Reto1Materias {
    public static void main (String[] args) {
        // Declaro e inicializo variables
        String mensajeBienvenida = "¡Bienvenido! En esta aplicación los estudiantes podrán gestionar " +
                "las notas de su materia.";
        String mensajeError = "El porcentaje evaluado de una materia no puede ser mayor a 100";
        String aviso = "¿Falta añadir notas? S/N ";
        String aprobacion;

        int porcentajeEvaluado = 100;
        int porcentajesSumados = 0;
        double suma;
        int flag = 1;
        double notaFinal = 0;
        // Creo un objeto de Clase Scanner para obtener los datos primitivos de entrada
        Scanner sc = new Scanner(System.in);

        // Lineas de codigo del algoritmo.
        System.out.println(mensajeBienvenida);
        System.out.println("Por favor ingrese su nombre: ");
        // Pido ingresar el nombre
        String nombre = sc.next();
        // Capitalizo el nombre
        nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
        System.out.println("Ingrese el nombre de la materia: ");
        String nombreMateria = sc.next();
        nombreMateria = nombreMateria.substring(0, 1).toUpperCase() + nombreMateria.substring(1).toLowerCase();

        // Ciclo while
        while (flag == 1) {
            System.out.println("Ingrese la nota obteniada: ");
            double nota = sc.nextDouble();
            System.out.println("Ingrese el porcentaje de la nota: ");
            double porcentajeNota = sc.nextInt();
            if (porcentajeNota > porcentajeEvaluado){
                System.out.println(mensajeError);
            } else if (porcentajeNota < porcentajeEvaluado) {
                notaFinal += (nota * (porcentajeNota / 100));
                porcentajesSumados += porcentajeNota;
                System.out.println(aviso);
                // Caracter capitalizado para la respuesta
                char respuesta = sc.next().toUpperCase().charAt(0);
                if (respuesta == 'N') {
                    flag = 0;
                } else if (respuesta == 'S') {
                    System.out.println("Ingrese la nota obteniada: ");
                    nota = sc.nextDouble();
                    System.out.println("Ingrese el porcentaje de la nota: ");
                    porcentajeNota = sc.nextInt();
                    suma = (porcentajesSumados + porcentajeNota);
                    if (suma > porcentajeEvaluado) {
                        System.out.println(mensajeError);
                        suma = 0;
                    } else if (suma < porcentajeEvaluado) {
                        notaFinal += (nota * (porcentajeNota / 100));
                        porcentajesSumados += porcentajeNota;
                        suma = 0;
                    } else if (suma == porcentajeEvaluado) {
                        notaFinal += (nota * (porcentajeNota / 100));
                        porcentajesSumados += porcentajeNota;
                        suma = 0;
                        flag = 0;
                    }
                }

            }

        } if (notaFinal >= 3){
            aprobacion = "Aprobado";
        } else {
            aprobacion = "Reprobado";
        } System.out.println("El estudiante "+ nombre + " curso la materia " + nombreMateria + " y obtuvo " + notaFinal + " resultando en " + aprobacion);
    }
}


