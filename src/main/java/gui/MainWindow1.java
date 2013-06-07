package gui;

import java.awt.Color;
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
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import com.SQLiteDemo;

import core.Ged;


public class MainWindow1 {

	private Ged ged = new Ged();
	public JFrame frmGed;
	private SQLiteDemo gedBD = new SQLiteDemo(ged);
	private JTextField textField;
	private JFileChooser choixfichier1;
	private String dirName;
	private String [] column ={"Titre" , "Auteur" , "Date" , "Tag"};

	
	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public MainWindow1() throws SQLException {
		//gedBD.CreateTables();
		/*if(gedBD.getElements().equals(null))
			gedBD.CreateTables();
		
		else gedBD.getElements();*/
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(140, 38, 138, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(140, 66, 127, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(140, 102, 109, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(140, 130, 61, 16);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(140, 158, 127, 16);
		panel.add(lblNewLabel_4);
		
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
		list_1.setBounds(27, 110, 150, 291);
		list_1.setModel(new AbstractListModel() {
			String[] values= ged.gedToTable(ged.getList());
            public int getSize() { return ged.getListSize(); }
            public Object getElementAt(int i) { return values[i]; }

		});
		list_1.setToolTipText("");
		list_1.setBorder(new TitledBorder(null, "Documents", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		frmGed.getContentPane().add(list_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(188, 110, 201, 291);
		panel_1.setBorder(new TitledBorder(null, "Aper\u00E7u", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		frmGed.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("images/degache.jpg"));
		lblNewLabel_5.setBounds(16, 30, 168, 239);
		panel_1.add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("Ouvrir");
		btnNewButton_1.setBounds(401, 352, 135, 49);
		btnNewButton_1.setIcon(new ImageIcon("images/ouvrir.jpg"));
		btnNewButton_1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
			}
		});
		frmGed.getContentPane().add(btnNewButton_1);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBounds(547, 352, 117, 49);
		btnModifier.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				MetaWindow frame = new MetaWindow(ged, null);
				frame.setVisible(true);
			}
		});
		btnModifier.setIcon(new ImageIcon("images/custom_dialog.png"));
		frmGed.getContentPane().add(btnModifier);
		
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
		                      File f2 = new File("C:\\root\\"+f.getName());
		                      InputStream in = new FileInputStream(f);

		                      //For Append the file.
		                      //OutputStream out = new FileOutputStream(f2,true);

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
                list_1.setModel(new javax.swing.AbstractListModel() {
        			String[] values= ged.gedToTable(ged.getList());
                    public int getSize() { return ged.getListSize(); }
                    public Object getElementAt(int i) { return values[i]; }

        		});
			}
		});
		
		btnRechercher.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				System.out.println(btnRechercher.getText());
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
