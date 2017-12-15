 import java.sql.*;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.text.JTextComponent;



public class Modele {
	
	private static Connection connexion;
	private static Statement st;
	private static PreparedStatement pst;
	private static ResultSet rs;
	
	public static Connection connect(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://localhost/gsbv2", "root", "");
			
			 st = connexion.createStatement();
	
		}		
		
			catch(SQLException erreur) {
				System.out.println("La connexion � la base de donn�es a �chou� ou Erreur SQL�" + erreur);

			}
			catch(ClassNotFoundException erreur){
				System.out.println("Driver non charg� !" + erreur);

			}
		return connexion;
	}
	public static void deconnect(){
		try {
			connexion.close();
		} catch (SQLException erreur) {
			System.out.println(erreur);
		}
	}
	public static boolean ConnexionLesComptables(String id, String mdp){
		 boolean rep= false;
		 
	    String sql = ("SELECT count(*) login,mdp,comptable FROM visiteur WHERE login ='" + id+ "' AND mdp='"+ mdp+ "' and comptable=1;" );
	   int count= 0;
		try{

			rs = st.executeQuery(sql);
			if(rs.next()){
			count=rs.getInt(1);
			
			}
			if(count!=0){
			rep=true;
			
			
			}
			
			rs.close();
		}
		catch(SQLException e){
			System.out.println("probl�me sql" + e);
		}
		return rep;

}
	
	//R�cup�re l'id le nom et le prenom du visiteur
	
	public static ArrayList<Visiteur> getLesVisiteurs() {
		connect();
		ArrayList <Visiteur> lesVisiteurs = new ArrayList <Visiteur>();
		try {
	
	
			Visiteur unVisiteur ;
			String unId ;
			String unNom ;
			String unPrenom ;
			String sql = "select distinct id,nom,prenom from visiteur, fichefrais where fichefrais.idVisiteur = visiteur.id and idVisiteur is not null";
			rs = st.executeQuery(sql) ;
	
			while (rs.next()) {
				unId = rs.getString(1);
				unNom = rs.getString(2);
				unPrenom = rs.getString(3);
				unVisiteur = new Visiteur(unId,unNom,unPrenom);
				lesVisiteurs.add(unVisiteur);
			}
			rs.close() ; // Permet de lib�rer la m�moire utilis�e.
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return lesVisiteurs ;
	}
	
	//Permet de r�cup�rer l'id du visiteur en fonction du nom du visiteur
	public static String getIdVisiteur(String unNom) {
		String unId = null;
		try {
	
			String sql = "select id from visiteur where nom='"+unNom+"';";
			rs = st.executeQuery(sql) ;
			if(rs.next()){
				unId = rs.getString(1);		
			}
			rs.close() ; // Permet de lib�rer la m�moire utilis�e.
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return unId ;
	}
	
	//Cr�e une collection de mois en fonction de l'id pass� en param�tre
	
	public static ArrayList<FraisForfait> getLesMois(String unId) {
		ArrayList <FraisForfait> lesMois = new ArrayList <FraisForfait>();
		try {
			FraisForfait unMois;
			String leMois;
			String sql = "select mois from visiteur, fichefrais where fichefrais.idVisiteur = visiteur.id and idVisiteur='"+unId+"';";
			rs = st.executeQuery(sql) ;
	
			while (rs.next()) {
				leMois = rs.getString(1);

				unMois = new FraisForfait(leMois);
				lesMois.add(unMois);
			}
			rs.close() ; // Permet de lib�rer la m�moire utilis�e.
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return lesMois ;
	}
	
	public static ArrayList<HorsForfait> getLesHorsForfaits(String unMoisVisiteur, String unIdVisiteur) {
		ArrayList <HorsForfait> lesHorsForfaits = new ArrayList <HorsForfait>();
		try {
			HorsForfait unHorsForfait;
			String libelle;
			double montant;
			String sql = "SELECT libelle,montant FROM lignefraishorsforfait WHERE idVisiteur='"+unIdVisiteur+"' and mois='"+unMoisVisiteur+"';";
			rs = st.executeQuery(sql) ;
	
			while (rs.next()) {
				libelle = rs.getString(1);
				montant = rs.getDouble(2);
				unHorsForfait = new HorsForfait(libelle,montant);
				lesHorsForfaits.add(unHorsForfait);
			}
			rs.close() ; // Permet de lib�rer la m�moire utilis�e.
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return lesHorsForfaits ;
	}
	
	  public static FicheFrais getFicheFrais(String unMoisVisiteur, String unIdVisiteur){
			FicheFrais laFiche = null;
			try {
				double unNbForfait = 0;
				double unNbKm = 0;
				double unNbNuitee = 0;
				double unNbRepas = 0;
		//Recup�re nbForfait
				String sql = "select quantite from lignefraisforfait where idFraisForfait='ETP' and mois='"+ unMoisVisiteur+ "' and idVisiteur='"+unIdVisiteur+"';";
				rs = st.executeQuery(sql) ;
		
				while (rs.next()) {
					unNbForfait = rs.getDouble(1);

				}
				rs.close() ; // Permet de lib�rer la m�moire utilis�e.
			//Recup�re nbKm
			sql = "select quantite from lignefraisforfait where idFraisForfait='KM' and mois='"+ unMoisVisiteur+ "' and idVisiteur='"+unIdVisiteur+"';";
			rs = st.executeQuery(sql) ;
	
			while (rs.next()) {
				unNbKm = rs.getDouble(1);

			}
			rs.close() ; // Permet de lib�rer la m�moire utilis�e.
			//Recup�re nbNuitee
			sql = "select quantite from lignefraisforfait where idFraisForfait='NUI' and mois='"+ unMoisVisiteur+ "' and idVisiteur='"+unIdVisiteur+"';";
			rs = st.executeQuery(sql) ;
	
			while (rs.next()) {
				unNbNuitee = rs.getDouble(1);

			}
			rs.close() ; // Permet de lib�rer la m�moire utilis�e.
			//Recup�re nbRepas
			sql = "select quantite from lignefraisforfait where idFraisForfait='REP' and mois='"+ unMoisVisiteur+ "' and idVisiteur='"+unIdVisiteur+"';";
			rs = st.executeQuery(sql) ;
	
			while (rs.next()) {
				unNbRepas = rs.getDouble(1);

			}
			rs.close() ; // Permet de lib�rer la m�moire utilis�e.
			laFiche = new FicheFrais(FicheFrais.getCoutTotalForfait(unNbForfait),FicheFrais.getCoutTotalKm(unNbKm),FicheFrais.getCoutTotalNuitee(unNbNuitee),FicheFrais.getCoutTotalRepas(unNbRepas));
		} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return laFiche;
		  
	  }
	  
	  public static ArrayList<FicheFrais> getLesFiches() {
			connect();
			ArrayList <FicheFrais> lesFiches = new ArrayList <FicheFrais>();
			try {
		
		
				FicheFrais uneFiche ;
				String unIdVisiteur;
				String unMois;
				int unNbJustificatifs  ;
				float unMontantValide  ;
				Date uneDateModif; 
				String unIdEtat;
				
				String sql = "select * from fichefrais ";
				rs = st.executeQuery(sql) ;
		
				while (rs.next()) {
					unIdVisiteur = rs.getString(1);
					unMois = rs.getString(2);
					unNbJustificatifs = rs.getInt(3);
					unMontantValide = rs.getInt(4);
					uneDateModif= rs.getDate(5);
					unIdEtat= rs.getString(6);
					uneFiche = new FicheFrais(unIdEtat);
					lesFiches.add(uneFiche);
				}
				rs.close() ; // Permet de lib�rer la m�moire utilis�e.
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			return lesFiches ;
		}
}