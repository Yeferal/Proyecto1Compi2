
package lalr;

import java.io.Serializable;
import java.util.ArrayList;

public class TablaTerminalesNoT implements Serializable{
    
    
    ArrayList<String> terminales = new ArrayList<>();
    ArrayList<String> noTerminales = new ArrayList<>();
    int bandera;

    public ArrayList<String> getTerminales() {
        return terminales;
    }

    public int getBandera() {
        return bandera;
    }

    public void setBandera(int bandera) {
        this.bandera = bandera;
    }
    
    

    public void setTerminales(ArrayList<String> terminales) {
        this.terminales = terminales;
    }

    public ArrayList<String> getNoTerminales() {
        return noTerminales;
    }

    public void setNoTerminales(ArrayList<String> noTerminales) {
        this.noTerminales = noTerminales;
    }
    
    public void agregarTerminal(String terminal){
        terminales.add(terminal);
    }
    
    public void agregarNoTerminal(String noTerminal){
        noTerminales.add(noTerminal);
    }
    
    
    public boolean isExistTerminal(String terminal){
        for (int i = 0; i < terminales.size(); i++) {
            if(terminales.get(i).equals(terminal)){
                
                return true;
            }
        }
        agregarTerminal(terminal);
        return false;
    }
    
    public boolean isExistNoTerminal(String noTerminal){
        for (int i = 0; i < noTerminales.size(); i++) {
            if(noTerminales.get(i).equals(noTerminal)){
                return true;
            }
        }
        agregarNoTerminal(noTerminal);
        return false;
    }
    
    public void desplegarTerminales(){
        System.out.println("Terminales");
        for (int i = 0; i < terminales.size(); i++) {
            System.out.println((i+1)+".\t"+terminales.get(i));
        }
    }
    
    public void desplegarNoTerminales(){
        System.out.println("No Terminales");
        for (int i = 0; i < noTerminales.size(); i++) {
            System.out.println((i+1)+".\t"+noTerminales.get(i));
        }
    }
    
    public boolean buscarNoTerminal(String nombre){
        for (int i = 0; i < noTerminales.size(); i++) {
            if(nombre.equals(noTerminales.get(i))){
                System.out.println("Existe el no terminal: "+nombre);
                return true;
            }
        }
        return false;
    }
    
    public boolean buscarExpresion(String nombre){
        boolean encontrado = false;
        for (int i = 0; i < terminales.size(); i++) {
            if(nombre.equals(terminales.get(i))){
                encontrado = true;
                System.out.println("Existe el terminal exp: "+nombre);
                bandera = 1;
                return true;
            }
        }
        for (int i = 0; i < noTerminales.size(); i++) {
            if(nombre.equals(noTerminales.get(i))){
                encontrado = true;
                System.out.println("Existe el no terminal exp: "+nombre);
                bandera = 2;
                return true;
            }
        }
        bandera = 0;
        return false;
    }
    
}
