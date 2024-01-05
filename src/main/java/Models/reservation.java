package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Utils.Connexion;

public class reservation {
    private Abonné abonne;
    private Ouvrage ouvrage;
	public reservation() {
		
	}
	public reservation(Abonné abonne, Ouvrage ouvrage) {
		this.abonne = abonne;
		this.ouvrage = ouvrage;
	}
	public Abonné getAbonne() {
		return abonne;
	}
	public void setAbonne(Abonné abonne) {
		this.abonne = abonne;
	}
	public Ouvrage getOuvrage() {
		return ouvrage;
	}
	public void setOuvrage(Ouvrage ouvrage) {
		this.ouvrage = ouvrage;
	}
	
	public List<reservation> getAllReservationDetails() {
	    List<reservation> reservationDetails = new ArrayList<>();
	    Connexion co = new Connexion();

	    try (Connection conn = co.ConnectBdd()) {
	        if (conn != null) {
	            String query = "SELECT r.id_utilisateur, r.id_ouvrage, " +
	                           "a.id_utilisateur AS abonne_id, a.nom_utilisateur AS abonne_nom_utilisateur, " +
	                           "a.nom AS abonne_nom, a.prenom AS abonne_prenom, " +
	                           "o.id_ouvrage AS ouvrage_id, o.titre AS ouvrage_titre, o.disponible AS disponible " +
	                           "FROM reservation r " +
	                           "JOIN abonne a ON r.id_utilisateur = a.id_utilisateur " +
	                           "JOIN ouvrage o ON r.id_ouvrage = o.id_ouvrage";

	            try (PreparedStatement preparedStatement = conn.prepareStatement(query);
	                 ResultSet resultSet = preparedStatement.executeQuery()) {

	                while (resultSet.next()) {
	                    reservation reservation = new reservation();
	                   
	                    Abonné abonne = new Abonné();
	                    abonne.setId_utilisateur(resultSet.getInt("abonne_id"));
	                    abonne.setNom_utilisateur(resultSet.getString("abonne_nom_utilisateur"));
	                    abonne.setNom(resultSet.getString("abonne_nom"));
	                    abonne.setPrenom(resultSet.getString("abonne_prenom"));
	                    reservation.setAbonne(abonne);

	                    Ouvrage ouvrage = new Ouvrage();
	                    ouvrage.setId_ouvrage(resultSet.getInt("ouvrage_id"));
	                    ouvrage.setTitre(resultSet.getString("ouvrage_titre"));
	                    ouvrage.setDisponible(resultSet.getInt("disponible"));
	                    reservation.setOuvrage(ouvrage);

	                    reservationDetails.add(reservation);
	                }
	            }
	        } else {
	            System.out.println("Connection is null. Check your configuration.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return reservationDetails;
	}
	
	
	
	    public static void main(String[] args) {
	        // Test the getAllReservationDetails method
	        reservation reservationModel = new reservation();
	        List<reservation> reservationDetails = reservationModel.getAllReservationDetails();

	        // Display the results
	        for (reservation reservation : reservationDetails) {
	            System.out.println("Reservation Details:");
	            System.out.println("Abonne ID: " + reservation.getAbonne().getId_utilisateur());
	            System.out.println("Abonne Nom: " + reservation.getAbonne().getNom());
	            System.out.println("Abonne Prenom: " + reservation.getAbonne().getPrenom());
	            System.out.println("Ouvrage ID: " + reservation.getOuvrage().getId_ouvrage());
	            System.out.println("Ouvrage Titre: " + reservation.getOuvrage().getTitre());
	            System.out.println("------------------------------");
	        }
	    }
	


}
