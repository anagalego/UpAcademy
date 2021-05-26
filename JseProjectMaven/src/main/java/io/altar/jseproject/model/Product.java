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
	public void printShelves() {
		for(long id : this.shelfIds) {
			ShelfRepository.getInstance().getMap().get(id).printInfo();
		}
	}
	
	public float getTax() { return tax; }
	public void setTax(float tax) { this.tax = tax; }
	
	public float getDiscount() { return discount; }
	public void setDiscount(float discount) { this.discount = discount; }
	
	public void printInfo() {
		super.printInfo();
		System.out.print("€\t" + tax + "%\t" + discount + "%\t" + shelfIds.size());
		if(!shelfIds.isEmpty()) {
			System.out.println("Available in:");
			shelfIds.forEach(s -> ShelfRepository.getInstance().getEntity(s).printInfo());
		}
	}
	
	public void shelfList() {
		super.printInfo();
		System.out.print("€\t" + tax + "%\t" + discount);
	}

}
