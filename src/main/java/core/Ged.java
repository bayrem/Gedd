package core;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;
import java.util.Date;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.filechooser.FileSystemView;

import com.*;

public class Ged {
	
	private List<Element> liste;
	private List<Element> rechList;
	private List<Tag> tags;
	
	public void addTag(String s, String str){
		Tag t = new Tag(s,str);
		for(int i=0;i<tags.size();i++)
			if(tags.get(i).getName().equals(s)){
				tags.get(i).addLivre(str); break;}
		
		tags.add(t);		
	}
	
	public Ged(){
		liste = new ArrayList<Element>();
		tags = new ArrayList<Tag>();
		liste.add(new Doc("ABC"));
		liste.add(new Doc("ABCDE"));
	}
	
	public void afficherElements() {
		for (int i= 0; i< liste.size();i++)
			System.out.println(liste.get(i).getTitre()+" "+liste.get(i).getAuteur()+" "
		+liste.get(i).getDate()+" "+liste.get(i).getType()+" "+liste.get(i).tagstoString()
		+" "+liste.get(i).seriestoString());
		
	}
	
	public void remplirList(Element elem){
		
		liste.add(elem);
		
	}
	
	public void ajouterElement(File f) throws IOException{
		Element elem;
		
		//recuperation de l'extension
		String extenstion = f.getName().substring(f.getName().toString().length()-3);
		System.out.println("extension: "+extenstion);
		
		//set current date
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		
		//test de creation du document
		switch (extenstion) {
		case "jpg": elem = new Photo(f.getName()); elem.setDate(dateFormat.format(date));
			break;
			
		case "flv": elem = new Video(f.getName()); elem.setDate(dateFormat.format(date));
			break;

		default: elem = new Doc(f.getName()); elem.setDate(dateFormat.format(date));
			break;
		}
		
		//test d'ajout dans la liste
		System.out.println(liste.size());
		liste.add(elem);
		System.out.println("fichier ajouter à la ged");
		System.out.println(liste.size());
		
		//test liste
		afficherElements();
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
	
	public void afficherTag(){
		for(int i=0;i<tags.size();i++)
			System.out.println(tags.get(i).getName());
	}
	

}
