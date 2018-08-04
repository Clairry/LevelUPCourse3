package pastryApp.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pastryApp.model.OrderInfo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.GregorianCalendar;

@Component
public class OrderInfosDAO {
    @Autowired
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public OrderInfo createOrderInfo (String userName, Date dateOfDelivery, String telephoneOfCustomer) {
        OrderInfo orderInfo = new OrderInfo(dateOfDelivery, userName, telephoneOfCustomer);

        em.persist(orderInfo);

        return orderInfo;
    }
}
