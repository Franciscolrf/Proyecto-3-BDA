/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Clase que representa la informacion de un producto en el sistema.
 * 
 * @author Fran
 */
public class ProductoDTO {
    // Atributos
    private Long codigoBarras;
    private String codigoInterno;
    private String nombre;
    private float precio;
    private Date fechaRegistro;

    // Constructores

    /*
     * Constructor vacío
     */
    public ProductoDTO() {
    }

    /**
     * Crea una instancia con la informacion de un producto en el catalogo de
     * productos.
     * 
     * @param codigoBarras
     * @param codigoInterno
     * @param nombre        Nombre del producto.
     * @param precio        Precio del producto.
     * @param fechaRegistro Fecha de registro del producto en el sistema.
     */
    public ProductoDTO(Long codigoBarras, String codigoInterno, String nombre, float precio, Date fechaRegistro) {
        this.codigoBarras = codigoBarras;
        this.codigoInterno = codigoInterno;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaRegistro = fechaRegistro;
    }

    // Getters y Setters

    /**
     * Devuelve el código de barras del producto.
     *
     * @return Un Long que representa el código de barras del producto.
     */
    public Long getCodigoBarras() {
        return codigoBarras;
    }

    /**
     * Establece el código de barras del producto.
     *
     * @param id Un Long que representa el código de barras a establecer.
     */
    public void setCodigoBarras(Long id) {
        this.codigoBarras = id;
    }

    /**
     * Establece el código interno del producto.
     *
     * @param codigo Una cadena que representa el código interno a establecer.
     */
    public void setCodigoInterno(String codigo) {
        this.codigoInterno = codigo;
    }

    /**
     * Devuelve el código interno del producto.
     *
     * @return Una cadena que representa el código interno del producto.
     */
    public String getCodigoInterno() {
        return this.codigoInterno;
    }

    /**
     * Devuelve el nombre del producto.
     *
     * @return Una cadena que representa el nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre Una cadena que representa el nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el precio del producto.
     *
     * @return Un float que representa el precio del producto.
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio Un float que representa el precio a establecer.
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * Devuelve la fecha de registro del producto.
     *
     * @return Un objeto Date que representa la fecha de registro del producto.
     */
    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }

    /**
     * Establece la fecha de registro del producto.
     *
     * @param fechaRegistro Un objeto Date que representa la fecha de registro a
     *                      establecer.
     */
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /*
     * Metodo que regresa la informacion del producto en forma de cadena.
     */
    @Override
    public String toString() {
        return "Producto{" + "codigoBarras=" + codigoBarras + ", codigo=" + codigoInterno + ", nombre=" + nombre
                + ", precio=" + precio + ", fecha_registro=" + fechaRegistro + '}';
    }
}
