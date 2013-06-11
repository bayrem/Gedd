package gui;

import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.Element;
import core.Ged;
import javax.swing.JComboBox;


public class MainWindow1 {

	private Ged ged = new Ged();
	MainWindow1 mw = this;
	private Element ele;
	public JFrame frmGed;
	private JTextField textField;
	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public MainWindow1() throws SQLException {
		File doss = new File("C:\\root\\");
  	  	if(!doss.exists())
  		  doss.mkdir();
  	  	//File dbF = new File("DB55.db");
  	  	//if(!dbF.exists())
  	  		//ged.gedBD.CreateTables();
  	  	//else
  	  		ged.gedBD.getElements();
  	  		/*for(int i=0;i<ged.getListSize();i++){
  	  			ged.gedBD.ImporterTag(ged.getList().get(i));
  	  			ged.gedBD.ImporterSerie(ged.getList().get(i));
  	  		}*/
  	  			
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "serial", "unchecked" })
	private void initialize() {
		
		frmGed = new JFrame();
		frmGed.setTitle("GED");
		frmGed.setBounds(100, 100, 813, 502);
		frmGed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGed.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(17, 70, 232, 28);
		textField.setBackground(new Color(255, 255, 255));
		frmGed.getContentPane().add(textField);
		textField.setColumns(10);
		
		final JButton btnRechercher = new JButton("Rechercher");
		
		btnRechercher.setBounds(261, 68, 117, 34);
		frmGed.getContentPane().add(btnRechercher);
		
		final JPanel panel = new JPanel();
		panel.setBounds(465, 110, 320, 345);
		panel.setBorder((Border) new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Metadonnees", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		frmGed.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTitre = new JLabel("Titre :");
		lblTitre.setBounds(17, 38, 61, 16);
		panel.add(lblTitre);
		
		JLabel lblAuteur = new JLabel("Auteur :");
		lblAuteur.setBounds(17, 66, 61, 16);
		panel.add(lblAuteur);
		
		JLabel lblDateDeCration = new JLabel("Date de creation :");
		lblDateDeCration.setBounds(17, 102, 121, 16);
		panel.add(lblDateDeCration);
		
		JLabel lblTags = new JLabel("Tags :");
		lblTags.setBounds(17, 161, 61, 16);
		panel.add(lblTags);
		
		JLabel lblSrie = new JLabel("Serie :");
		lblSrie.setBounds(17, 235, 61, 16);
		panel.add(lblSrie);
		
		final JLabel lblNewLabel = new JLabel("N/A");
		lblNewLabel.setBounds(140, 38, 138, 16);
		panel.add(lblNewLabel);
		
		final JLabel lblNewLabel_1 = new JLabel("N/A");
		lblNewLabel_1.setBounds(140, 66, 127, 16);
		panel.add(lblNewLabel_1);
		
		final JLabel lblNewLabel_2 = new JLabel("N/A");
		lblNewLabel_2.setBounds(140, 102, 109, 16);
		panel.add(lblNewLabel_2);
		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(140, 159, 109, 20);
		panel.add(comboBox);
		
		final JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(140, 233, 109, 20);
		panel.add(comboBox_1);
		
		JButton btnNewButton_1 = new JButton("Ouvrir");
		btnNewButton_1.setBounds(17, 285, 135, 49);
		panel.add(btnNewButton_1);
		btnNewButton_1.setIcon(new ImageIcon("images/ouvrir.jpg"));
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(193, 285, 117, 49);
		panel.add(btnModifier);
		btnModifier.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable()
			    {
			      public void run()
			      {
			    	  if(ele != null){
							MetaWindow frame = new MetaWindow(ged, ele.getTitre());
							frame.setVisible(true);
						}
						else {
							String st="Aucun element choisit";
							JOptionPane.showMessageDialog(null,st);
						}
			      }
			    });
			}
		});
		btnModifier.setIcon(new ImageIcon("images/custom_dialog.png"));
		btnNewButton_1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				File f = new File("C:\\root\\"+ele.getTitre());
				if(f.canExecute()){
					Desktop dt = Desktop.getDesktop();
				    try {
						dt.open(f);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
					
			}
		});
		
		final JLabel lblNewLabel_5 = new JLabel("Apperçu non valable");
		lblNewLabel_5.setIcon(new ImageIcon("images/dossier_GED.png"));
		lblNewLabel_5.setBounds(10, 22, 130, 126);
		
		final JPanel panel_1 = new JPanel();
		panel_1.setBounds(288, 113, 150, 159);
		panel_1.setBorder(new TitledBorder(null, "Aper\u00E7u", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		frmGed.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.add(lblNewLabel_5);
		
		
		JButton btnAjouterDocument = new JButton("Ajouter ");
		
		btnAjouterDocument.setBounds(7, 0, 169, 49);
		btnAjouterDocument.setIcon(new ImageIcon("images/dossier-ajouter-icone-7846-32.png"));
		frmGed.getContentPane().add(btnAjouterDocument);
		
		JButton btnNewButton = new JButton("Diffuser");
		btnNewButton.setBounds(176, 0, 158, 49);
		btnNewButton.setIcon(new ImageIcon("images/icone_partager.png"));
		frmGed.getContentPane().add(btnNewButton);
		
		JList list = new JList();
		list.setBounds(26, 258, 130, -47);
		frmGed.getContentPane().add(list);
		
		
		final JList list_1 = new JList();
		
		//manipulateur de selection des element de la liste
		class MonListSelectionListener implements ListSelectionListener
		{
			public void valueChanged(ListSelectionEvent e)
			{
				//System.out.println("doc_choisi:" + list_1.getSelectedValue() );
				for(int i=0;i<ged.getListSize();i++)
					if(ged.getList().get(i).getTitre().equals(list_1.getSelectedValue()))
						ele = ged.getList().get(i);
				lblNewLabel.setText(ele.getTitre());
				lblNewLabel_1.setText(ele.getAuteur());
				lblNewLabel_2.setText(ele.getDate());
				for(int i=0;i<ele.getTags().size();i++)
				comboBox.addItem(ele.getTags().get(i));
				for(int i=0;i<ele.getSeries().size();i++)
					comboBox_1.addItem(ele.getSeries().get(i));
				switch(ele.getType()){
				case "document" : 
					break;
				case "photo" : {/*
					JLabel lblNewLabel_5 = new JLabel("Apperçu non valable");
					lblNewLabel_5.setIcon(new ImageIcon("images/degache.jpg"));
					lblNewLabel_5.setBounds(16, 30, 168, 239);
					panel_1.add(lblNewLabel_5);
					panel_1.revalidate();*/
				}
					break;
				case "video" :
					break;
				}
				
			}	
		}
		
		list_1.setBounds(27, 110, 237, 345);
		// n'autorise qu'une seule ligne de selection
		list_1.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		// ajoute un écouteur
		list_1.addListSelectionListener( new MonListSelectionListener() );
		list_1.setModel(new AbstractListModel() {
			String[] values= ged.gedToTable(ged.getList());
            public int getSize() { return ged.getListSize(); }
            public Object getElementAt(int i) { return values[i]; }

		});
		list_1.setToolTipText("");
		list_1.setBorder(new TitledBorder(null, "Documents", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		frmGed.getContentPane().add(list_1);
		// Action listener du bouton ajout
		btnAjouterDocument.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				SwingUtilities.invokeLater(new Runnable()
			    {
			      public void run()
			      {
		                  File f ;
		                  javax.swing.JFileChooser jFileChooser1 = new JFileChooser();
		                  jFileChooser1.showOpenDialog(null);
		                  f = jFileChooser1.getSelectedFile();
		                  System.out.println(f.getName());
		                  System.out.println(f.getAbsolutePath());
							ged.ajouterElement(f);
						if(ged.ajouterElement(f)){	
		                //creation ou modification des metadonnées
		                  MetaWindow frame = new MetaWindow(ged,f.getName());
		  				  frame.setVisible(true);
						}
		               // copie physique des document
		               // ************************************
		                  try{
		                      File f2 = new File("C:\\root\\"+f.getName());
		                      InputStream in = new FileInputStream(f);

		                      //For Overwrite the file.
		                      OutputStream out = new FileOutputStream(f2);

		                      byte[] buf = new byte[1024];
		                      int len;
		                      while ((len = in.read(buf)) > 0){
		                        out.write(buf, 0, len);
		                      }
		                      in.close();
		                      out.close();
		                      System.out.println("File copied.");
		                      System.out.println(f2.getAbsolutePath());
		                    }
		                    catch(FileNotFoundException ex){
		                      System.out.println(ex.getMessage() + " in the specified directory.");
		                      System.exit(0);
		                    }
		                    catch(IOException e){
		                      System.out.println(e.getMessage());      
		                    }
		                //actualisation de la liste
		                  list_1.setModel(new javax.swing.AbstractListModel() {
		          			String[] values= ged.gedToTable(ged.getList());
		                      public int getSize() { return ged.getListSize(); }
		                      public Object getElementAt(int i) { return values[i]; }
		          		});
			      }
			    });
				
			}
		});
		
		// Actionlistner du bouton recherche
		btnRechercher.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println(btnRechercher.getText());
				ged.afficherTag();
				ged.afficherSerie();
		    	ged.rechercher(textField.getText());
		    	list_1.setModel(new javax.swing.AbstractListModel() {
		            String[] strings =  ged.gedToTable(ged.getRechList());
		            public int getSize() { return strings.length; }
		            public Object getElementAt(int i) { return strings[i]; }
		        });
			}
		});
	}
}
