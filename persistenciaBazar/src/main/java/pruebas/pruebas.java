/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dtos.ProductoDTO;
import excepciones.PersistenciaException;
import gestores.GestorProductos;

/**
 *
 * @author ID145
 */
public class pruebas {

    /**
     * @param args the command line arguments
     * @throws PersistenciaException
     * @throws ParseException
     */
    public static void main(String[] args) throws PersistenciaException, ParseException {
        GestorProductos gp = new GestorProductos();
        ProductoDTO p = new ProductoDTO();
        Date fecha = new Date();
        p.setCodigoBarras(1234567890L);
        p.setCodigoInterno("SAB001");
        p.setNombre("Producto de prueba");
        p.setPrecio(100.20F);
        p.setFechaRegistro(fecha);

        ProductoDTO a = new ProductoDTO();
        a.setCodigoBarras(777777777L);
        a.setCodigoInterno("SAB002");
        a.setNombre("Producto de prueba 2");
        a.setPrecio(200.20F);
        a.setFechaRegistro(new Date());
        // gp.insertar(a);

        ProductoDTO b = new ProductoDTO();
        b.setCodigoBarras(4444444444L);
        b.setCodigoInterno("SAB005");
        b.setNombre("Producto de prueba 5");
        b.setPrecio(17.40F);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha2 = sdf.parse("2023-04-04");
        b.setFechaRegistro(fecha2);
        gp.insertar(b);

        try {
            Date desde = sdf.parse("2023-01-01");
            Date hasta = sdf.parse("2023-12-31");
            List<ProductoDTO> lista = gp.consultarPorRangoFechas(desde, hasta);

            for (ProductoDTO productoDTO : lista) {
                System.out.println(productoDTO.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
