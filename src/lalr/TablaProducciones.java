
package lalr;

import java.util.ArrayList;

public class TablaProducciones {
    
    public ArrayList<Produccion> listaProducciones = new ArrayList<>();
    
    public void agregarProduccion(Produccion produccion){
        listaProducciones.add(produccion);
    }
    
    public void desplegarProducciones(){
        System.out.println();
        for (int i = 0; i < listaProducciones.size(); i++) {
            System.out.print(listaProducciones.get(i).getId()+".\t"+listaProducciones.get(i).getNombreNoTerminal()+" -> ");
            listaProducciones.get(i).desplegarExpresiones();
            System.out.println("");
        }
    }
    
    public void generarEstadoInicial(){
        ArrayList<Produccion> aux = new ArrayList<>();
        Produccion p = new Produccion("INICIO");
        p.agregarNuevaExpresion(new Expresion(listaProducciones.get(0).getNombreNoTerminal(), 2));
        p.agregarNuevaExpresion(new Expresion("$", 0));
        p.setId(0);
        p.getSimboloesPreAnalisis().add("?");
        aux.add(p);
        for (int i = 0; i < listaProducciones.size(); i++) {
            listaProducciones.get(i).setId(i+1);
            aux.add(listaProducciones.get(i));
        }
        listaProducciones = aux;
    }
    
}
