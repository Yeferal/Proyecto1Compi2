
package analisis;
import java_cup.runtime.*;
import java.util.ArrayList;

%%
%{
    //coidgo de usuario en sintaxis java
    //public ArrayList<ErrorG> listaErrores = new  ArrayList<>();

%}

    //directivas
%public 
%class AnalizadorLexico
%cupsym Simbolos
%cup
%char
%line
%column
%full
//%ignorecase
//%unicode

//expreciones regulares

LetraMin            = ([a-z] | á | é | í | ó | ú | ñ )
LetraMay            = ([A-Z] | Á | É | Í | Ó | Ú | Ñ )
Letra               = ({LetraMin}|{LetraMay})
Identificador      = ({LetraMin}|{Numero}|{LetraMay})({LetraMin}|{Numero}|{LetraMay})+
Digito              = [0-9]
Numero              = {Digito} {Digito}*
Espacio             = [" "\t\r\b]+
Salto               = [\n]
%%

//"hO"		{System.out.println("espacio: "+yytext()); return new Symbol(Simbolos.ESPACIO , yycolumn, yyline, yytext());}
nombre 		{System.out.println("NOMBRE: "+yytext()); return new Symbol(Simbolos.NOMBRE , yycolumn, yyline, yytext());}	//único dato obligatorio
version		{System.out.println("VERSION: "+yytext()); return new Symbol(Simbolos.VERSION , yycolumn, yyline, yytext());}
autor 		{System.out.println("AUTOR: "+yytext()); return new Symbol(Simbolos.AUTOR , yycolumn, yyline, yytext());}
lanzamiento 	{System.out.println("LAZAMIENTO: "+yytext()); return new Symbol(Simbolos.LANZAMIENTO , yycolumn, yyline, yytext());}
extension 	{System.out.println("EXTENSION: "+yytext()); return new Symbol(Simbolos.EXTENSION , yycolumn, yyline, yytext());}
":" 		{System.out.println("DOS PUNTOS: "+yytext()); return new Symbol(Simbolos.DOS_PUNTOS , yycolumn, yyline, yytext());}
";" 		{System.out.println("PUNT COMA: "+yytext()); return new Symbol(Simbolos.PUNTO_COMA , yycolumn, yyline, yytext());}
"."		{System.out.println("PUNTO: "+yytext()); return new Symbol(Simbolos.PUNTO , yycolumn, yyline, yytext());}
"%%"		{System.out.println("SEPARACION: "+yytext()); return new Symbol(Simbolos.SEPARACION , yycolumn, yyline, yytext());}
"?"		{System.out.println("INTERROGACION: "+yytext()); return new Symbol(Simbolos.INTERROGACION , yycolumn, yyline, yytext());}
"*"		{System.out.println("ASTERISCO: "+yytext()); return new Symbol(Simbolos.ASTERISCO , yycolumn, yyline, yytext());}
"+"		{System.out.println("MAS: "+yytext()); return new Symbol(Simbolos.MAS , yycolumn, yyline, yytext());}
"β"		{System.out.println("BETA: "+yytext()); return new Symbol(Simbolos.BETA , yycolumn, yyline, yytext());}
"|"		{System.out.println("LINEA: "+yytext()); return new Symbol(Simbolos.LINEA , yycolumn, yyline, yytext());}
"["		{System.out.println("CORCHETE_A: "+yytext()); return new Symbol(Simbolos.CORCHETE_A , yycolumn, yyline, yytext());}
"]"		{System.out.println("CORCHETE_C: "+yytext()); return new Symbol(Simbolos.CORCHETE_C , yycolumn, yyline, yytext());}
"("		{System.out.println("PARENTESIS_A: "+yytext()); return new Symbol(Simbolos.PARENTESIS_A , yycolumn, yyline, yytext());}
")"		{System.out.println("PARENTESIS_C: "+yytext()); return new Symbol(Simbolos.PARENTESIS_C , yycolumn, yyline, yytext());}
"-"		{System.out.println("GUION: "+yytext()); return new Symbol(Simbolos.GUION , yycolumn, yyline, yytext());}
"\\n"		{System.out.println("SALTO_RESERV: "+yytext()); return new Symbol(Simbolos.SALTO_RESERV , yycolumn, yyline, yytext());}
"\\t"		{System.out.println("TAB_RESERV: "+yytext()); return new Symbol(Simbolos.TAB_RESERV , yycolumn, yyline, yytext());}
"\\b"		{System.out.println("ESPACIO_BLANCO: "+yytext()); return new Symbol(Simbolos.ESPACIO_BLANCO , yycolumn, yyline, yytext());}
"\""		{System.out.println("COMILLAS: "+yytext()); return new Symbol(Simbolos.COMILLAS , yycolumn, yyline, yytext());}
"="		{System.out.println("IGUAL: "+yytext()); return new Symbol(Simbolos.IGUAL , yycolumn, yyline, yytext());}
"&"		{System.out.println("IGNORAR: "+yytext()); return new Symbol(Simbolos.IGNORAR , yycolumn, yyline, yytext());}
terminal	{System.out.println("TERMINAL: "+yytext()); return new Symbol(Simbolos.TERMINAL , yycolumn, yyline, yytext());}
"no terminal"	{System.out.println("NO_TERMINAL: "+yytext()); return new Symbol(Simbolos.NO_TERMINAL , yycolumn, yyline, yytext());}
","		{System.out.println("COMA: "+yytext()); return new Symbol(Simbolos.COMA , yycolumn, yyline, yytext());}
"::"		{System.out.println("DOBLE_PUNTO: "+yytext()); return new Symbol(Simbolos.DOBLE_PUNTO , yycolumn, yyline, yytext());}
"{"		{System.out.println("LLAVES_A: "+yytext()); return new Symbol(Simbolos.LLAVES_A , yycolumn, yyline, yytext());}
"}"		{System.out.println("LLAVES_C: "+yytext()); return new Symbol(Simbolos.LLAVES_C , yycolumn, yyline, yytext());}
"//"		{System.out.println("COMENTARIO_SIMPLE: "+yytext()); return new Symbol(Simbolos.COMENTARIO_SIMPLE , yycolumn, yyline, yytext());}
"/*"		{System.out.println("COMENTARIO_A: "+yytext()); return new Symbol(Simbolos.COMENTARIO_A , yycolumn, yyline, yytext());}
"*/"		{System.out.println("COMENTARIO_C: "+yytext()); return new Symbol(Simbolos.COMENTARIO_C , yycolumn, yyline, yytext());}


<YYINITIAL> {
    {Espacio}                       {/*Ignore*/}
    (" ")*                          {/*Ignore*/}
    ({Numero})*  {System.out.println("NUM_VERSION: "+yytext()); return new Symbol(Simbolos.NUMERO, yycolumn, yyline, yytext());}
    ({Letra})                       {System.out.println("letra: "+yytext()); return new Symbol(Simbolos.LETRA , yycolumn, yyline, yytext());}
    {Identificador}               {System.out.println("id: "+yytext()); return new Symbol(Simbolos.IDENTIFICADOR , yycolumn, yyline, yytext());}
    ({Salto})                       {System.out.println("salto: "+yytext()); return new Symbol(Simbolos.SALTO_LINEA , yycolumn, yyline, yytext());}
    .                           {System.out.println("CUALQUIER_SIM: "+yytext()); 
                                    //ErrorG e = new ErrorG(yyline+1, yycolumn+1,yytext(),"Lexico","Error Lexico token: " + yytext()+"   Linea: " + (yyline+1) + " ,    Columna: " + (yycolumn+1));
                                    //listaErrores.add(e);
                                    return new Symbol(Simbolos.CUALQUIER_SIM , yycolumn, yyline, yytext());
                                    }
    
}