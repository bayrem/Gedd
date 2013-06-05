package core;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.*;

public class Ged {
	
	private List<Element> liste = new ArrayList<Element>();
	
	public void afficherElement() {
	}
	
	public void ajouterElement(File f){
		
		liste.add(new Doc(f.getName()));
		
	}
	

}
