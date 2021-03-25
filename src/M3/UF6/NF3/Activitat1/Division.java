/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package M3.UF6.NF3.Activitat1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author alexp
 */
public class Division {
    public static void main ( String[] a ) throws IOException {
    BufferedReader stdin = 
        new BufferedReader ( new InputStreamReader( System.in ) );
 
    String inData = null;
    int    num=0, div=0 ;


        try
        {
          System.out.println("Enter the numerator:");
          inData = stdin.readLine();
          num    = Integer.parseInt( inData );
          
          System.out.println("Enter the divisor:");
          inData = stdin.readLine();
          div    = Integer.parseInt( inData );
          System.out.println( num + " / " + div + " is " + (num/div) );
        }

        catch (NumberFormatException ex )
        {
          System.out.println("You entered bad data." );
          System.out.println("Run the program again." );
        }
    
        catch (ArithmeticException ex )
        {
          System.out.println("You can't divide " + num + " by " + div);
        }
    
  }
}
