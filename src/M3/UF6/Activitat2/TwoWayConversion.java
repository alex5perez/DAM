/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M3.UF6.Activitat2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author alexp
 */
public class TwoWayConversion extends JFrame implements ActionListener {
    JLabel l;
    JTextField f, c;
    JButton bFc;
    JButton bCf;
    JButton bBorrar;
    
    public static void main(String[] args) {
        M3.UF6.Activitat2.TwoWayConversion a2 = new M3.UF6.Activitat2.TwoWayConversion();
        
        a2.setSize(500,500);
        a2.setVisible(true);
    }
    
    public TwoWayConversion() {
        l = new JLabel("Conversor");
        f = new JTextField(10);
        c = new JTextField(10);
        bFc = new JButton("Passar de F a C");
        bCf = new JButton("Passar de C a F");
        bBorrar = new JButton("Borrar");
        
        setLayout(new FlowLayout());
        
        bFc.addActionListener(this);
        bCf.addActionListener(this);
        bBorrar.addActionListener(this);
        
        add(l);
        add(f);
        add(c);
        add(bCf);
        add(bFc);
        add(bBorrar);
        
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("Passar de F a C")) {
            int far = Integer.parseInt(f.getText());
            int cel = (far - 32) * 5 / 9;
            c.setText(String.valueOf(cel));
        }
        if(e.getActionCommand().equals("Passar de C a F")) {
            int cel = Integer.parseInt(c.getText());
            int far = (cel * 9) / 5 + 32;
            f.setText(String.valueOf(far));
        }
        if(e.getActionCommand().equals("Borrar")) {
            f.setText("");
            c.setText("");
        }
    }
    
}
