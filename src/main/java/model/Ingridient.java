package model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Ingridient {

    @Id
    @GeneratedValue()
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "ingridient")
    private List<RecipeItem> recipeItems;

    public Ingridient(String name) {
        this.name = name;
    }

    public Ingridient() {
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
}
