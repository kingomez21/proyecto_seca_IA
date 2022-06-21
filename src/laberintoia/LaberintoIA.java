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
import java.util.Collections;
import java.util.Comparator;
import java.util.Timer;

/**
 *
 * @author USUARIO
 */
public class LaberintoIA {

    Matriz matriz;
    BusquedaAmplitud bsq;
    BusquedaCosto bsqC;
    ArrayList<Nodo> listaMovimientosAmplitud;
    ArrayList<Nodo> listaMovimientosAmplitud2;
    
    ArrayList<Nodo> listaMovimientosCostoUniforme;
    ArrayList<Nodo> listaMovimientosCostoUniforme2;
    

    public LaberintoIA() {

        matriz = new Matriz();
        matriz.CargarMundo();
        bsq = new BusquedaAmplitud(matriz.getMatriz());
        bsqC = new BusquedaCosto(matriz.getMatriz());
        
        listaMovimientosAmplitud = new ArrayList<>();
        listaMovimientosAmplitud2 = new ArrayList<>();
        
        listaMovimientosCostoUniforme = new ArrayList<>();
        listaMovimientosCostoUniforme2 =  new ArrayList<>();
    }

    
    public void AgenteAmplitud(int[][] m) {
        ArrayList<Nodo> cola = new ArrayList<>();
        Nodo padre = new Nodo(m, null, '0', null, 0, 0);
        ArrayList<Nodo> encontrado = new ArrayList<>();
        int cont = 0;
        bsq.verificarAmplitudV1(cola, padre);
        System.err.println("" + bsq.getNodosExpandidos().size());
        
        for (int i = 1; i < bsq.getNodosExpandidos().size(); i++) {
            if (bsq.getNodosExpandidos().get(i).getMeta() == '5') {
                
                encontrado.add(cont, bsq.getNodosExpandidos().get(i));
                cont++;
            }

        }
        System.out.println("metas encontradas: "+cont);
        //movimientosAmplitud(encontrado.get(0));
        movimientosAmplitud(encontrado.get(0));
    }

    public void movimientosAmplitud(Nodo meta) {
        if (meta.getOperador() != null) {
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
    
    public void AgenteCostoUniforme(int [][] m){
        
        ArrayList<Nodo> cola = new ArrayList<>();
        Nodo padre = new Nodo(m, null, '0', null, 0, 0);
        ArrayList<Nodo> encontrado = new ArrayList<>();
        int cont = 0;
        bsqC.verificacionCostoUniforme(cola, padre);
        
        //System.err.println("" + bsqC.getNodosExpandidos().size());
        
        for (int i = 1; i < bsqC.getNodosExpandidos().size(); i++) {
            if (bsqC.getNodosExpandidos().get(i).getMeta() == '5') {
                
                encontrado.add(cont, bsqC.getNodosExpandidos().get(i));
                cont++;
            }

        }
        //System.out.println("metas encontradas: "+cont);
        //movimientosAmplitud(encontrado.get(0));
        //System.out.println("operador: "+encontrado.get(1).getOperador());
        movimientosCostoUniforme(encontrado.get(1));
    }
    
    public void movimientosCostoUniforme(Nodo meta){
        if (meta.getOperador() != null) {
            listaMovimientosCostoUniforme.add(meta);
            movimientosCostoUniforme(meta.getPadre());
        }
    }
    
    public void recorridoCostoUniforme(int matris[][], int fl, int col, int contador, int pos){
        int fila = 0, colum = 0;

        if (contador < listaMovimientosCostoUniforme.size()) {
            pos--;
            
            if (contador == 0) {
                fila = fl;
                colum = col;
            } else {
                fila = matriz.EncontrarJugador(matris)[0];
                colum = matriz.EncontrarJugador(matris)[1];
            }
            System.err.println("Fila: " + fila);
            System.err.println("Columna: " + colum);
            int[][] estadoMov = bsqC.moverJugador(listaMovimientosCostoUniforme.get(pos).getOperador(), fila, colum);
            matriz.mostrarMundo(estadoMov);
            System.out.println();
            contador++;
            
            recorridoCostoUniforme(estadoMov, fila, colum, contador, pos);
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
        game.matriz.mostrarMundo(m);
        System.out.println();
        game.matriz.CargarMundo();
        int [][] m2 = game.matriz.getMatriz();
        game.recorridoAmplitud(m2, fila, colum, 0, game.listaMovimientosAmplitud.size());
        System.err.println("Nodos expandidos: "+ game.bsq.getNodosExpandidos().size() +" Profundidad: "+game.listaMovimientosAmplitud.get(0).getProfundidad());
        game.eliminarRecorrido();
        */
        
        // Secuencia para resolver la busqueda costo uniforme
        
        game.AgenteCostoUniforme(m);
        game.matriz.mostrarMundo(m);
        System.out.println();
        game.matriz.CargarMundo();
        int [][] m2 = game.matriz.getMatriz();
        game.recorridoCostoUniforme(m2, fila, colum, 0, game.listaMovimientosCostoUniforme.size());
        System.err.println("Nodos expandidos: "+ game.bsqC.getNodosExpandidos().size() +" Profundidad: "+game.listaMovimientosCostoUniforme.get(0).getCosto());
        /*Collections.sort(game.bsqC.getNodosExpandidos(), new Comparator<Nodo> () {
            @Override
            public int compare(Nodo o1, Nodo o2) {
                return new Integer(o2.getCosto()).compareTo(new Integer(o1.getCosto()));
            }
        });
        for (int i = 0; i < game.bsqC.getNodosExpandidos().size(); i++) {
            System.out.println("DATA: "+game.bsqC.getNodosExpandidos().get(i).getCosto());
        }*/

    }

}
