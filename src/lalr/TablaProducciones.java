
package lalr;

import java.util.ArrayList;

public class TablaProducciones {
    
    ArrayList<Produccion> listaProducciones = new ArrayList<>();
    
    public void agregarProduccion(Produccion produccion){
        listaProducciones.add(produccion);
    }
    
    public void desplegarProducciones(){
        System.out.println();
        for (int i = 0; i < listaProducciones.size(); i++) {
            System.out.print(listaProducciones.get(i).getNombreNoTerminal()+" -> ");
            listaProducciones.get(i).desplegarExpresiones();
            
        }
    }
    
}
