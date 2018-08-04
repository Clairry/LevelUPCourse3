package pastryApp.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pastryApp.model.Ingredient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class IngredientsDAO {
    @Autowired
    @PersistenceContext
    private EntityManager em;

    //@Secured("ADMIN")
    @Transactional
    public Ingredient createIngredient(String name) {
        Ingredient ingredient = new Ingredient(name);

        em.persist(ingredient);

        return ingredient;
    }

    @SuppressWarnings("unchecked")
    public List<Ingredient> findAllIngredients () {return em.createQuery("from Ingredient").getResultList();}
}
