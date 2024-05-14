/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

/**
 *
 * @author ID145
 */
public class VentaDTO {
    private ObjectId _id;
    private String nombreCliente;
    private String apellidoCliente;
    private float montoTotal;
    private MetodoPago metodoPago;
    private UsuarioDTO usuario;
    private Date fechaVenta;
    private List<ProductoDTO> productosVendidos;

    private static enum MetodoPago {
        EFECTIVO,
        TARJETA
    }

    public VentaDTO() {
    }

    /**
     * Crea una instancia con la informacion de una venta realizada en el sistema.
     * 
     * @param _id
     * @param nombreCliente
     * @param apellidoCliente
     * @param montoTotal
     * @param metodoPago
     * @param usuario
     * @param fechaVenta
     * @param productosVendidos
     */

    public VentaDTO(ObjectId _id, String nombreCliente, String apellidoCliente, float montoTotal, MetodoPago metodoPago,
            UsuarioDTO usuario, Date fechaVenta, List<ProductoDTO> productosVendidos) {
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
     * Crea una instancia con la informacion de una venta realizada en el sistema
     * sin id.
     * 
     * @param nombreCliente
     * @param apellidoCliente
     * @param montoTotal
     * @param metodoPago
     * @param usuario
     * @param fechaVenta
     * @param productosVendidos
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

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public List<ProductoDTO> getProductosVendidos() {
        return productosVendidos;
    }

    public void setProductosVendidos(List<ProductoDTO> productosVendidos) {
        this.productosVendidos = productosVendidos;
    }

    @Override
    public String toString() {
        return "VentaDTO{" + "nombreCliente=" + nombreCliente + ", apellidoCliente=" + apellidoCliente + ", montoTotal="
                + montoTotal + ", metodoPago=" + metodoPago + ", usuario=" + usuario + ", fechaVenta=" + fechaVenta
                + ", productosVendidos=" + productosVendidos + '}';
    }
}
