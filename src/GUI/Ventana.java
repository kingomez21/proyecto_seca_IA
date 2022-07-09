/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
//import javax.swing.Timer;
import laberintoia.LaberintoIA;

public class Ventana extends javax.swing.JFrame {

    LaberintoIA game;
    GestionArchivo gs = new GestionArchivo();
    Tablero tb = new Tablero();
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
        
        reloj = new Timer();
        
        
    }

    public void recorridoAmplitudV(int matris[][], int fl, int col, int contador, int pos) {

        
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
            
            System.out.println();
            System.out.println("---------------");
            System.out.println("Movimientos");
            System.out.println();
            game.matriz.mostrarMundo(estadoMov);
            contador++;

            recorridoAmplitudV(estadoMov, fila, colum, contador, pos);
        }

    }

    public void recorridoCostoUniformeV(int matris[][], int fl, int col, int contador, int pos){
        int fila = 0, colum = 0;

        if (contador < game.listaMovimientosCostoUniforme.size()) {
            pos--;
            
            if (contador == 0) {
                fila = fl;
                colum = col;
            } else {
                fila = game.matriz.EncontrarJugador(matris)[0];
                colum = game.matriz.EncontrarJugador(matris)[1];
            }
            int[][] estadoMov = game.bsqC.moverJugador(game.listaMovimientosCostoUniforme.get(pos).getOperador(), fila, colum);
            System.out.println();
            System.out.println("---------------");
            System.out.println("Movimientos");
            System.out.println();
            game.matriz.mostrarMundo(estadoMov);
            contador++;
            
            recorridoCostoUniformeV(estadoMov, fila, colum, contador, pos);
        }
    }
    
    public void recorridoAmplitud(int op) {
        // Secuencia para resolver la busqueda por amplitud
        game.matriz.CargarMundo();
        int[][] m = game.matriz.getMatriz();
        int fila = game.matriz.EncontrarJugador(m)[0];
        int colum = game.matriz.EncontrarJugador(m)[1];
        game.AgenteAmplitud(m, op);
        
        game.matriz.CargarMundo();
        int[][] m2 = game.matriz.getMatriz();
        System.out.println();
        recorridoAmplitudV(m2, fila, colum, 0, game.listaMovimientosAmplitud.size());
        
        
        game.matriz.CargarMundo();
    }

    public void recorridoCosto(int op){
        game.matriz.CargarMundo();
        int[][] m = game.matriz.getMatriz();
        int fila = game.matriz.EncontrarJugador(m)[0];
        int colum = game.matriz.EncontrarJugador(m)[1];
        game.AgenteCostoUniforme(m, op);
        game.matriz.CargarMundo();
        int[][] m2 = game.matriz.getMatriz();
        System.out.println();
        recorridoCostoUniformeV(m2, fila, colum, 0, game.listaMovimientosCostoUniforme.size());
        game.matriz.CargarMundo();
    }
    
    public void recorridoProfundidadV(int matris[][], int fl, int col, int contador, int pos) {

        
        int fila = 0, colum = 0;

        if (contador < game.listaMovimientosProfundidad.size()) {
            pos--;
            
            if (contador == 0) {
                fila = fl;
                colum = col;
            } else {
                fila = game.matriz.EncontrarJugador(matris)[0];
                colum = game.matriz.EncontrarJugador(matris)[1];
            }
            
            int[][] estadoMov = game.bsqP.moverJugador(game.listaMovimientosProfundidad.get(pos).getOperador(), fila, colum);
            System.out.println();
            System.out.println("---------------");
            System.out.println("Movimientos");
            System.out.println();
            game.matriz.mostrarMundo(estadoMov);
            contador++;
            
            recorridoProfundidadV(estadoMov, fila, colum, contador, pos);
           
        }
        
        

    }
    public void recorridoProfundidad (int op){
        game.matriz.CargarMundo();
        int[][] m = game.matriz.getMatriz();
        int fila = game.matriz.EncontrarJugador(m)[0];
        int colum = game.matriz.EncontrarJugador(m)[1];
        game.AgenteProfundidad(m, op);
        game.matriz.CargarMundo();
        int[][] m2 = game.matriz.getMatriz();
        System.out.println();
        recorridoProfundidadV(m2, fila, colum, 0, game.listaMovimientosProfundidad.size());
        game.matriz.CargarMundo();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        PanelTablero = new javax.swing.JPanel();
        etiqueta1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PanelTablero.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout PanelTableroLayout = new javax.swing.GroupLayout(PanelTablero);
        PanelTablero.setLayout(PanelTableroLayout);
        PanelTableroLayout.setHorizontalGroup(
            PanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTableroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiqueta1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(478, Short.MAX_VALUE))
        );
        PanelTableroLayout.setVerticalGroup(
            PanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTableroLayout.createSequentialGroup()
                .addComponent(etiqueta1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 456, Short.MAX_VALUE))
        );

        jButton2.setText("Buqueda por amplitud");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("BUSQUEDA NO INFORMADA");

        jButton3.setText("Busqueda por costo uniforme");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Busqueda por profundidad");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(PanelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        System.out.println();
        System.err.println("RECORRIDO #1 - AMPLITUD");
        recorridoAmplitud(0);
        long tiempoFinalAmplitud = System.currentTimeMillis();
        tiempoFinalAmplitud = (tiempoFinalAmplitud - game.bsq.getTiempoInicial());
        JOptionPane.showMessageDialog(null, "Nodos expandidos: " + game.bsq.getNodosExpandidos().size()
                + " Profundidad: " + game.listaMovimientosAmplitud.get(0).getProfundidad()
                + " Tiempo: " + tiempoFinalAmplitud + " Milisegundos");
        game.eliminarRecorrido();
        System.out.println();
        System.err.println("RECORRIDO #2 - AMPLITUD");
        recorridoAmplitud(1);
        game.eliminarRecorrido();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        System.out.println();
        System.err.println("RECORRIDO #1 - COSTO");
        recorridoCosto(0);
        long tiempoFinalCosto = System.currentTimeMillis();
        tiempoFinalCosto = (tiempoFinalCosto - game.bsqC.getTiempoInicial());
        JOptionPane.showMessageDialog(null, "Nodos expandidos: " + game.bsqC.getNodosExpandidos().size()
                + " Profundidad: " + game.listaMovimientosCostoUniforme.get(0).getProfundidad()
                + " Tiempo: " + tiempoFinalCosto + " Milisegundos");
        game.eliminarRecorridoCosto();
        System.out.println();
        System.err.println("RECORRIDO #2 - COSTO");
        recorridoCosto(1);
        game.eliminarRecorridoCosto();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        System.out.println();
        System.err.println("RECORRIDO #1 - PROFUNDIDAD");
        recorridoProfundidad(0);
        long tiempoFinalProfundidad = System.currentTimeMillis();
        tiempoFinalProfundidad = (tiempoFinalProfundidad - game.bsqP.getTiempoInicial());
        JOptionPane.showMessageDialog(null, "Nodos expandidos: " + game.bsqP.getNodosExpandidos().size()
                + " Profundidad: " + game.listaMovimientosProfundidad.get(0).getProfundidad()
                + " Tiempo: " + tiempoFinalProfundidad + " Milisegundos");
        game.eliminarRecorridoProfundidad();
        System.out.println();
        System.err.println("RECORRIDO #2 - PROFUNDIDAD");
        recorridoProfundidad(1);
        game.eliminarRecorridoProfundidad();
    }//GEN-LAST:event_jButton4ActionPerformed

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

        /* Create and display the. form */
        
        
 
        Ventana g = new Ventana();
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelTablero;
    private javax.swing.JLabel etiqueta1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
