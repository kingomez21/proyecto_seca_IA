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
    
    public void AgenteBuquedaAmplitud(String verificacion, int[][] estado, int cont){
        if(cont < 28){
            int fila = matriz.EncontrarJugador(estado)[0];
            int colum = matriz.EncontrarJugador(estado)[1];
            String mov = bsq.verificar(fila, colum);
            
            int[][] est = bsq.mover(mov, fila, colum);
            matriz.mostrarMundo(est);
            System.out.println();
            cont++;
            AgenteBuquedaAmplitud(mov, est, cont);
        }
    }
    
    public static void main(String[] args) {
        
        LaberintoIA game = new LaberintoIA();
        String inicial = game.bsq.verificar(2, 2);
        int [][] m = game.matriz.getMatriz();
        game.AgenteBuquedaAmplitud(inicial, m , 0);
        //amplitud.moverDerecha();
        /*
        m.mostrarMundo(amplitud.moverDerecha(m.EncontrarJugador(m.getMatriz())[0], m.EncontrarJugador(m.getMatriz())[1]));
        System.out.println(amplitud.getNodo());
        System.out.println(amplitud.getOperador());
        System.out.println();
        m.mostrarMundo(amplitud.moverDerecha(m.EncontrarJugador(amplitud.getEstado())[0], m.EncontrarJugador(amplitud.getEstado())[1]));
        System.out.println(amplitud.getNodo());
        System.out.println(amplitud.getOperador());
        System.out.println();
        m.mostrarMundo(amplitud.moverArriba(m.EncontrarJugador(amplitud.getEstado())[0], m.EncontrarJugador(amplitud.getEstado())[1]));
        System.out.println(amplitud.getNodo());
        System.out.println(amplitud.getOperador());
        System.out.println();
         m.mostrarMundo(amplitud.moverArriba(m.EncontrarJugador(amplitud.getEstado())[0], m.EncontrarJugador(amplitud.getEstado())[1]));
        System.out.println(amplitud.getNodo());
        System.out.println(amplitud.getOperador());
        System.out.println();
        m.mostrarMundo(amplitud.moverArriba(m.EncontrarJugador(amplitud.getEstado())[0], m.EncontrarJugador(amplitud.getEstado())[1]));
        System.out.println(amplitud.getNodo());
        System.out.println(amplitud.getOperador());
        System.out.println();
        m.mostrarMundo(amplitud.moverAbajo(m.EncontrarJugador(amplitud.getEstado())[0], m.EncontrarJugador(amplitud.getEstado())[1]));
        System.out.println(amplitud.getNodo());
        System.out.println(amplitud.getOperador());
        System.out.println();*/
        
    }
    
}
