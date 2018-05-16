package model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name = "Cake_Part")
public class CakePart {

    @Id
    @GeneratedValue()
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cakePart")
    private List<RecipeItem> recipeItems;

    public CakePart(String name) {
        this.name = name;
    }

    public CakePart() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CakePart cakePart = (CakePart) o;
        return id == cakePart.id &&
                Objects.equals(name, cakePart.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}
