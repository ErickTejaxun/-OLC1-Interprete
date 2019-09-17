/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

/**
 *
 * @author erick
 */
public class ErrorC 
{
    public String descripcion;
    public int linea, columna;
    public String valor;
    public String archivo;

    public ErrorC(String descripcion, int linea, int columna, String valor, String archivo) {
        this.descripcion = descripcion;
        this.linea = linea;
        this.columna = columna;
        this.valor = valor;
        this.archivo = archivo;
    }
    
    
}
