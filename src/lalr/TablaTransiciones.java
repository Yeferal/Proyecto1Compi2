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
public class TablaTransiciones {
    
    private ArrayList<TransicionesEstado> tablaTransiciones = new ArrayList<>();
    TablaTerminalesNoT tablaTerminalesNoT;
    ArrayList<EstadoLR> listaEstadoLR;
    int tamanio;
    
    public void generarTabla(ArrayList<EstadoLR> listaEstadoLR, TablaTerminalesNoT tablaTerminalesNoT){
        this.listaEstadoLR = listaEstadoLR;
        this.tablaTerminalesNoT = tablaTerminalesNoT;
        tamanio = tablaTerminalesNoT.getTerminales().size()+tablaTerminalesNoT.getNoTerminales().size()+1;
        buscarTransicionesAtEstado();
        desplegarFilaTerminalesNT();
        desplegarFila();
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
            nuevaFila.listaTransiciones.get(buscarPosicion(actual.getListaTransicionesLR().get(i)));
            nuevaFila.listaTransiciones.set(buscarPosicion(actual.getListaTransicionesLR().get(i)), actual.getListaTransicionesLR().get(i));
        }
    }
    
    private int buscarPosicion(TransicionLR transicionLR){
        int pos = tablaTerminalesNoT.getTerminales().size();
        if(transicionLR.getTipo()==1){
            for (int i = 0; i < tablaTerminalesNoT.getTerminales().size(); i++) {
                if(tablaTerminalesNoT.getTerminales().get(i).equals(transicionLR.getTokenTransicion())){
                    return i;
                }
            }
        }else if(transicionLR.getTipo()==2){
            for (int i = 0; i < tablaTerminalesNoT.getNoTerminales().size(); i++) {
                if(tablaTerminalesNoT.getNoTerminales().get(i).equals(transicionLR.getTokenTransicion())){
                    return i+tablaTerminalesNoT.getTerminales().size()+1;
                }
            }
        }else if(transicionLR.getTipo()==0){
            return pos;
        }else if(transicionLR.getTipo()==3){
            for (int i = 0; i < tablaTerminalesNoT.getTerminales().size(); i++) {
                if(tablaTerminalesNoT.getTerminales().get(i).equals(transicionLR.getTokenTransicion())){
                    return i;
                }
            }
        }
        return pos;
    }
    
    
    public void desplegarFilaTerminalesNT(){
        System.out.println("");
        System.out.print("\t\t");
        for (int i = 0; i < tablaTerminalesNoT.getTerminales().size(); i++) {
            System.out.print(tablaTerminalesNoT.getTerminales().get(i)+"\t");
        }
        System.out.print("$\t");
        for (int i = 0; i < tablaTerminalesNoT.getNoTerminales().size(); i++) {
            System.out.print(tablaTerminalesNoT.getNoTerminales().get(i)+"\t");
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
