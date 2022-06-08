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
    String Nodo;
    int profundidad;
    String operador;

    public BusquedaAmplitud(int[][] estado) {
        this.Estado = estado;
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
        this.operador = "izquierda";
        this.Nodo = "(" + fila + "," + movColum + ")";
        this.profundidad += 1;
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
        this.operador = "arriba";
        this.Nodo = "(" + movFila + "," + colum + ")";
        this.profundidad += 1;
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
        this.operador = "derecha";
        this.Nodo = "(" + fila + "," + movColum + ")";
        this.profundidad += 1;
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
        this.operador = "abajo";
        this.Nodo = "(" + movFila + "," + colum + ")";
        this.profundidad += 1;
        return this.Estado;
    }

    public void verificarAmplitudV1(ArrayList<Nodo> cola, Nodo padre) {

        int cont = 0;
        cola.add(padre);
        int fila = 0, colum = 0;
        String mov = "";
        char verIzquierda, verArriba, verDerecha, verAbajo;

        while (cont < 2) {

            Nodo nodoExpandido = cola.remove(0);
            System.err.println("Nodo Expandido: "+nodoExpandido.getOperador());
            
            System.err.println("Nodo Fila: "+nodoExpandido.getPosFila());
            System.err.println("Nodo Colum: "+nodoExpandido.getPosColum());
            
            if (nodoExpandido.getOperador() == null) {
                System.err.println("Entro a null ");
                fila = matriz.EncontrarJugador(nodoExpandido.getEstado())[0];
                colum = matriz.EncontrarJugador(nodoExpandido.getEstado())[1];
            } else {
                System.err.println("No Entro a null ");
                fila = nodoExpandido.getPosFila();
                colum = nodoExpandido.getPosColum();
            }

            System.err.println("Fila: " + fila);
            System.err.println("Columna: " + colum);
            
            mov = verificar(fila, colum);

            verIzquierda = mov.charAt(0);
            verArriba = mov.charAt(1);
            verDerecha = mov.charAt(2);
            verAbajo = mov.charAt(3);
            
            System.err.println("movimientos: " + mov);
            System.err.println("ver IZ: " + verIzquierda);
            System.err.println("ver ARR: " + verArriba);
            System.err.println("ver DER: " + verDerecha);
            System.err.println("ver ABA: " + verAbajo);
            
            if (verIzquierda == '1') {
                
                int movColumIz = colum - 1;

                if (movColumIz >= 0) {
                    
                    if (movColumIz > 9) {
                        movColumIz = colum;
                    }
                    
                    cola.add(new Nodo(nodoExpandido, "IZ", nodoExpandido.getProfundidad()+1, fila, movColumIz));
                    
                }
            }
            
            if(verArriba == '1'){
                int movFilaAr = fila - 1;

                if (movFilaAr >= 0) {
                    if (movFilaAr > 9) {
                        movFilaAr = fila;
                    }
                    cola.add(new Nodo(nodoExpandido, "ARR", nodoExpandido.getProfundidad()+1, movFilaAr, colum));
                }
            }
            
            if(verDerecha == '1'){
                int movColumDer = colum + 1;

                if (movColumDer >= 0) {
                    if (movColumDer > 9) {
                        movColumDer = colum;
                    }
                    cola.add(new Nodo(nodoExpandido, "DER", nodoExpandido.getProfundidad()+1, fila, movColumDer));
                }
            }
            
            if(verAbajo == '1'){
                int movFilaAba = fila + 1;

                if (movFilaAba >= 0) {
                    if (movFilaAba > 9) {
                        movFilaAba = fila;
                    }
                    cola.add(new Nodo(nodoExpandido, "ABA", nodoExpandido.getProfundidad()+1, movFilaAba, colum));
                }
            }

            //System.err.println("Fila: " + fila);
            //System.err.println("Columna: " + colum);
            for (int i = 0; i < cola.size(); i++) {
                System.out.print("padre operador: "+ cola.get(i).getPadre().getOperador()+" Operador : "+cola.get(i).getOperador() + " - ");

            }
            System.out.println();

            cont++;
        }

    }

    /*public void verificarAmplitud(int[][] estadoInicial, String verificacion) {

        char izq = verificacion.charAt(0);

        ArrayList<Nodo> cola = new ArrayList<>();
        Nodo padre = new Nodo(estadoInicial, null, null, 0);
        int cont = 0, fil = 0;
        int filaIz = 0, columIz = 0, filaArr = 0, columArr = 0, filaDer = 0, columDer = 0, filaAba = 0, columAba = 0;

        cola.add(padre);

        /*Nodo hijo1 = new Nodo(moverIzquierda(2, 2), padre, "IZ", padre.getProfundidad() + 1);
        Nodo hijo2 = new Nodo(moverDerecha(2, 2), padre, "DER", padre.getProfundidad() + 1);

        Nodo hijo11 = new Nodo(moverIzquierda(2, 1), hijo1, "IZ", hijo1.getProfundidad() + 1);
        Nodo hijo12 = new Nodo(moverDerecha(2, 3), hijo1, "DER", hijo1.getProfundidad() + 1);

        while (fil < 10) {
            for (int j = 0; j < 10; j++) {
                System.out.print("" + hijo12.getEstado()[fil][j] + " ");
            }
            System.out.println();
            fil++;
        }
        while (cont < 29) {

            Nodo nodoExpandido = cola.remove(0);
            System.err.println("" + nodoExpandido.getOperador());

            filaIz = matriz.EncontrarJugadorMov(nodoExpandido.getEstado(), 8)[0];
            columIz = matriz.EncontrarJugadorMov(nodoExpandido.getEstado(), 8)[1];
            System.out.println("FIZ" + filaIz);
            System.out.println("CIZ" + columIz);
            filaArr = matriz.EncontrarJugadorMov(nodoExpandido.getEstado(), 9)[0];
            columArr = matriz.EncontrarJugadorMov(nodoExpandido.getEstado(), 9)[1];
            System.out.println("FARR" + filaArr);
            System.out.println("CARR" + columArr);
            filaDer = matriz.EncontrarJugadorMov(nodoExpandido.getEstado(), 10)[0];
            columDer = matriz.EncontrarJugadorMov(nodoExpandido.getEstado(), 10)[1];
            System.out.println("FDER" + filaDer);
            System.out.println("CDER" + columDer);
            filaAba = matriz.EncontrarJugadorMov(nodoExpandido.getEstado(), 11)[0];
            columAba = matriz.EncontrarJugadorMov(nodoExpandido.getEstado(), 11)[1];
            System.out.println("FABA" + filaAba);
            System.out.println("CABA" + columAba);

            while (fil < 10) {
                for (int j = 0; j < 10; j++) {
                    System.out.print("" + nodoExpandido.getEstado()[fil][j] + " ");
                }
                System.out.println();
                fil++;
            }

            if (filaIz != 0 && columIz != 0) {

                int movColumIz = columIz - 1;

                if (movColumIz >= 0) {
                    if (movColumIz > 9) {
                        movColumIz = columIz;
                    }

                    int izquierda = nodoExpandido.getEstado()[filaIz][movColumIz];

                    System.err.println("IZ" + izquierda);

                    if (izquierda != 1 && izquierda != 7 && izquierda != 2) {

                        cola.add(new Nodo(moverIzquierda(filaIz, columIz), nodoExpandido, "IZ", nodoExpandido.getProfundidad() + 1));
                        //nodoExpandido.getEstado()[fila][colum] = estado_inicial[fila][colum];
                    }
                }

            } else {
                cola.add(new Nodo(moverIzquierda(matriz.EncontrarJugador(nodoExpandido.getEstado())[0], matriz.EncontrarJugador(nodoExpandido.getEstado())[1]), nodoExpandido, "IZ", nodoExpandido.getProfundidad() + 1));
            }

            if (filaArr != 0 && columArr != 0) {

                int movFilaAr = filaArr - 1;

                if (movFilaAr >= 0) {
                    if (movFilaAr > 9) {
                        movFilaAr = filaArr;
                    }
                    int arriba = nodoExpandido.getEstado()[movFilaAr][columArr];
                    System.err.println("ARR" + arriba);

                    if (arriba != 1 && arriba != 7 && arriba != 2) {

                        cola.add(new Nodo(this.moverArriba(filaArr, columArr), nodoExpandido, "ARR", nodoExpandido.getProfundidad() + 1));

                    }//nodoExpandido.getEstado()[fila][colum] = estado_inicial[fila][colum];
                }
            } else {
                cola.add(new Nodo(this.moverArriba(matriz.EncontrarJugador(nodoExpandido.getEstado())[0], matriz.EncontrarJugador(nodoExpandido.getEstado())[1]), nodoExpandido, "ARR", nodoExpandido.getProfundidad() + 1));
            }

            if (filaDer != 0 && columDer != 0) {
                int movColumDer = columDer + 1;

                if (movColumDer >= 0) {
                    if (movColumDer > 9) {
                        movColumDer = columDer;
                    }

                    int derecha = nodoExpandido.getEstado()[filaDer][movColumDer];
                    System.err.println("DER" + derecha);

                    if (derecha != 1 && derecha != 7 && derecha != 2) {

                        cola.add(new Nodo(moverDerecha(filaDer, columDer), nodoExpandido, "DER", nodoExpandido.getProfundidad() + 1));
                        //nodoExpandido.getEstado()[fila][colum] = estado_inicial[fila][colum];
                    }

                }

            } else {
                cola.add(new Nodo(moverDerecha(matriz.EncontrarJugador(nodoExpandido.getEstado())[0], matriz.EncontrarJugador(nodoExpandido.getEstado())[1]), nodoExpandido, "DER", nodoExpandido.getProfundidad() + 1));
            }

            if (filaAba != 0 && columAba != 0) {
                int movFilaAba = filaAba + 1;

                if (movFilaAba >= 0) {
                    if (movFilaAba > 9) {
                        movFilaAba = filaAba;
                    }

                    int abajo = nodoExpandido.getEstado()[movFilaAba][columAba];
                    System.err.println("ABA" + abajo);

                    if (abajo != 1 && abajo != 7 && abajo != 2) {

                        cola.add(new Nodo(this.moverAbajo(filaAba, columAba), nodoExpandido, "ABA", nodoExpandido.getProfundidad() + 1));
                        //nodoExpandido.getEstado()[fila][colum] = estado_inicial[fila][colum];
                    }
                }

            } else {
                cola.add(new Nodo(this.moverAbajo(matriz.EncontrarJugador(nodoExpandido.getEstado())[0], matriz.EncontrarJugador(nodoExpandido.getEstado())[1]), nodoExpandido, "ABA", nodoExpandido.getProfundidad() + 1));
            }

            for (int i = 0; i < cola.size(); i++) {
                System.out.print(cola.get(i).getOperador() + " - ");

            }
            System.out.println();
            cont++;
            fil = 0;
        }

    }*/

    public String verificar(int fila, int colum) {

        String movimientos = "";

        int movColumIz = colum - 1;

        if (movColumIz >= 0) {
            if (movColumIz > 9) {
                movColumIz = colum;
            }
            int izquierda = this.Estado[fila][movColumIz];
            if (izquierda != 1 && izquierda != 7) {
                movimientos += "1";
            } else {
                movimientos += "0";
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
            if (arriba != 1 && arriba != 7) {
                movimientos += "1";
            } else {
                movimientos += "0";
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
            if (derecha != 1 && derecha != 7) {
                movimientos += "1";
            } else {
                movimientos += "0";
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
            if (abajo != 1 && abajo != 7) {
                movimientos += "1";
            } else {
                movimientos += "0";
            }
        } else {
            movimientos += "0";
        }

        return movimientos;
    }

    public int[][] mover(String movimientos, int fila, int colum) {

        if (movimientos.equalsIgnoreCase("1010")) {
            return this.moverDerecha(fila, colum);
        }

        if (movimientos.equalsIgnoreCase("1001")) {
            return this.moverIzquierda(fila, colum);
        }

        if (movimientos.equalsIgnoreCase("0100")) {
            return this.moverArriba(fila, colum);
        }

        if (movimientos.equalsIgnoreCase("0010")) {
            return this.moverDerecha(fila, colum);
        }

        if (movimientos.equalsIgnoreCase("0110")) {
            return this.moverArriba(fila, colum);
        }

        if (movimientos.equalsIgnoreCase("1000")) {
            return this.moverIzquierda(fila, colum);
        }

        if (movimientos.equalsIgnoreCase("0001")) {
            return this.moverAbajo(fila, colum);
        }

        if (movimientos.equalsIgnoreCase("0011")) {
            return this.moverDerecha(fila, colum);
        }

        if (movimientos.equalsIgnoreCase("0111")) {
            return this.moverDerecha(fila, colum);
        }

        if (movimientos.equalsIgnoreCase("1100")) {
            return this.moverIzquierda(fila, colum);
        }

        if (movimientos.equalsIgnoreCase("1110")) {
            return this.moverIzquierda(fila, colum);
        }

        if (movimientos.equalsIgnoreCase("1101")) {
            return this.moverIzquierda(fila, colum);
        }

        if (movimientos.equalsIgnoreCase("1011")) {
            return this.moverDerecha(fila, colum);
        }

        if (movimientos.equalsIgnoreCase("0101")) {
            return this.moverAbajo(fila, colum);
        }

        return this.Estado;
    }

    //public 
    public int[][] getEstado() {
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
