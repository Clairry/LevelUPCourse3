package web;

import DAO.CakePartsDAO;
import model.CakePart;

import javax.persistence.EntityManager;
import java.util.List;

public class AddCakePartBean {
    private final EntityManager em;
    private final CakePartsDAO cakePartsDAO;

    public AddCakePartBean(EntityManager em) {
        this.em = em;
        cakePartsDAO = new CakePartsDAO(em);
    }

    public List<CakePart> getParts () {return cakePartsDAO.FindAllCakeParts();}
}
