package web;

import DAO.IngridientsDAO;
import model.Ingridient;

import javax.persistence.EntityManager;
import java.util.List;

public class AddIngridientBean {
    private final EntityManager em;
    private final IngridientsDAO ingridientsDao;

    public AddIngridientBean(EntityManager em) {
        this.em = em;
        ingridientsDao = new IngridientsDAO(em);
    }

    public List<Ingridient> getIngridients() {return ingridientsDao.findAllIngridients();}
}
