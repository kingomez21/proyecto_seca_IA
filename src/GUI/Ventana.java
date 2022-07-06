/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import laberintoia.LaberintoIA;

public class Ventana extends javax.swing.JFrame {

    LaberintoIA game;
    GestionArchivo gs = new GestionArchivo();
    public Tablero tb = new Tablero();
    Casilla casilla = new Casilla();
    Timer reloj;
    int[][] laberinto;
    int j = 0;
    ArrayList<int[][]> movAmp;

    public Ventana() {
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        laberinto = gs.abrirArchivo();
        tb.dibujarTablero(laberinto, PanelTablero);
        game = new LaberintoIA();
        movAmp = new ArrayList<>();
        recorridoAmplitud();
        Timer reloj = new Timer(1000, tiempo);
        reloj.start();
        //reloj.setDelay(800);
    }

    public void recorridoAmplitudV(int matris[][], int fl, int col, int contador, int pos) {

        //long x = 100;
        //int cc = 0;
        int fila = 0, colum = 0;

        if (contador < game.listaMovimientosAmplitud.size()) {
            pos--;

            if (contador == 0) {
                fila = fl;
                colum = col;
            } else {
                fila = game.matriz.EncontrarJugador(matris)[0];
                colum = game.matriz.EncontrarJugador(matris)[1];
            }

            int[][] estadoMov = game.bsq.moverJugador(game.listaMovimientosAmplitud.get(pos).getOperador(), fila, colum);
            //Thread.sleep(x);
            //reloj.setDelay(100);
            //tb.dibujarTablero(estadoMov, PanelTablero);
            //game.matriz.mostrarMundo(estadoMov);
            movAmp.add(contador, estadoMov);
            //System.out.println("tamaño"+movAmp.size());
            //game.matriz.mostrarMundo(movAmp.get(0));
            System.out.println();
            contador++;

            recorridoAmplitudV(estadoMov, fila, colum, contador, pos);
        }

    }

    public void recorridoAmplitud() {
        // Secuencia para resolver la busqueda por amplitud
        //int[][] m = game.matriz.getMatriz();
        int fila = game.matriz.EncontrarJugador(laberinto)[0];
        int colum = game.matriz.EncontrarJugador(laberinto)[1];
        game.AgenteAmplitud(laberinto);
        game.matriz.CargarMundo();
        int[][] m2 = game.matriz.getMatriz();
        recorridoAmplitudV(m2, fila, colum, 0, game.listaMovimientosAmplitud.size());

        long tiempoFinalAmplitud = System.currentTimeMillis();
        tiempoFinalAmplitud = (tiempoFinalAmplitud - game.bsq.getTiempoInicial());
        System.err.println("Nodos expandidos: " + game.bsq.getNodosExpandidos().size()
                + " Profundidad: " + game.listaMovimientosAmplitud.get(0).getProfundidad()
                + " Tiempo: " + tiempoFinalAmplitud + " Milisegundos");
        game.eliminarRecorrido();

    }
    
    ActionListener tiempo = new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent ae) {

                tb.dibujarTablero(movAmp.get(j), PanelTablero);
                j++;
                if (j >= movAmp.size()) {
                    reloj.stop();
                }
            }
        };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        tipoBusqueda = new javax.swing.JComboBox<>();
        PanelTablero = new javax.swing.JPanel();
        etiqueta1 = new javax.swing.JLabel();
        tipoBusqueda1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Búsqueda por amplitud", "Buúsqueda por profundidad" }));

        PanelTablero.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout PanelTableroLayout = new javax.swing.GroupLayout(PanelTablero);
        PanelTablero.setLayout(PanelTableroLayout);
        PanelTableroLayout.setHorizontalGroup(
            PanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTableroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiqueta1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(502, Short.MAX_VALUE))
        );
        PanelTableroLayout.setVerticalGroup(
            PanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTableroLayout.createSequentialGroup()
                .addComponent(etiqueta1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tipoBusqueda1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Búsqueda informada", "Busqueda NO informada" }));

        jButton1.setText("Iniciar búsqueda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(12, 12, 12)
                        .addComponent(PanelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tipoBusqueda1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tipoBusqueda1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(0, 392, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*
        Ventana g = new Ventana(tiempo);
        g.recorridoAmplitud();
        
        //ActionListener tiempo;
        
        
        
        reloj = new Timer(1000, tiempo);
        reloj.start();*/
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelTablero;
    private javax.swing.JLabel etiqueta1;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> tipoBusqueda;
    private javax.swing.JComboBox<String> tipoBusqueda1;
    // End of variables declaration//GEN-END:variables
}
