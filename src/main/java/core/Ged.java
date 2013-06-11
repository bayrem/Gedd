package core;



import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.*;

public class Ged {
	
	private List<Element> liste;
	private List<Element> rechList;
	private List<Tag> tags;
	private List<Serie> series;
	public SQLiteDemo gedBD = new SQLiteDemo(this);
	
	public boolean addTag(String s, String str){
		Tag t = new Tag(s,str);
		for(int i=0;i<tags.size();i++)
			if(tags.get(i).getName().equals(s)){
				tags.get(i).addLivre(str); return true;}
		
		tags.add(t);		
		return true;
	}
	
	public boolean addSerie(String s, String str){
		Serie s1 = new Serie(s,str);
		for(int i=0;i<series.size();i++)
			if(series.get(i).getName().equals(s)){
				series.get(i).addLivre(str); return true;}
		
		series.add(s1);		
		return true;
	}
	
	public Ged(){
		liste = new ArrayList<Element>();
		tags = new ArrayList<Tag>();
		series = new ArrayList<Serie>();
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
		String extenstion = f.getName().substring(f.getName().toString().length()-3).toLowerCase();
		System.out.println("extension: "+extenstion);
		
		//set current date
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		
		//test de creation du document
		switch (extenstion) {
		case ("jpg"): elem = new Photo(f.getName()); elem.setDate(dateFormat.format(date));
			break;
			
		case ("png"): elem = new Photo(f.getName()); elem.setDate(dateFormat.format(date));
		break;
			
		case "flv": elem = new Video(f.getName()); elem.setDate(dateFormat.format(date));
			break;
			
		case "wmv": elem = new Video(f.getName()); elem.setDate(dateFormat.format(date));
		break;

		default: elem = new Doc(f.getName()); elem.setDate(dateFormat.format(date));
			break;
		}
		
		//test d'ajout dans la liste
		System.out.println(liste.size());
		liste.add(elem);
		System.out.println("fichier ajouter à la ged");
		System.out.println(liste.size());
		
		//test affichache de la liste
		afficherElements();
		
		//insertion de l'element dans la base de donnee
		this.gedBD.InsertDocument(elem);
		for(int i=0;i<elem.getTags().size();i++)
			this.gedBD.InsertTag(elem, elem.getTags().get(i));
		for(int j=0;j<elem.getSeries().size();j++)
			this.gedBD.InsertSerie(elem, elem.getSeries().get(j));
		
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
		
		if(rech.equals(""))
			rechList = liste;
		else{
			// recherche par mot cle**********************
			for(int i=0;i<liste.size();i++){
				if(liste.get(i).getTitre().contains(rech)){
					rechList.add(liste.get(i));
				}	
			}
			//********************************************
			rechercheParTag(rech);
			rechercheParSerie(rech);
		}
		
	}
	
	private void rechercheParTag(String rech){
		// recherche par tag**************************
				for(int i=0; i<tags.size();i++){
					if(tags.get(i).getName().equals(rech)){
						for (int j=0; j<liste.size();j++){
							for(int i1=0;i1<tags.get(i).getLstLivre().size();i1++){
								if(tags.get(i).getLstLivre().get(i1).equals(liste.get(j).getTitre()))
									rechList.add(liste.get(j));
							}
						}
					}	
				}
				//********************************************
	}
	
	private void rechercheParSerie(String rech){
		// recherche par tag**************************
				for(int i=0; i<series.size();i++){
					if(series.get(i).getName().equals(rech)){
						for (int j=0; j<liste.size();j++){
							for(int i1=0;i1<series.get(i).getLstLivre().size();i1++){
								if(series.get(i).getLstLivre().get(i1).equals(liste.get(j).getTitre()))
									rechList.add(liste.get(j));
							}
						}
					}	
				}
				//********************************************
	}
	
	public void afficherTag(){
		for(int i=0;i<tags.size();i++)
			System.out.println(tags.get(i).getName());
	}
	
	public void afficherSerie(){
		for(int i=0;i<series.size();i++)
			System.out.println(series.get(i).getName());
	}
	

}
