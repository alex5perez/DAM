/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M9.UF3.Activitat2;

import java.io.*;
import java.net.*;
import java.util.Scanner;


/**
 *
 * @author alexp i hector
 */
public class ExempeURL {
    
    public static void main (String[] args) {
		URL url;
		
	String direccio = args[0];
        int port = Integer.parseInt(args[1]);
        
            try {
                url = new URL("http", direccio, port, "/");
                Visualitzar (url);
            } catch (MalformedURLException e) { System.out.println(e); }
                
            

	}
    
        private static void Visualitzar(URL url) {
		
		BufferedReader in;
		
		try {
			
			//Url
			InputStream inputStream = url.openStream();
			in = new BufferedReader(new InputStreamReader(inputStream));
			
			String inputLine;
			//Mostra per pantalla per linea
			while ((inputLine = in.readLine()) != null)
				System.out.println(inputLine);
			in.close();
			
		} catch (IOException e) {e.printStackTrace(); }

		
	}

}


