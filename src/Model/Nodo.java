/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class Nodo {

    //ArrayList<Nodo> nodo = new ArrayList<>();
    //Matriz matriz = new Matriz();
    int Estado[][] = new int[10][10];
    Nodo padre;
    String operador;
    int profundidad;
    int costo;
    char meta;
    int posFila;
    int posColum;
    int metasEncontradas;
           

    public Nodo(int[][] estado, Nodo padre, char meta , String operador, int profundidad, int costo) {
        this.Estado = estado;
        this.padre = padre;
        this.operador = operador;
        this.profundidad = profundidad;
        this.meta = meta;
        this.costo = costo;
    }

    public Nodo(int[][] estado, Nodo padre, char meta , int metaEncontrada ,String operador, int profundidad, int posFil, int posCol){
        this.Estado = estado;
        this.padre = padre;
        this.operador = operador;
        this.profundidad = profundidad;
        this.posFila = posFil;
        this.posColum = posCol;
        this.meta = meta;
        this.metasEncontradas = metaEncontrada;
    }

    public Nodo(int[][] estado, Nodo padre, char meta , String operador, int profundidad, int posFil, int posCol, int costo){
        this.Estado = estado;
        this.padre = padre;
        this.operador = operador;
        this.profundidad = profundidad;
        this.posFila = posFil;
        this.posColum = posCol;
        this.meta = meta;
        this.costo = costo;
    }

    public int getMetasEncontradas() {
        return metasEncontradas;
    }

    public void setMetasEncontradas(int metasEncontradas) {
        this.metasEncontradas = metasEncontradas;
    }
    
    public char getMeta() {
        return meta;
    }

    public void setMeta(char meta) {
        this.meta = meta;
    }
    
    public int getPosFila() {
        return posFila;
    }

    public void setPosFila(int posFila) {
        this.posFila = posFila;
    }

    public int getPosColum() {
        return posColum;
    }

    public void setPosColum(int posColum) {
        this.posColum = posColum;
    }

    

    public int[][] getEstado() {
        return Estado;
    }

    public void setEstado(int[][] Estado) {
        this.Estado = Estado;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public int getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

}
