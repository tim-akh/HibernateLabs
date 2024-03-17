package hibworld;

import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query;

        System.out.println("Task 1 (Выведите информацию о всех городах, расположенных в Аргентине)"); //1
        query = session.createQuery("select city from City city where city.country_code = 'ARG'");
        query.getResultList().forEach(System.out::println);
        System.out.println("------------------------------------");

        System.out.println("Task 2 (Выведите информацию о десяти наиболее населенных городах Канады)"); //2
        query = session.createQuery("select city from City city where city.country_code = 'CAN' order by city.population desc");
        query.setFirstResult(0).setMaxResults(10).getResultList().forEach(System.out::println);
        System.out.println("------------------------------------");

        System.out.println("Task 3 (Выведите информацию о всех городах, расположенных в Африке)"); //3
        query = session.createQuery("select city from City city where city.country_code.continent = 'Africa'");
        query.getResultList().forEach(System.out::println);
        System.out.println("------------------------------------");

        System.out.println("Task 4 (Выведите информацию об общей численности населения городов Монголии)"); //4
        query = session.createQuery("select sum(city.population) from City city where city.country_code = 'MNG'");
        System.out.println(query.getSingleResult());
        System.out.println("------------------------------------");

        System.out.println("Task 5 (Выведите население столицы страны, в которой расположен город \"Alexandria\")"); //5
        System.out.println("Таких две");
        query = session.createQuery("select distinct country.capital.population from City city join city.country_code as country where city = 609");
        query.getResultList().forEach(System.out::println);
        System.out.println("------------------------------------");


        session.close();
    }
}
