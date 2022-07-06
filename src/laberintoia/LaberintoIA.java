/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laberintoia;

import Algoritmos.BusquedaAmplitud;
import Algoritmos.BusquedaCosto;
import Algoritmos.BusquedaProfundidad;
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

    public Matriz matriz;
    public BusquedaAmplitud bsq;
    public BusquedaCosto bsqC;
    public BusquedaProfundidad bsqP;
    public ArrayList<Nodo> listaMovimientosAmplitud;
    public ArrayList<Nodo> listaMovimientosAmplitud2;
    
    public ArrayList<Nodo> listaMovimientosCostoUniforme;
    public ArrayList<Nodo> listaMovimientosCostoUniforme2;
    
    public ArrayList<Nodo> listaMovimientosProfundidad;

    public LaberintoIA() {

        matriz = new Matriz();
        matriz.CargarMundo();
        bsq = new BusquedaAmplitud(matriz.getMatriz());
        bsqC = new BusquedaCosto(matriz.getMatriz());
        bsqP = new BusquedaProfundidad(matriz.getMatriz());
        
        listaMovimientosAmplitud = new ArrayList<>();
        listaMovimientosAmplitud2 = new ArrayList<>();
        
        listaMovimientosCostoUniforme = new ArrayList<>();
        listaMovimientosCostoUniforme2 =  new ArrayList<>();
        
        listaMovimientosProfundidad = new ArrayList<>();
    }

    
    public void AgenteAmplitud(int[][] m) {
        ArrayList<Nodo> cola = new ArrayList<>();
        Nodo padre = new Nodo(m, null, '0', null, 0, 0);
        ArrayList<Nodo> encontrado = new ArrayList<>();
        int cont = 0;
        bsq.verificarAmplitud(cola, padre);
        System.err.println("" + bsq.getNodosExpandidos().size());
        
        for (int i = 1; i < bsq.getNodosExpandidos().size(); i++) {
            if (bsq.getNodosExpandidos().get(i).getMeta() == '5') {
                
                encontrado.add(cont, bsq.getNodosExpandidos().get(i));
                cont++;
            }

        }
        //System.out.println("metas encontradas: "+cont);
        //movimientosAmplitud(encontrado.get(0));
        movimientosAmplitud(encontrado.get(1));
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
        
        for (int i = 1; i < bsqC.getNodosExpandidos().size(); i++) {
            if (bsqC.getNodosExpandidos().get(i).getMeta() == '5') {
                
                encontrado.add(cont, bsqC.getNodosExpandidos().get(i));
                cont++;
            }

        }
        //System.out.println("metas encontradas: "+cont);
        //movimientosAmplitud(encontrado.get(0));
        //System.out.println("operador: "+encontrado.get(1).getOperador());
        movimientosCostoUniforme(encontrado.get(0));
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
            int[][] estadoMov = bsqC.moverJugador(listaMovimientosCostoUniforme.get(pos).getOperador(), fila, colum);
            matriz.mostrarMundo(estadoMov);
            System.out.println();
            contador++;
            
            recorridoCostoUniforme(estadoMov, fila, colum, contador, pos);
        }
    }
    
    public void eliminarRecorridoCosto(){
        for (int i = 0; i < listaMovimientosCostoUniforme.size(); i++) {
           listaMovimientosCostoUniforme.removeAll(listaMovimientosCostoUniforme);
        }
    }
    
    
    public void AgenteProfundidad(int[][] m) {
        ArrayList<Nodo> pila = new ArrayList<>();
        Nodo padre = new Nodo(m, null, '0', null, 0, 0);
        ArrayList<Nodo> encontrado = new ArrayList<>();
        int cont = 0;
        bsqP.verficarProfundidad(pila, padre);
        //System.err.println("" + bsqP.getNodosExpandidos().size());
        
        for (int i = 1; i < bsqP.getNodosExpandidos().size(); i++) {
            if (bsqP.getNodosExpandidos().get(i).getMeta() == '5') {
                
                encontrado.add(cont, bsqP.getNodosExpandidos().get(i));
                cont++;
            }

        }
        //System.out.println("metas encontradas: "+cont);
        //movimientosAmplitud(encontrado.get(0));
        movimientosProfundidad(encontrado.get(1));
    }

    public void movimientosProfundidad(Nodo meta) {
        if (meta.getOperador() != null) {
            listaMovimientosProfundidad.add(meta);
            movimientosProfundidad(meta.getPadre());
        }

    }
    
   

    public void recorridoProfundidad(int matris[][], int fl, int col, int contador, int pos) {

        
        int fila = 0, colum = 0;

        if (contador < listaMovimientosProfundidad.size()) {
            pos--;
            
            if (contador == 0) {
                fila = fl;
                colum = col;
            } else {
                fila = matriz.EncontrarJugador(matris)[0];
                colum = matriz.EncontrarJugador(matris)[1];
            }
            
            int[][] estadoMov = bsqP.moverJugador(listaMovimientosProfundidad.get(pos).getOperador(), fila, colum);
            matriz.mostrarMundo(estadoMov);
            System.out.println();
            contador++;
            
            recorridoProfundidad(estadoMov, fila, colum, contador, pos);
        }

    }
    
    public void eliminarRecorridoProfundidad(){
        for (int i = 0; i < listaMovimientosProfundidad.size(); i++) {
           listaMovimientosProfundidad.removeAll(listaMovimientosProfundidad);
        }
    }
    
    
    //public static void main(String[] args) {
        /*
        LaberintoIA game = new LaberintoIA();
        int[][] m = game.matriz.getMatriz();
        int fila = game.matriz.EncontrarJugador(m)[0];
        int colum = game.matriz.EncontrarJugador(m)[1];
        */
        
        
        // Secuencia para resolver la busqueda por amplitud
        /*
        game.AgenteAmplitud(m);
        game.matriz.mostrarMundo(m);
        System.out.println();
        game.matriz.CargarMundo();
        int [][] m2 = game.matriz.getMatriz();
        game.recorridoAmplitud(m2, fila, colum, 0, game.listaMovimientosAmplitud.size());
        long tiempoFinalAmplitud = System.currentTimeMillis();
        tiempoFinalAmplitud = (tiempoFinalAmplitud - game.bsq.getTiempoInicial());
        System.err.println("Nodos expandidos: "+ game.bsq.getNodosExpandidos().size() +
                " Profundidad: "+game.listaMovimientosAmplitud.get(0).getProfundidad() +
                " Tiempo: "+tiempoFinalAmplitud+" Milisegundos");
        game.eliminarRecorrido();
        */
        
        // Secuencia para resolver la busqueda costo uniforme
        /*
        game.AgenteCostoUniforme(m);
        game.matriz.mostrarMundo(m);
        System.out.println();
        game.matriz.CargarMundo();
        int [][] m3 = game.matriz.getMatriz();
        game.recorridoCostoUniforme(m3, fila, colum, 0, game.listaMovimientosCostoUniforme.size());
        long tiempoFinalCosto = System.currentTimeMillis();
        tiempoFinalCosto = (tiempoFinalCosto - game.bsq.getTiempoInicial());
        System.err.println("Nodos expandidos: "+ game.bsqC.getNodosExpandidos().size() +
                " Profundidad: "+game.listaMovimientosCostoUniforme.get(0).getProfundidad()+ 
                " Costo: "+game.listaMovimientosCostoUniforme.get(0).getCosto() +
                " Tiempo: "+tiempoFinalCosto+" Milisegundos");
        
        game.eliminarRecorridoCosto();*/
        
    // secuencia para resolver profundidad
    /*
        game.AgenteProfundidad(m);
        game.matriz.mostrarMundo(m);
        System.out.println();
        game.matriz.CargarMundo();
        int [][] m2 = game.matriz.getMatriz();
        game.recorridoProfundidad(m2, fila, colum, 0, game.listaMovimientosProfundidad.size());
        long tiempoFinalAmplitud = System.currentTimeMillis();
        tiempoFinalAmplitud = (tiempoFinalAmplitud - game.bsqP.getTiempoInicial());
        System.err.println("Nodos expandidos: "+ game.bsqP.getNodosExpandidos().size() +
                " Profundidad: "+game.listaMovimientosProfundidad.get(0).getProfundidad() +
                " Tiempo: "+tiempoFinalAmplitud+" Milisegundos");
        game.eliminarRecorridoProfundidad();*/
    
    //}

}
