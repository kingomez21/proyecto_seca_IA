/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberintoia;

import Algoritmos.BusquedaAmplitud;
import Algoritmos.BusquedaCosto;
import Model.Matriz;
import Model.Nodo;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class LaberintoIA {

    Matriz matriz;
    BusquedaAmplitud bsq;
    BusquedaCosto bsqC;
    ArrayList<Nodo> listaMovimientosAmplitud;

    public LaberintoIA() {

        matriz = new Matriz();
        matriz.CargarMundo();
        bsq = new BusquedaAmplitud(matriz.getMatriz());
        bsqC = new BusquedaCosto(matriz.getMatriz());
        listaMovimientosAmplitud = new ArrayList<>();

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

    public void AgenteAmplitud(int[][] m) {
        ArrayList<Nodo> cola = new ArrayList<>();
        Nodo padre = new Nodo(m, null, '0', null, 0);
        Nodo encontrado = null;
        bsq.verificarAmplitudV1(cola, padre);
        System.err.println("" + bsq.getNodosExpandidos().size());
        for (int i = 1; i < bsq.getNodosExpandidos().size(); i++) {
            if (bsq.getNodosExpandidos().get(i).getMeta() == '5') {
                encontrado = bsq.getNodosExpandidos().get(i);
                /*System.out.print("Operador del padre: " + bsq.getNodosExpandidos().get(i).getPadre().getPadre().getPadre().getOperador()
                        + " FilPadre: " + bsq.getNodosExpandidos().get(i).getPadre().getPadre().getPadre().getPosFila()
                        + " ColumPadre: " + bsq.getNodosExpandidos().get(i).getPadre().getPadre().getPadre().getPosColum()
                        + " Operador: " + bsq.getNodosExpandidos().get(i).getOperador()
                        + " posF: " + bsq.getNodosExpandidos().get(i).getPosFila()
                        + " Colum: " + bsq.getNodosExpandidos().get(i).getPosColum() + "\n");
*/
            }

        }

        movimientosAmplitud(encontrado);
    }

    public void movimientosAmplitud(Nodo meta) {
        if (meta.getOperador() != null) {
            Nodo recorridoNodo = meta;
            listaMovimientosAmplitud.add(meta);
            movimientosAmplitud(meta.getPadre());
        }

    }

    public void recorridoAmplitud(int matris[][], int fl, int col, int contador, int pos) {

        
        int fila = 0, colum = 0;

        if (contador < listaMovimientosAmplitud.size()) {
            pos--;
            
            if (contador == 0) {
                fila = fl;
                colum = col;
            } else {
                fila = matriz.EncontrarJugador(matris)[0];
                colum = matriz.EncontrarJugador(matris)[1];
            }
            //System.out.println(""+listaMovimientosAmplitud.get(pos).getOperador());
            //listaMovimientosAmplitud.get(pos).getPosColum();
            //int fila = matriz.EncontrarJugador(matris)[0];
            //int colum = matriz.EncontrarJugador(matris)[1];
            System.err.println("Fila: " + fila);
            System.err.println("Columna: " + colum);
            int[][] estadoMov = bsq.moverJugador(listaMovimientosAmplitud.get(pos).getOperador(), fila, colum);
            matriz.mostrarMundo(estadoMov);
            System.out.println();
            contador++;
            
            recorridoAmplitud(estadoMov, fila, colum, contador, pos);
        }

    }
    
    public void eliminarRecorrido(){
        for (int i = 0; i < listaMovimientosAmplitud.size(); i++) {
           listaMovimientosAmplitud.removeAll(listaMovimientosAmplitud);
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
        
        
        // Secuencia para resolver la busqueda por amplitud
        /*
        game.AgenteAmplitud(m);
        game.matriz.CargarMundo();
        int [][] m2 = game.matriz.getMatriz();
        game.recorridoAmplitud(m2, fila, colum, 0, game.listaMovimientosAmplitud.size());
        System.err.println("Nodos expandidos"+ game.listaMovimientosAmplitud.size() +" Profundidad: "+game.listaMovimientosAmplitud.get(0).getProfundidad());
        game.eliminarRecorrido();
        
        int fila2 = game.matriz.EncontrarJugador(m)[0];
        int colum2 = game.matriz.EncontrarJugador(m)[1];
        System.err.println("" + fila2);
        System.err.println("" + colum2);
        //int [][] m3 = m2;
        game.AgenteAmplitud(m2);
        //game.matriz.mostrarMundo(m2);
        game.matriz.CargarMundo();
        int [][] m3 = game.matriz.getMatriz();
        m3[fila][colum]= 7; 
        game.recorridoAmplitud(m3, fila2, colum2, 0, game.listaMovimientosAmplitud.size());
        System.err.println("Nodos expandidos"+ game.listaMovimientosAmplitud.size() +" Profundidad: "+game.listaMovimientosAmplitud.get(0).getProfundidad());
        */

    }

}
