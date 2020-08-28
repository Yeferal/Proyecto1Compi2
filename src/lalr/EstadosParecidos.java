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
public class EstadosParecidos {
    
    ArrayList<Integer> estadoParecidos;
    
    
    public EstadosParecidos() {
        estadoParecidos = new ArrayList<>();
    }
    
    public void agregarNuevo(int numero){
        estadoParecidos.add(numero);
    }

    public ArrayList<Integer> getEstadoParecidos() {
        return estadoParecidos;
    }

    public void setEstadoParecidos(ArrayList<Integer> estadoParecidos) {
        this.estadoParecidos = estadoParecidos;
    }
    
    public void desplegarLista(){
        System.out.print("Estados: "+estadoParecidos.get(0));
        for (int i = 1; i < estadoParecidos.size(); i++) {
            System.out.print("y"+estadoParecidos.get(i));
        }
    }
    
}
