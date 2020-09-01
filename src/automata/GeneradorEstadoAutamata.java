
package automata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import objetos.Arbol;
import objetos.Siguiente;

public class GeneradorEstadoAutamata implements Serializable{
    
    public ArrayList<String> listaCaracteres = new ArrayList<>();
    public ArrayList<EstadoAutamata> listaFilasAutomatas = new ArrayList<>();
    public ArrayList<Siguiente> tablaSig = new ArrayList<>();
    int bandera;
    //Comparator<Integer> comparador = Collections.reverseOrder();
    
    int contador, estadoAcep;
    
    public void generarEstados(Arbol arbol){
        contador = 1;
        listaCaracteres = arbol.tablaS.listaCaracteres; //lista de caracteres posibles
        tablaSig = arbol.tablaS.tablaSig;               //tabla de siguientes
        
        listaFilasAutomatas.clear();
        ArrayList<Integer> primerosRaiz = arbol.getRaiz().getPrimeros();
        estadoAcep = arbol.tablaS.tablaSig.size();
        arbol.tablaS.desplegarTabla();
        listaFilasAutomatas.add(new EstadoAutamata("S"+contador,tablaSig.get(primerosRaiz.get(0)).nombreToken, isEstadoAceptacion(primerosRaiz, estadoAcep)));
        listaFilasAutomatas.get(0).setListaSig(primerosRaiz);
        //contador++;
        int nu = listaFilasAutomatas.size();
        for (int i = 0; i < nu; i++) {
            //System.out.println(nu);
            verificarCaracteresAceptacion(listaFilasAutomatas.get(i));
            //System.out.println(listaFilasAutomatas.get(i).getNombre()+"  "+listaFilasAutomatas.get(i).getListaEstados().get(0).getCaracter()+","+listaFilasAutomatas.get(i).getListaEstados().get(0).getEstadoSiguiente());
            nu = listaFilasAutomatas.size();
            //System.out.println(nu);
        }
        despleagar();
        copiarCaracteres();
    }
    
    public void copiarCaracteres(){
        for (int i = 0; i < listaFilasAutomatas.size(); i++) {
            listaFilasAutomatas.get(i).setListaCaracteres(listaCaracteres);
        }
    }
    
    public void despleagar(){
        System.out.print("\t\t\t");
        for (int i = 0; i < listaCaracteres.size(); i++) {
            System.out.print(listaCaracteres.get(i)+",\t");
        }
        System.out.println("\n");
        for (int i = 0; i < listaFilasAutomatas.size(); i++) {
            System.out.print(listaFilasAutomatas.get(i).nombreToken+"\t"+listaFilasAutomatas.get(i).isAceptacion+" > "+listaFilasAutomatas.get(i).nombre+"\t");
            for (int j = 0; j < listaFilasAutomatas.get(i).listaEstados.size(); j++) {
                //System.out.print(listaFilasAutomatas.get(i).listaEstados.get(j).getCaracter()+",");
                System.out.print(listaFilasAutomatas.get(i).listaEstados.get(j).getEstadoSiguiente()+","+listaFilasAutomatas.get(i).listaEstados.get(j).getToken()+"\t");
            }
            System.out.println("\n");
        }
    }
    
    
    public boolean isEstadoAceptacion(ArrayList<Integer> listaSig, int aceptacion){
        for (int i = 0; i < listaSig.size(); i++) {
            if(listaSig.get(i)==aceptacion){
                return true;
            }
        }
        return false;
    }
    
    public void verificarCaracteresAceptacion(EstadoAutamata estadoAutamata){
        //System.out.println("lisCC: "+listaCaracteres);
        for (int i = 0; i < listaCaracteres.size(); i++) {
            ArrayList<Integer> n = new ArrayList<>();
            //System.out.println("lis: "+estadoAutamata.listaSig);
            for (int j = 0; j < estadoAutamata.listaSig.size(); j++) {
                if (compararCaracteres(tablaSig.get(estadoAutamata.listaSig.get(j)-1).getNodoFinal().listaCaracteres, listaCaracteres.get(i))) {
                    n.add(estadoAutamata.listaSig.get(j));
                    
                }
            }
            
            if(n.size()!=0){
                //System.out.println("n{"+n+"}"+"  "+listaCaracteres.get(i));
                agregarU(n,i,estadoAutamata, listaCaracteres.get(i));
            }else{
                
                estadoAutamata.getListaEstados().add(new Estado(listaCaracteres.get(i), 0,null));
            }
        }
        
    }
    
    public boolean compararCaracteres(ArrayList<String> listaCaracteresEstado, String caracterBuscado){
        for (int i = 0; i < listaCaracteresEstado.size(); i++) {
            if (listaCaracteresEstado.get(i).equals(caracterBuscado)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean compararListaEstadosPosibles(ArrayList<Integer> u, int pos){
        
        for (int i = 0; i < u.size(); i++) {
            if (u.get(i)==pos) {
                return true;
            }
        }
        return false;
    }
    
    public void agregarU(ArrayList<Integer> n, int numero, EstadoAutamata estadoAutamata, String carac){
         ArrayList<Integer> u = new ArrayList<>();
         //System.out.println("nn "+n);
         for (int i = 0; i < n.size(); i++) {
             //System.out.println("Estado "+n.get(i)+"::=  "+tablaSig.get(n.get(i)-1).getListaSiguientes());
             for (int j = 0; j < tablaSig.get(n.get(i)-1).getListaSiguientes().size(); j++) {
                 //System.out.println(tablaSig.get(n.get(i)-1).getListaSiguientes().get(j)+" != "+u);
                 if(!compararListaEstadosPosibles(u, tablaSig.get(n.get(i)-1).getListaSiguientes().get(j))){
                     u.add(tablaSig.get(n.get(i)-1).getListaSiguientes().get(j));
                 }
             }
        }
        ordenar(u);
        if(verificarExistenciaU(u)){
            contador++;
            //System.out.println("La ultimos que se agregan son: "+"S"+contador+" > "+u + "\tpara: "+carac);
            
            EstadoAutamata es = new EstadoAutamata("S"+contador,tablaSig.get(n.get(0)-1).nombreToken, isEstadoAceptacion(u, estadoAcep));
            //es.nombreToken = 
            es.setListaCaracteres(listaCaracteres);
            es.setListaSig(u);
            listaFilasAutomatas.add(es);
            estadoAutamata.getListaEstados().add(new Estado(carac, contador,tablaSig.get(n.get(0)-1).nombreToken));
            
        }else{
            //System.out.println("La ultimos que ya existen son: "+"S"+bandera+" > "+u);
            estadoAutamata.getListaEstados().add(new Estado(carac, bandera,tablaSig.get(n.get(0)-1).nombreToken));
        }
    }
    
    public void ordenar(ArrayList<Integer> u){
        Collections.sort(u);
    }
    
    public boolean verificarExistenciaU(ArrayList<Integer> u){
        for (int i = 0; i < listaFilasAutomatas.size(); i++) {
            if(listaFilasAutomatas.get(i).listaSig.equals(u)){
                bandera = i+1;
                return false;
            }
        }
        return true;
    }
    
}