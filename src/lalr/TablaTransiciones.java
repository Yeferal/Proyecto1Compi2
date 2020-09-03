/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lalr;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author LENOVO-PC
 */
public class TablaTransiciones implements Serializable{
    
    public ArrayList<TransicionesEstado> tablaTransiciones = new ArrayList<>();
    private GenerarTablaLALR  generarTablaLALR = new GenerarTablaLALR();
    private TablaProducciones tablaProducciones;
    TablaTerminalesNoT tablaTerminalesNoT;
    ArrayList<EstadoLR> listaEstadoLR;
    int tamanio;
    boolean isCorrectoLR1 = true;
    
    public void generarTabla(ArrayList<EstadoLR> listaEstadoLR, TablaTerminalesNoT tablaTerminalesNoT, TablaProducciones tablaProducciones){
        this.listaEstadoLR = listaEstadoLR;
        this.tablaTerminalesNoT = tablaTerminalesNoT;
        this.tablaProducciones = tablaProducciones;
        isCorrectoLR1 = true;
        tamanio = tablaTerminalesNoT.getTerminales().size()+tablaTerminalesNoT.getNoTerminales().size()+1;
        buscarTransicionesAtEstado();
        desplegarFilaTerminalesNT();
        desplegarFila();
        generarTablaLALR.iniciarRecorrido(tablaTransiciones, listaEstadoLR);
        //desplegarFilaTerminalesNT();
        generarTablaLALR.despleagarNuevaTabla();
        tablaTransiciones = generarTablaLALR.tablaTransicionesNueva;
    }
    
    public void buscarTransicionesAtEstado(){
        for (int i = 0; i < listaEstadoLR.size(); i++) {
            TransicionesEstado nuevaFila = new TransicionesEstado(i+1, (i+1)+"", tamanio);
            buscarTransiciones(listaEstadoLR.get(i), nuevaFila);
            tablaTransiciones.add(nuevaFila);
        }
    }
    
    private void buscarTransiciones(EstadoLR actual, TransicionesEstado nuevaFila){
        for (int i = 0; i < actual.getListaTransicionesLR().size(); i++) {
            int posicion = buscarPosicion(actual.getListaTransicionesLR().get(i));
            
            if(nuevaFila.listaTransiciones.get(posicion)!=null){
                isCorrectoLR1 = false;
                TransicionLR aux = nuevaFila.listaTransiciones.get(posicion);
                TransicionLR auxNuevo = actual.getListaTransicionesLR().get(i);
                //aux.setTokenTransicion(aux.getTipoTransicion()+"/"+actual.getListaTransicionesLR().get(i).getTipoTransicion());
                nuevaFila.listaTransiciones.set(posicion, aux);
                int nivelA = 0, nivelB = 0;
                System.out.println("00000000000000000000000000000000000000000");
                System.out.println("Aux");
                if(aux.getTipo()==1){
                    nivelA = listaEstadoLR.get(aux.getNumIrA()-1).getListaProducciones().get(0).getNivel();
                    System.out.print("ES un shift: "+listaEstadoLR.get(aux.getNumIrA()-1).getListaProducciones().get(0).getNombreNoTerminal()+" -> ");
                    listaEstadoLR.get(aux.getNumIrA()-1).getListaProducciones().get(0).desplegarExpresiones();
                    System.out.println();
                }else if(aux.getTipo()==3){
                    nivelA = tablaProducciones.listaProducciones.get(aux.getNumIrA()).getNivel();
                    System.out.print("ES un reduce: "+tablaProducciones.listaProducciones.get(aux.getNumIrA()).getNombreNoTerminal()+" -> ");
                    tablaProducciones.listaProducciones.get(aux.getNumIrA()).desplegarExpresiones();
                    System.out.println();
                }
                
                System.out.println("VERSUS");
                if(auxNuevo.getTipo()==1){
                    nivelB = listaEstadoLR.get(auxNuevo.getNumIrA()-1).getListaProducciones().get(0).getNivel();
                    System.out.print("ES un shift: "+listaEstadoLR.get(auxNuevo.getNumIrA()-1).getListaProducciones().get(0).getNombreNoTerminal()+" -> ");
                    listaEstadoLR.get(auxNuevo.getNumIrA()-1).getListaProducciones().get(0).desplegarExpresiones();
                    System.out.println("\tnivel: "+listaEstadoLR.get(auxNuevo.getNumIrA()-1).getListaProducciones().get(0).getNivel());
                }else if(auxNuevo.getTipo()==3){
                    nivelB = tablaProducciones.listaProducciones.get(aux.getNumIrA()).getNivel();
                    System.out.print("ES un reduce: "+tablaProducciones.listaProducciones.get(aux.getNumIrA()).getNombreNoTerminal()+" -> ");
                    tablaProducciones.listaProducciones.get(aux.getNumIrA()).desplegarExpresiones();
                    System.out.println("\tnivel: "+tablaProducciones.listaProducciones.get(aux.getNumIrA()).getNivel());
                }
                System.out.println("AuxNuevo");
                if(nivelA==nivelB){
                    if(auxNuevo.getTipo()==1){
                        System.out.println("Dejamos el aux, ya que es un reduce");
                        nuevaFila.listaTransiciones.set(posicion, aux);
                    }else{
                        System.out.println("Dejamos el auxNuevo, ya que es un reduce");
                        nuevaFila.listaTransiciones.set(posicion, auxNuevo);
                    }
                }else{
                    if(nivelA<nivelB){
                        System.out.println("Dejamos el auxNuevo, ya que es de un nivel mayor");
                        nuevaFila.listaTransiciones.set(posicion, auxNuevo);
                    }else{
                        System.out.println("Dejamos el aux, ya que es de un nivel mayor");
                        nuevaFila.listaTransiciones.set(posicion, aux);
                    }
                }
                
            }else{
                nuevaFila.listaTransiciones.set(posicion, actual.getListaTransicionesLR().get(i));
            }
            
        }
    }
    
    private int buscarPosicion(TransicionLR transicionLR){
        int pos = tablaTerminalesNoT.getTerminales().size();
        if(transicionLR.getTipo()==1){
            for (int i = 0; i < tablaTerminalesNoT.getTerminales().size(); i++) {
                if(tablaTerminalesNoT.getTerminales().get(i).getNombre().equals(transicionLR.getTokenTransicion())){
                    return i;
                }
            }
        }else if(transicionLR.getTipo()==2){
            for (int i = 0; i < tablaTerminalesNoT.getNoTerminales().size(); i++) {
                if(tablaTerminalesNoT.getNoTerminales().get(i).getNombre().equals(transicionLR.getTokenTransicion())){
                    return i+tablaTerminalesNoT.getTerminales().size()+1;
                }
            }
        }else if(transicionLR.getTipo()==0){
            return pos;
        }else if(transicionLR.getTipo()==3){
            for (int i = 0; i < tablaTerminalesNoT.getTerminales().size(); i++) {
                if(tablaTerminalesNoT.getTerminales().get(i).getNombre().equals(transicionLR.getTokenTransicion())){
                    return i;
                }
            }
        }
        return pos;
    }
    
    
    public void desplegarFilaTerminalesNT(){
        System.out.println("");
        System.out.print("\t\t\t");
        for (int i = 0; i < tablaTerminalesNoT.getTerminales().size(); i++) {
            System.out.print(tablaTerminalesNoT.getTerminales().get(i).getNombre()+"\t");
        }
        System.out.print("$\t");
        for (int i = 0; i < tablaTerminalesNoT.getNoTerminales().size(); i++) {
            System.out.print(tablaTerminalesNoT.getNoTerminales().get(i).getNombre()+"\t");
        }
        System.out.println("");
    }
    public void desplegarFila(){
        for (int i = 0; i < tablaTransiciones.size(); i++) {
            tablaTransiciones.get(i).despleagar();
            System.out.println("");
        }
    }
    
}
