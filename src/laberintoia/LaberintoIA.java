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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Matriz m = new Matriz();
        m.CargarMundo();
        //System.out.println(m.EncontrarJugador(m.getMatriz())[0]);
        //System.out.println(m.EncontrarJugador(m.getMatriz())[1]);
        BusquedaAmplitud amplitud = new BusquedaAmplitud(m.getMatriz());

        //amplitud.moverDerecha();
        m.mostrarMundo(amplitud.moverDerecha(m.EncontrarJugador(m.getMatriz())[0], m.EncontrarJugador(m.getMatriz())[1]));
        System.out.println(amplitud.getNodo());
        System.out.println(amplitud.getOperador());
        System.out.println();
        System.out.println(m.EncontrarJugador(amplitud.getEstado())[0]);
        System.out.println(m.EncontrarJugador(amplitud.getEstado())[1]);
        m.mostrarMundo(amplitud.moverDerecha(m.EncontrarJugador(amplitud.getEstado())[0], m.EncontrarJugador(amplitud.getEstado())[1]));
    }
    
}
