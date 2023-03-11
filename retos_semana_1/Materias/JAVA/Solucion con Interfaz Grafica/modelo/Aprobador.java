package modelo;

import java.awt.Component;

import javax.swing.DefaultRowSorter;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Aprobador {
	
	/*
	 * Mensajes fijos que son mostrados a los usuarios en la aplicacion
	 */
    public static final String MENSAJE_BIENVENIDA = "¡Bienvenido! En esta aplicacion los estudiantes podran gestionar" +
            " las notas de su materia.";
    private static final String ALERTA_PORCENTAJE_EVALUADO = "El porcentaje evaluado de una materia no puede ser mayor a 100";
    private static final String SOLICITUD_NOMBRE = "Por favor ingresa tu nombre: ";
    private static final String SOLICITUD_NOMBRE_MATERIA = "Ingrese el nombre de la materia: ";
    private static final String SOLICITUD_NOTA = "Ingresa la nota obtenida: ";
    private static final String SOLICITUD_PORCENTAJE_NOTA = "Ingresa el porcentaje de la nota: ";
    private static final String ALERTA_VALORES_INGRESADOS = "ERROR! los Valores ingresados son incorrectos";
    private static final String ALERTA_ANADIR_NOTAS = "¿Falta añadir notas? S/N ";
    private static final String ALERTA_VALOR_NOTA = "La Nota ingresada debe estar en entre 0 y 5 ";
    
    /*
     *  Atributos con valores constantes para calculo
     */
    private static final int VALOR_MATERIA_TOTAL = 100;
    private static final int NOTA_PARA_APROBAR = 3;
    private static final int NOTA_MINIMA = 0;
    private static final int NOTA_MAXIMA = 5;


    /*
     *  Variables de instancia y de uso
     */
    private static String nombre;
    private static double nota;
    private static  int porcentajeNota;
    private static int porcentajesSumados = 0;
    private static int respuesta;
    private static double suma;
    private static double notaFinal = 0;
    private static String nombreMateria;
    private static boolean toDo;  // Variable para control de ciclo

    
    private Aprobador() {
    	
    }
    
    public static void aprobador(Component parentComponent, JTextArea text) {
    	solictadorDatos(parentComponent);
    	validador(parentComponent);
    	resultado(parentComponent, text);
    }
    
    private static void solictadorDatos(Component parentComponent){
        /* 
         * Muestra un cuadro de dialogo solicitando el nombre del 
         * usuario. El nombre es capitalizado.
         */
        nombre = JOptionPane.showInputDialog(parentComponent, SOLICITUD_NOMBRE, "", JOptionPane.QUESTION_MESSAGE);
        nombre = nombre.substring(0,1).toUpperCase() + nombre.substring(1).toLowerCase();
        /* 
         * Muestra un cuadro de dialogo solicitando el nombre de la materia
         * El nombre de la materia es capitalizado.
         */
        nombreMateria = JOptionPane.showInputDialog(parentComponent, SOLICITUD_NOMBRE_MATERIA, "", JOptionPane.QUESTION_MESSAGE);
        nombreMateria = nombreMateria.substring(0,1).toUpperCase() + nombreMateria.substring(1).toLowerCase();
    }
    
    private static void solicitadorNotas(Component parentComponent){
    	/* 
    	 * Muestra un cuadro de dialogo solicitando el valor de la nota obtenida. 
    	 * Captura las excepciones de conversion de datos. Delega la excepcion caputarada al bloque cath
    	 * del evento en la clase del paquete vista.
    	 */
    	try{
        	String notaIngresadaString = JOptionPane.showInputDialog(parentComponent, SOLICITUD_NOTA, "", JOptionPane.QUESTION_MESSAGE);
        	 double notaVerificada = Double.parseDouble(notaIngresadaString);
        	 setNota(notaVerificada, parentComponent);
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(parentComponent, ALERTA_VALORES_INGRESADOS);
            System.out.println(e.getCause().getMessage());
        }catch (NullPointerException e) {
        	System.out.println(e.getCause().getMessage());
        }catch(Exception e) {
        	System.out.println(e.getCause().getMessage());
        }
    }
    
    private static void solicitadorPorcentaje(Component parentComponent){
    	/*
    	 *  Muestra un cuadro de dialogo solicitando el valor del porcentaje de la nota obtenida. 
    	 * Captura las excepciones de conversion de datos. Delega la excepcion caputarada al bloque cath
    	 * del evento en la clase del paquete vista.
    	 */
    		String porcentajeIngresadoString = null;
    		try{
    	        porcentajeIngresadoString = JOptionPane.showInputDialog(parentComponent, SOLICITUD_PORCENTAJE_NOTA, "", JOptionPane.QUESTION_MESSAGE);
    	        porcentajeNota = Integer.parseInt(porcentajeIngresadoString);
    	        }catch (NumberFormatException e){
    	        	if(porcentajeIngresadoString.equals(null)) {
    	        		System.out.println(e.getCause().getMessage());
    	        	}else {
    	        		JOptionPane.showMessageDialog(parentComponent, ALERTA_VALORES_INGRESADOS);
    	        		System.out.println(e.getCause().getMessage());
    	    }	    
    	}
    }
    
    private static void validador(Component parentComponent){
    	/* 
    	 * Metodo recibe de parametro un Component. Realiza la logica de negocio de la aplicacion
    	 * 
    	 */
    	
    	toDo = true;
    	
        while (toDo){
        	solicitadorNotas(parentComponent);
        	solicitadorPorcentaje(parentComponent);
        	if(porcentajeNota > VALOR_MATERIA_TOTAL){ 
            JOptionPane.showMessageDialog(parentComponent, ALERTA_PORCENTAJE_EVALUADO);
                 }
        	else if(porcentajeNota < VALOR_MATERIA_TOTAL){
                     notaFinal += (nota * ((double)porcentajeNota / 100 ));
                     porcentajesSumados += porcentajeNota;
                     respuesta = JOptionPane.showConfirmDialog(parentComponent, ALERTA_ANADIR_NOTAS,"",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                     if(respuesta == 1){
                         toDo = false;
                     }else if(respuesta == 0){
                         solicitadorNotas(parentComponent);
                         solicitadorPorcentaje(parentComponent);
                         suma = (porcentajesSumados + porcentajeNota);
                         if (suma > VALOR_MATERIA_TOTAL){
                         	JOptionPane.showMessageDialog(parentComponent, ALERTA_PORCENTAJE_EVALUADO);
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
    /*
     *  Retorna una string si la nota final es mayor a NOTA_PARA_APROBAR
     */
    private static String aprobacion(){
        return (notaFinal >= NOTA_PARA_APROBAR)?"APROBADO":"DESAPROBADO";
    }
    /*
     *  Concatena y visualiza el resultado con los datos del alumno, las notas ponderadas y si  aprobo o desaprobo
     */
    private static String solucion(){
        return "\n\tEl estudiante "+ nombre + " curso la materia " + nombreMateria + "\n" + 
                "\n\ty obtuvo " + (Math.round(notaFinal * 100.0) / 100.0) + " resultando en " + aprobacion();
    }
    private static void resultado(Component parentComponet, JTextArea text) {
    	text.setText("");
    	text.append(solucion());
    	JOptionPane.showMessageDialog(parentComponet, "Resultado visualizado con exito");
    }

    /*
     * Metodo setter valida si la nota ingresada se encuentra dentro de los limites establicidos
     */
    private static void setNota(double notax, Component parentComponent) {
        if(notax >= NOTA_MINIMA && notax <= NOTA_MAXIMA){
            nota = notax;
        } else {
        	JOptionPane.showMessageDialog(parentComponent, ALERTA_VALOR_NOTA);
        	throw new IllegalArgumentException(ALERTA_VALOR_NOTA);
        }
    }
   
}
