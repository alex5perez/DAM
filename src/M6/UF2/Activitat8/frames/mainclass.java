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
package M6.UF2.Activitat8.frames;

import M6.UF2.Activitat8.coches.Coches;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/*
* File: Exercici8UF2M6.java 
* Author: Alex Pérez Rubio
* Date: 17-11-2020
* Description: Activitat 8 PRACTICA UF2 M6
*/
public class mainclass {
    
    static Scanner teclado = new Scanner(System.in);
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("$objectdb/db/coches.odb");
    static EntityManager em = emf.createEntityManager();
    
    //Mostra cotes
    public static void MostrarCoches() {
        TypedQuery<Coches> query = em.createQuery("SELECT p FROM Coches p", Coches.class);
        List<Coches> results = query.getResultList();
        for (Coches p : results) {
                System.out.println(p);
        }
    }
    
    //Mostra cotxes id
    public static void EnseñarCochesId(int id) {
        Coches vehiculo = em.find(Coches.class, id);
            System.out.println(vehiculo);
    }
    
    //Introdueix cotxes
    public static void IntroducirCoches() {
        
        boolean reparar = true;
        boolean correcto = false;
        System.out.println("Introdueix el model");
        String modelo = teclado.next();
        System.out.println("Introdueix la matricula");
        String matricula = teclado.next();
        System.out.println("Introdueix els kilometres");
        int kilometro = teclado.nextInt();
        
        //Reparacio si o no
        System.out.println("Necessita reparacio? (si, no)");
        String repararString = teclado.next();
        while (!correcto) {
            
            if(repararString.equalsIgnoreCase("si") || repararString.equalsIgnoreCase("no")) {
                
                if(repararString.equalsIgnoreCase("si")) {
                    reparar = true;
                } else {
                    reparar = false;
                }
                correcto = true;
            }else {
                System.out.println("Error, introdueix si o no");
                System.out.println("Reparacio? (si, no)");
                repararString = teclado.next();
            }
        }
        
        //Utilitzem el entitymanager de Coches
        em.getTransaction().begin();
        Coches c = new Coches(modelo, matricula, kilometro, reparar);
        em.persist(c);
        em.getTransaction().commit();
        
    }
    
    //Menu
    public static void menu() {
        System.out.println("1. Mostrar Cotxes");
        System.out.println("2. Nous Cotxes");
        System.out.println("3. Buscar Cotxes");
        System.out.println("4. Editar Cotxes");
        System.out.println("5. Eliminar Cotxes");
        System.out.println("6. Salir");
    }
    
    //Borrar cotxe
    public static void BorrarVehiculo(int id) {

		Coches vehiculo = em.find(Coches.class, id);

		em.getTransaction().begin();
		em.remove(vehiculo);
		em.getTransaction().commit();

    }
    
    //Editar els cotxes
    public static void EditarVehiculo(int id) {
        String valor;
        boolean modificar = true;
        Coches vehiculo = em.find(Coches.class, id);
        
        em.getTransaction().begin();
        System.out.println("Seleccio del camp que vols modificar ");
        String campo = teclado.next();
        
        while (modificar) {
            if (campo.equalsIgnoreCase("modelo")) {
                valor = teclado.next();
                vehiculo.setModelo(valor);
            }
            
            else if (campo.equalsIgnoreCase("matricula")) {
                valor = teclado.next();
                vehiculo.setMatricula(valor);
            }
            
            else if (campo.equalsIgnoreCase("reparar")) {
                boolean reparar;
                valor = teclado.next();
                
                if (valor.equalsIgnoreCase("Si")) {
                    reparar = true;
                }else{
                    reparar = false;
                }
                vehiculo.setReparar(reparar);
            }
            
            else if (campo.equalsIgnoreCase("matricula")) {
                int valorkm = teclado.nextInt();
                vehiculo.setKilometros(valorkm);
            }else{
                System.out.println("Camp error");
            }
            System.out.println("Vols modificar mes?");
            valor = teclado.next();
            
            if (valor.equalsIgnoreCase("Si")) {
                modificar = true;
            }else{
                modificar = false;
            }
        }
        
        em.getTransaction().commit();
    }
    
    //Main
    public static void main(String[] args) {
        int opcio;
        int id;
        boolean finalitzar = false;
        
        System.out.println("Introdueix que vols fer");
        
        while (!finalitzar) {
            menu();
            opcio = teclado.nextInt();
            
            switch (opcio) {
                
                case 1:
                    MostrarCoches();
                    break;
                
                case 2:
                    IntroducirCoches();
                    break;
                    
                case 3:
                    System.out.println("Seleccio de la id");
                    id = teclado.nextInt();
                    EnseñarCochesId(id);
                    break;
                    
                case 4:
                    System.out.println("Seleccio de la id");
                    id = teclado.nextInt();
                    EditarVehiculo(id);
                    break;
                    
                case 5:
                    System.out.println("Seleccio de la id");
                    id = teclado.nextInt();
                    BorrarVehiculo(id);
                    break;
                    
                case 6:
                    finalitzar = true;
                    break;
            }
        }
        em.close();
        emf.close();
    }
}
