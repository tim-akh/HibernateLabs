import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @Column(name ="menu_date")
    private LocalDate date;

    @OneToMany(mappedBy = "menu")
    @OrderColumn(name = "position")
    private List<MenuItem> items = new ArrayList<MenuItem>();

    //constructors
    public Menu() {
    }

    public Menu(String title, LocalDate date) {
        this.title = title;
        this.date = date;
    }

    //setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setItems(List<MenuItem> items) {
        this.items = items;
    }

    //getters
    public long getId() {
        return id;
    }
    public String getTitle() { return title; }
    public LocalDate getDate() {
        return date;
    }
    public List<MenuItem> getItems() {
        return items;
    }

    public void addItem(MenuItem item) {
        items.add(item);
        item.setMenu(this);
    }


}
