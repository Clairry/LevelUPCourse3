package web;

import DAO.FormsDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/add-form")
public class AddFormServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        Float coeff = Float.parseFloat(req.getParameter("coeff"));
        Float price = Float.parseFloat(req.getParameter("price"));

        FormsDAO formsDAO = (FormsDAO) getServletContext().getAttribute("formsDAO");

        formsDAO.getEm().getTransaction().begin();

        try{
            formsDAO.createForm(name, coeff, price);
            formsDAO.getEm().getTransaction().commit();
        }
        catch (Throwable e) {
            formsDAO.getEm().getTransaction().rollback();
            e.printStackTrace();

            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to insert form:" + e.getMessage());
            return;
        }

        resp.sendRedirect("/addForm.jsp");

    }
}
