package Analizadores;

import java_cup.runtime.*;
import Funcionalidades.*;
import olc1.*;



%%
%class Lexico //nombre del archivo generado en java
%cup // Compatibilidad con el analizador lexico
%public // clase de tipo publica
%unicode //codificacion unicode para caracteres
%line // conteo de lineas en variables yyline
%char //conteo de caracteres en variables yychar
%ignorecase //para mayusculas y minusculas


//codigo en el constructor
%init{
    yyline = 1;
    yychar = 1;
%init}



BLANCOS=[ \r\t]+
LETRA=[a-zA-Z]
ENTERO = [0-9]+
CADENA = "\""[^\"]+"\""
ESPECIALC = ("\\""n"|"\\""\'"|"\\""\"")
IDENTIFICADOR = {LETRA}({LETRA}|"_"|{ENTERO})*
CADENANUM = [0-9]"~"[0-9]
CADENAMIN = [a-z]"~"[a-z]
CADENAMAYUS =[A-Z]"~"[A-Z]
CADENAVAR  = [ -}]"~"[ -}]
NOMBREEXPRESION = \"[A-Z]|[a-z]|[0-9]\"
COMENTARIOLINEA= ("//".*\n)|("//".*\r)    
COMENTARIOMULTIL = "<!""!"*([^!>]|[^!]">"|"!"[^>])*"!"*"!>"  

%{
    public void agregar_error(String tipo, String lexema, int fila, int columna)
    {
        Error_ un_error = new Error_(tipo, lexema, fila+1, columna+1);
        Interfaz.listaErrores.add(un_error);
    }
%}

%%

{BLANCOS}               {}
{COMENTARIOLINEA}      {}
{COMENTARIOMULTIL}    {}


"CONJ" {return new Symbol(sym.conj,yyline,yychar,yytext());}
"~" {return new Symbol(sym.trazo,yyline,yychar,yytext());}
":" {return new Symbol(sym.dospuntos,yyline,yychar,yytext());}
"-" {return new Symbol(sym.guion,yyline,yychar,yytext());}
">" {return new Symbol(sym.mayor,yyline,yychar,yytext());} //5
"<" {return new Symbol(sym.menor,yyline,yychar,yytext());}
";" {return new Symbol(sym.puntocoma,yyline,yychar,yytext());}
"_" {return new Symbol(sym.guionbajo,yyline,yychar,yytext());}
"," {return new Symbol(sym.coma,yyline,yychar,yytext());}
"\"" {return new Symbol(sym.comilladoble,yyline,yychar,yytext());} //10
"!" {return new Symbol(sym.exclamacion,yyline,yychar,yytext());}
"#" {return new Symbol(sym.numeral,yyline,yychar,yytext());}
"$" {return new Symbol(sym.dolar,yyline,yychar,yytext());}
"&" {return new Symbol(sym.ampersand,yyline,yychar,yytext());}
"'" {return new Symbol(sym.comillasimple,yyline,yychar,yytext());} //15
"(" {return new Symbol(sym.parentesisaper,yyline,yychar,yytext());}
")" {return new Symbol(sym.parentesiscierre,yyline,yychar,yytext());}
"+" {return new Symbol(sym.mas,yyline,yychar,yytext());}
"%" {return new Symbol(sym.porcentaje,yyline,yychar,yytext());}
"*" {return new Symbol(sym.asterisco ,yyline,yychar,yytext());} //20
"/" {return new Symbol(sym.slash,yyline,yychar,yytext());}
"=" {return new Symbol(sym.igual,yyline,yychar,yytext());}
"?" {return new Symbol(sym.interrogacion,yyline,yychar,yytext());}
"@" {return new Symbol(sym.arroba,yyline,yychar,yytext());}
"[" {return new Symbol(sym.corcheteaper,yyline,yychar,yytext());} //25
"]" {return new Symbol(sym.corchetecierre,yyline,yychar,yytext());}
"^" {return new Symbol(sym.potencia,yyline,yychar,yytext());}
"`" {return new Symbol(sym.acento,yyline,yychar,yytext());}
"|" {return new Symbol(sym.barraor,yyline,yychar,yytext());}
"{" {return new Symbol(sym.llaveaper,yyline,yychar,yytext());} //30
"}" {return new Symbol(sym.llavecierre,yyline,yychar,yytext());}
"." {return new Symbol(sym.punto,yyline,yychar,yytext());}


\n {yychar=1;}

{LETRA}                 {return new Symbol(sym.letra,yycolumn, yyline, yytext());}
{IDENTIFICADOR} {return new Symbol(sym.identificador,yyline,yychar,yytext());}
{ENTERO} {return new Symbol(sym.entero,yyline,yychar,yytext());}
{CADENA} {return new Symbol(sym.cadena,yyline,yychar,yytext());}
{ESPECIALC} {return new Symbol(sym.especialc,yyline,yychar,yytext());}
{CADENANUM} {return new Symbol(sym.cadenanum,yyline,yychar,yytext());}
{CADENAMIN} {return new Symbol(sym.cadenamin,yyline,yychar,yytext());}
{CADENAMAYUS} {return new Symbol(sym.cadenamayus,yyline,yychar,yytext());}
{NOMBREEXPRESION} {return new Symbol(sym.nombreexpresion,yyline,yychar,yytext());}
{CADENAVAR} {return new Symbol(sym.cadenavar,yyline,yychar,yytext());}

.   {
	    System.err.println("Error lexico: "+yytext()+ " Linea:"+(yyline)+" Columna:"+(yychar));
            agregar_error("Error Léxico",yytext(),yyline,yycolumn);
    }