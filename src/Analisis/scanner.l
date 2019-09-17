package Analisis; // Paquete donde estará nuestro scanner
import java_cup.runtime.Symbol; 
import Utilidades.*;
%% 

%{
    /*Area de declaración de codigo java. 
    *Funciones y variables necesarias
    *
    */
    public String errores = "";
    public String lexemas = "";
    public void addError(ErrorC e)
    {
    	Singlenton.registrarError(e);
    }
    public void addLexema(Symbol s)
    {
        lexemas+=sym.terminalNames[s.sym] +"\t"+ s.value + "\t" + s.left + "\t" + s.right +"\n";
    }
%}

// Area de directivas
%cupsym sym 
%class scanner
%cup
%public
%unicode
%line
%column
%char
%ignorecase


// Area de definición de expresiones regulares. Tokens.
Comentario = "//" [^\r\n]* [^\r\n]
ComentarioMulti = "/*" [^/] ~"*/" | "/*" "/"+ "*/"
entero =[0-9]+  | ("-"[0-9]+)         
espacio = \t|\f|" "|\r|\n
letra = [a-zA-Z]
id ={letra}({letra}|{entero}|"_")*
decimal =[0-9]+ "." [0-9]*| ("-"[0-9]+ "." [0-9]*)
cadena =[\"] [^\"\n]* [\"\n]
bool=("verdadero"|"falso")
/*%state  */


/*
var id = EXP;


*/

%%

// Acciones
/* Espacios en blanco */
<YYINITIAL>
{



    {espacio}     {/*Ignorar*/}
    "var" {Symbol s = new  Symbol(sym.var,yycolumn,yyline,yytext()); addLexema(s); return s; }
    "=" {Symbol s = new Symbol(sym.asignacion,yycolumn,yyline,yytext()); addLexema(s); return s;}    
    "," {Symbol s = new Symbol(sym.coma,yycolumn,yyline,yytext()); addLexema(s); return s;}
    ";" {Symbol s = new Symbol(sym.puntocoma,yycolumn,yyline,yytext()); addLexema(s); return s;}    
    "+" {Symbol s = new Symbol(sym.suma,yycolumn,yyline,yytext()); addLexema(s); return s;}  
    "(" {Symbol s = new Symbol(sym.pari,yycolumn,yyline,yytext()); addLexema(s); return s;}  
    ")" {Symbol s = new Symbol(sym.pard,yycolumn,yyline,yytext()); addLexema(s); return s;}  
    "true" {Symbol s = new Symbol(sym.booleano,yycolumn,yyline,yytext()); addLexema(s); return s;}
    "false" {Symbol s = new Symbol(sym.booleano,yycolumn,yyline,yytext()); addLexema(s); return s;}    
    "imprimir" {Symbol s = new Symbol(sym.imprimir,yycolumn,yyline,yytext()); addLexema(s); return s;}
    {id} {Symbol s = new  Symbol(sym.id,yycolumn,yyline,yytext()); addLexema(s); return s; } 
    {decimal} {Symbol s = new  Symbol(sym.decimal,yycolumn,yyline,yytext()); addLexema(s); return s;}     
    {entero} {Symbol s = new  Symbol(sym.entero,yycolumn,yyline,yytext()); addLexema(s); return s;}     
    {cadena} {Symbol s = new Symbol(sym.cadena,yycolumn,yyline,yytext().substring(1,yytext().length()-1)); addLexema(s); return s;}

    {Comentario} { /*Se ignora.*/}
    {ComentarioMulti} { /*Se ignora.*/}
    /*Recolección de errores*/
    .   
    {         
            
            addError(new ErrorC("Error, caracter no válido.",(yyline+1), (yycolumn+1), yytext(), "----"));    
            //addError("Error lexico: "+yytext()+ " Linea:"+(yyline+1)+" Columna:"+(yycolumn+1));
    }

}



