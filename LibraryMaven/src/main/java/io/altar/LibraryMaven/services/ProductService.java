package io.altar.LibraryMaven.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import io.altar.LibraryMaven.models.Product;
import io.altar.LibraryMaven.repositories.ProductRepository;


@RequestScoped
public class ProductService extends EntityService<ProductRepository, Product> {

	
	
	public List<String> getProductNames() {
		return repository.getProductNames();
	}
	
	public List<Product> getProductsWithDiscount() {
		return repository.getProductsWithDiscount();
	}
	
	public List<Product> getProductsWithDiscount(int value) {
		return repository.getProductsWithDiscount(value);
	}
	
	public double getProductSales() {		
		return repository.getProductSales();
	}
	
	public void clearShelves(long id) {
		Product p = repository.getEntity(id);
		p.getShelves().clear();
		repository.editEntity(p);
	}
}
