package AnalisisHTML; // Paquete donde estará nuestro scanner
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
    public String cadena = "";

    public int contador = 0;

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
%class scannerHTML
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
%state CAD
%%

// Acciones
/* Espacios en blanco */
<YYINITIAL>
{   
    {espacio}     {/*Ignorar*/}
    "html" {Symbol s = new  Symbol(sym.rhtml,yycolumn,yyline,yytext()); addLexema(s); return s; }
    "head" {Symbol s = new Symbol(sym.rhead,yycolumn,yyline,yytext()); addLexema(s); return s;}
    "title" {contador++; Symbol s = new Symbol(sym.rtitle,yycolumn,yyline,yytext()); addLexema(s); return s;}
    "noufe" {contador++; Symbol s = new Symbol(sym.rnoufe,yycolumn,yyline,yytext()); addLexema(s); return s;}
    "div" {Symbol s = new Symbol(sym.rdiv,yycolumn,yyline,yytext()); addLexema(s); return s;}
    "body" {Symbol s = new Symbol(sym.rbody,yycolumn,yyline,yytext()); addLexema(s); return s;}
    "id" {Symbol s = new Symbol(sym.rid,yycolumn,yyline,yytext()); addLexema(s); return s;}
    "<" { Symbol s = new Symbol(sym.menorque,yycolumn,yyline,yytext()); addLexema(s); return s;}
    ">" { 
            Symbol s = new Symbol(sym.mayorque,yycolumn,yyline,yytext()); 
            if(contador==1)
            {
                yybegin(CAD);
            }
            else
            {
                contador = 0;
            }
            addLexema(s); 
            return s;
        }    
    "/" {contador++; Symbol s = new Symbol(sym.diagonal,yycolumn,yyline,yytext()); addLexema(s); return s;}
    "=" {Symbol s = new Symbol(sym.igual,yycolumn,yyline,yytext()); addLexema(s); return s;}
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
<CAD>
{
    [^]  
    {        
        if(yytext().equals("<"))
        {
            Symbol s = new Symbol(sym.cadena,yycolumn,yyline,cadena);             
            addLexema(s); 
            yypushback(1);
            yybegin(YYINITIAL);
            contador = 0;
            cadena = "";
            return s;
        }
        cadena += yytext();
    }
}


