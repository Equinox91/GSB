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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class Fenetre extends JFrame implements ActionListener{

	private JPanel monPanel ;
	private JLabel lblMessage;
	private JLabel lblMessage1;
	private JLabel lblMessage2;
	private JTextField id;
	private JPasswordField mdp;
	private JButton btn;
	


	
	
	public Fenetre(){
		monPanel = new JPanel();
		
		
		this.setTitle("GSB Connexion");
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		
		monPanel.setBackground(new Color(119, 181,254));
		
		lblMessage= new JLabel("Identifiant :");
		id = new JTextField("lolo");
		lblMessage1= new JLabel("Mot de passe:");
		lblMessage2= new JLabel("");
		mdp = new JPasswordField("lolo");
		btn = new JButton("Se connecter");
		this.btn.addActionListener(this);
		 
		 
		 
		//dimension des champs
		 id.setPreferredSize(new Dimension (150,30));
		 mdp.setPreferredSize(new Dimension (150,30));
	
	
		//monPanel.setLayout(new BorderLayout());
		
		
		//ajout au panel
		 monPanel.add(lblMessage, BorderLayout.SOUTH);
		 monPanel.add(id);
		 monPanel.add(lblMessage1,BorderLayout.WEST);
		 monPanel.add(mdp);
		monPanel.add(btn);
		 monPanel.add(lblMessage2,BorderLayout.WEST);
		
	this.getContentPane().add(monPanel);
	 this.setVisible(true) ;
	}
	
	@Override
	public void actionPerformed(java.awt.event.ActionEvent evenement) {
		// TODO Auto-generated method stub
		  if(evenement.getSource()==btn){
			  char[] pass = mdp.getPassword();
			  String passString = new String(pass);
			 if( Modele.ConnexionLesComptables(id.getText(), passString) == false){
					this.add(lblMessage2);
					String chaine = "Echec connexion";
					lblMessage2.setText(chaine);
			 }
			 else{
				 setVisible(false) ;
				 Fenetre_compt uneFenetre1 = new Fenetre_compt() ;
				dispose();
			 }
	
		  }
		 }
}