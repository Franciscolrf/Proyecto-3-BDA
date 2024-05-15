/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.Date;
import java.util.List;

import org.bson.Document;

import dtos.VentaDTO;
import excepciones.PersistenciaException;

/**
 *
 * @author ID145
 */
public interface IGestorVentas {
    /**
     * Método para insertar una venta en la base de datos
     * 
     * @param venta
     * @return true si se insertó correctamente, false en caso contrario
     * @throws PersistenciaException
     */
    boolean insertar(VentaDTO venta) throws PersistenciaException;

    /**
     * Método para eliminar una venta de la base de datos
     * 
     * @param codigoInterno
     * @return true si se eliminó correctamente, false en caso contrario
     * @throws PersistenciaException
     */
    boolean eliminar(String codigoInterno) throws PersistenciaException;

    /**
     * Método para modificar una venta en la base de datos
     * 
     * @param venta
     * @return true si se modificó correctamente, false en caso contrario
     * @throws PersistenciaException
     */
    boolean modificar(VentaDTO venta) throws PersistenciaException;

    /**
     * Método para consultar una venta por su código interno
     * 
     * @param nombreCliente
     * @return la venta si existe, null en caso contrario
     * @throws PersistenciaException
     */
    List<VentaDTO> consultarPorNombreCliente(String nombreCliente) throws PersistenciaException;

    /**
     * Método para consultar una venta por su número de teléfono
     * 
     * @param desde
     * @param hasta
     * @return la venta si existe, null en caso contrario
     * @throws PersistenciaException
     */
    List<VentaDTO> consultarPorRangoFechas(Date desde, Date hasta) throws PersistenciaException;

    /**
     * Método para consultar todas las ventas
     * 
     * @return la lista de ventas
     * @throws PersistenciaException
     */
    List<VentaDTO> consultarTodos() throws PersistenciaException;

    /**
     * Método para convertir un documento de MongoDB en un objeto VentaDTO
     * 
     * @param doc
     * @return el objeto VentaDTO
     * @throws PersistenciaException
     */
    VentaDTO documentToVentaDTO(Document doc) throws PersistenciaException;

    /**
     * Método para convertir un objeto VentaDTO en un documento de MongoDB
     * 
     * @param venta
     * @return el documento de MongoDB
     * @throws PersistenciaException
     */
    Document ventaDTOToDocument(VentaDTO venta) throws PersistenciaException;

    /**
     * Método para consultar una venta por su código interno
     * 
     * @param codigoInterno
     * @return la venta si existe, null en caso contrario
     * @throws PersistenciaException
     */
    VentaDTO consultarPorCodigoInterno(String codigoInterno) throws PersistenciaException;
}
