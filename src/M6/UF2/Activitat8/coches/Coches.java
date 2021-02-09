/*
Heu de desenvolupar una aplicació que permeti fer el manteniment dels vehicles 
que gestiona una taller de cotxes.
La informació s'ha d'emmagatzemar en una bdoo que, com a mínim, ha de contenir 
objectes de tipus vehicles i de tipus propietaris.
Identifiqueu per a cada tipus d'objecte els camps necessaris i teniu en compte
que, entre tots els objectes que emmagatzemareu en la bdoo, hi ha d'haver,
com a mínim, un camp de tipus String, un de tipus data, un de tipus enter, i un de tipus booleà.
La interfície de l'aplicació és lliure, però és valorarà més l'ús d'una 
interfície visual enlloc de text, i la usabilitat, la coherència i l'ordre de la interfície també comptaran més.
L'aplicació ha de permetre llistar les dades dels vehicles, les dades dels 
propietaris i les dades de la resta d'objectes que emmagatzemeu en la bdoo.
*/
package M6.UF2.Activitat8.coches;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
* File: Exercici8UF2M6.java 
* Author: Alex Pérez Rubio
* Date: 17-11-2020
* Description: Activitat 8 PRACTICA UF2 M6
*/

@Entity
public class Coches implements Serializable {
    
    private static final long serialVersionUID = 1L;
        
        //Variables
        @Id @GeneratedValue
        Long id;
        private String modelo;
        private String matricula;
        private int kilometros;
        private Date fecha;
        private boolean reparar;
    
            public Coches( String modelo, String matricula,
                    int kilometros, boolean reparar)
            {
                this.modelo = modelo;
                this.matricula = matricula;
                this.kilometros = kilometros;
                this.fecha = new Date(System.currentTimeMillis());
                this.reparar = reparar;
            }
            
            //Gets and Sets
            public String getModelo() {
                return modelo;
            }
            
            public void setModelo(String modelo) {
                this.modelo = modelo;
            }
            
            public String getMatricula() {
                return matricula;
            }
            
            public void setMatricula(String matricula) {
                this.matricula = matricula;
            }
            
            public int getKilometros() {
                return kilometros;
            }
            
            public void setKilometros(int kilometros) {
                this.kilometros = kilometros;
            }
            
            public Date getFecha() {
                return fecha;
            }
            
            public void setFechaCompra(Date fechaCompra) {
                this.fecha = fechaCompra;
            }
            
            //Es te que reparar?
            public String isReparar() {
                if(reparar)
                    return "Si";
                            else {
                                return "No";
                }
            }
            
            public long getId() {
                return id;
            }
            
            public void setReparar(boolean reparar) {
                this.reparar = reparar;
            }
            
            @Override
            //Mostrem
            public String toString() {
                return "Id" + getId() + " - " + " Modelo: " + getModelo() +
                        " - " + " matricula: " + getMatricula() + " - " +
                        " fecha " + getFecha() + " - " + " kilometros " +
                        getKilometros() + " - " + " Reparar? " + isReparar();
            }
        
        
        
        
}