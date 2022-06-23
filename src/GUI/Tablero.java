/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Rectangle;
import javax.swing.*;

public class Tablero extends JFrame{
                
    public Tablero() {
        
    }
    
    public JLabel[][] dibujarTablero(int[][] laberinto, JPanel panel){
        
        panel.removeAll(); // elimina todos los componentes del tablero.
        panel.repaint(); // re-dibuja el tamaño del tablero m*n
        JLabel[][] tablero = new JLabel[10][10];
        
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                tablero[i][j] = new JLabel();
                tablero[i][j].setOpaque(true);
                tablero[i][j].setBounds(new Rectangle(50, 50)); // se dibuja como un rectangulo.
                ImageIcon imagen = seleccionarIcono(laberinto[i][j]);
                tablero[i][j].setLocation(j*50, i*50);
                tablero[i][j].setIcon(imagen);
                panel.add(tablero[i][j]);
            }
            
        }
        return tablero;
    }
    
    public ImageIcon seleccionarIcono(int laberinto){
        ImageIcon imagen;
        switch (laberinto){
            case 0:
                imagen = new ImageIcon("images/casillaLibre.png");
                break;
            case 1:
                imagen = new ImageIcon("images/muro.png");
                break;
            case 2:
                imagen = new ImageIcon("images/agente.png");
                break;
            case 3:
                imagen = new ImageIcon("images/nave1.png");
                break;
            case 4:
                imagen = new ImageIcon("images/nave2.png");
                break;
            case 5:
                imagen = new ImageIcon("images/item1.png");
                break;
            case 6:
                imagen = new ImageIcon("images/aceite.png"); 
                break;
            default:
                imagen = new ImageIcon("images/casillaLibre.png");
        }
        return imagen;
    }
}
