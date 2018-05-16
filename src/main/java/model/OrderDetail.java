package model;

import javax.persistence.*;
import java.util.Objects;

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

    @Column(precision = 10, scale = 2)
    private float price;

    public OrderDetail(int amount, OrderInfo orderInfo, Cake cake, Form form, float price) {
        setAmount(amount);
        this.orderInfo = orderInfo;
        this.cake = cake;
        this.form = form;
        setPrice(price);
    }

    public OrderDetail() {
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if (price < 0) throw new IllegalArgumentException("Price should't be negative");
        this.price = price;
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
        if (amount < 0) throw new IllegalArgumentException("Amount should't be negative");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return id == that.id &&
                amount == that.amount &&
                Float.compare(that.price, price) == 0 &&
                Objects.equals(orderInfo, that.orderInfo) &&
                Objects.equals(cake, that.cake) &&
                Objects.equals(form, that.form);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, amount, orderInfo, cake, form, price);
    }
}
