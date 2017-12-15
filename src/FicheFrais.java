public class FicheFrais {

private final static double coutForfait=100.00;
private final static double coutKm=0.62;
private final static double coutNuitee=80.00;
private final static double coutRepas=25.00;
private static double coutTotalForfait;
private static double coutTotalKm;
private static double coutTotalNuitee;
private static double coutTotalRepas;
private String idEtat;

public FicheFrais(String unId){
	this.idEtat = unId;
}
public FicheFrais(double desForfaits, double desKMs, double desNuitees, double desRepas){
	this.coutTotalForfait=desForfaits;
	this.coutTotalKm=desKMs;
	this.coutTotalNuitee=desNuitees;
	this.coutTotalRepas=desRepas;

}
public static double getInfoTotalForfait() {
	return coutTotalForfait;
}
public static double getInfoTotalKm() {
	return coutTotalKm;
}
public static double getInfoTotalNuitee() {
	return coutTotalNuitee;
}
public static double getInfoTotalRepas() {
	return coutTotalRepas;
}
public static double getCoutTotalForfait(double unNbForfait) {
	coutTotalForfait=unNbForfait*FicheFrais.getCoutForfait();
	return coutTotalForfait;
}
public String getIdEtat() {
	return idEtat;
}
public void setIdEtat(String idEtat) {
	this.idEtat = idEtat;
}
public static double getCoutTotalKm(double nbKm) {
	coutTotalKm=nbKm*FicheFrais.getCoutKm();
	return coutTotalKm;
}

public static double getCoutTotalNuitee(double nbNuit) {
	coutTotalNuitee=nbNuit*FicheFrais.getCoutNuitee();
	return coutTotalNuitee;
}

public static double getCoutTotalRepas(double nbRepas) {
	coutTotalRepas=nbRepas*FicheFrais.getCoutRepas();
	return coutTotalRepas;
}
public static double getCoutForfait() {
	return coutForfait;
}

public static double getCoutKm() {
	return coutKm;
}

public static double getCoutNuitee() {
	return coutNuitee;
}

public static double getCoutRepas() {
	return coutRepas;
}






}