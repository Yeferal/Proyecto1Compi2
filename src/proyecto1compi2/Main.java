
package proyecto1compi2;

import analisis.AnalizadorLexico;
import analisis.AnalizadorSintactico;
import analisis.comprobaciones.AnalizadorLexicoC;
import analisis.comprobaciones.AnalizadorSintacticoC;
import automata.GeneradorEstadoAutamata;
import automata.ManejadorLexico;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import lalr.GeneradorEstadosLALR;
import lalr.TablaProducciones;
import lalr.TablaTerminalesNoT;
import lalr.TablaTransiciones;
import lalr.lectura.TablaPila;
import objetos.Arbol;
import objetos.ManejadorNodos;
import objetos.Nodo;
import ventanas.VentanaInicio;

public class Main {

    int b = 0;
    public static void main(String[] args) throws IOException, Exception {
        VentanaInicio ventanaInicio = new VentanaInicio();
        ventanaInicio.setVisible(true);
        
        
        
        
        
        
        
        
        
        
        
//        String texto = "este    eside";
//        String texto1 = "//Informacion del lenguaje\n" +
//        "nombre: java;\n" +
//        "version: 11.0.7;\n" +
//        "autor: sun Microsystems;\n" +
//        "lanzamiento: 1996;\n" +
//        "extension: java;\n" +
//        "%% //codigo fuente\n" +
//        "List<String> listString=new ArrayList<>();\n" +
//        "public void addString(String valor){\n" +
//        "listString.add(valor);\n" +
//        "}\n" +
//        "public Integer suma(Integer numero1,Integer numero2){\n" +
//        "return numero1+numero2;\n" +
//        "}\n" +
//        "%% //Sección de expresiones regulares\n" +
        //"palabras = \"abc\";\n" +
        //"ases = .;\n" +
//        "palabra = [a-z]+;\n" +
//        "entero = [0-9]+;\n" +
//        "real = [0-9]+((.)[0-9]+)?;\n" +
//        "mas = \"+\";\n" +
//        "por = \"*\";\n" +
//        "xd = \"x\";\n" +
//        "menos = \"-\";\n" +
//        "igual = \"=\";\n" +
//        "& = [\\n\\t]; /* Significa que cuando se encuentre este token deberá ser ignorado */\n" +
//        "%% //Seccion de simbolos terminales y no terminales\n" +
        //"terminal por, div;\n" +
        //"terminal mas, menos, por,xd, igual;\n" +
//        "terminal por,xd, igual;\n" +
//        "terminal entero;\n" +
//        "no terminal S, E, V;\n" +
//        "no terminal S;\n" +
        //"terminal   pc, pa, entero, id, por, mas;\n" +
 //       "terminal entero;\n" +
        //"no terminal  F, T, E;\n" +
//        "no terminal F;\n" +
//        "%%\n" +
//                
//        "S :: V igual E:val {printf(\"Resultado = %d\",val);};\n" +
//        "S :: E:val {printf(\"Resultado = %d\",val);};\n" +
//        "E :: V {printf(\"Resultado = %d\",val);};\n" +
//        "V :: xd:val {printf(\"Resultado = %d\",val);};\n" +
                
        //"S :: E:val {printf(\"Resultado = %d\",val);};\n" +   
        //"S :: B:val {printf(\"Resultado = %d\",val);};\n" +
        //"B :: B mas:val {printf(\"Resultado = %d\",val);};\n" +     
        //"E :: E:val menos E:val2 {RESULT=val - val2;};\n" +
        //"E :: E:val mas E:val2 {RESULT=val + val2;};\n" +      
        //"E :: E:val por E:val2 {RESULT=val * val2;};\n" +
        //"E :: E:val div E:val2 {RESULT=val / val2;};\n" +
        //"E :: entero:val {RESULT=val;};";
                
//        "F :: pa:val E pc {printf(\"Resultado = %d\",val);};\n" + 
//        "F :: entero:val {RESULT=val * val2;};\n" +    
//        "F :: id:val {RESULT=val + val2;};\n" +
//        "T :: F:val por T:val2 {RESULT=val - val2;};\n" +
//        "T :: F {printf(\"Resultado = %d\",val);};\n" +   
//        "E :: E mas T:val {printf(\"Resultado = %d\",val);};\n" +  
//        "E :: T:val {RESULT=val;};";
                
//        "E :: E mas T:val {printf(\"Resultado = %d\",val);};\n" + 
//        "E :: T:val {printf(\"Resultado = %d\",val);};\n" +        
//        "T :: F:val por T:val2 {RESULT=val - val2;};\n" +
//        "T :: F {printf(\"Resultado = %d\",val);};\n" + 
//        "F :: id:val {RESULT=val * val2;};\n" +    
//        "F :: entero:val {RESULT=val + val2;};\n" +
//        "F :: pa:val E pc {RESULT=val;};";
        
        //"E :: entero:val {RESULT=val;};";
//        "V :: por E:val {RESULT=val;};";
//        AnalizadorLexico lexico =  new AnalizadorLexico(new StringReader(texto1));
//        AnalizadorSintactico sintactico = new AnalizadorSintactico(lexico);
//        sintactico.parse();
//        TablaTerminalesNoT tablaTerminalesNoT = sintactico.tablaTerminalesNoT;
//        tablaTerminalesNoT.desplegarTerminales();
//        tablaTerminalesNoT.desplegarNoTerminales();
//        
//        TablaProducciones tablaProducciones = sintactico.tablaProducciones;
//        tablaProducciones.generarEstadoInicial();
//        tablaProducciones.desplegarProducciones();
//        System.out.println("");
//        
//        GeneradorEstadosLALR generadorEstadosLALR = new GeneradorEstadosLALR();
//        generadorEstadosLALR.inciarEstado(tablaProducciones.listaProducciones, tablaTerminalesNoT);
//        System.out.println("===========================Estados===========================");
//        generadorEstadosLALR.pintarEstados();
//        
//        TablaTransiciones tablaTransiciones = new TablaTransiciones();
//        tablaTransiciones.generarTabla(generadorEstadosLALR.listaEstadoLR, tablaTerminalesNoT);
//        //generadorEstadosLALR.pintarProducciones();
//        //tablaProducciones.desplegarProducciones();
//        
//        LinkedList<String> cola = new LinkedList<>();
//        cola.offer("xd");
//        cola.offer("igual");
//        cola.offer("xd");
//        cola.offer("$");
//        TablaPila tablaPila = new TablaPila();
//        tablaPila.iniciarPila(tablaProducciones.listaProducciones, tablaTransiciones.tablaTransiciones, tablaTerminalesNoT, cola);
        
        
        
        
        
        
        
        
        
        
        
//        Arbol arFinal = new Arbol(null);
//        Nodo nodo = null;
//        ManejadorNodos m = new ManejadorNodos();
//        GeneradorEstadoAutamata ge = new GeneradorEstadoAutamata();
//        for (int i = 0; i < sintactico.listaExpReg.size(); i++) {
//            if(i==0){
//                nodo = sintactico.listaExpReg.get(i).getArbol().getRaiz();
//            }else{
//                nodo = m.generarPadre(nodo, sintactico.listaExpReg.get(i).getArbol().getRaiz(), 4, "|", m.determinarAnulabilidad(nodo,sintactico.listaExpReg.get(i).getArbol().getRaiz()), "");
//            }
//            System.out.println("Tp: "+nodo.getIzquierdaNodo().getNombreToken());
//        }
//        Nodo node = new Nodo(6,"#",false, "");
//        Nodo raiz = m.generarPadre(nodo, node,1,".",false, "");
//        arFinal = new Arbol(raiz);
//        
//        arFinal.iniciarRecorridoPrimeroUltimos();
//        arFinal.tablaS.listarCaracteres();
//        arFinal.tablaS.deplegarCaracteres();
////        arFinal.tablaS.generarTablaEstados(arFinal);
//        ge.generarEstados(arFinal);
//        
//        String textoF = "ho*la fda 2443 3443.434 + - +";
//        String [] arre = textoF.split("");
//        System.out.println(arre[4]);
//        ManejadorLexico manejadorLexico = new ManejadorLexico();
//        manejadorLexico.iniciarRecorrido(ge.listaFilasAutomatas, textoF);
        
        
        
        
        
        
        
        
        
    }
    
    
    
}
