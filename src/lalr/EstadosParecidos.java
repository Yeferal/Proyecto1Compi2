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
public class EstadosParecidos implements Serializable{
    
    ArrayList<Integer> estadoParecidos;
    boolean verificado;
    int id;
    
    public EstadosParecidos() {
        estadoParecidos = new ArrayList<>();
        verificado = false;
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

    public boolean isVerificado() {
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String toString(){
        String texto = "";
        texto = estadoParecidos.get(0)+"";
        for (int i = 1; i < estadoParecidos.size(); i++) {
            texto += "y"+estadoParecidos.get(i);
        }
        return texto;
    }
    
    
    
    public void desplegarLista(){
        System.out.print(id+". "+estadoParecidos.get(0));
        for (int i = 1; i < estadoParecidos.size(); i++) {
            System.out.print("y"+estadoParecidos.get(i));
        }
    }
    
}
