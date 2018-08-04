package pastryApp.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pastryApp.model.Form;
import pastryApp.repository.FormsRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class FormsDAO {
    @Autowired
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private FormsRepository repository;

    @Transactional
    public Form createForm (String name, float coeff, float price) {
        Form form = new Form(name, coeff, price);

        em.persist(form);

        return form;
    }

    @SuppressWarnings("unchecked")
    public List<Form> findAllForms() {return repository.findAll();}
}
