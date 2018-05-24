package pastryApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pastryApp.DAO.FormsDAO;
import pastryApp.model.Form;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class AddFormBean {
    private final EntityManager em;
    private final FormsDAO formsDAO;

    public AddFormBean(@Autowired EntityManager em, @Autowired FormsDAO formsDAO) {
        this.em = em;
        this.formsDAO = formsDAO;
    }

    public List<Form> getForms() {return formsDAO.findAllForms();}
}
