/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GestionArchivo {
    
    public GestionArchivo() {

    }
    
    public int[][] abrirArchivo(){
       int[][] laberinto = new int [10][10];
       try{            
           BufferedReader lector = new BufferedReader(new FileReader("matriz.txt"));            

           String linea; 
           int i=0;
           // solo lee la matriz.
           while(i < 10){   
               linea = lector.readLine();
               String[] cadena = linea.split(" "); 
               for (int j=0; j<10; j++) { 
                   laberinto[i][j] = Integer.parseInt(cadena[j]); // asigna un String a cada posicion (i,j) de la matriz.
               } 
               i++; // siguiente fila.
           }
           lector.close();
           for(int n=0; n<10; n++){
               for(int m=0; m<10; m++){
                   System.out.print(laberinto[n][m] + " ");
               }
               System.out.println("");
           }

       }
       catch(IOException e){
           System.err.println(e);
       }
       return laberinto;        
   }
}
