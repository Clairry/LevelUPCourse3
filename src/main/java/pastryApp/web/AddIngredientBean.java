package pastryApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pastryApp.DAO.IngredientsDAO;
import pastryApp.model.Ingredient;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class AddIngredientBean {
    private final EntityManager em;
    private final IngredientsDAO ingredientsDAO;

    public AddIngredientBean(@Autowired EntityManager em, @Autowired IngredientsDAO ingredientsDAO) {
        this.em = em;
        this.ingredientsDAO = ingredientsDAO;
    }

    public List<Ingredient> getIngredients() {return ingredientsDAO.findAllIngredients();}
}
