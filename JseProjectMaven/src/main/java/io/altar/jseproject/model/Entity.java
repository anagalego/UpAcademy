package io.altar.jseproject.model;

public class Entity {

	private Long id;
	private String name;
	private float price;
	
	public Entity(String name, float price) {
		this.name = name;
		this.price = price;
	}
	
	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public float getPrice() { return price; }
	public void setPrice(float price) { this.price = price; }
	
	public void printInfo() {
		System.out.print(id + "\t" + name + "\t" + price);
	}
}
