
import java.util.ArrayList;


public class Visiteur{
	//Attributs Privés
	private String idVisiteur ;
	private String nomVisiteur ;
	private String prenomVisiteur ;
	private ArrayList <Visiteur> lesVisiteurs = new ArrayList <Visiteur>();
	
	//Constructeurs
	public Visiteur(String unId , String unNom, String unPrenom) {
		this.idVisiteur = unId ;
		this.nomVisiteur = unNom ;
		this.prenomVisiteur = unPrenom ;
		ArrayList <Visiteur> lesFilms = new ArrayList <Visiteur>();
	}

	//Méthodes Publiques
	public String getIdVisiteur() {
		return idVisiteur;
	}

	public void setIdVisiteur(String idVisiteur) {
		this.idVisiteur = idVisiteur;
	}
	public String getNomVisiteur() {
		return nomVisiteur;
	}
	public void setNomVisiteur(String nomVisiteur) {
		this.nomVisiteur = nomVisiteur;
	}
	public String getPrenomVisiteur() {
		return prenomVisiteur;
	}
	public void setPrenomVisiteur(String prenomVisiteur) {
		this.prenomVisiteur = prenomVisiteur;
	}
	public String toXML() {
		{
			String xml ;
			xml = "<Visiteur id=" +idVisiteur + ">" ;
			xml = xml + "<nom =" +nomVisiteur+ ">" ;
			xml = xml + "<prenom =" +prenomVisiteur+ ">" ;
			xml = xml + "</films>" ;
			return xml ;
		}
	}

	
	


	
}