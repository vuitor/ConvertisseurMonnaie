import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Convertisseur extends JFrame implements ActionListener
{
	JLabel lbTitre = new JLabel ("Mon convertisseur");
	JButton btEuro = new JButton ("Euro");
	JButton btFr = new JButton ("Franc");
	JButton btApropos = new JButton ("A propos");
	JButton btTaux = new JButton ("Taux");
	JButton btAc = new JButton ("AC");
	JButton btQuitter = new JButton ("Quitter");
	
	JTextField txtMt = new JTextField();
	
	//Definition attribut de la classe
	private String devise;
	private float taux;
	
	
	public Convertisseur()
	{
		//Initialisation
		this.devise = "Franc";
		this.taux = (float) 6.56;
		
		//Titre de la fênetre
		this.setTitle("Mon convertisseur");
		
		//Paramètre fênetre (x, y, taille fênetre x, fênetre y)
		this.setBounds(200, 200, 450, 300);
		
		//Pas de présentation par défaut - Eliminer le layout par défaut
		this.setLayout(null);
		
		//Eliminer la resize
		this.setResizable(false);
		
		//Placement des boutons
		this.lbTitre.setBounds(150, 20, 300, 20);
		this.add(this.lbTitre);
		
		this.btFr.setBounds(50, 100, 120, 20);
		this.add(this.btFr);
		
		this.txtMt.setBounds(170, 100, 100, 20);
		this.add(this.txtMt);
		
		this.btEuro.setBounds(290, 100, 100, 20);
		this.add(this.btEuro);
		
		this.btApropos.setBounds(50, 170, 100, 20);
		this.add(this.btApropos);
		
		this.btAc.setBounds(170, 170, 100, 20);
		this.add(this.btAc);
		
		this.btTaux.setBounds(290, 170, 100, 20);
		this.add(this.btTaux);
		
		this.btQuitter.setBounds(170, 200, 100, 20);
		this.add(this.btQuitter);
		
		//Rentre les boutons cliquables ou écoutables
		this.btAc.addActionListener(this);
		this.btQuitter.addActionListener(this);
		this.btApropos.addActionListener(this);
		this.btTaux.addActionListener(this);
		this.btEuro.addActionListener(this);
		this.btFr.addActionListener(this);
		///////////////////////////////////////////////////////////
		
		//Rendre la fênetre visible
		this.setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		Convertisseur unC = new Convertisseur();
	}

	@Override
	public void actionPerformed(ActionEvent unEvent)
	{
		if(unEvent.getSource() == this.btAc)
		{
			this.txtMt.setText("");	//Clear le montant
		}
		else if (unEvent.getSource() == this.btQuitter)
		{
			this.dispose(); // Arrêt de l'application
		}
		else if(unEvent.getSource() == this.btEuro)
		{
			float mt;
			try
			{
				mt = Float.parseFloat(this.txtMt.getText());
				mt = (float) (mt/this.taux); // Conversion au taux.
				//mt = (float) (mt/6.56); // Conversion Francs vers Euro.
				this.txtMt.setText("" + mt);
			}
			catch (NumberFormatException exp)
			{
				JOptionPane.showMessageDialog(this, "Erreur de saisie sur le format du montant !", "Erreur", JOptionPane.INFORMATION_MESSAGE);
				this.txtMt.setText("");
			}
		}
		else if(unEvent.getSource() == this.btFr)
		{
			float mt;
			try
			{
				mt = Float.parseFloat(this.txtMt.getText());
				mt = (float) (mt*this.taux); // Conversion au Taux
				//mt = (float) (mt*6.56); // Conversion Francs vers Euro.
				this.txtMt.setText("" + mt);
			}
			catch (NumberFormatException exp)
			{
				JOptionPane.showMessageDialog(this, "Erreur de saisie sur le format du montant !", "Erreur", JOptionPane.INFORMATION_MESSAGE);
				this.txtMt.setText("");
			}
		}
		else if(unEvent.getSource() == this.btApropos)
		{
			JOptionPane.showMessageDialog(this, "Logiciel crée en 2016\n" + "par Victor L.\n", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(unEvent.getSource() == this.btTaux)
		{
			try
			{
				this.devise = JOptionPane.showInputDialog("Saisie de la devise : ", "Nom de la devise");
			}
			catch (Exception exp)
			{
				this.devise = "Franc";
			}
			
			try
			{
				this.taux = Float.parseFloat(JOptionPane.showInputDialog(this, "Saisie des données"));
			}
			catch (NumberFormatException exp)
			{
				JOptionPane.showMessageDialog(this, "Erreur de saisie du taux", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
				this.taux = (float) 6.56;
			}
			catch(Exception exp)
			{
				this.taux = (float) 6.56;
			}
			
			if(this.devise == null || this.devise.equals(""))
			{
				this.devise = "Franc";
			}
			this.btFr.setText(this.devise);
		}
	}

}
