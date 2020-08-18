
package proyecto1compi2;

import analisis.AnalizadorLexico;
import analisis.AnalizadorSintactico;
import java.io.IOException;
import java.io.StringReader;
import ventanas.VentanaInicio;

public class Main {

    
    public static void main(String[] args) throws IOException, Exception {
        VentanaInicio ventanaInicio = new VentanaInicio();
        ventanaInicio.setVisible(true);
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
"palabras = \"abcd\";\n" +
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
        System.out.println("Arboles: "+sintactico.listaExpReg.size());
        for (int i = 0; i < sintactico.listaExpReg.size(); i++) {
            System.out.println("Nombre exp: "+sintactico.listaExpReg.get(i).getNombre());
            sintactico.listaExpReg.get(i).getArbol().iniciarRecorridoPrimeroUltimos();
        }
        
        
        
        //sintactico.listaExpReg.get(0).getArbol().recorrer(sintactico.listaExpReg.get(0).getArbol().getRaiz());
        
        
//        Process p = Runtime.getRuntime().exec("system.out.println(\"Hola\")");
//        Process p = Runtime.getRuntime().exec("System.out.println(\"Hola\");");
    }
    
}
