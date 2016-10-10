package manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import exception.ItemAlreadyInBaseException;
import exception.ItemNotFoundInBaseException;
import model.Etudiant;
import model.Plage;
import model.Soutenance;

public class Admin {
	List<Etudiant> etudiants;
	List<Plage> plages;
	List<Soutenance> soutenances;
	InteractBD interactBD;
	
	public InteractBD getInteractBD () {
		return this.interactBD;
	}
	
	public Admin () {
		etudiants = new ArrayList<>();
		plages = new ArrayList<>();
		soutenances = new ArrayList<>();
		interactBD = new InteractBD();
		try {
			interactBD.connect();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void ajoutEtudiant (Etudiant etudiant) throws ItemAlreadyInBaseException {
		if (!etudiants.contains(etudiant)) {
			etudiants.add(etudiant);
		}
		try {
			Statement statement = interactBD.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Etudiant where id = "+etudiant.getId());
			
			//Un appel à next() renvoie true si et seulement il y a un élément suivant 
			//Sachant qu'à la créationd du resultSet, le pointeur pointe avant la première ligne de l'ensemble
			//Donc si le premier next renvoie true, c'est que la première ligne de l'ensembe est non vide 
			//-> l'ensemble est non vide
			if (resultSet.next()) {
				throw new ItemAlreadyInBaseException();
			} else {
				String query = "insert into Etudiant values (\"";
				query += etudiant.getNom();
				query += "\",\"";
				query += etudiant.getPrenom();
				query += "\",\"";
				query += etudiant.getStatut();
				query += "\",";
				query += etudiant.getId();
				query += ");";
				statement.executeUpdate(query);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ajoutPlage (Plage plage) throws ItemAlreadyInBaseException {
		if (!plages.contains(plage)) {
			plages.add(plage);
		}
		try {
			Statement statement = interactBD.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Plage where "
					+ "jour = "+plage.getJour()
					+ " and plage = "+plage.getPlage()
					+ " and salle = "+plage.getSalle());
			
			if (resultSet.next()) {
				throw new ItemAlreadyInBaseException();
			} else {
				String query = "insert into Plage values (";
				query += plage.getJour();
				query += ",";
				query += plage.getPlage();
				query += ",";
				query += plage.getSalle();
				query += ");";
				statement.executeUpdate(query);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void ajoutSoutenance (Soutenance soutenance) throws ItemAlreadyInBaseException {
		if (!soutenances.contains(soutenance)) {
			soutenances.add(soutenance);
		}
		try {
			Statement statement = interactBD.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Soutenance where titre = '"
			+ soutenance.getTitre() + "'");
			
			if (resultSet.next()) {
				throw new ItemAlreadyInBaseException();
			} else {
				String query = "insert into Soutenance values (\"";
				query += soutenance.getTitre();
				query += "\",";
				query += soutenance.getId();
				query += ",";
				query += soutenance.getJour();
				query += ",";
				query += soutenance.getPlage();
				query += ",";
				query += soutenance.getSalle();
				query += ");";
				statement.executeUpdate(query);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void suppressionEtudiant (Etudiant etudiant) throws ItemNotFoundInBaseException {
		if (etudiants.contains(etudiant)) {
			etudiants.remove(etudiant);
		}
		
		try {
			Statement statement = interactBD.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Etudiant where id = " + etudiant.getId());
			
			if (!resultSet.next()) {
				throw new ItemNotFoundInBaseException();
			} else {
				String query = "delete from Etudiant where id = " + etudiant.getId() + ";";
				statement.executeUpdate(query);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void suppressionPlage (Plage plage) throws ItemNotFoundInBaseException {
		if (plages.contains(plage)) {
			plages.remove(plage);
		}
		
		try {
			Statement statement = interactBD.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Plage where jour = " + plage.getJour() 
			+ " and plage = " + plage.getPlage()
			+ " and salle = " + plage.getSalle() + ";");
			
			if (!resultSet.next()) {
				throw new ItemNotFoundInBaseException();
			} else {
				String query = "delete from Plage where jour = " + plage.getJour() 
				+ " and plage = " + plage.getPlage()
				+ " and salle = " + plage.getSalle() + ";";
				statement.executeUpdate(query);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void suppressionSoutenance (Soutenance soutenance) throws ItemNotFoundInBaseException {
		if (soutenances.contains(soutenance)) {
			soutenances.remove(soutenance);
		}
		
		try {
			Statement statement = interactBD.getConnection().createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Soutenance where titre = '"
			+ soutenance.getTitre() + "';");
			
			if (!resultSet.next()) {
				throw new ItemNotFoundInBaseException();
			} else {
				String query = "delete from Soutenance where titre = '" 
						+ soutenance.getTitre() + "';";
				statement.executeUpdate(query);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeBD () {
		try {
			if (interactBD.isConnected()) {
				interactBD.disconnect();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
