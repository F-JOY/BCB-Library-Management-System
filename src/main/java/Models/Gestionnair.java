package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Utils.Connexion;

public class Gestionnair {
	private int id_utilisateur;
    private String nom_utilisateur;
    private String mot_de_pass;
    private String nom;
    private String prenom;
     
    public Gestionnair() {}
	public Gestionnair(int id_utilisateur, String nom_utilisateur, String mot_de_pass, String nom, String prenom) {
		this.id_utilisateur = id_utilisateur;
		this.nom_utilisateur = nom_utilisateur;
		this.mot_de_pass = mot_de_pass;
		this.nom = nom;
		this.prenom = prenom;
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
    
	////////////////////////Connexion//////////////////////////
	 public static Gestionnair verifyConnexion(String username, String password) {
		 
		 Connexion co = new Connexion();
	        try (Connection conn = co.ConnectBdd()) {
	            if (conn != null) {
	                System.out.println("Connection successful!");
	                String query = "SELECT * FROM `gestionnaire` WHERE nom_utilisateur = ? AND mot_de_pass = ?";
		            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
		                preparedStatement.setString(1, username);
		                preparedStatement.setString(2, password);
		                System.out.println(username);
		                try (ResultSet resultSet = preparedStatement.executeQuery()) {
		                    if (resultSet.next()) {
		                        Gestionnair gestionnaire = new Gestionnair();
		                        gestionnaire.setId_utilisateur(resultSet.getInt("id_utilisateur"));
		                        gestionnaire.setNom_utilisateur(resultSet.getString("nom_utilisateur"));
		                        gestionnaire.setMot_de_pass(resultSet.getString("mot_de_pass"));
		                        gestionnaire.setNom(resultSet.getString("nom"));
		                        gestionnaire.setPrenom(resultSet.getString("prenom"));
		                        return gestionnaire;
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
		 
		System.out.print(verifyConnexion("admin_1", "123")); 
	 }
	 
	
}
