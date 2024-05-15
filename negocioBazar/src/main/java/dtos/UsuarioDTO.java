/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.time.LocalDateTime;
import java.util.Date;

import org.bson.types.ObjectId;

/**
 * Clase que representa la informacion de un usuario en el sistema.
 * 
 * @author Fran
 */
public class UsuarioDTO {
    // Atributos
    private String codigoInterno;
    private String nombre;
    private String apellido;
    private Date fechaContratacion;
    private Puesto puesto;
    private String telefono;
    private String contrasena;
    private DireccionDTO direccion;

    /*
     * Enumeracion de los puestos disponibles en el sistema.
     */
    public static enum Puesto {
        GERENTE,
        CAJERO
    }

    // Constructores

    /*
     * Constructor vacío
     */
    public UsuarioDTO() {
    }

    /**
     * Crea una instancia con la informacion de un usuario en el sistema sin id.
     * 
     * @param nombre
     * @param apellido
     * @param fechaContratacion
     * @param puesto
     * @param telefono
     * @param contrasena
     * @param direccion
     */
    public UsuarioDTO(String nombre, String apellido, Date fechaContratacion, Puesto puesto, String telefono,
            String contrasena, DireccionDTO direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaContratacion = fechaContratacion;
        this.puesto = puesto;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.direccion = direccion;
    }
    
    public UsuarioDTO(String nombre, String apellido,String codigoInterno, Date fechaContratacion, Puesto puesto, String telefono,
            String contrasena, DireccionDTO direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoInterno=codigoInterno;
        this.fechaContratacion = fechaContratacion;
        this.puesto = puesto;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.direccion = direccion;
    }

    // Getters y Setters

    /**
 * Devuelve el código interno del usuario.
 *
 * @return Una cadena que representa el código interno del usuario.
 */
public String getCodigoInterno() {
    return codigoInterno;
}

/**
 * Establece el código interno del usuario.
 *
 * @param codigoInterno Una cadena que representa el código interno a establecer.
 */
public void setCodigoInterno(String codigoInterno) {
    this.codigoInterno = codigoInterno;
}

/**
 * Devuelve el nombre del usuario.
 *
 * @return Una cadena que representa el nombre del usuario.
 */
public String getNombre() {
    return nombre;
}

/**
 * Establece el nombre del usuario.
 *
 * @param nombre Una cadena que representa el nombre a establecer.
 */
public void setNombre(String nombre) {
    this.nombre = nombre;
}

/**
 * Devuelve el apellido del usuario.
 *
 * @return Una cadena que representa el apellido del usuario.
 */
public String getApellido() {
    return apellido;
}

/**
 * Establece el apellido del usuario.
 *
 * @param apellido Una cadena que representa el apellido a establecer.
 */
public void setApellido(String apellido) {
    this.apellido = apellido;
}

/**
 * Devuelve la fecha de contratación del usuario.
 *
 * @return Un objeto Date que representa la fecha de contratación del usuario.
 */
public Date getFechaContratacion() {
    return fechaContratacion;
}

/**
 * Establece la fecha de contratación del usuario.
 *
 * @param fechaContratacion Un objeto Date que representa la fecha de contratación a establecer.
 */
public void setFechaContratacion(Date fechaContratacion) {
    this.fechaContratacion = fechaContratacion;
}

/**
 * Devuelve el puesto del usuario.
 *
 * @return Un objeto Puesto que representa el puesto del usuario.
 */
public Puesto getPuesto() {
    return puesto;
}

/**
 * Establece el puesto del usuario.
 *
 * @param puesto Un objeto Puesto que representa el puesto a establecer.
 */
public void setPuesto(Puesto puesto) {
    this.puesto = puesto;
}

/**
 * Devuelve el teléfono del usuario.
 *
 * @return Una cadena que representa el teléfono del usuario.
 */
public String getTelefono() {
    return telefono;
}

/**
 * Establece el teléfono del usuario.
 *
 * @param telefono Una cadena que representa el teléfono a establecer.
 */
public void setTelefono(String telefono) {
    this.telefono = telefono;
}

/**
 * Devuelve la contraseña del usuario.
 *
 * @return Una cadena que representa la contraseña del usuario.
 */
public String getContrasena() {
    return contrasena;
}

/**
 * Establece la contraseña del usuario.
 *
 * @param contrasena Una cadena que representa la contraseña a establecer.
 */
public void setContrasena(String contrasena) {
    this.contrasena = contrasena;
}

/**
 * Devuelve la dirección del usuario.
 *
 * @return Un objeto DireccionDTO que representa la dirección del usuario.
 */
public DireccionDTO getDireccion() {
    return direccion;
}

/**
 * Establece la dirección del usuario.
 *
 * @param direccion Un objeto DireccionDTO que representa la dirección a establecer.
 */
public void setDireccion(DireccionDTO direccion) {
    this.direccion = direccion;
}

    /*
     * Metodo que regresa la informacion del usuario en forma de cadena.
     */
    @Override
    public String toString() {
        return "Usuario{" + " nombre=" + nombre + ", apellido=" + apellido + ", fechaContratacion=" + fechaContratacion
                + ", puesto=" + puesto + ", telefono=" + telefono + ", contrasena=" + contrasena + ", direccion="
                + direccion + '}';
    }

}
