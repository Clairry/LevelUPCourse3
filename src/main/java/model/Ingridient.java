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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ingridient")
    private List<Recipe> recipes;

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

    public Ingridient(String name) {
        this.name = name;
    }

    public Ingridient() {
    }
}
