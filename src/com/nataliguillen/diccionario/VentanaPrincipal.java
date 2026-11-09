package com.nataliguillen.diccionario;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VentanaPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName());

    public VentanaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblDefinicion = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuOpciones = new javax.swing.JMenu();
        itemNuevoDiccionario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Diccionario de Don Fidelio");

        txtBuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        lblDefinicion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDefinicion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDefinicion.setText("DEFINICION DEL CONCEPTO...");
        lblDefinicion.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        menuOpciones.setText("Opciones");
        menuOpciones.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        itemNuevoDiccionario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        itemNuevoDiccionario.setText("Nuevo Diccionario");
        itemNuevoDiccionario.addActionListener(this::itemNuevoDiccionarioActionPerformed);
        menuOpciones.add(itemNuevoDiccionario);

        jMenuBar1.add(menuOpciones);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDefinicion, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                    .addComponent(txtBuscar)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBuscar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addGap(18, 18, 18)
                .addComponent(lblDefinicion, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemNuevoDiccionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoDiccionarioActionPerformed
        
        NuevoDiccionario ventana = new NuevoDiccionario();
        ventana.setVisible(true);

    }//GEN-LAST:event_itemNuevoDiccionarioActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
        String palabra = txtBuscar.getText().trim();

        if (palabra.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Debe ingresar una palabra para buscar.");
            return;
        }

        // Leer diccionario
        try {
            FileInputStream archivo = new FileInputStream(
                    "Diccionario.NataliGuillenRodriguez");
            ObjectInputStream entrada = new ObjectInputStream(archivo);

            Diccionario diccionario = (Diccionario) entrada.readObject();

            entrada.close();
            archivo.close();

            // Buscar termino
            boolean encontrado = false;
            ArrayList<Termino> terminos = diccionario.getTerminos();

            for (Termino termino : terminos) {
                if (termino.getPalabra().equalsIgnoreCase(palabra)) {
                    lblDefinicion.setText(
                            "<html><body style='width:400px'>"
                            + termino.getConcepto()
                            + "</body></html>");
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                lblDefinicion.setText("DEFINICION DEL CONCEPTO...");
                JOptionPane.showMessageDialog(this,
                        "No se encontraron resultados.");
            }

        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al leer el diccionario.");
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JMenuItem itemNuevoDiccionario;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblDefinicion;
    private javax.swing.JMenu menuOpciones;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
