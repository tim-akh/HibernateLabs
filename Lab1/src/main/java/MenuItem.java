import javax.persistence.*;

@Entity
@Table(name = "menuitem")
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private double price;
    @Column
    private int fat;
    @Column
    private int calories;
    @Column
    private int carbohydrates;
    @Column
    private int protein;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    //constructors
    public MenuItem() {
    }

    public MenuItem(String name, double price, int fat, int calories, int carbohydrates, int protein) {
        this.name = name;
        this.price = price;
        this.fat = fat;
        this.calories = calories;
        this.carbohydrates = carbohydrates;
        this.protein = protein;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setFat(int fat) {
        this.fat = fat;
    }
    public void setCalories(int calories) {
        this.calories = calories;
    }
    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }
    public void setProtein(int protein) {
        this.protein = protein;
    }
    public void setMenu(Menu menu) { this.menu = menu; }

    //getters
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getFat() {
        return fat;
    }
    public int getCalories() {
        return calories;
    }
    public int getCarbohydrates() {
        return carbohydrates;
    }
    public int getProtein() {
        return protein;
    }
    public Menu getMenu() { return menu; }
}
