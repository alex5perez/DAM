/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M9.UF3.Activitat10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexp
 */
public class ServidorFils implements Runnable {
    ServerSocket Servidor;
    String cadena = "";
    Socket clientConnectat;
    static int clients;

    public ServidorFils(ServerSocket servidor, Socket clientConnectat) {
        this.Servidor = servidor;
        this.clientConnectat = clientConnectat;
        this.clients ++;
    }
    
        public void run(){
            boolean stop = false;
            while(!stop) {
                
                                PrintWriter fsortida = null;
                                BufferedReader fentrada = null;

                                System.out.println("Client " + this.clients + " connectat... ");
                                
                                try {
                                    
                                    //FLUX DE SORTIDA AL CLIENT
                                    fsortida = new PrintWriter(clientConnectat.getOutputStream(), true);


                                    //FLUX D'ENTRADA DEL CLIENT
                                    fentrada = new BufferedReader(new InputStreamReader(clientConnectat.getInputStream()));

                                    //Missatge quan el client conecta amb el servidor
                                    fsortida.println("Connexió amb client: " + clients);
                                    if ((cadena = fentrada.readLine()) != null) {
                                            
                                            System.out.println("Nom Client " + this.clients + ": " + cadena);
                                            System.out.println("Rebent: "+cadena);
                                            if (cadena.equals("*")) break;
                                    }
                                }catch (SocketException e){
                                    stop = true;
                                } catch (IOException ex) {
                                Logger.getLogger(ServidorFils.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                    
                            try {
                                //TANCAR STREAMS I SOCKETS
                                System.out.println("Tancant connexió... ");
                                fentrada.close();
                                fsortida.close();
                                clientConnectat.close();
                            }catch (SocketException e){
                                System.out.println("Error");
                            }catch (IOException s) {
                                s.printStackTrace();
                            }
            }               
        }   
}