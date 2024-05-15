/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.Date;
import java.util.List;

import org.bson.Document;

import dtos.UsuarioDTO;
import excepciones.PersistenciaException;
import pojos.Usuario;

/**
 *
 * @author ID145
 */
public interface IGestorUsuarios {
    /**
     * Método para insertar un usuario en la base de datos
     * 
     * @param usuario
     * @return true si se insertó correctamente, false en caso contrario
     * @throws PersistenciaException
     */
    boolean insertar(UsuarioDTO usuario) throws PersistenciaException;

    /**
     * Método para eliminar un usuario de la base de datos
     * 
     * @param codigoInterno
     * @return true si se eliminó correctamente, false en caso contrario
     * @throws PersistenciaException
     */
    boolean eliminar(String codigoInterno) throws PersistenciaException;

    /**
     * Método para modificar un usuario en la base de datos
     * 
     * @param usuario
     * @return true si se modificó correctamente, false en caso contrario
     * @throws PersistenciaException
     */
    boolean modificar(UsuarioDTO usuario) throws PersistenciaException;

    /**
     * Método para consultar un usuario por su código interno
     * 
     * @param nombre
     * @return el usuario si existe, null en caso contrario
     * @throws PersistenciaException
     */
    List<UsuarioDTO> consultarPorNombre(String nombre) throws PersistenciaException;

    /**
     * Método para consultar un usuario por su número de teléfono
     * 
     * @param desde
     * @param hasta
     * @return la lista de usuarios que cumplan con el rango de fechas
     * @throws PersistenciaException
     */
    List<UsuarioDTO> consultarPorRangoFechas(Date desde, Date hasta) throws PersistenciaException;

    /**
     * Método para consultar un usuario por su código interno
     * 
     * @param codigoInterno
     * @return el usuario si existe, null en caso contrario
     * @throws PersistenciaException
     */
    UsuarioDTO consultarPorCodigoInterno(String codigoInterno) throws PersistenciaException;

    /**
     * Método para consultar todos los usuarios
     * 
     * @return la lista de todos los usuarios
     * @throws PersistenciaException
     */
    List<UsuarioDTO> consultarTodos() throws PersistenciaException;

    /**
     * Método para convertir un usuarioDTO a un Document
     * 
     * @param usuario
     * @return el Document
     */
    Document usuarioDTOToDocument(UsuarioDTO usuario);

    /**
     * Método para convertir un Document a un usuarioDTO
     * 
     * @param doc
     * @return el usuarioDTO
     */
    UsuarioDTO documentToUsuarioDTO(Document doc);

    /**
     * Método para convertir un usuario a un Document
     * 
     * @param doc
     * @return el Document
     */
    Usuario documentToUsuario(Document doc);

    /**
     * Método para iniciar sesión
     * 
     * @param telefono
     * @param contrasena
     * @return true si se inicia sesión correctamente, false en caso contrario
     * @throws PersistenciaException
     */
    boolean iniciarSesion(String telefono, String contrasena) throws PersistenciaException;
}
