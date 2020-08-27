
package lalr;

public class TransicionLR {
    /*Tipos de Transicion
    1. Terminal   SHIFT
    2. No terminal GOTO
    
    */
    
    private String tokenTransicion;
    private int numIrA, tipo;

    public TransicionLR(String tokenTransicion, int numIrA) {
        this.tokenTransicion = tokenTransicion;
        this.numIrA = numIrA;
    }

    public String getTokenTransicion() {
        return tokenTransicion;
    }

    public void setTokenTransicion(String tokenTransicion) {
        this.tokenTransicion = tokenTransicion;
    }

    public int getNumIrA() {
        return numIrA;
    }

    public void setNumIrA(int numIrA) {
        this.numIrA = numIrA;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    public String getTipoTransicion(){
        switch(tipo){
            case 1:
                return "s"+numIrA;
            case 2:
                return "g"+numIrA;
                default:
                    return numIrA+"";
                
        }
    }
    
}
