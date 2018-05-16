package web;

import DAO.FormsDAO;
import model.Form;

import javax.persistence.EntityManager;
import java.util.List;

public class AddFormBean {
    private final EntityManager em;
    private final FormsDAO formsDAO;

    public AddFormBean(EntityManager em) {
        this.em = em;
        formsDAO = new FormsDAO(em);
    }

    public List<Form> getForms() {return formsDAO.findAllForms();}
}
