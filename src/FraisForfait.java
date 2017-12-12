
		public class FraisForfait {
		private String idVisiteur;
		private String mois;
		private int nbJustificatifs;
		private float montantValide;
		private String idEtat;

		public String getIdVisiteur() {
			return idVisiteur;
		}


		public FraisForfait(String leMois) {
			this.mois= leMois;
		}

		public void setIdVisiteur(String idVisiteur) {
			this.idVisiteur = idVisiteur;
		}
		public String getMois() {
			return mois;
		}
		public void setMois(String mois) {
			this.mois = mois;
		}
		public int getNbJustificatifs() {
			return nbJustificatifs;
		}
		public void setNbJustificatifs(int nbJustificatifs) {
			this.nbJustificatifs = nbJustificatifs;
		}
		public float getMontantValide() {
			return montantValide;
		}
		public void setMontantValide(float montantValide) {
			this.montantValide = montantValide;
		}
		public String getIdEtat() {
			return idEtat;
		}
		public void setIdEtat(String idEtat) {
			this.idEtat = idEtat;
		}


		}
	