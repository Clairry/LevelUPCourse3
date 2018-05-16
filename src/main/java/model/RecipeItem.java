package model;

import javax.persistence.*;
import java.util.Objects;

//строки рецептуры торта
@Entity
@NamedQueries({
        @NamedQuery(name = "SEARCH_BY_CAKE_ID", query = "from RecipeItem Where cake_id = :cakeId order by cakePart_id")
})
public class RecipeItem {

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
    @Column (nullable = false, precision = 10, scale = 2)
    private float amount;

    public RecipeItem(Cake cake, CakePart cakePart, Ingridient ingridient, float amount) {
        this.cake = cake;
        this.cakePart = cakePart;
        this.ingridient = ingridient;
        setAmount(amount);
    }

    public RecipeItem() {
    }

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

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount should't be negative");
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeItem that = (RecipeItem) o;
        return id == that.id &&
                amount == that.amount &&
                Objects.equals(cake, that.cake) &&
                Objects.equals(cakePart, that.cakePart) &&
                Objects.equals(ingridient, that.ingridient);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, cake, cakePart, ingridient, amount);
    }
}
