
package objetos;

public class Arbol {
    /*TIPOS
    1. concatenacion    (.)
    2. asterisco        (*)
    3. mas              (+)
    4. separador o      (|)
    5. caracter         (char)
    6. final cadena     (#)
    7. una o nada       (?)
    8. lambda           ("")
    */
    Nodo raiz;
    int indice;

    public Arbol(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    
    
    public void iniciarRecorridoPrimeroUltimos(){
        indice = 1;
        generarIndices(raiz);
        recorrer(raiz);
    }
    
    public void generarIndices(Nodo nodo){
        //System.out.println("Nodo: "+nodo.getLexema());
        if(nodo!= null && nodo.getIzquierdaNodo()==null){
            switch(nodo.getTipo()){
                case 5:
                    //cuando es un caracter
                    nodo.setId(indice);
                    nodo.getPrimeros().add(indice);
                    nodo.getSiguientes().add(indice);
                    indice++;
                    break;
                case 8:
                    //cuando es un lambda
                    nodo.setId(0);
                    break;
                case 6:
                    //cuado es una final de cadena
                    nodo.setId(indice);
                    nodo.getPrimeros().add(indice);
                    nodo.getSiguientes().add(indice);
                    indice++;
                    break;
            }
        }else{
            if(nodo!=null){
                generarIndices(nodo.getIzquierdaNodo());
                generarIndices(nodo.getDerechaNodo());
                //generarPrimerosUltmios(nodo);
            }
            
        }
    }
    
    public void recorrer(Nodo nodo){
        if(nodo!= null && nodo.getIzquierdaNodo()==null){
            System.out.println("NodoH: "+nodo.getLexema()+"----->"+nodo.getId());
        }else{
            if(nodo!=null){
                recorrer(nodo.getIzquierdaNodo());
                System.out.println("NodoP: "+nodo.getLexema()+"----->"+nodo.getId());
                recorrer(nodo.getDerechaNodo());
                
            }
            
        }
    }
    
    public void generarPrimerosUltmios(Nodo nodo){
        switch(nodo.getTipo()){
            case 1:
                //Primero Ultimos nodo concat
                concatenarNodoPU(nodo);
                break;
            case 2:
                //estrella nodos ultimos u primeros
                estrellaNodoPU(nodo);
                break;
            case 3:
                //estrella nodos ultimos u primeros
                estrellaNodoPU(nodo);
                break;
            case 4:
                //| o primeros ultimos
                lineaONodoPU(nodo);
                break;
        }
        
        
        if(nodo.getIzquierdaNodo().isAnulable()){
            nodo.getPrimeros();
        }
    }
    
    public void concatenarNodoPU(Nodo nodo){
        if(nodo.getIzquierdaNodo().isAnulable()){
            for (int i = 0; i < nodo.getIzquierdaNodo().getPrimeros().size(); i++) {
                nodo.getPrimeros().add(nodo.getIzquierdaNodo().getPrimeros().get(indice));
            }
            for (int i = 0; i < nodo.getDerechaNodo().getPrimeros().size(); i++) {
                nodo.getPrimeros().add(nodo.getDerechaNodo().getPrimeros().get(indice));
            }
        }else{
            for (int i = 0; i < nodo.getIzquierdaNodo().getPrimeros().size(); i++) {
                nodo.getPrimeros().add(nodo.getIzquierdaNodo().getPrimeros().get(indice));
            }
        }
        
        if(nodo.getDerechaNodo().isAnulable()){
            for (int i = 0; i < nodo.getIzquierdaNodo().getSiguientes().size(); i++) {
                nodo.getSiguientes().add(nodo.getIzquierdaNodo().getSiguientes().get(indice));
            }
            for (int i = 0; i < nodo.getDerechaNodo().getSiguientes().size(); i++) {
                nodo.getSiguientes().add(nodo.getDerechaNodo().getSiguientes().get(indice));
            }
        }else{
            for (int i = 0; i < nodo.getDerechaNodo().getSiguientes().size(); i++) {
                nodo.getSiguientes().add(nodo.getIzquierdaNodo().getSiguientes().get(indice));
            }
        }
    }
    
    public void estrellaNodoPU(Nodo nodo){

            for (int i = 0; i < nodo.getIzquierdaNodo().getPrimeros().size(); i++) {
                nodo.getPrimeros().add(nodo.getIzquierdaNodo().getPrimeros().get(indice));
            }

            for (int i = 0; i < nodo.getDerechaNodo().getSiguientes().size(); i++) {
                nodo.getSiguientes().add(nodo.getIzquierdaNodo().getSiguientes().get(indice));
            }
    }
    
    public void lineaONodoPU(Nodo nodo){
            for (int i = 0; i < nodo.getIzquierdaNodo().getPrimeros().size(); i++) {
                nodo.getPrimeros().add(nodo.getIzquierdaNodo().getPrimeros().get(indice));
            }
            for (int i = 0; i < nodo.getDerechaNodo().getPrimeros().size(); i++) {
                nodo.getPrimeros().add(nodo.getDerechaNodo().getPrimeros().get(indice));
            }
            for (int i = 0; i < nodo.getIzquierdaNodo().getSiguientes().size(); i++) {
                nodo.getSiguientes().add(nodo.getIzquierdaNodo().getSiguientes().get(indice));
            }
            for (int i = 0; i < nodo.getDerechaNodo().getSiguientes().size(); i++) {
                nodo.getSiguientes().add(nodo.getDerechaNodo().getSiguientes().get(indice));
            }
    }
    
    
}
