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
import java.util.Scanner;

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
        
        Scanner teclado = new Scanner(System.in);
        boolean menu = true;
        int seleccioMenu = 0;
        
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
        XPathQueryService servicio = (XPathQueryService) col.getService("XPathQueryService", "1.0");
        
        while(menu){
            System.out.println("1.Mostrar empleats del departament");
            System.out.println("2.Insertar un departament");
            System.out.println("3.Esborrar un departament");
            System.out.println("4.Modificar un departament");
            seleccioMenu = teclado.nextInt();
            
            if(seleccioMenu == 1){
                mostrarEmpleats(teclado,servicio);
            }else if (seleccioMenu == 2){
                insereixdep(teclado,servicio);
            }else if (seleccioMenu == 3){
                esborradep(teclado,servicio);
            }else if (seleccioMenu == 4){
               modificaDep(teclado);
            }else{
                System.out.println("Has sortit");
                menu = false;
            }
        col.close();
        }
    }
        
        private static void mostrarEmpleats(Scanner teclado,XPathQueryService servicio) throws XMLDBException{
            System.out.println("Escriu un departament");
            String departament = teclado.next();
            String xquerySent = "for $num in /departamentos/DEP_ROW[DNOMBRE='"+departament+"']/DEPT_NO let $emp := /EMPLEADOS/EMP_ROW[DEPT_NO=$num] return $emp"; 
            ResourceSet result = servicio.query(xquerySent);
             // recorrer los datos del recurso.
            ResourceIterator i;
        
            i = result.getIterator();
                if (!i.hasMoreResources())
                    System.out.println(" LA CONSULTA NO DEVUELVE NADA."); 

                while (i.hasMoreResources()) {
                    Resource r = i.nextResource();
                    System.out.println((String) r.getContent());
                }

        }
        
        private static void insereixdep(Scanner teclado,XPathQueryService servicio) throws XMLDBException{
            System.out.println("Nom del departament");
            String departament = teclado.next();
            System.out.println("Numero del departament");
            int numDepartament = teclado.nextInt();
            System.out.println("Lloc del departament");
            String llocDepartament = teclado.next();
            ResourceSet result = servicio.query("update insert\n" +"<DEP_ROW><DEPT_NO>"+numDepartament+"</DEPT_NO>"+ "<DNOMBRE>"+departament+"</DNOMBRE>"
                                                    + "<LOC>"+llocDepartament+"</LOC></DEP_ROW> into /departamentos");
            System.out.println("Departament inserit");
        }
        
        private static void esborradep(Scanner teclado,XPathQueryService servicio) throws XMLDBException{
            System.out.println("Num del departament per esborrar");
            int numDepartament = teclado.nextInt();
            ResourceSet result = servicio.query("update delete /departamentos/DEP_ROW[DEPT_NO="+numDepartament+"]");
            System.out.println("Esborrat " + numDepartament);
        }
        
        private static void modificaDep(Scanner teclado) throws XMLDBException{
            System.out.println("Num del departament per modificar");
            int numDepartament = teclado.nextInt();
            System.out.println("Num nou pel departament");
            int numNouDep = teclado.nextInt();
            System.out.println("Nom del departament");
            String nomDepartament = teclado.nextLine();
            System.out.println("Lloc del departament");
            String llocDep = teclado.nextLine();
            
            String query = "update replace /departamentos/DEP_ROW[DEPT_NO ="+ numDepartament +"] with <DEP_ROW><DEPT_NO>"
                                + numNouDep + "</DEPT_NO>" + "<DNOMBRE>" + nomDepartament + "</DNOMBRE><LOC>" + llocDep + "</LOC></DEP_ROW>";
            consultar(query);
        }
        
}



