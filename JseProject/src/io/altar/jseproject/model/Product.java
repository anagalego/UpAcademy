package io.altar.jseproject.model;

import java.util.ArrayList;
import java.util.List;
import io.altar.jseproject.repositories.ShelfRepository;

public class Product extends Entity {
	
	private List<Long> shelfIds; 
	private float tax;
	private float discount;
	
	
	public Product(String name, float tax, float price, float discount) {
		super(name, price);
		this.tax = tax;
		this.discount = discount;
		shelfIds = new ArrayList<>();
	}	
	
	public List<Long> getShelves() { return shelfIds; }	
	public void addToShelves(long... shelfIds) {	
		for(long id : shelfIds) {
			this.shelfIds.add(id);
			ShelfRepository.getInstance().getMap().get(id).setProduct(this);
		}
	}
	public void removeFromShelves(long... shelfIds) {
		for(long id : shelfIds) {
			this.shelfIds.remove(id);
			ShelfRepository.getInstance().getMap().get(id).setProduct(null);
		}
	}
	
	public float getTax() { return tax; }
	public void setTax(float tax) { this.tax = tax; }
	
	public float getDiscount() { return discount; }
	public void setDiscount(float discount) { this.discount = discount; }
	
	public void printInfo() {
		super.printInfo();
		System.out.print(tax + "%\t" + discount + "%\t" + shelfIds.size() + "\n");
		if(!shelfIds.isEmpty()) {
			printShelves();
		}
	}
	
	public void printShelves() {
		System.out.println("\nPRODUCT " + this.getId() + "in SHELF/S:");
		shelfIds.forEach(s -> ShelfRepository.getInstance().getEntity(s).printInfo());
	}

}
