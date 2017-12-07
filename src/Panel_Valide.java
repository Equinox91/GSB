import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class Panel_Valide extends JPanel implements ActionListener {
	

		//Attributs Privés
	

	
	
		
		private JLabel lblMessage1;

		
		public Panel_Valide() {
			
	
	
			lblMessage1= new JLabel("Valide");
	
			

			this.add(lblMessage1);
			
			
			this.setBackground(Color.white);
		

			this.setVisible(true) ;

		 
		

		}

		@Override
		public void actionPerformed(ActionEvent e) {

      
		}
}