package io.altar.LibraryMaven.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({ 
	@NamedQuery(name = Product.GET_PRODUCTS, query = "SELECT p FROM Product p"),
	@NamedQuery(name = Product.GET_PRODUCTS_IDS, query = "SELECT p.id FROM Product p"),	
	@NamedQuery(name = Product.GET_PRODUCT_COUNT, query = "SELECT COUNT(p.id) FROM Product p"),
})
public class Product extends Entity_ {


	public static final String GET_PRODUCTS = "getAllProducts";
	public static final String GET_PRODUCTS_IDS = "getAllProductsIds";
	public static final String GET_PRODUCT_COUNT = "getProductCount";

	private static final long serialVersionUID = 1L;


	
	//@Column(precision = 10, scale = 0, columnDefinition = "NUMBER (10)")
	private ArrayList<Long> shelfIds = new ArrayList<>();
	//@Column(precision = 10, scale = 0, columnDefinition = "NUMBER (10)")
	private int tax;
	//@Column(precision = 10, scale = 0, columnDefinition = "NUMBER (10)")	
	private float discount;
	private float finalPrice;
	
	public Product() {}
	 
	
	public ArrayList<Long> getShelfIds() {
		return shelfIds;
	}
	public void setShelfId(ArrayList<Long> shelfIds) {
		this.shelfIds = shelfIds;
	}

	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}

	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	public float getFinalPrice() {
		return finalPrice;
	}
	
	public void setFinalPrice() {
		float tempPrice = tax*super.getPrice()/100 + super.getPrice();
		float tempDiscount = tempPrice * discount;
		this.finalPrice = tempPrice - tempDiscount;
	}

	
}
