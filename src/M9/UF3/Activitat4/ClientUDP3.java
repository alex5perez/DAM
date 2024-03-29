/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M9.UF3.Activitat4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author alexp
 */
public class ClientUDP3 {
    public static void main (String[] args) throws Exception {
		
		//FLUX PER A ENTRADA ESTÀNDARD
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//Socket client
		DatagramSocket clientSocket = new DatagramSocket();
		byte[] enviats = new byte[1024];
		byte[] rebuts = new byte[1024];
		
		//DADES DEL SERVIDOR al qual s'envia el missatge
		InetAddress IPServidor = InetAddress.getLocalHost();
		int port = 9800;
		
                //While per pantalla que missatge es vol transmetre al servidor.
                while(clientSocket.getSoTimeout() <= 5000){
                    
                    //INTRODUIR DADES PEL TECLAT
                    System.out.print("Introdueix missatge: ");
                    String cadena = in.readLine();
                    enviats = cadena.getBytes();
                    
                    //ENVIANT DATAGRAMA AL SERVIDOR
                    System.out.println("Enviant "+enviats.length+"bytes al servidor.");
                    DatagramPacket enviament = new DatagramPacket(enviats, enviats.length, IPServidor, port);
                    clientSocket.send(enviament);

                    //REBENT DATAGRAMA DEL SERVIDOR
                    DatagramPacket rebut = new DatagramPacket(rebuts, rebuts.length);
                    System.out.println("Esperant datagrama...");
                    
                    //Servidor no respongui passats 5 segons (setSoTimeout) el programa acabi.
                    clientSocket.setSoTimeout(5000);
                    try{
                        clientSocket.receive(rebut);
                    }catch (Exception e){
                        System.out.println("Més de 5 segons, error");
                    }
                    String majuscula = new String(rebut.getData());

                    //ACONSEGUINT INFORMACIÓ DEL DATAGRAMA
                    InetAddress IPOrigen = rebut.getAddress();
                    int portOrigen = rebut.getPort();
                    System.out.println("\tProcedent de: "+IPOrigen+":"+portOrigen);
                    System.out.println("\tDades: "+majuscula.trim());
                }
		
		
		
		//Tanca el socket
		clientSocket.close();
		
	}

}
