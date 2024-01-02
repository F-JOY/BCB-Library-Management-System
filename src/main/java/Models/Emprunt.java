package Models;

import java.util.Date;

public class Emprunt {
	private int id_emprunt;
    private Date date_debut;
    private Date date_restitution;
    private Abonné abonne;
    private Ouvrage ouvrage;
	public Emprunt() {
	}
	public Emprunt(int id_emprunt, Date date_debut, Date date_restitution, Abonné abonne, Ouvrage ouvrage) {
		
		this.id_emprunt = id_emprunt;
		this.date_debut = date_debut;
		this.date_restitution = date_restitution;
		this.abonne = abonne;
		this.ouvrage = ouvrage;
	}
	public int getId_emprunt() {
		return id_emprunt;
	}
	public void setId_emprunt(int id_emprunt) {
		this.id_emprunt = id_emprunt;
	}
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public Date getDate_restitution() {
		return date_restitution;
	}
	public void setDate_restitution(Date date_restitution) {
		this.date_restitution = date_restitution;
	}
	
	
    
    
}
