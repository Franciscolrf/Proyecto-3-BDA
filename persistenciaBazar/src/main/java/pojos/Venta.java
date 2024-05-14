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

    /*
     * Constructor por defecto.
     */
    public Venta() {
    }

    /*
     * Constructor con todos los atributos.
     * 
     * @param _id Identificador de la venta.
     * 
     * @param nombreCliente Nombre del cliente.
     * 
     * @param apellidoCliente Apellido del cliente.
     * 
     * @param montoTotal Monto total de la venta.
     * 
     * @param metodoPago Método de pago de la venta.
     * 
     * @param usuario Usuario que realizó la venta.
     * 
     * @param fechaVenta Fecha de la venta.
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

    /*
     * Constructor con todos los atributos excepto el identificador.
     * 
     * @param nombreCliente Nombre del cliente.
     * 
     * @param apellidoCliente Apellido del cliente.
     * 
     * @param montoTotal Monto total de la venta.
     * 
     * @param metodoPago Método de pago de la venta.
     * 
     * @param usuario Usuario que realizó la venta.
     * 
     * @param fechaVenta Fecha de la venta.
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
    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public float getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public List<Producto> getProductosVendidos() {
        return productosVendidos;
    }

    public void setProductosVendidos(List<Producto> productosVendidos) {
        this.productosVendidos = productosVendidos;
    }

    /*
     * Método toString.
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
