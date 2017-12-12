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
				System.out.println("La connexion à la base de données a échoué ou Erreur SQL…" + erreur);

			}
			catch(ClassNotFoundException erreur){
				System.out.println("Driver non chargé !" + erreur);

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
			System.out.println("problème sql" + e);
		}
		return rep;

}
	
	//Récupère l'id le nom et le prenom du visiteur
	
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
			rs.close() ; // Permet de libérer la mémoire utilisée.
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return lesVisiteurs ;
	}
	
	//Permet de récupérer l'id du visiteur en fonction du nom du visiteur
	public static String getIdVisiteur(String unNom) {
		String unId = null;
		try {
	
			String sql = "select id from visiteur where nom='"+unNom+"';";
			rs = st.executeQuery(sql) ;
			if(rs.next()){
				unId = rs.getString(1);		
			}
			rs.close() ; // Permet de libérer la mémoire utilisée.
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return unId ;
	}
	
	//Crée une collection de mois en fonction de l'id passé en paramètre
	
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
			rs.close() ; // Permet de libérer la mémoire utilisée.
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return lesMois ;
	}
	
	  public static FicheFrais getFicheFrais(String unMoisVisiteur, String unIdVisiteur){
			FicheFrais laFiche = null;
			try {
				String unMois;
				float unMontant;
				String unIdEtat;
		
				String sql = "select mois,montantValide,idEtat from visiteur,fichefrais where fichefrais.idVisiteur = visiteur.id and mois='"+ unMoisVisiteur+ "' and idVisiteur='"+unIdVisiteur+"';";
				rs = st.executeQuery(sql) ;
		
				while (rs.next()) {
					unMois = rs.getString(1);
					unMontant = rs.getFloat(2);
					unIdEtat = rs.getString(3);
					laFiche = new FicheFrais(unMois,unMontant,unIdEtat);
				}
				rs.close() ; // Permet de libérer la mémoire utilisée.
			} 
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return laFiche;
		  
	  }
}
