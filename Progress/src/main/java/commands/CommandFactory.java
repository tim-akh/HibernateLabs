package commands;

import org.hibernate.Session;


public interface CommandFactory {
    public Command makeCommand(Session session, String[] arguments);
    public String getDescription();
    public String[] getArgsTempl();
}
