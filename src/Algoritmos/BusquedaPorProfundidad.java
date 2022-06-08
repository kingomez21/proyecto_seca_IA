/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos;

import Model.Matriz;
import Model.Nodo;
import java.util.ArrayList;

/**
 *
 * @author Camilo
 */
public class BusquedaPorProfundidad {
    
    Matriz matriz = new Matriz();
    int Estado[][] = new int[10][10];
    String Nodo;
    int profundidad;
    String operador;
    
    public BusquedaPorProfundidad(int[][] estado) {
        this.Estado = estado;
    }

    public int[][] moverIzquierda(int colum, int fila) {
        int movFila = fila - 1;

        if (movFila < 0) {
            movFila = 0;
        } else if (movFila > 9) {
            movFila = 9;
        }

        this.Estado[colum][fila] = 7;
        this.Estado[colum][movFila] = 2;
        this.operador = "izquierda";
        this.Nodo = "(" + colum + "," + movFila + ")";
        this.profundidad += 1;
        return this.Estado;
    }

    public int[][] moverArriba(int colum, int fila) {
        int movColum = colum - 1;

        if (movColum < 0) {
            movColum = 0;
        } else if (movColum > 9) {
            movColum = 9;
        }

        this.Estado[colum][fila] = 7;
        this.Estado[movColum][fila] = 2;
        this.operador = "arriba";
        this.Nodo = "(" + movColum + "," + fila + ")";
        this.profundidad += 1;
        return this.Estado;
    }

    public int[][] moverDerecha(int colum, int fila) {
        int movFila = fila + 1;

        if (movFila < 0) {
            movFila = 0;
        } else if (movFila > 9) {
            movFila = 9;
        }

        this.Estado[colum][fila] = 7;
        this.Estado[colum][movFila] = 2;
        this.operador = "derecha";
        this.Nodo = "(" + colum + "," + movFila + ")";
        this.profundidad += 1;
        return this.Estado;
    }

    public int[][] moverAbajo(int colum, int fila) {
        int movColum = colum + 1;

        if (movColum < 0) {
            movColum = 0;
        } else if (movColum > 9) {
            movColum = 9;
        }

        this.Estado[colum][fila] = 7;
        this.Estado[movColum][fila] = 2;
        this.operador = "abajo";
        this.Nodo = "(" + movColum + "," + fila + ")";
        this.profundidad += 1;
        return this.Estado;
    }
    
    public void verificarBusquedaPorProfundidad(ArrayList<Nodo> pila, Nodo padre){
        
    }
    
}
