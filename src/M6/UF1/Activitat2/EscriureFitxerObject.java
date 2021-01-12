package exercici2uf1;
/**
 *
 * @author alexp
 */
import java.io.*;
import java.util.Scanner;

public class EscriureFitxerObject {
    public static void main(String[] args) throws IOException {
        Cotxes cotxes;
        Scanner sc = new Scanner(System.in);
        
        File fitxer = new File("C:\\Users\\alexp\\Downloads\\2n Dam\\M6\\UF1\\actividades\\cotxes.txt");
       	FileOutputStream fileout = new FileOutputStream(fitxer);
        ObjectOutputStream dataOuCotxes = new ObjectOutputStream(fileout);
        String marca[] = {"Seat" , "Bmw" , "Ford" , "Ferrari"};
        String model[] = {"Leon", "X6", "Mustang", "Spider"};
        int any[]={2002 ,2012 ,2018 ,2010};
        String matricula[]={"B3599XC", "B3598XC", "B3597XC", "B3596XC"};
        for (int i=0; i<marca.length; i++){
			cotxes = new Cotxes(marca[i], model[i], any[i], matricula[i]);
			dataOuCotxes.writeObject(cotxes);
		}
        
        String marcax;
        String modelx;
        int anyx;
        String matriculax;
        
        Cotxes cotxe;
        
        System.out.println("Marca:");
        marcax = sc.next();
        System.out.println("Model:");
        modelx = sc.next();
        System.out.println("Any:");
        anyx = sc.nextInt();
        System.out.println("Matricula:");
        matriculax = sc.next();       
        cotxe = new Cotxes(marcax, modelx, anyx, matriculax);
			dataOuCotxes.writeObject(cotxe);    
    dataOuCotxes.close();
    sc.close();
    }
}