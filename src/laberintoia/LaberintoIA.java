/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberintoia;

import Algoritmos.BusquedaAmplitud;
import Model.Matriz;

/**
 *
 * @author USUARIO
 */
public class LaberintoIA {

    Matriz matriz;
    BusquedaAmplitud bsq;

    public LaberintoIA() {
        matriz = new Matriz();
        matriz.CargarMundo();
        bsq = new BusquedaAmplitud(matriz.getMatriz());

    }

    public void AgenteBuquedaAmplitud(String verificacion, int[][] estado, int cont) {
        try {
            if (cont < 29) {
                int fila = matriz.EncontrarJugador(estado)[0];
                int colum = matriz.EncontrarJugador(estado)[1];
                String mov = bsq.verificar(fila, colum);
                int[][] est = bsq.mover(mov, fila, colum);
                System.err.println("Nodo: "+bsq.getNodo()+" operador: "+bsq.getOperador()+" profundidad: "+bsq.getProfundidad());
                matriz.mostrarMundo(est);
                System.out.println();
                cont++;
                AgenteBuquedaAmplitud(mov, est, cont);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.print("El Jugador quedo encerrado");
        }

    }

    public static void main(String[] args) {

        LaberintoIA game = new LaberintoIA();
        String inicial = game.bsq.verificar(2, 2);
        int[][] m = game.matriz.getMatriz();
        game.AgenteBuquedaAmplitud(inicial, m, 0);

    }

}
