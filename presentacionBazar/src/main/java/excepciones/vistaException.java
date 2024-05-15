package excepciones;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Excepción que se lanza cuando ocurre un error en la capa de presentación
 * @author Fran
 */
public class vistaException extends Exception {
    /**
     * Constructor por defecto.
     */
    public vistaException(){}
    
    /**
     * Constructor con mensaje.
     * @param msg Mensaje de la excepción.
     */
    public vistaException (String msg){
        super(msg);
    }
    
    /**
     * Constructor con mensaje y causa.
     * @param msg Mensaje de la excepción.
     * @param causa Causa de la excepción.
     */
    public vistaException (String msg, Throwable causa){
        super(msg,causa);
    }
}
