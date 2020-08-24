
package objetos;

import java.util.ArrayList;

public class TablaSiguientes {
    
    public ArrayList<Siguiente> tablaSig = new ArrayList<>();
    public ArrayList<String> listaCaracteres = new ArrayList<>();
    
    
    public void agregarSiguiente(Siguiente siguiente){
        tablaSig.add(siguiente);
    }
    
    public void desplegarTabla(){
        System.out.println("Tabla de Siguientes");
        for (int i = 0; i < tablaSig.size(); i++) {
            System.out.print(tablaSig.get(i).nombreToken+"\t"+tablaSig.get(i).getNodoFinal().getLexema());
            System.out.print(", "+tablaSig.get(i).getNodoFinal().getId());
            System.out.print(" -- \t");
            System.out.println(tablaSig.get(i).getListaSiguientes());
        }
    }
    
    
    public void listarCaracteres(){
        listaCaracteres.clear();
        for (int i = 0; i < tablaSig.size(); i++) {
            if(tablaSig.get(i).getNodoFinal().getTipo()!=6){
                for (int j = 0; j < tablaSig.get(i).getNodoFinal().listaCaracteres.size(); j++) {
                    verifiacarExistenciaCaracter(tablaSig.get(i).getNodoFinal().listaCaracteres.get(j));
                }
            }
            
        }
        
    }
    public void verifiacarExistenciaCaracter(String caracter){
        boolean isExist = false;
        for (int i = 0; i < listaCaracteres.size(); i++) {
            if(caracter.equals(listaCaracteres.get(i))){
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            
            listaCaracteres.add(caracter);
        }
    }
    
    public void deplegarCaracteres(){
        System.out.println(listaCaracteres);
    }
    
}
