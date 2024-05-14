/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/** 
 * Excepción que se lanza cuando ocurre un error en la capa de persistencia
 * @author Fran
 */
public class PersistenciaException extends Exception {

    
    public PersistenciaException() {
    }

    public PersistenciaException(String msg) {
        super(msg);
    }
    
    public PersistenciaException(String msg, Throwable causa) {
        super(msg,causa);
    }
}
