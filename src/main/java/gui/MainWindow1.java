package gui;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
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
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.Element;
import com.SQLiteDemo;

import core.Ged;
import javax.swing.JScrollBar;


public class MainWindow1 {

	private Ged ged = new Ged();
	private Element ele;
	public JFrame frmGed;
	private JTextField textField;
	private JFileChooser choixfichier1;
	private String dirName;
	private String [] column ={"Titre" , "Auteur" , "Date" , "Tag"};

	
	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public MainWindow1() throws SQLException {
		if(ged.gedBD.getElements().equals(null))
			//ged.gedBD.CreateTables();
			ged.gedBD.DropAllTable();
		//else ged.gedBD.getElements();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmGed = new JFrame();
		frmGed.setTitle("GED");
		frmGed.setBounds(100, 100, 680, 452);
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
		
		JPanel panel = new JPanel();
		panel.setBounds(401, 110, 263, 213);
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
		lblTags.setBounds(17, 130, 61, 16);
		panel.add(lblTags);
		
		JLabel lblSrie = new JLabel("Serie :");
		lblSrie.setBounds(17, 158, 61, 16);
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
		
		final JLabel lblNewLabel_3 = new JLabel("N/A");
		lblNewLabel_3.setBounds(140, 130, 61, 16);
		panel.add(lblNewLabel_3);
		
		final JLabel lblNewLabel_4 = new JLabel("N/A");
		lblNewLabel_4.setBounds(140, 158, 127, 16);
		panel.add(lblNewLabel_4);
		
		final JLabel lblNewLabel_5 = new JLabel("New label");
		File f = new File("images/degache.jpg");
		lblNewLabel_5.setIcon(new ImageIcon("images/dossier_GED.png"));
		lblNewLabel_5.setBounds(16, 30, 168, 239);
		
		final JPanel panel_1 = new JPanel();
		panel_1.setBounds(188, 110, 201, 291);
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
				lblNewLabel_3.setText(ele.tagstoString());
				lblNewLabel_4.setText(ele.seriestoString());
				switch(ele.getType()){
				case "document" : 
					break;
				case "photo" : lblNewLabel_5.setIcon(new ImageIcon("C:\\root\\"+ele.getTitre())); panel_1.add(lblNewLabel_5);
					break;
				case "video" :
					break;
				}
				lblNewLabel_5.setIcon(new ImageIcon("images/degache.jpg"));
			}	
		}
		
		list_1.setBounds(27, 110, 150, 291);
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
		
		
		JButton btnNewButton_1 = new JButton("Ouvrir");
		btnNewButton_1.setBounds(401, 352, 135, 49);
		btnNewButton_1.setIcon(new ImageIcon("images/ouvrir.jpg"));
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
		frmGed.getContentPane().add(btnNewButton_1);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(547, 352, 117, 49);
		btnModifier.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if(ele != null){
					MetaWindow frame = new MetaWindow(ged, ele.getTitre());
					frame.setVisible(true);
				}
				
				else {
					JPopupMenu pop = new JPopupMenu();
					JLabel jlb = new JLabel();
					jlb.setText("Aucun element choisit");
						pop.add(jlb);
				}
			}
		});
		btnModifier.setIcon(new ImageIcon("images/custom_dialog.png"));
		frmGed.getContentPane().add(btnModifier);
		
		
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
		                  try {
							ged.ajouterElement(f);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
		                //creation ou modification des metadonnées
		                  MetaWindow frame = new MetaWindow(ged,f.getName());
		  				  frame.setVisible(true);
		  				  
		               // copie physique des document
		               // ************************************
		                  try{
		                	  File doss = new File("C:\\root\\");
		                	  if(!doss.exists())
		                		  doss.mkdir();
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
		                  
			      }
			    });
				
				//***************************************
				
				//actualisation de la liste
                list_1.setModel(new javax.swing.AbstractListModel() {
        			String[] values= ged.gedToTable(ged.getList());
                    public int getSize() { return ged.getListSize(); }
                    public Object getElementAt(int i) { return values[i]; }

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
