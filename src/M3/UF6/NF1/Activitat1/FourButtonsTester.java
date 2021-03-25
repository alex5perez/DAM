/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M3.UF6.Activitat1;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author alexp
 */
class FourButtons extends JFrame {
    JPanel panel;
    JButton vermell, verd, blau, gris;
    
    FourButtons( String four_buttons ) {
                super ( four_buttons );
                
                setLayout( new FlowLayout() );
                
                JButton vermell = new JButton("Vermell");
                JButton verd = new JButton("Verd");
                JButton blau = new JButton("Blau");
                JButton gris = new JButton("Gris");
                setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                vermell.setBackground(Color.red);
                add(vermell);
                verd.setBackground(Color.green);
                add(verd);
                blau.setBackground(Color.blue);
                add(blau);
                gris.setBackground(Color.gray);
                add(gris);
    }
    
     
        public void actionPerformed( ActionEvent evt) {
        getContentPane().setBackground(Color.red);
                repaint();

        }

    
    



    public class FourButtonsTester {
    //public static void main(String[] args) {
    FourButtons frm = new FourButtons ("Four buttons");
    //frm.setSize(500, 500);
    //frm.setVisible(true);
    }
    }
//}

