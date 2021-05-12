package io.altar.jseproject.model;

import java.time.LocalTime;

public class Product {
	
	private int id;
	private String title = "-";
	private String author = "-";
	private float pvp;
	
	
	public Product(String title, String author, float pvp) {
		this.id = LocalTime.now().getNano();
		this.title = title;
		this.author = author;
		this.pvp = pvp;
	}
	
	
	public int getId() { return id; }
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }

	public String getAuthor() { return author; }
	public void setAuthor(String author) { this.author = author; }

	public float getPvp() { return pvp; }
	public void setPvp(float pvp) { this.pvp = pvp; }

	public void printInfo() {
		System.out.println(id + ":\t" + title + "\t" + author + "\t" + pvp);
	}

}
