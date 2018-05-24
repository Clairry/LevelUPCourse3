package pastryApp.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pastryApp.model.Cake;
import pastryApp.model.Form;
import pastryApp.model.OrderDetail;
import pastryApp.model.OrderInfo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class OrderDetailsDAO {
    @Autowired
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public OrderDetail createOrderDetail (int amount, OrderInfo orderInfo, Cake cake, Form form, float price) {
        OrderDetail orderDetail = new OrderDetail(amount, orderInfo, cake, form, price);

        em.persist(orderDetail);

        return orderDetail;
    }
}
