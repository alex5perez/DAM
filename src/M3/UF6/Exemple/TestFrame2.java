/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M3.UF6.Exemple;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author alexp
 */


        class MyFrame extends JFrame {
        JPanel panel;
        Button label, labe2, labe3, labe4, labe5;

        
            MyFrame( String title ) {
                super ( title );
                setSize( 350, 300);
                setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                
                setLayout( new BorderLayout(2,9) );
                label = new Button("NORTH!");
                        add(label, BorderLayout.NORTH);
                labe2 = new Button("SOUTH!");
                        add(labe2, BorderLayout.SOUTH);
                labe3 = new Button("CENTER!");
                        add(labe3, BorderLayout.CENTER);
                labe4 = new Button("EAST!");
                        add(labe4, BorderLayout.EAST);
                labe5 = new Button("WEST!");
                        add(labe5, BorderLayout.WEST);
                //labe5.getVerticalAlignment();
                
                
            }
        }

    public class TestFrame2 {
        public static void main ( String[] args ) {
            MyFrame frame = new MyFrame("Hello");
            frame.setVisible(true);
    
   } 
    
}
