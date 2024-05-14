package bda.itson.persistenciabazar;

import dao.GestorProductos;
import dtos.ProductoDTO;
import excepciones.PersistenciaException;
import java.time.LocalDateTime;

/**
 *
 * @author ID145
 */
public class PersistenciaBazar {

    public static void main(String[] args) {
        try
        {
            // Crear instancia de GestorProductos
            GestorProductos gestorProductos = new GestorProductos();

            // Crear un ProductoDTO de ejemplo
            ProductoDTO productoDTO = new ProductoDTO();
            productoDTO.setCodigoBarras(123456L);
            productoDTO.setCodigoInterno("INT123");
            productoDTO.setNombre("Producto de prueba");
            productoDTO.setPrecio(Double.MAX_VALUE);
            productoDTO.setFechaRegistro(LocalDateTime.now());

            // Registrar el producto utilizando el gestor
            gestorProductos.registrarProducto(productoDTO);

            // Mostrar mensaje de éxito
            System.out.println("Producto registrado correctamente.");

        } catch (PersistenciaException e)
        {
            // Manejar la excepción en caso de error de persistencia
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}
