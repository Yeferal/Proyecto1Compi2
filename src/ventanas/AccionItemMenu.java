/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import objetos.ArchivoLenguaje;

/**
 *
 * @author LENOVO-PC
 */
public class AccionItemMenu implements ActionListener{
    
    VentanaInicio ventanaInicio;
    int identificadorL;
    JLabel labelLenguaje;
    String nombre;

    public AccionItemMenu(VentanaInicio ventanaInicio, int identificadorL, JLabel labelLenguaje, String nombre) {
        this.ventanaInicio = ventanaInicio;
        this.identificadorL = identificadorL;
        this.labelLenguaje = labelLenguaje;
        this.nombre = nombre;
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
         labelLenguaje.setText("Lenguaje Seleccionado: "+nombre);
         ventanaInicio.idLenguajeSeleccionado = identificadorL;
         System.out.println("Lenguaje Seleccionado: "+nombre);
         ArchivoLenguaje archivoLenguaje = ventanaInicio.archivo.listaLenguajes.get(identificadorL);
         ventanaInicio.ventanaTablaLALR.llenarTabla(archivoLenguaje.getTablaTerminalesNoT(), archivoLenguaje.getTablaTransiciones().tablaTransiciones);
    }
    
}
