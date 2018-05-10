package model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Form {
    @Id
    @GeneratedValue()
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    //коэффициент пересчет базового рецепта под конкретную форму
    @Column (nullable = false)
    private float coeff;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "form")
    private List<OrderDetail> orderDetails;

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
        this.coeff = coeff;
    }

    public Form(String name, float coeff) {
        this.name = name;
        this.coeff = coeff;
    }

    public Form() {
    }
}
