package manager.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exception.ItemAlreadyInBaseException;
import exception.ItemNotFoundInBaseException;
import manager.Admin;
import manager.InteractBD;
import model.Etudiant;
import model.Etudiant.Statut;
import model.Plage;
import model.Soutenance;

public class AdminTest {
	private static Admin admin;
	private Etudiant e;
	private Soutenance s;
	private Plage p;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		admin = new Admin();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		admin.closeBD();
	}
	
	@Before
	public void setUp() throws Exception {
		e = new Etudiant();
		e.setId(1);
		e.setNom("doe");
		e.setPrenom("john");
		e.setStatut(Statut.FSI);
		
		p = new Plage();
		p.setJour((byte) 1);
		p.setPlage((byte) 1);
		p.setSalle(10);
		
		s = new Soutenance();
		s.setTitre("soutenance");
		s.setId(1);
		s.setJour((byte) 1);
		s.setPlage((byte) 1);
		s.setSalle(10);
	}

	@After
	public void tearDown() throws Exception {
		admin.getInteractBD().getConnection().createStatement().executeUpdate("delete from Soutenance;");
		admin.getInteractBD().getConnection().createStatement().executeUpdate("delete from Etudiant;");
		admin.getInteractBD().getConnection().createStatement().executeUpdate("delete from Plage;");
	}

	@Test
	public void testAjoutEtudiant() throws ItemAlreadyInBaseException, SQLException {
		admin.ajoutEtudiant(e);
		
		InteractBD i = admin.getInteractBD();
		Statement statement = i.getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery("select * from Etudiant where id = 1;");
		assertTrue(resultSet.next());
		assertFalse(resultSet.next());
	}
	
	@Test(expected = ItemAlreadyInBaseException.class)
	public void testAjoutEutidantAlreadyInBase() throws ItemAlreadyInBaseException {
		admin.ajoutEtudiant(e);
		admin.ajoutEtudiant(e);
	}
	
	@Test
	public void testAjoutPlage() throws ItemAlreadyInBaseException, SQLException {
		admin.ajoutPlage(p);
		
		InteractBD i = admin.getInteractBD();
		Statement statement = i.getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery("select * from Plage where jour = 1;");
		assertTrue(resultSet.next());
		assertFalse(resultSet.next());
	}
	
	@Test(expected = ItemAlreadyInBaseException.class)
	public void testAjoutPlageAlreadyInBase() throws ItemAlreadyInBaseException {
		admin.ajoutPlage(p);
		admin.ajoutPlage(p);
	}
	
	@Test
	public void testAjoutSoutenance() throws ItemAlreadyInBaseException, SQLException {
		admin.ajoutEtudiant(e);
		admin.ajoutPlage(p);
		admin.ajoutSoutenance(s);
		
		InteractBD i = admin.getInteractBD();
		Statement statement = i.getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery("select * from Soutenance where titre = 'soutenance';");
		assertTrue(resultSet.next());
		assertFalse(resultSet.next());
	}
	
	@Test(expected = ItemAlreadyInBaseException.class)
	public void testSoutenancePlageAlreadyInBase() throws ItemAlreadyInBaseException {
		admin.ajoutEtudiant(e);
		admin.ajoutPlage(p);
		admin.ajoutSoutenance(s);
		admin.ajoutSoutenance(s);
	}
	
	@Test
	public void testSuppressionEtudiant() throws ItemNotFoundInBaseException, SQLException, ItemAlreadyInBaseException {
		admin.ajoutEtudiant(e);
		InteractBD i = admin.getInteractBD();
		Statement statement = i.getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery("select * from Etudiant where id = 1;");
		assertTrue(resultSet.next());
		assertFalse(resultSet.next());
		
		admin.suppressionEtudiant(e);
		i = admin.getInteractBD();
		statement = i.getConnection().createStatement();
		resultSet = statement.executeQuery("select * from Etudiant where id = 1;");
		assertFalse(resultSet.next());
	}
	
	@Test(expected = ItemNotFoundInBaseException.class)
	public void testSuppressionEtudiantItemNotFoundInBaseException() throws ItemAlreadyInBaseException, ItemNotFoundInBaseException {
		admin.ajoutEtudiant(e);
		admin.suppressionEtudiant(e);
		admin.suppressionEtudiant(e);
	}
	
	@Test
	public void testSuppressionPlage() throws ItemNotFoundInBaseException, SQLException, ItemAlreadyInBaseException {
		admin.ajoutPlage(p);
		InteractBD i = admin.getInteractBD();
		Statement statement = i.getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery("select * from Plage where jour = 1;");
		assertTrue(resultSet.next());
		assertFalse(resultSet.next());
		
		admin.suppressionPlage(p);
		i = admin.getInteractBD();
		statement = i.getConnection().createStatement();
		resultSet = statement.executeQuery("select * from Plage where jour = 1;");
		assertFalse(resultSet.next());
	}
	
	@Test(expected = ItemNotFoundInBaseException.class)
	public void testSuppressionPlageItemNotFoundInBaseException() throws ItemAlreadyInBaseException, ItemNotFoundInBaseException {
		admin.ajoutPlage(p);
		admin.suppressionPlage(p);
		admin.suppressionPlage(p);
	}
	
	@Test
	public void testSuppressionSoutenance() throws ItemNotFoundInBaseException, SQLException, ItemAlreadyInBaseException {
		admin.ajoutSoutenance(s);
		InteractBD i = admin.getInteractBD();
		Statement statement = i.getConnection().createStatement();
		ResultSet resultSet = statement.executeQuery("select * from Soutenance where titre = 'soutenance';");
		assertTrue(resultSet.next());
		assertFalse(resultSet.next());
		
		admin.suppressionSoutenance(s);
		i = admin.getInteractBD();
		statement = i.getConnection().createStatement();
		resultSet = statement.executeQuery("select * from Soutenance where titre = 'soutenance';");
		assertFalse(resultSet.next());
	}
	
	@Test(expected = ItemNotFoundInBaseException.class)
	public void testSuppressionSoutenanceItemNotFoundInBaseException() throws ItemAlreadyInBaseException, ItemNotFoundInBaseException {
		admin.ajoutSoutenance(s);
		admin.suppressionSoutenance(s);
		admin.suppressionSoutenance(s);
	}
}
