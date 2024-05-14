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

    public Long getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(Long id) {
        this.codigoBarras = id;
    }

    public void setCodigoInterno(String codigo) {
        this.codigoInterno = codigo;
    }

    public String getCodigoInterno() {
        return this.codigoInterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Date getFechaRegistro() {
        return this.fechaRegistro;
    }

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
