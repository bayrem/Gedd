package com;

import java.util.ArrayList;
import java.util.List;

public abstract class Element {
	
	private String titre;
	private String auteur;
	private String dateCreation;
	private String type;
	private List<String> tags = new ArrayList<String>();
	private List<String> series = new ArrayList<String>();
	
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
	
	public void setTags(String s)
	{
		int j=0;
		for (int i=0; i<s.length();i++){
			if(s.charAt(i) == ','){
				String str = s.substring(j, i);
				j=i+1;
					if(tags.isEmpty() || !tags.contains(str))
						tags.add(str);
			}
		}
	}
	
	public void setSeries(String s)
	{
		int j=0;
		for (int i=0; i<s.length();i++){
			if(s.charAt(i) == ','){
				String str = s.substring(j, i);
				j=i+1;
					if(series.isEmpty() || !series.contains(str))
						series.add(str);
			}
		}
	}
	
	public List<String> getTags() {
		// TODO Auto-generated method stub
		return this.tags;
	}
	
	public List<String> getSeries() {
		// TODO Auto-generated method stub
		return this.series;
	}
	
	public String tagstoString(){
		String s="";
		if(!tags.isEmpty())
			for(int i=0;i<tags.size();i++)
				s=s+" "+tags.get(i);
		return s;
	}
	
	public String[] listToTable(List<String> lst){
		String[] elem = new String[lst.size()] ;
		for (int i=0; i<lst.size();i++)
			elem[i] = lst.get(i);
		return elem;
	}
	
	public String seriestoString(){
		String s="";
		if(!series.isEmpty())
			for(int i=0;i<series.size();i++)
				s=s+" "+series.get(i);
		return s;
	}
}
