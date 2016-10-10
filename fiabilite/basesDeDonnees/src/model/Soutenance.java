package model;

public class Soutenance {
	private String titre;
	private int id;
	private byte jour;
	private byte plage;
	private int salle;
	public String getTitre() {
		return titre;
	}
	public int getId() {
		return id;
	}
	public byte getJour() {
		return jour;
	}
	public byte getPlage() {
		return plage;
	}
	public int getSalle() {
		return salle;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setJour(byte jour) {
		this.jour = jour;
	}
	public void setPlage(byte plage) {
		this.plage = plage;
	}
	public void setSalle(int salle) {
		this.salle = salle;
	}
}
