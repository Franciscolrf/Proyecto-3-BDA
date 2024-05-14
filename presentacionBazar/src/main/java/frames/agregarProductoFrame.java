/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package frames;

import javax.swing.JOptionPane;

/**
 *
 * @author ID145
 */
public class agregarProductoFrame extends javax.swing.JFrame {

    /**
     * Creates new form agregarProductoFrame
     */
    public agregarProductoFrame() {
        initComponents();
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
        jLabel1 = new javax.swing.JLabel();
        fieldCodigoBarras = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fieldCodigoInterno = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fieldNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fieldPrecio = new javax.swing.JTextField();
        botonSalir = new javax.swing.JButton();
        fieldRestablecer = new javax.swing.JButton();
        botonAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Agregar Producto");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(jLabel4)
                .addContainerGap(265, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 740, 0);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Código de Barras: ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 140, 120, 20);
        getContentPane().add(fieldCodigoBarras);
        fieldCodigoBarras.setBounds(130, 140, 130, 22);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Código Interno:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(350, 140, 110, 20);
        getContentPane().add(fieldCodigoInterno);
        fieldCodigoInterno.setBounds(460, 140, 130, 22);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 200, 60, 20);
        getContentPane().add(fieldNombre);
        fieldNombre.setBounds(130, 200, 160, 22);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Precio:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(400, 200, 60, 20);
        getContentPane().add(fieldPrecio);
        fieldPrecio.setBounds(460, 200, 70, 22);

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });
        getContentPane().add(botonSalir);
        botonSalir.setBounds(40, 320, 72, 23);

        fieldRestablecer.setText("Restablecer");
        fieldRestablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldRestablecerActionPerformed(evt);
            }
        });
        getContentPane().add(fieldRestablecer);
        fieldRestablecer.setBounds(270, 320, 110, 23);

        botonAgregar.setText("Agregar Producto");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(botonAgregar);
        botonAgregar.setBounds(470, 320, 140, 23);

        setBounds(0, 0, 658, 403);
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_botonSalirActionPerformed

    private void fieldRestablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldRestablecerActionPerformed
        fieldCodigoBarras.setText("");
        fieldCodigoInterno.setText("");
        fieldNombre.setText("");
        fieldPrecio.setText("");
    }//GEN-LAST:event_fieldRestablecerActionPerformed

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        String codigoBarras = fieldCodigoBarras.getText().trim();
                String codigoInterno = fieldCodigoInterno.getText().trim();
                String nombre = fieldNombre.getText().trim();
                String precio = fieldPrecio.getText().trim();

                // Validar que ningún campo esté vacío
                if (codigoBarras.isEmpty() || codigoInterno.isEmpty() || nombre.isEmpty() || precio.isEmpty()) {
                    JOptionPane.showMessageDialog(agregarProductoFrame.this, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar código de barras
                if (!codigoBarras.matches("^\\d{10}$")) {
                    JOptionPane.showMessageDialog(agregarProductoFrame.this, "Código de Barras debe contener solo números y debe ser de 10 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar código interno
                if (!codigoInterno.matches("^[A-Z]{3}\\d{3}$")) {
                    JOptionPane.showMessageDialog(agregarProductoFrame.this, "Código Interno debe tener el formato de 3 letras y luego 3 números (ejemplo: SAB001).", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar nombre
                if (!nombre.matches("^[a-zA-Z0-9 ]+$")) {
                    JOptionPane.showMessageDialog(agregarProductoFrame.this, "Nombre solo puede contener letras, números y espacios.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validar precio
                if (!precio.matches("^\\d+(\\.\\d{1,2})?$") || Double.parseDouble(precio) < 0) {
                    JOptionPane.showMessageDialog(agregarProductoFrame.this, "Precio debe ser un número no negativo.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                

                // Si todas las validaciones son exitosas, proceder con la lógica de agregar producto
                JOptionPane.showMessageDialog(agregarProductoFrame.this, "Producto agregado exitosamente.");
        
    }//GEN-LAST:event_botonAgregarActionPerformed

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
            java.util.logging.Logger.getLogger(agregarProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(agregarProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(agregarProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(agregarProductoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new agregarProductoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JTextField fieldCodigoBarras;
    private javax.swing.JTextField fieldCodigoInterno;
    private javax.swing.JTextField fieldNombre;
    private javax.swing.JTextField fieldPrecio;
    private javax.swing.JButton fieldRestablecer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}