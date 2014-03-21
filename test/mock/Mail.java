package mock;

public class Mail {
    protected String adresse;
    protected String message;
    
    public Mail(String adresse, String message) {
        this.adresse = adresse;
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
    
}
