
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package Analisis;

import java_cup.runtime.*;
import java.util.ArrayList;
import Utilidades.*;
import Analisis.Arbol.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\016\000\002\002\004\000\002\002\003\000\002\005" +
    "\004\000\002\005\003\000\002\006\003\000\002\006\003" +
    "\000\002\007\007\000\002\004\007\000\002\003\005\000" +
    "\002\003\003\000\002\003\003\000\002\003\003\000\002" +
    "\003\003\000\002\003\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\031\000\006\007\006\014\012\001\002\000\010\002" +
    "\ufffd\007\ufffd\014\ufffd\001\002\000\010\002\ufffe\007\ufffe" +
    "\014\ufffe\001\002\000\004\017\030\001\002\000\010\002" +
    "\000\007\006\014\012\001\002\000\010\002\ufffc\007\ufffc" +
    "\014\ufffc\001\002\000\004\002\026\001\002\000\004\016" +
    "\013\001\002\000\014\004\017\005\014\006\015\017\021" +
    "\020\016\001\002\000\010\012\ufff6\013\ufff6\015\ufff6\001" +
    "\002\000\010\012\ufff5\013\ufff5\015\ufff5\001\002\000\010" +
    "\012\ufff8\013\ufff8\015\ufff8\001\002\000\010\012\ufff7\013" +
    "\ufff7\015\ufff7\001\002\000\006\013\022\015\023\001\002" +
    "\000\010\012\ufff4\013\ufff4\015\ufff4\001\002\000\014\004" +
    "\017\005\014\006\015\017\021\020\016\001\002\000\004" +
    "\012\024\001\002\000\010\002\ufffb\007\ufffb\014\ufffb\001" +
    "\002\000\010\012\ufff9\013\ufff9\015\ufff9\001\002\000\004" +
    "\002\001\001\002\000\010\002\uffff\007\uffff\014\uffff\001" +
    "\002\000\004\010\031\001\002\000\014\004\017\005\014" +
    "\006\015\017\021\020\016\001\002\000\006\012\033\013" +
    "\022\001\002\000\010\002\ufffa\007\ufffa\014\ufffa\001\002" +
    "" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\031\000\014\002\010\004\003\005\006\006\004\007" +
    "\007\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\010\004\003\006\026\007\007\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\004" +
    "\003\017\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\003\024\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\003\031\001\001\000" +
    "\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




    public ArrayList<String> listaClaves = new ArrayList<String>();
    public String errores;

    public Nodo raizAST;

    public void syntax_error(Symbol s)
    {


        //ErrorC(String descripcion, int linea, int columna, String valor, String archivo)
        Singlenton.registrarError(new ErrorC("Error sintactico. El analizador se recupero tras el error",(s.right+1), (s.left+1), s.value.toString(), "----"));  

    }

    /**Metodo al que se llama en el momento en que ya no es posible una recuperación de errores.*/
    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception
    {

        Singlenton.registrarError(new ErrorC("Error sintactico. El analizador se recupero tras el error",(s.right+1), (s.left+1), s.value.toString(), "----"));             
    }
    


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= INICIO EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // INICIO ::= LINSTRUCCCION 
            {
              Object RESULT =null;
		int nodoleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nodoright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Nodo nodo = (Nodo)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 raizAST = nodo;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // LINSTRUCCCION ::= LINSTRUCCCION INSTRUCCION 
            {
              Nodo RESULT =null;
		int listaleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int listaright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Nodo lista = (Nodo)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int instleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int instright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Nodo inst = (Nodo)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = lista; RESULT.addHijo(inst);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("LINSTRUCCCION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // LINSTRUCCCION ::= INSTRUCCION 
            {
              Nodo RESULT =null;
		int instleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int instright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Nodo inst = (Nodo)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new Nodo("instrucciones","instrucciones",instleft, instright); RESULT.addHijo(inst); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("LINSTRUCCCION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // INSTRUCCION ::= DECLARACION 
            {
              Nodo RESULT =null;
		int instleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int instright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Nodo inst = (Nodo)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT = inst;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("INSTRUCCION",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // INSTRUCCION ::= IMPRIMIR 
            {
              Nodo RESULT =null;
		int instleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int instright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Nodo inst = (Nodo)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		RESULT = inst;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("INSTRUCCION",4, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // IMPRIMIR ::= imprimir pari EXPRESION pard puntocoma 
            {
              Nodo RESULT =null;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		Object valor = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int exprleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int exprright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Nodo expr = (Nodo)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		 RESULT = new Nodo("imprimir", "imprimir", valorleft, valorright); RESULT.addHijo(expr);
              CUP$parser$result = parser.getSymbolFactory().newSymbol("IMPRIMIR",5, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // DECLARACION ::= var id asignacion EXPRESION puntocoma 
            {
              Nodo RESULT =null;
		int nombreleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int nombreright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		String nombre = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Nodo valor = (Nodo)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 
                        RESULT = new Nodo("declaracion","declaracion",nombreleft, nombreright);  
                        RESULT.addHijo(new Nodo("nombre",nombre, nombreleft, nombreright));
                        RESULT.addHijo(valor);
                    
              CUP$parser$result = parser.getSymbolFactory().newSymbol("DECLARACION",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // EXPRESION ::= EXPRESION suma EXPRESION 
            {
              Nodo RESULT =null;
		int nodoIleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int nodoIright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Nodo nodoI = (Nodo)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object valor = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int nodoDleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int nodoDright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Nodo nodoD = (Nodo)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Nodo("suma", "+", valorleft, valorright); RESULT.addHijo(nodoI); RESULT.addHijo(nodoD); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // EXPRESION ::= cadena 
            {
              Nodo RESULT =null;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String valor = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Nodo("cadena", valor, valorleft, valorright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // EXPRESION ::= entero 
            {
              Nodo RESULT =null;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String valor = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Nodo("entero", valor, valorleft, valorright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // EXPRESION ::= decimal 
            {
              Nodo RESULT =null;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String valor = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Nodo("decimal", valor, valorleft, valorright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // EXPRESION ::= booleano 
            {
              Nodo RESULT =null;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String valor = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Nodo("booleano", valor, valorleft, valorright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // EXPRESION ::= id 
            {
              Nodo RESULT =null;
		int valorleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String valor = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Nodo("variable", valor, valorleft, valorright); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

}
