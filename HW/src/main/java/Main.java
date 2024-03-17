import org.hibernate.Session;

import javax.persistence.criteria.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();


        session.getTransaction().commit();
        session.close();
    }
}
