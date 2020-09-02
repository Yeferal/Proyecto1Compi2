
package ventanas;

import analisis.AnalizadorLexico;
import analisis.AnalizadorSintactico;
import archivos.Archivo;
import archivos.GeneradorLenguaje;
import automata.ManejadorLexico;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import lalr.lectura.TablaPila;
import objetos.ArchivoExtension;
import objetos.ArchivoLenguaje;
import objetos.Lenguaje;
import proyecto1compi2.NumeroLinea;

public class VentanaInicio extends javax.swing.JFrame {
    
    public int indiceTabbed;
    private VentanaGuardar ventanaGuardar = new VentanaGuardar(this);
    public Archivo archivo = new Archivo();
    public ArrayList<ArchivoExtension> listaArchivos = new ArrayList<>();
    private ArrayList<Lenguaje> listaLenguajes = new ArrayList<>();
    private GeneradorLenguaje generadorLenguaje = new GeneradorLenguaje();
    public VentanaTablaLALR ventanaTablaLALR = new VentanaTablaLALR();
    private VentanaPila ventanaPila = new VentanaPila();
    final File carpeta = new File("Lenguajes");
    public int idLenguajeSeleccionado;
    
    public VentanaInicio() {
        initComponents();
        this.setLocationRelativeTo(null);
        //menuVer.setEnabled(false);
        //botonErrores.setEnabled(false);
        archivo.listarFicherosPorCarpeta(carpeta);
        buscarLenguajes();
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
    
    private void buscarLenguajes(){
        for (int i = 0; i < archivo.listaLenguajes.size(); i++) {
            listaLenguajes.add(archivo.listaLenguajes.get(i).getLenguaje());
            String nombre = archivo.listaLenguajes.get(i).getLenguaje().getNombre();
            AccionItemMenu accionItemMenu = new AccionItemMenu(this, i, labelLenguaje, nombre);
            JMenuItem item = new JMenuItem(nombre);
            item.setName(nombre);
            item.addActionListener(accionItemMenu);
            menuLenguaje.add(item);
        }
    }
    
    public void cambiarNombreTabbed(String nombre){
        tabbedPanel.setTitleAt(indiceTabbed, nombre);
        
        
    }
    
    public void compilarEntrada(String texto){
        ArchivoLenguaje archivoLenguaje = archivo.listaLenguajes.get(idLenguajeSeleccionado);
        ManejadorLexico manejadorLexico = new ManejadorLexico();
        manejadorLexico.iniciar(archivoLenguaje.getGeneradorEstadoAutamata().listaFilasAutomatas, texto, archivoLenguaje.getListaIgnorados());
        LinkedList<String> cola = manejadorLexico.cola;
        TablaPila tablaPila = new TablaPila();
        tablaPila.iniciarPila(archivoLenguaje.getTablaProducciones().listaProducciones, archivoLenguaje.getTablaTransiciones().tablaTransiciones, archivoLenguaje.getTablaTerminalesNoT(), cola);
        ventanaPila.llenarPila(tablaPila.getListaAcciones());
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
        botonErrores = new javax.swing.JButton();
        labelLenguaje = new javax.swing.JLabel();
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
        menuItemTabla = new javax.swing.JMenuItem();
        menuItemPila = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelFilCol.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        labelFilCol.setForeground(new java.awt.Color(255, 51, 51));

        tabbedPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabbedPanelMouseClicked(evt);
            }
        });

        botonErrores.setText("Errores");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabbedPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(labelLenguaje, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(botonErrores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelFilCol, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelLenguaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tabbedPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelFilCol, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonErrores))
                .addGap(9, 9, 9))
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
        menuItemCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCompilarActionPerformed(evt);
            }
        });
        menuEjecutar.add(menuItemCompilar);

        menuItemCargarLenguaje.setText("Cargar Lenguaje");
        menuItemCargarLenguaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCargarLenguajeActionPerformed(evt);
            }
        });
        menuEjecutar.add(menuItemCargarLenguaje);

        menuItemBorrarLenguaje.setText("Borrar Lenguaje");
        menuEjecutar.add(menuItemBorrarLenguaje);

        menuBar.add(menuEjecutar);

        menuVer.setText("Ver");

        menuItemTabla.setText("Tabla LALR");
        menuItemTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemTablaActionPerformed(evt);
            }
        });
        menuVer.add(menuItemTabla);

        menuItemPila.setText("Pila");
        menuItemPila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemPilaActionPerformed(evt);
            }
        });
        menuVer.add(menuItemPila);

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

    private void menuItemPilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemPilaActionPerformed
        ventanaPila.setVisible(true);
    }//GEN-LAST:event_menuItemPilaActionPerformed

    private void menuItemCargarLenguajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCargarLenguajeActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.showOpenDialog(this);
        File file = fileChooser.getSelectedFile();
        if(file!=null){
            try {
                String ruta = file.getPath();
                AnalizadorLexico lexico = new AnalizadorLexico(new StringReader(archivo.leerArchivo(ruta)));
                AnalizadorSintactico sintactico = new AnalizadorSintactico(lexico);
                sintactico.parse();
                if(sintactico.erroresSintacticos.size()>0 || sintactico.erroresSemanticos.size()>0){
                    JOptionPane.showMessageDialog(null, "El archivo del lenguaje contiene errores");
                    System.out.println("\nSINTACITCOS");
                    for (int i = 0; i < sintactico.erroresSintacticos.size(); i++) {
                        System.out.println(sintactico.erroresSintacticos.get(i).toString());
                    }
                    System.out.println("\nSEMANTICOS");
                    for (int i = 0; i < sintactico.erroresSemanticos.size(); i++) {
                        System.out.println(sintactico.erroresSemanticos.get(i).toString());
                    }
                    botonErrores.setEnabled(true);
                }else{
                    JOptionPane.showMessageDialog(null, "El archivo fue leido correctamente");
                    botonErrores.setEnabled(true);
                    generadorLenguaje.generar(sintactico);
                }
            } catch (Exception ex) {
                Logger.getLogger(VentanaInicio.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
        
    }//GEN-LAST:event_menuItemCargarLenguajeActionPerformed

    private void menuItemCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCompilarActionPerformed
        //int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
        if(tabbedPanel.getComponentCount()>0){
            JScrollPane jAux = (JScrollPane) tabbedPanel.getComponent(indiceTabbed);
            JTextArea areaAux = (JTextArea) jAux.getViewport().getComponent(0);
            String texto = areaAux.getText();
            String extension = tabbedPanel.getTitleAt(indiceTabbed);
            System.out.println(extension);
            String arreglo [] = extension.split("\\.");
            System.out.println(arreglo);
            if(arreglo.length>1){
                if(listaLenguajes.get(idLenguajeSeleccionado).getExtension()==null){
                    JOptionPane.showMessageDialog(null, "El lenguaje selccionado no requiere una extension");
                }else{
                    if(arreglo[arreglo.length-1].equals(listaLenguajes.get(idLenguajeSeleccionado).getExtension())){
                       System.out.println(texto); 
                        compilarEntrada(texto);
                    }else{
                        JOptionPane.showMessageDialog(null, "La extension del archivo no es la correcta");
                    }
                }
            }else{
                if(listaLenguajes.get(idLenguajeSeleccionado).getExtension()==null){
                    System.out.println(texto);
                    compilarEntrada(texto);
                }else{
                    JOptionPane.showMessageDialog(null, "El lenguaje selccionado requiere la extension:\n."+listaLenguajes.get(idLenguajeSeleccionado).getExtension());
                }
            }
            
            
            
            
        }else{
            System.out.println("No hay componentes");
        }
        
        
        
        
        
        
        
    }//GEN-LAST:event_menuItemCompilarActionPerformed

    private void menuItemTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemTablaActionPerformed
        ventanaTablaLALR.setVisible(true);
    }//GEN-LAST:event_menuItemTablaActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonErrores;
    private javax.swing.JLabel labelFilCol;
    private javax.swing.JLabel labelLenguaje;
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
    private javax.swing.JMenuItem menuItemPila;
    private javax.swing.JMenuItem menuItemSalir;
    private javax.swing.JMenuItem menuItemTabla;
    private javax.swing.JMenu menuLenguaje;
    private javax.swing.JMenu menuVer;
    private javax.swing.JPanel panel;
    public javax.swing.JTabbedPane tabbedPanel;
    // End of variables declaration//GEN-END:variables
}
