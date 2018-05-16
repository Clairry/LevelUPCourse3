package DAO;

import model.Cake;

import javax.persistence.EntityManager;
import java.util.List;

public class CakesDAO {
    private final EntityManager em;

    public CakesDAO(EntityManager em) {
        this.em = em;
    }

    public Cake createCake(String name) {
        Cake cake = new Cake(name);

        em.persist(cake);

        return cake;
    }

    @SuppressWarnings("unchecked")
    public List<Cake> findAllCakes() {return em.createQuery("from Cake").getResultList();}
}
