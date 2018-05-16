package DAO;

import model.Form;

import javax.persistence.EntityManager;
import java.util.List;

public class FormsDAO {
    private final EntityManager em;

    public FormsDAO(EntityManager em) {
        this.em = em;
    }

    public EntityManager getEm() {
        return em;
    }

    public Form createForm (String name, float coeff, float price) {
        Form form = new Form(name, coeff, price);

        em.persist(form);

        return form;
    }

    @SuppressWarnings("unchecked")
    public List<Form> findAllForms() {return em.createQuery("from Form").getResultList();}
}
