package org.example.MySQLHw;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/createAnimal")
public class CreateServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/createAnimal.jsp").forward(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String animal = req.getParameter("animal");
            int age = Integer.parseInt(req.getParameter("age"));
            Pet pet = new Pet(animal,age);
            PetDB.insert(pet);
            resp.sendRedirect(req.getContextPath()+"/index3");
        }
        catch (Exception e){
            getServletContext().getRequestDispatcher("/createAnimal.jsp").forward(req,resp);
        }
    }
}
