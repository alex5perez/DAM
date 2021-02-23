/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M3.UF6.Exemple;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author alexp
 */
public class ButtonQuitter extends JFrame implements ActionListener {
    JButton bQuit = new JButton("Click here to Exit");
    
    public ButtonQuitter(String title) {
        super(title);
        setLayout( new FlowLayout());
        bQuit.addActionListener(this);
        add(bQuit);
    }
    
    public void actionPerformed(ActionEvent evt) {
        System.exit(0);
    }
    public static void main ( String[] args) {
        ButtonQuitter frame = new ButtonQuitter("Button Quitter");
        
        frame.setSize(500,500);
        frame.setVisible(true);
    }
}
