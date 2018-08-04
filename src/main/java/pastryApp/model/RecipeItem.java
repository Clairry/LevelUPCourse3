package pastryApp.model;

import javax.persistence.*;
import java.util.Objects;

//строки рецептуры торта
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"cake_id","cakePart_id","ingredient_id"})})
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
    private Ingredient ingredient;

    //вес в граммах
    @Column (nullable = false, precision = 10, scale = 2)
    private float amount;

    public RecipeItem(Cake cake, CakePart cakePart, Ingredient ingredient, float amount) {
        this.cake = cake;
        this.cakePart = cakePart;
        this.ingredient = ingredient;
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

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Ingredient getIngredient() {
        return ingredient;
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
                Objects.equals(ingredient, that.ingredient);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, cake, cakePart, ingredient, amount);
    }
}
