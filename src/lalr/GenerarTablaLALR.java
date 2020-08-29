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
public class GenerarTablaLALR {
    
    
    private ArrayList<TransicionesEstado> tablaTransiciones;
    private ArrayList<TransicionesEstado> tablaTransicionesNueva;
    private ArrayList<EstadoLR> listaEstadoLR;
    private ArrayList<EstadosParecidos> listaParecido;
    private ArrayList<EstadosParecidos> listaParecidoConfirmados;
    boolean encontro;
    
    public void iniciarRecorrido(ArrayList<TransicionesEstado> tablaTransiciones, ArrayList<EstadoLR> listaEstadoLR){
        this.tablaTransiciones = copiarTabla(tablaTransiciones);
        this.listaEstadoLR = listaEstadoLR;
        encontro = false;
        listaParecido = new ArrayList<>();
        listaParecidoConfirmados = new ArrayList<>();
        tablaTransicionesNueva = new ArrayList<>();
        buscarParecidos();
        desplegarParecidos();
        
        cambiaParecidos();
        
        generarConfirmacionParecidos();
        desplegarParecidosConfirmados();
        
        this.tablaTransiciones = copiarTabla(tablaTransiciones);
        
        iniciarUnion();
//        desplegarParecidosConfirmados();
        //tablaTransicionesNueva = copiarTabla(this.tablaTransiciones);
        //despleagarNuevaTabla();
        
    }
    
   
    public void buscarParecidos(){
        int pos = 1;
        for (int i = 0; i < listaEstadoLR.size(); i++) {
            if(!listaEstadoLR.get(i).isUsed){
                EstadosParecidos estadosParecidos = new EstadosParecidos();
                estadosParecidos.agregarNuevo(i+1);
                estadosParecidos.setId(pos);
                for (int j = i+1; j < listaEstadoLR.size(); j++) {
                    if(!listaEstadoLR.get(j).isUsed){
                        if(compararEstados(listaEstadoLR.get(i), listaEstadoLR.get(j))){
                            estadosParecidos.agregarNuevo(j+1);
                            listaEstadoLR.get(j).isUsed = true;
                        }else{
                            
                        }
                    }
                }
                if(estadosParecidos.getEstadoParecidos().size()>0){
                    listaParecido.add(estadosParecidos);
                }
                pos++;
            }
            
        }
        
        if(listaParecido.size()>0){
            encontro = true;
        }
    }
    
    private boolean compararEstados(EstadoLR estado1, EstadoLR estado2){
        boolean isIgual = false;
        if(estado1.getListaProducciones().size()==estado2.getListaProducciones().size()){
            isIgual = false;
            for (int i = 0; i < estado1.getListaProducciones().size(); i++) {
                for (int j = 0; j < estado2.getListaProducciones().size(); j++) {
                    
                    if(compararProducciones(estado1.getListaProducciones().get(i), estado2.getListaProducciones().get(j))){
                        isIgual = true;
                        break;
                    }
                }
                if(!isIgual){
                    return false;
                }
//                if(!compararProducciones(estado1.getListaProducciones().get(i), estado2.getListaProducciones().get(i))){
//                        return false;
//                    }
            }
        }else{
            return false;
        }
        
        return true;
    }
    
    private boolean compararProducciones(Produccion p1, Produccion p2){
        if(p1.getListaExpresiones().equals(p2.getListaExpresiones()) && p1.pivote==(p2.pivote)){
            
            return true;
        }
        return false;
    }
    
    private void cambiaParecidos(){
        for (int i = 0; i < tablaTransiciones.size(); i++) {
            
            for (int j = 0; j < tablaTransiciones.get(i).getTablaTransiciones().size(); j++) {
                if(tablaTransiciones.get(i).getTablaTransiciones().get(j)!=null){
                    int numeroActual = tablaTransiciones.get(i).getTablaTransiciones().get(j).getNumIrA();
                    tablaTransiciones.get(i).getTablaTransiciones().get(j).setNumIrA(encontraNuevoId(numeroActual));
                }
            }
        }
    }
    
    private int encontraNuevoId(int numeroActual){
        for (int i = 0; i < listaParecido.size(); i++) {
            
            for (int j = 0; j < listaParecido.get(i).getEstadoParecidos().size(); j++) {
                if(listaParecido.get(i).getEstadoParecidos().get(j)==numeroActual){
                    return listaParecido.get(i).getId();
                }
            }
            
        }
        return 0;
    }
    
    private void iniciarUnion(){
        if(encontro){
            busquedaUnion();
            //despleagarNuevaTabla();
        }else{
            System.out.println("No encontro estados parecidos para unir");
        }
    }
    
    
    private void generarConfirmacionParecidos(){
        int posicion = 1;
        for (int i = 0; i < tablaTransiciones.size(); i++) {
            if(!tablaTransiciones.get(i).verificado){
                for (int j = 0; j < listaParecido.size(); j++) {
                    if(!listaParecido.get(j).verificado){
                       if(tablaTransiciones.get(i).numero==listaParecido.get(j).getEstadoParecidos().get(0)){
                            TransicionesEstado nuevaFila = new TransicionesEstado(posicion, listaParecido.get(j).toString(),tablaTransiciones.get(i).getTamanio());
                            confirmarParecido(listaParecido.get(j), nuevaFila, tablaTransiciones.get(i),posicion);
                            listaParecido.get(j).verificado = true;
                            break;
                        }else{
                            tablaTransiciones.get(i).verificado = true;
                            EstadosParecidos e1 = new EstadosParecidos();
                            e1.agregarNuevo(tablaTransiciones.get(i).numero);
                            e1.setId(posicion);
                            listaParecidoConfirmados.add(e1);
                            break;
                        } 
                    }
                }
                posicion++;
            }
            
        }
        for (int i = 0; i < tablaTransiciones.size(); i++) {
             tablaTransiciones.get(i).verificado = false;
        }
    }
    
    private void confirmarParecido(EstadosParecidos e, TransicionesEstado nuevaFila, TransicionesEstado actualFila, int posicion){
        boolean isCorrecto = true;
        boolean isUnir = true;
        for (int i = 0; i < e.getEstadoParecidos().size(); i++) {
            for (int j = 0; j < nuevaFila.getTablaTransiciones().size(); j++) {
                if(tablaTransiciones.get(e.getEstadoParecidos().get(i)-1).getTablaTransiciones().get(j)==null){
                    //aceptado
                    
                }else if(nuevaFila.getTablaTransiciones().get(j)==null && tablaTransiciones.get(e.getEstadoParecidos().get(i)-1).getTablaTransiciones().get(j)!=null){
                    //aceptado
                    
                }else if(nuevaFila.getTablaTransiciones().get(j)!=null && tablaTransiciones.get(e.getEstadoParecidos().get(i)-1).getTablaTransiciones().get(j)!=null){
                    //no aceptado
                    if(nuevaFila.getTablaTransiciones().get(j).equals(tablaTransiciones.get(e.getEstadoParecidos().get(i)-1).getTablaTransiciones().get(j))){
                        
                    }else{
                        isCorrecto = false;
                        break;
                    }
                }
            }
            if(!isCorrecto){
                isUnir = false;
                break;
            }
            
        }
        
        if(isUnir){
            EstadosParecidos e1 = new EstadosParecidos();
            for (int i = 0; i < e.getEstadoParecidos().size(); i++) {
                tablaTransiciones.get(e.getEstadoParecidos().get(i)-1).verificado = true; 
                e1.agregarNuevo(e.getEstadoParecidos().get(i));
                
            }
            e1.setId(posicion);
            listaParecidoConfirmados.add(e1);
        }else{
            EstadosParecidos e1 = new EstadosParecidos();
            e1.agregarNuevo(e.getEstadoParecidos().get(0));
            e1.setId(posicion);
            listaParecidoConfirmados.add(e1);
        }
        
    }
    
    private void busquedaUnion(){
        int posicion = 1;
        
        for (int i = 0; i < tablaTransiciones.size(); i++) {
            if(!tablaTransiciones.get(i).verificado){
                for (int j = 0; j < listaParecidoConfirmados.size(); j++) {
                    if(!listaParecidoConfirmados.get(j).verificado){
                        if(tablaTransiciones.get(i).numero==listaParecidoConfirmados.get(j).getEstadoParecidos().get(0)){
                            TransicionesEstado nuevaFila = new TransicionesEstado(posicion, listaParecidoConfirmados.get(j).toString(),tablaTransiciones.get(i).getTamanio());
                            unir(listaParecidoConfirmados.get(j), nuevaFila, tablaTransiciones.get(i),posicion);
                            listaParecidoConfirmados.get(j).verificado = true;
                            
                            break;
                        }else{
                            tablaTransiciones.get(i).verificado = true;
                            //tablaTransicionesNueva.add(tablaTransiciones.get(i));
                            
                            break;
                        }
                        
                    }
                }
                posicion++;
                
            }
        }
    }
    
    private void unir(EstadosParecidos e, TransicionesEstado nuevaFila, TransicionesEstado actualFila, int posicion){
        boolean isCorrecto = true;
        boolean isUnir = true;
        for (int i = 0; i < e.getEstadoParecidos().size(); i++) {
            for (int j = 0; j < nuevaFila.getTablaTransiciones().size(); j++) {
                //System.out.print("fILA: "+tablaTransiciones.get(e.getEstadoParecidos().get(i)-1).getTablaTransiciones().get(j));
                if(tablaTransiciones.get(e.getEstadoParecidos().get(i)-1).getTablaTransiciones().get(j)==null){
                    //aceptado
                    
                }else if(nuevaFila.getTablaTransiciones().get(j)==null && tablaTransiciones.get(e.getEstadoParecidos().get(i)-1).getTablaTransiciones().get(j)!=null){
                    //aceptado
                    nuevaFila.getTablaTransiciones().set(j, tablaTransiciones.get(e.getEstadoParecidos().get(i)-1).getTablaTransiciones().get(j));
                }else if(nuevaFila.getTablaTransiciones().get(j)!=null && tablaTransiciones.get(e.getEstadoParecidos().get(i)-1).getTablaTransiciones().get(j)!=null){
                    //no aceptado
                    boolean isTipo =  nuevaFila.getTablaTransiciones().get(j).getTipo()==tablaTransiciones.get(e.getEstadoParecidos().get(i)-1).getTablaTransiciones().get(j).getTipo();
                    boolean isNumeroIrA = nuevaFila.getTablaTransiciones().get(j).getNumIrA()==tablaTransiciones.get(e.getEstadoParecidos().get(i)-1).getTablaTransiciones().get(j).getNumIrA();
                    
                    if(isTipo && isNumeroIrA){
                        
                    }else{
                        isCorrecto = false;
                        break;
                    }
                    
                }
                
            }
            if(!isCorrecto){
                isUnir = false;
                break;
            }
            
        }
        
        if(isUnir){
            tablaTransicionesNueva.add(nuevaFila);
            for (int i = 0; i < e.getEstadoParecidos().size(); i++) {
                tablaTransiciones.get(e.getEstadoParecidos().get(i)-1).verificado = true;  
            }
        }else{
            actualFila.setNumero(posicion);
            actualFila.verificado = true;
            tablaTransicionesNueva.add(actualFila);
        }

    }
    
    
    public void desplegarParecidos(){
        System.out.println("\nLista de estados que se parecen: "+listaParecido.size());
        for (int i = 0; i < listaParecido.size(); i++) {
            listaParecido.get(i).desplegarLista();
            System.out.println("");
        }
    }
    
    public void desplegarParecidosConfirmados(){
        System.out.println("\nLista de estados que se parecen Comfirmados: "+listaParecidoConfirmados.size());
        for (int i = 0; i < listaParecidoConfirmados.size(); i++) {
            listaParecidoConfirmados.get(i).desplegarLista();
            System.out.println("");
        }
    }
    
    public void despleagarNuevaTabla(){
        for (int i = 0; i < tablaTransicionesNueva.size(); i++) {
            tablaTransicionesNueva.get(i).despleagar();
            System.out.println("");
        }
    }
    
    
    private ArrayList<TransicionesEstado> copiarTabla(ArrayList<TransicionesEstado> tabla){
        ArrayList<TransicionesEstado> nueva = new ArrayList<>();
        for (int i = 0; i < tabla.size(); i++) {
            TransicionesEstado aux = new TransicionesEstado(tabla.get(i).getNumero(), tabla.get(i).getNombreEstado(), tabla.get(i).getTamanio());
            for (int j = 0; j < tabla.get(i).getTablaTransiciones().size(); j++) {
                if(tabla.get(i).getTablaTransiciones().get(j)!=null){
                    aux.getTablaTransiciones().set(j, tabla.get(i).getTablaTransiciones().get(j));
                }
            }
            nueva.add(aux);
        }
        
        return nueva;
    }
}
