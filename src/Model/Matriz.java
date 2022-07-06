/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author USUARIO
 */
public class Matriz {

    private int matriz[][];

    public Matriz() {
        this.matriz = new int[10][10];
    }

    public void CargarMundo() {

        try {
            BufferedReader br = new BufferedReader(new FileReader("matriz.txt"));
            //Primera linea nos dice longitud de la matriz
            String linea = br.readLine();

            int fila = 0; //Para recorrer las filas de la matriz
            while (linea != null) {
                /*
				 * Tenemos todos los enteros JUNTOS en el String linea.
				 * Con split() los SEPARAMOS en un array donde cada entero
				 * es un String individual. Con un bucle, los parseamos a Integer
				 * para guardarlos en la matriz
                 */
                String[] enteros = linea.split(" ");
                for (int i = 0; i < enteros.length; i++) {
                    matriz[fila][i] = Integer.parseInt(enteros[i]);
                }

                fila++; //Incrementamos fila para la próxima línea de enteros
                linea = br.readLine(); //Leemos siguiente línea
            }
            br.close(); //Cerramos el lector de ficheros

            //Mostramos la matriz leída
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra archivo");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("No se pudo convertir a entero");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error accediendo al archivo.");
            e.printStackTrace();
        }

    }

    public int[][] getMatriz() {
        return this.matriz;
    }

    public int[] EncontrarJugador(int[][] m) {
        int[] jugador = new int[2];
        int fila = 0;
        while (fila < 10) {
            for (int i = 0; i < 10; i++) {

                if (m[fila][i] == 2) {
                    jugador[0] = fila;
                    jugador[1] = i;
                }

            }

            fila++;
        }
        return jugador;
    }
    
    public int[] EncontrarJugadorMov(int[][] m, int mov) {
        int[] jugador = new int[2];
        int fila = 0;
        while (fila < 10) {
            for (int i = 0; i < 10; i++) {

                if (m[fila][i] == mov) {
                    jugador[0] = fila;
                    jugador[1] = i;
                }

            }

            fila++;
        }
        return jugador;
    }

    public void mostrarMundo(int mundo[][]) {
        int fila = 0;

        while (fila < 10) {
            for (int i = 0; i < 10; i++) {
                System.out.print(mundo[fila][i]+" ");
            }
            System.out.println();

            fila++;
        }

    }

}
