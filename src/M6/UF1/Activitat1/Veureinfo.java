package Java;
//Fes un programa que s'anomeni VeureInfo que:
//Accepti de línia d'ordres (args[0]) el directori o fitxer que es vol consultar.

import java.io.File;

//Cal comprova que existeix file.exists()
        //Si és un directori (file.isDirectory()) que mostri el seu contingut, 
//com ho fa a CODI1.1
        //Si és un fitxer (file.isFile()) que mostri la seva informació, com ho fa a CODI1.2
//NO-DUAL
    //En el cas d'objectes ocults, indicar d'alguna manera en la sortida que es 
//tracta efectivament d'un objecte ocult.
    //S'ha d'indicar quina és l'última data que s'ha modificat l'objecte i, en 
//el cas d'objectes modificats els darrers tres dies, s'ha d'indicar d'alguna 
//manera aquest fet de manera VISIBLE.import java.io.*;

public class Veureinfo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        File f = new File(args[0]);
        String[] arxius = f.list();
        
        if(f.exists()){
            System.out.println("\nExisteix");
            if(f.isDirectory()){
                for (String arxiu : arxius) {
                    System.out.println(arxiu);
                }
            } 
            if(f.isFile()){
                System.out.println("\nNom del fitxer : "+f.getName());
                System.out.println("Ruta           : "+f.getPath());
	        System.out.println("Ruta absoluta  : "+f.getAbsolutePath());
		System.out.println("Es pot escriure: "+f.canRead());
		System.out.println("Es pot llegir  : "+f.canWrite());
		System.out.println("Grandaria      : "+f.length());
		System.out.println("Es un directori: "+f.isDirectory());
		System.out.println("Es un fitxer   : "+f.isFile());
            }      
        } else{
            System.out.println("\nNo existeix");
        }
        if(f.isHidden()){
            System.out.println("\nEs troba ocult");
        } else{
            System.out.println("\nNo es troba ocult");
        }
        System.out.println("\nL'ultima data de modificació es de " + ( 18528 - ((((f.lastModified()/ 1000) / 60 ) / 60) / 24 ))  + " dies enrere");
    //    System.out.println(f.lastModified());
    //    System.out.println( 18528 - ((((f.lastModified()/ 1000) / 60 ) / 60) / 24 ));
        
        if( 18528 - ((((f.lastModified()/ 1000) / 60 ) / 60) / 24 ) < 3){
            System.out.println("\nS ha modificat en els darrers 3 dies");
        }
    }
    
}


