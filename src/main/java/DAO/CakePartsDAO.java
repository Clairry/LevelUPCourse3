package DAO;

import model.CakePart;

import javax.persistence.EntityManager;
import java.util.List;

public class CakePartsDAO {
    private final EntityManager em;

    public CakePartsDAO(EntityManager em) {
        this.em = em;
    }

    public EntityManager getEm() {
        return em;
    }

    public CakePart CreateCakePart (String name) {
        CakePart cakePart = new CakePart(name);

        em.persist(cakePart);

        return cakePart;
    }

    @SuppressWarnings("unchecked")
    public List<CakePart> FindAllCakeParts () {return em.createQuery("from Cake_Part").getResultList();}
}
