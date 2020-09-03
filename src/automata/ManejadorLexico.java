
package automata;

import java.util.ArrayList;
import java.util.LinkedList;

public class ManejadorLexico {
    ArrayList<EstadoAutamata> listaFilasAutomatas;
    ArrayList<String> listaIgnorados = new ArrayList<>();
//    ArrayList<String> listaIgnorados = new ArrayList<>();
        public ArrayList<String> listaErroresLexicos = new ArrayList<>();
    public LinkedList<String> cola;
    String [] arregloCaracteres;
    int posicionArreglo = 0;
    String resultado, nombreTokenActual;

    public ArrayList<EstadoAutamata> getListaFilasAutomatas() {
        return listaFilasAutomatas;
    }

    public void setListaFilasAutomatas(ArrayList<EstadoAutamata> listaFilasAutomatas) {
        this.listaFilasAutomatas = listaFilasAutomatas;
    }
    
    public void iniciar(ArrayList<EstadoAutamata> listaFilasAutomatas ,String texto, ArrayList<String> listaIgnorados){
        this.listaIgnorados = listaIgnorados;
        this.listaFilasAutomatas = listaFilasAutomatas;
        listaErroresLexicos.clear();
        iniciarRecorrido(listaFilasAutomatas, texto);
        cola.offer("$");
    }
    
    
    public void iniciarRecorrido(ArrayList<EstadoAutamata> listaFilasAutomatas, String texto){
        arregloCaracteres = texto.split("");
        cola = new LinkedList<>();
        this.listaFilasAutomatas = listaFilasAutomatas;
        if(getCaracter()!=null){
            if(listaFilasAutomatas.get(0).obtenerTransicion(listaFilasAutomatas.get(0).posicionCaracter)!=0 && listaFilasAutomatas.get(0).comparaCaracter(getCaracter())){
                int transicion = listaFilasAutomatas.get(0).obtenerTransicion(listaFilasAutomatas.get(0).posicionCaracter);
                resultado = getCaracter();
                nombreTokenActual = listaFilasAutomatas.get(0).getListaEstados().get(listaFilasAutomatas.get(0).posicionCaracter).getToken();
                posicionArreglo++;
                if(transicion==0){
                    System.out.println("Transicion: "+transicion+", "+"Reconocio "+nombreTokenActual+"\tToken"+": "+resultado);
                    cola.offer(nombreTokenActual);
                    resultado = "";
                    transicionar(1);
                }else{
                    transicionar(transicion);
                }
            }else{
                if(listaFilasAutomatas.get(0).isAceptacion){
                    System.out.println("Reconocio "+nombreTokenActual+"\tToken"+": "+resultado);
                    cola.offer(nombreTokenActual);
                    resultado = "";
                    //posicionArreglo++;
                    transicionar(1);
                }else{
                    //System.out.println("Letra: "+resultado);
                    if(isIgnorado(getCaracter())){
                        System.out.println("IGNORADO: -"+getCaracter()+"-"); 
                        resultado = "";
                        posicionArreglo++;
                        transicionar(1);
                    }else{
                        System.out.println("Error: -"+getCaracter()+"-"); 
                        listaErroresLexicos.add(getCaracter());
                        resultado = "";
                        posicionArreglo++;
                        transicionar(1);
                    }
                    
                }
            }
        }else{
            if(resultado!=null || !resultado.isEmpty()){
                //System.out.println("Reconocio "+nombreTokenActual+"\tToken"+": "+resultado);
            }
            System.out.println("Final de la cadena");
        }
        
    }
    
    
    public void transicionar(int transicion){
        if(getCaracter()!=null){
            System.out.println("NO. "+transicion+",\tcaracter: "+getCaracter()+""+",\tsig: "+listaFilasAutomatas.get(transicion-1).obtenerTransicion(listaFilasAutomatas.get(transicion-1).posicionCaracter));
            if(listaFilasAutomatas.get(transicion-1).obtenerTransicion(listaFilasAutomatas.get(transicion-1).posicionCaracter)!=0 && listaFilasAutomatas.get(transicion-1).comparaCaracter(getCaracter())){
                int transicionNueva = listaFilasAutomatas.get(transicion-1).obtenerTransicion(listaFilasAutomatas.get(transicion-1).posicionCaracter);
//                resultado += getCaracter();
//                nombreTokenActual = listaFilasAutomatas.get(transicion-1).getListaEstados().get(listaFilasAutomatas.get(transicion-1).posicionCaracter).getToken();
////                System.out.println("estado: s"+transicion+" , "+nombreTokenActual);
//                posicionArreglo++;
                if(transicionNueva==0){
                    System.out.println("Transicion1: "+transicion+", "+"Reconocio "+nombreTokenActual+"\tToken"+": "+resultado);
                    cola.offer(nombreTokenActual);
                    resultado = "";
                    transicionar(1);
                }else{
                    resultado += getCaracter();
                    nombreTokenActual = listaFilasAutomatas.get(transicion-1).getListaEstados().get(listaFilasAutomatas.get(transicion-1).posicionCaracter).getToken();
                    posicionArreglo++;
                        transicionar(transicionNueva);
                }
            }else{
                if(listaFilasAutomatas.get(transicion-1).isAceptacion){
                    System.out.println("Reconocio2 "+nombreTokenActual+"\tToken"+": "+resultado);
                    cola.offer(nombreTokenActual);
                    resultado = "";
                    //posicionArreglo++;
                    transicionar(1);
                }else{
                    //System.out.println("Letra: "+resultado);
                    if(isIgnorado(getCaracter())){
                        System.out.println("IGNORADO: -"+getCaracter()+"-"); 
                        resultado = "";
                        posicionArreglo++;
                        transicionar(1);
                    }else{
                        System.out.println("Error: -"+getCaracter()+"-"); 
                        listaErroresLexicos.add(getCaracter());
                        resultado = "";
                        posicionArreglo++;
                        transicionar(1);
                    }
                }
                
            }
        }else{
            if(resultado!=null && !resultado.isEmpty() && nombreTokenActual!=null){
                System.out.println("Reconocio3 "+nombreTokenActual+"\tToken"+": "+resultado);
                cola.offer(nombreTokenActual);
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
    
    public boolean isIgnorado(String caracter){
        for (int i = 0; i < listaIgnorados.size(); i++) {
//            System.out.println(listaIgnorados.get(i)+"=Comparo="+caracter);
            if(listaIgnorados.get(i).equals(caracter)){
                return true;
            }
        }
        return false;
    }
}
