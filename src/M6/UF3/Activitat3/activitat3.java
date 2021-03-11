/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M6.UF3.Activitat3;

import java.io.BufferedReader;
import org.xmldb.api.*;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.*;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author alexp
 */
public class activitat3 {
    public static void main (String[] args) throws XMLDBException {
        String driver = "org.exist.xmldb.DatabaseImpl"; //Driver para eXist
        
        Collection col = null; // Colección
        
        String URI="xmldb:exist://localhost:8080/exist/xmlrpc/db"; //URI colección
        
        String usu="admin"; //Usuario
        
        String usuPwd="admin"; //Clave
        
        try {
            Class cl = Class.forName(driver); //Cargar del driver
   
            Database database = (Database) cl.newInstance(); //Instancia de la BD 
            
            DatabaseManager.registerDatabase(database); //Registro del driver
        } catch (Exception e) {
            System.out.println("Error al inicializar la BD eXist");
             e.printStackTrace(); 
        }
        
        col = DatabaseManager.getCollection(URI, usu, usuPwd);
        if(col == null) {
            System.out.println(" *** LA COLECCION NO EXISTE. ***");
        }
        System.out.println("Escriu un departament: ");
        String s = null;
        //try  {
            //BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
                    //s = in.readLinr();
        //}catch (IOException e){
            //System.out.println("Error en llegir");
            //e.printStackTrace();
        //}
        XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
         
        ResourceSet result = servicio.query ("for $em in /departamentos/DEP_ROW[DEPT_NO=20] return $em"); 
        // recorrer los datos del recurso.
        ResourceIterator i;
        i = result.getIterator();
        if (!i.hasMoreResources())
            System.out.println(" LA CONSULTA NO DEVUELVE NADA."); 
        
        while (i.hasMoreResources()) {
            Resource r = i.nextResource();
            System.out.println((String) r.getContent());
        }
        col.close(); //borramos
        
    }// FIN verempleados10
}
