package pastryApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pastryApp.DAO.CartItemsDAO;
import pastryApp.model.Cake;
import pastryApp.model.CartItem;
import pastryApp.model.Form;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class AddCartItemBean {
    private final EntityManager em;
    private final CartItemsDAO cartItemsDAO;

    public AddCartItemBean(@Autowired EntityManager em, @Autowired CartItemsDAO cartItemsDAO) {
        this.em = em;
        this.cartItemsDAO = cartItemsDAO;
    }

//    public List<CartItem> getCartItems (int userId) {
//        return cartItemsDAO.findCartItemsForUser(userId);
//    }

    public List<CartItem> getCartItems() {
        return cartItemsDAO.findAllCartItems();
    }

    @SuppressWarnings("unchecked")
    public List<Cake> getCakes() {return em.createQuery("from Cake").getResultList();}

    @SuppressWarnings("unchecked")
    public List<Form> getForms() {return em.createQuery("from Form").getResultList();}
}
