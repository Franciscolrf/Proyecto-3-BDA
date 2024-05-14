package dao;

import colecciones.Producto;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import conexion.ConexionBD;
import dtos.ProductoDTO;
import excepciones.PersistenciaException;
import interfaces.IGestorProductos;
import java.util.List;
import org.bson.Document;
import dao.ConvertidorBazarDTO;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author rramirez
 */
public class GestorProductos implements IGestorProductos {

    private final ConvertidorBazarDTO convertidor = new ConvertidorBazarDTO();
    private final MongoDatabase database;
    private final MongoCollection<Document> productosCollection;

    public GestorProductos() throws PersistenciaException {
        // Obtener la base de datos MongoDB
        this.database = ConexionBD.getDatabase();
        // Obtener la colección de productos
        this.productosCollection = database.getCollection("productos");
    }

    @Override
    public List<ProductoDTO> consultarTodos() throws PersistenciaException {
        try
        {
            List<ProductoDTO> productosDTO = new ArrayList<>();

            // Obtener todos los documentos de la colección de productos
            MongoCursor<Document> cursor = productosCollection.find().iterator();

            // Recorrer los documentos y convertirlos a ProductoDTO
            while (cursor.hasNext())
            {
                Document productoDoc = cursor.next();
                ProductoDTO productoDTO = new ProductoDTO(
                        productoDoc.getLong("codigoBarras"),
                        productoDoc.getString("codigoInterno"),
                        productoDoc.getString("nombre"),
                        productoDoc.getDouble("precio"),
                        productoDoc.get("fechaRegistro", LocalDateTime.class));

                productosDTO.add(productoDTO);
            }

            return productosDTO;
        } catch (Exception ex)
        {
            throw new PersistenciaException("Error al consultar todos los productos: " + ex.getMessage());
        }
    }

    @Override
    public List<ProductoDTO> consultarProductosPorNombre(String nombreProducto) throws PersistenciaException {
        try
        {
            List<ProductoDTO> productosDTO = new ArrayList<>();

            // Realizar la consulta a la base de datos por nombre
            FindIterable<Document> productosDocs = productosCollection.find(eq("nombre", nombreProducto));
            MongoCursor<Document> cursor = productosDocs.iterator();

            // Recorrer los documentos obtenidos y convertirlos a ProductoDTO
            while (cursor.hasNext())
            {
                Document productoDoc = cursor.next();
                ProductoDTO productoDTO = convertidor.convertirDocumentoAProductoDTO(productoDoc);
                productosDTO.add(productoDTO);
            }

            return productosDTO;
        } catch (Exception ex)
        {
            throw new PersistenciaException("Error al consultar productos por nombre: " + ex.getMessage());
        }
    }

    @Override
    public void registrarProducto(ProductoDTO productoDTO) throws PersistenciaException {
        Producto producto = convertidor.convertirProductoDTOAProducto(productoDTO);

        Document productoDoc = convertidor.convertirProductoADocumento(producto);

        productosCollection.insertOne(productoDoc);
    }

    @Override
    public ProductoDTO consultarProducto(String codigoProducto) throws PersistenciaException {
        try
        {
            // Realizar la consulta a la base de datos por código de barras
            Document productoDoc = productosCollection.find(eq("codigoBarras", codigoProducto)).first();

            // Verificar si se encontró el producto
            if (productoDoc != null)
            {
                // Convertir el documento a ProductoDTO
                return convertidor.convertirDocumentoAProductoDTO(productoDoc);
            } else
            {
                // Si no se encuentra el producto, retornar null o lanzar una excepción según la necesidad del sistema
                return null;
                // throw new PersistenciaException("No se encontró el producto con el código: " + codigoProducto);
            }
        } catch (Exception ex)
        {
            throw new PersistenciaException("Error al consultar producto por código de barras: " + ex.getMessage());
        }
    }

    @Override
    public ProductoDTO consultarProducto(Long productoId) throws PersistenciaException {
        try
        {
            // Realizar la consulta a la base de datos por el ID del producto
            Document productoDoc = productosCollection.find(eq("_id", productoId)).first();

            // Verificar si se encontró el producto
            if (productoDoc != null)
            {
                // Convertir el documento a ProductoDTO
                return convertidor.convertirDocumentoAProductoDTO(productoDoc);
            } else
            {
                // Si no se encuentra el producto, retornar null o lanzar una excepción según el requerimiento del sistema
                return null;
            }
        } catch (Exception ex)
        {
            throw new PersistenciaException("Error al consultar producto por ID: " + ex.getMessage());
        }
    }

    @Override
    public void actualizarProducto(ProductoDTO productoDTO) throws PersistenciaException {
        if (productoDTO == null)
        {
            throw new PersistenciaException("El producto es null");
        }
        Producto producto = convertidor.convertirProductoDTOAProducto(productoDTO);

        Document filtro = new Document("codigoBarras", producto.getCodigoBarras());
        Document productoDoc = convertidor.convertirProductoADocumento(producto);

        productosCollection.replaceOne(filtro, productoDoc);
    }

    @Override
    public void eliminarProducto(String codigoProducto) throws PersistenciaException {
        Document filtro = new Document("codigoBarras", codigoProducto);

        productosCollection.deleteOne(filtro);
    }

}
