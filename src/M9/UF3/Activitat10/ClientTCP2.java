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

/**
 *
 * @author alexp
 */
public class ClientTCP2 {
    public static void main (String[] args) throws Exception {
		
		String host = "localhost";
		int port = 60000;//Port remot
		Socket client;
                
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
                    //Si el client no posa el nom
                    while (nom == null || nom.equals("") ) {
                        System.out.println("Error, Introdueix el teu nom: ");
                        nom = in.readLine();
                    }
                    
                    String cadena = "";
                    fsortida.println(cadena);
                    //Quan el client esta conectat es mostra aixo
                    System.out.println("Que vols fer?");
                    System.out.println("0 <== Per veure els usuaris del chat");
                    System.out.println("1 <== Per enviar missatge a tots");
                    System.out.println("2 <== Per enviar missatge privat");
                    //Lectura teclat
                    cadena = in.readLine();

                    while (cadena != null) {

                            //Enviament cadena al servidor
                            fsortida.println(cadena);
                            
                            //Lectura del teclat
                            cadena = in.readLine();


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
		
}
