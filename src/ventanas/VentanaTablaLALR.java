/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import lalr.TablaTerminalesNoT;
import lalr.TablaTransiciones;
import lalr.TransicionesEstado;

/**
 *
 * @author LENOVO-PC
 */
public class VentanaTablaLALR extends javax.swing.JFrame {

    
    public VentanaTablaLALR() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void llenarTabla(TablaTerminalesNoT tablaTerminalesNoT , ArrayList<TransicionesEstado> tablaTransiciones){
        int tamanio = tablaTerminalesNoT.getTerminales().size()+ tablaTerminalesNoT.getNoTerminales().size()+2;
        DefaultTableModel modeloLALR = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }  
            };
        modeloLALR.addColumn("ESTADO ");
        
        for (int i = 0; i < tablaTerminalesNoT.getTerminales().size(); i++) {
            modeloLALR.addColumn(tablaTerminalesNoT.getTerminales().get(i));
        }
        modeloLALR.addColumn("$");
        for (int i = 0; i < tablaTerminalesNoT.getNoTerminales().size(); i++) {
            modeloLALR.addColumn(tablaTerminalesNoT.getNoTerminales().get(i));
        }
        tablaLALR.setModel(modeloLALR);
        String arreglo [] = new String[tamanio];
        
        for (int i = 0; i < tablaTransiciones.size(); i++) {
            arreglo[0] = ""+tablaTransiciones.get(i).getNumero();
            for (int j = 0; j < tablaTransiciones.get(i).getTablaTransiciones().size(); j++) {
                if(tablaTransiciones.get(i).getTablaTransiciones().get(j)!=null){
                    arreglo[j+1] = tablaTransiciones.get(i).getTablaTransiciones().get(j).getTipoTransicion();
                }else{
                    arreglo[j+1] = " ";
                }
                
            }
            modeloLALR.addRow(arreglo);
        }
        
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLALR = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tablaLALR.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaLALR);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1059, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(panel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private javax.swing.JTable tablaLALR;
    // End of variables declaration//GEN-END:variables
}
