package commands;

import org.hibernate.Session;

import javax.persistence.Query;

public class CommandTwo implements Command, CommandFactory{
    private Session session;
    private String arg1;
    
    @Override
    public void execute() {
       System.out.println("Execute second command with " + arg1);
        Query query = session.createQuery("select product.group from Product product where product.name = ?1 or product.id = ?1");
        query.setParameter(1, arg1);
        query.getResultList().forEach(System.out::println);
    }

    public CommandTwo(Session session, String arg1) {
        this.session = session;
        this.arg1 = arg1;
    }

    public CommandTwo() {        
    }    
    
    @Override
    public Command makeCommand(Session session, String[] arguments) {
        return new CommandTwo(session, arguments[0]);
    }

    @Override
    public String getDescription() {
        return "Enter arg for second command ...";
    }

    @Override
    public String[] getArgsTempl() {
        String[] args = {""};
        return args;
    }
}
