
package error;

public class Error {
    /*Tipo de error
    1. Lexico
    2. Sintactico
    3. Semantico
    */
    
    
    private String token;
    private int fila, columna, tipoError;
    private String descripcion;

    public Error(String token, int fila, int columna, int tipoError, String descripcion) {
        this.token = token;
        this.fila = fila;
        this.columna = columna;
        this.tipoError = tipoError;
        this.descripcion = descripcion;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getTipoError() {
        return tipoError;
    }

    public void setTipoError(int tipoError) {
        this.tipoError = tipoError;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String toString(){
        return "Token: "+token+",\tFila: "+fila+",\tColumna: "+columna+",\tTipoError: "+getTextoTipo()+",\tDescripcion: "+descripcion;
    }
    
    public String getTextoTipo(){
        switch(tipoError){
            case 1:
                return "Lexico";
            case 2:
                return "Sintactico";
            case 3:
                return "Semantico";
                default:
                    return "";
        }
    }
}
