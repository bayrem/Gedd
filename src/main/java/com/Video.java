package com;

public class Video extends Element {

	public Video(String name){
		this.setTitre(name);
		this.setType("video");
	}
	
	public Video(String titre, String auteur,String dateCreation, String type){
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
