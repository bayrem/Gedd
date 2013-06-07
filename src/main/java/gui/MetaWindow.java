package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;

import core.Ged;


public class MetaWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5847650559150958504L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	 private JTextField textField_3;
	 private JTextField textField_4;


	/**
	 * Create the frame.
	 */
	public MetaWindow(final Ged ged, final String titre) {
		setTitle("M\u00E9tadonn\u00E9e");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 535, 261);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFichier = new JMenu("Fichier");
		menuBar.add(mnFichier);
		
		JMenuItem mntmQuitter = new JMenuItem("Quitter");
		mntmQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//this.dispose();
			}
		});
		mnFichier.add(mntmQuitter);
		
		JMenu mnEdition = new JMenu("Edition");
		menuBar.add(mnEdition);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(22, 17, 484, 227);
		panel.setBorder(new TitledBorder(null, "Metadonnee", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		contentPane.add(panel);
		
		textField = new JTextField();
		textField.setBounds(92, 24, 134, 28);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 //input = textField.getText();
				
			}
		});
		panel.setLayout(null);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(92, 76, 134, 28);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(92, 129, 134, 28);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTitre = new JLabel("Titre :");
		lblTitre.setBounds(19, 30, 61, 16);
		panel.add(lblTitre);
		
		JLabel lblAuteur = new JLabel("Auteur :");
		lblAuteur.setBounds(19, 82, 61, 16);
		panel.add(lblAuteur);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setBounds(19, 135, 61, 16);
		panel.add(lblDate);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setIcon(new ImageIcon("images/enreg.jpg"));
		btnEnregistrer.setBounds(324, 121, 136, 44);
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for (int i=0;i<ged.getListSize();i++)
					if(ged.getList().get(i).getTitre().equals(titre)){
						if(!textField.getText().isEmpty())
							ged.getList().get(i).setTitre(textField.getText());
						if(!textField_1.getText().isEmpty())
							ged.getList().get(i).setAuteur(textField_1.getText());
						if(!textField_2.getText().isEmpty())
							ged.getList().get(i).setDate(textField_2.getText());
						if(!textField_3.getText().isEmpty())
							ged.getList().get(i).setTags(textField_3.getText()+",");
						if(!textField_4.getText().isEmpty())
							ged.getList().get(i).setSeries(textField_4.getText()+",");
						
					}
						
				ged.afficherElements();
				dispose();
			}
		});
		panel.add(btnEnregistrer);
		
		JLabel lblNewLabel = new JLabel("Tag :");
		lblNewLabel.setBounds(260, 30, 61, 16);
		panel.add(lblNewLabel);
		
		textField_3 = new JTextField();
		textField_3.setBounds(326, 24, 134, 28);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblSrie = new JLabel("S\u00E9rie :");
		lblSrie.setBounds(260, 82, 61, 16);
		panel.add(lblSrie);
		
		textField_4 = new JTextField();
		textField_4.setBounds(326, 76, 134, 28);
		panel.add(textField_4);
		textField_4.setColumns(10);
	}
}
