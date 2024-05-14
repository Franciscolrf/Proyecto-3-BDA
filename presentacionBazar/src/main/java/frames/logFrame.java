package frames;

import excepciones.PersistenciaException;
import javax.swing.JOptionPane;
import frames.agregarUsuarioFrame;
import frames.principalFrame;
import gestores.GestorUsuarios;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ID145 /**
 *
 * @author ID145
 */
public class logFrame extends javax.swing.JFrame {

    /**
     * Creates new form logFrame
     */
    public logFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        contrasenaField = new javax.swing.JPasswordField();
        telefonoField = new javax.swing.JTextField();
        botonSalir = new javax.swing.JButton();
        botonRegistrarse = new javax.swing.JButton();
        botonAceptar = new javax.swing.JButton();
        checkboxMostrarContrasena = new javax.swing.JCheckBox();
        botonRestablecer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Bazar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(292, 292, 292)
                                .addComponent(jLabel1)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel1)
                                .addContainerGap(42, Short.MAX_VALUE)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Teléfono:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setText("Contraseña:");

        contrasenaField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        contrasenaField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contrasenaFieldActionPerformed(evt);
            }
        });

        telefonoField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        botonSalir.setText("Salir");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        botonRegistrarse.setText("Registrarse");
        botonRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarseActionPerformed(evt);
            }
        });

        botonAceptar.setText("Iniciar Sesión");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        checkboxMostrarContrasena.setText("Mostrar contraseña");
        checkboxMostrarContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxMostrarContrasenaActionPerformed(evt);
            }
        });

        botonRestablecer.setText("Restablecer");
        botonRestablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRestablecerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(botonSalir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72,
                                        Short.MAX_VALUE)
                                .addComponent(botonRegistrarse)
                                .addGap(56, 56, 56)
                                .addComponent(botonRestablecer)
                                .addGap(79, 79, 79)
                                .addComponent(botonAceptar)
                                .addGap(46, 46, 46))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(checkboxMostrarContrasena)
                                        .addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(telefonoField, javax.swing.GroupLayout.DEFAULT_SIZE, 331,
                                                        Short.MAX_VALUE)
                                                .addComponent(contrasenaField)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(telefonoField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(contrasenaField, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(checkboxMostrarContrasena)
                                .addGap(91, 91, 91)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(botonSalir)
                                        .addComponent(botonAceptar)
                                        .addComponent(botonRegistrarse)
                                        .addComponent(botonRestablecer))
                                .addGap(0, 68, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void contrasenaFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_contrasenaFieldActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_contrasenaFieldActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botonSalirActionPerformed
        dispose();
    }// GEN-LAST:event_botonSalirActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botonAceptarActionPerformed

        String telefono = telefonoField.getText();
        String contrasena = contrasenaField.getText();
        if (telefonoField.getText().trim().isEmpty() || contrasenaField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(logFrame.this, "Favor de rellenar todos los campos.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            GestorUsuarios gu = new GestorUsuarios();
            boolean inicioSesion = gu.iniciarSesion(telefono, contrasena);
            if (!inicioSesion) {
                JOptionPane.showMessageDialog(logFrame.this, "Usuario o contraseña incorrectos.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (PersistenciaException ex) {
            Logger.getLogger(logFrame.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }

        dispose();
        principalFrame principal = new principalFrame();
        principal.setVisible(true);

    }// GEN-LAST:event_botonAceptarActionPerformed

    private void botonRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botonRegistrarseActionPerformed

        agregarUsuarioFrame agregarFrame = new agregarUsuarioFrame();
        agregarFrame.setVisible(true);
        dispose();
    }// GEN-LAST:event_botonRegistrarseActionPerformed

    private void checkboxMostrarContrasenaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_checkboxMostrarContrasenaActionPerformed
        if (checkboxMostrarContrasena.isSelected()) {
            contrasenaField.setEchoChar((char) 0);
        } else {
            contrasenaField.setEchoChar('*');
        }
    }// GEN-LAST:event_checkboxMostrarContrasenaActionPerformed

    private void botonRestablecerActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_botonRestablecerActionPerformed
        contrasenaField.setText("");
        telefonoField.setText("");
    }// GEN-LAST:event_botonRestablecerActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(logFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(logFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(logFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(logFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new logFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonRegistrarse;
    private javax.swing.JButton botonRestablecer;
    private javax.swing.JButton botonSalir;
    private javax.swing.JCheckBox checkboxMostrarContrasena;
    private javax.swing.JPasswordField contrasenaField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField telefonoField;
    // End of variables declaration//GEN-END:variables

}
