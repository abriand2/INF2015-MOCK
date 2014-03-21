package centresportif;

import MailUtil.MailSender;
import java.util.TreeMap;

public class Cours {
    
    protected String nom;
    protected int nbPlacesMax;
    protected TreeMap<String, Membre> membresInscrits;
    
    private MailSender mailSender;
    
    public Cours(String nom, int nbPlacesMax, MailSender sender) {
        this.nom = nom;
        this.nbPlacesMax = nbPlacesMax;
        membresInscrits = new TreeMap<>();
        mailSender = sender;
    }
    
    public void ajouterMembre(Membre membre) {
        membresInscrits.put(membre.obtenirNumeroMembre(), membre);
    }
    
    public void envoyerCourrielMembres(String message) {
        for (Membre m : membresInscrits.values()) {
            mailSender.send(m.obtenirAdresseCourriel(), message);
        }
    }
}
