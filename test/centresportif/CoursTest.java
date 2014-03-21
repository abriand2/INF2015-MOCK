
package centresportif;

import java.io.IOException;
import java.util.Date;
import mock.MockFileWriterWrapper;
import mock.MockMailSender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import util.FileWriterWrapper;

public class CoursTest {
    private Cours cours;
    private MockMailSender mockMailSender;
    
    @Before
    public void setUp() {
        mockMailSender = new MockMailSender();
        cours = new Cours("Yoga", 30, mockMailSender);
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void testEnvoyerCourrielMembres() throws IOException {
        Membre m = new Membre("Scurti", "Hugo", new Date());
        Membre m2 = new Membre("Roger", "Bertrand", new Date());
        cours.ajouterMembre(m);
        cours.ajouterMembre(m2);
        String message = "Bonjour, ceci est pour vous annoncez que le cours est annulé.";
       
        FileWriterWrapper mfw = new MockFileWriterWrapper();
        mfw.write("unmessage");
        
        cours.envoyerCourrielMembres(message);
        assertEquals(2, mockMailSender.obtenirCourriels().size());
        assertEquals(message, mockMailSender.obtenirCourriels().peek().getMessage());
    }
    
}
