public class HorsForfait {

		private String mois;
		private String libelle;
		private double montant;
		
		public HorsForfait(String mois, String libelle, double montant) {
			this.mois = mois;
			this.libelle = libelle;
			this.montant = montant;
		}
		public HorsForfait(String libelle, double montant) {
			this.libelle = libelle;
			this.montant = montant;
		}
		public String getMois() {
			return mois;
		}
		public void setMois(String mois) {
			this.mois = mois;
		}
		public String getLibelle() {
			return libelle;
		}
		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}
		public double getMontant() {
			return montant;
		}
		public void setMontant(double montant) {
			this.montant = montant;
		}



		}