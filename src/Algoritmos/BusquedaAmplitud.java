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
    
    public BusquedaAmplitud(int[][] estado){
        this.Estado = estado;
    }
    
    
    
    public int[][] moverIzquierda(int fila, int colum){
        int movColum = colum - 1;
        
        if(movColum < 0){
            movColum = 0;
        }else 
            if(movColum > 9){
            movColum = 9;
        }
        
        this.Estado[fila][colum] = 7;
        this.Estado[fila] [movColum] = 2;
        this.operador = "izquierda";
        this.Nodo = "("+fila+","+movColum+ ")";
        this.profundidad += 1;
        return this.Estado;
    }
    
    public int[][] moverArriba(int fila, int colum){
        int movFila = fila - 1;
        
        if(movFila < 0){
            movFila = 0;
        }else 
            if(movFila > 9){
            movFila = 9;
        }
        
        this.Estado[fila][colum] = 7;
        this.Estado[movFila][colum] = 2;
        this.operador = "arriba";
        this.Nodo = "("+movFila+","+colum+ ")";
        this.profundidad += 1;
        return this.Estado;
    }
    
    public int[][] moverDerecha(int fila, int colum){
        int movColum = colum + 1;
        
        if(movColum < 0){
            movColum = 0;
        }else 
            if(movColum > 9){
            movColum = 9;
        }
        
        this.Estado[fila][colum] = 7;
        this.Estado[fila] [movColum] = 2;
        this.operador = "derecha";
        this.Nodo = "("+fila+","+movColum+ ")";
        this.profundidad += 1;
        return this.Estado;
    }
    
    public int[][] moverAbajo(int fila, int colum){
        int movFila = fila + 1;
        
        if(movFila < 0){
            movFila = 0;
        }else 
            if(movFila > 9){
            movFila = 9;
        }
        
        this.Estado[fila][colum] = 7;
        this.Estado[movFila][colum] = 2;
        this.operador = "abajo";
        this.Nodo = "("+movFila+","+colum+ ")";
        this.profundidad += 1;
        return this.Estado;
    }
    
    public String verificar(int fila, int colum){
        
        String movimientos = "";
        
        int movColumIz = colum - 1;
        
        if(movColumIz >= 0){
            if(movColumIz > 9){
                movColumIz = colum;
            }
            int izquierda = this.Estado[fila][movColumIz];
            if(izquierda != 1 && izquierda != 7){
                movimientos += "1";
            }else {
                movimientos += "0";
            }
            
        }else {
            movimientos += "0";
        }
        
        int movFilaAr = fila - 1;
        
        if(movFilaAr >= 0){
            if(movFilaAr > 9){
                movFilaAr = fila;
            }
            int arriba = this.Estado[movFilaAr][colum];
            if(arriba != 1 && arriba != 7){
                movimientos += "1";
            }else {
                movimientos += "0";
            }
        }else {
            movimientos += "0";
        }
        
        int movColumDer = colum + 1;
        
        if(movColumDer >= 0){
            if(movColumDer > 9){
                movColumDer = colum;
            } 
            
            int derecha = this.Estado[fila][movColumDer];
            if(derecha != 1 && derecha != 7){
                movimientos += "1";
            }else {
                movimientos += "0";
            }
        }else {
            movimientos += "0";
        }
        
        int movFilaAba = fila + 1;
        
        if(movFilaAba >= 0){
            if(movFilaAba > 9){
                movFilaAba = fila;
            }
            
            int abajo = this.Estado[movFilaAba][colum];
            if(abajo != 1 && abajo != 7){
                movimientos += "1";
            }else {
                movimientos += "0";
            }
        }else {
            movimientos += "0";
        }
        
        
        return movimientos; 
    }
    
    
    public int[][] mover(String movimientos, int fila, int colum){
        
        if(movimientos.equalsIgnoreCase("1010")){
            return this.moverDerecha(fila, colum);
        }
        
        if(movimientos.equalsIgnoreCase("1001")){
            return this.moverIzquierda(fila, colum);
        }
        
        if(movimientos.equalsIgnoreCase("0100")){
            return this.moverArriba(fila, colum);
        }
        
        if(movimientos.equalsIgnoreCase("0010")){
            return this.moverDerecha(fila, colum);
        }
        
        if(movimientos.equalsIgnoreCase("0110")){
            return this.moverArriba(fila, colum);
        }
        
        if(movimientos.equalsIgnoreCase("1000")){
            return this.moverIzquierda(fila, colum);
        }
        
        if(movimientos.equalsIgnoreCase("0001")){
            return this.moverAbajo(fila, colum);
        }
        
        if(movimientos.equalsIgnoreCase("0011")){
            return this.moverDerecha(fila, colum);
        }
        
        if(movimientos.equalsIgnoreCase("0111")){
            return this.moverDerecha(fila, colum);
        }
        
        if(movimientos.equalsIgnoreCase("1100")){
            return this.moverIzquierda(fila, colum);
        }
        
        if(movimientos.equalsIgnoreCase("1110")){
            return this.moverIzquierda(fila, colum);
        }
        
        if(movimientos.equalsIgnoreCase("1101")){
            return this.moverIzquierda(fila, colum);
        }
        
        if(movimientos.equalsIgnoreCase("1011")){
            return this.moverDerecha(fila, colum);
        }
        
        if(movimientos.equalsIgnoreCase("0101")){
            return this.moverAbajo(fila, colum);
        }
        
        return this.Estado;
    }
    
    //public 
    
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
