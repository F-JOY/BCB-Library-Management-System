package Models;

import java.util.Date;

public class Bibliothecaire {
	    private int id_utilisateur;
	    private String nom_utilisateur;
	    private String mot_de_pass;
	    private String nom;
	    private String prenom;
	    private String email;
	    private String adresse;
	    private String num_tel;
	    private Date date_naiss;
	     public Bibliothecaire() {
	    	 
	     }
	    
		public Bibliothecaire(int id_utilisateur, String nom_utilisateur, String mot_de_pass, String nom, String prenom,
				String email, String adresse, String num_tel, Date date_naiss) {
			this.id_utilisateur = id_utilisateur;
			this.nom_utilisateur = nom_utilisateur;
			this.mot_de_pass = mot_de_pass;
			this.nom = nom;
			this.prenom = prenom;
			this.email = email;
			this.adresse = adresse;
			this.num_tel = num_tel;
			this.date_naiss = date_naiss;
		}

		public int getId_utilisateur() {
			return id_utilisateur;
		}

		public void setId_utilisateur(int id_utilisateur) {
			this.id_utilisateur = id_utilisateur;
		}

		public String getNom_utilisateur() {
			return nom_utilisateur;
		}

		public void setNom_utilisateur(String nom_utilisateur) {
			this.nom_utilisateur = nom_utilisateur;
		}

		public String getMot_de_pass() {
			return mot_de_pass;
		}

		public void setMot_de_pass(String mot_de_pass) {
			this.mot_de_pass = mot_de_pass;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getAdresse() {
			return adresse;
		}

		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}

		public String getNum_tel() {
			return num_tel;
		}

		public void setNum_tel(String num_tel) {
			this.num_tel = num_tel;
		}

		public Date getDate_naiss() {
			return date_naiss;
		}

		public void setDate_naiss(Date date_naiss) {
			this.date_naiss = date_naiss;
		}
	    
	    
	    
	    
}
