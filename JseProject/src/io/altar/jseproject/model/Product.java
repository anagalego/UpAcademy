package io.altar.jseproject.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Product {
	
	private int id;
	private String name;
	private List<Shelf> shelves; 
	private float tax;
	private float pvp;
	private float discount;
	
	
	public Product(String name, float tax, float pvp, float discount) {
		this.id = LocalTime.now().getNano();
		this.name = name;
		this.shelves = new ArrayList<>();
		this.tax = tax;
		this.pvp = pvp;
		this.discount = discount;
	}	
	
	public int getId() { return id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public List<Shelf> getShelves() {return shelves; }	
	public void addToShelves(Shelf... shelves) {	
		for(Shelf s : shelves) {
			this.shelves.add(s);
			s.setProduct(this);
		}
	}
	public void removeFromShelves(Shelf... shelves) {
		for(Shelf s : shelves) {
			this.shelves.remove(s);
			s.setProduct(null);
		}
	}
	public void printShelves() {
		for(Shelf s : this.shelves) {
			s.printInfo();
		}
	}
	
	public float getTax() { return tax; }
	public void setTax(float tax) { this.tax = tax; }
	
	public float getPvp() { return pvp; }
	public void setPvp(float pvp) { this.pvp = pvp; }
	
	public float getDiscount() { return discount; }
	public void setDiscount(float discount) { this.discount = discount; }
	
	public void printInfo() {
		System.out.println(id + "\t" + name + "\t" + pvp + "€\t" + tax + "%\t" + discount + "%\tAvailable in " + shelves.size() + " SHELVES.");
	}

}
