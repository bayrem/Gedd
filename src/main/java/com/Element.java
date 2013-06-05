package com;

import java.util.List;

public abstract class Element {
	
	private String titre;
	private String auteur;
	private String dateCreation;
	private List<String> tags;
	private List<String> series;
	
	public abstract void modifier();
	public abstract void ouvrir();
	
	public String getTitre(){
		return this.titre;
	}
	
	public String getAuteur(){
		return this.auteur;
	}
	
	public String getDate(){
		return this.dateCreation;
	}
	
	public void setTitre(String s){
		
	}
	
	public void setAuteur(String s){
		
	}
	
	public void setDate(String s){
		
	}
}
