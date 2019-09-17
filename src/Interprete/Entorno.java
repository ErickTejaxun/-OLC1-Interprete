/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interprete;

import java.util.Hashtable;

/**
 *
 * @author erick
 */
public class Entorno 
{
    public Entorno padre;
    public Hashtable<String, Simbolo> Tabla;
    
    public Entorno(Entorno padre)
    {
        this.padre = padre;
        Tabla = new Hashtable<String, Simbolo>();
    }
    
    public boolean insertar(Simbolo s)
    {
        Simbolo tmp = Tabla.get(s.identificador);        
        if(tmp ==null)
        {
            Tabla.put(s.identificador,s);
            return true;
        }        
        else
        {
            System.out.println("El simbolo "+s.identificador + " ya existe en este entorno");
            return false;
        }
    }
    public Simbolo obtener(String id)
    {
        return Tabla.get(id);
    }
    
}
