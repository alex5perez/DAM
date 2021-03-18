/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M9.UF3.Activitat3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author alexp i hector
 */
public class UrlConn {
    @SuppressWarnings("rawtypes")
	public static void main (String[] args) {
            String urlLoc = args[0];
            int numCamps = Integer.parseInt(args[1]);
            String text = args[2];
		
		try {
			String cadena;
                        //Url
			URL url = new URL(urlLoc);
			URLConnection connexio = url.openConnection();
			
			System.out.println("===============================================================");
			System.out.println("ADREÇA, DARA I CONTINGUT");
			System.out.println("Adreça [getURL]: " + connexio.getURL());
			
			Date data = new Date(connexio.getLastModified());
			System.out.println("Data última modificació [getLastModified()]: " + data);
			System.out.println("Tipus de Contingut [getContentType()]" + connexio.getContentType());
			
			System.out.println("===============================================================");
			System.out.println("TOTS ELS CAMPS DE CAPÇALERA AMB getHeaderFields(): ");
			
			//Fem servir una estructura Map per a recuperar capçaleres
			Map campsCapçalera = connexio.getHeaderFields();
			Iterator it = campsCapçalera.entrySet().iterator();
			
			while (it.hasNext()) {
				Map.Entry map = (Map.Entry) it.next();
				System.out.println(map.getKey() + ":" + map.getValue());
			}
			
			System.out.println("===============================================================");
			System.out.println("Camps" + numCamps);
                        //Numero Camps
                        for (int i=1; i <= numCamps; i++) {
                            System.out.println("getHeaderField("+i+")=> " + connexio.getHeaderField(i));
                        }
			
			System.out.println("===============================================================");
			
			System.out.println("Contingut de [url.getFile()]: " + url.getFile());
			BufferedReader pagina = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while ((cadena = pagina.readLine()) != null) {
                            //Text
                            if(cadena.contains(text.subSequence(0, text.length()-1))){
                                System.out.println(cadena);
                            }
				
			}
			
		}
		catch (MalformedURLException e) { e.printStackTrace();}
		catch (IOException e) {e.printStackTrace();}
	}

}
