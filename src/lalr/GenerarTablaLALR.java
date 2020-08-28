/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lalr;

import java.util.ArrayList;

/**
 *
 * @author LENOVO-PC
 */
public class GenerarTablaLALR {
    
    
    private ArrayList<TransicionesEstado> tablaTransiciones;
    private ArrayList<EstadoLR> listaEstadoLR;
    private ArrayList<EstadosParecidos> listaParecido;
    
    
    public void iniciarRecorrido(ArrayList<TransicionesEstado> tablaTransiciones, ArrayList<EstadoLR> listaEstadoLR){
        this.tablaTransiciones = tablaTransiciones;
        this.listaEstadoLR = listaEstadoLR;
        listaParecido = new ArrayList<>();
        buscarParecidos();
        desplegarParecidos();
    }
    
   
    public void buscarParecidos(){
        for (int i = 0; i < listaEstadoLR.size(); i++) {
            if(!listaEstadoLR.get(i).isUsed){
                EstadosParecidos estadosParecidos = new EstadosParecidos();
                estadosParecidos.agregarNuevo(i+1);
                for (int j = i+1; j < listaEstadoLR.size(); j++) {
                    if(!listaEstadoLR.get(j).isUsed){
                        if(compararEstados(listaEstadoLR.get(i), listaEstadoLR.get(j))){
                            estadosParecidos.agregarNuevo(j+1);
                            listaEstadoLR.get(j).isUsed = true;
                        }
                    }
                }
                if(estadosParecidos.getEstadoParecidos().size()>1){
                    listaParecido.add(estadosParecidos);
                }
            }
            
        }
    }
    
    private boolean compararEstados(EstadoLR estado1, EstadoLR estado2){
        boolean isIgual = false;
        if(estado1.getListaProducciones().size()==estado2.getListaProducciones().size()){
            isIgual = false;
            for (int i = 0; i < estado1.getListaProducciones().size(); i++) {
                for (int j = 0; j < estado2.getListaProducciones().size(); j++) {
                    
                    if(compararProducciones(estado1.getListaProducciones().get(i), estado2.getListaProducciones().get(j))){
                        isIgual = true;
                        break;
                    }
                }
                if(!isIgual){
                    return false;
                }
//                if(!compararProducciones(estado1.getListaProducciones().get(i), estado2.getListaProducciones().get(i))){
//                        return false;
//                    }
            }
        }else{
            return false;
        }
        
        return true;
    }
    
    private boolean compararProducciones(Produccion p1, Produccion p2){
        if(p1.getListaExpresiones().equals(p2.getListaExpresiones()) && p1.pivote==(p2.pivote)){
            
            return true;
        }
        return false;
    }
    
    public void desplegarParecidos(){
        System.out.println("\nLista de estados que se parecen: "+listaParecido.size());
        for (int i = 0; i < listaParecido.size(); i++) {
            listaParecido.get(i).desplegarLista();
            System.out.println("");
        }
    }
    
    
}
