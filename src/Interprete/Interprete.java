/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interprete;

import Analisis.Arbol.Nodo;

/**
 *
 * @author erick
 */
public class Interprete 
{
    public Nodo raiz;
    public Interprete(Nodo r)
    {
        raiz = r;
    }
    public void comenzar()
    {
        Ejecutar(raiz, new Entorno(null));
    }
    
    
    public Resultado Ejecutar(Nodo r, Entorno local)
    {
        switch(r.getTipo())
        {
            case "imprimir":
                Resultado result = Ejecutar(r.getHijos().get(0), local);
                System.out.println(result.valor.toString());
                return null;
            case "cadena":
            case "entero":
            case "decimal":
            case "booleano":                
                return new Resultado(r.getValue(), r.getTipo(), r.getLinea(), r.getColumna());
            case  "variable":
                return new Resultado(local.obtener(r.getValue()).valor,local.obtener(r.getValue()).tipo, r.getLinea(),r.getColumna());
            case "instrucciones":
                for(Nodo actual: r.getHijos())
                {
                    Ejecutar(actual, local);
                }     
            break;
             
            case "declaracion"    :
                String identificador = r.getHijos().get(0).getValue();
                Resultado resultadoD = Ejecutar(r.getHijos().get(1), local);
                if(resultadoD == null)
                {
                    //Imprimir error
                }
                else
                {
                    Simbolo simbolo = new Simbolo(identificador, resultadoD.tipo, resultadoD.linea, resultadoD.columna, r);
                    local.insertar(simbolo);
                }
            return null;
                
            case "repetir":                ;
                Resultado numerIteraciones = Ejecutar(r.getHijos().get(0), local);             
                if(numerIteraciones != null)
                {   
                    if(numerIteraciones.tipo.equals("int"))                
                    {
                        int cont = Integer.parseInt(numerIteraciones.valor.toString());
                        for(int x = 0 ; x < cont ; x ++)
                        {
                            /*Lista insturcciones ejecucion*/
                            for(Nodo instruccion : r.getHijos().get(1).getHijos())
                            {
                                Ejecutar(instruccion, local);
                            }
                        }
                    }                    
                }               
            return null;    
            case "mientras":                
                Resultado condicionBooleana = Ejecutar(r.getHijos().get(0), local);             
                if(condicionBooleana != null)
                {   
                    if(condicionBooleana.tipo.equals("booleano"))                
                    {                        
                        while((boolean)condicionBooleana.valor)
                        {
                            for(Nodo instruccion : r.getHijos().get(1).getHijos())
                            {
                                Ejecutar(instruccion, local);
                                condicionBooleana = Ejecutar(r.getHijos().get(0), local);
                            }                            
                        }           
                    } 
                    else
                    {
                        //Imprimir
                    }
                }               
            return null;  
                
            case "listainstrucciones":
                for(Nodo instruccion : r.getHijos().get(0).getHijos())
                {
                    Ejecutar(instruccion, local);
                    condicionBooleana = Ejecutar(instruccion, local);
                }                  
                return null;
            case "if":
                condicionBooleana = Ejecutar(r.getHijos().get(0), local);             
                if(condicionBooleana != null)
                {   
                    if(condicionBooleana.tipo.equals("booleano"))                
                    {                        
                        if((boolean)condicionBooleana.valor)
                        {
                            for(Nodo instruccion : r.getHijos().get(1).getHijos())
                            {
                                Ejecutar(instruccion, local);
                                condicionBooleana = Ejecutar(instruccion, local);
                            }                                                                                
                        }
                        else
                        {
                            if(r.getHijos().size()==3)
                            {
                                Ejecutar(r.getHijos().get(2), local);   
                            }                            
                        }
                    } 
                    else
                    {
                        //Imprimir Error
                    }
                }                 
                return null;
           /*Area de expresiones aritmeticas*/
                                                                            
            case "suma":
                Resultado izquierdo = Ejecutar(r.getHijos().get(0), local);
                Resultado derecho = Ejecutar(r.getHijos().get(1), local);
                if(izquierdo!= null && derecho != null)
                {

                    switch(izquierdo.tipo)
                    {
                        case "cadena":
                            String resultado = izquierdo.valor.toString()  + derecho.valor.toString() ;
                            return new Resultado(resultado, "cadena", izquierdo.linea, izquierdo.columna);
                        case "decimal":
                            switch(derecho.tipo)
                            {
                                case "cadena":
                                resultado = izquierdo.valor.toString()  + derecho.valor.toString() ;
                                return new Resultado(resultado, "cadena", izquierdo.linea, izquierdo.columna);                                    
                                    
                                case "entero":
                                    int entero = Integer.parseInt(derecho.valor.toString());
                                    double decimal = Double.parseDouble(izquierdo.valor.toString());
                                    return new Resultado(entero + decimal , "decimal",izquierdo.linea, izquierdo.columna);
                                
                                case "booleano":
                                    System.out.println("Error semantico, decimal + booleano no válido linea"+izquierdo.linea);
                                    return null;
                            }
                            
                            
                    }
                }
                
                
             

        }        

        return null;
    }
    
}
