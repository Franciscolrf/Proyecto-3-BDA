/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import dtos.VentaDTO;
import excepciones.PersistenciaException;

/**
 *
 * @author ID145
 */
public interface IGestorVentas {
    boolean insertar(VentaDTO venta) throws PersistenciaException;

    boolean eliminar(String codigoInterno) throws PersistenciaException;

    boolean modificar(VentaDTO venta) throws PersistenciaException;

    List<VentaDTO> consultarPorNombreCliente(String nombreCliente) throws PersistenciaException;

    List<VentaDTO> consultarPorRangoFechas(Date desde, Date hasta) throws PersistenciaException;

    List<VentaDTO> consultarTodos() throws PersistenciaException;

    VentaDTO documentToVentaDTO(Document doc) throws PersistenciaException;

    Document ventaDTOToDocument(VentaDTO venta) throws PersistenciaException;
}
