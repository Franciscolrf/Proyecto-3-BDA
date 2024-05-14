package gestores;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;

import dtos.UsuarioDTO;
import excepciones.PersistenciaException;
import interfaces.IGestorUsuarios;

public class GestorUsuarios implements IGestorUsuarios{

    @Override
    public boolean insertar(UsuarioDTO usuario) throws PersistenciaException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public boolean eliminar(ObjectId idUsuario) throws PersistenciaException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public boolean modificar(UsuarioDTO usuario) throws PersistenciaException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificar'");
    }

    @Override
    public List<UsuarioDTO> consultarPorNombre(String nombre) throws PersistenciaException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consultarPorNombre'");
    }

    @Override
    public List<UsuarioDTO> consultarPorRangoFechas(Date desde, Date hasta) throws PersistenciaException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consultarPorRangoFechas'");
    }

    @Override
    public List<UsuarioDTO> consultarTodos() throws PersistenciaException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consultarTodos'");
    }
    
}
