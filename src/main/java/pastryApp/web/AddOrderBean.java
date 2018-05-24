package pastryApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pastryApp.DAO.CartItemsDAO;
import pastryApp.DAO.OrderDetailsDAO;
import pastryApp.DAO.OrderInfosDAO;
import pastryApp.model.CartItem;

import javax.persistence.EntityManager;
import java.util.List;

@Component
public class AddOrderBean {
    private final EntityManager em;
    private final OrderDetailsDAO orderDetailsDAO;
    private final OrderInfosDAO orderInfosDAO;
    private final CartItemsDAO cartItemsDAO;

    public AddOrderBean(@Autowired EntityManager em, @Autowired OrderDetailsDAO orderDetailsDAO, @Autowired OrderInfosDAO orderInfosDAO, @Autowired CartItemsDAO cartItemsDAO) {
        this.em = em;
        this.orderDetailsDAO = orderDetailsDAO;
        this.orderInfosDAO = orderInfosDAO;
        this.cartItemsDAO = cartItemsDAO;
    }

    public List<CartItem> getCartItems() {
        return cartItemsDAO.findAllCartItems();
    }
}
