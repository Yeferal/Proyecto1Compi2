/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import automata.GeneradorEstadoAutamata;
import automata.ManejadorLexico;
import java.io.Serializable;
import java.util.ArrayList;
import lalr.TablaProducciones;
import lalr.TablaTerminalesNoT;
import lalr.TablaTransiciones;
import lalr.lectura.TablaPila;

/**
 *
 * @author LENOVO-PC
 */
public class ArchivoLenguaje implements Serializable{
    
    private Lenguaje lenguaje;    
    private GeneradorEstadoAutamata generadorEstadoAutamata;
    private ArrayList<String> listaIgnorados;
    private TablaTerminalesNoT tablaTerminalesNoT;
    private TablaProducciones tablaProducciones;
    private TablaTransiciones tablaTransiciones;
    //private TablaPila tablaPila;

    public ArchivoLenguaje(Lenguaje lenguaje, GeneradorEstadoAutamata generadorEstadoAutamata, ArrayList<String> listaIgnorados, TablaTerminalesNoT tablaTerminalesNoT, TablaProducciones tablaProducciones, TablaTransiciones tablaTransiciones) {
        this.lenguaje = lenguaje;
        this.generadorEstadoAutamata = generadorEstadoAutamata;
        this.listaIgnorados = listaIgnorados;
        this.tablaTerminalesNoT = tablaTerminalesNoT;
        this.tablaProducciones = tablaProducciones;
        this.tablaTransiciones = tablaTransiciones;
    }

    public Lenguaje getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(Lenguaje lenguaje) {
        this.lenguaje = lenguaje;
    }

    public GeneradorEstadoAutamata getGeneradorEstadoAutamata() {
        return generadorEstadoAutamata;
    }

    public void setGeneradorEstadoAutamata(GeneradorEstadoAutamata generadorEstadoAutamata) {
        this.generadorEstadoAutamata = generadorEstadoAutamata;
    }

    public ArrayList<String> getListaIgnorados() {
        return listaIgnorados;
    }

    public void setListaIgnorados(ArrayList<String> listaIgnorados) {
        this.listaIgnorados = listaIgnorados;
    }

    public TablaTerminalesNoT getTablaTerminalesNoT() {
        return tablaTerminalesNoT;
    }

    public void setTablaTerminalesNoT(TablaTerminalesNoT tablaTerminalesNoT) {
        this.tablaTerminalesNoT = tablaTerminalesNoT;
    }

    public TablaProducciones getTablaProducciones() {
        return tablaProducciones;
    }

    public void setTablaProducciones(TablaProducciones tablaProducciones) {
        this.tablaProducciones = tablaProducciones;
    }

    public TablaTransiciones getTablaTransiciones() {
        return tablaTransiciones;
    }

    public void setTablaTransiciones(TablaTransiciones tablaTransiciones) {
        this.tablaTransiciones = tablaTransiciones;
    }

    

    
    
    
}
