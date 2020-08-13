
package ventanas;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;

public class VentanaInicio extends javax.swing.JFrame {

    
    public VentanaInicio() {
        initComponents();
        this.setLocationRelativeTo(null);
        labelFilCol.setText("Fila: "+1+",  Columna: "+2);
        JTextArea area = new JTextArea();
        area.setFont(new Font("NORMAL", Font.PLAIN, 14));
        
        tabbedPanel.addTab("Eje 1.java",area);
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        labelFilCol = new javax.swing.JLabel();
        tabbedPanel = new javax.swing.JTabbedPane();
        menuBar = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        menuItemNuevo = new javax.swing.JMenuItem();
        menuItemAbrir = new javax.swing.JMenuItem();
        menuItemGuardar = new javax.swing.JMenuItem();
        menuItemGuardarComo = new javax.swing.JMenuItem();
        menuItemSalir = new javax.swing.JMenuItem();
        menuLenguaje = new javax.swing.JMenu();
        menuEjecutar = new javax.swing.JMenu();
        menuItemCompilar = new javax.swing.JMenuItem();
        menuItemCargarLenguaje = new javax.swing.JMenuItem();
        menuItemBorrarLenguaje = new javax.swing.JMenuItem();
        menuVer = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.BorderLayout());

        labelFilCol.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        labelFilCol.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGap(0, 891, Short.MAX_VALUE)
                        .addComponent(labelFilCol, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tabbedPanel))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(tabbedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFilCol, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(panel, java.awt.BorderLayout.CENTER);

        menuArchivo.setText("Archivo");

        menuItemNuevo.setText("Nuevo");
        menuItemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNuevoActionPerformed(evt);
            }
        });
        menuArchivo.add(menuItemNuevo);

        menuItemAbrir.setText("Abrir");
        menuArchivo.add(menuItemAbrir);

        menuItemGuardar.setText("Guardar");
        menuArchivo.add(menuItemGuardar);

        menuItemGuardarComo.setText("Guardar Como");
        menuArchivo.add(menuItemGuardarComo);

        menuItemSalir.setText("Salir");
        menuArchivo.add(menuItemSalir);

        menuBar.add(menuArchivo);

        menuLenguaje.setText("Lenguaje");
        menuBar.add(menuLenguaje);

        menuEjecutar.setText("Ejecutar");

        menuItemCompilar.setText("Compilar");
        menuEjecutar.add(menuItemCompilar);

        menuItemCargarLenguaje.setText("Cargar Lenguaje");
        menuEjecutar.add(menuItemCargarLenguaje);

        menuItemBorrarLenguaje.setText("Borrar Lenguaje");
        menuEjecutar.add(menuItemBorrarLenguaje);

        menuBar.add(menuEjecutar);

        menuVer.setText("Ver");
        menuBar.add(menuVer);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuItemNuevoActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labelFilCol;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuEjecutar;
    private javax.swing.JMenuItem menuItemAbrir;
    private javax.swing.JMenuItem menuItemBorrarLenguaje;
    private javax.swing.JMenuItem menuItemCargarLenguaje;
    private javax.swing.JMenuItem menuItemCompilar;
    private javax.swing.JMenuItem menuItemGuardar;
    private javax.swing.JMenuItem menuItemGuardarComo;
    private javax.swing.JMenuItem menuItemNuevo;
    private javax.swing.JMenuItem menuItemSalir;
    private javax.swing.JMenu menuLenguaje;
    private javax.swing.JMenu menuVer;
    private javax.swing.JPanel panel;
    private javax.swing.JTabbedPane tabbedPanel;
    // End of variables declaration//GEN-END:variables
}
