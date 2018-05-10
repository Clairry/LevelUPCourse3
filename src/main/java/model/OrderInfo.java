package model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Entity(name = "Order_Info")
public class OrderInfo {
    @Id
    @GeneratedValue()
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Customer customer;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "orderInfo")
    private List<OrderDetail> orderDetails;

    @Column(name = "date_of_delivery")
    private GregorianCalendar dateOfDelivery;

    //торт сделан (метка для кондитера)
    @Column(name = "is_ready")
    @ColumnDefault("0")
    private boolean isReady;

    //торт отдан заказчику
    @Column(name = "is_delivered")
    @ColumnDefault("0")
    private boolean isDelivered;

    //на случай, если заказ делает человек, не зарегистрированный в системе
    @Column(name = "name_of_customer")
    private String nameOfCustomer;

    @Column(name = "telephone_of_customer")
    private String telephoneOfCustomer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public GregorianCalendar getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(GregorianCalendar dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    public boolean isDelivered() {
        return isDelivered;
    }

    public void setDelivered(boolean delivered) {
        isDelivered = delivered;
    }

    public String getNameOfCustomer() {
        return nameOfCustomer;
    }

    public void setNameOfCustomer(String nameOfCustomer) {
        this.nameOfCustomer = nameOfCustomer;
    }

    public String getTelephoneOfCustomer() {
        return telephoneOfCustomer;
    }

    public void setTelephoneOfCustomer(String telephoneOfCustomer) {
        this.telephoneOfCustomer = telephoneOfCustomer;
    }

    public OrderInfo(Customer customer, GregorianCalendar dateOfDelivery) {
        this.customer = customer;
        this.dateOfDelivery = dateOfDelivery;
    }

    public OrderInfo(GregorianCalendar dateOfDelivery, boolean isReady, boolean isDelivered, String nameOfCustomer, String telephoneOfCustomer) {
        this.dateOfDelivery = dateOfDelivery;
        this.nameOfCustomer = nameOfCustomer;
        this.telephoneOfCustomer = telephoneOfCustomer;
    }

    public OrderInfo() {
    }
}
