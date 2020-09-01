/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lalr;

import java.util.ArrayList;
import objetos.ExpresionRegular;

/**
 *
 * @author LENOVO-PC
 */
public class ManejadorDatos {
    
    
    public boolean buscarExpresionExistente(ArrayList<ExpresionRegular> listaExp, ExpresionRegular expNueva){
        for (int i = 0; i < listaExp.size(); i++) {
            if(listaExp.get(i).getNombre().equals(expNueva.getNombre())){
                return false;
            }
        }
        return true;
    }
    public boolean buscarExpresionExistenteN(ArrayList<ExpresionRegular> listaExp, String nombre){
        for (int i = 0; i < listaExp.size(); i++) {
            if(listaExp.get(i).getNombre().equals(nombre)){
                return true;
            }
        }
        return false;
    }
    
}
