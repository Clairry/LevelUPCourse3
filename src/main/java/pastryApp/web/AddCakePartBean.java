package pastryApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pastryApp.DAO.CakePartsDAO;
import pastryApp.model.CakePart;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class AddCakePartBean {
    private final EntityManager em;
    private final CakePartsDAO cakePartsDAO;

    public AddCakePartBean(@Autowired EntityManager em, @Autowired CakePartsDAO cakePartsDAO) {
        this.em = em;
        this.cakePartsDAO = cakePartsDAO;
    }

    public List<CakePart> getParts () {return cakePartsDAO.FindAllCakeParts();}
}
