package com.nataliguillen.diccionario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.Comparator;

public class NuevoDiccionario extends javax.swing.JFrame {
    
    // Atributos
    public static ArrayList<Termino> NuevoSetTerminos = new ArrayList<>();
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(NuevoDiccionario.class.getName());

    public NuevoDiccionario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPalabra = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtConcepto = new javax.swing.JTextArea();
        btnGuardarTermino = new javax.swing.JButton();
        btnGuardarDiccionario = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Diccionario");

        txtPalabra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        txtConcepto.setColumns(20);
        txtConcepto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtConcepto.setRows(5);
        jScrollPane1.setViewportView(txtConcepto);

        btnGuardarTermino.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGuardarTermino.setText("Guardar Termino");
        btnGuardarTermino.addActionListener(this::btnGuardarTerminoActionPerformed);

        btnGuardarDiccionario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnGuardarDiccionario.setText("Guardar Diccionario");
        btnGuardarDiccionario.addActionListener(this::btnGuardarDiccionarioActionPerformed);

        btnVolver.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(this::btnVolverActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPalabra, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addComponent(btnGuardarTermino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardarDiccionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(txtPalabra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardarTermino)
                .addGap(18, 18, 18)
                .addComponent(btnGuardarDiccionario)
                .addGap(18, 18, 18)
                .addComponent(btnVolver)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarTerminoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarTerminoActionPerformed
        
        String palabra = txtPalabra.getText().trim();
        String concepto = txtConcepto.getText().trim();

        if (palabra.isEmpty() || concepto.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Debe ingresar la palabra y su definicion.");
            return;
        }

        // Crear y guardar termino
        Termino nuevoTermino = new Termino(palabra, concepto);
        NuevoSetTerminos.add(nuevoTermino);

        JOptionPane.showMessageDialog(this,
                "Termino guardado correctamente.");

        // Limpiar campos
        txtPalabra.setText("");
        txtConcepto.setText("");

    }//GEN-LAST:event_btnGuardarTerminoActionPerformed

    private void btnGuardarDiccionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDiccionarioActionPerformed
        
        if (NuevoSetTerminos.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Debe ingresar al menos un termino.");
            return;
        }

        // Ordenar terminos
        NuevoSetTerminos.sort(
                Comparator.comparing(Termino::getPalabra,
                        String.CASE_INSENSITIVE_ORDER));

        // Crear diccionario
        Diccionario diccionario = new Diccionario(NuevoSetTerminos);

        // Guardar archivo
        try {
            FileOutputStream archivo = new FileOutputStream(
                    "Diccionario.NataliGuillenRodriguez");
            ObjectOutputStream salida = new ObjectOutputStream(archivo);

            salida.writeObject(diccionario);
            salida.close();
            archivo.close();

            JOptionPane.showMessageDialog(this,
                    "Diccionario guardado correctamente.");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,
                    "Error al guardar el diccionario.");
        }

    }//GEN-LAST:event_btnGuardarDiccionarioActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        
        this.dispose();

    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new NuevoDiccionario().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarDiccionario;
    private javax.swing.JButton btnGuardarTermino;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtConcepto;
    private javax.swing.JTextField txtPalabra;
    // End of variables declaration//GEN-END:variables
}
