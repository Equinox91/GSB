import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Fenetre_compt extends JFrame implements ActionListener {
	

		//Attributs Privés
	
	    private JPanel monPanel ;
	
		private JMenuBar menu ;
		
		
		private JMenuItem listeV ;
		private JMenuItem listeF ;
		private JMenuItem validerF ;
		private JMenuItem paiement;
		private JMenuItem quitter ;
		
		public Fenetre_compt() {
			
			this.setTitle("GSB Comptable");
			this.setSize(500, 400);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
			
	
			menu = new JMenuBar() ;
			
			//instanciation du menu 
			JMenu menuPdt = new JMenu("Menu");
			JMenu menuPg = new JMenu("Quitter");
			
			//instanciation des items	
			listeV = new JMenuItem("Liste Visiteurs");
			listeF= new JMenuItem("Liste Fiche");
			validerF = new JMenuItem("Valider fiche");
			paiement= new JMenuItem("Paiement");
			quitter = new JMenuItem("à plus ;)");
		
			
			menu.setPreferredSize(new Dimension(40, 60));
			menu.setBackground(new Color(40,40,50));
		
			menu.setOpaque(false);
			
			//ajout des item au menu
			menuPdt.add(listeV);
			menuPdt.add(listeF);
			menuPdt.add(validerF);
			menuPdt.add(paiement);
			menuPg.add(quitter); 
		
			
			listeV.addActionListener(this);
			listeF.addActionListener(this);
			validerF.addActionListener(this);
			paiement.addActionListener(this);
			quitter.addActionListener(this);
		
			

			menu.add(menuPdt);
			menu.add(menuPg);
			
			
			this.setJMenuBar(menu);
			
			this.setBackground(new Color(119, 181,254));
		

			this.setVisible(true) ;

		 
		

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
           if(e.getSource() == quitter ) {
				
				
				System.exit(0) ;
			}
           if(e.getSource() == listeV){
        	 Panel_liste  Panel_list = new  Panel_liste();
        	this.setContentPane(Panel_list);
        	getContentPane().revalidate();
        	  
           }
           if(e.getSource() == listeF){
          	 Panel_listF  Panel_listF = new  Panel_listF();
          	this.setContentPane(Panel_listF);
          	getContentPane().revalidate();
          	  
             }
           if(e.getSource() == validerF){
            	 Panel_Valide  Panel_valid = new  Panel_Valide();
            	this.setContentPane(Panel_valid);
            	getContentPane().revalidate();
            	  
               }
           if(e.getSource() == paiement){
          	 Panel_Paiement  Panel_p = new  Panel_Paiement();
          	this.setContentPane(Panel_p);
          	getContentPane().revalidate();
          	  
             }
		}
}