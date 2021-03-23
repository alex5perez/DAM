/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M6.UF3.Examen;

import static M6.UF3.Activitat3.activitat3.URI;
import static M6.UF3.Activitat3.activitat3.col;
import static M6.UF3.Activitat3.activitat3.driver;
import static M6.UF3.Activitat3.activitat3.usu;
import static M6.UF3.Activitat3.activitat3.usuPwd;
import java.util.Scanner;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.Database;
import org.xmldb.api.base.Resource;
import org.xmldb.api.base.ResourceIterator;
import org.xmldb.api.base.ResourceSet;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XPathQueryService;

/**
 *
 * @author alexp
 */
public class ExamenM6UF3 {
    public static String driver = "org.exist.xmldb.DatabaseImpl"; //Driver para eXist
        
        public static Collection col = null; // Colección
        
        public static String URI="xmldb:exist://localhost:8080/exist/xmlrpc/db"; //URI colección
        
        public static String usu="admin"; //Usuario
        
        public static String usuPwd="admin"; //Clave
        
    public static void main (String[] args) throws XMLDBException {
        
        
        Scanner teclado = new Scanner(System.in);
        boolean menu = true;
        int seleccioMenu = 0;
        
        try {
            Class cl = Class.forName(driver);
   
            Database database = (Database) cl.newInstance();
            
            DatabaseManager.registerDatabase(database);
        } catch (Exception e) {
            System.out.println("Error al inicializar la BD eXist");
             e.printStackTrace(); 
        }
        
        col = DatabaseManager.getCollection(URI, usu, usuPwd);
        if(col == null) {
            System.out.println(" *** LA COLECCION NO EXISTE. ***");
        }
        XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
        
        //Menu
        while(menu){
            System.out.println("1.Mostrar els dies");
            System.out.println("2.Maxim casos");
            System.out.println("3.Maxim defuncions");
            System.out.println("4.Insertar dades");
            System.out.println("5.Esborrar dades");
            seleccioMenu = teclado.nextInt();
            
            if(seleccioMenu == 1){
                showDias(servicio);
            }else if (seleccioMenu == 2){
                maximCasos(servicio);
            }else if (seleccioMenu == 3){
                maximdefun(servicio);    
            }else if (seleccioMenu == 4){
                Insereix(teclado,servicio);
            }else if (seleccioMenu == 5){
               Esborrar(teclado,servicio);
            }else{
                System.out.println("Has sortit");
                menu = false;
            }
        }
        col.close();
        
        
        
    }
    
    private static void showDias(XPathQueryService servicio) throws XMLDBException{
       String xquerySent = "//response/rows/row/data/node()";
       ResourceSet result = servicio.query(xquerySent);
       ResourceIterator i;
        
            i = result.getIterator();
                if (!i.hasMoreResources())
                    System.out.println(" LA CONSULTA NO DEVUELVE NADA."); 

                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    System.out.println((String) r.getContent());
                }

    }
    
    private static void maximCasos(XPathQueryService servicio) throws XMLDBException{
       String xquerySent = "max(/response/rows/row/total_de_casos_confirmats/node())";
       ResourceSet result = servicio.query(xquerySent);
       ResourceIterator i;
        
            i = result.getIterator();
                if (!i.hasMoreResources())
                    System.out.println(" LA CONSULTA NO DEVUELVE NADA."); 

                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    System.out.println((String) r.getContent());
                }

    }
    
    private static void maximdefun(XPathQueryService servicio) throws XMLDBException{
       String xquerySent = "max(/response/rows/row/defuncions_di_ries/node())"; 
       ResourceSet result = servicio.query(xquerySent);
       ResourceIterator i;
        
            i = result.getIterator();
                if (!i.hasMoreResources())
                    System.out.println(" LA CONSULTA NO DEVUELVE NADA."); 

                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    System.out.println((String) r.getContent());
                }

    }
    
    //S'insereix igualment un duplicat
    private static void Insereix(Scanner teclado, XPathQueryService servicio)throws XMLDBException{
            System.out.println("Data");
            int numData = teclado.nextInt();
            System.out.println("Nous casos diaris");
            int nouCasos = teclado.nextInt();
            System.out.println("Defuncions");
            int defuns = teclado.nextInt();
            System.out.println("Total confirmats");
            int totalconf = teclado.nextInt();
            System.out.println("Total defuncions");
            int totaldefun = teclado.nextInt();
            try{
            ResourceSet result = servicio.query("update insert\n" +"<row><data>"+numData+"</data>"+ "<nous_casos_diaris_confirmats>"+nouCasos+"</nous_casos_diaris_confirmats>"
                                                    + "<defuncions_di_ries>"+defuns+"</defuncions_di_ries>"
                                                    +"<total_de_casos_confirmats>"+totalconf+"</total_de_casos_confirmats>"
                                                    +"<total_de_defuncions>"+totaldefun+"</total_de_defuncions></row> into /response");
            System.out.println("Cas inserit");
            }catch (Exception e){
            System.out.println("Cas ja existeix");
            }
        }
    
    private static void Esborrar(Scanner teclado,XPathQueryService servicio) throws XMLDBException{
            System.out.println("Data del dia que vols esborrar: ");
            int numData = teclado.nextInt();
            ResourceSet result = servicio.query("update delete /response/row[data="+numData+"]");
            System.out.println("Esborrat " + numData);
    }
}
