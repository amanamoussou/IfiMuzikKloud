package org.ifi.com.muzikKloud.entity;

public class SongTempUpdate {
	
	public String ex_titre;
	public String titre;
	public int date;
	public String artiste;
	public String fichier;
	public String[] artistes;
	public String albums;
	public String[] genres;
	
	//Introducing the dummy constructor
    public SongTempUpdate() {
    }
    
	public SongTempUpdate(String titre, int date, String artist, String file){
		this.titre = titre;
		this.artiste = artist;
		this.date = date;
		this.fichier = file;
	}
	
}