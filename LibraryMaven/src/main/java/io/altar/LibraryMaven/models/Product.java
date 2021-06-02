package io.altar.LibraryMaven.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@NamedQueries({ 
	@NamedQuery(name = Product.GET_PRODUCTS, query = "SELECT p FROM Product p"),
	@NamedQuery(name = Product.GET_PRODUCTS_IDS, query = "SELECT p.id FROM Product p"),	
	@NamedQuery(name = Product.GET_PRODUCT_COUNT, query = "SELECT COUNT(p.id) FROM Product p"),
	@NamedQuery(name = Product.GET_PRODUCT_BY_ID, query = "SELECT p FROM Product p WHERE p.id = :id"),
	@NamedQuery(name = Product.GET_PRODUCT_NAMES, query = "SELECT DISTINCT p.name FROM Product p"),
	@NamedQuery(name = Product.GET_PRODUCTS_WITH_DISCOUNT, query = "SELECT p FROM Product p WHERE p.discount > 0"),
	@NamedQuery(name = Product.GET_PRODUCTS_WITH_DISCOUNT_X, query = "SELECT p FROM Product p WHERE p.discount = :value" ),
	@NamedQuery(name = Product.GET_PRODUCT_SALES, query = "SELECT SUM(p.price) FROM Product p"),

})
public class Product extends Entity_ {


	public static final String GET_PRODUCTS = "getAllProducts";
	public static final String GET_PRODUCTS_IDS = "getAllProductsIds";
	public static final String GET_PRODUCT_COUNT = "getProductCount";
	public static final String GET_PRODUCT_BY_ID = "getProductById";
	public static final String GET_PRODUCT_NAMES = "getProductNames";
	public static final String GET_PRODUCTS_WITH_DISCOUNT = "getProductsWithDiscount";
	public static final String GET_PRODUCTS_WITH_DISCOUNT_X = "getProductsWithDiscountX";
	public static final String GET_PRODUCT_SALES = "getProductSales";

	

	private static final long serialVersionUID = 1L;


	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnoreProperties("product")
	private List<Shelf> shelves;
	private int tax;
	private int discount;
	private float finalPrice;
	
	public Product() {}
	 
	
	public List<Shelf> getShelves() {
		return shelves;
	}
	public void setShelves(List<Shelf> shelves) {
		this.shelves = shelves;
	}

	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}

	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	public float getFinalPrice() {
		return finalPrice;
	}
	
	public void setFinalPrice() {
		this.finalPrice = (tax*getPrice()/100+getPrice())
				-(tax*getPrice()/100+getPrice())*discount/100;
	}

	
}
