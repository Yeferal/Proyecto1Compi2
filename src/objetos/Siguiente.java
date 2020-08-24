
package objetos;

import java.util.ArrayList;

public class Siguiente {
    
    private Nodo nodoFinal;
    public String nombreToken;
    private ArrayList<Integer> listaSiguientes = new ArrayList<>();

    public Siguiente(Nodo nodoFinal) {
        this.nodoFinal = nodoFinal;
        nombreToken = nodoFinal.getNombreToken();
    }

    public Nodo getNodoFinal() {
        return nodoFinal;
    }

    public void setNodoFinal(Nodo nodoFinal) {
        this.nodoFinal = nodoFinal;
    }

    public ArrayList<Integer> getListaSiguientes() {
        return listaSiguientes;
    }

    public void setListaSiguientes(ArrayList<Integer> listaSiguientes) {
        this.listaSiguientes = listaSiguientes;
    }
    
    
    public void agregarSiguientes(ArrayList<Integer> siguientes){
        //System.out.println("los siguiente  que recibe son: "+siguientes);
        for (int i = 0; i < siguientes.size(); i++) {
            insertarUnSiguiente(siguientes.get(i));
        }
        //System.out.println("LOS SIGUIENTES CTUALES SON: "+listaSiguientes);
    }
    
    
    public void insertarUnSiguiente(int sig){
        boolean existe = false;
        
        for (int i = 0; i < listaSiguientes.size(); i++) {
            if(sig==listaSiguientes.get(i)){
                existe = true;
                //System.out.println("Existe uno similar");
                break;
            }
        }
        
        if(!existe){
            //System.out.println("No existe y agrego");
            listaSiguientes.add(sig);
            ordenar();
        }
    }
    
    public void ordenar(){
        for (int i = 1; i < listaSiguientes.size(); i++) {
            int bandera = i;
            int aux = listaSiguientes.get(i);
                
            while (bandera>0 && aux<listaSiguientes.get(bandera-1)) {                    
                listaSiguientes.set(bandera, listaSiguientes.get(bandera-1));
                listaSiguientes.set(bandera-1, aux);
                bandera--;
            } 
        }
    }
}
