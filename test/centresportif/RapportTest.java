package centresportif;

import MailUtil.MailSender;
import java.util.Date;
import mock.MockFileWriterWrapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RapportTest {
    
    private Rapport rapport;
    private Cours cours;
    //private MockFileWriterWrapper writerWrapper;
    
    @Before
    public void setUp() {
        cours = new Cours("Yoga", 30);
     //   writerWrapper = new MockFileWriterWrapper();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGenererRapportAucunMembre() throws Exception {
        rapport = new Rapport(cours);
        rapport.genererRapport();
        String expected = "Cours : Yoga\n" +
                "Nombre de places : 30\n" + 
                "Aucun membre n'est inscrit au cours";
        //assertEquals(expected, writerWrapper.getText());
    }
    
    @Test
    public void testGenererRapport2Membres() throws Exception {
        cours.ajouterMembre(new Membre("Scurti", "Hugo", new Date()));
        cours.ajouterMembre(new Membre("Bertrand", "Roger", new Date()));
        String expected = "Cours : Yoga\n" +
                "Nombre de places : 30\n" + 
                "Membres inscrits : \n" + 
                "-Hugo Scurti\n" + 
                "-Roger Bertrand\n";
        
        rapport = new Rapport(cours);
        
    }
}