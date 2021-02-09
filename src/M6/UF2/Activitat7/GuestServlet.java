//Segon tutorial amb GlassFish
package M6.UF2.Activitat7;
   /*
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.persistence.*;
import javax.servlet.annotation.WebServlet;


* File: Exercici6UF2M6.java 
* Author: Alex Pérez Rubio
* Date: 3-11-2020
* Description: Activitat 7 PRACTICA UF2 M6


@WebServlet("/GuestServlet")
public class GuestServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    @Override
    protected void doGet(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // Obtain a database connection:
        EntityManagerFactory emf =
           (EntityManagerFactory)getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
 
        try {
            // Handle a new guest (if any):
            String name = request.getParameter("name");
            if (name != null) {
                em.getTransaction().begin();
                em.persist(new Guest(name));
                em.getTransaction().commit();
            }
 
            // Display the list of guests:
            List<Guest> guestList = em.createQuery(
                "SELECT g FROM Guest g", Guest.class).getResultList();
            request.setAttribute("guests", guestList);
            request.getRequestDispatcher("/guest.jsp")
                .forward(request, response);
 
        } finally {
            // Close the database connection:
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            em.close();
        }
    }

    @Override
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
*/