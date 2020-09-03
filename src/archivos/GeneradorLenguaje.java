/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import analisis.AnalizadorSintactico;
import automata.GeneradorEstadoAutamata;
import automata.ManejadorLexico;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lalr.GeneradorEstadosLALR;
import lalr.TablaProducciones;
import lalr.TablaTerminalesNoT;
import lalr.TablaTransiciones;
import lalr.lectura.TablaPila;
import objetos.Arbol;
import objetos.ArchivoLenguaje;
import objetos.ExpresionRegular;
import objetos.Lenguaje;
import objetos.ManejadorNodos;
import objetos.Nodo;
import ventanas.VentanaInicio;

/**
 *
 * @author LENOVO-PC
 */
public class GeneradorLenguaje {
    
    VentanaInicio ventanaInicio;

    public GeneradorLenguaje(VentanaInicio ventanaInicio) {
        this.ventanaInicio = ventanaInicio;
    }
    
    public void generar(AnalizadorSintactico sintactico) throws Exception{
        Lenguaje lenguaje = sintactico.lenguaje;
        Arbol arFinal = new Arbol(null);
        Nodo nodo = null;
        ManejadorNodos m = new ManejadorNodos();//
        GeneradorEstadoAutamata ge = new GeneradorEstadoAutamata();
        for (int i = 0; i < sintactico.listaExpReg.size(); i++) {
            if(i==0){
                nodo = sintactico.listaExpReg.get(i).getArbol().getRaiz();
            }else{
                nodo = m.generarPadre(nodo, sintactico.listaExpReg.get(i).getArbol().getRaiz(), 4, "|", m.determinarAnulabilidad(nodo,sintactico.listaExpReg.get(i).getArbol().getRaiz()), "");
            }
        }
        Nodo node = new Nodo(6,"#",false, "");
        Nodo raiz = m.generarPadre(nodo, node,1,".",false, "");
        arFinal = new Arbol(raiz);
        
        arFinal.iniciarRecorridoPrimeroUltimos();
        arFinal.tablaS.listarCaracteres();
        
        
        //================================
        ge.generarEstados(arFinal);
        ArrayList<String> listaIgnorados = listarIgnorados(sintactico.expIgnorados);
        //================================
        
        
        //String textoF = "x = x";
        //ManejadorLexico manejadorLexico = new ManejadorLexico();
        //manejadorLexico.iniciar(ge.listaFilasAutomatas, textoF, listaIgnorados);

        
        
        
        
        
        
        
        
        
        
        
        
        //===================================================================================
        TablaTerminalesNoT tablaTerminalesNoT = sintactico.tablaTerminalesNoT;//
        tablaTerminalesNoT.desplegarTerminales();
        tablaTerminalesNoT.desplegarNoTerminales();

        TablaProducciones tablaProducciones = sintactico.tablaProducciones;//
        tablaProducciones.generarEstadoInicial();
        tablaProducciones.desplegarProducciones();
        System.out.println("");
        //===================================================================================
        
        GeneradorEstadosLALR generadorEstadosLALR = new GeneradorEstadosLALR();
        generadorEstadosLALR.inciarEstado(tablaProducciones.listaProducciones, tablaTerminalesNoT);
        System.out.println("===========================Estados===========================");
        generadorEstadosLALR.pintarEstados();
        
        //===================================================================================
        TablaTransiciones tablaTransiciones = new TablaTransiciones();//
        tablaTransiciones.generarTabla(generadorEstadosLALR.listaEstadoLR, tablaTerminalesNoT, tablaProducciones);
        //===================================================================================
        //generadorEstadosLALR.pintarProducciones();
        //tablaProducciones.desplegarProducciones();
        
       // LinkedList<String> cola = manejadorLexico.cola;
//        cola.offer("xd");
//        cola.offer("igual");
//        cola.offer("xd");
//        cola.offer("$");
        //TablaPila tablaPila = new TablaPila();
        //tablaPila.iniciarPila(tablaProducciones.listaProducciones, tablaTransiciones.tablaTransiciones, tablaTerminalesNoT, cola);
        
        ArchivoLenguaje archivoLenguaje = new ArchivoLenguaje(lenguaje, ge, listaIgnorados, tablaTerminalesNoT, tablaProducciones, tablaTransiciones);
        
        if(ventanaInicio.archivo.buscarLenguajeExistente(archivoLenguaje.getLenguaje().getNombre())){
            int resp = JOptionPane.showConfirmDialog(null, "Ya existe un lenguaje con el mismo nombre!!!\n¿Desea reemplazarlo?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if(resp==0){
                escribirArchivo(archivoLenguaje);
                System.out.println("Escribio");
            }
        }else{
            escribirArchivo(archivoLenguaje);
        }
    }
    
    public ArrayList<String> listarIgnorados(ExpresionRegular exp){
        ArrayList<String> lista = new ArrayList<>();
        if(exp!=null){
            recorrer(exp.getArbol().getRaiz(), lista);
        }
        
        return lista;
    }
    
    private void recorrer(Nodo actual, ArrayList<String> lista){
        
        if(actual.getIzquierdaNodo()==null){
            if(actual.getTipo()==5){
                lista.add(actual.getLexema());
            }
        }else{
            recorrer(actual.getIzquierdaNodo(), lista);
            recorrer(actual.getDerechaNodo(), lista);
            if(actual.getTipo()==5){
                lista.add(actual.getLexema());
            }
        }
        
    }
    
    public void escribirArchivo(ArchivoLenguaje archivoLenguaje) throws FileNotFoundException{
        try {
            ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream("Lenguajes/"+archivoLenguaje.getLenguaje().getNombre()+".dat"));
            escribiendoFichero.writeObject(archivoLenguaje);
            escribiendoFichero.close();
            System.out.println("Se escrivio");
        } catch (IOException ex) {
            Logger.getLogger(GeneradorLenguaje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
