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
    private String codigoInterno;
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

    /**
 * Obtiene el código interno del usuario.
 *
 * @return El código interno del usuario.
 */
public String getCodigoInterno() {
    return codigoInterno;
}

/**
 * Establece el código interno del usuario.
 *
 * @param codigoInterno El código interno del usuario.
 */
public void setCodigoInterno(String codigoInterno) {
    this.codigoInterno = codigoInterno;
}

/**
 * Obtiene el identificador único del usuario.
 *
 * @return El identificador único del usuario.
 */
public ObjectId get_id() {
    return _id;
}

/**
 * Establece el identificador único del usuario.
 *
 * @param _id El identificador único del usuario.
 */
public void set_id(ObjectId _id) {
    this._id = _id;
}

/**
 * Obtiene el nombre del usuario.
 *
 * @return El nombre del usuario.
 */
public String getNombre() {
    return nombre;
}

/**
 * Establece el nombre del usuario.
 *
 * @param nombre El nombre del usuario.
 */
public void setNombre(String nombre) {
    this.nombre = nombre;
}

/**
 * Obtiene el apellido del usuario.
 *
 * @return El apellido del usuario.
 */
public String getApellido() {
    return apellido;
}

/**
 * Establece el apellido del usuario.
 *
 * @param apellido El apellido del usuario.
 */
public void setApellido(String apellido) {
    this.apellido = apellido;
}

/**
 * Obtiene la fecha de contratación del usuario.
 *
 * @return La fecha de contratación del usuario.
 */
public Date getFechaContratacion() {
    return fechaContratacion;
}

/**
 * Establece la fecha de contratación del usuario.
 *
 * @param fechaContratacion La fecha de contratación del usuario.
 */
public void setFechaContratacion(Date fechaContratacion) {
    this.fechaContratacion = fechaContratacion;
}

/**
 * Obtiene el puesto del usuario.
 *
 * @return El puesto del usuario.
 */
public Puesto getPuesto() {
    return puesto;
}

/**
 * Establece el puesto del usuario.
 *
 * @param puesto El puesto del usuario.
 */
public void setPuesto(Puesto puesto) {
    this.puesto = puesto;
}

/**
 * Obtiene el teléfono del usuario.
 *
 * @return El teléfono del usuario.
 */
public String getTelefono() {
    return telefono;
}

/**
 * Establece el teléfono del usuario.
 *
 * @param telefono El teléfono del usuario.
 */
public void setTelefono(String telefono) {
    this.telefono = telefono;
}

/**
 * Obtiene la contraseña del usuario.
 *
 * @return La contraseña del usuario.
 */
public String getContrasena() {
    return contrasena;
}

/**
 * Establece la contraseña del usuario.
 *
 * @param contrasena La contraseña del usuario.
 */
public void setContrasena(String contrasena) {
    this.contrasena = contrasena;
}

/**
 * Obtiene la dirección del usuario.
 *
 * @return La dirección del usuario.
 */
public Direccion getDireccion() {
    return direccion;
}

/**
 * Establece la dirección del usuario.
 *
 * @param direccion La dirección del usuario.
 */
public void setDireccion(Direccion direccion) {
    this.direccion = direccion;
}

    @Override
    public String toString() {
        return "Usuario{"
                + "_id='" + _id + '\''
                + ", nombre='" + nombre + '\''
                + ", apellido='" + apellido + '\''
                + ", fechaContratacion=" + fechaContratacion
                + ", puesto=" + puesto
                + ", telefono='" + telefono + '\''
                + ", contrasena='" + contrasena + '\''
                + ", direccion=" + direccion
                + '}';
    }
}
