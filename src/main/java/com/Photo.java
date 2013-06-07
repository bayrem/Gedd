package com;

public class Photo extends Element {

	public Photo(String name){
		this.setTitre(name);
		this.setType("photo");
	}
	
	public Photo(String titre, String auteur,String dateCreation, String type){
		this.setAuteur(auteur);
		this.setTitre(titre);
		this.setDate(dateCreation);
		this.setType(type);
	}
	
	
	@Override
	public void modifier() {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void ouvrir() {
		// TODO Auto-generated method stub
		
	}

}
