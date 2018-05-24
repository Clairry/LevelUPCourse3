package pastryApp.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pastryApp.model.User;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class UsersDAO {
    @Autowired
    private EntityManager em;

    @Transactional
    public User createUser(String login, String password, String name, String telephoneNumber) {
        User user = new User (login, password, name, telephoneNumber);

        em.persist(user);

        return user;
    }

    @SuppressWarnings("unchecked")
    public User findUserByName (String userName) {
        return (User) em.createNamedQuery("FIND_USER_BY_NAME").setParameter("userName", userName).getSingleResult();
    }

    public List<User> findAllUsers () {
        return em.createQuery("from User").getResultList();
    }
}
