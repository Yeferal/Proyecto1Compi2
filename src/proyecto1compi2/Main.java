
package proyecto1compi2;

import analisis.AnalizadorLexico;
import analisis.AnalizadorSintactico;
import analisis.comprobaciones.AnalizadorLexicoC;
import analisis.comprobaciones.AnalizadorSintacticoC;
import automata.GeneradorEstadoAutamata;
import automata.ManejadorLexico;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import lalr.GeneradorEstadosLALR;
import lalr.TablaProducciones;
import lalr.TablaTerminalesNoT;
import lalr.TablaTransiciones;
import lalr.lectura.TablaPila;
import objetos.Arbol;
import objetos.ManejadorNodos;
import objetos.Nodo;
import ventanas.VentanaInicio;

public class Main {

    
    public static void main(String[] args) throws IOException, Exception {
        
        VentanaInicio ventanaInicio = new VentanaInicio();
        ventanaInicio.setVisible(true);
        
        
    }
    
    
    
}
