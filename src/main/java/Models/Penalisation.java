package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Utils.Connexion;

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
	
	public Abonné getAbonne() {
		return abonne;
	}
	public void setAbonne(Abonné abonne) {
		this.abonne = abonne;
	}
	public static List<Penalisation> getAllPenalisationsWithUsers() {
        List<Penalisation> penalisations = new ArrayList<>();
        Connexion co = new Connexion();

        try (Connection conn = co.ConnectBdd()) {
            if (conn != null) {
                String query = "SELECT p.*, a.* FROM penalisation p JOIN abonne a ON p.id_utilisateur = a.id_utilisateur";

                try (PreparedStatement preparedStatement = conn.prepareStatement(query);
                     ResultSet resultSet = preparedStatement.executeQuery()) {

                    while (resultSet.next()) {
                        Abonné abonne = new Abonné();
                        abonne.setId_utilisateur(resultSet.getInt("id_utilisateur"));
                        abonne.setNom_utilisateur(resultSet.getString("nom_utilisateur"));
                        abonne.setNom(resultSet.getString("nom"));
                        abonne.setPrenom(resultSet.getString("prenom"));
                        abonne.setType(resultSet.getString("type"));

                        Penalisation penalisation = new Penalisation();
                        penalisation.setId_penalisation(resultSet.getInt("id_penalisation"));
                        penalisation.setDate_debut(resultSet.getDate("date_debut"));
                        penalisation.setDate_fin(resultSet.getDate("date_fin"));
                        penalisation.setAbonne(abonne);

                        penalisations.add(penalisation);
                    }
                }
            } else {
                System.out.println("Connection is null. Check your configuration.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return penalisations;
    }
	
	
	///////////////test////////////////////
	public static void main(String[] args) {
	    List<Penalisation> penalisations = getAllPenalisationsWithUsers();
	    for (Penalisation penalisation : penalisations) {
	        System.out.println("Penalisation ID: " + penalisation.getId_penalisation());
	        System.out.println("Start Date: " + penalisation.getDate_debut());
	        System.out.println("End Date: " + penalisation.getDate_fin());

	        Abonné abonne = penalisation.getAbonne();
	        System.out.println("Abonné ID: " + abonne.getNom());
	        System.out.println("Nom d'utilisateur: " + abonne.getNom_utilisateur());
	        // Print other Abonné fields as needed

	        System.out.println("----------------------------------------");
	    }
	}

	
    
}
