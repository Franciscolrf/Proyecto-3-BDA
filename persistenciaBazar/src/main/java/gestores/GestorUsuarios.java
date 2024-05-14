package gestores;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import conexion.ConexionBD;
import dtos.DireccionDTO;
import dtos.UsuarioDTO;
import excepciones.PersistenciaException;
import interfaces.IGestorUsuarios;
import pojos.Direccion;
import pojos.Usuario;

import static com.mongodb.client.model.Filters.*;

/**
 * Clase que se encarga de gestionar los usuarios en la base de datos MongoDB
 * Implementa la interfaz IGestorUsuarios
 * @author Fran
 */
public class GestorUsuarios implements IGestorUsuarios {
    // Atributos
    private MongoCollection<Document> usuariosCollection;
    private static UsuarioDTO usuarioLogueado;

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

    /**
     * Inserta un usuario en la base de datos.
     * 
     * @param usuario El usuario a insertar.
     * @return true si se insertó correctamente, false en caso contrario.
     */
    @Override
    public boolean insertar(UsuarioDTO usuario) throws PersistenciaException {
        if (usuario == null) {
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
    // ...

    /**
     * Elimina un usuario de la base de datos.
     * 
     * @param usuario El usuario a eliminar.
     * @return true si se eliminó correctamente, false en caso contrario.
     * @throws PersistenciaException
     */
    @Override
    public boolean eliminar(UsuarioDTO usuario) throws PersistenciaException {
        if (usuario == null || usuario.getNombre() == null) {
            throw new PersistenciaException("El usuario o su nombre no pueden ser nulos");
        }

        try {
            usuariosCollection.deleteOne(eq("nombre", usuario.getNombre()));
            return true;
        } catch (Exception e) {
            throw new PersistenciaException("Error al eliminar el usuario", e);
        }
    }

    /**
     * Modifica un usuario en la base de datos.
     * 
     * @param usuario El usuario a modificar.
     * @return true si se modificó correctamente, false en caso contrario.
     * @throws PersistenciaException
     */
    @Override
    public boolean modificar(UsuarioDTO usuario) throws PersistenciaException {
        if (usuario == null || usuario.getNombre() == null) {
            throw new PersistenciaException("El usuario o su nombre no pueden ser nulos");
        }

        try {
            Document doc = usuarioDTOToDocument(usuario);
            usuariosCollection.replaceOne(eq("nombre", usuario.getNombre()), doc);
            return true;
        } catch (Exception e) {
            throw new PersistenciaException("Error al modificar el usuario", e);
        }
    }

    /**
     * Consulta usuarios por nombre.
     * 
     * @param nombre El nombre del usuario a buscar.
     * @return Una lista con los usuarios que coinciden con el nombre.
     * @throws PersistenciaException
     */
    @Override
    public List<UsuarioDTO> consultarPorNombre(String nombre) throws PersistenciaException {
        if (nombre == null || nombre.isEmpty()) {
            throw new PersistenciaException("El nombre no puede ser nulo o vacío");
        }

        List<UsuarioDTO> usuarios = new ArrayList<>();
        try {
            usuariosCollection.find(regex("nombre", nombre, "i")).forEach((Consumer<Document>) doc -> {
                UsuarioDTO usuario = documentToUsuarioDTO(doc);
                usuarios.add(usuario);
            });

            if (usuarios.isEmpty()) {
                throw new PersistenciaException("No se encontraron usuarios");
            }

            return usuarios;
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar el usuario por nombre", e);
        }
    }

    /**
     * Consulta usuarios por rango de fechas.
     * 
     * @param desde Fecha de inicio del rango.
     * @param hasta Fecha de fin del rango.
     * @return Una lista con los usuarios que coinciden con el rango de fechas.
     * @throws PersistenciaException
     */
    @Override
    public List<UsuarioDTO> consultarPorRangoFechas(Date desde, Date hasta) throws PersistenciaException {
        if (desde == null || hasta == null) {
            throw new PersistenciaException("Las fechas para la consulta no pueden ser nulas");
        }

        List<UsuarioDTO> usuarios = new ArrayList<>();
        try {
            usuariosCollection.find(and(gte("fechaContratacion", desde), lte("fechaContratacion", hasta)))
                    .forEach((Consumer<Document>) doc -> {
                        UsuarioDTO usuario = documentToUsuarioDTO(doc);
                        usuarios.add(usuario);
                    });

            if (usuarios.isEmpty()) {
                throw new PersistenciaException("No se encontraron usuarios");
            }

            return usuarios;
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar el usuario por rango de fechas", e);
        }
    }

    /**
     * Consulta todos los usuarios.
     * 
     * @return Lista de todos los usuarios.
     * @throws PersistenciaException
     */
    @Override
    public List<UsuarioDTO> consultarTodos() throws PersistenciaException {
        List<UsuarioDTO> usuarios = new ArrayList<>();
        try {
            usuariosCollection.find().forEach((Consumer<Document>) doc -> {
                UsuarioDTO usuario = documentToUsuarioDTO(doc);
                usuarios.add(usuario);
            });

            if (usuarios.isEmpty()) {
                throw new PersistenciaException("No se encontraron usuarios");
            }

            return usuarios;
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar los usuarios", e);
        }
    }

    /**
     * Inicia sesión para un usuario dado el número de teléfono y la contraseña.
     * 
     * @param telefono   Número de teléfono del usuario
     * @param contrasena Contraseña del usuario
     * @return true si la sesión se inició correctamente, false en caso contrario
     * @throws PersistenciaException Si ocurre un error durante la persistencia de
     *                               datos
     */
    @Override
    public boolean iniciarSesion(String telefono, String contrasena) throws PersistenciaException {
        try {
            // Buscar usuario por número de teléfono
            Document query = new Document("telefono", telefono);
            FindIterable<Document> iterable = usuariosCollection.find(query);

            for (Document doc : iterable) {
                UsuarioDTO usuario = documentToUsuarioDTO(doc);
                if (usuario == null) {
                    throw new PersistenciaException("No se encontró un usuario con el número de teléfono dado");
                }
                // Verificar si la contraseña coincide
                if (usuario.getContrasena().equals(contrasena)) {
                    // Inicio de sesión exitoso
                    usuarioLogueado = usuario;
                    setUsuarioLogueado(usuarioLogueado);
                    return true;
                }
            }

            // No se encontró un usuario con el número de teléfono dado o la contraseña no
            // coincide
            return false;
        } catch (Exception e) {
            throw new PersistenciaException("Error al iniciar sesión", e);
        }
    }

    public static void setUsuarioLogueado(UsuarioDTO usuario) {
        usuarioLogueado = usuario;
    }
    public static UsuarioDTO getUsuarioLogueado() {
        return usuarioLogueado;
    }

    /**
     * Convierte un objeto UsuarioDTO a un documento de MongoDB.
     * 
     * @param usuario UsuarioDTO a convertir
     * @return Document
     */
    public Document usuarioDTOToDocument(UsuarioDTO usuario) {
        Document direccionDoc = new Document()
                .append("ciudad", usuario.getDireccion().getCiudad())
                .append("numeroEdificio", usuario.getDireccion().getNumeroEdificio())
                .append("calle", usuario.getDireccion().getCalle())
                .append("colonia", usuario.getDireccion().getColonia())
                .append("codigoPostal", usuario.getDireccion().getCodigoPostal());

        return new Document()
                .append("nombre", usuario.getNombre())
                .append("apellido", usuario.getApellido())
                .append("fechaContratacion", usuario.getFechaContratacion())
                .append("puesto", usuario.getPuesto().name())
                .append("telefono", usuario.getTelefono())
                .append("contrasena", usuario.getContrasena())
                .append("direccion", direccionDoc);
    }

    /**
     * Convierte un documento de MongoDB a un objeto UsuarioDTO.
     * 
     * @param doc Documento de MongoDB
     * @return UsuarioDTO
     */
    public UsuarioDTO documentToUsuarioDTO(Document doc) {
        String nombre = doc.getString("nombre");
        String apellido = doc.getString("apellido");
        Date fechaContratacion = doc.getDate("fechaContratacion");
        UsuarioDTO.Puesto puesto = UsuarioDTO.Puesto.valueOf(doc.getString("puesto"));
        String telefono = doc.getString("telefono");
        String contrasena = doc.getString("contrasena");

        Document direccionDoc = (Document) doc.get("direccion");
        String ciudad = direccionDoc.getString("ciudad");
        String numeroEdificio = direccionDoc.getString("numeroEdificio");
        String calle = direccionDoc.getString("calle");
        String colonia = direccionDoc.getString("colonia");
        String codigoPostal = direccionDoc.getString("codigoPostal");

        DireccionDTO direccion = new DireccionDTO(ciudad, numeroEdificio, calle, colonia, codigoPostal);

        return new UsuarioDTO(nombre, apellido, fechaContratacion, puesto, telefono, contrasena, direccion);
    }

    /**
     * Convierte un documento de MongoDB a un objeto Usuario.
     * 
     * @param doc Documento de MongoDB
     * @return Usuario
     */
    public Usuario documentToUsuario(Document doc) {
        String nombre = doc.getString("nombre");
        String apellido = doc.getString("apellido");
        Date fechaContratacion = doc.getDate("fechaContratacion");
        Usuario.Puesto puesto = Usuario.Puesto.valueOf(doc.getString("puesto"));
        String telefono = doc.getString("telefono");
        String contrasena = doc.getString("contrasena");

        Document direccionDoc = (Document) doc.get("direccion");
        String ciudad = direccionDoc.getString("ciudad");
        String numeroEdificio = direccionDoc.getString("numeroEdificio");
        String calle = direccionDoc.getString("calle");
        String colonia = direccionDoc.getString("colonia");
        String codigoPostal = direccionDoc.getString("codigoPostal");

        Direccion direccion = new Direccion(ciudad, numeroEdificio, calle, colonia, codigoPostal);

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setFechaContratacion(fechaContratacion);
        usuario.setPuesto(puesto);
        usuario.setTelefono(telefono);
        usuario.setContrasena(contrasena);
        usuario.setDireccion(direccion);

        return usuario;
    }

    /**
     * Convierte un objeto Usuario a un documento de MongoDB.
     * 
     * @param usuario Usuario a convertir
     * @return Document
     */
    private Document usuarioToDocument(Usuario usuario) {
        Document direccionDoc = new Document()
                .append("ciudad", usuario.getDireccion().getCiudad())
                .append("numeroEdificio", usuario.getDireccion().getNumeroEdificio())
                .append("calle", usuario.getDireccion().getCalle())
                .append("colonia", usuario.getDireccion().getColonia())
                .append("codigoPostal", usuario.getDireccion().getCodigoPostal());

        return new Document()
                .append("nombre", usuario.getNombre())
                .append("apellido", usuario.getApellido())
                .append("fechaContratacion", usuario.getFechaContratacion())
                .append("puesto", usuario.getPuesto().name())
                .append("telefono", usuario.getTelefono())
                .append("contrasena", usuario.getContrasena())
                .append("direccion", direccionDoc);
    }

}
