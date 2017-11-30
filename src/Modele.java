import java.sql.*;
import java.util.ArrayList;

import javax.swing.JTextField;



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

		boolean rep = true;
		int typeComptable=0;
	    int total;
		try {
			 pst =connexion.prepareStatement("SELECT id,mdp,comptable FROM comptable WHERE id=? and mdp=?");
			 pst.setString(1, id);
			 pst.setString(2, mdp);
			 rs = pst.executeQuery();
					 id = rs.getString("id");
					 mdp = rs.getString("mdp");
					
					Comptable unComptable =new Comptable(id,mdp,typeComptable);

				rs.close();
		} catch (SQLException erreur) {
			rep=false;
			System.out.println(erreur);
		}
		return rep; 
	}

}
