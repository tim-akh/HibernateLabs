import java.util.List;

public interface DBService {
     void save(User user);
     void save(Role role);
     void save(Right right);
     User getUser(int id);
     List<User> findUserByName(String name);
     User findUser(String login, String pass);
     List<Role> readAllRoles();
     List<Right> readAllRights();
     List<User> readAllUsers();
     void openConnection();
     void closeConnection();

}
