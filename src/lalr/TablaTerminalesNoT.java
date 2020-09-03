
package lalr;

import automata.TerminalNoT;
import java.io.Serializable;
import java.util.ArrayList;

public class TablaTerminalesNoT implements Serializable{
    
    
//    ArrayList<String> terminales = new ArrayList<>();
//    ArrayList<String> noTerminales = new ArrayList<>();
//    
    ArrayList<TerminalNoT> terminales = new ArrayList<>();
    ArrayList<TerminalNoT> noTerminales = new ArrayList<>();
    
    int bandera;
    public int posicionTerminal;

    public ArrayList<TerminalNoT> getTerminales() {
        return terminales;
    }

    public int getBandera() {
        return bandera;
    }

    public void setBandera(int bandera) {
        this.bandera = bandera;
    }
    
    

    public void setTerminales(ArrayList<TerminalNoT> terminales) {
        this.terminales = terminales;
    }

    public ArrayList<TerminalNoT> getNoTerminales() {
        return noTerminales;
    }

    public void setNoTerminales(ArrayList<TerminalNoT> noTerminales) {
        this.noTerminales = noTerminales;
    }
    
    public void agregarTerminal(TerminalNoT terminal){
        terminales.add(terminal);
    }
    
    public void agregarNoTerminal(TerminalNoT noTerminal){
        noTerminales.add(noTerminal);
    }
    
    
    public boolean isExistTerminal(String terminal, int nivel){
        for (int i = 0; i < terminales.size(); i++) {
            if(terminales.get(i).getNombre().equals(terminal)){
                
                return true;
            }
        }
        agregarTerminal(new TerminalNoT(terminal, nivel));
        return false;
    }
    
    public boolean isExistNoTerminal(String noTerminal, int nivel){
        for (int i = 0; i < noTerminales.size(); i++) {
            if(noTerminales.get(i).getNombre().equals(noTerminal)){
                return true;
            }
        }
        agregarNoTerminal(new TerminalNoT(noTerminal, nivel));
        return false;
    }
    
    public void desplegarTerminales(){
        System.out.println("Terminales");
        for (int i = 0; i < terminales.size(); i++) {
            System.out.println((i+1)+".\t"+terminales.get(i).getNombre());
        }
    }
    
    public void desplegarNoTerminales(){
        System.out.println("No Terminales");
        for (int i = 0; i < noTerminales.size(); i++) {
            System.out.println((i+1)+".\t"+noTerminales.get(i).getNombre());
        }
    }
    
    public boolean buscarTerminal(String nombre){
        for (int i = 0; i < terminales.size(); i++) {
            if(nombre.equals(terminales.get(i).getNombre())){
                posicionTerminal = i;
                return true;
            }
        }
        return false;
    }
    
    public boolean buscarNoTerminal(String nombre){
        for (int i = 0; i < noTerminales.size(); i++) {
            if(nombre.equals(noTerminales.get(i).getNombre())){
                System.out.println("Existe el no terminal: "+nombre);
                return true;
            }
        }
        return false;
    }
    
    public boolean buscarExpresion(String nombre){
        boolean encontrado = false;
        for (int i = 0; i < terminales.size(); i++) {
            if(nombre.equals(terminales.get(i).getNombre())){
                encontrado = true;
                System.out.println("Existe el terminal exp: "+nombre);
                bandera = 1;
                return true;
            }
        }
        for (int i = 0; i < noTerminales.size(); i++) {
            if(nombre.equals(noTerminales.get(i).getNombre())){
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
