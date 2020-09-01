/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automata;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author LENOVO-PC
 */
public class EstadoAutamata implements Serializable{
    
    public String nombre, nombreToken;
    boolean isAceptacion;
    int posicionCaracter;
    ArrayList<String> listaCaracteres = new ArrayList<>();
    ArrayList<Integer> listaSig = new ArrayList<>();
    ArrayList<Estado> listaEstados = new ArrayList<>();

//    public EstadoAutamata(String nombre, boolean isAceptacion) {
//        this.nombre = nombre;
//        this.isAceptacion = isAceptacion;
//    }

    public EstadoAutamata(String nombre, String nombreToken, boolean isAceptacion) {
        this.nombre = nombre;
        this.nombreToken = nombreToken;
        this.isAceptacion = isAceptacion;
    }
    
    

    public ArrayList<String> getListaCaracteres() {
        return listaCaracteres;
    }

    public void setListaCaracteres(ArrayList<String> listaCaracteres) {
        this.listaCaracteres = listaCaracteres;
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isIsAceptacion() {
        return isAceptacion;
    }

    public void setIsAceptacion(boolean isAceptacion) {
        this.isAceptacion = isAceptacion;
    }

    public ArrayList<Integer> getListaSig() {
        return listaSig;
    }

    public void setListaSig(ArrayList<Integer> listaSig) {
        this.listaSig = listaSig;
    }

    public ArrayList<Estado> getListaEstados() {
        return listaEstados;
    }

    public void setListaEstados(ArrayList<Estado> listaEstados) {
        this.listaEstados = listaEstados;
    }
    
    public boolean comparaCaracter(String caracter){
        for (int i = 0; i < listaCaracteres.size(); i++) {
            if(listaCaracteres.get(i).equals(caracter)){
                posicionCaracter = i;
                //System.out.println("Encotro: "+caracter);
                return true;
            }
        }
        return false;
    }
    public int obtenerTransicion(int posicion){
        int p = listaEstados.get(posicion).getEstadoSiguiente();
        return p;
    }
    
    
}
