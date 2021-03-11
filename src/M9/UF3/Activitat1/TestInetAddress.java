/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M9.UF3.Activitat1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author alexp & hector
 */
public class TestInetAddress {
	
	public static void main (String[] args) {
                //String pel nom de la maquina
                String nomPc;
                Scanner scan = new Scanner(System.in);
            
		InetAddress dir = null;
                
		try {
                    System.out.println("nom de màquina o adreça IP: ");
			nomPc = scan.nextLine();
			dir = InetAddress.getByName(nomPc);
			provaTots(dir);
			
		} catch (Exception e) {e.printStackTrace();}
		
	}
	
	private static void provaTots(InetAddress dir) throws IOException {
		
		InetAddress dir2;
		
		System.out.println("\tMètode getByName(): "+dir);
		
		try {
			dir2 = InetAddress.getLocalHost();
			System.out.println("\tMètode getLocalHost(): "+dir2);
		} catch (UnknownHostException e) {e.printStackTrace();}
		
		//FEM SERVIR MÊTODES DE LA CLASSE
                System.out.println("\tMètode isReachable: "+dir.isReachable(50));
		System.out.println("\tMètode getHostName(): "+dir.getHostName());
		System.out.println("\tMètode getHostAddress(): "+dir.getHostAddress());
		System.out.println("\tMètode toString(): "+dir.toString());
		System.out.println("\tMètode getCanonicalHostName(): "+dir.getCanonicalHostName());
		
	}

}
