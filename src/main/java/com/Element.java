package com;

import java.util.List;

public abstract class Element {
	
	private String titre;
	private String auteur;
	private String dateCreation;
	private String type;
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
		this.titre = s;
		
	}
	
	public void setAuteur(String s){
		this.auteur = s;
	}
	
	public void setDate(String s){
		this.dateCreation = s;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> setTags()
	{
		return this.tags;
	}
	public List<String> setSerie()
	{
		return this.series;
	}
}
