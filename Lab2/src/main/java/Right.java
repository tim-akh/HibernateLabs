import javax.persistence.*;

@Entity
@Table(name = "rights")
public class Right {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "right_name")
    private String right;

    //constructors
    public Right(String right) {
        this.right = right;
    }

    public Right() {

    }

    //setters
    public void setRight(String right) {
        this.right = right;
    }

    //getters
    public int getId() {
        return id;
    }
    public String getRight() {
        return right;
    }
}
