package pojos;

import java.util.Date;

import org.bson.types.ObjectId;

/**
 * Clase que representa un producto.
 * 
 * @author Fran
 */
public class Producto {

    // Atributos
    private ObjectId _id;
    private Long codigoBarras;
    private String codigoInterno;
    private String nombre;
    private float precio;
    private Date fechaRegistro;

    // Constructores

    /**
     * Constructor por defecto.
     */
    public Producto() {
    }

    /**
     * Constructor con todos los atributos.
     * 
     * @param _id Identificador del producto.
     * 
     * @param codigoBarras Código de barras del producto.
     * 
     * @param codigoInterno Código interno del producto.
     * 
     * @param nombre Nombre del producto.
     * 
     * @param precio Precio del producto.
     * 
     * @param fechaRegistro Fecha de registro del producto.
     */
    public Producto(ObjectId _id, Long codigoBarras, String codigoInterno, String nombre, float precio,
            Date fechaRegistro) {
        this._id = _id;
        this.codigoBarras = codigoBarras;
        this.codigoInterno = codigoInterno;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Constructor con todos los atributos.
     * 
     * @param codigoBarras Código de barras del producto.
     * 
     * @param codigoInterno Código interno del producto.
     * 
     * @param nombre Nombre del producto.
     * 
     * @param precio Precio del producto.
     * 
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

    /**
     * Obtiene el identificador único del objeto.
     *
     * @return El identificador único del objeto.
     */
    public ObjectId get_id() {
        return _id;
    }

    /**
     * Establece el identificador único del objeto.
     *
     * @param _id El identificador único del objeto.
     */
    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    /**
     * Obtiene el código de barras del objeto.
     *
     * @return El código de barras del objeto.
     */
    public Long getCodigoBarras() {
        return codigoBarras;
    }

    /**
     * Establece el código de barras del objeto.
     *
     * @param codigoBarras El código de barras del objeto.
     */
    public void setCodigoBarras(Long codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    /**
     * Obtiene el código interno del objeto.
     *
     * @return El código interno del objeto.
     */
    public String getCodigoInterno() {
        return codigoInterno;
    }

    /**
     * Establece el código interno del objeto.
     *
     * @param codigoInterno El código interno del objeto.
     */
    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    /**
     * Obtiene el nombre del objeto.
     *
     * @return El nombre del objeto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del objeto.
     *
     * @param nombre El nombre del objeto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el precio del objeto.
     *
     * @return El precio del objeto.
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del objeto.
     *
     * @param precio El precio del objeto.
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la fecha de registro del objeto.
     *
     * @return La fecha de registro del objeto.
     */
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Establece la fecha de registro del objeto.
     *
     * @param fechaRegistro La fecha de registro del objeto.
     */
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Método que devuelve una cadena de texto con los atributos del producto.
     * @return una cadena de texto con los atributos del producto.
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
