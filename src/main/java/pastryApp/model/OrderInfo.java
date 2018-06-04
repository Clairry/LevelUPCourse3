package pastryApp.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity(name = "Order_Info")
public class OrderInfo {
    @Id
    @GeneratedValue()
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "orderInfo")
    private List<OrderDetail> orderDetails;

    @Column(name = "date_of_delivery")
    private Date dateOfDelivery;

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

    public OrderInfo(User user, Date dateOfDelivery) {
        this.user = user;
        this.dateOfDelivery = dateOfDelivery;
    }

    public OrderInfo(Date dateOfDelivery, String nameOfCustomer, String telephoneOfCustomer) {
        this.dateOfDelivery = dateOfDelivery;
        this.nameOfCustomer = nameOfCustomer;
        this.telephoneOfCustomer = telephoneOfCustomer;
    }

    public OrderInfo() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Date getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(Date dateOfDelivery) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderInfo orderInfo = (OrderInfo) o;
        return id == orderInfo.id &&
                isReady == orderInfo.isReady &&
                isDelivered == orderInfo.isDelivered &&
                Objects.equals(user, orderInfo.user) &&
                Objects.equals(dateOfDelivery, orderInfo.dateOfDelivery) &&
                Objects.equals(nameOfCustomer, orderInfo.nameOfCustomer) &&
                Objects.equals(telephoneOfCustomer, orderInfo.telephoneOfCustomer);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, user, dateOfDelivery, isReady, isDelivered, nameOfCustomer, telephoneOfCustomer);
    }
}
