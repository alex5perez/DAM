package exercici2uf1;
/**
 *
 * @author alexp
 */
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import java.util.Scanner;

public class LlegirFitxerObject {
      public static void main(String[] args) throws IOException, ClassNotFoundException {
        int opcio;
        Cotxes cotxes;
        Scanner sc = new Scanner(System.in);
        File fitxer = new File("C:\\Users\\alexp\\Downloads\\2n Dam\\M6\\UF1\\actividades\\cotxes.txt");
        FileInputStream filein = new FileInputStream(fitxer);
        ObjectInputStream dataInCotxes = new ObjectInputStream(filein);
     
        System.out.println("1- Recuperar objectes Cotxe");
        System.out.println("2- Recuperar objectes segons un camp de Cotxe");
        opcio = sc.nextInt();  
 
        if(opcio ==1){
         try {
            while (true){
		cotxes = (Cotxes) dataInCotxes.readObject();
		System.out.println("Marca: " +cotxes.getMarca()+ " Model: " +cotxes.getModel()+ " Any: "+ cotxes.getAny()+ " Matricula: "+ cotxes.getMatricula());
		}
	} catch (EOFException eo) {}
        }else if(opcio ==2){
                System.out.println("1-Marca");
                System.out.println("2-Model");
                System.out.println("3-Any");
                System.out.println("4-Matricula");             
           opcio = sc.nextInt(); 
           switch(opcio){
               case 1:  
                   String  Marca;
                   Marca= sc.next();
             try {
                 while (true){
            	cotxes = (Cotxes) dataInCotxes.readObject();
                if(Marca.equalsIgnoreCase(cotxes.getMarca()))
		System.out.println("Marca: " +cotxes.getMarca()+ " Model: " +cotxes.getModel()+ " Any: "+ cotxes.getAny()+ " Matricula: "+ cotxes.getMatricula());
		}
                } catch (EOFException eo) {}
                   break;
               case 2:
                     String  Model;
                     Model= sc.next();
                try {
                while (true){
            	cotxes = (Cotxes) dataInCotxes.readObject();
                if(Model.equalsIgnoreCase(cotxes.getModel()))
		System.out.println("Marca: " +cotxes.getMarca()+ " Model: " +cotxes.getModel()+ " Any: "+ cotxes.getAny()+ " Matricula: "+ cotxes.getMatricula());
		}
                } catch (EOFException eo) {}
                   break;
               case 3:
                    int Any;
                    Any= sc.nextInt();
                try {
                while (true){
            	cotxes = (Cotxes) dataInCotxes.readObject();
                if(Any == cotxes.getAny())
		System.out.println("Marca: " +cotxes.getMarca()+ " Model: " +cotxes.getModel()+ " Any: "+ cotxes.getAny()+ " Matricula: "+ cotxes.getMatricula());
		}
                } catch (EOFException eo) {}
                   break;  
               case 4:
                     String  Matricula;
                     Matricula= sc.next();
                try {
                while (true){
            	cotxes = (Cotxes) dataInCotxes.readObject();
                if(Matricula.equalsIgnoreCase(cotxes.getMatricula()))
		System.out.println("Marca: " +cotxes.getMarca()+ " Model: " +cotxes.getModel()+ " Any: "+ cotxes.getAny()+ " Matricula: "+ cotxes.getMatricula());
		}
                } catch (EOFException eo) {}
                   break;     
           }
        }
	dataInCotxes.close();
    }     
} 
