package web;

import DAO.IngridientsDAO;
import com.sun.net.httpserver.HttpServer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/add-ingridient")
public class AddIngridientServlet extends HttpServlet{
    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");

        IngridientsDAO ingridientsDAO = (IngridientsDAO) getServletContext().getAttribute("ingridientsDao");


        ingridientsDAO.getEm().getTransaction().begin();

        try {
            ingridientsDAO.createIngridient(name);
            ingridientsDAO.getEm().getTransaction().commit();
        }
        catch (Throwable e) {
            ingridientsDAO.getEm().getTransaction().rollback();
            e.printStackTrace();

            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to insert recipe ingridient:" + e.getMessage());
            return;
        }

        resp.sendRedirect("/addIngridient.jsp");
    }
}
