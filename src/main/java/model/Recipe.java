package model;

import javax.persistence.*;

//строки рецептуры торта
@Entity
public class Recipe {

    @Id
    @GeneratedValue()
    private int id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Cake cake;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private CakePart cakePart;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Ingridient ingridient;

    //вес в граммах
    @Column (nullable = false)
    private int amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cake getCake() {
        return cake;
    }

    public void setCake(Cake cake) {
        this.cake = cake;
    }

    public CakePart getCakePart() {
        return cakePart;
    }

    public void setCakePart(CakePart cakePart) {
        this.cakePart = cakePart;
    }

    public void setIngridient(Ingridient ingridient) {
        this.ingridient = ingridient;
    }

    public Ingridient getIngridient() {
        return ingridient;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Recipe(Cake cake, CakePart cakePart, Ingridient ingridient, int amount) {
        this.cake = cake;
        this.cakePart = cakePart;
        this.ingridient = ingridient;
        this.amount = amount;
    }

    public Recipe() {
    }
}
