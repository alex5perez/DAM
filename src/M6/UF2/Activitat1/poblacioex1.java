/*
Heu de crear una segona taula per a poblacions. 
En aquesta segona taula hi haurà dos camps: 
codi postal i nom de població. 
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
public class poblacioex1 {
    static Scanner teclat = new Scanner(System.in);
    
    public static void menu() {
        System.out.println("1. Inserir un registre");
        System.out.println("2. Suprimeix un registre");
        System.out.println("3. Mostrar els registres");
        System.out.println("4. Salir");
        System.out.println("Tria una opció");
    }
    
    public static void main(String[] args) throws SQLException {
        
        int opcio;
        boolean programa = true;
        boolean val;
        Statement stmt;
        ResultSet rs;
        int id;
        
        String resposta;
        
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/activitat1", "alumne", "alumne");
            con.setAutoCommit(false);
            
        } catch (Exception e) {
            System.out.println(e);
        }
        
        while (programa) {
            menu();
            opcio = teclat.nextInt();
            
            switch (opcio) {
                
                case 1:
                    
                    System.out.println("Introdueix el codi postal");
                    String cp = teclat.next();
                    System.out.println("Introdueix la poblacio");
                    String poblacio = teclat.next();
                    
                    stmt = (Statement) con.createStatement();
                    stmt.executeUpdate("INSERT INTO poblacio(codi_postal, poblacio) "
                                    + "VALUES ('"
                                    + cp
                                    + "', '"
                                    + poblacio
                                    + "')");
                    
                    System.out.println("Vols guardar aquesta modificacio?");
                    resposta = teclat.next();
                    
                    if (resposta.equalsIgnoreCase("si")) {
                        con.commit();
                        System.out.println("Poblacio afegida correctament");
                        System.out.println();
                    }else{
                        con.rollback();
                        System.out.println("Desfent els canvis");
                        System.out.println();
                    }
                
                    System.out.println();
                    
                    break;
                
                case 2:
                    System.out.println("Introdueix el codi postal de la poblacio que vols eliminar(Tots els alumnes amb aquesta poblacio seran eliminats)");
                    id = teclat.nextInt();
                    
                    stmt = (Statement) con.createStatement();
                    
                    rs = stmt.executeQuery("SELECT * FROM poblacio WHERE codi_postal = '" + id + "'");
                    
                    val = rs.next();
                    
                    if (val == false) {
                        System.out.println("Poblacio no encontrada");
    
                    }else{
                        stmt = (Statement) con.createStatement();
                        stmt.executeUpdate("DELETE FROM poblacio WHERE codi_postal = '" + id + "'");
                        System.out.println("Vols guardar aquesta modificacio?");
                        resposta = teclat.next();
                        
                        if(resposta.equalsIgnoreCase("si")) {
                            con.commit();
                            System.out.println("Poblacio eliminada correctament");
                        }else {
                            con.rollback();
                            System.out.println("Poblacio no eliminada");
                        }
                    }
                    break;
                case 3:
                    
                    stmt = (Statement) con.createStatement();
                    rs = stmt.executeQuery("select * from poblacio");
                    
                        System.out.println("CP ----- POBLACION");
                    while (rs.next())
                        System.out.println(rs.getInt(1) + "  " + rs.getString(2));
                    
                    break;
                case 4:
                    System.out.println("Conexio finalitzada");
                    con.close();
                    programa = false;
                    
                default:
                    break;
            }
            
        }
        
    }
    
}