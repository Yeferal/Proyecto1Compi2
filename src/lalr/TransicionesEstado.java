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
public class TransicionesEstado {
    
    public ArrayList<TransicionLR> listaTransiciones = new ArrayList<>();
    int numero;
    String nombreEstado;
    boolean verificado;
    int tamanio;
    public TransicionesEstado(int numero, String nombreEstado, int tamanio) {
        this.numero = numero;
        this.nombreEstado = nombreEstado;
        verificado = false;
        this.tamanio = tamanio;
        generarEstadoTotales(tamanio);
    }
    
    public ArrayList<TransicionLR> getTablaTransiciones() {
        return listaTransiciones;
    }

    public void setTablaTransiciones(ArrayList<TransicionLR> tablaTransiciones) {
        this.listaTransiciones = tablaTransiciones;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }
    
    public void generarEstadoTotales(int tamanio){
        for (int i = 0; i < tamanio; i++) {
            listaTransiciones.add(null);
        }
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
    
    
    
    public void despleagar(){
        System.out.print(numero+".  \t"+nombreEstado+"\t\t");
        for (int i = 0; i < listaTransiciones.size(); i++) {
            if(listaTransiciones.get(i)==null){
                System.out.print("--"+"\t");
            }else{
                System.out.print(listaTransiciones.get(i).getTipoTransicion()+"\t");
            }
            
        }
    }
}
