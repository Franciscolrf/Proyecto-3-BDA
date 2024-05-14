package gestores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import conexion.ConexionBD;
import dtos.DireccionDTO;
import dtos.ProductoDTO;
import dtos.UsuarioDTO;
import dtos.VentaDTO;
import dtos.VentaDTO.MetodoPago;
import excepciones.PersistenciaException;
import interfaces.IGestorVentas;

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

    @Override
    public VentaDTO documentToVentaDTO(Document doc) {
        // Extracción del documento anidado 'usuario'
        Document usuarioDoc = (Document) doc.get("usuario");
    
        // Creación del objeto UsuarioDTO a partir del subdocumento
        UsuarioDTO usuario = new UsuarioDTO(
                usuarioDoc.getString("nombre"),
                usuarioDoc.getString("apellido"),
                new Date(usuarioDoc.getDate("fechaContratacion").getTime()),
                UsuarioDTO.Puesto.valueOf(usuarioDoc.getString("puesto")),
                usuarioDoc.getString("telefono"),
                usuarioDoc.getString("contrasena"),
                new DireccionDTO(
                        usuarioDoc.getString("ciudad"),
                        usuarioDoc.getString("numeroEdificio"),
                        usuarioDoc.getString("calle"),
                        usuarioDoc.getString("colonia"),
                        usuarioDoc.getString("codigoPostal"))
        );
    
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
        venta.setProductosVendidos(productosVendidos);
    
        return venta;
    }
    

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
            .append("metodoPago", venta.getMetodoPago().name())
            .append("productosVendidos", productosVendidosDocs);
}


}
