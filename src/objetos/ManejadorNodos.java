
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
    
    public Nodo generarPadre(Nodo izquierdaNodo, Nodo derechaNodo, int tipo, String lexema, boolean anulable, String nombreToken){
        Nodo padre = new Nodo(tipo, lexema, anulable, nombreToken);
        if(izquierdaNodo!=null){
            izquierdaNodo.setPadreNodo(padre);
            System.out.println("NodoI: "+izquierdaNodo.getLexema());
        }
        if(derechaNodo!=null){
            derechaNodo.setPadreNodo(padre);
            System.out.println("NodoD: "+derechaNodo.getLexema());
        }
        padre.setIzquierdaNodo(izquierdaNodo);
        padre.setDerechaNodo(derechaNodo);
        
        
        
        return padre;
    }
    
    public Nodo generarNodosTexto(String texto, String nombreToken){
        String [] arreglo = texto.split("");
        Nodo padre = null;
        for (int i = 0; i < arreglo.length; i++) {
            if(i==0){
                padre = new Nodo(5, arreglo[i], false, nombreToken);
            }else{
                Nodo n = new Nodo(5, arreglo[i], false, nombreToken);
                Nodo nodoConcat = new Nodo(1, ".", determinarAnulabilidad(padre, n), nombreToken);
                padre.setPadreNodo(nodoConcat);
                nodoConcat.setIzquierdaNodo(padre);
                n.setPadreNodo(nodoConcat);
                nodoConcat.setDerechaNodo(n);
                padre = nodoConcat;
                
            }
        }
        return padre;
    }
    
    public boolean verificarTamanio(String a, String b){
        if(a.length()==1 && b.length()==1){
            return true;
        }
        return false;
    }
    
    
    public boolean isMenor(String a, String b){
        char c1 = a.charAt(0);
        char c2 = b.charAt(0);
        int v1 = (int) c1;
        int v2 = (int) c2;
        if(v1<v2){
            return true;
        }
        return false;
    }
    
    public Nodo generarPadreCadenas(Nodo padre,int tipo, String lexema, boolean anulabilidad, String nombreToken){
        Nodo nuevo = null;
        boolean isUno = false;
        int cantidad = padre.listaCaracteres.size();
        for (int i = 0; i < cantidad; i++) {
            Nodo nodoAs = new Nodo(tipo, lexema, anulabilidad, nombreToken);
            Nodo nuevoC = new Nodo(5, padre.listaCaracteres.get(i), false, nombreToken);
            nodoAs.setIzquierdaNodo(nuevoC);
            if(i==0){
                nuevo = nodoAs;
            }else if(i!=0){
                isUno = true;
                Nodo nodoConcat = generarPadre(nuevo, nodoAs, 1, ".", determinarAnulabilidad(nuevo, nodoAs), nombreToken);
                nuevo = nodoConcat;
            }
        }
        if(isUno){
            Nodo nodoAs = new Nodo(tipo, lexema, anulabilidad, nombreToken);
            nodoAs.setIzquierdaNodo(nuevo);
            nuevo = nodoAs;
        }
        return nuevo;
    }
    
}
