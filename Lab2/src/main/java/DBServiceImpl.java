import java.security.NoSuchAlgorithmException;
import java.util.List;

public class DBServiceImpl implements DBService {

    private UserDAO userDAO;

    public DBServiceImpl() {
        userDAO = new UserDAO(HibernateUtil.getSessionFactory().openSession());
    }

    public void save(User user) {
        userDAO.save(user);
    }
    public void save(Role role) {
        userDAO.save(role);
    }
    public void save(Right right) {
        userDAO.save(right);
    }
    public User getUser(int id) {
        return userDAO.getUser(id);
    }
    public List<User> findUserByName(String name) {
        return userDAO.findUserByName(name);
    }
    public User findUser(String login, String pass) {
        try {
            return userDAO.findUser(login, pass);
        }
        catch (NoSuchAlgorithmException e) {
            System.out.println(e);
            return null;
        }
    }
    public List<Role> readAllRoles() {
        return userDAO.readAllRoles();
    }
    public List<Right> readAllRights() {
        return userDAO.readAllRights();
    }
    public List<User> readAllUsers() {
        return userDAO.readAllUsers();
    }
    public void openConnection() {
        userDAO.getSession().beginTransaction();
    }
    public void closeConnection() {
        userDAO.getSession().getTransaction().commit();
        userDAO.getSession().close();
    }
}
