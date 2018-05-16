package DAO;

import model.Cake;
import model.CakePart;
import model.Ingridient;
import model.RecipeItem;

import javax.persistence.EntityManager;
import java.util.List;

public class RecipeItemsDAO {
    private final EntityManager em;

    public RecipeItemsDAO(EntityManager em) {
        this.em = em;
    }

    public EntityManager getEm() {
        return em;
    }

    public RecipeItem createRecipeItem(Cake cake, CakePart cakePart, Ingridient ingridient, float amount) {
        RecipeItem recipeItem = new RecipeItem(cake, cakePart, ingridient, amount);

        em.persist(recipeItem);

        return recipeItem;
    }

    @SuppressWarnings("unchecked")
    public List<RecipeItem> findRecipeItemsByCakeId (Integer id) {
        return em.createNamedQuery("SEARCH_BY_CAKE_ID").setParameter("cakeId", id).getResultList();
    }
}
