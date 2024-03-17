import org.junit.Test;
import org.junit.Assert;
import javax.persistence.NoResultException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AuthTest {
    @Test
    public void Test() throws NoSuchAlgorithmException {
        DBService dbs = new DBServiceImpl();
        dbs.openConnection();

        User user1 = new User("Dave", "crunchycheetos", "qwerty");
        User user2 = new User("John", "lolkekw", "password");
        User user3 = new User("Vladimir", "zdravstvuy_te", "privet123");

        Role role1 = new Role("Administrator");
        Role role2 = new Role("Moderator");

        Right right1 = new Right("Ban User");
        Right right2 = new Right("Appoint Moderator");
        Right right3 = new Right("Restart Server");
        Right right4 = new Right("Appeal to Admin");
        Right right5 = new Right("View Log");
        Right right6 = new Right("Do Nothing");

        role1.addRight(right1);
        role1.addRight(right2);
        role1.addRight(right3);
        role1.addRight(right5);

        role2.addRight(right1);
        role2.addRight(right3);
        role2.addRight(right4);
        role2.addRight(right5);

        user1.setRole(role1);
        user2.setRole(role2);
        user3.setRole(role2);

        dbs.save(user1);
        dbs.save(user2);
        dbs.save(user3);

        dbs.save(role1);
        dbs.save(role2);

        dbs.save(right1);
        dbs.save(right2);
        dbs.save(right3);
        dbs.save(right4);
        dbs.save(right5);
        dbs.save(right6);

        Assert.assertEquals(dbs.getUser(1), user1);
        Assert.assertEquals(user1.getRole(), role1);
        Assert.assertEquals(user1.getPassword(), User.getHash("qwerty"));
        Assert.assertNotNull(dbs.readAllUsers());

        List<User> users = new ArrayList<User>();
        users.add(user3);
        Assert.assertEquals(dbs.findUserByName(user3.getName()), users);

        // с вводом почему-то не получилось, работаем с 3 пользователем
        String login = "zdravstvute";
        String password = "privet123";
        System.out.println("------------------------");
        System.out.println("Login: " + login);
        System.out.println("Password: " + password);
        try {
            User user = dbs.findUser(login, password);
            System.out.println("Authorized successfully!");
            System.out.println("Your role is: " + user.getRole().getTitle());
            System.out.println("Your rights:");
            for (Right right: user.getRole().getAccessList()) {
                System.out.println(right.getRight());
            }
            Assert.assertNotNull(user);
        }
        catch (NoResultException e) {
            System.out.println("Authorization is not possible!");
            Assert.assertTrue(false);
        }

        dbs.closeConnection();



    }
}
