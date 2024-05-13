package excepciones;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ID145
 */
public class vistaException extends Exception {
    public vistaException(){}
    
    public vistaException (String msg){
        super(msg);
    }
    
    public vistaException (String msg, Throwable causa){
        super(msg,causa);
    }
}
