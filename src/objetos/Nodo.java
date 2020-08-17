
package objetos;

import java.util.ArrayList;

public class Nodo {
    
    /*TIPOS
    1. concatenacion    (.)
    2. asterisco        (*)
    3. mas              (+)
    4. separador o      (|)
    5. caracter         (char)
    6. final cadena     (#)
    7. una o nada       (?)
    8. lambda           ("")
    */
    
    private int tipo, id;
    private String lexema;
    private ArrayList<Integer> primeros = new ArrayList<>();
    private ArrayList<Integer> siguientes = new ArrayList<>();
    private boolean anulable;
    private Nodo derechaNodo, izquierdaNodo, padreNodo;

    public Nodo(int tipo, String lexema, boolean anulable) {
        this.tipo = tipo;
        this.lexema = lexema;
        this.anulable = anulable;
    }
    
    

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public ArrayList<Integer> getPrimeros() {
        return primeros;
    }

    public void setPrimeros(ArrayList<Integer> primeros) {
        this.primeros = primeros;
    }

    public ArrayList<Integer> getSiguientes() {
        return siguientes;
    }

    public void setSiguientes(ArrayList<Integer> siguientes) {
        this.siguientes = siguientes;
    }

    public boolean isAnulable() {
        return anulable;
    }

    public void setAnulable(boolean anulable) {
        this.anulable = anulable;
    }

    public Nodo getDerechaNodo() {
        return derechaNodo;
    }

    public void setDerechaNodo(Nodo derechaNodo) {
        this.derechaNodo = derechaNodo;
    }

    public Nodo getIzquierdaNodo() {
        return izquierdaNodo;
    }

    public void setIzquierdaNodo(Nodo izquierdaNodo) {
        this.izquierdaNodo = izquierdaNodo;
    }

    public Nodo getPadreNodo() {
        return padreNodo;
    }

    public void setPadreNodo(Nodo padreNodo) {
        this.padreNodo = padreNodo;
    }
    
    
    
    
    
}
