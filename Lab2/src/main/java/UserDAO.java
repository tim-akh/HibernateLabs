import org.hibernate.Session;

import javax.persistence.Query;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserDAO {
    private Session session;

    public UserDAO(Session session) {
        this.session = session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return session;
    }

    public void save(User user) {
        session.saveOrUpdate(user);
    }
    public void save(Role role) {
        session.saveOrUpdate(role);
    }
    public void save(Right right) {
        session.saveOrUpdate(right);
    }
    public User getUser(int id) {
        Query query = session.createQuery("select user from User user where user.id = ?1");
        query.setParameter(1, id);
        return (User) query.getSingleResult();
    }
    public List<User> findUserByName(String name) {
        Query query = session.createQuery("select user from User user where user.name = ?1");
        query.setParameter(1, name);
        return query.getResultList();
    }
    public User findUser(String login, String pass) throws NoSuchAlgorithmException {
        String hashedPass = User.getHash(pass);
        Query query = session.createQuery("select user from User user where user.login = ?1 and user.password = ?2");
        query.setParameter(1, login);
        query.setParameter(2, hashedPass);
        return (User) query.getSingleResult();
    }
    public List<Role> readAllRoles() {
        Query query = session.createQuery("select role from Role role");
        return query.getResultList();
    }
    public List<Right> readAllRights() {
        Query query = session.createQuery("select right from Right right");
        return query.getResultList();
    }
    public List<User> readAllUsers() {
        Query query = session.createQuery("select user from User user");
        return query.getResultList();
    }
}
