
package objetos;

public class ManejadorNodos {
    
    
    public boolean determinarAnulabilidad(Nodo izquierdaNodo, Nodo derechaNodo){
        if(derechaNodo!=null){
            if(izquierdaNodo.isAnulable() && derechaNodo.isAnulable()){
                return true;
            }else{
                return false;
            }
        }else{
            return izquierdaNodo.isAnulable();
        }
    }
    
    public Nodo generarNodoHijo(Nodo hijo, Nodo padre){
        hijo.setPadreNodo(padre);
        padre.setIzquierdaNodo(hijo);
        return padre;
    }
    
    public Nodo generarPadre(Nodo izquierdaNodo, Nodo derechaNodo, int tipo, String lexema, boolean anulable){
        Nodo padre = new Nodo(tipo, lexema, anulable);
        if(izquierdaNodo!=null){
            izquierdaNodo.setPadreNodo(padre);
        }
        if(derechaNodo!=null){
            derechaNodo.setPadreNodo(padre);
        }
        padre.setIzquierdaNodo(izquierdaNodo);
        padre.setDerechaNodo(derechaNodo);
        return padre;
    }
    
    public Nodo generarNodosTexto(String texto){
        String [] arreglo = texto.split("");
        Nodo padre = null;
        for (int i = 0; i < arreglo.length; i++) {
            if(i==0){
                padre = new Nodo(5, arreglo[i], false);
            }else{
                Nodo n = new Nodo(5, arreglo[i], false);
                Nodo nodoConcat = new Nodo(1, ".", determinarAnulabilidad(padre, n));
                padre.setPadreNodo(nodoConcat);
                nodoConcat.setIzquierdaNodo(padre);
                n.setPadreNodo(nodoConcat);
                nodoConcat.setDerechaNodo(n);
                padre = nodoConcat;
                
            }
        }
        return padre;
    }
}
