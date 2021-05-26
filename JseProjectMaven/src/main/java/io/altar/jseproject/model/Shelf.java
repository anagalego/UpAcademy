package io.altar.jseproject.model;

public class Shelf extends Entity {
	
	private int capacity;
	private Product product;
	
	public Shelf(String name, int capacity, float price) {
		super(name, price);
		this.capacity = capacity;
	}
		
	public int getCapacity() { return capacity; }
	public void setCapacity(int capacity) { this.capacity = capacity; }

	public Product getProduct() { return product; }
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	public void printInfo() {
		super.printInfo();
		System.out.print("€\t" + capacity + "\n");
		if(product != null) {
			System.out.println("\nContains PRODUCT:");
			product.shelfList();
		}
	}
	
	
}
