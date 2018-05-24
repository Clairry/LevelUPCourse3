package pastryApp.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pastryApp.model.Ingridient;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class IngridientsDAO {
    @Autowired
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Ingridient createIngridient(String name) {
        Ingridient ingridient = new Ingridient(name);

        em.persist(ingridient);

        return ingridient;
    }

    @SuppressWarnings("unchecked")
    public List<Ingridient> findAllIngridients () {return em.createQuery("from Ingridient").getResultList();}
}
