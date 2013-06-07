package core;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;
import java.sql.Date;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.filechooser.FileSystemView;

import com.*;

public class Ged {
	
	private List<Element> liste;
	private List<Element> rechList;
	
	public Ged(){
		liste = new ArrayList<Element>();
		liste.add(new Doc("ABC"));
		liste.add(new Doc("ABCDE"));
	}
	
	public void afficherElement() {
		for (int i= 0; i< liste.size();i++)
			System.out.println(liste.get(i).getTitre());
	}
	
	public void remplirList(Element elem){
		
		liste.add(elem);
		
	}
	
	public void ajouterElement(File f) throws IOException{
		FileSystemView vueSysteme = FileSystemView.getFileSystemView();
		Element elem;
		
		//recuperation de l'extension
		String extenstion = f.getName().substring(f.getName().toString().length()-3);
		System.out.println("extension: "+extenstion);
		
		//test de creation du document
		switch (extenstion) {
		case "jpg": elem = new Photo(f.getName());
			break;
			
		case "flv": elem = new Video(f.getName());
			break;

		default: elem = new Doc(f.getName());
			break;
		}
		
		
		//recuperation dateModification
		Locale locale = Locale.getDefault();
		NumberFormat nf = NumberFormat.getInstance(locale);
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, locale);
		String dateFile = dateFormat.format(new Date(f.lastModified()));
		elem.setDate(dateFile);
		System.out.println("date de modifacation: "+elem.getDate());
		
		//recuperation de l'auteur
		Path path = Paths.get(f.getAbsolutePath());
		UserPrincipal auteur = Files.getOwner(path);
		String nomAuteur = auteur.getName();
		elem.setAuteur(nomAuteur);
		System.out.println("auteur: "+elem.getAuteur());
		
		//test d'ajout dans la liste
		System.out.println(liste.size());
		liste.add(elem);
		System.out.println("fichier ajouter à la ged");
		System.out.println(liste.size());
		
		//test liste
		for(int i=0; i<liste.size();i++)
			System.out.println(liste.get(i).getTitre()+" "+liste.get(i).getAuteur()+" "+liste.get(i).getDate()+" "+liste.get(i).getType());
	}
	
	public String[] gedToTable(List<Element> lst){
		String[] elem = new String[lst.size()] ;
		for (int i=0; i<lst.size();i++)
			elem[i] = lst.get(i).getTitre();
		return elem;
	}
	
	public List<Element> getList(){
		return this.liste;
	}
	
	
	public List<Element> getRechList(){
		return this.rechList;
	}
	
	public int getListSize(){
		return liste.size();
	}
	
	public void rechercher(String rech){
		rechList = new ArrayList<Element>();
		for(int i=0;i<liste.size();i++){
			if(liste.get(i).getTitre().contains(rech)){
				rechList.add(liste.get(i));
			}
				
		}
		
	}
	

}
