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
		
		try {
			String cadena;
			URL url = new URL("http://insbaixcamp.org/index.php/2013-10-29-12-24-12/informacio-general-4");
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
			System.out.println("Camps 1 i 4 de Capçalera");
			System.out.println("getHeaderField(1)=> " + connexio.getHeaderField(1));
			System.out.println("getHeaderField(4)=> " + connexio.getHeaderField(4));
			System.out.println("===============================================================");
			
			System.out.println("Contingut de [url.getFile()]: " + url.getFile());
			BufferedReader pagina = new BufferedReader(new InputStreamReader(url.openStream()));
			
			while ((cadena = pagina.readLine()) != null) {
				
				System.out.println(cadena);
			}
			
		}
		catch (MalformedURLException e) { e.printStackTrace();}
		catch (IOException e) {e.printStackTrace();}
	}

}
