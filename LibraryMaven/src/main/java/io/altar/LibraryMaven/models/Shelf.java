package io.altar.LibraryMaven.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({ 
	@NamedQuery(name = Shelf.GET_SHELVES, query = "SELECT s FROM Shelf s"),
	@NamedQuery(name = Shelf.GET_SHELVES_IDS, query = "SELECT s.id FROM Shelf s"),	
	@NamedQuery(name = Shelf.GET_SHELF_COUNT, query = "SELECT COUNT(s.id) FROM Shelf s"),
})
public class Shelf extends Entity_ {	

	public static final String GET_SHELVES = "getAllShelves";
	public static final String GET_SHELVES_IDS = "getShelvesIds";
	public static final String GET_SHELF_COUNT = "getShelfCount";

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Product product;
	private int capacity;

	
	public Shelf() {}

	
	public int getCapacity() { return capacity; }
	public void setCapacity(int capacity) { this.capacity = capacity; }

	public Product getProduct() { return product; }
	public void setProduct(Product product) {
		this.product = product;
	}
}
