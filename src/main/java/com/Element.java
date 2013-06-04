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
}
