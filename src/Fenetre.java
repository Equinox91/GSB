	import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Fenetre extends JFrame implements ActionListener{


	private JPanel monPanel ;

	
	
	public Fenetre(){
		
		this.setTitle("GSB"); 
		
		this.setLocationRelativeTo(null);
	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setSize(500, 400);
		this.setResizable(false); 
		
		

	

		//Les autres panel
		Panel_Connexion monPanelAccueil = new Panel_Connexion();
		this.getContentPane().add(monPanelAccueil);

		
		
		this.setVisible(true); 
		}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

	
	