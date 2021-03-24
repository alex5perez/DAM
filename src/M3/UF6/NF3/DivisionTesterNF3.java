/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M3.UF6.NF3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author alexp
 */
public class DivisionTesterNF3 {
    public static void main (String[] args) throws IOException {
        BufferedReader teclat = new BufferedReader ( new InputStreamReader ( System.in));
        
        String data;
        int num1=0, num2=0;
        
        try{
            System.out.println("Enter the numerator: ");
            data = teclat.readLine();
            num1 = Integer.parseInt(data);
            
            System.out.println("Enter de divisor: ");
            data = teclat.readLine();
            num2 = Integer.parseInt(data);
            
            System.out.println(num1 + "/" + num2 + "is" + (num1/num2));
            
        }catch(NumberFormatException ex ){
            System.out.println("You entered bad data.");
            System.out.println("Please try agains.");
        }
        
        catch(ArithmeticException ex){
            System.out.println("You can't divide " + num1 + " by " + num2);
        }
    }
}
