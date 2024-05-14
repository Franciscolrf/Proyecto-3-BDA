/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.util.Date;

import org.bson.types.ObjectId;

/**
 *
 * @author ID145
 */
public class Usuario {
    
    // Atributos
    private ObjectId _id;
    private String nombre;
    private String apellido;
    private Date fechaContratacion;
    private Puesto puesto;
    private String telefono;
    private String contrasena;
    private Direccion direccion;

    public static enum Puesto {
        GERENTE,
        CAJERO
    }

    public Usuario() {
    }

    public Usuario(ObjectId _id, String nombre, String apellido, Date fechaContratacion, Puesto puesto, String telefono,
            String contrasena, Direccion direccion) {
        this._id = _id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaContratacion = fechaContratacion;
        this.puesto = puesto;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.direccion = direccion;
    }

    public Usuario(String nombre, String apellido, Date fechaContratacion, Puesto puesto, String telefono,
            String contrasena, Direccion direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaContratacion = fechaContratacion;
        this.puesto = puesto;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.direccion = direccion;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

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

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "_id='" + _id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaContratacion=" + fechaContratacion +
                ", puesto=" + puesto +
                ", telefono='" + telefono + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", direccion=" + direccion +
                '}';
    }
}
