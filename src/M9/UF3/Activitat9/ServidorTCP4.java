/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M9.UF3.Activitat9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

/**
 *
 * @author Alex Perez i Hector Garzon
 */
public class ServidorTCP4 {
    public static void main (String[] args) throws Exception {
                Scanner teclat = new Scanner(System.in);
        
		int numPort = 60000;
		ServerSocket servidor = new ServerSocket(numPort);
                
                //Variable per comptar els clients
                int clients = 0;
                int numClients;
                Thread thread;
                ServidorFils fil;
                
                System.out.println("Numero dels clients que vols? ");
                numClients = teclat.nextInt();
                
                    //El Servidor agafa els clients que li posem per teclat
                    while ( clients < numClients) {
                        try {
                            System.out.println("Esperant connexió... ");
                            Socket clientConnectat = servidor.accept();
                            clients++;
                            
                            fil = new ServidorFils(servidor, clientConnectat);
                            thread = new Thread(fil);
                            thread.start();
                        }catch (SocketException e){
                                System.out.println("Error");
                        }catch (IOException s) {
                                s.printStackTrace();
                            }
                    }   
            servidor.close();
            teclat.close();
	}

}
