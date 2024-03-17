import javax.persistence.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;
    @Column
    private String login;
    @Column(name = "passwd")
    private String password;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;


    //constructors
    public User(String name, String login, String password) throws NoSuchAlgorithmException {
        this.name = name;
        this.login = login;
        this.password = getHash(password);
    }

    public User() {}

    //setters
    public void setName (String name) {
        this.name = name;
    }
    public void setLogin (String login) {
        this.login = login;
    }
    public void setPassword (String password) {
        this.password = password;
    }
    public void setRole(Role role) {this.role = role; }

    //getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public Role getRole() { return role; }


    public static String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder(bytes.length * 2);
        Formatter formatter = new Formatter(sb);
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        return sb.toString();
    }

    public static String getHash(String pass) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return bytesToHexString(md.digest(pass.getBytes()));
    }

}
