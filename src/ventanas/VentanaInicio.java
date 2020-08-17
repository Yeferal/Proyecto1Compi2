
package ventanas;

import archivos.Archivo;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import objetos.ArchivoExtension;
import objetos.Lenguaje;
import proyecto1compi2.NumeroLinea;

public class VentanaInicio extends javax.swing.JFrame {
    
    public int indiceTabbed;
    private VentanaGuardar ventanaGuardar = new VentanaGuardar(this);
    private Archivo archivo = new Archivo();
    public ArrayList<ArchivoExtension> listaArchivos = new ArrayList<>();
    private ArrayList<Lenguaje> listaLenguajes = new ArrayList<>();
    
    public VentanaInicio() {
        initComponents();
        this.setLocationRelativeTo(null);
        listaLenguajes.add(new Lenguaje("Java"));
        listaLenguajes.add(new Lenguaje("C++"));
        listaLenguajes.add(new Lenguaje("Python"));
    }
    
    private void crearArchivo(String nombre){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        if (file!=null) {
            String ruta = file.getPath()+"/"+nombre;
            System.out.println(ruta);
            archivo.crearArchivo(ruta, " ");
        }
    }
    
    private void generarPestania(ArchivoExtension ar, String nombre){
        listaArchivos.add(ar);
            JScrollPane j = new JScrollPane();
            JTextArea jArea = new JTextArea();
            jArea.addCaretListener(new CaretListener() {
                @Override
                public void caretUpdate(CaretEvent e) {
                    JTextArea editArea = (JTextArea) e.getSource();
                    int linea = 1,columna = 1;
                    try {
                        int carePos = editArea.getCaretPosition();
                        linea = editArea.getLineOfOffset(carePos);
                        columna = carePos - editArea.getLineStartOffset(linea);
                        linea +=1;
                        columna +=1;
                    } catch (Exception ex) {
                    }
                    labelFilCol.setText("Fila: "+linea+",  Columna: "+columna);
                }
            });
            NumeroLinea nL = new NumeroLinea(jArea);
            jArea.setText("");
            j.setRowHeaderView(nL);
            j.setViewportView(jArea);
            tabbedPanel.addTab(nombre, j);
    }
    
    private void verificarArchivo(ArchivoExtension ar, String nombre){
        boolean estado = false;
        int index = 0;
        for (int i = 0; i < listaArchivos.size(); i++) {
            if(listaArchivos.get(i).getNombre().equals(ar.getNombre())){
                estado = true;
                index = i;
                break;
            }
        }
        
        if(estado){
            tabbedPanel.remove(index);
            listaArchivos.remove(index);
            listaArchivos.add(ar);
            JScrollPane j = new JScrollPane();
            JTextArea jArea = new JTextArea();
            jArea.addCaretListener(new CaretListener() {
                @Override
                public void caretUpdate(CaretEvent e) {
                    JTextArea editArea = (JTextArea) e.getSource();
                    int linea = 1,columna = 1;
                    try {
                        int carePos = editArea.getCaretPosition();
                        linea = editArea.getLineOfOffset(carePos);
                        columna = carePos - editArea.getLineStartOffset(linea);
                        linea +=1;
                        columna +=1;
                    } catch (Exception ex) {
                    }
                    labelFilCol.setText("Fila: "+linea+",  Columna: "+columna);
                }
            });
            NumeroLinea nL = new NumeroLinea(jArea);
            jArea.setText(archivo.leerArchivo(ar.getPath()));
            j.setRowHeaderView(nL);
            j.setViewportView(jArea);
            tabbedPanel.addTab(nombre, j);
            
        }else{
            listaArchivos.add(ar);
            JScrollPane j = new JScrollPane();
            JTextArea jArea = new JTextArea();
            jArea.addCaretListener(new CaretListener() {
                @Override
                public void caretUpdate(CaretEvent e) {
                    JTextArea editArea = (JTextArea) e.getSource();
                    int linea = 1,columna = 1;
                    try {
                        int carePos = editArea.getCaretPosition();
                        linea = editArea.getLineOfOffset(carePos);
                        columna = carePos - editArea.getLineStartOffset(linea);
                        linea +=1;
                        columna +=1;
                    } catch (Exception ex) {
                    }
                    labelFilCol.setText("Fila: "+linea+",  Columna: "+columna);
                }
            });
            NumeroLinea nL = new NumeroLinea(jArea);
            jArea.setText(archivo.leerArchivo(ar.getPath()));
            j.setRowHeaderView(nL);
            j.setViewportView(jArea);
            tabbedPanel.addTab(nombre, j);
        }
    }

    
    private void guardarComo(String nombre){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        if (file!=null) {
            String ruta = file.getPath()+"/"+nombre;
            JScrollPane jAux = (JScrollPane) tabbedPanel.getComponent(indiceTabbed);
            JTextArea areaAux = (JTextArea) jAux.getViewport().getComponent(0);
            archivo.crearArchivo(ruta, areaAux.getText());
            JOptionPane.showMessageDialog(null, "Se Guardo el nuevo archivo");

        }
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

        labelFilCol.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        labelFilCol.setForeground(new java.awt.Color(255, 51, 51));

        tabbedPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabbedPanelMouseClicked(evt);
            }
        });

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

        menuItemNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menuItemNuevo.setText("Nuevo");
        menuItemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemNuevoActionPerformed(evt);
            }
        });
        menuArchivo.add(menuItemNuevo);

        menuItemAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuItemAbrir.setText("Abrir");
        menuItemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemAbrirActionPerformed(evt);
            }
        });
        menuArchivo.add(menuItemAbrir);

        menuItemGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuItemGuardar.setText("Guardar");
        menuItemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGuardarActionPerformed(evt);
            }
        });
        menuArchivo.add(menuItemGuardar);

        menuItemGuardarComo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuItemGuardarComo.setText("Guardar Como");
        menuItemGuardarComo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemGuardarComoActionPerformed(evt);
            }
        });
        menuArchivo.add(menuItemGuardarComo);

        menuItemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menuItemSalir.setText("Salir");
        menuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemSalirActionPerformed(evt);
            }
        });
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

            generarPestania(new ArchivoExtension("Sin nombre", null),"Sin nombre");
    }//GEN-LAST:event_menuItemNuevoActionPerformed

    private void tabbedPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedPanelMouseClicked
        indiceTabbed = tabbedPanel.getSelectedIndex();
    }//GEN-LAST:event_tabbedPanelMouseClicked

    private void menuItemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemAbrirActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        if(file!=null){
            String ruta = file.getPath();
            String nombreA = file.getName();
            System.out.println("Nombre: "+nombreA);
            String [] arreglo = nombreA.split("\\.");
            ArchivoExtension a = new ArchivoExtension(nombreA, ruta);
            if(arreglo.length>1){
                System.out.println("extesion: "+arreglo[arreglo.length-1]);
                a.setExtension(arreglo[arreglo.length-1]);
            }else{
                System.out.println("No tiene extension: "+arreglo[0]);
                a.setExtension("");
            }
            verificarArchivo(a, nombreA);
        }
    }//GEN-LAST:event_menuItemAbrirActionPerformed

    private void menuItemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGuardarActionPerformed
        if(listaArchivos.size()>0){
            ventanaGuardar.setListaLenguajes(listaLenguajes);
            ventanaGuardar.llenarTabla();
            ventanaGuardar.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "No existe ningun archivo");
        }

    }//GEN-LAST:event_menuItemGuardarActionPerformed

    private void menuItemGuardarComoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemGuardarComoActionPerformed
        String nombreNuevo = JOptionPane.showInputDialog("Escribe el nuevo nombre del archivo");
        if(nombreNuevo!=null){
            String f[] = listaArchivos.get(indiceTabbed).getNombre().split("\\.");
            if(!f[0].equals(nombreNuevo)){
                guardarComo(nombreNuevo);
            }else{
                JOptionPane.showMessageDialog(null, "El nombre del arhcivo es el mismo");
            }
        }
        

        
        
        
    }//GEN-LAST:event_menuItemGuardarComoActionPerformed

    private void menuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_menuItemSalirActionPerformed
    
    
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
    public javax.swing.JTabbedPane tabbedPanel;
    // End of variables declaration//GEN-END:variables
}
