package pastryApp.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pastryApp.model.Cake;
import pastryApp.model.CartItem;
import pastryApp.model.Form;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CartItemsDAO {
    @Autowired
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public CartItem createCartItem(String user, Cake cake, Form form, int amount, float price) {
        CartItem cartItem = new CartItem(user, cake, form, amount, price);

        em.persist(cartItem);

        return cartItem;
    }

    @Transactional
    public CartItem createCartItem(String user, int cakeId, int formId, int amount) {
        float price = em.find(Form.class, formId).getPrice();

        return createCartItem(user, em.find(Cake.class, cakeId), em.find(Form.class, formId), amount, price*amount);
    }

    @SuppressWarnings("unchecked")
    public List<CartItem> findCartItemsForUser (String user) {
        return em.createNamedQuery("FIND_BY_USER").setParameter("user", user).getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<CartItem> findCartItemsForUserCakeForm (String user, int cakeId, int formId) {
        return em.createNamedQuery("FIND_BY_USER_ID_CAKE_ID_FORM_ID")
                                .setParameter("user", user)
                                .setParameter("cakeId", cakeId)
                                .setParameter("formId", formId)
                                .getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<CartItem> findAllCartItems () {
        return em.createQuery("from CartItem").getResultList();
    }

    @Transactional
    public void deleteCartItemForUser(String user) {
      List<CartItem> cartItemForDelete = findCartItemsForUser(user);

        for (CartItem cartItem : cartItemForDelete) {
            em.remove(cartItem);
        }
    }

    @Transactional
    public CartItem updateCartItem(CartItem cartItem) {
        return em.merge(cartItem);
    }
 }
