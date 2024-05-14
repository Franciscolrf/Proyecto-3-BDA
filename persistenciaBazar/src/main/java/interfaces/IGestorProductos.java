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

/**
 *
 * @author ID145
 */
public interface IGestorProductos {
    boolean insertar(ProductoDTO producto) throws PersistenciaException;

    boolean eliminar(Long codigoBarras) throws PersistenciaException; // Suponiendo que se eliminará por código de
                                                                      // barras

    boolean modificar(ProductoDTO producto) throws PersistenciaException;

    List<ProductoDTO> consultarPorNombre(String nombre) throws PersistenciaException;

    List<ProductoDTO> consultarPorRangoFechas(Date desde, Date hasta) throws PersistenciaException;

    List<ProductoDTO> consultarTodos() throws PersistenciaException;

     ProductoDTO documentToProductoDTO(Document doc);
     Document productoDTOToDocument(ProductoDTO producto);
}
