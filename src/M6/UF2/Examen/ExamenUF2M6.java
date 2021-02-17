/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenuf2m6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author alexp
 */
public class ExamenUF2M6 {
    static Scanner teclat = new Scanner(System.in);
    
    //Menu
    public static void menu() {
        System.out.println("Escull una opció:");
        System.out.println("1. Crear");
        System.out.println("2. Login");
        System.out.println("3. Reset");
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        int opcio;
        boolean programa = true;
        boolean val;
        Statement stmt;
        ResultSet rs;
        
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/examen", "alumne", "alumne");
        } catch (Exception e) {
                System.out.println(e);
        }
        
        while (programa) {
            menu ();
            opcio = teclat.nextInt();
            
            switch (opcio) {
                
                
                case 1:
                    System.out.println("Has escollit crear, insereix la informació que es demana:");
                    System.out.println("Usuari?");
                    String usuari = teclat.next();
                    System.out.println("Contrasenya?");
                    String contrasenya = teclat.next();
                    System.out.println("Pregunta? (Sense espais, per exemple Anys?, Localitat?");
                    String pregunta = teclat.next();
                    System.out.println("Resposta?");
                    String resposta = teclat.next();
                    try {  
                    
                    stmt = (Statement) con.createStatement();
                    stmt.executeUpdate("INSERT INTO usuaris(usuari, contrasenya, pregunta, resposta)"
                            + "VALUES ('" 
                            + usuari
                            + "', '"
                            + contrasenya
                            + "', '"
                            + pregunta
                            + "', '"
                            + resposta
                            + "')");
                    
                      System.out.println("Usuari creat");
                    }catch (Exception e) {
                    System.out.println("Usuari no creat, ja existeix");
                    }
                    break;
                    
                case 2:
                    System.out.println("Has escollit login, insereix la informació que es demana:");
                    System.out.println("Usuari?");
                    usuari = teclat.next();
                    System.out.println("Contrasenya?");
                    contrasenya = teclat.next();
                    boolean login = true;
                        
                        stmt = (Statement) con.createStatement();
                        rs = stmt.executeQuery("SELECT * FROM usuaris WHERE usuari = '"
                                        + usuari + "'");
                        
                        val = rs.next();
                        
                        if (val == false) {
                            System.out.println("Usuari no exiteix");
                        }else{
                            while (login) {
                                       //No consegueixo posar que em validi tambe la contrasenya
                                       //Nomes m'agafa el usuari
                                rs = stmt.executeQuery("SELECT * FROM usuaris WHERE usuari = '" + usuari + "'");
                            System.out.println("Login Correcte");
                            login = false;
                            }
                        }
                break;
                
                case 3:
                    System.out.println("Has escollit reset, insereix la informació que es demana:");
                    System.out.println("Usuari?");
                    usuari = teclat.next();

                    boolean reset = true;
                        
                        stmt = (Statement) con.createStatement();
                        rs = stmt.executeQuery("SELECT * FROM usuaris WHERE usuari = '"
                                        + usuari + "'");
                        
                        val = rs.next();
                    System.out.println(rs.getString(3));
                    String camp = teclat.next().toLowerCase();
                    System.out.println("Introdueix nova contrasenya:");
                            if (camp.equals("campo")) {
                                int contrasenyaUpdate = teclat.nextInt();
                                stmt.executeUpdate("UPDATE usuaris SET " + camp
                                                   + "= '" + contrasenyaUpdate + "' WHERE usuari =  '" + usuari
                                                   + "'");
                                //No aconsegueixo que modifiqui
                                 }else{
                                String valor = teclat.next();
                                stmt.executeUpdate("UPDATE usuaris SET " + camp
                                                   + "= '" + valor + "' WHERE usuari =  '" + usuari
                                                   + "'");
                            }
                            
                            System.out.println("Contrasenya Canviada");
                            reset = false;
                break;
            }
    
        }
    }
}

