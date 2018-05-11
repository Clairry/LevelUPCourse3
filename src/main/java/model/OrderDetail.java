package model;

import javax.persistence.*;

@Entity(name = "Order_Detail")
public class OrderDetail {
    @Id
    @GeneratedValue()
    private int id;

    @Column
    private int amount;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private OrderInfo orderInfo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cake cake;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Form form;

    public OrderDetail(int amount, OrderInfo orderInfo, Cake cake, Form form) {
        this.amount = amount;
        this.orderInfo = orderInfo;
        this.cake = cake;
        this.form = form;
    }

    public OrderDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Cake getCake() {
        return cake;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }
}
