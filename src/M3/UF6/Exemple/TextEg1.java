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
import javax.swing.JTextField;

/**
 *
 * @author alexp
 */
public class TextEg1 extends JFrame implements ActionListener{
    
    JTextField InText, textOut;
    
    
    public TextEg1 (String title) {
        super(title);
        InText = new JTextField(15);
        textOut = new JTextField(15);
        JButton bpitja = new JButton("Pitja");
        setLayout(new FlowLayout());
        bpitja.addActionListener(this);
        add(InText);
        add(textOut);
        add(bpitja);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void actionPerformed( ActionEvent evt) {
        String name = InText.getText();
        textOut.setText( name );
        repaint();
    }
    
    public static void main (String[] args) {
        TextEg1 teg = new TextEg1("TextField");
        teg.setSize(500,500);
        teg.setVisible(true);
    }
}
