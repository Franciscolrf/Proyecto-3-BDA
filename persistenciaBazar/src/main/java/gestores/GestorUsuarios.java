package gestores;

import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import conexion.ConexionBD;
import dtos.DireccionDTO;
import dtos.UsuarioDTO;
import excepciones.PersistenciaException;
import interfaces.IGestorUsuarios;

public class GestorUsuarios implements IGestorUsuarios {
    // Atributos
    private MongoCollection<Document> usuariosCollection;

    // Constructores

    /**
     * Constructor por defecto.
     * 
     * @throws PersistenciaException
     */
    public GestorUsuarios() throws PersistenciaException {
        MongoDatabase database = ConexionBD.getDatabase();
        usuariosCollection = database.getCollection("usuarios");
    }

    @Override
    public boolean insertar(UsuarioDTO usuario) throws PersistenciaException {
        if (usuario==null) {
            throw new PersistenciaException("El usuario no puede ser nulo");
        }

        try {
            Document doc = usuarioDTOToDocument(usuario);
            usuariosCollection.insertOne(doc);
            return true;
        } catch (Exception e) {
            throw new PersistenciaException("Error al insertar el usuario", e);
        }
    }

    @Override
    public boolean eliminar(UsuarioDTO usuario) throws PersistenciaException {
        if (usuario==null) {
            throw new PersistenciaException("El id del usuario no puede ser nulo");
        }
        try{
            Document doc = usuarioDTOToDocument(usuario);
            usuariosCollection.deleteOne(doc);
            return true;
        } catch (Exception e) {
            throw new PersistenciaException("Error al eliminar el usuario", e);
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

    private Document usuarioDTOToDocument(UsuarioDTO usuario) {
        Document doc = new Document("nombre", usuario.getNombre())
                .append("apellido", usuario.getApellido())
                .append("fechaContratacion", usuario.getFechaContratacion())
                .append("puesto", usuario.getPuesto().name())
                .append("telefono", usuario.getTelefono())
                .append("contrasena", usuario.getContrasena())
                .append("direccion", new Document("ciudad", usuario.getDireccion().getCiudad())
                        .append("numeroEdificio", usuario.getDireccion().getNumeroEdificio())
                        .append("calle", usuario.getDireccion().getCalle())
                        .append("colonia", usuario.getDireccion().getColonia())
                        .append("codigoPostal", usuario.getDireccion().getCodigoPostal()));

        return doc;
    }

    private UsuarioDTO documentToUsuarioDTO(Document doc) {
        Document direccionDoc = (Document) doc.get("direccion");
        return new UsuarioDTO(
                doc.getString("nombre"),
                doc.getString("apellido"),
                new Date(doc.getDate("fechaContratacion").getTime()),
                UsuarioDTO.Puesto.valueOf(doc.getString("puesto")),
                doc.getString("telefono"),
                doc.getString("contrasena"),
                new DireccionDTO(
                        direccionDoc.getString("ciudad"),
                        direccionDoc.getString("numeroEdificio"),
                        direccionDoc.getString("calle"),
                        direccionDoc.getString("colonia"),
                        direccionDoc.getString("codigoPostal")));
    }

}
