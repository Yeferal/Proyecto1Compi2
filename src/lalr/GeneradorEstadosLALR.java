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
public class GeneradorEstadosLALR {
    
    public ArrayList<EstadoLR> listaEstadoLR = new ArrayList<>();
    ArrayList<Produccion> listaProducciones;
    EstadoLR estadoAux, estadoAux2;
    ArrayList<String> auxSimbolos = new ArrayList<>();
    TablaTerminalesNoT tablaTerminalesNoT = new TablaTerminalesNoT();
    private int posicionEstado;
    
    
    public void inciarEstado(ArrayList<Produccion> listaProducciones, TablaTerminalesNoT tablaTerminalesNoT){
        this.listaProducciones = listaProducciones;
        this.tablaTerminalesNoT = tablaTerminalesNoT;
        pintarProducciones();
        if(listaProducciones.size()>0){
           if(listaProducciones.get(0).getId()==0){
               if(listaProducciones.get(0).listaExpresiones.get(0).getTipo()==2){
                   estadoAux = new EstadoLR();
                   estadoAux.getListaProducciones().add(copiarProduccion(listaProducciones.get(0))); //AGREGA EL  PRIMER ESTADO INICIAL
                   
                   if(listaProducciones.get(0).isLimit()){
                       auxSimbolos.clear();
                       analizarEstadoAnalisis(estadoAux.listaProducciones.get(0).listaExpresiones.get(0).nombre); // Agraga todas la producciones que pertenescan la expresion analisada
                       generarSimbolosPreAnalisis(estadoAux.listaProducciones.get(0).listaExpresiones.get(1));  //agrega los simbolos de pre analisis a . x B   ====B primeros
                       agregarSimbolosPreAnalisisEstados(estadoAux.listaProducciones.get(0).listaExpresiones.get(0).nombre); // agrega los simbolos de preAnalisis a todas las producciones encontradas.
                   }
               }
           }else{
               
           }
        }
        
        for (int i = 1; i < estadoAux.listaProducciones.size(); i++) {
            estadoAux.listaProducciones.get(i).id = i;
            if(estadoAux.listaProducciones.get(i).listaExpresiones.get(0).getTipo()!=1){
                if(estadoAux.listaProducciones.get(i).isLimit()){
                    auxSimbolos.clear();
                    analizarEstadoAnalisis(estadoAux.listaProducciones.get(i).listaExpresiones.get(0).nombre); // Agraga todas la producciones que pertenescan la expresion analisada
                    generarSimbolosPreAnalisis(estadoAux.listaProducciones.get(i).listaExpresiones.get(1));  //agrega los simbolos de pre analisis a . x B   ====B primeros
                    agregarSimbolosPreAnalisisEstados(estadoAux.listaProducciones.get(i).listaExpresiones.get(0).nombre); // agrega los simbolos de preAnalisis a todas las producciones encontradas.
                }else{
                    auxSimbolos.clear();
                    copiarSimbolos(estadoAux.listaProducciones.get(i).simboloesPreAnalisis);
                    analizarEstadoAnalisis(estadoAux.listaProducciones.get(i).listaExpresiones.get(0).nombre); // Agraga todas la producciones que pertenescan la expresion analisada
                    agregarSimbolosPreAnalisisEstados(estadoAux.listaProducciones.get(i).listaExpresiones.get(0).nombre); // agrega los simbolos de preAnalisis a todas las producciones encontradas.
                    
                }
            }
        }
        listaEstadoLR.add(estadoAux);
        recorrerEstados();
    }
    
    public void analizarEstadoAnalisis(String nombreEstado){
        for (int i = 0; i < listaProducciones.size(); i++) {
            if(listaProducciones.get(i).nombreNoTerminal.equals(nombreEstado)){
                agregarProduccionAuxEstado(copiarProduccion(listaProducciones.get(i))); //busca si esta produccion no a sido agregada
                //break;
            }
        }
    }
    
    public void analizarEstadoAnalisis2(String nombreEstado){
        for (int i = 0; i < listaProducciones.size(); i++) {
            if(listaProducciones.get(i).nombreNoTerminal.equals(nombreEstado)){
                //System.out.println("UNA DE PRODUCCION: "+listaProducciones.get(i).nombreNoTerminal+" ----> ");
                //listaProducciones.get(i).desplegarSimbolosPreAnalisis();
                agregarProduccionAuxEstado2(listaProducciones.get(i)); //busca si esta produccion no a sido agregada
                
            }
        }
    }
    
    private void agregarProduccionAuxEstado(Produccion p){
        boolean existeProduccion = false;
        for (int i = 0; i < estadoAux.listaProducciones.size(); i++) {
            if(estadoAux.listaProducciones.get(i).listaExpresiones.equals(p.listaExpresiones)){
                existeProduccion = true;
                break;
            }
        }
        if(!existeProduccion){
           estadoAux.listaProducciones.add(copiarProduccion(p)); 
            //System.out.print("Agrego la nueva produccion: "+p.nombreNoTerminal+" -> ");
            //p.desplegarExpresiones();
            //System.out.println("");
        }
    }
    
    private void agregarProduccionAuxEstado2(Produccion p){
        boolean existeProduccion = false;
        for (int i = 0; i < estadoAux2.listaProducciones.size(); i++) {
            boolean isPivote = estadoAux2.listaProducciones.get(i).pivote==p.pivote;
            if(isPivote && estadoAux2.listaProducciones.get(i).nombreNoTerminal.equals(p.nombreNoTerminal) && estadoAux2.listaProducciones.get(i).listaExpresiones.equals(p.listaExpresiones)){
                existeProduccion = true;
                break;
            }
        }
        if(!existeProduccion){
            Produccion p2 = copiarProduccion(p);
            estadoAux2.listaProducciones.add(p2); 
            //System.out.print("2.0 Agrego la nueva produccion: "+p.nombreNoTerminal+" -> ");
            //p.desplegarExpresiones();
            //System.out.println("");
        }
    }
    
    private void generarSimbolosPreAnalisis(Expresion expresionPivote){
        switch(expresionPivote.getTipo()){
            case 0:
                agregarSimbolo(expresionPivote.nombre);
                break;
            case 1:
                agregarSimbolo(expresionPivote.nombre);
                break;
            case 2:
                //si es un no terminal
                buscarExpNoTerminal(expresionPivote);
                break;
        }
    }
    
    private void buscarExpNoTerminal(Expresion expresionPivote){
        for (int i = 0; i < listaProducciones.size(); i++) {
            if(listaProducciones.get(i).getNombreNoTerminal().equals(expresionPivote.getNombre())){
                if(listaProducciones.get(i).getListaExpresiones().size()>0 && !listaProducciones.get(i).getListaExpresiones().get(0).nombre.equals(listaProducciones.get(i).getNombreNoTerminal())){
                    generarSimbolosPreAnalisis(listaProducciones.get(i).getListaExpresiones().get(0));
                }
            }
        }
    }
    private void agregarSimbolosPreAnalisisEstados(String nombreEstadoPivote){
        //System.out.println("SIMBOLOS Analis: "+auxSimbolos+ "\tpara -> "+nombreEstadoPivote);
        for (int i = 0; i < estadoAux.listaProducciones.size(); i++) {
            //System.out.print("Entro con los simbolos: "+estadoAux.listaProducciones.get(i).getSimboloesPreAnalisis()+ "\tpara - "+estadoAux.listaProducciones.get(i).id+" -> "+estadoAux.listaProducciones.get(i).nombreNoTerminal+" -> ");
                   // estadoAux.listaProducciones.get(i).desplegarExpresiones();
                    //System.out.println("");
            for (int j = 0; j < auxSimbolos.size(); j++) {
                if(estadoAux.listaProducciones.get(i).nombreNoTerminal.equals(nombreEstadoPivote)){
                   // System.out.print("SIMBOLOS A Agregar: "+auxSimbolos.get(j)+ "\tpara -> "+estadoAux.listaProducciones.get(i).id+" - "+estadoAux.listaProducciones.get(i).nombreNoTerminal+" -> ");
                    //estadoAux.listaProducciones.get(i).desplegarExpresiones();
                    //System.out.println("");
                    
                    estadoAux.listaProducciones.get(i).agregarSimbolo(auxSimbolos.get(j)); 
                }
            }
            //System.out.print("Salio con: "+estadoAux.listaProducciones.get(i).getSimboloesPreAnalisis()+ "\tpara - "+estadoAux.listaProducciones.get(i).id+" -> "+estadoAux.listaProducciones.get(i).nombreNoTerminal+" -> ");
            //estadoAux.listaProducciones.get(i).desplegarExpresiones();
                   // System.out.println("");
                    //System.out.println("");
        }
    }
    
    private void copiarSimbolos(ArrayList<String> simbolos){
        for (int i = 0; i < simbolos.size(); i++) {
            auxSimbolos.add(simbolos.get(i));
        }
    }
    
    private Produccion copiarProduccion(Produccion produccion){
        Produccion nuevo = new Produccion(produccion.getNombreNoTerminal());
        for (int i = 0; i < produccion.getListaExpresiones().size(); i++) {
            nuevo.agregarNuevaExpresion(produccion.getListaExpresiones().get(i));
        }
        nuevo.pivote = produccion.pivote+0;
        copiarSimbolosProducion(nuevo, produccion.getSimboloesPreAnalisis());
        //nuevo.setSimboloesPreAnalisis(produccion.getSimboloesPreAnalisis());
        return nuevo;
    }
    
    public void copiarSimbolosProducion(Produccion nuevo, ArrayList<String> simbolos){
        for (int i = 0; i < simbolos.size(); i++) {
            nuevo.getSimboloesPreAnalisis().add(simbolos.get(i));
        }
    }
    
    private void recorrerEstados(){
        for (int i = 0; i < listaEstadoLR.size(); i++) {
            for (int j = 0; j < listaEstadoLR.get(i).listaProducciones.size(); j++) {
                //System.out.print("IR A: "+auxSimbolos.get(j)+ "\tpara -> "+listaEstadoLR.get(i).listaProducciones.get(j).id+" - "+estadoAux.listaProducciones.get(i).nombreNoTerminal+" -> ");
                //estadoAux.listaProducciones.get(i).desplegarExpresiones();
                //System.out.println("");
                if(!listaEstadoLR.get(i).listaProducciones.get(j).transiciono){
                    irA(listaEstadoLR.get(i).listaProducciones.get(j), listaEstadoLR.get(i));
                }
            }
            
            
        }
    }
    
    public void irA(Produccion produccion, EstadoLR estadoActual){
        if(produccion.isUltimaExpresion()){
            //System.out.println("Entrero");
            estadoAux2 = new EstadoLR();
            Produccion nuevo = copiarProduccion(produccion);
            Expresion expresionBuscada = nuevo.getListaExpresiones().get(nuevo.pivote);
            nuevo.pivote = nuevo.pivote+1;
            produccion.transiciono = true;
            estadoAux2.getListaProducciones().add(nuevo);
            buscarProduccionesIgualTransicion(expresionBuscada, estadoActual);
            //Generar El estado con sus simbolos de preanalisis
            generarSimbolsoNuevoEstados();
            //buscar si no existe algun estdo igual
            if(busarEstadosParecidos()){
                TransicionLR transicionLR = new TransicionLR(produccion.getListaExpresiones().get(produccion.pivote).getNombre(), posicionEstado);
                transicionLR.setTipo(produccion.getListaExpresiones().get(produccion.pivote).getTipo());
                estadoActual.listaTransicionesLR.add(transicionLR);
                //listaEstadoLR.add(estadoAux2);
            }else{
                posicionEstado = listaEstadoLR.size()+1;
                listaEstadoLR.add(estadoAux2);
                TransicionLR transicionLR = new TransicionLR(produccion.getListaExpresiones().get(produccion.pivote).getNombre(), posicionEstado);
                transicionLR.setTipo(produccion.getListaExpresiones().get(produccion.pivote).getTipo());
                estadoActual.listaTransicionesLR.add(transicionLR);
            }
        }else{
                produccion.transiciono = true;
                if(produccion.isUltimo() && produccion.getListaExpresiones().get(produccion.getPivote()).getTipo()==0){
                    TransicionLR transicionLR = new TransicionLR("a", 0);
                    transicionLR.setTipo(0);
                    estadoActual.getListaTransicionesLR().add(transicionLR);
                    
                }else if(produccion.pivote==produccion.getListaExpresiones().size()){
                    System.out.println("AGREGO EL DE ACEPPPPPPPPPPPPPPPPPPPPPPPPPPPPTTTTTTTTTTTTTTTTTTTTTTTTAAAAAAAAAAAAAAAAAAAACCCCCCCCCCCCCIIIIIIIIIIIOOOOOOOOOONNNNNNNNNN");

                    for (int i = 0; i < produccion.getSimboloesPreAnalisis().size(); i++) {
                        TransicionLR transicionLR = new TransicionLR(produccion.getSimboloesPreAnalisis().get(i), buscarProducionTransicion(produccion));
                        transicionLR.setTipo(3);
                        estadoActual.getListaTransicionesLR().add(transicionLR);
                    }
                }
            }
    }
    
    private void buscarProduccionesIgualTransicion(Expresion expresionBuscada, EstadoLR estadoActual){
        for (int i = 0; i < estadoActual.getListaProducciones().size(); i++) {
            if(!estadoActual.getListaProducciones().get(i).transiciono && estadoActual.getListaProducciones().get(i).isUltimo()){
                if(estadoActual.getListaProducciones().get(i).getListaExpresiones().get(estadoActual.getListaProducciones().get(i).pivote).getNombre().equals(expresionBuscada.nombre)){
                    Produccion nuevo = copiarProduccion(estadoActual.getListaProducciones().get(i));
                    nuevo.pivote = nuevo.pivote+1;
                    estadoActual.getListaProducciones().get(i).transiciono = true;
                    estadoAux2.getListaProducciones().add(nuevo);
                }
        }
        }
    }
    
    public void generarSimbolsoNuevoEstados(){
        for (int i = 0; i < estadoAux2.listaProducciones.size(); i++) {
            estadoAux2.listaProducciones.get(i).id = i+1;
            if(estadoAux2.listaProducciones.get(i).isUltimaExpresion()){
                if(estadoAux2.listaProducciones.get(i).listaExpresiones.get(estadoAux2.listaProducciones.get(i).pivote).getTipo()!=1){
                    //System.out.println("Entro 1");
                    if(estadoAux2.listaProducciones.get(i).isLimit()){
                        //System.out.println("Entro 2");
                        auxSimbolos.clear();
                        analizarEstadoAnalisis2(estadoAux2.listaProducciones.get(i).listaExpresiones.get(estadoAux2.listaProducciones.get(i).pivote).nombre); // Agraga todas la producciones que pertenescan la expresion analisada
                        generarSimbolosPreAnalisis(estadoAux2.listaProducciones.get(i).listaExpresiones.get(estadoAux2.listaProducciones.get(i).pivote+1));  //agrega los simbolos de pre analisis a . x B   ====B primeros
                        agregarSimbolosPreAnalisisEstados(estadoAux2.listaProducciones.get(i).listaExpresiones.get(estadoAux2.listaProducciones.get(i).pivote).nombre); // agrega los simbolos de preAnalisis a todas las producciones encontradas.
                    }else{
                        //System.out.println("Entro 3");
                        auxSimbolos.clear();
                        copiarSimbolos(estadoAux2.listaProducciones.get(i).simboloesPreAnalisis);
                        analizarEstadoAnalisis2(estadoAux2.listaProducciones.get(i).listaExpresiones.get(estadoAux2.listaProducciones.get(i).pivote).nombre); // Agraga todas la producciones que pertenescan la expresion analisada
                        agregarSimbolosPreAnalisisEstadosNuevos(estadoAux2.listaProducciones.get(i).listaExpresiones.get(estadoAux2.listaProducciones.get(i).pivote).nombre); // agrega los simbolos de preAnalisis a todas las producciones encontradas.
                    }
                }
                
            }
        }
    }
    
    private void agregarSimbolosPreAnalisisEstadosNuevos(String nombreEstadoPivote){
        //System.out.println("SIMBOLOS Analis: "+auxSimbolos+ "\tpara -> "+nombreEstadoPivote);
        for (int i = 0; i < estadoAux2.listaProducciones.size(); i++) {
            //System.out.print("Entro con los simbolos: "+estadoAux.listaProducciones.get(i).getSimboloesPreAnalisis()+ "\tpara - "+estadoAux.listaProducciones.get(i).id+" -> "+estadoAux.listaProducciones.get(i).nombreNoTerminal+" -> ");
                   // estadoAux.listaProducciones.get(i).desplegarExpresiones();
                    //System.out.println("");
            for (int j = 0; j < auxSimbolos.size(); j++) {
                if(estadoAux2.listaProducciones.get(i).nombreNoTerminal.equals(nombreEstadoPivote)){
                   // System.out.print("SIMBOLOS A Agregar: "+auxSimbolos.get(j)+ "\tpara -> "+estadoAux.listaProducciones.get(i).id+" - "+estadoAux.listaProducciones.get(i).nombreNoTerminal+" -> ");
                    //estadoAux.listaProducciones.get(i).desplegarExpresiones();
                    //System.out.println("");
                    
                    estadoAux2.listaProducciones.get(i).agregarSimbolo(auxSimbolos.get(j)); 
                }
            }
            //System.out.print("Salio con: "+estadoAux.listaProducciones.get(i).getSimboloesPreAnalisis()+ "\tpara - "+estadoAux.listaProducciones.get(i).id+" -> "+estadoAux.listaProducciones.get(i).nombreNoTerminal+" -> ");
            //estadoAux.listaProducciones.get(i).desplegarExpresiones();
                   // System.out.println("");
                    //System.out.println("");
        }
    }
    
    private boolean busarEstadosParecidos(){
        boolean encontro = false;
        for (int i = 0; i < listaEstadoLR.size(); i++) {
            if(busarProduccionesParecidas(listaEstadoLR.get(i))){
                encontro = true;
                posicionEstado = i+1;
                break;
            }
        }
        return encontro;
        
    }
    
    private boolean busarProduccionesParecidas(EstadoLR estadoAnalisado){
        boolean encontro = false;
//        if(estadoAux2.getListaProducciones().size()==estadoAnalisado.getListaProducciones().size()){
//            
//        }
        //System.out.println("tAMANIO ESTADO BUSCADO: "+estadoAux2.getListaProducciones().size());
        //estadoAux2.desplegar();
        for (int i = 0; i < estadoAux2.getListaProducciones().size(); i++) {
            encontro = false;
            for (int j = 0; j < estadoAnalisado.getListaProducciones().size(); j++) {
                boolean isExpresiones = estadoAux2.getListaProducciones().get(i).listaExpresiones.equals(estadoAnalisado.getListaProducciones().get(j).getListaExpresiones());
                boolean isSimboloes = estadoAux2.getListaProducciones().get(i).getSimboloesPreAnalisis().equals(estadoAnalisado.getListaProducciones().get(j).getSimboloesPreAnalisis());
                boolean isPivote = estadoAux2.getListaProducciones().get(i).pivote==estadoAnalisado.getListaProducciones().get(j).pivote;
                boolean isTamanio = estadoAux2.getListaProducciones().size()==estadoAnalisado.getListaProducciones().size();
                if(isExpresiones && isSimboloes && isPivote && isTamanio){
                    encontro = true;
                    break;
                }
            }
            if (!encontro) {
                //System.out.println("NO  Existeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
                return false;
            }
        }
       // System.out.println("Existeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        return true; 
    }
    
    
    public void pintarEstados(){
        System.out.println("Total de estado: "+listaEstadoLR.size());
        for (int i = 0; i < listaEstadoLR.size(); i++) {
            System.out.println("Estado # "+(i+1));
                listaEstadoLR.get(i).desplegar();
        }
    }
    
    public void agregarSimbolo(String nombre){
        boolean existe = false;
        for (int i = 0; i < auxSimbolos.size(); i++) {
            if(auxSimbolos.get(i).equals(nombre)){
                existe = true;
                break;
            }
        }
        if (!existe) {
            auxSimbolos.add(nombre);
        }
    }
    
    public void pintarProducciones(){
        System.out.println("");
        System.out.println("LISTA PRODUCCIONES ");
        for (int i = 0; i < listaProducciones.size(); i++) {
            System.out.print(listaProducciones.get(i).getId()+".\t"+listaProducciones.get(i).transiciono+" () "+listaProducciones.get(i).getNombreNoTerminal()+" -> ");
            listaProducciones.get(i).desplegarExpresiones();
            listaProducciones.get(i).desplegarSimbolosPreAnalisis();
        }
    }
    
    public int buscarProducionTransicion(Produccion produccion){
        
        for (int i = 0; i < listaProducciones.size(); i++) {
            boolean isNombre = listaProducciones.get(i).nombreNoTerminal.equals(produccion.getNombreNoTerminal());
            boolean isExpresiones = listaProducciones.get(i).getListaExpresiones().equals(produccion.getListaExpresiones());
            if(isNombre && isExpresiones){
                return i;
            }
        }
        
        return 0;
    }
}
