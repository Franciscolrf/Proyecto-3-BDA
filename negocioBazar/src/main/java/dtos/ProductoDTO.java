package dtos;

import java.time.LocalDateTime;

/**
 *
 * @author ID145
 */
public class ProductoDTO {

    private Long codigoBarras;
    private String codigoInterno;
    private String nombre;
    private double precio;
    private LocalDateTime fechaRegistro;

    public ProductoDTO() {
    }

    /**
     * Crea una instancia con la informacion de un producto en el catalogo de
     * productos.
     *
     * @param codigoBarras
     * @param codigoInterno
     * @param nombre Nombre del producto.
     * @param precio Precio del producto.
     * @param fechaRegistro Fecha de registro del producto en el sistema.
     */
    public ProductoDTO(Long codigoBarras, String codigoInterno, String nombre, double precio, LocalDateTime fechaRegistro) {
        this.codigoBarras = codigoBarras;
        this.codigoInterno = codigoInterno;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaRegistro = fechaRegistro;
    }

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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDateTime getFechaRegistro() {
        return this.fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigoBarras=" + codigoBarras + ", codigo=" + codigoInterno + ", nombre=" + nombre + ", precio=" + precio + ", fecha_registro=" + fechaRegistro + '}';
    }

}
