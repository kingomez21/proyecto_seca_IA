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
    
    int posFila;
    int posColum;
           

    public Nodo(int[][] estado, Nodo padre, String operador, int profundidad) {
        this.Estado = estado;
        this.padre = padre;
        this.operador = operador;
        this.profundidad = profundidad;
    }
    
    public Nodo(Nodo padre, String operador, int profundidad, int posFil, int posCol){
        this.padre = padre;
        this.operador = operador;
        this.profundidad = profundidad;
        this.posFila = posFil;
        this.posColum = posCol;
    }
    
    
/*
    public int[][] moverIzquierda(int[][] estado, int fila, int colum) {
        int fil =0;
        int movColum = colum - 1;

        if (movColum < 0) {
            movColum = 0;
        } else if (movColum > 9) {
            movColum = 9;
        }

        estado[fila][colum] = 7;
        estado[fila][movColum] = 2;
        /*while (fil < 10) {
            for (int j = 0; j < 10; j++) {
                System.out.print("" + this.Estado[fil][j] + " ");
            }
            System.out.println();
            fil++;
        }
        return estado;
    }

    public int[][] moverArriba(int [][] estado, int fila, int colum) {
        int movFila = fila - 1;

        if (movFila < 0) {
            movFila = 0;
        } else if (movFila > 9) {
            movFila = 9;
        }

        estado[fila][colum] = 7;
        estado[movFila][colum] = 2;
        return estado;
    }

    public int[][] moverDerecha(int [][] estado, int fila, int colum) {
        int movColum = colum + 1;

        if (movColum < 0) {
            movColum = 0;
        } else if (movColum > 9) {
            movColum = 9;
        }

        estado[fila][colum] = 7;
        estado[fila][movColum] = 2;
        return estado;
    }

    public int[][] moverAbajo(int [][] estado, int fila, int colum) {
        int movFila = fila + 1;

        if (movFila < 0) {
            movFila = 0;
        } else if (movFila > 9) {
            movFila = 9;
        }

        estado[fila][colum] = 7;
        estado[movFila][colum] = 2;
        return estado;
    }

    public Nodo verficarAmplitud(int[][] estado_inicial, Nodo pad) {

        int cont = 0, fila, colum;
        int fil = 0;
        Nodo padre = new Nodo(estado_inicial, null, null, 0);
        nodo.add(padre); 

        while (cont < 5) {
            Nodo nodoExpandido = nodo.remove(0);
            System.err.println(nodoExpandido.getProfundidad());
            while (fil < 10) {
                for (int j = 0; j < 10; j++) {
                    System.out.print("" + nodoExpandido.getEstado()[fil][j] + " ");
                }
                System.out.println();
                fil++;
            }
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

                System.err.println(izquierda);
                if (izquierda != 1 && izquierda != 7 && izquierda != 2) {

                    nodo.add(new Nodo(moverIzquierda(estado_inicial, fila, colum), nodoExpandido, "IZ", nodoExpandido.profundidad + 1));
                    nodoExpandido.getEstado()[fila][colum] = estado_inicial[fila][colum];
                    
                }

            }

            int movFilaAr = fila - 1;

            if (movFilaAr >= 0) {
                if (movFilaAr > 9) {
                    movFilaAr = fila;
                }
                int arriba = nodoExpandido.getEstado()[movFilaAr][colum];
                System.err.println(arriba);

                if (arriba != 1 && arriba != 7 && arriba != 7) {

                    nodo.add(new Nodo(this.moverArriba(estado_inicial,fila, colum), nodoExpandido, "ARR", nodoExpandido.profundidad + 1));
                    nodoExpandido.getEstado()[fila][colum] = estado_inicial[fila][colum];
                }
            }

            int movColumDer = colum + 1;

            if (movColumDer >= 0) {
                if (movColumDer > 9) {
                    movColumDer = colum;
                }

                int derecha = nodoExpandido.getEstado()[fila][movColumDer];
                System.err.println(derecha);

                if (derecha != 1 && derecha != 7 && derecha != 2) {

                    nodo.add(new Nodo(moverDerecha(estado_inicial, fila, colum), nodoExpandido, "DER", nodoExpandido.profundidad + 1));
                    nodoExpandido.getEstado()[fila][colum] = estado_inicial[fila][colum];
                }

            }

            int movFilaAba = fila + 1;

            if (movFilaAba >= 0) {
                if (movFilaAba > 9) {
                    movFilaAba = fila;
                }

                int abajo = nodoExpandido.getEstado()[movFilaAba][colum];
                System.err.println(abajo);

                if (abajo != 1 && abajo != 7 && abajo != 2) {

                    nodo.add(new Nodo(this.moverAbajo(estado_inicial, fila, colum), nodoExpandido, "ABA", nodoExpandido.profundidad + 1));
                    nodoExpandido.getEstado()[fila][colum] = estado_inicial[fila][colum];
                }
            }

            for (int i = 0; i < nodo.size(); i++) {
                System.out.print(nodo.get(i).getOperador()+" - ");
                
            }
            System.out.println();
            cont++;
            fil = 0;
        }
        return nodo.get(0);
    }*/

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
