package com;

import java.util.ArrayList;
import java.util.List;

public class Serie {
	
	private String name;
	private List<String> lstLivre = new ArrayList<String>();
	
	public Serie(String name, String lvr){
		this.name = name;
		this.lstLivre.add(lvr);
	}
	
	public List<String> getLstLivre() {
		return lstLivre;
	}
	
	public void addLivre(String str){
		this.lstLivre.add(str);
	}
	
	public void setLstLivre(List<String> lstLivre) {
		this.lstLivre = lstLivre;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
