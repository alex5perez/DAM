/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M9.UF3.Activitat9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author alexp
 */
public class ServidorFils implements Runnable {
    ServerSocket Servidor;
    String cadena = "";
    Socket clientConnectat;
    static int clients = 0;
    public void run(){
        try {
                            clients++;
                            
                            System.out.println("Client " + clients + " connectat... ");

                            //FLUX DE SORTIDA AL CLIENT
                            PrintWriter fsortida = new PrintWriter(clientConnectat.getOutputStream(), true);


                            //FLUX D'ENTRADA DEL CLIENT
                            BufferedReader fentrada = new BufferedReader(new InputStreamReader(clientConnectat.getInputStream()));
                            
                            //Missatge quan el client conecta amb el servidor
                            fsortida.println("Connexió amb client: " + clients);
                            while ((cadena = fentrada.readLine()) != null) {

                                    fsortida.println(cadena);
                                    System.out.println("Rebent: "+cadena);
                                    if (cadena.equals("*")) break;

                            }

                            //TANCAR STREAMS I SOCKETS
                            System.out.println("Tancant connexió... ");
                            fentrada.close();
                            fsortida.close();
                            clientConnectat.close();
                        }catch (SocketException e){
                            System.out.println("Error");
		
                        }
                    }   
}
