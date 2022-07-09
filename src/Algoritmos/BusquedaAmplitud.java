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
 * @author USUARIO
 */
public class BusquedaAmplitud {

    Matriz matriz = new Matriz();
    int Estado[][] = new int[10][10];
    ArrayList<Nodo> nodosExpandidos = new ArrayList<>();
    ArrayList<Nodo> recorridoMeta1 = new ArrayList<>();
    long tiempoInicial;

    public BusquedaAmplitud(int[][] estado) {
        this.Estado = estado;
        this.tiempoInicial = System.currentTimeMillis();
    }

    public int[][] moverIzquierda(int fila, int colum) {
        int movColum = colum - 1;

        if (movColum < 0) {
            movColum = 0;
        } else if (movColum > 9) {
            movColum = 9;
        }

        this.Estado[fila][colum] = 7;
        this.Estado[fila][movColum] = 2;

        return this.Estado;
    }

    public int[][] moverArriba(int fila, int colum) {
        int movFila = fila - 1;

        if (movFila < 0) {
            movFila = 0;
        } else if (movFila > 9) {
            movFila = 9;
        }

        this.Estado[fila][colum] = 7;
        this.Estado[movFila][colum] = 2;

        return this.Estado;
    }

    public int[][] moverDerecha(int fila, int colum) {
        int movColum = colum + 1;

        if (movColum < 0) {
            movColum = 0;
        } else if (movColum > 9) {
            movColum = 9;
        }

        this.Estado[fila][colum] = 7;
        this.Estado[fila][movColum] = 2;

        return this.Estado;
    }

    public int[][] moverAbajo(int fila, int colum) {
        int movFila = fila + 1;

        if (movFila < 0) {
            movFila = 0;
        } else if (movFila > 9) {
            movFila = 9;
        }

        this.Estado[fila][colum] = 7;
        this.Estado[movFila][colum] = 2;
        return this.Estado;
    }

    public void verificarAmplitud(ArrayList<Nodo> cola, Nodo padre) {

        int cont = 0;
        int contMeta = 0;
        cola.add(padre);
        int fila = 0, colum = 0;
        String mov = "";
        char verIzquierda, verArriba, verDerecha, verAbajo;
        char meta = '0';
        int acum = 1;
        long time = 0;
        boolean ban1 = true, ban2 = true;

        try {

            while (contMeta < 2) {

                Nodo nodoExpandido = cola.remove(0);
                nodosExpandidos.add(nodoExpandido);

                if (nodoExpandido.getOperador() == null) {
                    fila = matriz.EncontrarJugador(nodoExpandido.getEstado())[0];
                    colum = matriz.EncontrarJugador(nodoExpandido.getEstado())[1];
                } else {
                    fila = nodoExpandido.getPosFila();
                    colum = nodoExpandido.getPosColum();
                }

                meta = nodoExpandido.getMeta();

                if (meta == '5') {
                    contMeta++;
                    if(contMeta ==1){
                        ban1 = false;
                    }
                    if(contMeta == 2){
                        ban2 = false;
                    }

                }

                if (contMeta == 2) {
                    acum = contMeta;
                }

                mov = verificar(fila, colum);

                verIzquierda = mov.charAt(0);
                verArriba = mov.charAt(1);
                verDerecha = mov.charAt(2);
                verAbajo = mov.charAt(3);

                if (verIzquierda == '1' || verIzquierda == '5') {

                    int movColumIz = colum - 1;

                    if (movColumIz >= 0) {

                        if (movColumIz > 9) {
                            movColumIz = colum;
                        }

                        cola.add(new Nodo(moverIzquierda(fila, colum), nodoExpandido, verIzquierda, acum, "IZ", nodoExpandido.getProfundidad() + 1, fila, movColumIz));

                    }
                }

                if (verArriba == '1' || verArriba == '5') {
                    int movFilaAr = fila - 1;

                    if (movFilaAr >= 0) {
                        if (movFilaAr > 9) {
                            movFilaAr = fila;
                        }
                        cola.add(new Nodo(moverArriba(fila, colum), nodoExpandido, verArriba, acum, "ARR", nodoExpandido.getProfundidad() + 1, movFilaAr, colum));
                    }
                }

                if (verDerecha == '1' || verDerecha == '5') {
                    int movColumDer = colum + 1;

                    if (movColumDer >= 0) {
                        if (movColumDer > 9) {
                            movColumDer = colum;
                        }
                        cola.add(new Nodo(moverDerecha(fila, colum), nodoExpandido, verDerecha, acum, "DER", nodoExpandido.getProfundidad() + 1, fila, movColumDer));
                    }
                }

                if (verAbajo == '1' || verAbajo == '5') {
                    int movFilaAba = fila + 1;

                    if (movFilaAba >= 0) {
                        if (movFilaAba > 9) {
                            movFilaAba = fila;
                        }
                        cola.add(new Nodo(moverAbajo(fila, colum), nodoExpandido, verAbajo, acum, "ABA", nodoExpandido.getProfundidad() + 1, movFilaAba, colum));
                    }
                }

            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Mensaje: " + e.getMessage());
        }

    }

    public ArrayList<Nodo> getNodosExpandidos() {
        return nodosExpandidos;
    }

    public void setNodosExpandidos(ArrayList<Nodo> nodosExpandidos) {
        this.nodosExpandidos = nodosExpandidos;
    }

    public int[][] moverJugador(String mov, int fila, int colum) {

        if (mov.equalsIgnoreCase("IZ")) {
            return this.moverIzquierda(fila, colum);
        }
        if (mov.equalsIgnoreCase("ARR")) {
            return this.moverArriba(fila, colum);
        }
        if (mov.equalsIgnoreCase("DER")) {
            return this.moverDerecha(fila, colum);
        }
        if (mov.equalsIgnoreCase("ABA")) {
            return this.moverAbajo(fila, colum);
        }

        return this.Estado;
    }

    public String verificar(int fila, int colum) {

        String movimientos = "";

        int movColumIz = colum - 1;

        if (movColumIz >= 0) {
            if (movColumIz > 9) {
                movColumIz = colum;
            }
            int izquierda = this.Estado[fila][movColumIz];
            if (izquierda == 5) {
                movimientos += "5";
            } else {
                if (izquierda != 1 && izquierda != 7 && izquierda != 5 && izquierda != 2) {
                    movimientos += "1";

                } else {
                    movimientos += "0";
                }
            }

        } else {
            movimientos += "0";
        }

        int movFilaAr = fila - 1;

        if (movFilaAr >= 0) {
            if (movFilaAr > 9) {
                movFilaAr = fila;
            }
            int arriba = this.Estado[movFilaAr][colum];
            if (arriba == 5) {
                movimientos += "5";
            } else {
                if (arriba != 1 && arriba != 7 && arriba != 5 && arriba != 2) {
                    movimientos += "1";
                } else {
                    movimientos += "0";
                }
            }
        } else {
            movimientos += "0";
        }

        int movColumDer = colum + 1;

        if (movColumDer >= 0) {
            if (movColumDer > 9) {
                movColumDer = colum;
            }

            int derecha = this.Estado[fila][movColumDer];
            if (derecha == 5) {
                movimientos += "5";
            } else {
                if (derecha != 1 && derecha != 7 && derecha != 5 && derecha != 2) {
                    movimientos += "1";
                } else {
                    movimientos += "0";
                }
            }
        } else {
            movimientos += "0";
        }

        int movFilaAba = fila + 1;

        if (movFilaAba >= 0) {
            if (movFilaAba > 9) {
                movFilaAba = fila;
            }

            int abajo = this.Estado[movFilaAba][colum];
            if (abajo == 5) {
                movimientos += "5";
            } else {
                if (abajo != 1 && abajo != 7 && abajo != 5 && abajo != 2) {
                    movimientos += "1";
                } else {
                    movimientos += "0";
                }
            }
        } else {
            movimientos += "0";
        }

        return movimientos;
    }

    public long getTiempoInicial() {
        return tiempoInicial;
    }

    public void setTiempoInicial(long tiempoInicial) {
        this.tiempoInicial = tiempoInicial;
    }

}
