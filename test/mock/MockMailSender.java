package mock;

import MailUtil.MailSender;
import java.util.Stack;


public class MockMailSender extends MailSender {
    
    protected Stack<Mail> courriels;
    
    public MockMailSender(){
        courriels = new Stack<>();
    }
    
    public Stack<Mail> obtenirCourriels(){
        return courriels;
    }
    
    @Override
    public void send(String adresse, String message) {
        courriels.add(new Mail(adresse, message));
    }
    
}
