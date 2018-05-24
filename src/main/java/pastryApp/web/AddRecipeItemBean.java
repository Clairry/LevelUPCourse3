package pastryApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pastryApp.DAO.RecipeItemsDAO;
import pastryApp.model.Cake;
import pastryApp.model.CakePart;
import pastryApp.model.Ingridient;
import pastryApp.model.RecipeItem;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class AddRecipeItemBean {
    private final EntityManager em;
    private final RecipeItemsDAO recipeItemsDAO;

    public AddRecipeItemBean(@Autowired EntityManager em, @Autowired RecipeItemsDAO recipeItemsDAO) {
        this.em = em;
        this.recipeItemsDAO = recipeItemsDAO;
    }

    public List<RecipeItem> getRecipeItems (Integer cakeId) {
        return recipeItemsDAO.findRecipeItemsByCakeId(cakeId);
    }

    @SuppressWarnings("unchecked")
    public List<Cake> getCakes() {return em.createQuery("from Cake").getResultList();}

    @SuppressWarnings("unchecked")
    public List<CakePart> getCakeParts() {return em.createQuery("from Cake_Part").getResultList();}

    @SuppressWarnings("unchecked")
    public List<Ingridient> getIngridients() {return em.createQuery("from Ingridient").getResultList();}

    @SuppressWarnings("unchecked")
    public List<RecipeItem> getRecipeItems() {return em.createQuery("from RecipeItem").getResultList();}
}
