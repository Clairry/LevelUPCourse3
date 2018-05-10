package model;

import javax.persistence.*;
import java.util.List;

@Entity (name = "Cake_Part")
public class CakePart {

    @Id
    @GeneratedValue()
    private int id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cakePart")
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

    public CakePart(String name) {
        this.name = name;
    }

    public CakePart() {
    }
}
