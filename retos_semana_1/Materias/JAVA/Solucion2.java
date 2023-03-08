import java.util.List;
import java.util.Scanner;

public class Reto1MateriasOOP {
    public static void main(String[] args) {


        AprobadorDeNotas aprobadorDeNotas = new AprobadorDeNotas();

        aprobadorDeNotas.aprobador();

    }
    public static class AprobadorDeNotas {

        // Mensajes fijos que son mostrados a los usuarios en la aplicacion
        private final String MENSAJE_BIENVENIDA = "¡Bienvenido! En esta aplicacion los estudiantes podran gestionar" +
                " las notas de su materia.";
        private final String ALERTA_PORCENTAJE_EVALUADO = "El porcentaje evaluado de una materia no puede ser mayor a 100";
        private final String SOLICITUD_NOMBRE = "Por favor ingresa tu nombre: ";
        private final String SOLICITUD_NOMBRE_MATERIA = "Ingrese el nombre de la materia: ";
        private final String SOLICITUD_NOTA = "Ingresa la nota obtenida: ";
        private final String SOLICITUD_PORCENTAJE_NOTA = "Ingresa el porcentaje de la nota: ";
        private final String ALERTA_VALORES_INGRESADOS = "ERROR! los Valores ingresados son incorrectos";
        private final String ALERTA_ANADIR_NOTAS = "¿Falta añadir notas? S/N ";


        // Atributos con valores constantes para calculo
        private final int VALOR_MATERIA_TOTAL = 100;
        private final int NOTA_PARA_APROBAR = 3;
        private final int NOTA_MINIMA = 0;
        private final int NOTA_MAXIMA = 5;


        // Variables de instancia y de uso
        private String nombre;
        private double nota;
        private  int porcentajeNota;
        private Scanner scanner;
        private int porcentajesSumados = 0;
        private char respuesta;
        private double suma;
        private double notaFinal = 0;
        private String nombreMateria;
        private boolean toDo = true;  // Variable para control de ciclo


        // Metodos
        public AprobadorDeNotas(){
            scanner= new Scanner(System.in);
        }
        public void aprobador(){
            presentacion();
            solictadorDatos();
            validador();
            resultados();
        }
        // Muestra un mensaje de bienvenida
        private void presentacion() {
            System.out.println(MENSAJE_BIENVENIDA);
        }
        private void solictadorDatos(){
            // Solicita el nombre del usuario y lo capitaliza
            System.out.println(SOLICITUD_NOMBRE);
            nombre = scanner.nextLine();
            nombre = nombre.substring(0,1).toUpperCase() + nombre.substring(1).toLowerCase();
            // Solicita el nombre de la materia y lo capitaliza
            System.out.println(SOLICITUD_NOMBRE_MATERIA);
            nombreMateria = scanner.nextLine();
            nombreMateria = nombreMateria.substring(0,1).toUpperCase() + nombreMateria.substring(1).toLowerCase();
        }

        //solicita ingresar la nota obtenida
        private void solicitadorNotas(){
            try{
                System.out.println(SOLICITUD_NOTA);
                double notaIngresada = scanner.nextDouble();
                setNota(notaIngresada);
            }catch (Exception e){
                System.out.println(ALERTA_VALORES_INGRESADOS);
                scanner.nextLine();
            }
        }
        // solicita indicar el valor del porcentaje de la nota
        private void solicitadorPorcentaje(){
            try{
                System.out.println(SOLICITUD_PORCENTAJE_NOTA);
                porcentajeNota = scanner.nextInt();
            }catch (Exception e){
                System.out.println(ALERTA_VALORES_INGRESADOS);
            }
        }

        /* Se encarga de validar si las notas y porcentajes ingresados son correctos y
            y determina si se aprueba o no la materia
        */
        private void validador(){
            while (toDo){
                solicitadorNotas();
                solicitadorPorcentaje();
                if(porcentajeNota > VALOR_MATERIA_TOTAL){
                    System.out.println(ALERTA_PORCENTAJE_EVALUADO);
                }else if(porcentajeNota < VALOR_MATERIA_TOTAL){
                    notaFinal += (nota * ((double)porcentajeNota / 100 ));
                    porcentajesSumados += porcentajeNota;
                    System.out.println(ALERTA_ANADIR_NOTAS);
                    respuesta = scanner.next().toUpperCase().charAt(0);
                    if(respuesta == 'N'){
                        toDo = false;
                    }else if(respuesta == 'S'){
                        solicitadorNotas();
                        solicitadorPorcentaje();
                        suma = (porcentajesSumados + porcentajeNota);
                        if (suma > VALOR_MATERIA_TOTAL){
                            System.out.println(ALERTA_PORCENTAJE_EVALUADO);
                            suma = 0;
                        } else if (suma < VALOR_MATERIA_TOTAL) {
                            notaFinal += (nota * ((double)porcentajeNota / 100));
                            porcentajesSumados += porcentajeNota;
                            suma = 0;
                        } else if (suma == VALOR_MATERIA_TOTAL) {
                            notaFinal += (nota * ((double)porcentajeNota / 100));
                            porcentajesSumados += porcentajeNota;
                            suma = 0;
                            toDo = false;
                        }
                    }
                }
            }
        }
        // retorna una string si la nota final es mayor a NOTA_PARA_APROBAR
        private String aprobacion(){
            return (notaFinal >= NOTA_PARA_APROBAR)?"APROBADO":"DESAPROBADO";
        }
        // Concatena y visualiza el resultado con los datos del alumno, las notas ponderadas y si  aprobo o desaprobo
        private void resultados(){
            System.out.println("El estudiante "+ nombre + " curso la materia " + nombreMateria +
                    " y obtuvo " + (Math.round(notaFinal * 100.0) / 100.0) + " resultando en " + aprobacion());
        }
        // Metodo setter valida si la nota ingresada se encuentra dentro de los limites establicidos
        private void setNota(double nota) {
            if(nota >= NOTA_MINIMA && nota <= NOTA_MAXIMA){
                this.nota = nota;
            } else {
                System.out.println("La Nota ingresada debe estar en entre 0 y 5 ");
            }
        }
    }
}
