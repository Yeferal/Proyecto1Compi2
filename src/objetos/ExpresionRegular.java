
package objetos;

public class ExpresionRegular {
    
    Arbol arbol;
    String nombre;

    public ExpresionRegular(Arbol arbol, String nombre) {
        this.arbol = arbol;
        this.nombre = nombre;
    }

    public Arbol getArbol() {
        return arbol;
    }

    public void setArbol(Arbol arbol) {
        this.arbol = arbol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
