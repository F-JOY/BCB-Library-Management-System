package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Utils.Connexion;

public class Ouvrage {
	 private int id_ouvrage;
	    private String titre;
	    private String auteur;
	    private String description;
	    private int annee;
	    private int disponible;
	    private String type;
	    private String faculte;
	    private String promoteur;
	    private String isbn;
	    private double prix;
		public Ouvrage() {
		}
		public Ouvrage(int id_ouvrage, String titre, String auteur, String description, int annee, int disponible,
				String type, String faculte, String promoteur, String isbn, double prix) {
			this.id_ouvrage = id_ouvrage;
			this.titre = titre;
			this.auteur = auteur;
			this.description = description;
			this.annee = annee;
			this.disponible = disponible;
			this.type = type;
			this.faculte = faculte;
			this.promoteur = promoteur;
			this.isbn = isbn;
			this.prix = prix;
		}
		public int getId_ouvrage() {
			return id_ouvrage;
		}
		public void setId_ouvrage(int id_ouvrage) {
			this.id_ouvrage = id_ouvrage;
		}
		public String getTitre() {
			return titre;
		}
		public void setTitre(String titre) {
			this.titre = titre;
		}
		public String getAuteur() {
			return auteur;
		}
		public void setAuteur(String auteur) {
			this.auteur = auteur;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getAnnee() {
			return annee;
		}
		public void setAnnee(int annee) {
			this.annee = annee;
		}
		public int getDisponible() {
			return disponible;
		}
		public void setDisponible(int disponible) {
			this.disponible = disponible;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getFaculte() {
			return faculte;
		}
		public void setFaculte(String faculte) {
			this.faculte = faculte;
		}
		public String getPromoteur() {
			return promoteur;
		}
		public void setPromoteur(String promoteur) {
			this.promoteur = promoteur;
		}
		public String getIsbn() {
			return isbn;
		}
		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}
		public double getPrix() {
			return prix;
		}
		public void setPrix(double prix) {
			this.prix = prix;
		}
		/////////////////////////affichage d'un ouvrage ///////////////////
		private static Ouvrage mapResultSetToOuvrage(ResultSet resultSet) throws SQLException {
		    Ouvrage ouvrage = new Ouvrage();
		    ouvrage.setId_ouvrage(resultSet.getInt("id_ouvrage"));
		    ouvrage.setTitre(resultSet.getString("titre"));
		    ouvrage.setAuteur(resultSet.getString("auteur"));
		    ouvrage.setDescription(resultSet.getString("description"));
		    ouvrage.setAnnee(resultSet.getInt("annee"));
		    ouvrage.setDisponible(resultSet.getInt("disponible"));
		    ouvrage.setType(resultSet.getString("type"));
		    ouvrage.setFaculte(resultSet.getString("faculte"));
		    ouvrage.setPromoteur(resultSet.getString("promoteur"));
		    ouvrage.setIsbn(resultSet.getString("isbn"));
		    ouvrage.setPrix(resultSet.getDouble("prix"));

		    // Add any additional attributes here...

		    return ouvrage;
		}
		/////////////////////////selectionner les livres/////////////////////
		public static List<Ouvrage> getLivres() {
			
			List<Ouvrage> livres = new ArrayList<>();
	       
	        Connexion co = new Connexion();
	        try (Connection conn = co.ConnectBdd()) {
	            if (conn != null) {
	                System.out.println("Connection successful!");
	                String query = "SELECT * FROM `ouvrage` WHERE type = 'Livre'"; 
		            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
		            	try (ResultSet resultSet = preparedStatement.executeQuery()) {
		      	            while (resultSet.next()) {
		      	                Ouvrage livre = mapResultSetToOuvrage(resultSet);
		      	                livres.add(livre);
		      	            }

		      	        } catch (SQLException e) {
		      	            e.printStackTrace();
		      	        }
		      	      return livres;
		            }
	               
	            } else {
	                System.out.println("Connection is null. Check your configuration.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;   
	    }   

		
		//////////////////////selectionner les theses///////////////////////
		public static List<Ouvrage> getThese() {
			List<Ouvrage> Theses = new ArrayList<>();
		       
	        Connexion co = new Connexion();
	        try (Connection conn = co.ConnectBdd()) {
	            if (conn != null) {
	                System.out.println("Connection successful!");
	                String query = "SELECT * FROM `ouvrage` WHERE type = 'these'"; 
		            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
		            	try (ResultSet resultSet = preparedStatement.executeQuery()) {
		      	            while (resultSet.next()) {
		      	                Ouvrage these = mapResultSetToOuvrage(resultSet);
		      	                Theses.add(these);
		      	            }

		      	        } catch (SQLException e) {
		      	            e.printStackTrace();
		      	        }
		      	      return Theses;
		            }
	               
	            } else {
	                System.out.println("Connection is null. Check your configuration.");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;   
	        
	    }   

	    ///////////////////recherche ouvrage par mot cle dans tous les attributs//////////////////////////
		public static List<Ouvrage> searchOuvrage(String keyword) {
		    List<Ouvrage> searchResults = new ArrayList<>();
		    Connexion co = new Connexion();
		    // Split the input keyword into individual words
		    String[] keywords = keyword.trim().split("\\s+");
		    String[] columns = {"id_ouvrage", "titre", "auteur", "description", "annee", "type", "faculte", "promoteur", "isbn"};
		    String query = "SELECT * FROM `ouvrage` WHERE ";

		    for (int i = 0; i < keywords.length; i++) {
		        if (i > 0) {
		            query += " OR ";
		        }
		        query += "(";
		        for (int j = 0; j < columns.length; j++) {
		            if (j > 0) {
		                query += " OR ";
		            }
		            query += columns[j] + " LIKE ?";
		        }
		        query += ")";
		    }

		    try (Connection conn = co.ConnectBdd()) {
		        if (conn != null) {
		            System.out.println("Connection successful!");
		            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
		                int parameterIndex = 1; // Initialize parameter index outside the loop

		                for (String keywordPart : keywords) {
		                    for (int j = 0; j < columns.length; j++) {
		                        preparedStatement.setString(parameterIndex, "%" + keywordPart + "%");
		                        parameterIndex++; // Increment parameter index only once per iteration
		                    }
		                }

		                try (ResultSet resultSet = preparedStatement.executeQuery()) {
		                    while (resultSet.next()) {
		                        // Use the mapper function to create Ouvrage objects
		                        Ouvrage ouvrage = mapResultSetToOuvrage(resultSet);
		                        searchResults.add(ouvrage);
		                    }
		                } catch (SQLException e) {
		                    e.printStackTrace();
		                }

		                return searchResults;
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
		 String n = "exactes Livre";
		System.out.println(searchOuvrage(n)); 
	 }
}
