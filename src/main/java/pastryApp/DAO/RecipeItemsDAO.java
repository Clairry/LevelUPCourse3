package pastryApp.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pastryApp.model.Cake;
import pastryApp.model.CakePart;
import pastryApp.model.Ingridient;
import pastryApp.model.RecipeItem;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class RecipeItemsDAO {
    @Autowired
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public RecipeItem createRecipeItem(int cakeId, int cakePartId, int ingridientId, float amount) {
        return createRecipeItem(em.find(Cake.class, cakeId), em.find(CakePart.class, cakePartId),
                                em.find(Ingridient.class, ingridientId), amount);
    }

    @Transactional
    public RecipeItem createRecipeItem(Cake cake, CakePart cakePart, Ingridient ingridient, float amount) {
        RecipeItem recipeItem = new RecipeItem(cake, cakePart, ingridient, amount);

        em.persist(recipeItem);

        return recipeItem;
    }

    @SuppressWarnings("unchecked")
    public List<RecipeItem> findRecipeItemsByCakeId (int id) {
        return em.createNamedQuery("SEARCH_BY_CAKE_ID").setParameter("cakeId", id).getResultList();
    }
}
