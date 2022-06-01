/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberintoia;

import Algoritmos.BusquedaAmplitud;
import Algoritmos.BusquedaCosto;
import Model.Matriz;

/**
 *
 * @author USUARIO
 */
public class LaberintoIA {

    Matriz matriz;
    BusquedaAmplitud bsq;
    BusquedaCosto bsqC;

    public LaberintoIA() {

        matriz = new Matriz();
        matriz.CargarMundo();
        bsq = new BusquedaAmplitud(matriz.getMatriz());
        bsqC = new BusquedaCosto(matriz.getMatriz());

    }

    public void AgenteBuquedaAmplitud(String verificacion, int[][] estado, int cont) {
        try {
            if (cont < 29) {
                int fila = matriz.EncontrarJugador(estado)[0];
                int colum = matriz.EncontrarJugador(estado)[1];
                String mov = bsq.verificar(fila, colum);
                int[][] est = bsq.mover(mov, fila, colum);
                System.out.println("Nodo: " + bsq.getNodo() + " operador: " + bsq.getOperador() + " profundidad: " + bsq.getProfundidad());
                matriz.mostrarMundo(est);
                System.out.println();
                cont++;
                AgenteBuquedaAmplitud(mov, est, cont);
            }
        } catch (IndexOutOfBoundsException e) {
            System.err.print("El Jugador quedo encerrado");
        }

    }

    public void AgenteBusquedaCostoUniforme(int[][] estado, int cont) {
        try {
            if (cont < 29) {
                int fila = matriz.EncontrarJugador(estado)[0];
                int colum = matriz.EncontrarJugador(estado)[1];
                String verficacion = bsqC.verficarCostoCaminos(fila, colum);
                bsqC.setCostoAcumulado(bsqC.getProfundidad());
                int[][] est = bsqC.mover(verficacion, fila, colum);
                matriz.mostrarMundo(est);
                System.out.println();
                cont++;
                AgenteBusquedaCostoUniforme(est, cont);
            }

        } catch (IndexOutOfBoundsException e) {
            System.err.println("Jugador quedo encerrado");
        }
    }

    public static void main(String[] args) {

        LaberintoIA game = new LaberintoIA();
        int[][] m = game.matriz.getMatriz();
        int fila = game.matriz.EncontrarJugador(m)[0];
        int colum = game.matriz.EncontrarJugador(m)[1];
        String inicial = game.bsq.verificar(fila, colum);
        //game.AgenteBuquedaAmplitud(inicial, m, 0);

        game.AgenteBusquedaCostoUniforme(m, 0);

    }

}
