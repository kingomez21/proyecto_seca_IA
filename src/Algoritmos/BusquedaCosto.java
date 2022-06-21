/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritmos;

import Model.Matriz;
import Model.Nodo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author USUARIO
 */
public class BusquedaCosto {

    Matriz matriz = new Matriz();
    int[][] Estado = new int[10][10];
    ArrayList<Nodo> nodosExpandidos = new ArrayList<>();

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

    public void verificacionCostoUniforme(ArrayList<Nodo> cola, Nodo padre) {

        int cont = 0;
        int contMeta = 0;
        cola.add(padre);
        int fila = 0, colum = 0;
        int[] mov = new int[4];
        int verIzquierda = 0, verArriba = 0, verDerecha = 0, verAbajo = 0;
        char verIzquierdaMeta = '0', verArribaMeta = '0', verDerechaMeta = '0', verAbajoMeta = '0';
        char meta = '0';

        while (contMeta < 2) {

            /*if(cola.size() == 1){
                Nodo nodoExpandido = cola.remove(0);
                nodosExpandidos.add(nodoExpandido);
            }
            ordenarMenorAMayor(cola).remove(0);*/
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
            //System.out.println("metas: " + meta);
            if (meta == '5') {
                contMeta++;
            }

            mov = verficarCostoCaminos(fila, colum);
            //System.err.println("movimientos: " + mov.length);
            verIzquierda = mov[0];
            verArriba = mov[1];
            verDerecha = mov[2];
            verAbajo = mov[3];
            /*
            System.err.println("IZ: " + verIzquierda);
            System.err.println("ARR: " + verArriba);
            System.err.println("DER: " + verDerecha);
            System.err.println("ABA: " + verAbajo);*/

            if (verIzquierda != 1000) {

                if (verIzquierda == 0) {
                    verIzquierdaMeta = '5';
                    //System.out.println("Meta IZ: " + verIzquierdaMeta);
                }
                int movColumIz = colum - 1;

                if (movColumIz >= 0) {

                    if (movColumIz > 9) {
                        movColumIz = colum;
                    }

                    cola.add(new Nodo(moverIzquierda(fila, colum), nodoExpandido, verIzquierdaMeta, "IZ", nodoExpandido.getProfundidad() + 1, fila, movColumIz, nodoExpandido.getCosto() + verIzquierda));
                    verIzquierdaMeta = '0';
                }
            }

            if (verArriba != 1000) {

                if (verArriba == 0) {
                    verArribaMeta = '5';
                    //System.out.println("Meta ARR: " + verArribaMeta);
                }

                int movFilaAr = fila - 1;

                if (movFilaAr >= 0) {
                    if (movFilaAr > 9) {
                        movFilaAr = fila;
                    }
                    cola.add(new Nodo(moverArriba(fila, colum), nodoExpandido, verArribaMeta, "ARR", nodoExpandido.getProfundidad() + 1, movFilaAr, colum, nodoExpandido.getCosto() + verArriba));
                    verArribaMeta = '0';
                }
            }

            if (verDerecha != 1000) {

                if (verDerecha == 0) {
                    verDerechaMeta = '5';
                    //System.out.println("Meta DER: " + verDerechaMeta);
                }

                int movColumDer = colum + 1;

                if (movColumDer >= 0) {
                    if (movColumDer > 9) {
                        movColumDer = colum;
                    }
                    cola.add(new Nodo(moverDerecha(fila, colum), nodoExpandido, verDerechaMeta, "DER", nodoExpandido.getProfundidad() + 1, fila, movColumDer, nodoExpandido.getCosto() + verDerecha));
                    verDerechaMeta = '0';
                }
            }

            if (verAbajo != 1000) {

                if (verAbajo == 0) {
                    verAbajoMeta = '5';
                    //System.out.println("Meta ABA: " + verAbajoMeta);
                }

                int movFilaAba = fila + 1;

                if (movFilaAba >= 0) {
                    if (movFilaAba > 9) {
                        movFilaAba = fila;
                    }
                    cola.add(new Nodo(moverAbajo(fila, colum), nodoExpandido, verAbajoMeta, "ABA", nodoExpandido.getProfundidad() + 1, movFilaAba, colum, nodoExpandido.getCosto() + verAbajo));
                    verAbajoMeta = '0';
                }
            }

            Collections.sort(cola, new Comparator<Nodo>() {
                @Override
                public int compare(Nodo o1, Nodo o2) {
                    return new Integer(o1.getCosto()).compareTo(new Integer(o2.getCosto()));
                }
            });
            //cont++;
        }
    }

    public int[] verficarCostoCaminos(int fila, int colum) {

        //String mover = "";
        int[] mover = new int[4];

        int iz = 0, arr = 0, der = 0, aba = 0;

        int movColumIz = colum - 1;

        if (movColumIz >= 0) {
            if (movColumIz > 9) {
                movColumIz = colum;
            }
            int izquierda = this.Estado[fila][movColumIz];

            if (izquierda == 5) {
                iz = 0;
            } else {
                if (izquierda != 1 && izquierda != 7 && izquierda != 5) {
                    if (izquierda == 6) {
                        iz = 4;
                    } else {
                        iz = 1;
                    }

                } else {
                    iz = 1000;
                }
            }

        } else {
            iz = 1000;
        }

        int movFilaAr = fila - 1;

        if (movFilaAr >= 0) {
            if (movFilaAr > 9) {
                movFilaAr = fila;
            }
            int arriba = this.Estado[movFilaAr][colum];

            if (arriba == 5) {
                arr = 0;
            } else {
                if (arriba != 1 && arriba != 7 && arriba != 5) {
                    if (arriba == 6) {
                        arr = 4;
                    } else {
                        arr = 1;
                    }

                } else {
                    arr = 1000;
                }
            }

        } else {
            arr = 1000;
        }

        int movColumDer = colum + 1;

        if (movColumDer >= 0) {
            if (movColumDer > 9) {
                movColumDer = colum;
            }

            int derecha = this.Estado[fila][movColumDer];

            if (derecha == 5) {
                der = 0;
            } else {

                if (derecha != 1 && derecha != 7 && derecha != 5) {
                    if (derecha == 6) {
                        der = 4;
                    } else {
                        der = 1;
                    }

                } else {
                    der = 1000;
                }
            }

        } else {
            der = 1000;
        }

        int movFilaAba = fila + 1;

        if (movFilaAba >= 0) {
            if (movFilaAba > 9) {
                movFilaAba = fila;
            }

            int abajo = this.Estado[movFilaAba][colum];
            if (abajo == 5) {
                aba = 0;
            } else {
                if (abajo != 1 && abajo != 7 && abajo != 5) {
                    if (abajo == 6) {
                        aba = 4;
                    } else {
                        aba = 1;
                    }
                } else {
                    aba = 1000;
                }
            }
        } else {
            aba = 1000;
        }

        mover[0] = iz;
        mover[1] = arr;
        mover[2] = der;
        mover[3] = aba;
        return mover;
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

    public ArrayList<Nodo> getNodosExpandidos() {
        return nodosExpandidos;
    }

    public void setNodosExpandidos(ArrayList<Nodo> nodosExpandidos) {
        this.nodosExpandidos = nodosExpandidos;
    }

    //ordenamiento wuiki wuiki
    public ArrayList<Nodo> ordenarMenorAMayor(ArrayList<Nodo> listaDeNodos) {

        Collections.sort(listaDeNodos, new Comparator<Nodo>() {
            @Override
            public int compare(Nodo o1, Nodo o2) {
                return new Integer(o1.getCosto()).compareTo(new Integer(o2.getCosto()));
            }
        });
        for (int i = 0; i < listaDeNodos.size(); i++) {
            System.out.println("DATA: " + listaDeNodos.get(i).getCosto());
        }

        return listaDeNodos;
    }

}
