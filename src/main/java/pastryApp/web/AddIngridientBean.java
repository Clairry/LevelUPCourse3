package pastryApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pastryApp.DAO.IngridientsDAO;
import pastryApp.model.Ingridient;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class AddIngridientBean {
    private final EntityManager em;
    private final IngridientsDAO ingridientsDAO;

    public AddIngridientBean(@Autowired EntityManager em, @Autowired IngridientsDAO ingridientsDAO) {
        this.em = em;
        this.ingridientsDAO = ingridientsDAO;
    }

    public List<Ingridient> getIngridients() {return ingridientsDAO.findAllIngridients();}
}
