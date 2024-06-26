/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import dtos.VentaDTO;
import dtos.VentaDTO.MetodoPago;
import excepciones.PersistenciaException;
import gestores.GestorVentas;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import pojos.Producto;

/**
 * Frame que permite modificar una venta existente en la base de datos.
 * @author Fran
 */
public class modificarVentaFrame extends javax.swing.JFrame {

    VentaDTO venta;
    Producto producto;
    float montoTotal;

    /**
     * Creates new form agregarVentaForm
     */
    public modificarVentaFrame(VentaDTO venta) {
        this.venta = venta;
        initComponents();
        initFields();
    }

    private modificarVentaFrame() {
        initComponents();
    }

    /**
     * Inicializa los campos del formulario con los valores de la venta a
     * modificar.
     */
    private void initFields() {
        fieldNombreCliente.setText(venta.getNombreCliente());
        fieldApellidoCliente.setText(venta.getApellidoCliente());
        fieldTotal.setText(String.valueOf(venta.getMontoTotal()));
        fieldCodigoInterno.setText(venta.getCodigoInterno());
        fieldTotal.setEditable(false);
        fieldCodigoInterno.setEditable(false);
        
        MetodoPago metodoPago = venta.getMetodoPago();
        if (metodoPago != null) {
            metodoPagoComboBox.setSelectedItem(metodoPago.toString());
        }
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
        botonSalir = new javax.swing.JButton();
        botonCompletar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fieldNombreCliente = new javax.swing.JTextField();
        fieldApellidoCliente = new javax.swing.JTextField();
        metodoPagoComboBox = new javax.swing.JComboBox<>();
        fieldTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        fieldCodigoInterno = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Modificar Venta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(220, 220, 220))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 690, 70);

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir);
        botonSalir.setBounds(130, 420, 100, 23);

        botonCompletar.setText("Modificar Venta");
        botonCompletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCompletarActionPerformed(evt);
            }
        });
        getContentPane().add(botonCompletar);
        botonCompletar.setBounds(420, 420, 130, 23);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("Nombre cliente:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 110, 110, 22);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Apellido cliente:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 160, 110, 22);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Método de pago:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 230, 120, 22);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Total a pagar:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 290, 100, 22);

        fieldNombreCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(fieldNombreCliente);
        fieldNombreCliente.setBounds(140, 110, 360, 26);

        fieldApellidoCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(fieldApellidoCliente);
        fieldApellidoCliente.setBounds(140, 170, 360, 22);

        metodoPagoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EFECTIVO", "TARJETA" }));
        metodoPagoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metodoPagoComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(metodoPagoComboBox);
        metodoPagoComboBox.setBounds(140, 230, 100, 22);

        fieldTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldTotalActionPerformed(evt);
            }
        });
        getContentPane().add(fieldTotal);
        fieldTotal.setBounds(140, 290, 100, 22);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel7.setText("Codigo Interno:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(330, 230, 120, 22);

        fieldCodigoInterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCodigoInternoActionPerformed(evt);
            }
        });
        getContentPane().add(fieldCodigoInterno);
        fieldCodigoInterno.setBounds(470, 230, 100, 22);

        setBounds(0, 0, 707, 520);
    }// </editor-fold>//GEN-END:initComponents

    private void metodoPagoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metodoPagoComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_metodoPagoComboBoxActionPerformed

    /**
     * Método que se ejecuta al hacer click en el botón "Modificar Venta".
     * @param evt
     */
    private void botonCompletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCompletarActionPerformed
        GestorVentas gv = null;
        try {
           gv= new GestorVentas();
        } catch (PersistenciaException ex) {
            Logger.getLogger(modificarVentaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Obtener los valores de los campos
        String nombreCliente = fieldNombreCliente.getText();
        String apellidoCliente = fieldApellidoCliente.getText();
        MetodoPago metodoPago = MetodoPago.valueOf(metodoPagoComboBox.getSelectedItem().toString());
        String codigoInterno = fieldCodigoInterno.getText();
        float montoTotal = Float.parseFloat(fieldTotal.getText());

        // Crear un objeto VentaDTO con los valores obtenidos
        VentaDTO ventaModificada = null;
        try {
            ventaModificada = gv.consultarPorCodigoInterno(codigoInterno);
        } catch (PersistenciaException ex) {
            Logger.getLogger(modificarVentaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        ventaModificada.setNombreCliente(nombreCliente);
        ventaModificada.setApellidoCliente(apellidoCliente);
        ventaModificada.setMetodoPago(metodoPago);
        ventaModificada.setCodigoInterno(codigoInterno);
        ventaModificada.setMontoTotal(montoTotal);

        // Intentar modificar la venta en la base de datos
        boolean exito = false;
        try {
            exito = gv.modificar(ventaModificada);
        } catch (PersistenciaException ex) {
            Logger.getLogger(modificarVentaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (exito) {
            JOptionPane.showMessageDialog(this, "La venta se modificó correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            // Cerrar el frame después de completar la modificación
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo modificar la venta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        ventasFrame vf = null;
        try {
            vf = new ventasFrame();
        } catch (PersistenciaException ex) {
            Logger.getLogger(modificarVentaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        vf.setVisible(true);
    }//GEN-LAST:event_botonCompletarActionPerformed


    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_botonSalirActionPerformed

    private void fieldTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldTotalActionPerformed
        fieldTotal.setEditable(false);
    }//GEN-LAST:event_fieldTotalActionPerformed

    private void fieldCodigoInternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCodigoInternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCodigoInternoActionPerformed

    /**
     * Método main de la clase.
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
            java.util.logging.Logger.getLogger(modificarVentaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(modificarVentaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(modificarVentaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(modificarVentaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new modificarVentaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCompletar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JTextField fieldApellidoCliente;
    private javax.swing.JTextField fieldCodigoInterno;
    private javax.swing.JTextField fieldNombreCliente;
    private javax.swing.JTextField fieldTotal;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> metodoPagoComboBox;
    // End of variables declaration//GEN-END:variables

}
