import org.hibernate.Session;
import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Query query;

        System.out.println("Task 1"); //1
        query = session.createQuery("select new list(movie.name, movie.year, movie.directors.size) from Movie movie");
        for (Object o: query.getResultList()) {
            System.out.println(o);
        }
        System.out.println("------------------------------");

        System.out.println("Task 2"); //2
        query = session.createQuery("select movie.directors from Movie movie where movie.year >= ?1 and movie.year <= ?2");
        query.setParameter(1, 1980);
        query.setParameter(2, 1989);
        List<Director> dirs = query.getResultList();
        for (Director d: dirs) {
            System.out.println(d.getId() + ": " + d.getFirstName() + " " + d.getLastName());
        }
        System.out.println("------------------------------");

        CriteriaBuilder builder = session.getCriteriaBuilder();

        Root<Movie> root;
        List<Movie> movies;

        System.out.println("Task 3"); //3
        CriteriaQuery<Movie> movieCriteria_3 = builder.createQuery(Movie.class);
        root = movieCriteria_3.from(Movie.class);
        movieCriteria_3.select(root);
        movieCriteria_3.where(builder.and(builder.ge(root.<Number>get("year"), 1995)), builder.le(root.<Number>get("year"), 2000));
        movies = session.createQuery(movieCriteria_3).getResultList();
        for (Movie m: movies) {
            System.out.println(m.getId() + ": " + m.getName() + ", " + m.getYear() + ", " + m.getRank());
        }
        System.out.println("------------------------------");

        System.out.println("Task 4"); //4
        CriteriaQuery<Double> doubleCriteria = builder.createQuery(Double.class);
        root = doubleCriteria.from(Movie.class);
        Join<Movie, Director> director_4 = root.join("directors");
        doubleCriteria.select(builder.avg(root.<Number>get("rank")));
        doubleCriteria.where(builder.equal(director_4.get("firstName"), "David"));
        Double avg_rank = session.createQuery(doubleCriteria).getSingleResult();
        System.out.println("Average rank: " + avg_rank);
        System.out.println("------------------------------");

        System.out.println("Task 5"); //5
        CriteriaQuery<String> stringCriteria = builder.createQuery(String.class);
        root = stringCriteria.from(Movie.class);
        Join<Movie, Director> director_5 = root.join("directors");
        stringCriteria.select(director_5.<String>get("lastName"));
        stringCriteria.where(builder.and(builder.gt(root.<Number>get("year"), 2000), builder.isNotNull(root.get("rank"))));
        List<String> lastNames = session.createQuery(stringCriteria).getResultList();
        for (String ln: lastNames) {
            System.out.println(ln);
        }
        System.out.println("------------------------------");

        session.getTransaction().commit();
        session.close();
    }
}
