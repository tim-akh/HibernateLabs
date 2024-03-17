import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "group_name")
    private String groupName;

    @OneToMany(mappedBy = "group")
    private Set<Product> products = new HashSet<Product>();

    //constructors
    public Group() {}

    //setters
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    //getters
    public int getId() {
        return id;
    }
    public String getGroupName() {
        return groupName;
    }
    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return id + ": " + groupName;
    }
}
