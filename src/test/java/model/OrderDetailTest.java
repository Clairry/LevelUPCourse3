package model;

import org.hibernate.criterion.Order;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertNotNull;

public class OrderDetailTest {
    private EntityManagerFactory emf;
    private EntityManager em;

    @Before
    public void setup(){
        emf = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        em = emf.createEntityManager();
    }

    @After
    public void end(){
        em.close();
        emf.close();
    }

    @Test
    public void testOrderDetails(){
        Customer customer = new Customer("Ivan", "12345", "Иванов Иван Иванович", "9999999");
        OrderInfo orderInfo = new OrderInfo(customer, new GregorianCalendar(2018, Calendar.JUNE, 01));
        Cake cake = new Cake("MangoCoconut");
        Form form = new Form ("Eclipse", 1);
        OrderDetail orderDetail = new OrderDetail(1,orderInfo, cake, form);

        em.getTransaction().begin();
        try{
            em.persist(orderDetail);
        } catch (Throwable t) {
            em.getTransaction().rollback();
        } finally {
            em.getTransaction().commit();
        }

        OrderDetail found = em.find(OrderDetail.class, orderDetail.getId());
        assertNotNull(found);
        assertNotNull(found.getCake());
        assertNotNull(found.getAmount());
        assertNotNull(found.getForm());
        assertNotNull(found.getOrderInfo());
        assertNotNull(found.getOrderInfo().getCustomer());
    }
}
