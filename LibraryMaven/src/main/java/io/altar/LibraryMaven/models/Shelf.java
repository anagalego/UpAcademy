package io.altar.LibraryMaven.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({ 
	@NamedQuery(name = Shelf.GET_SHELVES, query = "SELECT s FROM Shelf s"),
	@NamedQuery(name = Shelf.GET_SHELVES_IDS, query = "SELECT s.id FROM Shelf s"),	
	@NamedQuery(name = Shelf.GET_SHELF_COUNT, query = "SELECT COUNT(s.id) FROM Shelf s"),
	@NamedQuery(name = Shelf.GET_SHELF_BY_ID, query = "SELECT s FROM Shelf s WHERE s.id = :id"),
	@NamedQuery(name = Shelf.GET_EMPTY, query = "SELECT s FROM Shelf s WHERE s.product = null"),
	@NamedQuery(name = Shelf.GET_SHELVES_WITH_PRODUCT, query = "SELECT s FROM Shelf s WHERE s.product.id = :id"),
	@NamedQuery(name = Shelf.EMPTY_SHELF_BY_ID, query = "UPDATE Shelf s SET s.product = null WHERE s.id = :id"),
	@NamedQuery(name = Shelf.EMPTY_ALL_SHELVES, query = "UPDATE Shelf s SET s.product = null"),

})
public class Shelf extends Entity_ {	

	public static final String GET_SHELVES = "getAllShelves";
	public static final String GET_SHELVES_IDS = "getShelvesIds";
	public static final String GET_SHELF_COUNT = "getShelfCount";
	public static final String GET_SHELF_BY_ID = "getShelfById";
	public static final String GET_EMPTY = "getEmpty";
	public static final String GET_SHELVES_WITH_PRODUCT = "getShelvesWithProduct";
	public static final String EMPTY_SHELF_BY_ID = "emptyShelfById";
	public static final String EMPTY_ALL_SHELVES = "emptyAllShelves";
	



	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.ALL)
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
