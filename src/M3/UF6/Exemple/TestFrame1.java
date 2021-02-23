/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M3.UF6.Exemple;

import javax.swing.JFrame;

/**
 *
 * @author alexp
 */
public class TestFrame1 {
    public static void main ( String[] args ) {
        JFrame frame = new JFrame("Test Frame 1");
        //x y posicio, width i height tamany
        frame.setBounds(700,300,500,500);
        frame.setVisible( true );
        frame.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );
        
    }
    public void setBounds(int x, int y, int width, int height) {
        

    }
    
}
