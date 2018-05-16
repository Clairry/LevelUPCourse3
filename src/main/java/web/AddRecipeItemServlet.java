package web;

import DAO.RecipeItemsDAO;
import model.Cake;
import model.CakePart;
import model.Ingridient;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/add-recipeItem")
public class AddRecipeItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String cakeId = req.getParameter("cake");
        String cakePartId = req.getParameter("cakePart");
        String ingridientId = req.getParameter("ingridient");
        String amount = req.getParameter("amount");

        RecipeItemsDAO recipeItemsDao = (RecipeItemsDAO) getServletContext().getAttribute("recipeItemsDao");
        AddRecipeItemBean addRecipeItemBean = (AddRecipeItemBean) getServletContext().getAttribute("addRecipeItemBean");

        recipeItemsDao.getEm().getTransaction().begin();

        try{
            Cake cake = addRecipeItemBean.findCake(Integer.parseInt(cakeId));
            CakePart cakePart = addRecipeItemBean.findCakePart(Integer.parseInt(cakePartId));
            Ingridient ingridient = addRecipeItemBean.findIngridient(Integer.parseInt(ingridientId));

            recipeItemsDao.createRecipeItem(cake, cakePart, ingridient, Float.parseFloat(amount));
            recipeItemsDao.getEm().getTransaction().commit();
        }
        catch (Throwable e) {
            recipeItemsDao.getEm().getTransaction().rollback();
            e.printStackTrace();

            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to insert recipe item:" + e.getMessage());
            return;
        }

        resp.sendRedirect("/addRecipeItem.jsp");
    }
}
