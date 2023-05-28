package org.example.MySQLHw;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editAnimal")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Pet pet = PetDB.selectOne(id);
            if (pet!=null){
                req.setAttribute("pet",pet);
                getServletContext().getRequestDispatcher("/editAnimal.jsp").forward(req,resp);
            }
            else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(req,resp);
            }
        }catch (Exception ex){
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(req,resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("animal");
            int price = Integer.parseInt(req.getParameter("age"));
            Pet pet = new Pet(id,name,price);
            PetDB.update(pet);
            resp.sendRedirect(req.getContextPath()+"/index3");
        } catch (Exception ex){
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(req,resp);
        }
    }
}
