package web;

import DAO.CakePartsDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-cakePart")
public class AddCakePartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");

        CakePartsDAO cakePartsDAO = (CakePartsDAO) getServletContext().getAttribute("cakePartsDAO");

        cakePartsDAO.getEm().getTransaction().begin();

        try{
            cakePartsDAO.CreateCakePart(name);
            cakePartsDAO.getEm().getTransaction().commit();
        }
        catch(Throwable e) {
            cakePartsDAO.getEm().getTransaction().rollback();
            e.printStackTrace();

            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to insert cake part:" + e.getMessage());
            return;
        }

        resp.sendRedirect("addCakePart.jsp");

    }
}
