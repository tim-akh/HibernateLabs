import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @ManyToMany
    @JoinTable(
            name = "roles_rights",
            joinColumns = { @JoinColumn(name = "roles_id")},
            inverseJoinColumns = { @JoinColumn(name = "rights_id")}
    )
    private Set<Right> accessList = new HashSet<Right>();

    //constructors
    public Role(String title) {
        this.title = title;
    }

    public Role() {

    }

    //setters
    public void setTitle(String title) {
        this.title = title;
    }

    //getters
    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public Set<Right> getAccessList() {
        return accessList;
    }

    public void addRight(Right right) {
        this.accessList.add(right);
    }
}
