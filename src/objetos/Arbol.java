
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
    public TablaSiguientes tablaS = new TablaSiguientes();

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
        recorrerParaSiguientes(raiz);
        //recorrer(raiz);
        tablaS.desplegarTabla();
        
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
                    
                    tablaS.agregarSiguiente(new Siguiente(nodo));
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
                    tablaS.agregarSiguiente(new Siguiente(nodo));
                    indice++;
                    break;
            }
        }else{
            if(nodo!=null){
                generarIndices(nodo.getIzquierdaNodo());
                generarIndices(nodo.getDerechaNodo());
                generarPrimerosUltmios(nodo);
            }
            
        }
    }
    
    public void recorrer(Nodo nodo){
        if(nodo!= null && nodo.getIzquierdaNodo()==null){
            System.out.println("NodoH: "+nodo.getLexema()+"----->"+nodo.getId());
            nodo.desplegar();
        }else{
            if(nodo!=null){
                recorrer(nodo.getIzquierdaNodo());
                System.out.println("NodoP: "+nodo.getLexema()+"----->"+nodo.getId());
                nodo.desplegar();
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
        
       
    }
    
    public void concatenarNodoPU(Nodo nodo){
        if(nodo.getIzquierdaNodo().isAnulable()){
            for (int i = 0; i < nodo.getIzquierdaNodo().getPrimeros().size(); i++) {
                nodo.getPrimeros().add(nodo.getIzquierdaNodo().getPrimeros().get(i));
            }
            for (int i = 0; i < nodo.getDerechaNodo().getPrimeros().size(); i++) {
                nodo.getPrimeros().add(nodo.getDerechaNodo().getPrimeros().get(i));
            }
            //System.out.println("OP:"+1);
        }else{
            for (int i = 0; i < nodo.getIzquierdaNodo().getPrimeros().size(); i++) {
                nodo.getPrimeros().add(nodo.getIzquierdaNodo().getPrimeros().get(i));
            }
            //System.out.println("OP:"+12);
        }
        
        if(nodo.getDerechaNodo().isAnulable()){
            for (int i = 0; i < nodo.getIzquierdaNodo().getSiguientes().size(); i++) {
                nodo.getSiguientes().add(nodo.getIzquierdaNodo().getSiguientes().get(i));
            }
            for (int i = 0; i < nodo.getDerechaNodo().getSiguientes().size(); i++) {
                nodo.getSiguientes().add(nodo.getDerechaNodo().getSiguientes().get(i));
            }
            //System.out.println("OP:"+2);
        }else{
            //System.out.println("ENCONTRADOS: "+nodo.getDerechaNodo().getSiguientes());
            for (int i = 0; i < nodo.getDerechaNodo().getSiguientes().size(); i++) {
                nodo.getSiguientes().add(nodo.getDerechaNodo().getSiguientes().get(i));
            }
            //System.out.println("OP:"+22);
        }
        pintarNodo(nodo);
        //System.out.println();
    }
    
    public void estrellaNodoPU(Nodo nodo){

            for (int i = 0; i < nodo.getIzquierdaNodo().getPrimeros().size(); i++) {
                nodo.getPrimeros().add(nodo.getIzquierdaNodo().getPrimeros().get(i));
            }

            for (int i = 0; i < nodo.getIzquierdaNodo().getSiguientes().size(); i++) {
                nodo.getSiguientes().add(nodo.getIzquierdaNodo().getSiguientes().get(i));
            }
    }
    
    public void lineaONodoPU(Nodo nodo){
            for (int i = 0; i < nodo.getIzquierdaNodo().getPrimeros().size(); i++) {
                nodo.getPrimeros().add(nodo.getIzquierdaNodo().getPrimeros().get(i));
            }
            for (int i = 0; i < nodo.getDerechaNodo().getPrimeros().size(); i++) {
                nodo.getPrimeros().add(nodo.getDerechaNodo().getPrimeros().get(i));
            }
            for (int i = 0; i < nodo.getIzquierdaNodo().getSiguientes().size(); i++) {
                nodo.getSiguientes().add(nodo.getIzquierdaNodo().getSiguientes().get(i));
            }
            for (int i = 0; i < nodo.getDerechaNodo().getSiguientes().size(); i++) {
                nodo.getSiguientes().add(nodo.getDerechaNodo().getSiguientes().get(i));
            }
    }
    
    public void recorrerParaSiguientes(Nodo nodo){
        if(nodo!= null && nodo.getIzquierdaNodo()==null){
            
        }else{
            if(nodo.getIzquierdaNodo()!=null){
                recorrerParaSiguientes(nodo.getIzquierdaNodo());
            }
            if(nodo.getDerechaNodo()!=null){
                recorrerParaSiguientes(nodo.getDerechaNodo());
            }
            
            
            switch(nodo.getTipo()){
                case 1:
                    //Primero Ultimos nodo concat
                    agregarSiguientesConcat(nodo);

                    break;
                case 2:
                    //estrella nodos ultimos u primeros
                    agregarSiguientesEstrella(nodo);

                    break;
                case 3:
                    //estrella nodos ultimos u primeros
                    agregarSiguientesEstrella(nodo);
                    break;
            }
        }
    }
    
    public void agregarSiguientesConcat(Nodo padre){
//        System.out.println("              Para el Nodo: "+padre.getLexema());
//        System.out.println("  PP: "+padre.getPrimeros());
//        System.out.println("  PU: "+padre.getSiguientes());
//            System.out.println("para: "+padre.getIzquierdaNodo().getSiguientes());
//            System.out.println("los: "+padre.getDerechaNodo().getPrimeros());
//        pintarNodo(padre);
        for (int i = 0; i < padre.getIzquierdaNodo().getSiguientes().size(); i++) {
//            System.out.println("Fi: "+tablaS.tablaSig.get(padre.getIzquierdaNodo().getSiguientes().get(i)-1).getListaSiguientes());
            tablaS.tablaSig.get(padre.getIzquierdaNodo().getSiguientes().get(i)-1).agregarSiguientes(padre.getDerechaNodo().getPrimeros());
//            System.out.println("PR: "+(padre.getIzquierdaNodo().getSiguientes().get(i)-1)+"======="+padre.getDerechaNodo().getPrimeros());
//            System.out.println("Ff: "+tablaS.tablaSig.get(padre.getIzquierdaNodo().getSiguientes().get(i)-1).getListaSiguientes());
        }
    }
    public void agregarSiguientesEstrella(Nodo padre){
        for (int i = 0; i < padre.getPrimeros().size(); i++) {
            tablaS.tablaSig.get(padre.getIzquierdaNodo().getSiguientes().get(i)-1).agregarSiguientes(padre.getSiguientes());
        }
    }
    
    public void pintarNodo(Nodo nodo){
        System.out.println("                "+nodo.isAnulable());
        System.out.println("                "+nodo.getPrimeros()+"("+nodo.getLexema()+")"+nodo.getSiguientes());
        System.out.println("                 /      \\");
        System.out.println("                /        \\");
        System.out.print("     "+nodo.getIzquierdaNodo().isAnulable()+"-"+nodo.getIzquierdaNodo().getPrimeros()+"("+nodo.getIzquierdaNodo().getLexema()+")"+nodo.getIzquierdaNodo().getSiguientes());
        System.out.println("     "+nodo.getDerechaNodo().isAnulable()+"-"+nodo.getDerechaNodo().getPrimeros()+"("+nodo.getDerechaNodo().getLexema()+")"+nodo.getDerechaNodo().getSiguientes());

    }
    
}
