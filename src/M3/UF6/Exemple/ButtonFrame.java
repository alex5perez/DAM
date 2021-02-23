/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M3.UF6.Exemple;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author alexp
 */

    class ButtonFrame2 extends JFrame implements ActionListener {
        JButton bChange, bChange2;
        
        public ButtonFrame2() {
            setSize( 500, 500);
            bChange = new JButton("Click Me!");
            bChange2 = new JButton("Clicame!");
            setLayout( new FlowLayout() );
            
            bChange.addActionListener( this );
            bChange2.addActionListener( this );
            
            add( bChange );
            add( bChange2 );
            setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        }

        
        @Override
        public void actionPerformed( ActionEvent evt) {
            System.out.println("Alex");
            getContentPane().setBackground(Color.blue);
            repaint();
            System.out.println("Hola");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ButtonFrame2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

public class ButtonFrame {
        public static void main ( String[] args ) {
            ButtonFrame2 frame = new ButtonFrame2();
            frame.setVisible(true);
            
    
   } 
    
}

