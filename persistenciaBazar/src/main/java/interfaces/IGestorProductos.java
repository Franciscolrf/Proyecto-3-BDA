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
 *
 * @author ID145
 */
public interface IGestorProductos {
    /**
     * Método para insertar un producto en la base de datos
     * 
     * @param producto
     * @return true si se insertó correctamente, false en caso contrario
     * @throws PersistenciaException
     */
    boolean insertar(ProductoDTO producto) throws PersistenciaException;

    /**
     * Método para eliminar un producto de la base de datos
     * 
     * @param codigoInterno
     * @return true si se eliminó correctamente, false en caso contrario
     * @throws PersistenciaException
     */
    boolean eliminar(String codigoInterno) throws PersistenciaException;

    /**
     * Método para modificar un producto en la base de datos
     * 
     * @param producto
     * @return true si se modificó correctamente, false en caso contrario
     * @throws PersistenciaException
     */
    boolean modificar(ProductoDTO producto) throws PersistenciaException;

    /**
     * Método para consultar un producto por su código interno
     * 
     * @param codigoInterno
     * @return el producto si existe, null en caso contrario
     * @throws PersistenciaException
     */
    Producto consultarPorCodigoInterno(String codigoInterno) throws PersistenciaException;

    /**
     * Método para consultar un producto por su nombre
     * 
     * @param nombre
     * @return el producto si existe, null en caso contrario
     * @throws PersistenciaException
     */
    List<ProductoDTO> consultarPorNombre(String nombre) throws PersistenciaException;

    /**
     * Método para consultar un producto por su marca
     * 
     * @param desde
     * @param hasta
     * @return el producto si existe, null en caso contrario
     * @throws PersistenciaException
     */
    List<ProductoDTO> consultarPorRangoFechas(Date desde, Date hasta) throws PersistenciaException;

    /**
     * Método para consultar todos los productos
     * 
     * @return la lista de productos
     * @throws PersistenciaException
     */
    List<ProductoDTO> consultarTodos() throws PersistenciaException;

    /**
     * Método para convertir un documento de MongoDB a un objeto ProductoDTO
     * 
     * @param doc
     * @return el objeto ProductoDTO
     */
    ProductoDTO documentToProductoDTO(Document doc);

    /**
     * Método para convertir un objeto ProductoDTO a un documento de MongoDB
     * 
     * @param producto
     * @return el documento
     */
    Document productoDTOToDocument(ProductoDTO producto);
}
