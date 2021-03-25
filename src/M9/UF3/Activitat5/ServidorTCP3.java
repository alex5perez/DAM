/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M9.UF3.Activitat5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author Alex Pérez i Hector Garzon
 */
public class ServidorTCP3 {
    public static void main (String[] args) throws Exception {
		
		int numPort = 60000;
		ServerSocket servidor = new ServerSocket(numPort);
		String cadena = "";
                
                //Variable per comptar els clients
                int clients = 0;
                
                    //El Servidor aten maxim 3 clients
                    while ( clients < 3) {
                        try {
                            System.out.println("Esperant connexió... ");
                            Socket clientConnectat = servidor.accept();
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
            servidor.close();
		
	}

}

