package centresportif;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.FileWriterWrapper;

/**
 * 
 * Cette classe permet de générer des rapports concernant un cours donné.
 */
public class Rapport {
    private FileWriterWrapper fileWriter;
    protected Cours cours;
    
    public Rapport(Cours cours) {
        try {
            this.cours = cours;
            this.fileWriter = new FileWriterWrapper(new FileWriter(""));
        } catch (IOException ex) {
            Logger.getLogger(Rapport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void genererRapport() throws IOException {
        String rapport = String.format("Cours : %s\n", cours.nom);
        rapport += String.format("Nombre de places : %s\n", cours.nbPlacesMax);
        if (cours.membresInscrits.size() == 0) {
            rapport += "Aucun membre n'est inscrit au cours";
        } else {
            rapport += "Membres inscrits : \n";
            for (Membre m : cours.membresInscrits.values()) {
                rapport += String.format("-%s %s\n", m.prenom + m.nom);
            }
        }
        fileWriter.write(rapport);
    }
}
