/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analisis.Arbol;

import java.util.ArrayList;
import java.util.LinkedList;



/**
 *"hola mundo"
 * @author erick
 */
public class Nodo 
{
    private String tipo;
    private String value;
    private int columna;
    private int linea;    
    private LinkedList<Nodo> hijos = new LinkedList();

    public Nodo(String tipo, String valor, LinkedList<Nodo> lista, int l, int c)
    {
        this.tipo = tipo;
        this.value = valor;
        this.hijos = lista;
        this.linea = l;
        this.columna = c;
    }
    public Nodo(String tipo, String valor, int l, int c)
    {
        this.tipo = tipo;
        this.value = valor;        
        this.linea = l;
        this.columna = c;
    }  
    public Nodo(String tipo, int l, int c)
    {
        this.tipo = tipo;
        this.value = tipo;        
        this.linea = l;
        this.columna = c;
    }     
    
    public Nodo() 
    {
        this.value="";
    }
     
    
    public Nodo(String value) 
    {
        this.value=value;
        this.tipo = value;
    }
    
    public void addHijo(Nodo hijo)
    {
        this.hijos.add(hijo);
    }
    
    public Nodo(String value, int id) 
    {
        this.value=value;
        this.linea = id;
        this.tipo=value;
    }
//    public Nodo(String value, int id, int x) 
//    {
//        this.value=value;
//        this.linea = id;
//        this.tipo=value;
//    }    
    public Nodo(String value, Nodo hijo) 
    {
        this.value=value;
        this.tipo=value;        
        this.hijos.add(hijo);
    }    
    
    public Nodo(String tipo, int id, String value) 
    {
        this.tipo=tipo;
        this.value=value;
        this.linea = id;
    }    

    public String getTipo() {
        return tipo;
    }

    public String getValue() {
        return value;
    }

    public int getColumna() {
        return columna;
    }

    public int getLinea() {
        return linea;
    }

    public LinkedList<Nodo> getHijos() {
        return hijos;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public void setHijos(LinkedList<Nodo> hijos) {
        this.hijos = hijos;
    }

    public void pop(Nodo nuevo)
    {
        if(nuevo!=null)
        {
            this.hijos.add(nuevo);
        }
    }    
    
    public void add(Nodo nuevo)
    {
        if(nuevo!=null)
        {
            this.hijos.add(nuevo);
        }
    }
    
    public void addLista(Nodo nuevo)
    {
        if(nuevo!=null)
        {
            for(Nodo aux: nuevo.getHijos())
            {
                this.hijos.add(aux);
            }
        }
    }
    


    
    
}
