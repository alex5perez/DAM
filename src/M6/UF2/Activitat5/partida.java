/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M6.UF2.Activitat5;

import java.util.Date;
import javax.swing.JOptionPane;

/*
* File: Exercici5UF2M6.java 
* Author: Alex Pérez Rubio
* Date: 21-01-2021
* Description: Activitat 5 PRACTICA UF2 M6
*/
public class partida extends javax.swing.JFrame {
    
    private static String[] posicionesTablero = new String[64];
    private static String stringx = "";
    private boolean nuevo;
    
    /**
     * Creates new form partida
     */
    public partida(boolean nuevo) {
        initComponents();
        Date fecha = new Date();
        
        this.nuevo = nuevo;
        
        if (nuevo) {
            for (int i = 0; i <= 7; i++) {
                for (int j = 0; j <= 7; j++) {
                    if (jTable1.getModel().getValueAt(i, j).toString().equals("")) {
                        stringx += " ";
                    }else {
                        stringx += jTable1.getModel().getValueAt(i, j).toString();
                    }
                }
            }
            
            
        }
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"X", null, "X", null, "X", null, "X", null},
                {null, "X", null, "X", null, "X", null, "X"},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, "", null, null, null, null, null, null},
                {null, "O", null, "O", "", "O", null, "O"},
                {"O", null, "O", null, "O", null, "O", null}
            },
            new String [] {
                "Col", "Col", "Col", "Col", "Col", "Col", "Col", "Col"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jButton1.setText("Sortir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int fila;
        int columna;
        int numO = 0;
        int numX = 0;
        
        fila = obtenirFilaClicada();
        columna = obtenirColumnaClicada();
        
        if (noHiHaOrigen()) {
            if (jugaX && EsX(fila, columna)) {
                ActualitzaNouOrigen(fila, columna);
            } else if (jugaO && EsO(fila, columna)) {
                ActualitzaNouOrigen(fila, columna);
            } else {
                mostraError();
            } 
        } else if (movimentValid(fila, columna)) {
            if (esBuit(fila, columna) || ocupatContrari(fila, columna)) {
                mou(fila, columna);
                guanyador(fila, columna);
            }
        }else if (ocupatPropi(fila, columna)) {
                ActualitzaNouOrigen(fila, columna);
        }else{
            mostrarErrorMoviment();
        }
        
        
        
        
    }//GEN-LAST:event_jTable1MouseClicked
    
    /**
     * @param args the command line arguments
     */
    private boolean jugaX = true;
    private boolean jugaO = false;
    private int filaOrigen = -1;
    private int columnaOrigen = -1;
    
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
            java.util.logging.Logger.getLogger(partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(partida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new partida(true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private int obtenirFilaClicada() {
        return jTable1.getSelectedRow();
    }
    
    private int obtenirColumnaClicada() {
        return jTable1.getSelectedColumn();
    }
    
    private boolean noHiHaOrigen() {
        boolean noOrigen = false;
        if(filaOrigen == -1 || columnaOrigen == -1) {
            noOrigen = true;
        }
        
        return noOrigen;
    }
    
    private boolean EsX(int fila, int columna) {
        boolean isx = false;
        if (jTable1.getValueAt(fila, columna) == "X"); {
        isx = true;
        
    }
        return isx;
    }
    
    private boolean EsO(int fila, int columna) {
        boolean iso = false;
        if (jTable1.getValueAt(fila, columna) == "O"); {
        iso = true;
        
    }
        return iso;
    }
    
    private void ActualitzaNouOrigen(int fila, int columna) {
        this.filaOrigen = fila;
        this.columnaOrigen = columna;
    }
    
    private void mostraError() {
        jLabel1.setText("Tria una fitxa teva");
    }
    
    private boolean movimentValid(int fila, int columna) {
        boolean movimentValid = false;
        int movimentcolumna = columna - columnaOrigen;
        int movimentfila = fila - filaOrigen;
        
        if (jugaO && (movimentfila == -1) && ((movimentcolumna == 1) || (movimentcolumna == -1))){
        movimentValid = true;
        }else if (jugaX && (movimentfila == 1) && ((movimentcolumna == 1 || (movimentcolumna == -1 )))) {
        movimentValid = true;
        }
        return movimentValid;
        
    }
    
    private boolean esBuit(int fila, int columna) {
        boolean esBuit = false;
        if(jTable1.getValueAt(fila, columna) == null) {
            esBuit = true;
        }
        return esBuit;
    }
    
    private boolean ocupatContrari(int fila, int columna) {
         boolean isOcupatContrari = false;
        if ((jugaX == true && EsO(fila, columna) == true) || (jugaO == true && EsX(fila, columna) == true)) {
            isOcupatContrari = true;
        }
        
        return isOcupatContrari;
    }
    
    private void mou(int fila, int columna) {
        int conta = 0;
        if (jugaO) {
            jTable1.setValueAt("O", fila, columna);
            jTable1.setValueAt(null, filaOrigen, columnaOrigen);
            columnaOrigen = -1;
            filaOrigen = -1;
            if(conta==0){
                conta = 1;
                jugaO = false;
                jugaX = true;
            }
            
        }else{
            jTable1.setValueAt("X", fila, columna);
            jTable1.setValueAt(null, filaOrigen, columnaOrigen);
            columnaOrigen = -1;
            filaOrigen = -1;
            if(conta==0){
                conta = 1;
                jugaO = true;
                jugaX = false;
        }
            conta = 0;
        }
    }
    
    private boolean ocupatPropi(int fila, int columna) {
        boolean isOcupatPropi = false;
        if ((jugaX == true && EsX(fila, columna) == true) || (jugaO == true && EsO(fila, columna) == true)) {
            isOcupatPropi = true;
        }
        
        return isOcupatPropi;
    }
    
    private void mostrarErrorMoviment() {
        jLabel1.setText("Moviment erroni");
    }
    
    public void recuperarPartida(){
        
    }
    
    private void guanyador(int fila, int columna) {
        if(EsO(fila, columna) && fila == 0) {
            JOptionPane.showMessageDialog(null, "O guanya", "Partida Finalitzada", JOptionPane.PLAIN_MESSAGE);
        }else if(EsX(fila, columna) && fila == 7) {
            JOptionPane.showMessageDialog(null, "X guanya", "Partida Finalitzada", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
