import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;
    @Column
    private int year;
    @Column
    private float rank;

    @ManyToMany
    @JoinTable(
            name = "movies_directors",
            joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "director_id") }
    )
    private Set<Director> directors = new HashSet<Director>();


    //constructors
    public Movie() {

    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public void setRank(float rank) {
        this.rank = rank;
    }
    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }

    //getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getYear() {
        return year;
    }
    public float getRank() {
        return rank;
    }
    public Set<Director> getDirectors() {
        return directors;
    }
}
