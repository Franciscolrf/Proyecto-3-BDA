package pojos;

import java.util.Date;

/**
 * Clase que representa un producto.
 * @author ID145
 */
public class Producto {

    // Atributos
    private Long codigoBarras;
    private String codigoInterno;
    private String nombre;
    private float precio;
    private Date fechaRegistro;

    // Constructores

    /*
     * Constructor por defecto.
     */
    public Producto() {
    }

    /*
     * Constructor con todos los atributos.
     * @param codigoBarras Código de barras del producto.
     * @param codigoInterno Código interno del producto.
     * @param nombre Nombre del producto.
     * @param precio Precio del producto.
     * @param fechaRegistro Fecha de registro del producto.
     */
    public Producto(Long codigoBarras, String codigoInterno, String nombre, float precio, Date fechaRegistro) {
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /*
     * Método que devuelve una cadena de texto con los atributos del producto.
     */
    @Override
    public String toString() {
        return "Producto{" +
                "codigoBarras=" + codigoBarras +
                ", codigoInterno='" + codigoInterno + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
