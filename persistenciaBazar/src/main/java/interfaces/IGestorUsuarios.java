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
 * Interfaz para el gestor de usuarios
 * 
 * @author Fran
 */
public interface IGestorUsuarios {
    /**
     * Método para insertar un usuario en la base de datos
     * 
     * @param usuario el usuario a insertar
     * @return true si se insertó correctamente, false en caso contrario
     * @throws PersistenciaException por si hay un error al insertar el usuario
     */
    boolean insertar(UsuarioDTO usuario) throws PersistenciaException;

    /**
     * Método para eliminar un usuario de la base de datos
     * 
     * @param codigoInterno el código interno del usuario a eliminar
     * @return true si se eliminó correctamente, false en caso contrario
     * @throws PersistenciaException por si hay un error al eliminar el usuario
     */
    boolean eliminar(String codigoInterno) throws PersistenciaException;

    /**
     * Método para modificar un usuario en la base de datos
     * 
     * @param usuario el usuario a modificar
     * @return true si se modificó correctamente, false en caso contrario
     * @throws PersistenciaException por si hay un error al modificar el usuario
     */
    boolean modificar(UsuarioDTO usuario) throws PersistenciaException;

    /**
     * Método para consultar un usuario por su código interno
     * 
     * @param nombre el nombre del usuario a consultar
     * @return el usuario si existe, null en caso contrario
     * @throws PersistenciaException por si hay un error en la consulta
     */
    List<UsuarioDTO> consultarPorNombre(String nombre) throws PersistenciaException;

    /**
     * Método para consultar un usuario por su número de teléfono
     * 
     * @param desde fecha de inicio del rango
     * @param hasta fecha de fin del rango
     * @return la lista de usuarios que cumplan con el rango de fechas
     * @throws PersistenciaException por si hay un error en la consulta
     */
    List<UsuarioDTO> consultarPorRangoFechas(Date desde, Date hasta) throws PersistenciaException;

    /**
     * Método para consultar un usuario por su código interno
     * 
     * @param codigoInterno el código interno del usuario a consultar
     * @return el usuario si existe, null en caso contrario
     * @throws PersistenciaException por si hay un error en la consulta
     */
    UsuarioDTO consultarPorCodigoInterno(String codigoInterno) throws PersistenciaException;

    /**
     * Método para consultar todos los usuarios
     * 
     * @return la lista de todos los usuarios
     * @throws PersistenciaException por si hay un error en la consulta
     */
    List<UsuarioDTO> consultarTodos() throws PersistenciaException;

    /**
     * Método para convertir un usuarioDTO a un Document
     * 
     * @param usuario el usuarioDTO a convertir
     * @return el Document
     */
    Document usuarioDTOToDocument(UsuarioDTO usuario);

    /**
     * Método para convertir un Document a un usuarioDTO
     * 
     * @param doc el Document a convertir
     * @return el usuarioDTO
     */
    UsuarioDTO documentToUsuarioDTO(Document doc);

    /**
     * Método para convertir un usuario a un Document
     * 
     * @param doc el usuario a convertir
     * @return el Document
     */
    Usuario documentToUsuario(Document doc);

    /**
     * Método para iniciar sesión
     * 
     * @param telefono   el teléfono del usuario
     * @param contrasena la contraseña del usuario
     * @return true si se inicia sesión correctamente, false en caso contrario
     * @throws PersistenciaException por si hay un error al iniciar sesión
     */
    boolean iniciarSesion(String telefono, String contrasena) throws PersistenciaException;
}
