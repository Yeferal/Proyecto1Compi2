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
    
    public ArrayList<TransicionesEstado> tablaTransiciones = new ArrayList<>();
    private GenerarTablaLALR  generarTablaLALR = new GenerarTablaLALR();
    TablaTerminalesNoT tablaTerminalesNoT;
    ArrayList<EstadoLR> listaEstadoLR;
    int tamanio;
    boolean isCorrectoLR1 = true;
    
    public void generarTabla(ArrayList<EstadoLR> listaEstadoLR, TablaTerminalesNoT tablaTerminalesNoT){
        this.listaEstadoLR = listaEstadoLR;
        this.tablaTerminalesNoT = tablaTerminalesNoT;
        isCorrectoLR1 = true;
        tamanio = tablaTerminalesNoT.getTerminales().size()+tablaTerminalesNoT.getNoTerminales().size()+1;
        buscarTransicionesAtEstado();
        desplegarFilaTerminalesNT();
        desplegarFila();
        //generarTablaLALR.iniciarRecorrido(tablaTransiciones, listaEstadoLR);
        //desplegarFilaTerminalesNT();
        //generarTablaLALR.despleagarNuevaTabla();
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
                aux.setTokenTransicion(aux.getTokenTransicion()+"/"+actual.getListaTransicionesLR().get(i).getTokenTransicion());
                nuevaFila.listaTransiciones.set(posicion, aux);
            }else{
                nuevaFila.listaTransiciones.set(posicion, actual.getListaTransicionesLR().get(i));
            }
            
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
        System.out.print("\t\t\t");
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
