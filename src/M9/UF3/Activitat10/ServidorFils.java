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
    Socket[] clientConnectat;
    static int clients;
    Socket client;

    public ServidorFils(ServerSocket servidor, Socket[] clientConnectat, Socket sortidaClient) {
        this.Servidor = servidor;
        this.clientConnectat = clientConnectat;
        this.clients ++;
        this.client = sortidaClient;
    }

        public void run(){
            boolean stop = false;
            while(!stop) {
                
                                PrintWriter fsortida = null;
                                BufferedReader fentrada = null;

                                System.out.println("Client " + this.clients + " connectat... ");
                                
                                try {
                                    
                                    //FLUX DE SORTIDA AL CLIENT
                                    fsortida = new PrintWriter(this.client.getOutputStream(), true);


                                    //FLUX D'ENTRADA DEL CLIENT
                                    fentrada = new BufferedReader(new InputStreamReader(this.client.getInputStream()));

                                    //Missatge quan el client conecta amb el servidor
                                    fsortida.println("Connexió amb client: " + clients);
                                    if ((cadena = fentrada.readLine()) != null) {
                                            
                                            System.out.println("Nom Client " + this.clients + ": " + cadena);
                                            
                                            if (cadena.equals("*")) break;
                                    }
                                }catch (SocketException e){
                                    stop = true;
                                } catch (IOException ex) { 
                    Logger.getLogger(ServidorFils.class.getName()).log(Level.SEVERE, null, ex);
                }
                                
                                while (!stop) {
                                    try {
                                        cadena = fentrada.readLine();
                                        
                                    }catch (SocketException e) {
                                        stop = true;
                                    if (cadena == null || cadena.equals("")) {
                                        stop = true;
                                    }
                                    
                                    if(!stop) {
                                        fsortida.println(cadena);
                                        
                                        if (cadena != null) {
                                            for (int i=0; i<1; i++) {
                                                if(clientConnectat[i] != null)  {
                                                    
                                                }

                                            }
                                            System.out.println("Rebent: "+cadena);
                                                
                                        }
                                    }
 
                                    } catch (IOException ex) {
                                        Logger.getLogger(ServidorFils.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                    
                            try {
                                //TANCAR STREAMS I SOCKETS
                                System.out.println("Tancant connexió... ");
                                fentrada.close();
                                fsortida.close();
                                client.close();
                            }catch (SocketException e){
                                System.out.println("Error");
                            }catch (IOException s) {
                                s.printStackTrace();
                            }
            }               
        }   
}