package analisis.comprobaciones;
import java_cup.runtime.*;

%%
%{
    //coidgo de usuario en sintaxis java
%}

    //directivas
%public 
%class AnalizadorLexicoC
%type java_cup.runtime.Symbol
%cupsym SimbolosC
%cup
%cupdebug
%char
%line
%column
%full
//%ignorecase
//%unicode


    //expreciones regulares
LetraMin            = [a-záéíóú]
//LetraMin            = [a-zá-ú]
//LetraMin            = ([a-z]|"á"|"é"|"í"|"ó"|"ú")
LetraMay            = [A-ZÁÉÍÓÚ]
//LetraMay            = [A-ZÁ-Ú]
//LetraMay            = ([A-Z]|"Á"|"É"|"Í"|"Ó"|"Ú")
idMin               = ({LetraMin})+
idMay               = ({LetraMay})+
Espacio             = [ \b\t\r\n]+
%%

<YYINITIAL> {
    {Espacio}                       {/*Ignore*/}
    {idMin}                         {System.out.println("idMin: "+yytext()); return new Symbol(SimbolosC.ID_MIN , yycolumn, yyline, yytext());}
    {idMay}                         {System.out.println("idMay: "+yytext()); return new Symbol(SimbolosC.ID_MAY , yycolumn, yyline, yytext());}
    .                               {System.out.println("error Lexico: "+"Columna: "+(yycolumn+1)+", Linea: "+ (yyline+1) + ",   Token: "+yytext());
                                        return new Symbol(SimbolosC.ERR , yycolumn, yyline, yytext());
                                    }
    
}
