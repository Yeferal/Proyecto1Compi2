/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lalr.lectura;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import lalr.Produccion;
import lalr.TablaTerminalesNoT;
import lalr.TransicionLR;
import lalr.TransicionesEstado;

/**
 *
 * @author LENOVO-PC
 */
public class TablaPila {
    
    private Stack<Integer> pila = new Stack<>();
    private Stack<String> pilaSimbolos = new Stack<>();
    private LinkedList<String> cola = new LinkedList<>();
    private ArrayList<String> tiposToken;
    private TablaTerminalesNoT tablaTerminalesNoT;
    private ArrayList<TransicionesEstado> tablaTransiciones;
    private ArrayList<Produccion> listaProducciones;
    private ArrayList<Accion> listaAcciones;
    private boolean completo = true;
    public boolean aceptado = false;

    public ArrayList<Accion> getListaAcciones() {
        return listaAcciones;
    }

    public void setListaAcciones(ArrayList<Accion> listaAcciones) {
        this.listaAcciones = listaAcciones;
    }
    
    
    
    public void iniciarPila(ArrayList<Produccion> listaProducciones, ArrayList<TransicionesEstado> tablaTransiciones, TablaTerminalesNoT tablaTerminalesNoT,LinkedList<String> cola){
        this.listaProducciones = listaProducciones;
        this.tablaTransiciones = tablaTransiciones;
        this.tablaTerminalesNoT = tablaTerminalesNoT;
        this.cola = cola;
        aceptado = true;
        listaAcciones = new ArrayList<>();
        listarPalabrasReservadas();
        System.out.println("LISTA DE LA PILA");
        desplegarFilaTerminalesNT();
        desplegarFila();
        agregarNumEstadoPila(1);
        recorrer();
        desplegarAcciones();
    }
    
    private void recorrer(){
        int numeroEstado = pila.peek()-1;
        String tokenCadena = cola.peek();
        TransicionLR celda = tablaTransiciones.get(numeroEstado).listaTransiciones.get(obtenerNumColumna(tokenCadena));
        if(celda!=null){
//            System.out.println("Celda: "+celda.getTipoTransicion());
            Accion acc = new Accion(getAccionPila(), getAccionPilaSim(), getAccionColaCadena(), getTipoAccion(numeroEstado, tokenCadena, celda));
            
            listaAcciones.add(acc);
            accionar(celda.getTipo(), celda);
        }else{
            Accion acc = new Accion(getAccionPila(), getAccionPilaSim(), getAccionColaCadena(), "ERROR");
            listaAcciones.add(acc);
            aceptado = false;
        }
        
    }
    
    private void accionar(int tipoAccion, TransicionLR celda){
        
        switch(tipoAccion){
            case 1:
                //shift
                System.out.println("Entro shift");
                hacerSHIFT(celda);
                if(completo && !cola.isEmpty() && !pila.isEmpty() && !pilaSimbolos.isEmpty()){
                    
                    int numeroEstado = pila.peek()-1;
                    String tokenCadena = cola.peek();
                    TransicionLR celdaAux = tablaTransiciones.get(numeroEstado).listaTransiciones.get(obtenerNumColumna(tokenCadena));
                    if(celdaAux!=null){
                        Accion acc = new Accion(getAccionPila(), getAccionPilaSim(), getAccionColaCadena(), getTipoAccion(numeroEstado, tokenCadena, celdaAux));
                        listaAcciones.add(acc);
                        accionar(celdaAux.getTipo(), celdaAux);
                    }else{
                        Accion acc = new Accion(getAccionPila(), getAccionPilaSim(), getAccionColaCadena(), "ERROR");
                        listaAcciones.add(acc);
                        aceptado = false;
                    }
                }else{
                    Accion acc = new Accion(getAccionPila(), getAccionPilaSim(), getAccionColaCadena(), "ERROR");
                        listaAcciones.add(acc);
                        aceptado = false;
                }
                break;
            case 2:
                //goto
                System.out.println("Entro goto");
                hacerGOTO(celda);
                if(completo && !cola.isEmpty() && !pila.isEmpty() && !pilaSimbolos.isEmpty()){
                    
                    int numeroEstado = pila.peek()-1;
                    String tokenCadena = cola.peek();
                    TransicionLR celdaAux = tablaTransiciones.get(numeroEstado).listaTransiciones.get(obtenerNumColumna(tokenCadena));
                    if(celdaAux!=null){
                        Accion acc = new Accion(getAccionPila(), getAccionPilaSim(), getAccionColaCadena(), getTipoAccion(numeroEstado, tokenCadena, celdaAux));
                        listaAcciones.add(acc);
                        accionar(celdaAux.getTipo(), celdaAux);
                    }else{
                        Accion acc = new Accion(getAccionPila(), getAccionPilaSim(), getAccionColaCadena(), "ERROR");
                        listaAcciones.add(acc);
                        aceptado = false;
                    }
                }else{
                    Accion acc = new Accion(getAccionPila(), getAccionPilaSim(), getAccionColaCadena(), "ERROR");
                        listaAcciones.add(acc);
                        aceptado = false;
                }
                break;
            case 3:
                //reduce
                System.out.println("Entro reduce");
                hacerREDUCE(celda);
                if(completo && !cola.isEmpty() && !pila.isEmpty() && !pilaSimbolos.isEmpty()){
                    
                    int numeroEstado = pila.peek()-1;
                    String tokenCadena = pilaSimbolos.peek();
                    TransicionLR celdaAux = tablaTransiciones.get(numeroEstado).listaTransiciones.get(obtenerNumColumna(tokenCadena));
                    if(celdaAux!=null){
                        Accion acc = new Accion(getAccionPila(), getAccionPilaSim(), getAccionColaCadena(), getTipoAccion(numeroEstado, tokenCadena, celdaAux));
                        listaAcciones.add(acc);
                        accionar(celdaAux.getTipo(), celdaAux);
                    }else{
                        Accion acc = new Accion(getAccionPila(), getAccionPilaSim(), getAccionColaCadena(), "ERROR");
                        listaAcciones.add(acc);
                        aceptado = false;
                    }
                }else{
                    Accion acc = new Accion(getAccionPila(), getAccionPilaSim(), getAccionColaCadena(), "ERROR");
                        listaAcciones.add(acc);
                        aceptado = false;
                }
                break;
            case 0:
                //aceptacion
                
                break;
        }
    }
    
    private void hacerSHIFT(TransicionLR tlr){
        pila.push(tlr.getNumIrA());
        completo = true;
        if(!cola.isEmpty()){
            pilaSimbolos.push(cola.poll());
        }else{
            completo = false;
        }
    }
    
    private void hacerGOTO(TransicionLR tlr){
        pila.push(tlr.getNumIrA());
        completo = true;
    }
    
    private void hacerREDUCE(TransicionLR tlr){
        Stack<String> pilaAux = new Stack<>();
        completo = true;
        for (int i = 0; i < listaProducciones.get(tlr.getNumIrA()).getListaExpresiones().size(); i++) {
            pilaAux.push(listaProducciones.get(tlr.getNumIrA()).getListaExpresiones().get(i).getNombre());
        }
        
        while (!pilaAux.isEmpty()) {            
            if(pilaSimbolos.peek().equals(pilaAux.peek())){
                pilaSimbolos.pop();
                pilaAux.pop();
                pila.pop();
            }else{
                completo = false;
                break;
            }
        }
        
        if(completo){
            pilaSimbolos.push(listaProducciones.get(tlr.getNumIrA()).getNombreNoTerminal());
            //pila.pop();
        }else{
            Accion acc = new Accion(getAccionPila(), getAccionPilaSim(), getAccionColaCadena(), "ERROR");
            listaAcciones.add(acc);
        }
    }
    
    
    public String getTipoAccion(int numeroEstado, String tokenTxt, TransicionLR tlr){
        String texto = "("+(numeroEstado+1)+", "+tokenTxt+") ";
        System.out.println(tlr);
        switch(tlr.getTipo()){
            case 1:
                texto += "SHIFT "+tlr.getNumIrA();
                return texto;
            case 2:
                texto += "GOTO "+tlr.getNumIrA();
                return texto;
            case 3:
                texto += "REDUCE "+tlr.getNumIrA()+", ";
                texto += listaProducciones.get(tlr.getNumIrA()).desplegarProduccion();
                return texto;
            case 0:
                texto = "ACEPTACION";
                aceptado = true;
                return texto;
                default:
                    return "ERROR";
        }
        
    }
        
    private void listarPalabrasReservadas(){
        tiposToken = new ArrayList<>();
        for (int i = 0; i < tablaTerminalesNoT.getTerminales().size(); i++) {
            tiposToken.add(tablaTerminalesNoT.getTerminales().get(i).getNombre());
        }
        tiposToken.add("$");
        for (int i = 0; i < tablaTerminalesNoT.getNoTerminales().size(); i++) {
            tiposToken.add(tablaTerminalesNoT.getNoTerminales().get(i).getNombre());
        }
        for (int i = 0; i < tiposToken.size(); i++) {
            System.out.print(i+","+tiposToken.get(i)+"\t");
        }
        System.out.println("");
    }
    
    
    private void agregarEntrada(String token){
        cola.offer(token);
    }
    
    private void agregarNumEstadoPila(int num){
        pila.push(num);
    }
    
    private void agregarSimbolEstadoPila(String simbolo){
        pilaSimbolos.push(simbolo);
    }
    
    private boolean isUltimoPilaNum(){
        if(pila.isEmpty()){
           return false;
        }
        return true;
    }
    private boolean isUltimoPilaSim(){
        if(pilaSimbolos.isEmpty()){
           return false;
        }
        return true;
    }
    private boolean isUltimoColaEntrada(){
        if(cola.isEmpty()){
           return false;
        }
        return true;
    }
    
    private int obtenerNumColumna(String simbolo){
        for (int i = 0; i < tiposToken.size(); i++) {
            System.out.println("Simbolo: "+simbolo);
            if(simbolo.equals(tiposToken.get(i))){
                return i;
            }
        }
        return 0;
    }
    
    private String getAccionColaCadena(){
        LinkedList<String> colaAux = new LinkedList<>();
        String texto = "";
        while (!cola.isEmpty()) {            
            texto += cola.peek()+" ";
            colaAux.offer(cola.poll());
        }
        while (!colaAux.isEmpty()) {            
            cola.offer(colaAux.poll());
        }
        return texto;
    }
    private String getAccionPilaSim(){
        Stack<String> pilaAux = new Stack<>();
        String texto = "";
        while (!pilaSimbolos.isEmpty()) {            
            pilaAux.push(pilaSimbolos.pop());
        }
        while (!pilaAux.isEmpty()) { 
            texto += pilaAux.peek()+" "; 
            pilaSimbolos.push(pilaAux.pop());
        }
        return texto;
    }
    private String getAccionPila(){
        Stack<Integer> pilaAux = new Stack<>();
        String texto = "";
        while (!pila.isEmpty()) {            
            
            pilaAux.push(pila.pop());
        }
        while (!pilaAux.isEmpty()) {
            texto += pilaAux.peek()+" ";            
            pila.push(pilaAux.pop());
        }
        return texto;
    }
    
    
    public void desplegarFilaTerminalesNT(){
        System.out.println("");
        System.out.print("\t\t\t");
        for (int i = 0; i < tablaTerminalesNoT.getTerminales().size(); i++) {
            System.out.print(tablaTerminalesNoT.getTerminales().get(i).getNombre()+"\t");
        }
        System.out.print("$\t");
        for (int i = 0; i < tablaTerminalesNoT.getNoTerminales().size(); i++) {
            System.out.print(tablaTerminalesNoT.getNoTerminales().get(i).getNombre()+"\t");
        }
        System.out.println("");
    }
    public void desplegarFila(){
        for (int i = 0; i < tablaTransiciones.size(); i++) {
            tablaTransiciones.get(i).despleagar();
            System.out.println("");
        }
    }
    public void desplegarAcciones(){
        System.out.println("\nNo.\tPila\t\t\t\tSimbolo\t\t\t\tEntrada\t\t\t\tAccion");
        for (int i = 0; i < listaAcciones.size(); i++) {
            System.out.print((i+1)+".\t");
            System.out.print(listaAcciones.get(i).getTextoPila()+tabuladores(listaAcciones.get(i).getTextoPila()));
            System.out.print(listaAcciones.get(i).getTextoSimbolo()+tabuladores(listaAcciones.get(i).getTextoSimbolo()));
            System.out.print(listaAcciones.get(i).getTextoEntrada()+tabuladores(listaAcciones.get(i).getTextoEntrada()));
            System.out.println(listaAcciones.get(i).getTextoAccion());
//            System.out.print(linear(listaAcciones.get(i).getTextoPila()+tabuladores(listaAcciones.get(i).getTextoPila())));
//            System.out.print(linear(listaAcciones.get(i).getTextoSimbolo()+tabuladores(listaAcciones.get(i).getTextoSimbolo())));
//            System.out.print(linear(listaAcciones.get(i).getTextoEntrada()+tabuladores(listaAcciones.get(i).getTextoEntrada())));
//            System.out.print(linear(listaAcciones.get(i).getTextoAccion()));
//            System.out.println("");
        }
    }
    
    public String tabuladores(String t){
        String texto = "";
        for (int i = (int)t.length()/8; i < 4; i++) {
            texto += "\t";
        }
        return texto;
    }
    
    public String linear(String t){
        String texto = "";
        for (int i = 0; i < t.length()+6; i++) {
            texto += "_";
        }
        return texto;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void probar(){
        
        System.out.println("");
        System.out.println("");
        System.out.println("");
        for (int i = 0; i < 5; i++) {
            pila.push(i);
        }
        System.out.println("Mira: "+pila.peek());
        System.out.println();
        while (!pila.isEmpty()) {            
            
            System.out.println("Saco: "+pila.pop());
        }
        
        probarCola();
    }
    public void probarCola(){
        
        System.out.println("");
        System.out.println("");
        for (int i = 0; i < 5; i++) {
            cola.offer("Hola"+i);
        }
        System.out.println("MiraC: "+cola.peek());
        System.out.println();
        while (!cola.isEmpty()) {            
            
            System.out.println("Primeo saca: "+cola.poll());
        }
    }
}
