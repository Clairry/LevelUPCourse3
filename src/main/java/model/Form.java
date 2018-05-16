package model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Form {
    @Id
    @GeneratedValue()
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    //коэффициент пересчет базового рецепта под конкретную форму
    @Column (nullable = false, precision = 10, scale = 2)
    private float coeff;

    @Column (nullable = false, precision = 10, scale = 2)
    private float price;

    @OneToMany(mappedBy = "form")
    private List<OrderDetail> orderDetails;

    public Form(String name, float coeff, float price) {
        this.name = name;
        setCoeff(coeff);
        setPrice(price);
    }

    public Form() {
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if (price < 0) throw new IllegalArgumentException("Price shouldn't be negative");
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCoeff() {
        return coeff;
    }

    public void setCoeff(float coeff) {
        if (coeff < 0) throw new IllegalArgumentException("Coefficient should't be negative");
        this.coeff = coeff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Form form = (Form) o;
        return id == form.id &&
                Float.compare(form.coeff, coeff) == 0 &&
                Float.compare(form.price, price) == 0 &&
                Objects.equals(name, form.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, coeff, price);
    }
}
