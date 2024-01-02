package Models;

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
	    
	    

}
