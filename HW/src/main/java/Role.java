import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "role")
    private String role;
    @ManyToOne
    private Actor actor;

    //constructors
    public Role() {}

    //setters
    public void setRole(String role) {
        this.role = role;
    }
    public void setActor(Actor actor) {
        this.actor = actor;
    }

    //getters
    public String getRole() {
        return role;
    }
    public Actor getActor() {
        return actor;
    }

    @Override
    public String toString() {
        return "Role{"
                + "role=" + role
                + ", actor=" + actor + "}";
    }
}
