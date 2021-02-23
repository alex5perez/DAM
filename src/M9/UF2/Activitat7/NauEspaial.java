/*
A partir del codi que es subministra:
1) Si es pitja la tecla d’espai la nostra nau ha de disparar
2) Per a cada dispar s’ha de crear un fil que gestionarà un raig làser.
3) El raig làser ha de partir de la nostra nau i anar cap amunt amb certa velocitat
4) Si el raig làser és prop d’alguna nau que no sigui la nostra, l’ha de destruir
5) El joc ha d’acabar si destruïm totes les naus (inicialment, enlloc de 3 que n’hi hagi 10)

 */
package M9.UF2.Activitat7;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
/*
* File: NauEspaial.java 
* Author: Alex Pérez Rubio
* Date: 23-02-2021
* Description: Activitat 7 PRACTICA UF2 M9
*/
public class NauEspaial extends javax.swing.JFrame {    
    
    public NauEspaial() {
        initComponents();
        }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGap(0, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGap(0, 300, Short.MAX_VALUE));
        pack();
        }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                    }
                }
            }
        catch (Exception ex) {
            java.util.logging.Logger.getLogger(NauEspaial.class.getName()).log(
                java.util.logging.Level.SEVERE, null, ex);
            }       
        NauEspaial f = new NauEspaial();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setTitle("Naus Espaials");
        f.setContentPane(new PanelNau());
        f.setSize(880, 860);
        f.setVisible(true);
        }
    }


class PanelNau extends JPanel implements Runnable, KeyListener{
    //10 Naus
    private int numNaus=10;    
    Nau[] nau;
    Nau nauPropia;
    Shot[] shots = new Shot[5];
    Shot shot;
    private static int contador = 0;
    
    public PanelNau(){        
        nau = new Nau[numNaus];
        for (int i=0;i<nau.length;i++) {
            Random rand = new Random();
            int velocitat=(rand.nextInt(3)+5)*10;
            int posX=rand.nextInt(100)+30;
            int posY=rand.nextInt(100)+30;
            int dX=rand.nextInt(3)+1;
            int dY=rand.nextInt(3)+1;
            String nomNau = Integer.toString(i);
            nau[i]= new Nau(nomNau,posX,posY,dX,dY,velocitat);
            }
        
        nauPropia = new Nau("NauNostre", 350, 650, 0, 0, 100);
        
        Thread n = new Thread(this);
        n.start();   
        
        addKeyListener(this);
        setFocusable(true);
        }

    public void run() {
        System.out.println("Inici fil repintar");
        while(true) {
            try { Thread.sleep(100);} catch(Exception e) {} // espero 0,1 segons
            System.out.println("Repintant");
            repaint();            
            }                   
        }

    public synchronized void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i=0; i<nau.length;++i) nau[i].pinta(g);
        nauPropia.pinta2(g);
        }
    
    public static void setContador(int c) {
        contador = c;
    }
    
    public synchronized void novabala() {
        if (contador < 5) {
            if (shots[contador] == null) {
                shots[contador] = new Shot(nauPropia.getX() + 22, nauPropia.getY() - 27, nauPropia.velocitat());
            }
        }
        
        contador++;
    }
    

    @Override
    public void keyTyped(KeyEvent e) {
    
    }
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("Key pressed code=" + e.getKeyCode() + ", char=" + e.getKeyChar());
        if (e.getKeyCode() == 37) {
            nauPropia.esquerra();
        }//System.out.println("a la esquerra");
        if (e.getKeyCode() == 39) {
            nauPropia.dreta();
        }//System.out.println("a la dreta");
        if (e.getKeyCode() == 32) {
            novabala();
        }
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 37) {
            nauPropia.parar();
        }
        if (e.getKeyCode() == 39) {
            nauPropia.parar();
        }
    }
    
}

class Shot extends Thread {
    ThreadGroup shots = new ThreadGroup("");
    private int x,y;
    private int v;
    private int i = 0;
    private Image image;
    
    public Shot(int x, int y, int v) {
        this.x=x;
        this.y=y;
        this.v=v;
        
        image = new ImageIcon(Nau.class.getResource("bala.png")).getImage();
        
        Thread t = new Thread(this);
        t.start();
    }
    
    public void run() {
        while (true) {
            //System.out.println("Movent nau numero " + this.nomNau);
            try { Thread.sleep(this.v); } catch (Exception e) {}
            moure();
            }
    }
    
    
    public synchronized void pintaShot(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(this.image, this.x, this.y, null);
    }

    private void moure() {
        int dsy = 30;
        y = y - dsy;
        if (y <= 0) {
            if (i < 1) {
                PanelNau.setContador(0);
                i++;
            }
        }
    }
}

class Nau extends Thread {
    private String nomNau;
    private int x,y;
    private int dsx,dsy,v;
    private int tx = 10;
    private int ty = 10;
    
    

    private Image image;
    private Image image2;
    

    public Nau(String nomNau, int x, int y, int dsx, int dsy, int v ) {
        this.nomNau = nomNau;
        this.x=x;
        this.y=y;
        this.dsx=dsx;
        this.dsy=dsy;
        this.v=v;
        
            image = new ImageIcon(Nau.class.getResource("nauenemiga.png")).getImage();
            image2 = new ImageIcon(Nau.class.getResource("nau.png")).getImage();
        
        Thread t = new Thread(this);
        t.start();
        }
    
    public int velocitat (){
        return v;
        }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public synchronized void moure (){
        x=x + dsx;
        y=y + dsy;
        // si arriva als marges ...
        if ( x>= 700 - tx || x<= tx) dsx = - dsx;
        if ( y >= 700 - ty || y<=ty ) dsy = - dsy;
        }
    
    public synchronized void pinta (Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(this.image, x, y, null);
        }
    
    public synchronized void pinta2 (Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(this.image2, x, y, null);
        }
    

    public void run() {
        while (true) {
            System.out.println("Movent nau numero " + this.nomNau);
            try { Thread.sleep(this.v); } catch (Exception e) {}
            moure();
            }
        }
    //Moure nau esquerra y dreta
    public void esquerra(){
        this.dsx = -10;
    }
    
    public void dreta(){
        this.dsx = 10;
    }
    
    public void parar(){
        this.dsx = 0;
    }
    }
