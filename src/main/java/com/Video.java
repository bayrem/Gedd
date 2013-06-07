package com;

public class Video extends Element {

	public Video(String name){
		this.setTitre(name);
		this.setType("video");
	}
	
	public Video(String titre, String auteur,String dateCreation){
		this.setAuteur(auteur);
		this.setTitre(titre);
		this.setDate(dateCreation);
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
