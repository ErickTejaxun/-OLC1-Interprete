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
public class Simbolo 
{
    public String identificador;
    public enum Tipo {ENTERO, DECIMAL, CADENA, BOOLEANO, CARACTER};
    public String tipo;
    public int linea, columna;
    public Object valor;

    public Simbolo
        (String identificador, String tipo, int linea, int columna, Object valor) {
        this.identificador = identificador;
        this.tipo = tipo;
        this.linea = linea;
        this.columna = columna;
        this.valor = valor;
    }
    
    
}
