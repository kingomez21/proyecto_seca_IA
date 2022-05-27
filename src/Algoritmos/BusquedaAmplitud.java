/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos;

import Model.Matriz;

/**
 *
 * @author USUARIO
 */
public class BusquedaAmplitud {

    int Estado[][] = new int[10][10];
    String Nodo;
    int profundidad;
    String operador;
    Matriz m;
    
    public BusquedaAmplitud(int[][] estado){
        //m = new Matriz();
        //m.CargarMundo();
        this.Estado = estado;
    }
    
    
    
    public int[][] moverDerecha(int fila, int colum){
        int movColum = colum + 1;
        
        this.Estado[fila][colum] = 10;
        this.Estado[fila] [movColum] = 2;
        this.operador = "derecha";
        this.Nodo = "("+fila+","+movColum+ ")";
        
        return this.Estado;
    }
    
    
    public int[][] getEstado(){
        return this.Estado;
    }

    public String getNodo() {
        return this.Nodo;
    }

    public int getProfundidad() {
        return this.profundidad;
    }

    public String getOperador() {
        return this.operador;
    }
    
    
    
}
