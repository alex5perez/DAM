/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M3.UF6.Exemple;

import java.awt.FlowLayout;
import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author alexp
 */
public class TwoTestFrames {
    public static void main ( String[] args ) {
        int height=100, width=200;
        JFrame master = new JFrame("Click to Close Everything");
        JFrame temp = new JFrame("Click to Close Just This");
        
        master.setVisible( true );
        master.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        master.setSize(400, 300);
        
        temp.setVisible( true );
        temp.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        temp.setSize( 300, 200);
        
        
        
    }
}


