/*
Has de codificar un programa que permeti inserir, modificar i esborrar 
alumnes en una base de dades. Les dades que, com a mínim, volem guardar 
de cada alumne és el seu nom, dni, data de naixement, adreça postal, sexe, 
codi postal i població.
 */
package M6.UF2.Activitat1;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.Statement;

/*
* File: Exercici1UF2M6.java 
* Author: Alex Pérez Rubio
* Date: 25-11-2020
* Description: Activitat 1 PRACTICA UF2 M6
*/
public class Ex1uf2m6 {
    static Scanner teclat = new Scanner(System.in);
    
    //Menu
    public static void menu() {
        
        System.out.println("1. Inserir un registre");
        System.out.println("2. Modificar un registre");
        System.out.println("3. Suprimeix un registre");
        System.out.println("4. Mostrar els registres");
        System.out.println("5. Mostrar els registres(Individual)");
        System.out.println("6. Salir");
        System.out.println("Tria una opció");
    }
    

    public static void main(String[] args) throws SQLException {
        
        
        //variables
        int opcio;
        int id;
        boolean programa = true;
        boolean val;
        Statement stmt;
        ResultSet rs;
        
        Connection con = null;
        
        //Conexio al mysql
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/activitat1", "alumne", "alumne");
        } catch (Exception e) {
                System.out.println(e);
        }
        
        //Programa del menu
        while (programa) {
            menu ();
            opcio = teclat.nextInt();
            
            switch (opcio) {
                
                //Insertar els alumnes i les seves dades
                case 1:
                    
                    System.out.println("Introdueix el nom");
                    String nom = teclat.next();
                    System.out.println("Introdueix el Dni");
                    String dni = teclat.next();
                    System.out.println("Introdueix la data de naixement");
                    String data = teclat.next();
                    System.out.println("Introdueix l'adreça poblacio");
                    String adrecapoblacio = teclat.next();
                    System.out.println("Introdueix el codi postal");
                    int codipoblacio = teclat.nextInt();
                    System.out.println("Introdueix la poblacio");
                    String ciutat = teclat.next();
                  try {  
                    //Statement execute update per fer INSERT a la taula
                    stmt = (Statement) con.createStatement();
                    stmt.executeUpdate("INSERT INTO alumne(nom, dni, data_naixement, codi_poblacio, codi_postal, poblacio)"
                            + "VALUES ('" 
                            + nom
                            + "', '"
                            + dni
                            + "', '"
                            + data
                            + "', '"
                            + adrecapoblacio
                            + "', '"
                            + codipoblacio
                            + "', '"
                            + ciutat
                            + "')");
                    
                    System.out.println("alumne introduit");
            }       catch (Exception e) {
                    System.out.println("no existeix poblacio");
                    }
                    break;
                    
                //Modificar els alumnes    
                case 2: 
                    
                    System.out.println("Introdueix el Id del alumne que vols modificar");
                    id = teclat.nextInt();
                    boolean modificar = true;
                        //Seleccio del dni per busacr l'alumne
                        stmt = (Statement) con.createStatement();
                        rs = stmt.executeQuery("SELECT * FROM alumne WHERE id = '"
                                        + id + "'");
                        
                        val = rs.next();
                        
                        //Alumne erroni
                        if (val == false) {
                            System.out.println("Alumne no existeix");
                        }else{
                            while (modificar) {
                                
                                rs = stmt.executeQuery("SELECT * FROM alumne WHERE id = '"
                                                + id + "'");
                                
                            System.out.println("ID--NOM--DNI--DATA_NAIXEMENT--CODI_POBLACIO--CODI_POSTAL--POBLACIO");
                            while (rs.next())
                                System.out.println(rs.getInt(1) + "  "
					+ rs.getString(2) + "  " + rs.getString(3)
					+ " " + rs.getString(4) + " "
                                        + rs.getString(5) + " " + rs.getString(6)
					+ " " + rs.getString(7));      
                            //Seleccio del camp a modificar
                            System.out.println("Escriu quin camp modificar:");
                            System.out.println("id--nom--dni--data_naixement--codi_poblacio--codi_postal--poblacio");
                            String camp = teclat.next().toLowerCase();
                            System.out.println("Introdueix el nou valor");
                            if (camp.equals("campo")) {
                                int codipoblacioUpdate = teclat.nextInt();
                                stmt.executeUpdate("UPDATE alumne SET " + camp
                                                   + "= '" + codipoblacioUpdate + "' WHERE id =  '" + id
                                                   + "'");
                            }else{
                                String valor = teclat.next();
                                stmt.executeUpdate("UPDATE alumne set " + camp
                                                   + "= '" + valor + "' WHERE id =  '" + id
                                                   + "'");
                            }
                            
                            System.out.println("Vols modificar alguna cosa mes?");
                            System.out.println("si o no");
                            String mes = teclat.next();
                            if (mes.equalsIgnoreCase("no")) {
                                modificar = false;
                            }
                            
                            }
                        }
                    
                    break;
                
                //Suprimeix un alumne    
                case 3:
                    
                    System.out.println("Introdueix el Id del alumne que vols eliminar");
                    id = teclat.nextInt();
                    
                    stmt = (Statement) con.createStatement();
                    
                    rs = stmt.executeQuery("SELECT * FROM alumne WHERE id = '" + id
                                    + "'");
                    val = rs.next();
                    
                    if (val == false) {
                        System.out.println("Alumne no existeix");
                    }else{
                        stmt = (Statement) con.createStatement();
                        stmt.executeUpdate("DELETE FROM alumne WHERE id = '" + id
                                        + "'");
                        
                        System.out.println("Alumne eliminat correctament");
                    }
                    
                    break;
                //Mostrar alumne    
                case 4:
                    
                    stmt = (Statement) con.createStatement();
                    rs = stmt.executeQuery("SELECT * FROM alumne");
                    System.out.println("ID--NOM--DNI--DATA_NAIXEMENT--CODI_POBLACIO--CODI_POSTAL--POBLACIO");
                    while (rs.next())
                        
                        System.out.println(rs.getInt(1) + "  "
				+ rs.getString(2) + "  " + rs.getString(3)
				+ " " + rs.getString(4) + " "
                                + rs.getString(5) + " " + rs.getString(6)
				+ " " + rs.getString(7));
                    break;
                case 5: 
                    
                    System.out.println("Introdueix el Id del alumne que vols veure");
                    id = teclat.nextInt();
                    
                    stmt = (Statement) con.createStatement();
                        rs = stmt.executeQuery("SELECT * FROM alumne WHERE id = '"
                                        + id + "'");
                    while (rs.next())
                        
                        System.out.println(rs.getInt(1) + "  "
				+ rs.getString(2) + "  " + rs.getString(3)
				+ " " + rs.getString(4) + " "
                                + rs.getString(5) + " " + rs.getString(6)
				+ " " + rs.getString(7));
                    break;
                    
                //Sortir del programa    
                case 6:    
                    System.out.println("Conexio finalitzada");
                    con.close();
                    programa = false;
                    
                default:
                    break;
                 
            }
            
        }
         
    }
    
}