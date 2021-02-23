/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M3.UF6.Exemple;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author alexp
 */
public class TextEg2 extends JFrame {
    
    JTextField text;
    JLabel lbl;
    
    
    public TextEg2 (String title) {
        super(title);
        text = new JTextField(15);
        lbl = new JLabel ("Enter Your Name:");
        setLayout(new FlowLayout());
        add(lbl);
        add(text);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    //public Repeater (String title) {
        //super(title);
        //setLayout(new FlowLayout() );
        
    //}
    

    
    public static void main (String[] args) {
        TextEg2 teg = new TextEg2 ("Label and TextField");
        teg.setSize(500,500);
        teg.setVisible(true);
    }
}