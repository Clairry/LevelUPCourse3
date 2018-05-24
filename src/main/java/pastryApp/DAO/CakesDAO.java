package pastryApp.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pastryApp.model.Cake;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CakesDAO {
    @Autowired
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Cake createCake(String name) {
        Cake cake = new Cake(name);

        em.persist(cake);

        return cake;
    }

    @Transactional
    public void createInitialData() {
        createCake("Coconut");
        createCake("Moon");
    }

    @SuppressWarnings("unchecked")
    public List<Cake> findAllCakes() {return em.createQuery("from Cake").getResultList();}
}
