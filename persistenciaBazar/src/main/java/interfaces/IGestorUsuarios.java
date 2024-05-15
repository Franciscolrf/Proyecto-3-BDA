/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import dtos.UsuarioDTO;
import excepciones.PersistenciaException;
import pojos.Usuario;

/**
 *
 * @author ID145
 */
public interface IGestorUsuarios {
    boolean insertar(UsuarioDTO usuario) throws PersistenciaException;

    boolean eliminar(UsuarioDTO Usuario) throws PersistenciaException; 

    boolean modificar(UsuarioDTO usuario) throws PersistenciaException;

    List<UsuarioDTO> consultarPorNombre(String nombre) throws PersistenciaException;

    List<UsuarioDTO> consultarPorRangoFechas(Date desde, Date hasta) throws PersistenciaException;
    UsuarioDTO consultarPorCodigoInterno(String codigoInterno) throws PersistenciaException;
    List<UsuarioDTO> consultarTodos() throws PersistenciaException;
    Document usuarioDTOToDocument(UsuarioDTO usuario);
    UsuarioDTO documentToUsuarioDTO(Document doc);
    Usuario documentToUsuario(Document doc);
    boolean iniciarSesion(String telefono, String contrasena) throws PersistenciaException;
}
