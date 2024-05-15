/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que representa la informacion de una venta en el sistema.
 * 
 * @author Fran
 */
public class VentaDTO {
    // Atributos
    private String codigoInterno;
    private String nombreCliente;
    private String apellidoCliente;
    private float montoTotal;
    private MetodoPago metodoPago;
    private UsuarioDTO usuario;
    private Date fechaVenta;
    private List<ProductoDTO> productosVendidos;

    /**
     * Enumeracion de los metodos de pago disponibles en el sistema.
     */
    public static enum MetodoPago {
        /**
         * Representa el pago en efectivo.
         */
        EFECTIVO,
        /**
         * Representa el pago con tarjeta.
         */
        TARJETA
    }

    // Constructores

    /**
     * Constructor vacío
     */
    public VentaDTO() {
    }

    /**
     * Crea una instancia con la informacion de una venta realizada en el sistema.
     * 
     * @param nombreCliente     el nombre del cliente.
     * @param apellidoCliente   el apellido del cliente.
     * @param montoTotal        el monto total de la venta.
     * @param metodoPago        el metodo de pago de la venta.
     * @param usuario           el usuario que realizo la venta.
     * @param fechaVenta        la fecha de la venta.
     * @param productosVendidos los productos vendidos en la venta.
     */

    public VentaDTO(String nombreCliente, String apellidoCliente, float montoTotal, MetodoPago metodoPago,
            UsuarioDTO usuario, Date fechaVenta, List<ProductoDTO> productosVendidos) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.montoTotal = montoTotal;
        this.metodoPago = metodoPago;
        this.usuario = usuario;
        this.fechaVenta = fechaVenta;
        this.productosVendidos = productosVendidos;
    }

    /**
     * Crea una instancia con la informacion de una venta realizada en el sistema
     * sin id.
     * 
     * @param nombreCliente   el nombre del cliente.
     * @param apellidoCliente el apellido del cliente.
     * @param montoTotal      el monto total de la venta.
     * @param metodoPago      el metodo de pago de la venta.
     * @param usuario         el usuario que realizo la venta.
     * @param fechaVenta      la fecha de la venta.
     */

    public VentaDTO(String nombreCliente, String apellidoCliente, float montoTotal, MetodoPago metodoPago,
            UsuarioDTO usuario, Date fechaVenta) {
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.montoTotal = montoTotal;
        this.metodoPago = metodoPago;
        this.usuario = usuario;
        this.fechaVenta = fechaVenta;
    }

    // Getters y Setters

    /**
     * Metodo que regresa el codigo interno de la venta.
     * 
     * @return el codigo interno de la venta.
     */
    public String getCodigoInterno() {
        return codigoInterno;
    }

    /**
     * Metodo que establece el codigo interno de la venta.
     * 
     * @param codigoInterno el codigo interno de la venta.
     */
    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    /**
     * Metodo que regresa el nombre del cliente.
     * 
     * @return el nombre del cliente.
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * Metodo que establece el nombre del cliente.
     * 
     * @param nombreCliente el nombre del cliente.
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * Metodo que regresa el apellido del cliente.
     * 
     * @return el apellido del cliente.
     */
    public String getApellidoCliente() {
        return apellidoCliente;
    }

    /**
     * Metodo que establece el apellido del cliente.
     * 
     * @param apellidoCliente el apellido del cliente.
     */
    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    /**
     * Metodo que regresa el monto total de la venta.
     * 
     * @return el monto total de la venta.
     */
    public float getMontoTotal() {
        return montoTotal;
    }

    /**
     * Metodo que establece el monto total de la venta.
     * 
     * @param montoTotal el monto total de la venta.
     */
    public void setMontoTotal(float montoTotal) {
        this.montoTotal = montoTotal;
    }

    /**
     * Metodo que regresa el metodo de pago de la venta.
     * 
     * @return el metodo de pago de la venta.
     */
    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    /**
     * Metodo que establece el metodo de pago de la venta.
     * 
     * @param metodoPago el metodo de pago de la venta.
     */
    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    /**
     * Metodo que regresa el usuario que realizo la venta.
     * 
     * @return el usuario que realizo la venta.
     */
    public UsuarioDTO getUsuario() {
        return usuario;
    }

    /**
     * Metodo que establece el usuario que realizo la venta.
     * 
     * @param usuario el usuario que realizo la venta.
     */
    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    /**
     * Metodo que regresa la fecha de la venta.
     * 
     * @return la fecha de la venta.
     */
    public Date getFechaVenta() {
        return fechaVenta;
    }

    /**
     * Metodo que establece la fecha de la venta.
     * 
     * @param fechaVenta la fecha de la venta.
     */
    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    /**
     * Metodo que regresa los productos vendidos en la venta.
     * 
     * @return los productos vendidos en la venta.
     */
    public List<ProductoDTO> getProductosVendidos() {
        return productosVendidos;
    }

    /**
     * Metodo que establece los productos vendidos en la venta.
     * 
     * @param productosVendidos los productos vendidos en la venta.
     */
    public void setProductosVendidos(List<ProductoDTO> productosVendidos) {
        this.productosVendidos = productosVendidos;
    }

    /*
     * Metodo que regresa la representacion en cadena de la venta.
     */
    @Override
    public String toString() {
        return "VentaDTO{" + "nombreCliente=" + nombreCliente + ", apellidoCliente=" + apellidoCliente + ", montoTotal="
                + montoTotal + ", metodoPago=" + metodoPago + ", usuario=" + usuario + ", fechaVenta=" + fechaVenta
                + ", productosVendidos=" + productosVendidos + '}';
    }

}
