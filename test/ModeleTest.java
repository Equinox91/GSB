import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ModeleTest {

	@Before
	public void setUp() throws Exception {
		Modele.connect();
	}

	@Test
	public void testConnect() {
		Assert.assertNotNull("erreur", Modele.connect());
	}

	@Test
	public void testDeconnect() {
		fail("Not yet implemented");
	}
	@Test
	public void testConnexionComptable() {
		Assert.assertTrue("Connexion �chou�e",Modele.ConnexionLesComptables("jpal","btssio"));
		}
		
	}

