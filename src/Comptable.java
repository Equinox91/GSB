
public class Comptable {
private String id;
private String nom;
private String prenom; 
private String login; 
private String mdp; 
private String adresse;
private int CP;
private String ville; 
private int comptable;
public Comptable(String id, String nom, int comptable) {
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.login = login;
	this.mdp = mdp;
	this.adresse = adresse;
	this.ville = ville;
	this.comptable = comptable;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
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
public String getLogin() {
	return login;
}
public void setLogin(String login) {
	this.login = login;
}
public String getMdp() {
	return mdp;
}
public void setMdp(String mdp) {
	this.mdp = mdp;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public int getCP() {
	return CP;
}
public void setCP(int cP) {
	CP = cP;
}
public String getVille() {
	return ville;
}
public void setVille(String ville) {
	this.ville = ville;
}
public int getComptable() {
	return comptable;
}
public void setComptable(int comptable) {
	this.comptable = comptable;
}


}
