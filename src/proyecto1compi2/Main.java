
package proyecto1compi2;

import analisis.AnalizadorLexico;
import analisis.AnalizadorSintactico;
import analisis.comprobaciones.AnalizadorLexicoC;
import analisis.comprobaciones.AnalizadorSintacticoC;
import automata.GeneradorEstadoAutamata;
import automata.ManejadorLexico;
import java.io.IOException;
import java.io.StringReader;
import objetos.Arbol;
import objetos.ManejadorNodos;
import objetos.Nodo;
import ventanas.VentanaInicio;

public class Main {

    int b = 0;
    public static void main(String[] args) throws IOException, Exception {
        //VentanaInicio ventanaInicio = new VentanaInicio();
        //ventanaInicio.setVisible(true);
        String texto = "este    eside";
        String texto1 = "//Informacion del lenguaje\n" +
        "nombre: java;\n" +
        "version: 11.0.7;\n" +
        "autor: sun Microsystems;\n" +
        "lanzamiento: 1996;\n" +
        "extension: java;\n" +
        "%% //codigo fuente\n" +
        "List<String> listString=new ArrayList<>();\n" +
        "public void addString(String valor){\n" +
        "listString.add(valor);\n" +
        "}\n" +
        "public Integer suma(Integer numero1,Integer numero2){\n" +
        "return numero1+numero2;\n" +
        "}\n" +
        "%% //Sección de expresiones regulares\n" +
        //"palabras = \"abc\";\n" +
        //"ases = .;\n" +
        "palabra = [a-z]+;\n" +
        "entero = [0-9]+;\n" +
        "real = [0-9]+((.)[0-9]+)?;\n" +
        "mas = \"+\";\n" +
        "menos = \"-\";\n" +
        "& = [\\n\\t]; /* Significa que cuando se encuentre este token deberá ser ignorado */\n" +
        "%% //Seccion de simbolos terminales y no terminales\n" +
        "terminal por, div;\n" +
        "terminal mas, menos;\n" +
        "terminal entero;\n" +
        "no terminal A, B;\n" +
        "no terminal S;\n" +
        "%%\n" +
        "S :: E:val {printf(\"Resultado = %d\",val);};\n" +
        "E :: E:val menos E:val2 {RESULT=val - val2;};\n" +
        "E :: E:val mas E:val2 {RESULT=val + val2;};\n" +
        "E :: E:val por E:val2 {RESULT=val * val2;};\n" +
        "E :: E:val div E:val2 {RESULT=val / val2;};\n" +
        "E :: entero:val {RESULT=val;};";
        AnalizadorLexico lexico =  new AnalizadorLexico(new StringReader(texto1));
        AnalizadorSintactico sintactico = new AnalizadorSintactico(lexico);
        sintactico.parse();
        Arbol arFinal = new Arbol(null);
        Nodo nodo = null;
        ManejadorNodos m = new ManejadorNodos();
        GeneradorEstadoAutamata ge = new GeneradorEstadoAutamata();
        for (int i = 0; i < sintactico.listaExpReg.size(); i++) {
            if(i==0){
                nodo = sintactico.listaExpReg.get(i).getArbol().getRaiz();
            }else{
                nodo = m.generarPadre(nodo, sintactico.listaExpReg.get(i).getArbol().getRaiz(), 4, "|", m.determinarAnulabilidad(nodo,sintactico.listaExpReg.get(i).getArbol().getRaiz()), "");
            }
            System.out.println("Tp: "+nodo.getIzquierdaNodo().getNombreToken());
        }
        Nodo node = new Nodo(6,"#",false, "");
        Nodo raiz = m.generarPadre(nodo, node,1,".",false, "");
        arFinal = new Arbol(raiz);
        
        arFinal.iniciarRecorridoPrimeroUltimos();
        arFinal.tablaS.listarCaracteres();
        arFinal.tablaS.deplegarCaracteres();
//        arFinal.tablaS.generarTablaEstados(arFinal);
        ge.generarEstados(arFinal);
        
        String textoF = "ho*la fda 2443 3443.434 + - +";
        String [] arre = textoF.split("");
        System.out.println(arre[4]);
        ManejadorLexico manejadorLexico = new ManejadorLexico();
        manejadorLexico.iniciarRecorrido(ge.listaFilasAutomatas, textoF);
        
        
        
        
        
        
        
        
        
        
//        GeneradorEstadoAutamata ge = new GeneradorEstadoAutamata();
//        System.out.println("Arboles: "+sintactico.listaExpReg.size());
//        for (int i = 0; i < sintactico.listaExpReg.size(); i++) {
//            System.out.println("Nombre exp: "+sintactico.listaExpReg.get(i).getNombre());
//            sintactico.listaExpReg.get(i).getArbol().iniciarRecorridoPrimeroUltimos();
//            sintactico.listaExpReg.get(i).getArbol().tablaS.listarCaracteres();
//            sintactico.listaExpReg.get(i).getArbol().tablaS.deplegarCaracteres();
//            sintactico.listaExpReg.get(i).getArbol().tablaS.generarTablaEstados(sintactico.listaExpReg.get(i).getArbol());
//            ge.generarEstados(sintactico.listaExpReg.get(i).getArbol());
//        }
//        
//        
//        
//        int l = 4;
        
//        int c = (int)'ñ';
//        System.out.println("ascii: "+c);
//        AnalizadorLexicoC analizadorLexicoC = new AnalizadorLexicoC(new StringReader("DSFDF"));
//        AnalizadorSintacticoC analizadorSintacticoC = new AnalizadorSintacticoC(analizadorLexicoC);
//        analizadorSintacticoC.parse();
//        switch(analizadorSintacticoC.getTipo()){
//            case 1:
//                System.out.println("MINUSCULAS");
//                break;
//            case 2:
//                System.out.println("MAYUSCULAS");
//                break;
//            case 0:
//                System.out.println("error");
//                break;
//        }
        
        
    }
    
    
    
}
