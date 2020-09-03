/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.util.ArrayList;
import error.Error;
/**
 *
 * @author LENOVO-PC
 */
public class VentanaErrores extends javax.swing.JFrame {

    
    public VentanaErrores() {
        initComponents();
        this.setLocationRelativeTo(null);
        areaErrores.setEditable(false);
    }
    
    
    public void llenarErrores(ArrayList<Error> erroresSintacticos, ArrayList<Error> erroresSemantico){
        String texto = "============Errores Lexicos============";
        texto += "\n\n============Errores Sintacticos============\n";
        for (int i = 0; i < erroresSintacticos.size(); i++) {
            texto += erroresSintacticos.get(i).toString()+"\n";
        }
        texto += "\n\n============Errores Semanticos============\n";
        for (int i = 0; i < erroresSemantico.size(); i++) {
            texto += erroresSemantico.get(i).toString()+"\n";
        }
        areaErrores.setText(texto);
    }
    
    public void llenarErroresEntrada(ArrayList<String> listaErroresLexicos){
        String texto = "============Errores Lexicos Entrada============ \n\n";
        for (int i = 0; i < listaErroresLexicos.size(); i++) {
            texto += "Token: "+listaErroresLexicos.get(i)+"\n";
        }
        areaErrores.setText(texto);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaErrores = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        areaErrores.setColumns(20);
        areaErrores.setRows(5);
        jScrollPane1.setViewportView(areaErrores);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(panel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaErrores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
