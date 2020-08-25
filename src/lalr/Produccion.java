
package lalr;

import java.util.ArrayList;

public class Produccion {
    
    String nombreNoTerminal;
    int id;
    ArrayList<Expresion> listaExpresiones = new ArrayList<>();
    ArrayList<String> simboloesPreAnalisis = new ArrayList<>();

    public Produccion(String nombreNoTerminal) {
        this.nombreNoTerminal = nombreNoTerminal;
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
    
    public void desplegarExpresiones(){
        for (int i = 0; i < listaExpresiones.size(); i++) {
//            System.out.print(listaExpresiones.get(i).getNombre()+":"+listaExpresiones.get(i).getTipo()+" ");
            System.out.print(listaExpresiones.get(i).getNombre()+" ");
        }
        System.out.println();
    }
    
}
