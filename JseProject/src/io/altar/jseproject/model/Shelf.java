package io.altar.jseproject.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Shelf {
	
	private int id;
	private String name;
	private int capacity;
	private Product product;
	private float price;
	
	public Shelf(String name, int capacity, float price) {
		this.id = LocalTime.now().getNano();
		this.name = name;
		this.capacity = capacity;
		this.price = price;
	}
	
	public int getId() { return id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public int getCapacity() { return capacity; }
	public void setCapacity(int capacity) { this.capacity = capacity; }

	public Product getProduct() { return product; }
	public void setProduct(Product product) { this.product = product; }
	
	public float getPrice() { return price; }
	public void setPrice(float price) { this.price = price; }
	

	public void printInfo() {
		System.out.println(id + "\t" + name + "\t" + capacity + "\t" + price);
		if(product != null) {
			System.out.println("\nContains:");
			product.printInfo();
		}
	}
	
	
}
