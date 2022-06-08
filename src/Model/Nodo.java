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

    ArrayList<Nodo> nodo = new ArrayList<>();
    Matriz matriz = new Matriz();
    int Estado[][] = new int[10][10];
    Nodo padre;
    String operador;
    int profundidad;
    int costo;

    public Nodo(int[][] estado, Nodo padre, String operador, int profundidad) {
        this.Estado = estado;
        this.padre = padre;
        this.operador = operador;
        this.profundidad = profundidad;
    }

    public String verficarAmplitud(int[][] estado_inicial, Nodo padre) {

        int cont = 0, fila, colum;
        int fil = 0;
        //Nodo padre = new Nodo(estado_inicial, null, null, 0);
        nodo.add(padre);

        while (cont < 3) {
            Nodo nodoExpandido = nodo.remove(0);
            System.err.println(nodoExpandido.getOperador());
            fila = matriz.EncontrarJugador(nodoExpandido.getEstado())[0];
            colum = matriz.EncontrarJugador(nodoExpandido.getEstado())[1];
            System.out.println(fila);
            System.out.println(colum);
            while (fil < 10) {
                for (int j = 0; j < 10; j++) {
                    System.out.print("" + nodoExpandido.getEstado()[fil][j] + " ");
                }
                System.out.println();
                fil++;
            }

            int movColumIz = colum - 1;

            if (movColumIz >= 0) {
                if (movColumIz > 9) {
                    movColumIz = colum;
                }

                int izquierda = nodoExpandido.getEstado()[fila][movColumIz];
                int[][] estadoIZ = new int[10][10];

                System.err.println(izquierda);
                if (izquierda != 1 && izquierda != 7 && izquierda != 2) {
                    estadoIZ = nodoExpandido.getEstado();
                    estadoIZ[fila][colum] = 7;
                    estadoIZ[fila][movColumIz] = 2;
                    while (fil < 10) {
                        for (int j = 0; j < 10; j++) {
                            System.out.print("" + estadoIZ[fil][j] + " ");
                        }
                        System.out.println();
                        fil++;
                    }
                    nodo.add(new Nodo(estadoIZ, nodoExpandido, "IZ", nodoExpandido.profundidad + 1));
                }

            }

            int movFilaAr = fila - 1;

            if (movFilaAr >= 0) {
                if (movFilaAr > 9) {
                    movFilaAr = fila;
                }
                int arriba = nodoExpandido.getEstado()[movFilaAr][colum];
                System.err.println(arriba);

                int[][] estadoARR = new int[10][10];

                if (arriba != 1 && arriba != 7 && arriba != 7) {
                    estadoARR = nodoExpandido.getEstado();
                    estadoARR[fila][colum] = 7;
                    estadoARR[movFilaAr][colum] = 2;

                    nodo.add(new Nodo(estadoARR, nodoExpandido, "ARR", nodoExpandido.profundidad + 1));
                }
            }

            int movColumDer = colum + 1;

            if (movColumDer >= 0) {
                if (movColumDer > 9) {
                    movColumDer = colum;
                }

                int derecha = nodoExpandido.getEstado()[fila][movColumDer];
                System.err.println(derecha);

                int[][] estadoDER = new int[10][10];

                if (derecha != 1 && derecha != 7 && derecha != 2) {
                    estadoDER = nodoExpandido.getEstado();
                    estadoDER[fila][colum] = 7;
                    estadoDER[fila][movColumDer] = 2;

                    nodo.add(new Nodo(estadoDER, nodoExpandido, "DER", nodoExpandido.profundidad + 1));
                }

            }

            int movFilaAba = fila + 1;

            if (movFilaAba >= 0) {
                if (movFilaAba > 9) {
                    movFilaAba = fila;
                }

                int abajo = nodoExpandido.getEstado()[movFilaAba][colum];
                System.err.println(abajo);

                int[][] estadoABA = new int[10][10];

                if (abajo != 1 && abajo != 7 && abajo != 2) {
                    estadoABA = nodoExpandido.getEstado();
                    estadoABA[fila][colum] = 7;
                    estadoABA[movFilaAba][colum] = 2;

                    nodo.add(new Nodo(estadoABA, nodoExpandido, "ABA", nodoExpandido.profundidad + 1));
                }
            }

            /*for (int i = 0; i < nodo.size(); i++) {
                System.out.println(nodo.get(i).getOperador());

            }*/
            cont++;
            fil = 0;
        }
        return nodo.get(0).getOperador();
    }

    public ArrayList<Nodo> getNodo() {
        return nodo;
    }

    public void setNodo(ArrayList<Nodo> nodo) {
        this.nodo = nodo;
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
