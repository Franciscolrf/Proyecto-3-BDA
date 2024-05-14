/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import colecciones.Producto;
import dtos.ProductoDTO;
import excepciones.PersistenciaException;
import java.time.LocalDateTime;
import org.bson.Document;

/**
 *
 * @author rramirez
 */
public class ConvertidorBazarDTO {

    /*
     * Convierte un ProductoDTO a producto
     */
    public Producto convertirProductoDTOAProducto(ProductoDTO productoDTO) throws PersistenciaException {
        if (productoDTO == null)
        {
            throw new PersistenciaException("El productoDTO dado es null");
        }
        Long codigoBarras = productoDTO.getCodigoBarras();
        String codigoInterno = productoDTO.getCodigoInterno();
        String nombre = productoDTO.getNombre();
        double precio = productoDTO.getPrecio();
        LocalDateTime fechaRegistro = productoDTO.getFechaRegistro();

        Producto producto = new Producto(codigoBarras, codigoInterno, nombre, precio, fechaRegistro);

        return producto;
    }

    /*
     * Convierte Producto a Documento
     */
    public Document convertirProductoADocumento(Producto producto) throws PersistenciaException {
        if (producto == null)
        {
            throw new PersistenciaException("El producto dado es null");
        }

        Long codigoBarras = producto.getCodigoBarras();
        String codigoInterno = producto.getCodigoInterno();
        String nombre = producto.getNombre();
        double precio = producto.getPrecio();
        LocalDateTime fechaRegistro = producto.getFechaRegistro();

        Document productoDoc = new Document()
                .append("codigoBarras", codigoBarras)
                .append("codigoInterno", codigoInterno)
                .append("nombre", nombre)
                .append("precio", precio)
                .append("fechaRegistro", fechaRegistro);

        return productoDoc;
    }

    // Método para convertir un Documento a ProductoDTO
    public ProductoDTO convertirDocumentoAProductoDTO(Document productoDoc) throws PersistenciaException {
        if (productoDoc == null)
        {
            throw new PersistenciaException("El producto dado es null");
        }

        Long codigoBarras = productoDoc.getLong("codigoBarras");
        String codigoInterno = productoDoc.getString("codigoInterno");
        String nombre = productoDoc.getString("nombre");
        double precio = productoDoc.getDouble("precio");
        LocalDateTime fechaRegistro = productoDoc.get("fechaRegistro", LocalDateTime.class);

        ProductoDTO productoDTO = new ProductoDTO(codigoBarras, codigoInterno, nombre, precio, fechaRegistro);
        
        return productoDTO;
    }

    // Método para validar los campos del producto
    private void validarCamposProductoDTO(ProductoDTO productoDTO) {
        if (productoDTO.getCodigoBarras() == null || productoDTO.getCodigoInterno() == null || productoDTO.getNombre() == null
                || productoDTO.getPrecio() <= 0 || productoDTO.getFechaRegistro() == null)
        {
            throw new IllegalArgumentException("El producto tiene campos nulos o inválidos");
        }
    }

}
