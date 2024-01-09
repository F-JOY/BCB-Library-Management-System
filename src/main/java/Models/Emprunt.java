package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Utils.Connexion;

public class Emprunt {
	private int id_emprunt;
    private Date date_debut;
    private boolean prolongation; 
    private Date date_restitution;
    private Abonné abonne;
    private Ouvrage ouvrage;
	public Emprunt() {
	}
	public Emprunt(int id_emprunt, Date date_debut,boolean prolongation, Date date_restitution, Abonné abonne, Ouvrage ouvrage) {
		
		this.id_emprunt = id_emprunt;
		this.date_debut = date_debut;
		this.prolongation=prolongation;
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
	public boolean isProlongation() {
		return prolongation;
	}
	public void setProlongation(boolean prolongation) {
		this.prolongation = prolongation;
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
	
	public static List<Emprunt> getAllEmpruntsDetails() {
        List<Emprunt> empruntsDetails = new ArrayList<>();
        Connexion co = new Connexion();

        try (Connection conn = co.ConnectBdd()) {
            if (conn != null) {
                String query = "SELECT e.id_emprunt, e.date_debut, e.date_restitution, " +
                               "o.id_ouvrage, o.titre, " +
                               "a.id_utilisateur, a.nom_utilisateur, a.nom, a.prenom " +
                               "FROM emprunt e " +
                               "JOIN ouvrage o ON e.id_ouvrage = o.id_ouvrage " +
                               "JOIN abonne a ON e.id_utilisateur = a.id_utilisateur";

                try (PreparedStatement preparedStatement = conn.prepareStatement(query);
                     ResultSet resultSet = preparedStatement.executeQuery()) {

                    while (resultSet.next()) {
                        Emprunt empruntDetails = new Emprunt();
                        empruntDetails.setId_emprunt(resultSet.getInt("id_emprunt"));
                        empruntDetails.setDate_debut(resultSet.getDate("date_debut"));
                        empruntDetails.setDate_restitution(resultSet.getDate("date_restitution"));

                        Ouvrage ouvrage = new Ouvrage();
                        ouvrage.setId_ouvrage(resultSet.getInt("id_ouvrage"));
                        ouvrage.setTitre(resultSet.getString("titre"));
                        empruntDetails.setOuvrage(ouvrage);

                        Abonné abonne = new Abonné();
                        abonne.setId_utilisateur(resultSet.getInt("id_utilisateur"));
                        abonne.setNom_utilisateur(resultSet.getString("nom_utilisateur"));
                        abonne.setNom(resultSet.getString("nom"));
                        abonne.setPrenom(resultSet.getString("prenom"));
                        empruntDetails.setAbonne(abonne);

                        empruntsDetails.add(empruntDetails);
                    }
                }
            } else {
                System.out.println("Connection is null. Check your configuration.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return empruntsDetails;
    }
	 public static List<Emprunt> getEmpruntsProlonges() {
	        List<Emprunt> empruntsProlonges = new ArrayList<>();
	        Connexion co = new Connexion();

	        try (Connection conn = co.ConnectBdd()) {
	            if (conn != null) {
	            	String query = "SELECT e.id_emprunt, e.date_debut, e.date_restitution, e.prolongation, " +
	                        "o.id_ouvrage, o.titre, " +
	                        "a.id_utilisateur, a.nom_utilisateur, a.nom, a.prenom " +
	                        "FROM emprunt e " +
	                        "JOIN ouvrage o ON e.id_ouvrage = o.id_ouvrage " +
	                        "JOIN abonne a ON e.id_utilisateur = a.id_utilisateur " +
	                        "WHERE e.prolongation = true";


	                try (PreparedStatement preparedStatement = conn.prepareStatement(query);
	                     ResultSet resultSet = preparedStatement.executeQuery()) {

	                    while (resultSet.next()) {
	                        Emprunt empruntProlonge = new Emprunt();
	                        empruntProlonge.setId_emprunt(resultSet.getInt("id_emprunt"));
	                        empruntProlonge.setDate_debut(resultSet.getDate("date_debut"));
	                        empruntProlonge.setDate_restitution(resultSet.getDate("date_restitution"));
	                        empruntProlonge.setProlongation(resultSet.getBoolean("prolongation"));
	                        Ouvrage ouvrage = new Ouvrage();
	                        ouvrage.setId_ouvrage(resultSet.getInt("id_ouvrage"));
	                        ouvrage.setTitre(resultSet.getString("titre"));
	                        empruntProlonge.setOuvrage(ouvrage);

	                        Abonné abonne = new Abonné();
	                        abonne.setId_utilisateur(resultSet.getInt("id_utilisateur"));
	                        abonne.setNom_utilisateur(resultSet.getString("nom_utilisateur"));
	                        abonne.setNom(resultSet.getString("nom"));
	                        abonne.setPrenom(resultSet.getString("prenom"));
	                        empruntProlonge.setAbonne(abonne);
	                        empruntsProlonges.add(empruntProlonge);
	                    }
	                }
	            } else {
	                System.out.println("Connection is null. Check your configuration.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return empruntsProlonges;
	    }

	 public static void main(String[] args) {
	        // Fetch the list of emprunts with details
	       /* List<Emprunt> empruntsDetails = Emprunt.getAllEmpruntsDetails();

	        // Display the retrieved details
	        for (Emprunt empruntDetails : empruntsDetails) {
	            System.out.println("Emprunt ID: " + empruntDetails.getId_emprunt());
	            System.out.println("Date début: " + empruntDetails.getDate_debut());
	            System.out.println("Date restitution: " + empruntDetails.getDate_restitution());

	            Ouvrage ouvrage = empruntDetails.getOuvrage();
	            System.out.println("Ouvrage ID: " + ouvrage.getId_ouvrage());
	            System.out.println("Ouvrage Titre: " + ouvrage.getTitre());

	            Abonné abonne = empruntDetails.getAbonne();
	            System.out.println("Abonné ID: " + abonne.getId_utilisateur());
	            System.out.println("Nom d'utilisateur: " + abonne.getNom_utilisateur());
	            System.out.println("Nom et prénom: " + abonne.getNom() + " " + abonne.getPrenom());

	            System.out.println("--------------------------------");
	        }*/
		 System.out.print(getEmpruntsProlonges());
		 
	    }
    
}
