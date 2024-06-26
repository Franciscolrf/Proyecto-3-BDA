package gestores;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import conexion.ConexionBD;
import dtos.ProductoDTO;
import interfaces.IGestorProductos;
import pojos.Producto;
import excepciones.PersistenciaException;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Updates.*;

/**
 * Clase que se encarga de gestionar los productos en la base de datos MongoDB
 * Implementa la interfaz IGestorProductos
 * 
 * @author Fran
 */
public class GestorProductos implements IGestorProductos {

    // Atributos
    private MongoCollection<Document> productosCollection;

    // Constructores

    /**
     * Constructor por defecto.
     * 
     */
    public GestorProductos() {
        MongoDatabase database = ConexionBD.getDatabase();
        productosCollection = database.getCollection("productos");
    }

    /**
     * Inserta un producto.
     * 
     * @param producto Producto a insertar
     * 
     * @return true si se insertó correctamente, false en caso contrario
     * @throws PersistenciaException por si hay un error al insertar el producto.
     */
    @Override
    public boolean insertar(ProductoDTO producto) throws PersistenciaException {
        try {
            if (producto == null) {
                throw new PersistenciaException("El producto no puede ser nulo");
            }
            Document doc = new Document()
                    .append("codigoBarras", producto.getCodigoBarras())
                    .append("codigoInterno", producto.getCodigoInterno())
                    .append("nombre", producto.getNombre())
                    .append("precio", producto.getPrecio())
                    .append("fechaRegistro", producto.getFechaRegistro());
            productosCollection.insertOne(doc);
            return true;

        } catch (Exception e) {
            throw new PersistenciaException("Error al insertar el producto", e);
        }
    }

    /**
     * Elimina un producto.
     * 
     * @param codigoInterno Código interno del producto a eliminar
     * 
     * @return true si se eliminó correctamente, false en caso contrario
     * @throws PersistenciaException por si hay un error al eliminar el producto.
     */
    @Override
    public boolean eliminar(String codigoInterno) throws PersistenciaException {
        if (codigoInterno == null) {
            throw new PersistenciaException("El código interno no puede ser nulo");
        }
        try {
            productosCollection.deleteOne(eq("codigoInterno", codigoInterno));
            return true;
        } catch (Exception e) {
            throw new PersistenciaException("Error al eliminar el producto", e);

        }
    }

    /**
     * Modifica un producto.
     * 
     * @param producto Producto a modificar
     * 
     * @return true si se modificó correctamente, false en caso contrario
     * @throws PersistenciaException por si hay un error al modificar el producto.
     */
    @Override
    public boolean modificar(ProductoDTO producto) throws PersistenciaException {
        if (producto == null) {
            throw new PersistenciaException("El producto no puede ser nulo");
        }

        try {
            productosCollection.updateOne(eq("codigoBarras", producto.getCodigoBarras()), combine(
                    set("codigoInterno", producto.getCodigoInterno()),
                    set("nombre", producto.getNombre()),
                    set("precio", producto.getPrecio())));
            return true;
        } catch (Exception e) {
            throw new PersistenciaException("Error al modificar el producto", e);
        }
    }

    /**
     * Consulta un producto por código interno.
     * 
     * @param codigoInterno Código interno del producto a buscar
     * @return Producto que coincide con el código interno
     * @throws PersistenciaException por si hay un error en la consulta.
     */
    @Override
    public Producto consultarPorCodigoInterno(String codigoInterno) throws PersistenciaException {
        if (codigoInterno == null || codigoInterno.isEmpty()) {
            throw new PersistenciaException("El código interno no puede ser nulo o vacío");
        }
        try {
            Document doc = productosCollection.find(eq("codigoInterno", codigoInterno)).first();
            if (doc == null) {
                throw new PersistenciaException("No se encontró el producto");
            }
            return documentToProducto(doc);
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar el producto por código interno", e);
        }
    }

    /**
     * Consulta productos por nombre.
     * El nombre puede ser una parte del nombre del producto.
     * 
     * @param nombre Nombre del producto a buscar
     * @return Lista de productos que coinciden con el nombre
     * @throws PersistenciaException por si hay un error en la consulta.
     */
    @Override
    public List<ProductoDTO> consultarPorNombre(String nombre) throws PersistenciaException {
        if (nombre == null || nombre.isEmpty()) {
            throw new PersistenciaException("El nombre no puede ser nulo o vacío");
        }
        List<ProductoDTO> productos = new ArrayList<>();
        try {
            productosCollection.find(regex("nombre", nombre, "i")).forEach((Consumer<? super Document>) doc -> {
                productos.add(documentToProductoDTO(doc));
            });
            if (productos.isEmpty()) {
                throw new PersistenciaException("No se encontraron productos");
            }
            return productos;
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar el producto por nombre", e);
        }
    }

    /**
     * Consulta un producto por nombre.
     * 
     * @param nombre Nombre del producto a buscar
     * @return Producto que coincide con el nombre
     * @throws PersistenciaException por si hay un error en la consulta.
     */
    public Producto consultarPorNombreSingular(String nombre) throws PersistenciaException {
        if (nombre == null || nombre.isEmpty()) {
            throw new PersistenciaException("El nombre no puede ser nulo o vacío");
        }

        try {
            Document doc = productosCollection.find(eq("nombre", nombre)).first();
            if (doc == null) {
                throw new PersistenciaException("No se encontró el producto");
            }
            return documentToProducto(doc);
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar el producto por nombre", e);
        }

    }

    /**
     * Consulta productos por rango de fechas.
     * 
     * @param desde Fecha de inicio del rango
     * @param hasta Fecha de fin del rango
     * @return Lista de productos que se registraron en el rango de fechas
     * @throws PersistenciaException por si hay un error en la consulta.
     */
    @Override
    public List<ProductoDTO> consultarPorRangoFechas(Date desde, Date hasta) throws PersistenciaException {
        List<ProductoDTO> productos = new ArrayList<>();
        if (desde == null || hasta == null) {
            throw new PersistenciaException("Las fechas no pueden ser nulas");
        }
        try {
            productosCollection.find(and(gte("fechaRegistro", desde), lte("fechaRegistro", hasta)))
                    .forEach((Consumer<? super Document>) doc -> {

                        productos.add(documentToProductoDTO(doc));
                    });
            if (productos.isEmpty()) {
                throw new PersistenciaException("No se encontraron productos");
            }
            return productos;
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar el producto por rango de fechas", e);
        }
    }

    /**
     * Consulta todos los productos.
     * 
     * @return Lista de todos los productos
     * @throws PersistenciaException por si hay un error en la consulta.
     */
    @Override
    public List<ProductoDTO> consultarTodos() throws PersistenciaException {
        List<ProductoDTO> productos = new ArrayList<>();
        try {
            productosCollection.find().forEach((Consumer<? super Document>) doc -> {
                productos.add(documentToProductoDTO(doc));

            });
            if (productos.isEmpty()) {
                throw new PersistenciaException("No se encontraron productos");
            }

            return productos;
        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar los productos", e);
        }
    }

    /**
     * Convierte un documento de MongoDB a un objeto ProductoDTO.
     * 
     * @param doc Documento de MongoDB
     * @return ProductoDTO
     */
    public ProductoDTO documentToProductoDTO(Document doc) {
        Long codigoBarras = doc.getLong("codigoBarras");
        String codigoInterno = doc.getString("codigoInterno");
        String nombre = doc.getString("nombre");
        Double precioDouble = doc.getDouble("precio");
        Date fechaRegistro = doc.getDate("fechaRegistro");

        float precio = (precioDouble != null) ? precioDouble.floatValue() : 0.0f;
        Date fechaRegistroDate = (fechaRegistro != null) ? new Date(fechaRegistro.getTime()) : null;

        return new ProductoDTO(codigoBarras, codigoInterno, nombre, precio, fechaRegistroDate);
    }

    public Document productoDTOToDocument(ProductoDTO producto) {
        return new Document()
                .append("codigoBarras", producto.getCodigoBarras())
                .append("codigoInterno", producto.getCodigoInterno())
                .append("nombre", producto.getNombre())
                .append("precio", producto.getPrecio())
                .append("fechaRegistro", producto.getFechaRegistro());
    }

    /**
     * Convierte un documento de MongoDB a un objeto Producto.
     * 
     * @param doc Documento de MongoDB
     * @return Producto
     */
    private Producto documentToProducto(Document doc) {
        ObjectId _id = doc.getObjectId("_id");
        Long codigoBarras = doc.getLong("codigoBarras");
        String codigoInterno = doc.getString("codigoInterno");
        String nombre = doc.getString("nombre");
        Double precioDouble = doc.getDouble("precio");
        Date fechaRegistro = doc.getDate("fechaRegistro");

        float precio = (precioDouble != null) ? precioDouble.floatValue() : 0.0f;
        Date fechaRegistroDate = (fechaRegistro != null) ? new Date(fechaRegistro.getTime()) : null;

        return new Producto(codigoBarras, codigoInterno, nombre, precio, fechaRegistroDate);
    }

    /**
     * Convierte un objeto Producto a productoDTO.
     * 
     * @param producto Producto a convertir
     * @return ProductoDTO
     */
    public ProductoDTO productoToProductoDTO(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setCodigoBarras(producto.getCodigoBarras());
        productoDTO.setCodigoInterno(producto.getCodigoInterno());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setPrecio(producto.getPrecio());
        productoDTO.setFechaRegistro(producto.getFechaRegistro());
        return productoDTO;
    }

}