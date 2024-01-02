package Models;

import java.util.Date;

public class Penalisation {
    private int id_penalisation;
    private Date date_debut;
    private Date date_fin;
    private Abonné abonne;
	public Penalisation() {
	}
	public Penalisation(int id_penalisation, Date date_debut, Date date_fin, Abonné abonne) {
		this.id_penalisation = id_penalisation;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.abonne = abonne;
	}
	public int getId_penalisation() {
		return id_penalisation;
	}
	public void setId_penalisation(int id_penalisation) {
		this.id_penalisation = id_penalisation;
	}
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	
    
}
