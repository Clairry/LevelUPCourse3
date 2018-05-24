package pastryApp.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pastryApp.model.CakePart;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CakePartsDAO {
    @Autowired
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public CakePart CreateCakePart (String name) {
        CakePart cakePart = new CakePart(name);

        em.persist(cakePart);

        return cakePart;
    }

    @SuppressWarnings("unchecked")
    public List<CakePart> FindAllCakeParts () {return em.createQuery("from Cake_Part").getResultList();}
}
