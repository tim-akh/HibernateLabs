import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;
    @Column
    private String description;
    @Column
    private float price;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    //constructors
    public Product() {}

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(float price) {
        this.price = price;
    }
    public void setGroup(Group group) {
        this.group = group;
    }

    //getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public float getPrice() {
        return price;
    }
    public Group getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return id + ": " + name + " " + price + " (" + description + ")";
    }
}
