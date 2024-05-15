/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import dtos.VentaDTO;
import excepciones.PersistenciaException;
import gestores.GestorVentas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ID145
 */
public class ventasFrame extends javax.swing.JFrame {
        GestorVentas gv = new GestorVentas();
    /**
     * Creates new form ventasFrame
     */
    public ventasFrame() throws PersistenciaException {
        initComponents();
        inicializarTablaVentas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVentas = new javax.swing.JTable();
        botonEliminar = new javax.swing.JButton();
        botonModificar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        botonFiltrarFechas = new javax.swing.JButton();
        fieldFechaDesde = new javax.swing.JTextField();
        fieldFechaHasta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        botonFIltrarNombre = new javax.swing.JButton();
        botonRestablece = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Ventas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(363, 363, 363)
                .addComponent(jLabel4)
                .addContainerGap(383, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel4)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 860, 100);

        tablaVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre Cliente", "Codigo Interno", "Método de Pago", "Total", "Fecha de Venta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaVentas);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 140, 604, 329);

        botonEliminar.setText("Eliminar");
        getContentPane().add(botonEliminar);
        botonEliminar.setBounds(530, 490, 90, 23);

        botonModificar.setText("Modificar");
        getContentPane().add(botonModificar);
        botonModificar.setBounds(270, 490, 90, 23);

        botonSalir.setText("Salir");
        getContentPane().add(botonSalir);
        botonSalir.setBounds(150, 490, 70, 23);

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

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre:");

        botonFIltrarNombre.setText("Buscar por Nombre");
        botonFIltrarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFIltrarNombreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonFIltrarNombre))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 32, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonFiltrarFechas)
                    .addComponent(fieldFechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldFechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
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
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonFIltrarNombre)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(630, 140, 210, 340);

        botonRestablece.setText("Restablecer");
        botonRestablece.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRestableceActionPerformed(evt);
            }
        });
        getContentPane().add(botonRestablece);
        botonRestablece.setBounds(390, 490, 110, 23);

        setBounds(0, 0, 866, 647);
    }// </editor-fold>//GEN-END:initComponents

    private void inicializarTablaVentas() throws PersistenciaException {
        GestorVentas gv = new GestorVentas();
        // Suponiendo que tienes un método para obtener la lista de ventas
        List<VentaDTO> listaVentas = gv.consultarTodos();

        // Creamos un DefaultTableModel para manejar los datos de la tabla
        DefaultTableModel model = (DefaultTableModel) tablaVentas.getModel();

        // Limpiamos la tabla por si tenía datos previos
        model.setRowCount(0);

        // Iteramos sobre la lista de ventas y agregamos cada venta a la tabla
        for (VentaDTO venta : listaVentas) {
            Object[] fila = {
                venta.getNombreCliente(),
                venta.getCodigoInterno(),
                venta.getMetodoPago(),
                venta.getMontoTotal(),
                venta.getFechaVenta()
            };
            model.addRow(fila);
        }
    }
    private void botonFiltrarFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFiltrarFechasActionPerformed

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

            // Llamar al método para obtener las ventas filtradas por fechas
            List<VentaDTO> ventasFiltradas = gv.consultarPorRangoFechas(fechaInicio, fechaFin);

            // Mostrar las ventas filtradas en la tabla
            mostrarVentasEnTabla(ventasFiltradas);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Error al parsear las fechas.", "Error", JOptionPane.ERROR_MESSAGE);
        }   catch (PersistenciaException ex) {
                Logger.getLogger(ventasFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_botonFiltrarFechasActionPerformed

    private void mostrarVentasEnTabla(List<VentaDTO> ventas) {
        DefaultTableModel model = (DefaultTableModel) tablaVentas.getModel();
        model.setRowCount(0); // Limpiamos la tabla antes de agregar las nuevas filas

        // Iteramos sobre la lista de ventas y agregamos cada una a la tabla
        for (VentaDTO venta : ventas) {
            Object[] fila = {
                venta.getNombreCliente(),
                venta.getCodigoInterno(),
                venta.getMetodoPago(),
                venta.getMontoTotal(),
                venta.getFechaVenta()
            };
            model.addRow(fila);
        }
    }

    private boolean validarFormatoFecha(String fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            sdf.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    private void botonFIltrarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFIltrarNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonFIltrarNombreActionPerformed

    private void botonRestableceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRestableceActionPerformed
        List<VentaDTO> ventas = null;
            try {
                ventas = gv.consultarTodos();
            } catch (PersistenciaException ex) {
                Logger.getLogger(ventasFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        fieldFechaDesde.setText("");
        fieldFechaHasta.setText("");
        mostrarVentasEnTabla(ventas);
    }//GEN-LAST:event_botonRestableceActionPerformed

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
            java.util.logging.Logger.getLogger(ventasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventasFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ventasFrame().setVisible(true);
                } catch (PersistenciaException ex) {
                    Logger.getLogger(ventasFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonFIltrarNombre;
    private javax.swing.JButton botonFiltrarFechas;
    private javax.swing.JButton botonModificar;
    private javax.swing.JButton botonRestablece;
    private javax.swing.JButton botonRestablecer;
    private javax.swing.JButton botonSalir;
    private javax.swing.JTextField fieldFechaDesde;
    private javax.swing.JTextField fieldFechaHasta;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaVentas;
    // End of variables declaration//GEN-END:variables
}
