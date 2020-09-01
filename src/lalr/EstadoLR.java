
package lalr;

import java.io.Serializable;
import java.util.ArrayList;

public class EstadoLR implements Serializable{
    
    ArrayList<TransicionLR> listaTransicionesLR = new ArrayList<>();
    ArrayList<Produccion> listaProducciones = new ArrayList<>();
    public boolean isUsed = false;

    public ArrayList<TransicionLR> getListaTransicionesLR() {
        return listaTransicionesLR;
    }

    public void setListaTransicionesLR(ArrayList<TransicionLR> listaTransicionesLR) {
        this.listaTransicionesLR = listaTransicionesLR;
    }

    public ArrayList<Produccion> getListaProducciones() {
        return listaProducciones;
    }

    public void setListaProducciones(ArrayList<Produccion> listaProducciones) {
        this.listaProducciones = listaProducciones;
    }
    
    
    public void desplegar(){
        for (int i = 0; i < listaProducciones.size(); i++) {
            System.out.print(listaProducciones.get(i).getId()+".\t"+listaProducciones.get(i).transiciono+" () "+listaProducciones.get(i).getNombreNoTerminal()+" -> ");
            listaProducciones.get(i).desplegarExpresiones();
            listaProducciones.get(i).desplegarSimbolosPreAnalisis();
        }
        desplegarTransiciones();
    }
    
    public void desplegarTransiciones(){
        for (int i = 0; i < listaTransicionesLR.size(); i++) {
            System.out.println("con: "+listaTransicionesLR.get(i).getTokenTransicion()+" se va a "+listaTransicionesLR.get(i).getNumIrA()+"\t "+listaTransicionesLR.get(i).getTipoTransicion());
        }
    }
    
}
