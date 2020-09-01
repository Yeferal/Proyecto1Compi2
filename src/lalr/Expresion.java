
package lalr;

import java.io.Serializable;

public class Expresion implements Serializable{
    
    /**TIPO
     * 0. reservada
     * 1. terminal
     * 2. no terminal
     * 3. λ
     */
    String nombre;
    int tipo;

    public Expresion(String nombre, int tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
}
