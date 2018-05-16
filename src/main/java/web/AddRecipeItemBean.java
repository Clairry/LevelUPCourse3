package web;

import DAO.RecipeItemsDAO;
import model.Cake;
import model.CakePart;
import model.Ingridient;
import model.RecipeItem;

import javax.persistence.EntityManager;
import java.util.List;

public class AddRecipeItemBean {
    private final EntityManager em;
    private final RecipeItemsDAO recipeItemsDAO;

    public AddRecipeItemBean(EntityManager em) {
        this.em = em;
        recipeItemsDAO = new RecipeItemsDAO(em);
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

    public Cake findCake (Integer id) {return em.find(Cake.class, id);}

    public CakePart findCakePart (Integer id) {return em.find(CakePart.class, id);}

    public Ingridient findIngridient (Integer id) {return em.find(Ingridient.class, id);}
}
