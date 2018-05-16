package web;

import DAO.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AddContextListener implements ServletContextListener {
    private EntityManagerFactory emf;
    private EntityManager em;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        emf = Persistence.createEntityManagerFactory("ProductionPersistenceUnit");
        em = emf.createEntityManager();

        createTestCake();

        servletContextEvent.getServletContext().setAttribute("indexBean", new IndexBean(em));
        servletContextEvent.getServletContext().setAttribute("ingridientsDao", new IngridientsDAO(em));
        servletContextEvent.getServletContext().setAttribute("addIngridientBean", new AddIngridientBean(em));
        servletContextEvent.getServletContext().setAttribute("cakePartsDAO", new CakePartsDAO(em));
        servletContextEvent.getServletContext().setAttribute("addCakePartBean", new AddCakePartBean(em));
        servletContextEvent.getServletContext().setAttribute("formsDAO", new FormsDAO(em));
        servletContextEvent.getServletContext().setAttribute("addFormBean", new AddFormBean(em));
        servletContextEvent.getServletContext().setAttribute("recipeItemsDao", new RecipeItemsDAO(em));
        servletContextEvent.getServletContext().setAttribute("addRecipeItemBean", new AddRecipeItemBean(em));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        em.close();
        emf.close();
    }

    private void createTestCake() {
        CakesDAO dao = new CakesDAO(em);

        em.getTransaction().begin();

        dao.createCake("Coconut");
        dao.createCake("Moon");

        em.getTransaction().commit();
    }
}
