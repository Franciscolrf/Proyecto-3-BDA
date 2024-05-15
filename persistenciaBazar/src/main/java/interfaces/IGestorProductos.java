/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.Date;
import java.util.List;

import org.bson.Document;

import dtos.ProductoDTO;
import excepciones.PersistenciaException;
import pojos.Producto;

/**
 * Interfaz para el gestor de productos
 * 
 * @author Fran
 */
public interface IGestorProductos {
    /**
     * Método para insertar un producto en la base de datos
     * 
     * @param producto el producto a insertar
     * @return true si se insertó correctamente, false en caso contrario
     * @throws PersistenciaException por si hay un error al insertar el producto.
     */
    boolean insertar(ProductoDTO producto) throws PersistenciaException;

    /**
     * Método para eliminar un producto de la base de datos
     * 
     * @param codigoInterno el código interno del producto a eliminar
     * @return true si se eliminó correctamente, false en caso contrario
     * @throws PersistenciaException por si hay un error al eliminar el producto.
     */
    boolean eliminar(String codigoInterno) throws PersistenciaException;

    /**
     * Método para modificar un producto en la base de datos
     * 
     * @param producto el producto a modificar
     * @return true si se modificó correctamente, false en caso contrario
     * @throws PersistenciaException por si hay un error al modificar el producto.
     */
    boolean modificar(ProductoDTO producto) throws PersistenciaException;

    /**
     * Método para consultar un producto por su código interno
     * 
     * @param codigoInterno el código interno del producto a consultar
     * @return el producto si existe, null en caso contrario
     * @throws PersistenciaException por si hay un error en la consulta.
     */
    Producto consultarPorCodigoInterno(String codigoInterno) throws PersistenciaException;

    /**
     * Método para consultar un producto por su nombre
     * 
     * @param nombre el nombre del producto a consultar
     * @return el producto si existe, null en caso contrario
     * @throws PersistenciaException por si hay un error en la consulta.
     */
    List<ProductoDTO> consultarPorNombre(String nombre) throws PersistenciaException;

    /**
     * Método para consultar un producto por su marca
     * 
     * @param desde fecha de inicio
     * @param hasta fecha de fin
     * @return el producto si existe, null en caso contrario
     * @throws PersistenciaException por si hay un error en la consulta.
     */
    List<ProductoDTO> consultarPorRangoFechas(Date desde, Date hasta) throws PersistenciaException;

    /**
     * Método para consultar todos los productos
     * 
     * @return la lista de productos
     * @throws PersistenciaException por si hay un error en la consulta.
     */
    List<ProductoDTO> consultarTodos() throws PersistenciaException;

    /**
     * Método para convertir un documento de MongoDB a un objeto ProductoDTO
     * 
     * @param doc el documento
     * @return el objeto ProductoDTO
     */
    ProductoDTO documentToProductoDTO(Document doc);

    /**
     * Método para convertir un objeto ProductoDTO a un documento de MongoDB
     * 
     * @param producto el producto
     * @return el documento
     */
    Document productoDTOToDocument(ProductoDTO producto);
}
