package pastryApp.model;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "FIND_BY_USER", query = "from CartItem where user = :user"),
        @NamedQuery(name = "FIND_BY_USER_ID_CAKE_ID_FORM_ID", query = "from CartItem where user = :user and cake_id = :cakeId and form_id = :formId")
})
public class CartItem {
    @Id
    @GeneratedValue()
    private int id;

//    @ManyToOne
//    private User user;

    @Column(nullable = false)
    private String user;

    @ManyToOne
    private Cake cake;

    @ManyToOne
    private Form form;

    @Column(precision = 10, scale = 2)
    private int amount;

    @Column(precision = 10, scale = 2)
    private float price;

    public CartItem(String user, Cake cake, Form form, int amount, float price) {
        this.user = user;
        this.cake = cake;
        this.form = form;
        setAmount(amount);
        setPrice(price);
    }

    public CartItem() {
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount should't be negative");
        this.amount = amount;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if (price < 0) throw new IllegalArgumentException("Price should't be negative");
        this.price = price;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
