
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
    private ArrayList<String> listaCaracteres = new ArrayList<>();
    private boolean anulable;
    private Nodo derechaNodo, izquierdaNodo, padreNodo;

    public Nodo(int tipo, String lexema, boolean anulable) {
        this.tipo = tipo;
        this.lexema = lexema;
        this.anulable = anulable;
        listaCaracteres.add(lexema);
    }
    
    public void generarListaCaracteres(String a, String b){
        listaCaracteres.clear();
        
        char c1 = a.charAt(0);
        char c2 = b.charAt(0);
        int v1 = (int) c1;
        int v2 = (int) c2;
        for (int i = v1; i < v2+1; i++) {
            char c = (char)i;
            listaCaracteres.add(Character.toString(c));
        }
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
