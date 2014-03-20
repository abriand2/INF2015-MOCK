package centresportif;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Membre {
    
    protected String nom;
    protected String prenom;
    protected Date dateInscription;
    protected String noMembre;
    protected String adresseCourriel;
    
    public Membre(String nom, String prenom, Date dateInscription) {        
        this.nom = nom;
        this.prenom = prenom;
        this.dateInscription = dateInscription;
        this.noMembre = genererNumeroMembre();
        this.adresseCourriel = String.format("%s.%s@centresportif.com", nom, prenom);
    }
    
    private String genererNumeroMembre() {
        SimpleDateFormat dateParser = new SimpleDateFormat("yyMMdd");
        String temp = nom.substring(0,3) + prenom.charAt(0) + 
                dateParser.format(dateInscription);
        return temp.toUpperCase();
    }
    
    public String obtenirNumeroMembre() {
        return noMembre;
    }
    
    public String obtenirAdresseCourriel() {
        return adresseCourriel;
    }
}
