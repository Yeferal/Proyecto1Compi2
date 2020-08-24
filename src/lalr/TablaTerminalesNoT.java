
package lalr;

import java.util.ArrayList;

public class TablaTerminalesNoT {
    
    
    ArrayList<String> terminales = new ArrayList<>();
    ArrayList<String> noTerminales = new ArrayList<>();

    public ArrayList<String> getTerminales() {
        return terminales;
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
    
}
