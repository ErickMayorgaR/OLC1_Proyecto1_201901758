package Analizadores;

import java_cup.runtime.*;
import ocl.funcionalidades.*;



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
}
%%


blancos = [ \r\t]+
// espacio en blanco \r = retorno de carro \t = tab 
letra = [a-zA-Z]
entero = [0-9]+
cadena = "\""[^\"]+"\""
especial_c = ("\\""n"|"\\""\'"|"\\""\"") //\n \' y \"
identificador = {letra}({letra}|"_"|{entero})*
cadena_num = [0-9]"~"[0-9]
cadena_min = [a-z]"~"[a-z]
cadena_mayus =[A-Z]"~"[A-Z]
nombre_expresion = \"[A-Z]|[a-z]|[0-9]\"


comentario_linea = ("//".*\n)|("//".*\r)    
comentario_multi_l = ("<""!"[^\!]*"!"">"  

%{
    public void agregar_error(String tipo, String lexema, int fila, int columna)
    {
        Error un_error = new Error(tipo, lexema, fila+1, columna+1);
        Interface.Lista_Errores.add(un_error);
    }
%}
%%



{blancos} {}
{comentario_linea} {}
{comentario_multi_l} {}

//elemtento,                               linea, columna, lexema
"CONJ" {return new Symbol(sym.CONJ,yyline,yychar,yytext());}
"~" {return new Symbol(sym.trazo,yyline,yychar,yytext());}
":" {return new Symbol(sym.dos_puntos,yyline,yychar,yytext());}
"-" {return new Symbol(sym.guion,yyline,yychar,yytext());}
">" {return new Symbol(sym.mayor,yyline,yychar,yytext());} //5
"<" {return new Symbol(sym.menor,yyline,yychar,yytext());}
";" {return new Symbol(sym.punto_coma,yyline,yychar,yytext());}
"_" {return new Symbol(sym.guion_bajo,yyline,yychar,yytext());}
"," {return new Symbol(sym.coma,yyline,yychar,yytext());}
"\"" {return new Symbol(sym.comilla_doble,yyline,yychar,yytext());} //10
"!" {return new Symbol(sym.exclamacion,yyline,yychar,yytext());}
"#" {return new Symbol(sym.numeral,yyline,yychar,yytext());}
"$" {return new Symbol(sym.dolar,yyline,yychar,yytext());}
"&" {return new Symbol(sym.ampersand,yyline,yychar,yytext());}
"'" {return new Symbol(sym.comilla_simple,yyline,yychar,yytext());} //15
"(" {return new Symbol(sym.parentesis_aper,yyline,yychar,yytext());}
")" {return new Symbol(sym.parentesis_cierre,yyline,yychar,yytext());}
"+" {return new Symbol(sym.mas,yyline,yychar,yytext());}
"%" {return new Symbol(sym.porcentaje,yyline,yychar,yytext());}
"*" {return new Symbol(sym.asterisco ,yyline,yychar,yytext());} //20
"\" {return new Symbol(sym.backslash,yyline,yychar,yytext());}
"=" {return new Symbol(sym.igual,yyline,yychar,yytext());}
"?" {return new Symbol(sym.interrogacion,yyline,yychar,yytext());}
"@" {return new Symbol(sym.arroba,yyline,yychar,yytext());}
"[" {return new Symbol(sym.corchete_aper,yyline,yychar,yytext());} //25
"]" {return new Symbol(sym.corchete_cierre,yyline,yychar,yytext());}
"^" {return new Symbol(sym.potencia,yyline,yychar,yytext());}
"`" {return new Symbol(sym.acento,yyline,yychar,yytext());}
"|" {return new Symbol(sym.barra_or,yyline,yychar,yytext());}
"{" {return new Symbol(sym.llave_aper,yyline,yychar,yytext());} //30
"}" {return new Symbol(sym.llave_cierre,yyline,yychar,yytext());}
"." {return new Symbol(sym.punto,yyline,yychar,yytext());}


\n {yychar=1;}
{identificador} {return new Symbol(sym.identificador,yyline,yychar,yytext());}
{entero} {return new Symbol(sym.entero,yyline,yychar,yytext());}
{cadena} {return new Symbol(sym.cadena,yyline,yychar,yytext());}
{especial_c} {return new Symbol(sym.especial_c,yyline,yychar,yytext());}
{cadena_num} {return new Symbol(sym.cadena_num,yyline,yychar,yytext());}
{cadena_min} {return new Symbol(sym.cadena_min,yyline,yychar,yytext());}
{cadena)mayus} {return new Symbol(sym.cadena_mayus,yyline,yychar,yytext());}

.   {
	    System.err.println("Error lexico: "+yytext()+ " Linea:"+(yyline)+" Columna:"+(yychar));
            agregar_error("Error Léxico",yytext(),yyline,yycolumn);
    }