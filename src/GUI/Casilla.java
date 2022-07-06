/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.*;

/**
 *
 * @author EDWIN
 */
public class Casilla extends JFrame{
    int alto;
    int ancho;
    boolean editable;
    JLabel casilla;  
    
    public Casilla() {
        super();
        alto = 50;
        ancho = 50;
        casilla = new JLabel(); // se crea una nueva etiqueta.
        casilla.setBounds(new Rectangle(ancho, alto)); // se dibuja como un rectangulo.
        casilla.setOpaque(true);
    }
    
    /*
    *@retorna una casilla libre.
    */
    public JLabel casillaLibre(){
        ImageIcon imagen =  new ImageIcon("images/casillaLibre.png");
        casilla.setIcon(imagen);
        return casilla; 
    }
    
    /*
    *retorna una casilla muro.
    */
    public JLabel casillaMuro(){
        ImageIcon imagen =  new ImageIcon("images/muro.png");
        casilla.setIcon(imagen);
        return casilla; 
    }
    
    /*
    *retorna una casilla aceite.
    */
    public JLabel casillaAceite(){
        ImageIcon imagen =  new ImageIcon("images/aceite.png");
        casilla.setIcon(imagen);
        return casilla; 
    }
    
    /*
    *retorna el agente.
    */
    public JLabel casillaAgente(){
        ImageIcon imagen =  new ImageIcon("images/agente.png");
        casilla.setIcon(imagen);
        return casilla; 
    }
    /*
    *retorna la nave 1.
    */
    public JLabel casillaNave1(){
        ImageIcon imagen =  new ImageIcon("images/nave1.png");
        casilla.setIcon(imagen);
        return casilla; 
    }
    
    /*
    *retorna la nave 2.
    */
    public JLabel casillaNave2(){
        ImageIcon imagen =  new ImageIcon("images/nave2.png");
        casilla.setIcon(imagen);
        return casilla; 
    }
    
    /*
    *retorna el item 1.
    */
    public JLabel casillaItem1(){
        ImageIcon imagen =  new ImageIcon("images/item1.png");
        casilla.setIcon(imagen);
        return casilla; 
    }
    
    /*
    *retorna el item 2.
    */
    public JLabel casillaItem2(){
        ImageIcon imagen =  new ImageIcon("images/item2.png");
        casilla.setIcon(imagen);
        return casilla; 
    }
}
