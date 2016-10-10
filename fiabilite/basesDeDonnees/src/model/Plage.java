package model;

public class Plage {
	private byte jour;
	private byte plage;
	private int salle;
	public byte getJour() {
		return jour;
	}
	public byte getPlage() {
		return plage;
	}
	public int getSalle() {
		return salle;
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
