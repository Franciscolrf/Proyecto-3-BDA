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

    // Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public DireccionDTO getDireccion() {
        return direccion;
    }

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
