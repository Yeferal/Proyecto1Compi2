
package lalr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Produccion {
    
    String nombreNoTerminal;
    int id, pivote;
    public boolean transiciono = false;
    ArrayList<Expresion> listaExpresiones = new ArrayList<>();
    ArrayList<String> simboloesPreAnalisis = new ArrayList<>();

    public Produccion(String nombreNoTerminal) {
        this.nombreNoTerminal = nombreNoTerminal;
        pivote = 0;
    }
    public void reiniciarTransicion(){
        transiciono = false;
    }
    public void agregarNuevaExpresion(Expresion expresion){
        listaExpresiones.add(expresion);
    }

    public String getNombreNoTerminal() {
        return nombreNoTerminal;
    }

    public void setNombreNoTerminal(String nombreNoTerminal) {
        this.nombreNoTerminal = nombreNoTerminal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Expresion> getListaExpresiones() {
        return listaExpresiones;
    }

    public void setListaExpresiones(ArrayList<Expresion> listaExpresiones) {
        this.listaExpresiones = listaExpresiones;
    }

    public int getPivote() {
        return pivote;
    }

    public void setPivote(int pivote) {
        this.pivote = pivote;
    }

    public ArrayList<String> getSimboloesPreAnalisis() {
        return simboloesPreAnalisis;
    }

    public void setSimboloesPreAnalisis(ArrayList<String> simboloesPreAnalisis) {
        this.simboloesPreAnalisis = simboloesPreAnalisis;
    }
    
    public void desplegarExpresiones(){
        for (int i = 0; i < listaExpresiones.size(); i++) {
//            System.out.print(listaExpresiones.get(i).getNombre()+":"+listaExpresiones.get(i).getTipo()+" ");
            if(pivote==i){
                System.out.print(". ");
            }
            System.out.print(listaExpresiones.get(i).getNombre()+" ");
        }
        if(listaExpresiones.size()== pivote){
            System.out.print(". ");
        }
    }
    
    public void desplegarSimbolosPreAnalisis(){
            System.out.print("\t"+simboloesPreAnalisis);
        System.out.println();
    }
    
    public boolean isLimit(){
        if(pivote<listaExpresiones.size()-1){
            System.out.println(nombreNoTerminal+" -> "+pivote + "<"+(listaExpresiones.size()-1));
            return true;
        }
        return false;
    }
    
    public void agregarSimbolo(String simbolo){
        boolean existe = false;
        for (int i = 0; i < simboloesPreAnalisis.size(); i++) {
            if (simboloesPreAnalisis.get(i).equals(simbolo)) {
                existe = true;
                break;
            }
        }
        if (!existe) {
            simboloesPreAnalisis.add(simbolo);
        }
        ordenarSimbolos();
    }
    
    public boolean isUltimaExpresion(){
        if(pivote<listaExpresiones.size() && listaExpresiones.get(pivote).getTipo()==0){
            return false;
        }else if(pivote==listaExpresiones.size()){
            return false;
        }else if(pivote>listaExpresiones.size()-1){
            return false;
        }
        return true;
    }
    
    public boolean isUltimo(){
        if(pivote<listaExpresiones.size()){
            return true;
        }
        return false;
    }
    
    public void ordenarSimbolos(){
        Collections.sort(simboloesPreAnalisis);
    }
    
    public String desplegarProduccion(){
        String t = getNombreNoTerminal()+" -> ";
        for (int i = 0; i < listaExpresiones.size(); i++) {
            t += listaExpresiones.get(i).getNombre()+" ";
        }
        return t;
    }
    
}
