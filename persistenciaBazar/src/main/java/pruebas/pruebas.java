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
import dtos.VentaDTO;
import dtos.VentaDTO.MetodoPago;
import excepciones.PersistenciaException;
import gestores.GestorProductos;
import gestores.GestorUsuarios;
import gestores.GestorVentas;
import pojos.Usuario;

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
        p.pruebasVentas(gv, gp, gu);

    }

    public void pruebasVentas(GestorVentas gv, GestorProductos gp, GestorUsuarios gu) throws PersistenciaException, ParseException {
        ProductoDTO p = new ProductoDTO();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha = sdf.parse("2023-01-01");
        Date fecha2 = sdf.parse("2023-04-04");
        Date fecha3 = sdf.parse("2023-05-05");
        Date fechaContratacion = sdf.parse("2024-01-01");
        p.setCodigoBarras(1234567890L);
        p.setCodigoInterno("PDV001");
        p.setNombre("ProductoVentas 1");
        p.setPrecio(100.20F);
        p.setFechaRegistro(fecha);

        ProductoDTO a = new ProductoDTO();
        a.setCodigoBarras(777777777L);
        a.setCodigoInterno("PDV001");
        a.setNombre("ProductoVentas 2");
        a.setPrecio(200.20F);
        a.setFechaRegistro(fecha2);

        ProductoDTO b = new ProductoDTO();
        b.setCodigoBarras(4444444444L);
        b.setCodigoInterno("PDV001");
        b.setNombre("ProductoVentas 3");
        b.setPrecio(17.40F);
        b.setFechaRegistro(fecha3);

        VentaDTO venta = new VentaDTO();
        venta.setNombreCliente("Jose");
        venta.setApellidoCliente("Perez");
        List<ProductoDTO> productos = List.of(p, a, b);
        venta.setProductosVendidos(productos);
        venta.setMetodoPago(MetodoPago.EFECTIVO);
        // el monto total es calculado a partir de la suma de el precio de los productos
        // vendidos.
        float montoTotal = 0;
        for (ProductoDTO productoDTO : productos) {
            montoTotal += productoDTO.getPrecio();
        }
        venta.setMontoTotal(montoTotal);
        Date fechaVenta= sdf.parse("2024-05-14");
        venta.setFechaVenta(fechaVenta);
        UsuarioDTO u = new UsuarioDTO();
        u.setNombre("Jose");
        u.setApellido("Perez");
        u.setFechaContratacion(fechaContratacion);
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
        venta.setUsuario(u);
        gu.setUsuarioLogueado(u);
        boolean insertado = gv.insertar(venta);
        System.out.println("Venta insertada: " + insertado);
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
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date u1 = sdf.parse("2023-01-01");
        Date us = sdf.parse("2023-12-31");
        // Usuario 1
        UsuarioDTO u = new UsuarioDTO();
        u.setNombre("Jose");
        u.setApellido("Perez");
        u.setFechaContratacion(u1);
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
        u2.setFechaContratacion(us);
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
        Date desde = sdf.parse("2023-01-01");
        Date hasta = sdf.parse("2023-12-31");

        // Insertar un usuario
        UsuarioDTO u3 = new UsuarioDTO();
        u3.setNombre("Pedro");
        u3.setApellido("Perez");
        u3.setFechaContratacion(u1);
        u3.setPuesto(Puesto.CAJERO);
        u3.setTelefono("1234567890");
        DireccionDTO d3 = new DireccionDTO();
        d3.setCiudad("CDMX");
        d3.setNumeroEdificio("123");
        d3.setCalle("Calle");
        d3.setColonia("Colonia");
        d3.setCodigoPostal("12345");
        u3.setDireccion(d3);

        UsuarioDTO u4 = new UsuarioDTO();
        u4.setNombre("Pedro");
        u4.setApellido("Aguilar");
        u4.setFechaContratacion(u1);
        u4.setPuesto(Puesto.CAJERO);
        u4.setTelefono("1234567890");
        DireccionDTO d4 = new DireccionDTO();
        d4.setCiudad("CDMX");
        d4.setNumeroEdificio("123");
        d4.setCalle("Calle");
        d4.setColonia("Colonia");
        d4.setCodigoPostal("12345");
        u4.setDireccion(d4);

        try {
            gu.insertar(u3);
            gu.insertar(u4);
            List<UsuarioDTO> lista = gu.consultarTodos();
            for (UsuarioDTO usuarioDTO : lista) {
                System.out.println(usuarioDTO.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
