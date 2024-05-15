/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

/**
 * Clase que representa una venta.
 * 
 * @author Fran
 */
public class Venta {

    // Atributos
    private ObjectId _id;
    private String nombreCliente;
    private String apellidoCliente;
    private float montoTotal;
    private MetodoPago metodoPago;
    private Usuario usuario;
    private Date fechaVenta;
    private List<Producto> productosVendidos;

    /**
     * Enumeración que representa los métodos de pago.
     */
    private static enum MetodoPago {
        EFECTIVO,
        TARJETA
    }

    // Constructores

    /**
     * Constructor por defecto.
     */
    public Venta() {
    }

    /**
     * Constructor con todos los atributos.
     * 
     * @param _id               Identificador de la venta.
     * 
     * @param nombreCliente     Nombre del cliente.
     * 
     * @param apellidoCliente   Apellido del cliente.
     * 
     * @param montoTotal        Monto total de la venta.
     * 
     * @param metodoPago        Método de pago de la venta.
     * 
     * @param usuario           Usuario que realizó la venta.
     * 
     * @param fechaVenta        Fecha de la venta.
     * 
     * @param productosVendidos Productos vendidos en la venta.
     */
    public Venta(ObjectId _id, String nombreCliente, String apellidoCliente, float montoTotal, MetodoPago metodoPago,
            Usuario usuario, Date fechaVenta, List<Producto> productosVendidos) {
        this._id = _id;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.montoTotal = montoTotal;
        this.metodoPago = metodoPago;
        this.usuario = usuario;
        this.fechaVenta = fechaVenta;
        this.productosVendidos = productosVendidos;
    }

    /**
     * Constructor con todos los atributos excepto el identificador.
     * 
     * @param nombreCliente     Nombre del cliente.
     * 
     * @param apellidoCliente   Apellido del cliente.
     * 
     * @param montoTotal        Monto total de la venta.
     * 
     * @param metodoPago        Método de pago de la venta.
     * 
     * @param usuario           Usuario que realizó la venta.
     * 
     * @param fechaVenta        Fecha de la venta.
     * 
     * @param productosVendidos Productos vendidos en la venta.
     */
    public Venta(String nombreCliente, String apellidoCliente, float montoTotal, MetodoPago metodoPago, Usuario usuario,
            Date fechaVenta, List<Producto> productosVendidos) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.montoTotal = montoTotal;
        this.metodoPago = metodoPago;
        this.usuario = usuario;
        this.fechaVenta = fechaVenta;
        this.productosVendidos = productosVendidos;
    }

    // Getters y Setters
    /**
     * Devuelve el ID del objeto.
     *
     * @return Un ObjectId que representa el ID del objeto.
     */
    public ObjectId get_id() {
        return _id;
    }

    /**
     * Establece el ID del objeto.
     *
     * @param _id Un ObjectId que se establecerá como el ID del objeto.
     */
    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    /**
     * Devuelve el nombre del cliente.
     *
     * @return Una cadena que representa el nombre del cliente.
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombreCliente Una cadena que se establecerá como el nombre del
     *                      cliente.
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * Devuelve el apellido del cliente.
     *
     * @return Una cadena que representa el apellido del cliente.
     */
    public String getApellidoCliente() {
        return apellidoCliente;
    }

    /**
     * Establece el apellido del cliente.
     *
     * @param apellidoCliente Una cadena que se establecerá como el apellido del
     *                        cliente.
     */
    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    /**
     * Devuelve el monto total de la venta.
     *
     * @return Un float que representa el monto total de la venta.
     */
    public float getMontoTotal() {
        return montoTotal;
    }

    /**
     * Establece el monto total de la venta.
     *
     * @param montoTotal Un float que se establecerá como el monto total de la
     *                   venta.
     */
    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    /**
     * Devuelve el método de pago de la venta.
     *
     * @return Un objeto MetodoPago que representa el método de pago de la venta.
     */
    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    /**
     * Establece el método de pago de la venta.
     *
     * @param metodoPago Un objeto MetodoPago que se establecerá como el método de
     *                   pago de la venta.
     */
    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    /**
     * Devuelve el usuario que realizó la venta.
     *
     * @return Un objeto Usuario que representa al usuario que realizó la venta.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario que realizó la venta.
     *
     * @param usuario Un objeto Usuario que se establecerá como el usuario que
     *                realizó la venta.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Devuelve la fecha de la venta.
     *
     * @return Un objeto Date que representa la fecha de la venta.
     */
    public Date getFechaVenta() {
        return fechaVenta;
    }

    /**
     * Establece la fecha de la venta.
     *
     * @param fechaVenta Un objeto Date que se establecerá como la fecha de la
     *                   venta.
     */
    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    /**
     * Devuelve la lista de productos vendidos.
     *
     * @return Una lista de objetos Producto que representa los productos vendidos.
     */
    public List<Producto> getProductosVendidos() {
        return productosVendidos;
    }

    /**
     * Establece la lista de productos vendidos.
     *
     * @param productosVendidos Una lista de objetos Producto que se establecerá
     *                          como los productos vendidos.
     */
    public void setProductosVendidos(List<Producto> productosVendidos) {
        this.productosVendidos = productosVendidos;
    }

    /**
     * Método toString.
     * @return Una cadena que representa el objeto.
     */
    @Override
    public String toString() {
        return "Venta{" +
                "_id=" + _id +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", apellidoCliente='" + apellidoCliente + '\'' +
                ", montoTotal=" + montoTotal +
                ", metodoPago=" + metodoPago +
                ", usuario=" + usuario +
                ", fechaVenta=" + fechaVenta +
                ", productosVendidos=" + productosVendidos +
                '}';
    }
}
