package M6.UF2.Activitat5.entity;
// Generated 30-ene-2021 17:44:43 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Partida generated by hbm2java
 */
public class Partida  implements java.io.Serializable {


     private int id;
     private Date data;
     private char guanyador;

    public Partida() {
    }

    public Partida(int id, Date data, char guanyador) {
       this.id = id;
       this.data = data;
       this.guanyador = guanyador;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Date getData() {
        return this.data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }
    public char getGuanyador() {
        return this.guanyador;
    }
    
    public void setGuanyador(char guanyador) {
        this.guanyador = guanyador;
    }




}

