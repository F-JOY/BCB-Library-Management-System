package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import Utils.Connexion;

public class Abonné {
	  private int id_utilisateur;
	    private String nom_utilisateur;
	    private String mot_de_pass;
	    private String nom;
	    private String prenom;
	    private String genre;
	    private String adresse;
	    private String email;
	    private String num_tel;
	    private Date date_naiss;
	    private String type;
	    private boolean paiementSF;
	    private boolean paiement;
		public Abonné() {	
		}
		
		public Abonné(int id_utilisateur, String nom_utilisateur, String mot_de_pass, String nom, String prenom,
				String genre, String adresse, String email, String num_tel, Date date_naiss, String type,
				boolean paiementSF, boolean paiement) {
			this.id_utilisateur = id_utilisateur;
			this.nom_utilisateur = nom_utilisateur;
			this.mot_de_pass = mot_de_pass;
			this.nom = nom;
			this.prenom = prenom;
			this.genre = genre;
			this.adresse = adresse;
			this.email = email;
			this.num_tel = num_tel;
			this.date_naiss = date_naiss;
			this.type = type;
			this.paiementSF = paiementSF;
			this.paiement = paiement;
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
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		public String getAdresse() {
			return adresse;
		}
		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
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
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public boolean isPaiementSF() {
			return paiementSF;
		}
		public void setPaiementSF(boolean paiementSF) {
			this.paiementSF = paiementSF;
		}
		public boolean isPaiement() {
			return paiement;
		}
		public void setPaiement(boolean paiement) {
			this.paiement = paiement;
		}
		
		
		////////////////////////Connexion//////////////////////////
		 public static Abonné verifyConnexion(String username, String password) {
			 Connexion co = new Connexion();
		        try (Connection conn = co.ConnectBdd()) {
		            if (conn != null) {
		                System.out.println("Connection successful!");
		                String query = "SELECT * FROM `abonne` WHERE nom_utilisateur = ? AND mot_de_pass = ?";
			            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			                preparedStatement.setString(1, username);
			                preparedStatement.setString(2, password);
			                try (ResultSet resultSet = preparedStatement.executeQuery()) {
			                    if (resultSet.next()) {
			                    	 Abonné abonne = new Abonné();
			                         abonne.setId_utilisateur(resultSet.getInt("id_utilisateur"));
			                         abonne.setNom_utilisateur(resultSet.getString("nom_utilisateur"));
			                         abonne.setMot_de_pass(resultSet.getString("mot_de_pass"));
			                         abonne.setNom(resultSet.getString("nom"));
			                         abonne.setPrenom(resultSet.getString("prenom"));
			                         abonne.setGenre(resultSet.getString("genre"));
			                         abonne.setAdresse(resultSet.getString("adresse"));
			                         abonne.setEmail(resultSet.getString("email"));
			                         abonne.setNum_tel(resultSet.getString("num_tel"));
			                         abonne.setDate_naiss(resultSet.getDate("date_naiss"));
			                         abonne.setType(resultSet.getString("type"));
			                         abonne.setPaiementSF(resultSet.getBoolean("paiementSF"));
			                         abonne.setPaiement(resultSet.getBoolean("paiement"));
			                         return abonne;
			                    }
			                }
			            }
		               
		            } else {
		                System.out.println("Connection is null. Check your configuration.");
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return null;
		    }
		
		 
		 public static void main(String[] args) throws SQLException {
			 
			System.out.print(verifyConnexion("abonne1", "motdepasse1")); 
		 }
	    
}
