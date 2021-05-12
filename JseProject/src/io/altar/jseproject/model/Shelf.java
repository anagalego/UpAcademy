package io.altar.jseproject.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Shelf {
	
	private int id;
	private String name;
	private List<Product> products;
	
	public Shelf(String name) {
		this.id = LocalTime.now().getNano();
		this.name = name;
		this.products = new ArrayList<>();
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public void addProducts(Product... product) {	
		for(Product p : product) {
			this.products.add(p);
		}
	}

	public void removeProducts(Product... product) {
		for(Product p : product) {
			this.products.remove(p);
		}
	}
	

	public void printInfo() {
		System.out.println(id + ":\t" + name + "\t" + products.size() + " Books");
	}
	
	public void printBooks() {
		for(Product p : this.products) {
			p.printInfo();
		}
	}
}
