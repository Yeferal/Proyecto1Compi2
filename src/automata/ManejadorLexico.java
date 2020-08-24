
package automata;

import java.util.ArrayList;

public class ManejadorLexico {
    ArrayList<EstadoAutamata> listaFilasAutomatas;
    String [] arregloCaracteres;
    int posicionArreglo = 0;
    String resultado, nombreTokenActual;
    
    public void iniciarRecorrido(ArrayList<EstadoAutamata> listaFilasAutomatas, String texto){
        arregloCaracteres = texto.split("");
        this.listaFilasAutomatas = listaFilasAutomatas;
        if(getCaracter()!=null){
            if(listaFilasAutomatas.get(0).comparaCaracter(getCaracter())){
                int transicion = listaFilasAutomatas.get(0).obtenerTransicion(listaFilasAutomatas.get(0).posicionCaracter);
                resultado = getCaracter();
                nombreTokenActual = listaFilasAutomatas.get(0).getListaEstados().get(listaFilasAutomatas.get(0).posicionCaracter).getToken();
                posicionArreglo++;
                transicionar(transicion);
            }else{
                if(listaFilasAutomatas.get(0).isAceptacion){
                    System.out.println("Reconocio "+nombreTokenActual+"\tToken"+": "+resultado);
                    resultado = "";
                    //posicionArreglo++;
                    transicionar(1);
                }else{
                    //System.out.println("Letra: "+resultado);
                    System.out.println("Error: -"+getCaracter()+"-"); 
                    resultado = "";
                    posicionArreglo++;
                    transicionar(1);
                }
            }
        }else{
            if(resultado!=null || !resultado.isEmpty()){
                System.out.println("Reconocio "+nombreTokenActual+"\tToken"+": "+resultado);
            }
            System.out.println("Final de la cadena");
        }
        
    }
    
    
    public void transicionar(int transicion){
        if(getCaracter()!=null){
            if(listaFilasAutomatas.get(transicion-1).comparaCaracter(getCaracter())){
                int transicionNueva = listaFilasAutomatas.get(transicion-1).obtenerTransicion(listaFilasAutomatas.get(transicion-1).posicionCaracter);
                resultado += getCaracter();
                nombreTokenActual = listaFilasAutomatas.get(transicion-1).getListaEstados().get(listaFilasAutomatas.get(0).posicionCaracter).getToken();
                //System.out.println("estado: s"+transicion+" , "+nombreTokenActual);
                posicionArreglo++;
                transicionar(transicionNueva);
            }else{
                if(listaFilasAutomatas.get(transicion-1).isAceptacion){
                    System.out.println("Reconocio "+nombreTokenActual+"\tToken"+": "+resultado);
                    resultado = "";
                    //posicionArreglo++;
                    transicionar(1);
                }else{
                    //System.out.println("Letra: "+resultado);
                    System.out.println("Error: -"+getCaracter()+"-"); 
                    resultado = "";
                    posicionArreglo++;
                    transicionar(1);
                }
                
            }
        }else{
            if(resultado!=null || !resultado.isEmpty()){
                System.out.println("Reconocio "+nombreTokenActual+"\tToken"+": "+resultado);
            }
            System.out.println("Final de la cadena"); 
        }
    }
    
    public String getCaracter(){
        if(posicionArreglo<arregloCaracteres.length){
            return arregloCaracteres[posicionArreglo];
        }
        return null;
    }
    public String getCaracterExtra(){
        if(posicionArreglo+1<arregloCaracteres.length){
            return arregloCaracteres[posicionArreglo+1];
        }
        return null;
    }
}
