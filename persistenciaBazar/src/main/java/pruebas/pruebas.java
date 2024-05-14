/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dtos.DireccionDTO;
import dtos.ProductoDTO;
import dtos.UsuarioDTO;
import dtos.UsuarioDTO.Puesto;
import excepciones.PersistenciaException;
import gestores.GestorProductos;
import gestores.GestorUsuarios;
import gestores.GestorVentas;

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
        pruebas p = new pruebas();
        GestorUsuarios gu = new GestorUsuarios();
        GestorVentas gv = new GestorVentas();
        p.pruebasUsuarios(gu);

    }

    public void pruebasProductos(GestorProductos gp) throws PersistenciaException, ParseException {

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

    public void pruebasUsuarios(GestorUsuarios gu) throws PersistenciaException, ParseException {
        // Usuario 1
        UsuarioDTO u = new UsuarioDTO();
        u.setNombre("Jose");
        u.setApellido("Perez");
        u.setFechaContratacion(new Date());
        u.setPuesto(Puesto.GERENTE);
        u.setTelefono("1234567890");
        u.setContrasena("123456");
        DireccionDTO d = new DireccionDTO();
        d.setCiudad("CDMX");
        d.setNumeroEdificio("123");
        d.setCalle("Calle");
        d.setColonia("Colonia");
        d.setCodigoPostal("12345");
        u.setDireccion(d);

        // Usuario 2

        UsuarioDTO u2 = new UsuarioDTO();
        u2.setNombre("Juan");
        u2.setApellido("Perez");
        u2.setFechaContratacion(new Date());
        u2.setPuesto(Puesto.CAJERO);
        u2.setTelefono("6442216360");
        u2.setContrasena("121121");
        DireccionDTO d2 = new DireccionDTO();
        d2.setCiudad("Obregon");
        d2.setNumeroEdificio("854");
        d2.setCalle("Sonora");
        d2.setColonia("Centro");
        d2.setCodigoPostal("66666");
        u2.setDireccion(d2);
        try {
            boolean a = gu.insertar(u2);
            System.out.println("Insertar: " + a);
            gu.eliminar(u);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
