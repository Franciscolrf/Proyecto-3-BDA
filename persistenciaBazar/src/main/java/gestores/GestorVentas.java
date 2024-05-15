package gestores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

import conexion.ConexionBD;
import dtos.DireccionDTO;
import dtos.ProductoDTO;
import dtos.UsuarioDTO;
import dtos.VentaDTO;
import dtos.VentaDTO.MetodoPago;
import excepciones.PersistenciaException;
import interfaces.IGestorVentas;
import pojos.Venta;

import static com.mongodb.client.model.Filters.*;

/**
 * Clase que se encarga de gestionar las ventas en la base de datos.
 * Implementa la interfaz IGestorVentas.
 * 
 * @author Fran
 */
public class GestorVentas implements IGestorVentas {
    // Atributos
    private MongoCollection<Document> ventasCollection;
    private GestorProductos gestorProductos = new GestorProductos();
    private GestorUsuarios gestorUsuarios = new GestorUsuarios();

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

    /**
     * Inserta una venta en la base de datos.
     * 
     * @param venta
     * @return true si la venta se insertó correctamente, false en caso contrario.
     * @throws PersistenciaException
     */
    @Override
    public boolean insertar(VentaDTO venta) throws PersistenciaException {
        if (venta == null) {
            throw new PersistenciaException("La venta no puede ser nula");
        }

        try {
            Document doc = ventaDTOToDocument(venta);
            ventasCollection.insertOne(doc);
            return true;
        } catch (Exception e) {
            throw new PersistenciaException("Error al insertar la venta", e);
        }
    }

    /**
     * Elimina una venta de la base de datos.
     * 
     * @param venta
     * @return true si la venta se eliminó correctamente, false en caso contrario.
     * @throws PersistenciaException
     */
    @Override
    public boolean eliminar(String codigoInterno) throws PersistenciaException {
        try {
            // Crear el filtro para encontrar la venta por su codigoInterno
            Document query = new Document("codigoInterno", codigoInterno);

            // Buscar la venta en la base de datos
            Document ventaDoc = ventasCollection.find(query).first();

            // Verificar si se encontró la venta
            if (ventaDoc != null) {
                // Eliminar la venta encontrada
                ventasCollection.deleteOne(query);
                return true; // La venta fue eliminada con éxito
            } else {
                // La venta no fue encontrada
                throw new PersistenciaException("No se encontró ninguna venta con el código interno: " + codigoInterno);
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al eliminar la venta con código interno: " + codigoInterno, e);
        }
    }

    /**
     * Modifica una venta en la base de datos.
     * 
     * @param venta
     * @return true si la venta se modificó correctamente, false en caso contrario.
     * @throws PersistenciaException
     */
    @Override
    public boolean modificar(VentaDTO venta) throws PersistenciaException {
        try {
            // Crear el filtro para encontrar la venta por su codigoInterno
            Document query = new Document("codigoInterno", venta.getCodigoInterno());

            // Crear el documento con los datos actualizados de la venta
            Document ventaActualizado = ventaDTOToDocument(venta);

            // Realizar la actualización en la base de datos
            UpdateResult result = ventasCollection.replaceOne(query, ventaActualizado);

            // Verificar si la venta fue encontrada y actualizada correctamente
            if (result.getModifiedCount() > 0) {
                return true; // La venta fue modificada con éxito
            } else {
                // La venta no fue encontrada
                throw new PersistenciaException(
                        "No se encontró ninguna venta con el código interno: " + venta.getCodigoInterno());
            }
        } catch (Exception e) {
            throw new PersistenciaException(
                    "Error al modificar la venta con código interno: " + venta.getCodigoInterno(), e);
        }
    }

    /**
     * Consulta ventas por nombre de cliente.
     * 
     * @param nombreCliente
     * @return lista de ventas con el nombre del cliente especificado.
     * @throws PersistenciaException
     */
    @Override
    public List<VentaDTO> consultarPorNombreCliente(String nombreCliente) throws PersistenciaException {
        if (nombreCliente == null) {
            throw new PersistenciaException("El nombre del cliente no puede ser nulo");
        }

        List<VentaDTO> ventas = new ArrayList<>();
        try {
            // Crear el filtro para buscar las ventas por nombre del cliente
            Document query = new Document("nombreCliente",
                    new Document("$regex", ".*" + nombreCliente + ".*").append("$options", "i"));

            // Buscar las ventas en la base de datos
            FindIterable<Document> ventasDocs = ventasCollection.find(query);

            // Convertir cada documento encontrado a un objeto VentaDTO
            for (Document doc : ventasDocs) {
                VentaDTO venta = documentToVentaDTO(doc);
                ventas.add(venta);
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar las ventas por nombre de cliente: " + nombreCliente, e);
        }
        return ventas;
    }

    /**
     * Consulta ventas por apellido de cliente.
     * 
     * @param codigoInterno
     * @return lista de ventas con el apellido del cliente especificado.
     * @throws PersistenciaException
     */
    @Override
    public VentaDTO consultarPorCodigoInterno(String codigoInterno) throws PersistenciaException {
        if (codigoInterno == null) {
            throw new PersistenciaException("El codigo interno no puede ser nulo");

        }

        try {
            // Crear el filtro para buscar la venta por su codigoInterno
            Document query = new Document("codigoInterno", codigoInterno);

            // Buscar la venta en la base de datos
            Document ventaDoc = ventasCollection.find(query).first();

            // Verificar si se encontró la venta
            if (ventaDoc != null) {
                // Convertir el documento encontrado a un objeto VentaDTO
                return documentToVentaDTO(ventaDoc);
            } else {
                // La venta no fue encontrada
                throw new PersistenciaException("No se encontró ninguna venta con el código interno: " + codigoInterno);
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar la venta con código interno: " + codigoInterno, e);
        }
    }

    /**
     * Consulta ventas por rango de fechas.
     * 
     * @param desde
     * @param hasta
     * @return lista de ventas realizadas en el rango de fechas especificado.
     * @throws PersistenciaException
     */
    @Override
    public List<VentaDTO> consultarPorRangoFechas(Date desde, Date hasta) throws PersistenciaException {
        if (desde == null || hasta == null) {
            throw new PersistenciaException("Las fechas no pueden ser nulas");

        }

        List<VentaDTO> ventas = new ArrayList<>();
        try {
            // Crear el filtro para buscar las ventas por rango de fechas
            Bson query = and(gte("fechaVenta", desde), lte("fechaVenta", hasta));

            // Buscar las ventas en la base de datos
            FindIterable<Document> ventasDocs = ventasCollection.find(query);

            // Convertir cada documento encontrado a un objeto VentaDTO
            for (Document doc : ventasDocs) {
                VentaDTO venta = documentToVentaDTO(doc);
                ventas.add(venta);
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar las ventas por rango de fechas", e);
        }
        return ventas;
    }

    /**
     * Consulta todas las ventas.
     * 
     * @return lista de todas las ventas.
     * @throws PersistenciaException
     */
    @Override
    public List<VentaDTO> consultarTodos() throws PersistenciaException {
        List<VentaDTO> ventas = new ArrayList<>();
        try {
            // Buscar todas las ventas en la base de datos
            FindIterable<Document> ventasDocs = ventasCollection.find();

            // Convertir cada documento encontrado a un objeto VentaDTO
            for (Document doc : ventasDocs) {
                VentaDTO venta = documentToVentaDTO(doc);
                ventas.add(venta);
            }
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar todas las ventas", e);
        }
        return ventas;
    }

    /**
     * Convierte un documento de venta a un objeto VentaDTO.
     * 
     * @param doc
     * @return objeto VentaDTO con la información del documento.
     * @throws PersistenciaException
     */
    @Override
    public VentaDTO documentToVentaDTO(Document doc) throws PersistenciaException {
        GestorProductos gestorProductos = new GestorProductos();

        // Extracción del documento anidado 'usuario'
        Document usuarioDoc = (Document) doc.get("usuario");

        UsuarioDTO usuario = null;
        if (usuarioDoc != null) {
            Document direccionDoc = (Document) usuarioDoc.get("direccion");
            DireccionDTO direccion = null;
            if (direccionDoc != null) {
                direccion = new DireccionDTO(
                        direccionDoc.getString("ciudad"),
                        direccionDoc.getString("numeroEdificio"),
                        direccionDoc.getString("calle"),
                        direccionDoc.getString("colonia"),
                        direccionDoc.getString("codigoPostal"));
            }

            usuario = new UsuarioDTO(
                    usuarioDoc.getString("nombre"),
                    usuarioDoc.getString("apellido"),
                    usuarioDoc.getDate("fechaContratacion") != null
                            ? new Date(usuarioDoc.getDate("fechaContratacion").getTime())
                            : null,
                    UsuarioDTO.Puesto.valueOf(usuarioDoc.getString("puesto")),
                    usuarioDoc.getString("telefono"),
                    usuarioDoc.getString("contrasena"),
                    direccion);
        }

        // Conversión de la lista de documentos de productos a lista de ProductoDTO
        List<Document> productosVendidosDocs = (List<Document>) doc.get("productosVendidos");
        List<ProductoDTO> productosVendidos = new ArrayList<>();
        for (Document productoDoc : productosVendidosDocs) {
            productosVendidos.add(gestorProductos.documentToProductoDTO(productoDoc));
        }

        VentaDTO venta = new VentaDTO();
        venta.setNombreCliente(doc.getString("nombreCliente"));
        venta.setApellidoCliente(doc.getString("apellidoCliente"));
        venta.setMontoTotal(doc.getDouble("montoTotal").floatValue());
        venta.setMetodoPago(MetodoPago.valueOf(doc.getString("metodoPago")));
        venta.setFechaVenta(new Date(doc.getDate("fechaVenta").getTime()));
        venta.setUsuario(usuario);
        venta.setCodigoInterno(doc.getString("codigoInterno"));
        venta.setProductosVendidos(productosVendidos);

        return venta;
    }

    /**
     * Convierte un objeto VentaDTO a un documento.
     * 
     * @param venta
     * @return documento con la información de la venta.
     * @throws PersistenciaException
     */
    @Override
    public Document ventaDTOToDocument(VentaDTO venta) throws PersistenciaException {
        UsuarioDTO usuario = GestorUsuarios.getUsuarioLogueado();
        GestorUsuarios gu = new GestorUsuarios();

        if (usuario == null) {
            throw new IllegalStateException("No hay usuario logueado.");
        }

        // Convertir UsuarioDTO a Document usando el método de GestorUsuarios
        Document usuarioDoc = gu.usuarioDTOToDocument(usuario);

        // Convertir la lista de productos vendidos a una lista de documentos
        List<Document> productosVendidosDocs = new ArrayList<>();
        for (ProductoDTO producto : venta.getProductosVendidos()) {
            productosVendidosDocs.add(gestorProductos.productoDTOToDocument(producto));
        }

        // Crear y devolver el documento de la venta
        return new Document("nombreCliente", venta.getNombreCliente())
                .append("apellidoCliente", venta.getApellidoCliente())
                .append("montoTotal", venta.getMontoTotal())
                .append("fechaVenta", venta.getFechaVenta())
                .append("usuario", usuarioDoc)
                .append("codigoInterno", venta.getCodigoInterno())
                .append("metodoPago", venta.getMetodoPago().name())
                .append("productosVendidos", productosVendidosDocs);
    }

}
