/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interprete;

/**
 *
 * @author erick
 */
public class Resultado 
{
    public Object valor;
    public String tipo;
    public int linea, columna;

    public Resultado(Object valor, String tipo, int linea, int columna) {
        this.valor = valor;
        this.tipo = tipo;
        this.linea = linea;
        this.columna = columna;
    }
    
    
}
