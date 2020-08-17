
package ventanas;

import archivos.Archivo;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import objetos.Lenguaje;

public class VentanaGuardar extends javax.swing.JFrame {

    private Archivo archivo = new Archivo();
    private VentanaInicio ventanaInicio;
    private ArrayList<Lenguaje> listaLenguajes;
    private int indice;
    private boolean seleccionado;
    private String nombreArchivo;
    
    public VentanaGuardar(VentanaInicio ventanaInicio) {
        initComponents();
        this.ventanaInicio = ventanaInicio;
        this.setLocationRelativeTo(null);
    }

    public ArrayList<Lenguaje> getListaLenguajes() {
        return listaLenguajes;
    }

    public void setListaLenguajes(ArrayList<Lenguaje> listaLenguajes) {
        this.listaLenguajes = listaLenguajes;
    }
    
    private void crearArchivo(String nombre,String extension){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        if (file!=null) {
            String ruta = file.getPath()+"/"+nombre;
            JScrollPane jAux = (JScrollPane) ventanaInicio.tabbedPanel.getComponent(ventanaInicio.indiceTabbed);
            JTextArea areaAux = (JTextArea) jAux.getViewport().getComponent(0);
            archivo.crearArchivo(ruta, areaAux.getText());
            ventanaInicio.tabbedPanel.setTitleAt(ventanaInicio.indiceTabbed, nombre);
            ventanaInicio.listaArchivos.get(ventanaInicio.indiceTabbed).setNombre(nombre);
            ventanaInicio.listaArchivos.get(ventanaInicio.indiceTabbed).setPath(ruta);
            ventanaInicio.listaArchivos.get(ventanaInicio.indiceTabbed).setExtension(extension);
            JOptionPane.showMessageDialog(null, "Se Guardaron los cambio Correctamente");
            ventanaInicio.setVisible(true);
            this.setVisible(false);
        }
    }
    
    public void llenarTabla(){
        DefaultTableModel modelo1 = new DefaultTableModel();
        
        modelo1.addColumn("Nombre");
        modelo1.addColumn("Extension");
       
        tablaLenguajes.setModel(modelo1);
        String datos[]= new String[2];
        for (int i = 0; i < listaLenguajes.size(); i++) {
            datos [0] = listaLenguajes.get(i).getNombre();
            datos [1] = listaLenguajes.get(i).getExtension();
            modelo1.addRow(datos);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLenguajes = new javax.swing.JTable();
        labelNombre = new javax.swing.JLabel();
        textFieldNombre = new javax.swing.JTextField();
        botonCancelar = new javax.swing.JButton();
        botonGuardar = new javax.swing.JButton();
        labelFinal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaLenguajes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaLenguajes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaLenguajesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaLenguajes);

        labelNombre.setText("Nombre: ");

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botonCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonGuardar))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(labelFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(173, 173, 173)
                        .addComponent(labelFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonCancelar)
                    .addComponent(botonGuardar))
                .addContainerGap())
        );

        getContentPane().add(panel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaLenguajesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaLenguajesMouseClicked
        indice = tablaLenguajes.getSelectedRow();
        seleccionado = false;
        if(listaLenguajes.get(indice).getExtension()==null || listaLenguajes.get(indice).getExtension().isEmpty()){
            labelFinal.setText("Nombre final: "+textFieldNombre.getText());
            seleccionado = true;
        }else{
            labelFinal.setText("Nombre final: "+textFieldNombre.getText()+"."+listaLenguajes.get(indice).getExtension());
            seleccionado = true;
        }
    }//GEN-LAST:event_tablaLenguajesMouseClicked

    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_botonCancelarActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        if(!labelNombre.getText().isEmpty() && seleccionado){
            if(listaLenguajes.get(indice).getExtension()==null || listaLenguajes.get(indice).getExtension().isEmpty()){
                nombreArchivo = textFieldNombre.getText();
                crearArchivo(nombreArchivo,"");
            }else{
                nombreArchivo = textFieldNombre.getText()+"."+listaLenguajes.get(indice).getExtension();
                crearArchivo(nombreArchivo,listaLenguajes.get(indice).getExtension());
            }
            
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelFinal;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tablaLenguajes;
    private javax.swing.JTextField textFieldNombre;
    // End of variables declaration//GEN-END:variables
}
