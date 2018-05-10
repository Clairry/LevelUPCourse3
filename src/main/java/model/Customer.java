package model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue()
    private int id;

    @Column (nullable = false, unique = true)
    private String login;

    @Column (nullable = false)
    private String password;

    @Column (nullable = false)
    private String name;

    @Column (name = "telephone_number", nullable = false)
    private String telephoneNumber;

    @Column
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<OrderInfo> orderInfos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<OrderInfo> getOrderInfos() {
        return orderInfos;
    }

    public void setOrderInfos(List<OrderInfo> orderInfos) {
        this.orderInfos = orderInfos;
    }

    public Customer(String login, String password, String name, String telephoneNumber) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.telephoneNumber = telephoneNumber;
    }

    public Customer() {
    }
}
