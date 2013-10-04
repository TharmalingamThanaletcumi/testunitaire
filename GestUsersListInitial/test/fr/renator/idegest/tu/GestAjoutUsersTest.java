package fr.renator.idegest.tu;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.text.Normalizer;

import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import fr.renater.idegest.tu.GestAjoutUsers;

public class GestAjoutUsersTest extends TestCase  {

	/** l'OUT */
	private GestAjoutUsers gau;                           // 1

	@Before
	protected void setUp() throws Exception {
		try {
			this.gau = new GestAjoutUsers("testusers.xml");   // 2
		} catch (IOException e) {
			fail("Création de l'OUT impossible !");
		}
	}

	@Test
	public void test2PremiersCarsGenUid() {
		String uid = this.gau.genUid("Bob", "Martin"); // 3 

		uid = uid.substring(0, 2).toLowerCase();
		assertTrue("Les 2 premiers caractères sont valides", uid.equals("bm"));  // 4
	}

	@Test
	public void test2PremiersCarsGenUidBis() {
		String uid = this.gau.genUid("Bob","Martin");
		System.out.println(uid);// 1
		String premscar = uid.substring(0, 2).toLowerCase();
		System.out.println(premscar);
		// 2
		assertEquals("Les 2 premiers caractères sont valides", "bm", premscar); // 3
	}

	/**
	 * L'uid obtenu est tout en minuscule
	 */

	@Test
	public void testidminuscule() {
		String uid = this.gau.genUid("Bob", "Martin");
		String idmin = uid.toLowerCase();
		assertEquals("l'uid obtenu est tout en minuscule", "bmartin", idmin);
	}

	/**
	 * L'uid obtenu est composé au minimum de 5 caractères et maximum de 9 
	 * (première lettre du prénom suivi de premières lettres du nom - si possible)
	 */

	@Test 
	public void testmin(){
		String uid = this.gau.genUid("Bob", "sonyiii");
		String min =uid.substring(0, 5).toLowerCase();

		assertEquals("l'uid obtenu est tout en minuscule", "bsony", min);	  
	}

	public void testmax(){
		String uid = this.gau.genUid("Bob", "koooooousgfdgf");
		String max =uid.substring(0, 9).toLowerCase();

		assertEquals("l'uid obtenu est tout en minuscule", "bkoooooou", max);	  
	}
	/**
	 * L'uid ne contient pas de caractères indésirables ({}/~…) 
	 * ni accent ou apostrohe, guillemet… 
	 * (conseil : faire une proposition dans une logique inverse)
	 */

	@Test
	public void testcarindesirables(){
		String uid = this.gau.genUid("Bob", "jonathééénna");
		uid=uid.toLowerCase();
		/**
		 * Normalizer.normalize(uid, Normalizer.Form.NFD);
		 *  This will separate all of the accent marks from the characters.
		 *  car.replaceAll("[^\\p{ASCII}]", "");
		 *  Then, you just need to compare each character against being a letter 
		 *  and throw out the ones that aren't.

		 */
		String car =  Normalizer.normalize(uid, Normalizer.Form.NFD);
		car = car.replaceAll("[^\\p{ASCII}]", "");
		
		assertEquals("l'uid obtenu est tout en minuscule", "bjonatheeenna", car);
	}

	/**
	 * L'ajout de plus d'un utilisateur avec même nom et même première lettre de prénom génère des UIDs différents. La méthode à tester est addUser.
	 */

}
