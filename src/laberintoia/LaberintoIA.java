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

    
    public void AgenteAmplitud(int[][] m, int op) {
        ArrayList<Nodo> cola = new ArrayList<>();
        Nodo padre = new Nodo(m, null, '0', null, 0, 0);
        ArrayList<Nodo> encontrado = new ArrayList<>();
        int cont = 0;
        bsq.verificarAmplitud(cola, padre);
       
        
        for (int i = 1; i < bsq.getNodosExpandidos().size(); i++) {
            if (bsq.getNodosExpandidos().get(i).getMeta() == '5') {
                
                encontrado.add(cont, bsq.getNodosExpandidos().get(i));
                cont++;
            }

        }
        
        movimientosAmplitud(encontrado.get(op));
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
    
    public void AgenteCostoUniforme(int [][] m,int op){
        
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
       
        movimientosCostoUniforme(encontrado.get(op));
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
    
    
    public void AgenteProfundidad(int[][] m, int op) {
        ArrayList<Nodo> pila = new ArrayList<>();
        Nodo padre = new Nodo(m, null, '0', null, 0, 0);
        ArrayList<Nodo> encontrado = new ArrayList<>();
        int cont = 0;
        bsqP.verficarProfundidad(pila, padre);
        
        
        for (int i = 1; i < bsqP.getNodosExpandidos().size(); i++) {
            if (bsqP.getNodosExpandidos().get(i).getMeta() == '5') {
                
                encontrado.add(cont, bsqP.getNodosExpandidos().get(i));
                cont++;
            }

        }
        
        movimientosProfundidad(encontrado.get(op));
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
    

}
