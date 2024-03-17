import commands.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<CommandFactory> cList = Arrays.asList(
                new CommandOne(),
                new CommandTwo(),
                new CommandThree()
        );
        Scanner in = new Scanner(System.in);
        int key = -1;
        while (key!=0){
            System.out.println("Команды:");
            System.out.println("1: Получить все товары из указанной группы");
            System.out.println("2: Найти группу для указанного товара");
            System.out.println("3: Получить товары, цена которых не превосходит заданную");
            System.out.println("Select command number (0 - exit)");
            key = in.nextInt();
            if (key == 0)
                continue;
            CommandFactory sel = cList.get(key-1);
            System.out.println(sel.getDescription());
            String [] a = sel.getArgsTempl();
            for (int i = 0; i < a.length; i++) {
                String st = in.next();
                a[i] = st;
            }
            Command q = sel.makeCommand(session, a);
            q.execute();
        }
        session.close();
        System.out.println("Stop");
        System.exit(0);

    }

}
