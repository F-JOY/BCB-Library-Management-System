package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import Utils.Connexion;

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
	    
		////////////////////////Connexion//////////////////////////
		 public static Bibliothecaire verifyConnexion(String username, String password) {
			 
			 Connexion co = new Connexion();
		        try (Connection conn = co.ConnectBdd()) {
		            if (conn != null) {
		                System.out.println("Connection successful!");
		                String query = "SELECT * FROM `bibliothecaire` WHERE nom_utilisateur = ? AND mot_de_pass = ?";
			            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
			                preparedStatement.setString(1, username);
			                preparedStatement.setString(2, password);
			                System.out.println(username);
			                try (ResultSet resultSet = preparedStatement.executeQuery()) {
			                    if (resultSet.next()) {
			                    	 Bibliothecaire bibliothecaire = new Bibliothecaire();
			                         bibliothecaire.setId_utilisateur(resultSet.getInt("id_utilisateur"));
			                         bibliothecaire.setNom_utilisateur(resultSet.getString("nom_utilisateur"));
			                         bibliothecaire.setMot_de_pass(resultSet.getString("mot_de_pass"));
			                         bibliothecaire.setNom(resultSet.getString("nom"));
			                         bibliothecaire.setPrenom(resultSet.getString("prenom"));
			                         bibliothecaire.setEmail(resultSet.getString("email"));
			                         bibliothecaire.setAdresse(resultSet.getString("adresse"));
			                         bibliothecaire.setNum_tel(resultSet.getString("num_tel"));
			                         bibliothecaire.setDate_naiss(resultSet.getDate("date_naiss"));
			                         return bibliothecaire;
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
			 
				System.out.print(verifyConnexion("biblio1", "motdepassebiblio1")); 
			 }
	    
	    
}
