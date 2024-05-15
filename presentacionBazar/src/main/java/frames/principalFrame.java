/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import dtos.ProductoDTO;
import java.util.List;
import gestores.GestorProductos;
import excepciones.PersistenciaException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ID145
 */
public class principalFrame extends javax.swing.JFrame {

    GestorProductos gestorProductos = new GestorProductos();

    /**
     * Creates new form principalFrame
     */
    public principalFrame() {

        initComponents();
        try {

            List<ProductoDTO> productos = gestorProductos.consultarTodos();
            ProductosTableModel tableModel = new ProductosTableModel(productos);
            tablaProductos.setModel(tableModel);
        } catch (PersistenciaException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar los productos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     *
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botonFiltrarFechas = new javax.swing.JButton();
        fieldFechaDesde = new javax.swing.JTextField();
        fieldFechaHasta = new javax.swing.JTextField();
        botonFIltrarNombre = new javax.swing.JButton();
        fieldNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        botonCerrarSesion = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        botonRestablecer = new javax.swing.JButton();
        botonSalir2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuProductos = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuVentas = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuUsuarios = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        menuAcercaDe = new javax.swing.JMenu();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Bazar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(451, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(377, 377, 377))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 6, 920, 60);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Desde:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Hasta:");

        botonFiltrarFechas.setText("Filtrar por Fechas");
        botonFiltrarFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFiltrarFechasActionPerformed(evt);
            }
        });

        botonFIltrarNombre.setText("Buscar por Nombre");
        botonFIltrarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFIltrarNombreActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nombre:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fieldFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonFiltrarFechas))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonFIltrarNombre))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fieldFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(fieldFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonFiltrarFechas)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonFIltrarNombre)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(700, 70, 210, 360);

        botonCerrarSesion.setText("Cerrar Sesión");
        botonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarSesionActionPerformed(evt);
            }
        });
        getContentPane().add(botonCerrarSesion);
        botonCerrarSesion.setBounds(92, 380, 100, 23);

        jScrollPane2.setViewportView(tablaProductos);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 70, 680, 240);

        botonRestablecer.setText("Restablecer");
        botonRestablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRestablecerActionPerformed(evt);
            }
        });
        getContentPane().add(botonRestablecer);
        botonRestablecer.setBounds(540, 380, 100, 23);

        botonSalir2.setText("Salir");
        botonSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalir2ActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir2);
        botonSalir2.setBounds(360, 380, 72, 23);

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        menuProductos.setText("Productos");

        jMenuItem1.setText("Agregar Producto");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuProductos.add(jMenuItem1);

        jMenuItem2.setText("Ver Productos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuProductos.add(jMenuItem2);

        jMenuBar1.add(menuProductos);

        menuVentas.setText("Ventas");

        jMenuItem3.setText("Agregar Venta");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuVentas.add(jMenuItem3);

        jMenuItem4.setText("Ver Ventas");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuVentas.add(jMenuItem4);

        jMenuBar1.add(menuVentas);

        menuUsuarios.setText("Usuarios");

        jMenuItem5.setText("Agregar Usuario");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuUsuarios.add(jMenuItem5);

        jMenuItem6.setText("Ver Usuarios");
        menuUsuarios.add(jMenuItem6);

        jMenuBar1.add(menuUsuarios);

        menuAcercaDe.setText("Acerca de...");

        jMenuItem9.setText("Información");
        menuAcercaDe.add(jMenuItem9);

        jMenuBar1.add(menuAcercaDe);

        setJMenuBar(jMenuBar1);

        setBounds(0, 0, 939, 540);
    }// </editor-fold>//GEN-END:initComponents

    private void botonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarSesionActionPerformed
        
        dispose();
        logFrame lf = new logFrame();
        lf.setVisible(true);
    }//GEN-LAST:event_botonCerrarSesionActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        agregarProductoFrame ag = new agregarProductoFrame();
        ag.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        productosFrame pf = new productosFrame();
        pf.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private boolean validarFormatoFecha(String fecha) {
        // Expresión regular para validar el formato yyyy-MM-dd
        String regex = "^\\d{4}-\\d{2}-\\d{2}$";
        return fecha.matches(regex);
    }

    private boolean validarValoresFecha(String fecha) {
        // Obtener los componentes de la fecha
        String[] componentes = fecha.split("-");
        int anio = Integer.parseInt(componentes[0]);
        int mes = Integer.parseInt(componentes[1]);
        int dia = Integer.parseInt(componentes[2]);

        // Validar que los valores sean válidos
        if (anio < 0 || mes < 1 || mes > 12 || dia < 1 || dia > 31) {
            return false;
        }

        return true;
    }

    private void mostrarProductosEnTabla(List<ProductoDTO> productos) {
        // Limpiar la tabla
        DefaultTableModel model = (DefaultTableModel) tablaProductos.getModel();
        model.setRowCount(0);

        // Llenar la tabla con los productos
        for (ProductoDTO producto : productos) {
            Object[] row = {
                producto.getNombre(),
                producto.getCodigoInterno(),
                producto.getPrecio(),
                producto.getFechaRegistro()
            };
            model.addRow(row);
        }
    }
    private void botonFiltrarFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFiltrarFechasActionPerformed
        GestorProductos gp = new GestorProductos();
        // Obtener las fechas ingresadas
        String fechaDesdeStr = fieldFechaDesde.getText();
        String fechaHastaStr = fieldFechaHasta.getText();

        // Validar el formato y los valores de las fechas
        if (!validarFormatoFecha(fechaDesdeStr) || !validarFormatoFecha(fechaHastaStr)) {
            JOptionPane.showMessageDialog(this, "Ingrese fechas válidas en formato yyyy-MM-dd.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Convertir las fechas a un formato más simple
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fechaInicio = sdf.parse(fechaDesdeStr);
            Date fechaFin = sdf.parse(fechaHastaStr);

            // Llamar al método para obtener los productos filtrados por fechas
            List<ProductoDTO> productosFiltrados = gp.consultarPorRangoFechas(fechaInicio, fechaFin);

            // Mostrar los productos filtrados en la tabla
            mostrarProductosEnTabla(productosFiltrados);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Error al parsear las fechas.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (PersistenciaException ex) {
            Logger.getLogger(principalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_botonFiltrarFechasActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        agregarVentaForm ag = new agregarVentaForm();
        ag.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        ventasFrame vf = null;
        try {
            vf = new ventasFrame();
        } catch (PersistenciaException ex) {
            Logger.getLogger(principalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        vf.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void botonRestablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRestablecerActionPerformed
        List<ProductoDTO> productos = null;
        try {
            productos = gestorProductos.consultarTodos();
        } catch (PersistenciaException ex) {
            Logger.getLogger(productosFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        mostrarProductosEnTabla(productos);
        fieldFechaDesde.setText("");
        fieldFechaHasta.setText("");
        fieldNombre.setText("");
    }//GEN-LAST:event_botonRestablecerActionPerformed

    private void botonFIltrarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFIltrarNombreActionPerformed
        String nombre = fieldNombre.getText();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un nombre para filtrar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            List<ProductoDTO> productosPorNombre = gestorProductos.consultarPorNombre(nombre);

            // Mostrar las ventas filtradas por nombre en la tabla
            mostrarProductosEnTabla(productosPorNombre);
        } catch (PersistenciaException ex) {
            Logger.getLogger(productosFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonFIltrarNombreActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
       agregarUsuarioFrame agf = new agregarUsuarioFrame();
       agf.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void botonSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalir2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonSalir2ActionPerformed

    /**
         * @param args the command line arguments
         */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(principalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principalFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCerrarSesion;
    private javax.swing.JButton botonFIltrarNombre;
    private javax.swing.JButton botonFiltrarFechas;
    private javax.swing.JButton botonRestablecer;
    private javax.swing.JButton botonSalir2;
    private javax.swing.JTextField fieldFechaDesde;
    private javax.swing.JTextField fieldFechaHasta;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu menuAcercaDe;
    private javax.swing.JMenu menuProductos;
    private javax.swing.JMenu menuUsuarios;
    private javax.swing.JMenu menuVentas;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
    public class ProductosTableModel extends javax.swing.table.DefaultTableModel {

        private final String[] columnNames = {"Nombre", "Codigo Interno", "Precio", "Fecha Registro"};
        private final List<ProductoDTO> productos;

        public ProductosTableModel(List<ProductoDTO> productos) {
            this.productos = productos;
            setColumnIdentifiers(columnNames);
            cargarDatos();
        }

        private void cargarDatos() {
            for (ProductoDTO producto : productos) {
                Object[] rowData = {
                    producto.getNombre(),
                    producto.getCodigoInterno(),
                    producto.getPrecio(),
                    producto.getFechaRegistro()
                };
                addRow(rowData);
            }
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            // Para que las celdas no sean editables
            return false;
        }
    }
}
