package model;

public class Etudiant {
	
	public enum Statut{
		FSI,ISL
	}
	
	private String nom;
	private String prenom;
	private Statut statut;
	private int id;
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public Statut getStatut() {
		return statut;
	}
	public int getId() {
		return id;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setStatut(Statut statut) {
		this.statut = statut;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
