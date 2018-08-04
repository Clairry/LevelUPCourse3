package pastryApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pastryApp.DAO.CakesDAO;
import pastryApp.DAO.UsersDAO;
import pastryApp.model.Cake;
import pastryApp.model.User;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class IndexBean {
    private final EntityManager em;
    private final CakesDAO cakesDao;

    public IndexBean (@Autowired EntityManager em, @Autowired CakesDAO cakesDao) {
        this.em = em;
        this.cakesDao = cakesDao;
    }

    public List<Cake> getCakes() {return cakesDao.findAllCakes();}

    //public List<User> getUsers() {return usersDAO.findAllUsers();}
}
