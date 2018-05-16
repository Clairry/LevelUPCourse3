package model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Cake {
    @Id
    @GeneratedValue()
    private int id;

    @Column (nullable = false, unique = true)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "cake")
    private List<RecipeItem> recipeItems;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, mappedBy = "cake")
    private List<OrderDetail> orderDetails;

    public Cake(String name) {
        this.name = name;}

    public Cake() {
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

    public List<RecipeItem> getRecipeItems() {
        return recipeItems;
    }

    public void setRecipeItems(List<RecipeItem> recipeItems) {
        this.recipeItems = recipeItems;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cake cake = (Cake) o;
        return id == cake.id &&
                Objects.equals(name, cake.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}
