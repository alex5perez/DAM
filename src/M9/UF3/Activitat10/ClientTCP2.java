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

import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author alexp
 */
public class ClientTCP2 implements Runnable {
    
    private static Socket client;
    private static boolean seguir = true;
    
    public ClientTCP2(Socket client) {
        this.client = client;
    }
        
    public static void main (String[] args) throws Exception {
		
		String host = "localhost";
		int port = 60000;//Port remot
		
                
                    try {
                    //Iniciem client 
                    client = new Socket(host, port);


                    //FLUX fDE SORTIDA AL SERVIDOR
                    PrintWriter fsortida = new PrintWriter(client.getOutputStream(), true);

                    //FLUX D'ENTRADA AL SERVIDOR
                    BufferedReader fentrada = new BufferedReader(new InputStreamReader(client.getInputStream()));

                    //FLUX PER A ENTRADA ESTÀNDARD
                    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

                    String nom = "";
                    //El Client posa el seu nom o nick
                    System.out.println("Introdueix el teu nom: ");
                    nom = in.readLine();
                    while (nom == null || nom.equals("") ) {
                        System.out.println("Error, Introdueix el teu nom: ");
                        nom = in.readLine();
                    }
                    fsortida.println(nom);
                    //Quan el client esta conectat es mostra aixo
                    String cadena, eco = "";
                    System.out.println("Missatge pel chat: ");
                    //Lectura teclat
                    cadena = in.readLine();

                    while (cadena != null ) {

                            //Enviament cadena al servidor
                            fsortida.println(nom + ": " + cadena);
                            //El Servidor diu al client
                            eco = fentrada.readLine();
                            System.out.println(" =>Eco: "+eco);
                            //Lectura del teclat
                            cadena = in.readLine();
                            
                            if (cadena == null) {
                                fsortida.print(cadena);
                            }
                    }
                    
                    fsortida.close();
                    fentrada.close();
                    System.out.println("Finalització de l'enviament...");
                    in.close();
                    client.close();
                    }catch(IOException e){
                        e.printStackTrace();
                    }
	}
    
    public static void noSeguir() {
        seguir = false;
    }

    @Override
    public void run() {
        while (seguir == true) {
            try {
                BufferedReader fentrada = new BufferedReader (new InputStreamReader(this.client.getInputStream()));
                String entrada = fentrada.readLine();
                
                if(entrada == null) {
                    noSeguir();
                }else{
                    System.out.println(entrada);
                }
            }catch(SocketException e){
                
            }catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
		
}
