package DAO;

import model.Ingridient;

import javax.persistence.EntityManager;
import java.util.List;

public class IngridientsDAO {
    private final EntityManager em;

    public IngridientsDAO(EntityManager em) {
        this.em = em;
    }

    public Ingridient createIngridient(String name) {
        Ingridient ingridient = new Ingridient(name);

        em.persist(ingridient);

        return ingridient;
    }

    @SuppressWarnings("unchecked")
    public List<Ingridient> findAllIngridients () {return em.createQuery("from Ingridient").getResultList();}

    public EntityManager getEm() {
        return em;
    }
}
