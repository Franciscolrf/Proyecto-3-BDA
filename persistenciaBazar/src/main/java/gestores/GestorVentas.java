package gestores;

import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import conexion.ConexionBD;
import dtos.VentaDTO;
import excepciones.PersistenciaException;
import interfaces.IGestorVentas;

public class GestorVentas implements IGestorVentas {
    // Atributos
    private MongoCollection<Document> ventasCollection;

    // Constructores

    /**
     * Constructor por defecto.
     * 
     * @throws PersistenciaException
     */
    public GestorVentas() throws PersistenciaException {
        MongoDatabase database = ConexionBD.getDatabase();
        ventasCollection = database.getCollection("ventas");
    }

    @Override
    public boolean insertar(VentaDTO venta) throws PersistenciaException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insertar'");
    }

    @Override
    public boolean eliminar(ObjectId idVenta) throws PersistenciaException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

    @Override
    public boolean modificar(VentaDTO venta) throws PersistenciaException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificar'");
    }

    @Override
    public List<VentaDTO> consultarPorNombreCliente(String nombreCliente) throws PersistenciaException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consultarPorNombreCliente'");
    }

    @Override
    public List<VentaDTO> consultarPorRangoFechas(Date desde, Date hasta) throws PersistenciaException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consultarPorRangoFechas'");
    }

    @Override
    public List<VentaDTO> consultarTodos() throws PersistenciaException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'consultarTodos'");
    }

    

}
