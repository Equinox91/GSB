public class FicheFrais {
private String mois;
private Float montant;
private String idEtat;

public FicheFrais(String mois, Float montant, String idEtat) {
	this.mois = mois;
	this.montant = montant;
	this.idEtat = idEtat;
}
public String getMois() {
	return mois;
}
public void setMois(String mois) {
	this.mois = mois;
}
public Float getMontant() {
	return montant;
}
public void setMontant(Float montant) {
	this.montant = montant;
}
public String getIdEtat() {
	return idEtat;
}
public void setIdEtat(String idEtat) {
	this.idEtat = idEtat;
}

}
