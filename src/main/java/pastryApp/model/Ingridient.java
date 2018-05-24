package pastryApp.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingridient that = (Ingridient) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}
