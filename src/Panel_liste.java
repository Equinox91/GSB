import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class Panel_liste extends JPanel implements ActionListener {
	

		//Attributs Privés
	 private JTable tableau;
	  JScrollPane scrollPane;
	  private JComboBox combo = new JComboBox();
	  private JComboBox mois = new JComboBox();
	  private JLabel label = new JLabel("Les visiteurs : ");
	  private JButton btn;
	  private String select1;
	  private String select2;
	
	
		
		private JLabel lbl;

		
		public Panel_liste() {
			
			
		lbl= new JLabel("Mois : ");
		btn = new JButton("Valider");
		select1="Selectionner un visiteur";
		select2="Selectionner un mois";
		

		this.scrollPane = new JScrollPane();
		
		//Ajout des éléments au panel
			combo.addItem(select1);
			mois.addItem(select2);
			this.add(label);
			this.add(combo);
			this.add(lbl);
			this.add(mois);
			this.add(btn);
			combo.addActionListener(this);
			mois.addActionListener(this);
			btn.addActionListener(this);
			this.setBackground(Color.white);
			this.setVisible(true) ;

			//Ajoute les visiteurs à la liste 
			ArrayList <Visiteur> LesVisiteurs =  Modele.getLesVisiteurs();
			for(Visiteur unVisiteur : LesVisiteurs){
				combo.addItem(unVisiteur.getNomVisiteur());
			}
			
			


		}

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource() == combo ){
				String nom = combo.getSelectedItem().toString();
				if(!nom.equals(select1) && !nom.equals(select1)){
					ArrayList <FraisForfait> lesMois =  Modele.getLesMois(Modele.getIdVisiteur(nom));
					mois.removeAllItems();
					
					for ( FraisForfait unMois : Modele.getLesMois(Modele.getIdVisiteur(nom))){
					
					mois.addItem(unMois.getMois());
					
					}
				}
				
				else{
					mois.removeAllItems();
					mois.addItem(select2);
				}
			}
				if(e.getSource() == btn ){
					

				
					Object data[][]= new Object[10][10];
					int i = 0;
					
						data[i][0] =.getNomVisiteur();
						
						i++;
				
					
				
				
					
					
					String [] title = {"Name", "Fiches"};
					this.tableau = new JTable(data,title);
					
					this.tableau.setRowHeight(30);
					

			
					
					
					this.setBackground(Color.white);
				
					this.scrollPane = new JScrollPane(this.tableau);
					this.add(this.scrollPane);
					this.setVisible(true) ;

				 
				

				}
				
				
			}
		
}