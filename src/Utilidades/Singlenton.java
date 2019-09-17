/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.util.ArrayList;



/**
 *
 * @author erick
 */
public class Singlenton 
{
    public static ArrayList<ErrorC> listaErrores = new ArrayList<ErrorC>();
    
    public static void registrarError(ErrorC e)
    {
        listaErrores.add(e);
    }
}
