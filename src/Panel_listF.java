import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import org.omg.Messaging.SyncScopeHelper;


public class Panel_listF extends JPanel implements ActionListener {
	

		//Attributs Privés
	 private JTable tableau;
	  JScrollPane scrollPane;

	
	
		


		
		public Panel_listF() {
			
	
			ArrayList <FicheFrais> LesFiches=  Modele.getLesFiches();
			ArrayList <Visiteur> LesVisiteurs =  Modele.getLesVisiteursNonTrier();
			Object data[][]= new Object[10][10];
			int i = 0;
			for(Visiteur unVisiteur : LesVisiteurs){
				data[i][0] =unVisiteur.getNomVisiteur();
				
				i++;
		
			}
			i=0;
			for(FicheFrais uneFiche : LesFiches){
				
				data[i][1]=uneFiche.getIdEtat();
				i++;
				}
		
			
			
			String [] title = {"Name", "Fiches"};
			this.tableau = new JTable(data,title);
			
			this.tableau.setRowHeight(30);
			

	
			
			
			this.setBackground(Color.white);
		
			this.scrollPane = new JScrollPane(this.tableau);
			this.add(this.scrollPane);
			this.setVisible(true) ;

		 
		

		}

		@Override
		public void actionPerformed(ActionEvent e) {

      
		}
}