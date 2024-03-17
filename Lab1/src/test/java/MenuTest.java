import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class MenuTest {

    @Test
    public void Test() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<MenuItem> items = new ArrayList<MenuItem>();

        MenuItem item1 = new MenuItem("Pizza", 45.0, 3, 8, 6, 5);
        MenuItem item2 = new MenuItem("Risotto", 154.0, 7, 4, 8, 2);
        MenuItem item3 = new MenuItem("Ravioli", 120.0, 2, 6, 10, 3);

        items.add(item1);
        items.add(item2);
        items.add(item3);

        session.save(item1);
        session.save(item2);
        session.save(item3);

        Menu menu = new Menu("Italian", LocalDate.now());

        menu.addItem(item1);
        menu.addItem(item2);
        menu.addItem(item3);

        session.save(menu);

        Assert.assertEquals(items, menu.getItems());

        session.getTransaction().commit();
        session.close();

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Menu load = (Menu) session.load(Menu.class, 1L);

        MenuItem newItem = new MenuItem("Added item", 1.0, 1, 1, 1, 1);
        session.save(newItem);

        load.addItem(newItem);

        Assert.assertEquals(4, load.getItems().size());

        session.save(load);

        session.getTransaction().commit();
        session.close();

    }

}