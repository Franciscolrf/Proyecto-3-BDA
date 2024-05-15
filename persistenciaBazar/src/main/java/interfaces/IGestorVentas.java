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
 * Interfaz para el gestor de ventas
 * 
 * @author Fran
 */
public interface IGestorVentas {
    /**
     * Método para insertar una venta en la base de datos
     * 
     * @param venta la venta a insertar
     * @return true si se insertó correctamente, false en caso contrario
     * @throws PersistenciaException por si hay un error al insertar la venta.
     */
    boolean insertar(VentaDTO venta) throws PersistenciaException;

    /**
     * Método para eliminar una venta de la base de datos
     * 
     * @param codigoInterno el código interno de la venta a eliminar
     * @return true si se eliminó correctamente, false en caso contrario
     * @throws PersistenciaException por si hay un error al eliminar la venta.
     */
    boolean eliminar(String codigoInterno) throws PersistenciaException;

    /**
     * Método para modificar una venta en la base de datos
     * 
     * @param venta la venta a modificar
     * @return true si se modificó correctamente, false en caso contrario
     * @throws PersistenciaException por si hay un error al modificar la venta.
     */
    boolean modificar(VentaDTO venta) throws PersistenciaException;

    /**
     * Método para consultar una venta por su código interno
     * 
     * @param nombreCliente el nombre del cliente a consultar
     * @return la venta si existe, null en caso contrario
     * @throws PersistenciaException por si hay un error en la consulta.
     */
    List<VentaDTO> consultarPorNombreCliente(String nombreCliente) throws PersistenciaException;

    /**
     * Método para consultar una venta por su número de teléfono
     * 
     * @param desde fecha de inicio del rango
     * @param hasta fecha de fin del rango
     * @return la venta si existe, null en caso contrario
     * @throws PersistenciaException por si hay un error en la consulta.
     */
    List<VentaDTO> consultarPorRangoFechas(Date desde, Date hasta) throws PersistenciaException;

    /**
     * Método para consultar todas las ventas
     * 
     * @return la lista de ventas
     * @throws PersistenciaException por si hay un error en la consulta.
     */
    List<VentaDTO> consultarTodos() throws PersistenciaException;

    /**
     * Método para convertir un documento de MongoDB en un objeto VentaDTO
     * 
     * @param doc el documento
     * @return el objeto VentaDTO
     * @throws PersistenciaException por si hay un error en la conversión.
     */
    VentaDTO documentToVentaDTO(Document doc) throws PersistenciaException;

    /**
     * Método para convertir un objeto VentaDTO en un documento de MongoDB
     * 
     * @param venta el objeto VentaDTO
     * @return el documento de MongoDB
     * @throws PersistenciaException por si hay un error en la conversión.
     */
    Document ventaDTOToDocument(VentaDTO venta) throws PersistenciaException;

    /**
     * Método para consultar una venta por su código interno
     * 
     * @param codigoInterno el código interno de la venta a consultar
     * @return la venta si existe, null en caso contrario
     * @throws PersistenciaException por si hay un error en la consulta.
     */
    VentaDTO consultarPorCodigoInterno(String codigoInterno) throws PersistenciaException;
}
