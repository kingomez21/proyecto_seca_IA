/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos;

/**
 *
 * @author USUARIO
 */
public class BusquedaCosto {

    int[][] Estado = new int[10][10];
    String Nodo;
    int profundidad;
    int Costo;
    String operador;

    public BusquedaCosto(int[][] estado) {
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

    public String verficarCostoCaminos(int fila, int colum) {

        String mover = "";
        int iz = 1000, arr = 1000, der = 1000, aba = 1000;

        int movColumIz = colum - 1;

        if (movColumIz >= 0) {
            if (movColumIz > 9) {
                movColumIz = colum;
            }
            int izquierda = this.Estado[fila][movColumIz];

            if (izquierda != 1 && izquierda != 7 && izquierda != 2) {
                if(izquierda == 6){
                    iz = this.Costo + 4;
                } else {
                    iz = this.Costo + 1;
                }
                
            } else {
                iz = 1000;
            }

        }

        int movFilaAr = fila - 1;

        if (movFilaAr >= 0) {
            if (movFilaAr > 9) {
                movFilaAr = fila;
            }
            int arriba = this.Estado[movFilaAr][colum];

            if (arriba != 1 && arriba != 7 && arriba != 2) {
                if(arriba == 6){
                    arr = this.Costo + 4;
                }else {
                    arr = this.Costo + 1;
                }
                
            } else {
                arr = 1000;
            }

        }

        int movColumDer = colum + 1;

        if (movColumDer >= 0) {
            if (movColumDer > 9) {
                movColumDer = colum;
            }

            int derecha = this.Estado[fila][movColumDer];

            if (derecha != 1 && derecha != 7 && derecha != 2) {
                if(derecha == 6){
                    der = this.Costo + 4;
                }else {
                    der = this.Costo + 1;
                }
                    
                
            } else {
                der = 1000;
            }

        }

        int movFilaAba = fila + 1;

        if (movFilaAba >= 0) {
            if (movFilaAba > 9) {
                movFilaAba = fila;
            }

            int abajo = this.Estado[movFilaAba][colum];

            if (abajo != 1 && abajo != 7 && abajo != 2) {
                if(abajo == 6){
                    aba = this.Costo + 4;
                }else {
                    aba = this.Costo + 1;
                }
            } else {
                aba = 1000;
            }

        }

        System.err.println(arr);
        System.err.println(iz);
        System.err.println(der);
        System.err.println(aba);
        
        if (iz != 1000) {
            if (iz <= arr && iz <= der && iz <= aba) {
                mover = "IZ";
            }
        }
        if (arr != 1000) {
            if (arr <= iz && arr <= der && arr <= aba) {
                mover = "ARR";
            }
        }
        if (der != 1000) {
            if (der <= arr && der <= iz && der <= aba) {
                mover = "DER";
            }
        }
        if (aba != 1000) {
            if (aba <= arr && aba <= iz && aba <= der) {
                mover = "ABA";
            }
        }

        return mover;
    }

    public int[][] mover(String mov, int fila, int colum) {

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

    public void setCostoAcumulado(int Costo) {
        this.Costo += Costo;
    }

    public int[][] getEstado() {
        return Estado;
    }

    public String getNodo() {
        return Nodo;
    }

    public int getProfundidad() {
        return profundidad;
    }

    public int getCosto() {
        return Costo;
    }

    public String getOperador() {
        return operador;
    }

    
    
}
