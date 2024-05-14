/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colecciones;

import java.time.LocalDateTime;

/**
 *
 * @author ID145
 */
public class Producto {

    private Long codigoBarras;
    private String codigoInterno;
    private String nombre;
    private double precio;
    private LocalDateTime fechaRegistro;

    public Producto(Long codigoBarras, String codigoInterno, String nombre, double precio, LocalDateTime fechaRegistro) {
        this.codigoBarras = codigoBarras;
        this.codigoInterno = codigoInterno;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaRegistro = fechaRegistro;
    }

    // Getters y setters
    public Long getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(Long codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "Producto{"
                + "codigoBarras=" + codigoBarras
                + ", codigoInterno='" + codigoInterno + '\''
                + ", nombre='" + nombre + '\''
                + ", precio=" + precio
                + ", fechaRegistro=" + fechaRegistro
                + '}';
    }

}
