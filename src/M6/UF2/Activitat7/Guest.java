package M6.UF2.Activitat7;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
 /*
* File: Exercici6UF2M6.java 
* Author: Alex Pérez Rubio
* Date: 3-11-2020
* Description: Activitat 7 PRACTICA UF2 M6
*/
@Entity
public class Guest implements Serializable {
    private static final long serialVersionUID = 1L;

    // Persistent Fields:
    @Id @GeneratedValue
    Long id;
    private String name;
    private Date signingDate;

    // Constructors:
    public Guest() {
    }

    public Guest(String name) {
        this.name = name;
        this.signingDate = new Date(System.currentTimeMillis());
    }

    // String Representation:
    @Override
    public String toString() {
        return name + " (signed on " + signingDate + ")";
    }
}